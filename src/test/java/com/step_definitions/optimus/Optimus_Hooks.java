package com.step_definitions.optimus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.common.helpers.BrowserHelper;
import com.common.helpers.Utils;
import com.common.hooks.Hooks;
import com.common.page_objects.Optimus_Generic_LocatorLibrary;
import com.common.page_objects.OLD_Generic_LocatorLibrary;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Optimus_Hooks extends Hooks {

	private static boolean beforeAllHookExecuted = false;
	private static boolean dbExtendedEventsRequired = false;


	public Optimus_Hooks() {
//		super();
		
		System.out.println("In Optimus_Hooks constructor");
		
		applicationName = "OPTIMUS";
		
	}


	
	@Before (order=1)
	public void beforeScenarioHook(Scenario scenario) {
		
		testName = scenario.getName();
		
		setupBrowserDriver();

		
		if(connectToDatabase) {
			Boolean dbConnectSuccess = false;
			// If running in docker attempt DB connect more than once due to docker db start issues
			if(Utils.getProperty("PLATFORM").equals("DOCKER")) {
				for(int i=1; i<=5; i++) {
					dbConnectSuccess = createDBConnectionJDBC();
					if(dbConnectSuccess)
						break;
					else
						BrowserHelper.customSleep(10 * 1000);
				}
				
			} else {
				dbConnectSuccess = createDBConnectionJDBC();
			}
			
			if(!dbConnectSuccess)
				reporterHelper.customFailScript("Unable to connect to DB");
				
		}

		instantiateHelpers();

		if(connectToDatabase)
			tidyDB();

        if(Boolean.parseBoolean(Utils.getProperty("PERFORM_HTTP_CHECKS"))) {
        	
        	reporterHelper.log("Performing HTTP Checks as PERFORM_HTTP_CHECKS set to true...");
        	
        	if(!beforeAllHookExecuted) {
        		reporterHelper.log("...First Scenario, therefore calling performHttpRequestCheck for user: DEFAULT_ADMINISTRATOR");
        		performHttpRequestCheck("DEFAULT_ADMINISTRATOR");
        	}
        	else {
        		String tempPersonasList = Utils.getProperty("PERSONAS_TO_CREATE");
        		String firstPersonaCreated;
        		
        		if(tempPersonasList.contains(","))
        			firstPersonaCreated = tempPersonasList.split(",")[0];
    			else
    				firstPersonaCreated = tempPersonasList;
        			
        		reporterHelper.log("...Not the first scenario, therefore calling performHttpRequestCheck for the first persona that was created on startup: " + firstPersonaCreated);
        		performHttpRequestCheck(firstPersonaCreated);
        	}
        }
        else
        	reporterHelper.log("Skipping http checks as PERFORM_HTTP_CHECKS is set to false in config");
		
        // setup locator library
        
//        reporterHelper.log("Setting up kalibrateLocatorLibrary for application version: " + Hooks.applicationVersionSimplified);
        
//		switch(Hooks.applicationVersionSimplified) {
//    	case "2.4.1":
//    		kalibrateLocatorLibrary = new Kalibrate_241_LocatorLibrary();
//			break;
//    	case "2.8": case "2.9":
//    		kalibrateLocatorLibrary = new Kalibrate_28_LocatorLibrary();
//			break;
//    	case "2.10":
//    		kalibrateLocatorLibrary = new Kalibrate_210_LocatorLibrary();
//			break;
//    	default :
//    		System.out.println("Unsupported version as derived from pninstalllog: " + Hooks.applicationVersionSimplified);
//    		Assert.fail("Unsupported version as derived from pninstalllog: " + Hooks.applicationVersionSimplified);
//    	}
        
        OLDLocatorLibrary = new OLD_Generic_LocatorLibrary();
        optimusLocatorLibrary = new Optimus_Generic_LocatorLibrary();
        
		
		launchApplication();
		
		reporterHelper.log("Scenario Tags:" + scenario.getSourceTagNames().toString());
		


	}

	
	// The following is used as a workaround to have a Global beforeAll and afterAll Hook
	// as global hooks are not supported by cucumber
	
	@Before (order=2) // note order defines order hooks will run with lowest number first
    public void beforeAll() {
        if(!beforeAllHookExecuted) {
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    reporterHelper.log("afterAll hook executed");
                	if(dbExtendedEventsRequired)
                		databaseHelper.createDBConnectionAndExecuteSQLStringNoResultSet("ALTER EVENT SESSION [User_SQLDeadlocks] ON SERVER STATE = STOP;");
                }
            });
            reporterHelper.log("beforeAll hook executed");

            // TODO - Add check of config item CONNECT_TO_DATABASE also 
            if(dbExtendedEventsRequired = Boolean.parseBoolean(Utils.getProperty("EXECUTE_DB_ENTENDED_EVENTS"))) 
            		databaseHelper.createDBConnectionAndExecuteSQLStringNoResultSet("ALTER EVENT SESSION [User_SQLDeadlocks] ON SERVER STATE = START;");
            
            beforeAllHookExecuted = true;
            
            if(Boolean.parseBoolean(Utils.getProperty("PERFORM_HTTP_CHECKS"))) 
            	performHttpRequestCheck("DEFAULT_ADMINISTRATOR");
            else
            	reporterHelper.log("Skipping http checks as PERFORM_HTTP_CHECKS is set to false in config");
            	
        	if(Boolean.parseBoolean(Utils.getProperty("CREATE_PERSONA_USERS_VIA_API")))	
        		deleteThenAddNewUsersViaHttpRequest();
    		else
    			reporterHelper.log("Skipping creating user via api as CREATE_PERSONA_USERS_VIA_API is set to false in config.");
            
//    		reporterHelper.postProcessTimingsFile();
//    		reporterHelper.processTimingsFile(true);
    		
    		if(connectToDatabase)
    			tidyDB();
    		
    		
            // Schedule Start
            String scheduledStartDate = Utils.getProperty("SCHEDULED_START_DATE");
            String scheduledStartTime = Utils.getProperty("SCHEDULED_START_TIME");

            // Only schedule if a SCHEDULED_START_TIME is defined in config 
            if(scheduledStartTime != null) {
	            if(scheduledStartDate == null) {
	            	// derive date from current date, in the desired format
	                scheduledStartDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	                reporterHelper.log("%%%%% SCHEDULED_START_DATE in config file is empty therefore using today's date: " + scheduledStartDate);
	            }
	            	
	            
	            SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	
	            try {
	    
	                Date newdate = dateformat2.parse(scheduledStartDate + " " + scheduledStartTime);
	    
	                reporterHelper.log("%%%%% Waiting until scheduled start dateTime: " + newdate);
	                
	                BrowserHelper.waitUntil(newdate);
	    
	            } catch (ParseException e) {
	    
	                e.printStackTrace();
	    
	            }
            } else
            	reporterHelper.log("%%%%% SCHEDULED_START_DATE not defined in config file therefore starting script immediately");
        }
    }

	
	@After (order=1)
	public void afterScenarioCloseOptimus() {
		
		reporterHelper.log("\nIn @After hook method afterScenarioCloseOptimus(), closing Optimus if necessary;");
		
		// If Optimus is still logged in...
		
		reporterHelper.log("\tChecking if browser is still open...");
		
		if(!driver.toString().contains("null"))
		{

			reporterHelper.log("\tBrowser is still open.  Checking if logged in...");
	

			if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.noddle_home_main_Header_1)) {
				reporterHelper.log("\tOptimus home page indetified, no need to logout");
			}
			else if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.noddle_generic_header_LogOut_Button)) {
				
				// Logout 
		        BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.noddle_generic_header_LogOut_Button, "present").click();
		        BrowserHelper.customSleep(1 * 1000);

				
			} else {
				reporterHelper.error("\n\tOptimus home page not displayed but unable to identify state to enable logout");
			}
			
			BrowserHelper.checkForConsoleErrors();
		        
			driver.close();
			driver.quit();
		}
		
		// Kill any chromedriver processes in memory
		reporterHelper.runSystemCommand("taskkill /im chromedriver.exe /f");
		
		
        // Check if SCHEDULED_STOP_TIME has elapsed and stop if need be
		String scheduledStopDate = Utils.getProperty("SCHEDULED_STOP_DATE");
        String scheduledStopTime = Utils.getProperty("SCHEDULED_STOP_TIME");

        // Only consider stopping script if a SCHEDULED_STOP_TIME is defined in config 
        if(scheduledStopTime != null) {
        	
            if(scheduledStopDate == null) {
            	// derive date from current date, in the desired format
            	scheduledStopDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            	System.out.println("%%%%% scheduledStopDate in config file is empty therefore using today's date: " + scheduledStopDate);
            }

            SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        	
            Date stopDateTime = null;
    
    	    
			try {
				stopDateTime = dateformat2.parse(scheduledStopDate + " " + scheduledStopTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    
    	    // Determine if the time has already passed, if it has
    	    // we need to roll the date to the next day...
    	    if (stopDateTime.before(new Date())) {
    	    	reporterHelper.log("Terminating Script as scheduled Stop Time elapsed: " + stopDateTime);
    	    	System.exit(0);
    	    } else
    	    	reporterHelper.log("Scheduled Stop Time has not elapsed: " + stopDateTime);    	    	
        } else
        	reporterHelper.log("%%%%% SCHEDULED_STOP_TIME not defined in config therefore not forcing test termination");
        	    

	}

	
	
	@After(order=2)
	public void afterScenarioCloseObjects() {
	
		reporterHelper.log("\nIn @After hook method afterScenarioCloseObjects(), closing down objects/connections where necessary;");

		// Tidy Database
		if(connectToDatabase) {
			
//			reporterHelper.processTimingsFile(false);
			
			tidyDB();
		}
		
		// Close SQL DB Objects
        try {
            if (dbResultSet != null) {
            	reporterHelper.log("\n\tSQL DB ResultSet still active, closing ResultSet");
            	dbResultSet.close();
            }
        } catch (Exception ignore) {}
        
        try {
            if (dbStatement != null) {
            	reporterHelper.log("\n\tSQL DB Statement still active, closing Statement");
            	dbStatement.close();
            }
        } catch (Exception ignore) {}
        
        try {
    		if (dbConn != null) {
    			reporterHelper.log("\n\tSQL DB Connection still active, closing connection");
    			dbConn.close();
    		}
        } catch (Exception ignore) {}
        
        try {
			// Close driver if it has not been closed already
//			if ( !(((RemoteWebDriver)driver).getSessionId() == null)) {
			if ( !(driver.toString().contains("null")) ) {	
				reporterHelper.log("\n\tBrowser driver still active, closing browser");
				driver.close();
				driver.quit();
			}
        } catch (Exception ignore) {}
		
		
		
		reporterHelper.setOutputFolderPassStatus();
		
		// Save test output files to report folder
		reporterHelper.saveTestOutputFiles();
		
		// Save updateable config file
//		saveUpdatableConfig();
	}


}