package com.step_definitions.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.common.helpers.BrowserHelper;
import com.common.helpers.Utils;
import com.common.hooks.Hooks;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Api_Hooks extends Hooks {

	private static boolean beforeAllHookExecuted = false;


	public Api_Hooks() {
		
		System.out.println("In Api_Hooks constructor");
		
		applicationName = "KALIBRATE";
		// TODO
//		switch(Hooks.applicationVersionSimplified) {
//    	case "2.4.1":
//    		apiEndpointLibrary = new 241_EndpointLibrary();
//			break;
//    	case "2.8": case "2.9":
//    		apiEndpointLibrary = new 28_EndpointLibrary();
//			break;
//    	default :
//    		System.out.println("Unsupported version as defined in config file APPLICATION_VERSION: " + Hooks.applicationVersionSimplified);
//    		Assert.fail("Unsupported version as defined in config file APPLICATION_VERSION: " + Hooks.applicationVersionSimplified);
//    	}
		
	}


	
	@Before (order=1)
	public void beforeScenarioHook(Scenario scenario) {
		
		testName = scenario.getName();
		
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

                }
            });
            reporterHelper.log("beforeAll hook executed");
            
            beforeAllHookExecuted = true;
            
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

	
	@After(order=2)
	public void afterScenarioCloseObjects() {
	
		reporterHelper.log("\nIn @After hook method afterScenarioCloseObjects(), closing down objects/connections where necessary;");

		
		reporterHelper.setOutputFolderPassStatus();
		
		// Save test output files to report folder
		reporterHelper.saveTestOutputFiles();
		
	}


}