package com.common.helpers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.common.hooks.Hooks;
import com.google.common.io.Files;

import io.appium.java_client.AppiumDriver;

public class ReporterHelper {
	
	private static int screenshotCount;

	private String screenshotDirectoryPath;
	private String testRunOutputPath;
	
	private StopWatch tempStopWatch;
	
	private ArrayList< String > listOfReportEntries = new ArrayList< String >();

	private Hooks hooks;

	private String timingsHeaderRow;
	private String timingsOutputBuffer="";
	
	private SimpleDateFormat dateFormat, dateFormat2, dateFormat3;
	
	private String scriptPassStatus = "PASSED";
	
	private Map<String, StopWatch> timersMap;

	private String browserExecutableName;
	
	private String earliestDateTimeStamp = null;
	private String latestDateTimeStamp = null;
	
	private long timerStartTime = 0;
	private long timerEndTime = 0;
	
	private String applicationNameExtended;
	
//	private DatabaseHelper databaseHelper = hooks.databaseHelper;
	
	public ReporterHelper(Hooks hooks) {	
		
		this.hooks = hooks;
		
		
		timersMap = new HashMap<String, StopWatch>(); 
		
		// Set file name using current date and time
		dateFormat = new SimpleDateFormat("yyyy-MM-dd kkmmss");
		dateFormat2 = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss,SSS");
		dateFormat3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		

		
		testRunOutputPath = "/" + System.getenv("COMPUTERNAME")
				+ "/" + Hooks.applicationName  
				+ "/" + dateFormat.format(new Date()) + "_" + Hooks.applicationName + "_" + Hooks.browserName + "_" + Hooks.testName.replace(' ', '-');

		screenshotDirectoryPath = Utils.getProperty("OUTPUT_DEFAULT_PATH") + testRunOutputPath;
		
		log("\n\n\n**** Creating Ouput Directory: " + screenshotDirectoryPath + "\n\n\n");
		
		// Create folder under project 
		new File(screenshotDirectoryPath).mkdirs();
		
		timingsHeaderRow = "MACHINE_NAME,"
							+ "BROWSER,"
							+ "APPLICATION,"
							+ "GRID_NODE,"
							+ "APPLICATION_URL,"
							+ "TEST_NAME,"
							+ "TIMER_NAME,"
							+ "SITE,"
							+ "DATETIME_STAMP,"
							+ "DURATION,"
							+ "NEW_TIMER_START,"
							+ "NEW_TIMER_END,"
							+ "NEW_TIMER_DURATION,"
							+ "SITES_IN_PRICEGEN_COUNT,"
							+ "BROWSER_MEM,"
							+ "ECLIPSE_MEM";

		// Copy config.properties to the created output folder
		try {
			String configFilePath = System.getenv("CONFIG_PROPERTIES_FILE");
			if (StringUtils.trimToNull(configFilePath) == null) {
				configFilePath = System.getProperty("user.dir")+"/config.properties";
			}
			else configFilePath = System.getProperty("user.dir")+"/" + configFilePath;
			File configFileInput = new File(configFilePath);
			File configFileOutput = new File(screenshotDirectoryPath+"/config.properties");
			FileUtils.copyFile(configFileInput, configFileOutput);
			
		} catch (Exception e) {
			customFailScript("Exception caught copying config file: " + e.toString());
		}

		// define name of browser executable to be used for memory check
		switch(Utils.getProperty("BROWSER_NAME").toUpperCase()) {
    	case "CHROME":
    		browserExecutableName = "chrome.exe";
			break;
    	case "FIREFOX":
    		browserExecutableName = "firefox.exe";
			break;
    	default:
    		customFailScript("Unknown BROWSER_NAME when attempting to define browser executable name for memory checker: " + Utils.getProperty("BROWSER_NAME"));
		}
	}

	public void initialise() {
        
        String ownSiteCount = "";
        String dbNameCapitalised = "";
        String dbInstanceCapitalised = "";
        String appVersion = "";
        
//        if(Boolean.parseBoolean(Utils.getProperty("CONNECT_TO_DATABASE"))) {
//			try {
//		        ResultSet sqlDbResultSet = hooks.databaseHelper.executeSQLStringWithResultSet("SELECT count(*) FROM [prc].[OwnSite]");
//		        ResultSet sqlDbResultSet2 = hooks.databaseHelper.executeSQLStringWithResultSet("SELECT DB_NAME()");
//		        ResultSet sqlDbResultSet3 = hooks.databaseHelper.executeSQLStringWithResultSet("SELECT CONVERT(sysname, SERVERPROPERTY('servername'))");
//		        ResultSet sqlDbResultSet4 = hooks.databaseHelper.executeSQLStringWithResultSet("SELECT Version FROM pninstalllog WHERE InstallLogID = ( SELECT MAX(InstallLogID) FROM pninstalllog )");
//	
//				sqlDbResultSet.first();
//				ownSiteCount = sqlDbResultSet.getString(1);
//				
//				sqlDbResultSet2.first();
//				dbNameCapitalised = sqlDbResultSet2.getString(1).toUpperCase();;
//				
//				sqlDbResultSet3.first();
//				dbInstanceCapitalised = sqlDbResultSet3.getString(1).toUpperCase();
//	
//				sqlDbResultSet4.first();
//				Hooks.applicationVersion = sqlDbResultSet4.getString(1);
//				Hooks.applicationVersionSimplified = Hooks.applicationVersion.split("\\.")[0] + "." + Hooks.applicationVersion.split("\\.")[1];
//	            
//				
//			} catch (Exception e) {
//	        	customFailScript("Exception caught: " + e.toString());
//			}
//        }
//
//		log("ownSiteCount: " + ownSiteCount);
//		log("dbNameCapitalised: " + dbNameCapitalised);
//		log("dbInstanceCapitalised: " + dbInstanceCapitalised);
//		log("appVersion: " + Hooks.applicationVersion);
//		log("applicationVersionSimplified: " + Hooks.applicationVersionSimplified);
		
		applicationNameExtended = dbNameCapitalised + "_" + appVersion + "_" + dbInstanceCapitalised + "_" + ownSiteCount;

	}
	public void takeScreenshot(AppiumDriver driver, String screenDescription) {		
		
		String tempFileName = null;
		String screenshotFullPath = null;
		
		if(Boolean.parseBoolean(Utils.getProperty("TAKE_SCREENSHOTS"))) {
			
			screenshotCount++;
			
			BrowserHelper.customSleep(Integer.parseInt(Utils.getProperty("SCREENSHOT_WAIT_TIME")));
			
			tempFileName = "PORTRAIT-" + String.format("%03d", screenshotCount) + "-" + screenDescription + ".png";
			screenshotFullPath = screenshotDirectoryPath + "/" + tempFileName;
			
			try {
				// Capture screenshot.
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				// Copy paste file at destination folder location
				FileUtils.copyFile(scrFile, new File(screenshotFullPath));
			
				log("\nSaved PORTRAIT screenshot: " + screenshotFullPath);
				listOfReportEntries.add("<img src=\"./" + tempFileName + "\"  width=\"50%\" height=\"50%\">");
			} catch (IOException e) {
				customFailScript("Exception2 caught: " + e.toString());
			}

			

			
			if(Boolean.parseBoolean(Utils.getProperty("SCREENSHOT_MULTIPLE_ORIENTATIONS"))) {
	
				((Rotatable)driver).rotate(ScreenOrientation.LANDSCAPE);
				
				tempFileName = "LANDSCAPE-" + String.format("%03d", screenshotCount) + "-" + screenDescription + ".png";
				screenshotFullPath = screenshotDirectoryPath + "/" + tempFileName;
				
				try {
					BrowserHelper.customSleep(2 * 1000);

					// Capture screenshot
					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
					// Copy file to destination folder location
					FileUtils.copyFile(scrFile, new File(screenshotFullPath));

		
					log("Saved LANDSCAPE screenshot: " + screenshotFullPath);
					
					listOfReportEntries.add("<img src=\"./" + tempFileName + "\"  width=\"50%\" height=\"50%\">");
					
					((Rotatable)driver).rotate(ScreenOrientation.PORTRAIT);

				} catch (Exception e) {
					customFailScript("Exception3 caught: " + e.toString());
				}
				
			}
			
			
		}
		
		
	}

	public String takeScreenshot(WebDriver driver, String screenDescription) {
		
		String tempFileName = null;
		String screenshotFullPath = null;
		
		screenDescription = screenDescription.replaceAll(" ", "_");
		
		if(Boolean.parseBoolean(Utils.getProperty("TAKE_SCREENSHOTS"))) {
			
			screenshotCount++;
			
			try {
				BrowserHelper.customSleep(Integer.parseInt(Utils.getProperty("SCREENSHOT_WAIT_TIME")));
				
				tempFileName = String.format("%03d", screenshotCount) + "-" + screenDescription + ".png";
				

				
				screenshotFullPath = screenshotDirectoryPath + "/" + tempFileName;

				log("Saving screeshot to screenshotFullPath: " + screenshotFullPath);
				
				// Capture screenshot
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				// Copy file to destination folder location
				FileUtils.copyFile(scrFile, new File(screenshotFullPath));
			
				log("\nSaved screenshot: " + screenshotFullPath);
				
			} catch (Exception e) {
				customFailScript("Exception4 caught: " + e.toString());
			}
				
		}
		
		listOfReportEntries.add("<img src=\"./" + tempFileName + "\"  width=\"50%\" height=\"50%\">");
		return screenshotFullPath;
	}
	
	
	public void customFailScript(String failMessage) {
		
		log("In customFailScript method");
		
		if(Boolean.parseBoolean(Utils.getProperty("PERFORM_HTTP_CHECKS"))) {
			log("In customFailScript method: performing http check as PERFORM_HTTP_CHECKS set to true");
			if(Utils.getProperty("PERSONAS_TO_CREATE").contains(","))
				Hooks.performHttpRequestCheck(Utils.getProperty("PERSONAS_TO_CREATE").split(",")[0]);
			else
				Hooks.performHttpRequestCheck(Utils.getProperty("PERSONAS_TO_CREATE"));
		}
        else
        	log("Skipping http checks as PERFORM_HTTP_CHECKS is set to false in config");

		setPassStatus("FAILED");
		error("\nAssertion failure exception caught: " + failMessage);

	
		if(Hooks.driver != null) {

			if(Hooks.driver.toString().contains("null"))
				error("Unable to take error screenshot as browser no longer open.");
			else 
				takeScreenshot(Hooks.driver, "General-Failed_Exit_Screen");
		}

		Assert.fail(failMessage);
	}

	
	public void customFailScriptNoHttpCheck(String failMessage) {
		
		setPassStatus("FAILED");
		error("\nAssertion failure exception caught: " + failMessage);

	
		if(Hooks.driver != null) {

			if(Hooks.driver.toString().contains("null"))
				error("Unable to take error screenshot as browser no longer open.");
			else 
				takeScreenshot(Hooks.driver, "General-Failed_Exit_Screen");
		}

		Assert.fail(failMessage);
	}
	
	public void setOutputFolderPassStatus() {
		if(Boolean.parseBoolean(Utils.getProperty("TAKE_SCREENSHOTS"))) {
				
			String oldDirectoryPath = screenshotDirectoryPath;
			String newDirectoryPath = screenshotDirectoryPath + "_" + scriptPassStatus;
			
			File dir = new File(oldDirectoryPath);
			boolean success = true;
			
			log("\nSetting Test Pass Status to " + scriptPassStatus);
			
			if (!dir.isDirectory()) {
				System.err.println("\nThere is no directory @ given path: " + dir.getPath());
				success = false;
				System.exit(0);
			}
			else {
				log("\tRenaming Directory \n\t\t" + oldDirectoryPath + "\n\tto \n\t\t" + newDirectoryPath);
				File newDir = new File(newDirectoryPath);
				success = dir.renameTo(newDir);
			}
			
			log("\tDirectory rename successful\n");
			
			if(!success) {
				customFailScript("Directory " + oldDirectoryPath + " could not be renamed to " + newDirectoryPath + ". There is no directory @ given path");
			}
			
			screenshotDirectoryPath = newDirectoryPath;
		}	
	}
	
	public void setPassStatus(String status) {
		scriptPassStatus = status;
	}
	

	public void startTimer(String timerName) {
		timerStartTime = System.currentTimeMillis();
		
		tempStopWatch = new StopWatch();
		log("\n Timer starting: '" + timerName + "'");
		
		timersMap.put(timerName, tempStopWatch);
		log(timersMap.size() + " timers in timersMap: " + timersMap);
		tempStopWatch.start();
	}
	
	public void stopTimer(String timerName) {
		
		timerEndTime = System.currentTimeMillis();
		long timerDifference = timerEndTime - timerStartTime;
		log("timerDifference:" + timerDifference);
		tempStopWatch = (StopWatch) timersMap.get(timerName);
		
		try {
			tempStopWatch.stop();
		} 
		catch (NullPointerException e) {
			error("\n An attempt was made to stop Timer '" + timerName + "', however no Timer found with that name\n\n\t current timers running: " + timersMap);
			return;
		}
		catch (Exception e) {
			error("\n An attempt was made to stop Timer '" + timerName + "', however exception caught: " + e);
			error(timersMap.size() + " timers in timersMap: " + timersMap);
			return;
		}
		
		String tempDateTimeStamp = dateFormat3.format(new Date());
		
		if(earliestDateTimeStamp == null)
			earliestDateTimeStamp = new String(tempDateTimeStamp);
		
		latestDateTimeStamp = tempDateTimeStamp;
		
		log("\n Timer stopped: '" + timerName + "' - " + tempStopWatch.getTime() + " milliseconds\n");
		
		timingsOutputBuffer += "\n" 
							+ System.getenv("COMPUTERNAME") + ","
							+ Hooks.browserName + ","
							+ applicationNameExtended + ","
							+ hooks.gridNodeURL + ","
							+ hooks.applicationURL + ","
							+ Hooks.testName + ","
							+ timerName + ","
							+ ","
//							+ dateFormat3.format(new Date()) + ","
//							+ tempStopWatch.getTime() + ","
							+ dateFormat3.format(timerStartTime) + ","
							+ dateFormat3.format(timerEndTime) + ","
							+ timerDifference + ","
//							+ productsInPriceGenCount + ","
//							+ runSystemCommand(Utils.getProperty("AUTOMATION_RESOURCES_DIRECTORY_PATH") + "\\MemoryChecker\\check_memory_usage.bat "+ browserExecutableName) + ","
//							+ runSystemCommand(Utils.getProperty("AUTOMATION_RESOURCES_DIRECTORY_PATH") + "\\MemoryChecker\\check_memory_usage.bat eclipse.exe")
							;
		


		log(timingsOutputBuffer);

	}
	
	public void stopTimer(String timerName, String widgetName) {
		
		timerEndTime = System.currentTimeMillis();
		long timerDifference = timerEndTime - timerStartTime;
		log("timerDifference:" + timerDifference);
		tempStopWatch = (StopWatch) timersMap.get(timerName);
		
		widgetName = widgetName.replace(",", "<comma>");
		
		try {
			tempStopWatch.stop();
		} 
		catch (NullPointerException e) {
			error("\n An attempt was made to stop Timer '" + timerName + "', however no Timer found with that name\n\n\t current timers running: " + timersMap);
			return;
		}
		catch (Exception e) {
			error("\n An attempt was made to stop Timer '" + timerName + "', however exception caught: " + e);
			error(timersMap.size() + " timers in timersMap: " + timersMap);
			return;
		}
		
		// Start of Get Products In ProceGen Count
		String productsInPriceGenCount = "";
			try {
		        ResultSet sqlDbResultSet = hooks.databaseHelper.executeSQLStringWithResultSet("SELECT	COUNT(DISTINCT opg.OwnSiteUID) SitesWithPriceRequestsToProcess " + 
		        		"FROM		dbo.PNPriceRequest				req " + 
		        		"JOIN		dbo.PNOwnProductGroup			opg " + 
		        		"ON			req.OwnProductGroupUID =		opg.OwnProductGroupUID " + 
		        		"WHERE		req.Processed =					0 " + 
		        		"AND			req.OnHold =					0 " + 
		        		"AND			req.Cancelled =					0 ;");
		
		        sqlDbResultSet.first();
		        productsInPriceGenCount = sqlDbResultSet.getString(1);
		        
		        log("%%%% productsInPriceGen %%%%: " + productsInPriceGenCount);
				
			} catch (Exception e) {
	        	log("Exception caught: " + e.toString());
			}
		// End of Get Products In ProceGen Count
			
			
		String tempDateTimeStamp = dateFormat3.format(new Date());
		
		if(earliestDateTimeStamp == null)
			earliestDateTimeStamp = new String(tempDateTimeStamp);
		
		latestDateTimeStamp = tempDateTimeStamp;
		
		log("\n Timer: " + timerName + ": " + tempStopWatch.getTime() + " milliseconds\n");
		
		timingsOutputBuffer += "\n" 
							+ System.getenv("COMPUTERNAME") + ","
							+ Hooks.browserName + ","
							+ applicationNameExtended + ","
							+ hooks.gridNodeURL + ","
							+ hooks.applicationURL + ","
							+ Hooks.testName + ","
							+ timerName + ","
							+ widgetName + ","
							+ latestDateTimeStamp + ","
							+ tempStopWatch.getTime() + ","
							+ dateFormat3.format(timerStartTime) + ","
							+ dateFormat3.format(timerEndTime) + ","
							+ timerDifference + ","
							+ productsInPriceGenCount + ","
							+ runSystemCommand(Utils.getProperty("AUTOMATION_RESOURCES_DIRECTORY_PATH") + "\\MemoryChecker\\check_memory_usage.bat "+ browserExecutableName) + ","
							+ runSystemCommand(Utils.getProperty("AUTOMATION_RESOURCES_DIRECTORY_PATH") + "\\MemoryChecker\\check_memory_usage.bat eclipse.exe");


		log(timingsOutputBuffer);

	}	
	
	public void log(String logString) {
		
		listOfReportEntries.add("<p>" + dateFormat3.format(new Date()) + " [INFO] " + logString + "</p>\n" );
		
		if(Boolean.parseBoolean(Utils.getProperty("DEBUG_OUTPUT"))) System.out.println(logString);

	}

	public void error(String errString) {
		
		listOfReportEntries.add("<p style='color:red'>"  + dateFormat3.format(new Date()) + " [ERROR] " + errString + "</p>\n" );

		if(Boolean.parseBoolean(Utils.getProperty("DEBUG_OUTPUT"))) System.err.println(errString);
		
	}

	public void postProcessTimingsFile() {
        String line = "";
        String cvsSplitBy = ",";
        String currentRowTimestamp = "";
        int rowCount = 0;
        
		try (BufferedReader br = new BufferedReader(new FileReader(Utils.getProperty("OUTPUT_DEFAULT_PATH") + "/" + System.getenv("COMPUTERNAME") + "/allTimings.csv"))) {

			// Skip Header Row
			br.readLine();
			
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] timingColumnsSplit = line.split(cvsSplitBy);
                currentRowTimestamp = timingColumnsSplit[8];
                
                log("Current Timer Timestamp: " + currentRowTimestamp);

                currentRowTimestamp = currentRowTimestamp.split("\\+")[0];
                currentRowTimestamp = "2018-04-05T08:46:58.604";
                
                String tempSQLString = "SELECT * FROM [cmn].[ETLTransferHistoryDetail] "
                		+ "WHERE StartTime <= CONVERT(Datetime2,'" + currentRowTimestamp + "') "
        				+ "AND EndTime >= CONVERT(Datetime2,'" + currentRowTimestamp + "') "
						+ "AND (RowsInserted > 0 OR RowsUpdated > 0 OR RowsDeleted > 0 OR DurationSeconds > 0 or DurationMinutes > 0)";
                
                
                
                ResultSet sqlDbResultSet;
                
    			try {
    				sqlDbResultSet = hooks.databaseHelper.executeSQLStringWithResultSet(tempSQLString);
    				
    				if(sqlDbResultSet.last()){
    				    rowCount = sqlDbResultSet.getRow(); 
    				    sqlDbResultSet.beforeFirst();
    				}
    			} catch (Exception e) {
    	        	customFailScript("Exception caught: " + e.toString());
    			}
    			
    			log("Number of ETL Steps running when timer was recorded: " + rowCount + "\n");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void processTimingsFile(boolean testWithDummyData) {
		
		if(testWithDummyData) {
			// Start of setup data for testing method
			timingsOutputBuffer = "SPDWAYAUTOTEST1,CHROME,KALIBRATE_SPEEDWAY_2.9,NA,http://weu-speedway291.kalibratetech.com,Process Sites For Review End To End Scenario 01_01,Launch Application: KALIBRATE_SPEEDWAY_2.9,,2018-04-12T06:19:53.607+0000,2018-04-12T06:19:53.607+0000,2967,2018-04-12T06:19:53.607+0000,2967,281544,525324\r\n" + 
					"SPDWAYAUTOTEST1,CHROME,KALIBRATE_SPEEDWAY_2.9,NA,http://weu-speedway291.kalibratetech.com,Process Sites For Review End To End Scenario 01_01,Login Empty Workspace,,2018-04-12T06:19:56.615+0000,2018-04-12T06:19:56.615+0000,915,2018-04-12T06:19:56.615+0000,915,309152,525428\r\n" + 
					"SPDWAYAUTOTEST1,CHROME,KALIBRATE_SPEEDWAY_2.9,NA,http://weu-speedway291.kalibratetech.com,Process Sites For Review End To End Scenario 01_01,Search widget search initiated with Product filter,,2018-04-12T06:19:56.659+0000,2018-04-12T06:19:56.659+0000,556,2018-04-12T06:19:56.659+0000,556,332668,525584\r\n" + 
					"SPDWAYAUTOTEST1,CHROME,KALIBRATE_SPEEDWAY_2.9,NA,http://weu-speedway291.kalibratetech.com,Process Sites For Review End To End Scenario 01_01,Launch Application: KALIBRATE_SPEEDWAY_2.9,,2018-04-12T06:19:56.660+0000,2018-04-12T06:19:56.660+0000,2046,2018-04-12T06:19:56.660+0000,2046,277632,520952\r\n" + 
					"SPDWAYAUTOTEST1,CHROME,KALIBRATE_SPEEDWAY_2.9,NA,http://weu-speedway291.kalibratetech.com,Process Sites For Review End To End Scenario 01_01,Launch Application: KALIBRATE_SPEEDWAY_2.9,,2018-04-12T06:19:56.661+0000,2018-04-12T06:19:56.661+0000,2624,2018-04-12T06:19:56.661+0000,2624,281300,498696\r\n" + 
					"SPDWAYAUTOTEST1,CHROME,KALIBRATE_SPEEDWAY_2.9,NA,http://weu-speedway291.kalibratetech.com,Process Sites For Review End To End Scenario 01_01,Login Empty Workspace,,2018-04-12T06:19:56.677+0000,2018-04-12T06:19:56.677+0000,865,2018-04-12T06:19:56.677+0000,865,307408,498732\r\n" + 
					"SPDWAYAUTOTEST1,CHROME,KALIBRATE_SPEEDWAY_2.9,NA,http://weu-speedway291.kalibratetech.com,Process Sites For Review End To End Scenario 01_01,Search widget search initiated with Product filter,,2018-04-12T06:19:56.678+0000,2018-04-12T06:19:56.678+0000,575,2018-04-12T06:19:56.678+0000,575,340464,500804\r\n" + 
					"SPDWAYAUTOTEST1,CHROME,KALIBRATE_SPEEDWAY_2.9,NA,http://weu-speedway291.kalibratetech.com,Process Sites For Review End To End Scenario 01_01,Click Generate Prices button in Multi Pricing Widget,,2018-04-12T06:20:02.037+0000,2018-04-12T06:20:02.037+0000,909,2018-04-12T06:20:02.037+0000,909,521460,494024\r\n" + 
					"SPDWAYAUTOTEST1,CHROME,KALIBRATE_SPEEDWAY_2.9,NA,http://weu-speedway291.kalibratetech.com,Process Sites For Review End To End Scenario 01_01,Sites for review present in Multi-Pricing Widget,Number of sites: 19,2018-04-12T06:20:02.038+0000,2018-04-12T06:20:02.038+0000,111329,2018-04-12T06:20:02.038+0000,111329,541872,484380\r\n" + 
					"SPDWAYAUTOTEST1,CHROME,KALIBRATE_SPEEDWAY_2.9,NA,http://weu-speedway291.kalibratetech.com,Process Sites For Review End To End Scenario 01_01,Search widget search initiated with Sites for review filter,,2018-04-12T06:20:02.050+0000,2018-04-12T06:20:02.050+0000,1877,2018-04-12T06:20:02.050+0000,1877,599616,484416\r\n" + 
					"SPDWAYAUTOTEST1,CHROME,KALIBRATE_SPEEDWAY_2.9,NA,http://weu-speedway291.kalibratetech.com,Process Sites For Review End To End Scenario 01_01,Apply Prices,0007787 - BINGHAMTON NY - (607) 273-4450,2018-04-12T06:20:02.051+0000,2018-04-12T06:20:02.051+0000,4997,2018-04-12T06:20:02.051+0000,4997,571124,484848\r\n" + 
					"SPDWAYAUTOTEST1,CHROME,KALIBRATE_SPEEDWAY_2.9,NA,http://weu-speedway291.kalibratetech.com,Process Sites For Review End To End Scenario 01_01,Apply Prices Adjusted,0007749 - BINGHAMTON NY - (607) 734-1126,2018-04-12T06:20:05.052+0000,4725,2018-04-12T06:20:05.052+0000,2018-04-12T06:20:05.052+0000,4725,613220,485100\r\n" + 
					"";
			
			earliestDateTimeStamp = "2018-04-12T06:19:53.607";
			latestDateTimeStamp = "2018-04-12T06:20:05.052";
		}
		
		// End of setup data for testing method

		if(!(earliestDateTimeStamp == null || latestDateTimeStamp == null)) {

    		try {
				hooks.databaseHelper.executeSQLStringWithResultSet("DROP TABLE TempTTPTable");
			} catch (Exception e1) {
				// Do nothing as table does not exist
				log("Exception caught trying to executing DROP TABLE TempTTPTable as table does not exist. No further action necessary.");
			}
			
			String tempSQLString0 = "CREATE TABLE TempTTPTable("
					+ "[ProcessMonitorID] [int] NOT NULL,"
					+ "[Time] [datetime] NOT NULL,"
					+ "[Trail] [tinyint] NOT NULL,"
					+ "[Step] [varchar](50) NOT NULL,"
					+ "[Result] [varchar](255) NOT NULL,"
					+ "[Details] [xml] NULL);";
	
    		try {
				hooks.databaseHelper.executeSQLStringWithResultSet(tempSQLString0);
			} catch (Exception e1) {
				// Do nothing as table does not exist
				log("Exception caught trying to executing sql: " + e1.toString());
			}
			

	        String tempSQLString1 = "DECLARE @TimeOffsetMinutes int " + 
	        		"SELECT    @TimeOffsetMinutes = TimeOffsetMinutes " + 
	        		"FROM    ksspnvapp_TimeOffsetMinutes " + 
	        		"INSERT INTO TempTTPTable ([ProcessMonitorID],[Time],[Trail],[Step],[Result],[Details]) " +
	        		"SELECT [ProcessMonitorID],[Time],[Trail],[Step],[Result],[Details] "
	        		+ "FROM [dbo].[PNProcessMonitor]  (nolock) "
	        		+ "WHERE [Time] >= DATEADD(minute, ISNULL(@TimeOffsetMinutes,0),'" + earliestDateTimeStamp.split("\\+")[0] + "') "
    				+ "AND [Time] <= DATEADD(minute, ISNULL(@TimeOffsetMinutes,0),'" + latestDateTimeStamp.split("\\+")[0] + "')";
	        

    		try {
				hooks.databaseHelper.executeSQLStringWithResultSet(tempSQLString1);
			} catch (Exception e1) {
				log("Exception caught trying to executing sql: " + e1.toString());
			}
	
	        // cycle through timingsOutputBuffer and for each timestamp check   
	        // ETLTransferHistoryDetail then #TtpTemp for matching steps
	        
	        String tempTimingRow = "";
	        String cvsSplitBy = ",";
	        String outputDelimiter = "|";
	        
	        String currentRowTimestamp = "";
	        String currentRowNewTimerStart = "";
	        String currentRowNewTimerEnd = "";
	        String timingsOutputBufferNew = "";
	        
	        boolean etlActivityIdentified = false;
	        boolean batchActivityIdentified = false;
	        
	        StringBuilder builder = new StringBuilder();
	        String batchStepDetails = "";
	        String etlStepDetails = "";
	        
	        String timingsOutputBufferRows[] = timingsOutputBuffer.split("\\n");
	        
	        for (int i = 0; i < timingsOutputBufferRows.length; i++){
	        	etlActivityIdentified = false;
	        	batchActivityIdentified = false;
	        	
	        	tempTimingRow = timingsOutputBufferRows[i];
	        	
	            // use comma as separator
	            String[] timingColumnsSplit = tempTimingRow.split(cvsSplitBy);
	
	            if(timingColumnsSplit.length > 1) {
		            // get the timerTimeStamp
		            currentRowTimestamp = timingColumnsSplit[8];
		            currentRowNewTimerStart = timingColumnsSplit[10];
		            currentRowNewTimerEnd = timingColumnsSplit[11];
		            
		            log("timingsOutputBuffer row " + (i+1) + " Timestamp: " + currentRowTimestamp);
	
	        		if(testWithDummyData) {
	        			// ETL Row to match against
		        		//2018-04-18 09:00:23 +00:00	
		        		//2018-04-18 09:01:51 +00:00

	        			currentRowNewTimerStart = "2018-04-18T09:00:24.000+0000";
		        		currentRowNewTimerEnd = "2018-04-18T09:01:22.100+0000";
	        		}
	        		
	        		
		            // remove the trailing +0000
		            currentRowTimestamp = currentRowTimestamp.split("\\+")[0];
		            currentRowNewTimerStart = currentRowNewTimerStart.split("\\+")[0];
	        		currentRowNewTimerEnd = currentRowNewTimerEnd.split("\\+")[0];
	        		
		            // Start of ETLTransferHistoryDetail check
	//	            String tempSQLString2 = "SELECT TOP 1 * FROM [cmn].[ETLTransferHistoryDetail] "
	//	            		+ "WHERE StartTime <= CONVERT(Datetime2,'" + currentRowTimestamp + "') "
	//	    				+ "AND EndTime >= CONVERT(Datetime2,'" + currentRowTimestamp + "') "
	//						+ "AND (RowsInserted > 0 OR RowsUpdated > 0 OR RowsDeleted > 0) "
	//	    				+ "ORDER BY ETLTransferHistoryID DESC";
		            
	//	            String tempSQLString2 = "SELECT * FROM [cmn].[ETLTransferHistoryDetail] "
	//	            		+ "WHERE EndTime >= DATEADD(hour, -1, CONVERT(Datetime2,'" + currentRowNewTimerStart + "')) "
	//	    				+ "AND StartTime <= DATEADD(hour, -1, CONVERT(Datetime2,'" + currentRowNewTimerEnd + "')) "
	////	    				+ "AND (RowsInserted > 0 OR RowsUpdated > 0 OR RowsDeleted > 0 OR DurationSeconds > 0 or DurationMinutes > 0) "
	//	    				+ "ORDER BY ETLTransferHistoryID";
	
		            String tempSQLString2 = "SELECT * FROM [cmn].[ETLTransferHistoryDetail] "
		            		+ "Where StartTime <= CONVERT(Datetime2,'" + currentRowNewTimerEnd + "') "
		            		+ "AND (EndTime >= CONVERT(Datetime2,'" + currentRowNewTimerStart + "') "
		    				+ "AND (RowsInserted > 0 OR RowsUpdated > 0 OR RowsDeleted > 0 OR DurationSeconds > 0 or DurationMinutes > 0) ) "
		    				+ "OR EndTime is NULL AND ETLTransferHistoryDetailID = (SELECT MAX(ETLTransferHistoryDetailID) FROM [cmn].[ETLTransferHistoryDetail] ) "
		    				+ "ORDER BY ETLTransferHistoryDetailID";

		            
	        		
		            ResultSet sqlDbResultSet;
		            
		            
					try {
						sqlDbResultSet = hooks.databaseHelper.executeSQLStringWithResultSet(tempSQLString2);
						
						int columnCount = sqlDbResultSet.getMetaData().getColumnCount();
						
					    while (sqlDbResultSet.next()) {
	
					    	// Add delimiter if required
					    	if(etlActivityIdentified)
					    		builder.append(outputDelimiter);
					    	else
						    	etlActivityIdentified = true;
					    	
				    		builder.append(sqlDbResultSet.getString(1));
					    }
	
						etlStepDetails = builder.toString().replace(",", "<comma>");
						builder.setLength(0);
						
					} catch (Exception e) {
			        	customFailScript("Exception caught: " + e.toString());
					}
					// End of ETLTransferHistoryDetail check
		
					
		            // Start of #TtpTemp check
					
	        		if(testWithDummyData) {
		        		currentRowNewTimerStart = "2018-04-12T06:20:02.070+0000";
		        		currentRowNewTimerEnd = "2018-04-12T06:20:02.118+0000";
		        		
			            currentRowNewTimerStart = currentRowNewTimerStart.split("\\+")[0];
		        		currentRowNewTimerEnd = currentRowNewTimerEnd.split("\\+")[0];
	        		}
	        		
	//	            String tempSQLString3 = "SELECT * "
	//	            		+ "FROM TempTTPTable "
	//	            		+ "WHERE [Time] >= DATEADD(hour, -1, CONVERT(Datetime2,'" + currentRowNewTimerStart + "')) "
	//	    				+ "AND [Time] <= DATEADD(hour, -1, CONVERT(Datetime2,'" + currentRowNewTimerEnd + "')) "
	//						+ "ORDER BY ProcessMonitorID";
	
//		            String tempSQLString3 = "SELECT * "
//		            		+ "FROM TempTTPTable "
//		            		+ "WHERE [Time] >= CONVERT(Datetime2,'" + currentRowNewTimerStart + "') "
//		    				+ "AND [Time] <= CONVERT(Datetime2,'" + currentRowNewTimerEnd + "') "
//							+ "ORDER BY ProcessMonitorID";
	
		            String tempSQLString3 = "DECLARE @TimeOffsetMinutes int " 
			        		+ "SELECT    @TimeOffsetMinutes = TimeOffsetMinutes " 
			        		+ "FROM    ksspnvapp_TimeOffsetMinutes " 
			        		+ "SELECT * "
		            		+ "FROM TempTTPTable "
		            		+ "WHERE [Time] >= DATEADD(minute, ISNULL(@TimeOffsetMinutes,0),'" + currentRowNewTimerStart + "') "
		    				+ "AND [Time] <= DATEADD(minute, ISNULL(@TimeOffsetMinutes,0),'" + currentRowNewTimerEnd + "') "		    				
							+ "ORDER BY ProcessMonitorID";

		            
					try {
			            sqlDbResultSet = hooks.databaseHelper.executeSQLStringWithResultSet(tempSQLString3);
		
					    while (sqlDbResultSet.next()) {
	
					    	// Add delimiter if required
					    	if(batchActivityIdentified)
					    		builder.append(outputDelimiter);
					    	else
					    		batchActivityIdentified = true;
					    	
				    		builder.append(sqlDbResultSet.getString(1));
					    }
	
	//		            int columnCount = sqlDbResultSet.getMetaData().getColumnCount();
	//		            log("columnCount: " + columnCount);
	//		            
	//					if(sqlDbResultSet.next())
	//					{
	//	
	//						if(!(sqlDbResultSet.getString("Result").equalsIgnoreCase("Executed successfully") || sqlDbResultSet.getString("Result").equalsIgnoreCase("Completed batch cycle"))) {
	//							log("Batch Step with a result different to \"Executed successfully\" identified");
	//							batchActivityIdentified = true;
	//
	//						    for (int j = 0; j < columnCount;) {
	//						        builder.append(sqlDbResultSet.getString(j + 1));
	//						        if (++j < columnCount) builder.append("|");
	//						    }
	//						}
	//						
	//					}
						
						batchStepDetails = builder.toString().replace(",", "<comma>");
						builder.setLength(0);
						
					} catch (Exception e) {
			        	customFailScript("Exception caught: " + e.toString());
					}
					// End of #TtpTemp check
					
					tempTimingRow=StringUtils.chomp(tempTimingRow);
					tempTimingRow += ("," + etlActivityIdentified + "," + batchActivityIdentified + "," + etlStepDetails + "," + batchStepDetails + "\n");
					
					timingsOutputBufferNew += tempTimingRow;
					
		        }
	        }
		        
		//        hooks.databaseHelper.executeSQLStringWithResultSet("DROP TABLE IF EXISTS TempTTPTable");
		        
	        String timingsHeaderRowTemp = timingsHeaderRow + ",ETL_ACTIVITY,BATCH_ACTIVITY,ETL_MATCHED_ETLTransferHistoryDetailID,BATCH_MATCHED_PNProcessMonitorID\n";
	
	        log(timingsHeaderRowTemp);
	        log(timingsOutputBufferNew);
	        
	        if(!testWithDummyData) {
	        	timingsHeaderRow = timingsHeaderRowTemp;
	        	timingsOutputBuffer = timingsOutputBufferNew;
	        }
	        
			earliestDateTimeStamp = null;
			latestDateTimeStamp = null;
			
	//        System.exit(0);
		}

	}	
	
	public void saveTestOutputFiles() {
		
		PrintWriter out;
		
        // save timings.csv
		
			log("\nSaving results to " + screenshotDirectoryPath + "/timings.csv");
	        try {
				out = new PrintWriter(screenshotDirectoryPath + "/timings.csv");
				out.print(timingsHeaderRow);
		        out.print(timingsOutputBuffer);
		        out.flush();
			} catch (Exception e) {
				customFailScript("Exception5 caught: " + e.toString());
			}
	        
	        log("Save to timings.csv successful");
        
	        
	        // append to master timings file
	        
	        log("\nApending results to " + Utils.getProperty("OUTPUT_DEFAULT_PATH") + "/" + System.getenv("COMPUTERNAME") + "/allTimings.csv");
	        log("\ntimingsOutputBuffer;\n" + timingsOutputBuffer + "\n\n");
	    
        	Boolean fileExists = false;

        	File tempFile = new File(Utils.getProperty("OUTPUT_DEFAULT_PATH") + "/" + System.getenv("COMPUTERNAME") + "/allTimings.csv");

        	// Create file if it doesn't already exist
        	// allTimings.csv
            if(!tempFile.exists()) {
    			try {
    				Files.createParentDirs(tempFile);
    				Files.touch(tempFile);
    				
				} catch (IOException e) {
					customFailScript("Exception caught creating new file: " + e.toString());
				}
            } else
            	fileExists = true;

            // Output header row (if required) and timingsOutputBuffer
	        try {
	        	
	        	out = new PrintWriter(new BufferedWriter(new FileWriter(Utils.getProperty("OUTPUT_DEFAULT_PATH") + "/" + System.getenv("COMPUTERNAME") + "/allTimings.csv", true)));
	        	
	            if(!fileExists)
	            	out.print(timingsHeaderRow);
	            
	            out.print(timingsOutputBuffer);
		        out.flush();
	        }catch (Exception e) {
	        	customFailScript("Exception caught appending to existing file: " + e.toString());
	        }
	        
	        log("Apend to output share allTimings.csv successful");

	  
	        // globalTimings.csv
        	fileExists = false;

        	tempFile = new File(Utils.getProperty("OUTPUT_DEFAULT_PATH") + "/globalTimings.csv");

        	// Create file if it doesn't already exist
            if(!tempFile.exists()) {
    			try {
    				Files.createParentDirs(tempFile);
    				Files.touch(tempFile);
    				
				} catch (IOException e) {
					customFailScript("Exception caught creating new file: " + e.toString());
				}
            } else
            	fileExists = true;

            // Output header row (if required) and timingsOutputBuffer
	        try {
	        	
	        	out = new PrintWriter(new BufferedWriter(new FileWriter(Utils.getProperty("OUTPUT_DEFAULT_PATH") + "/globalTimings.csv", true)));
	        	
	            if(!fileExists)
	            	out.print(timingsHeaderRow);
	            
	            out.print(timingsOutputBuffer);
		        out.flush();
	        }catch (Exception e) {
	        	customFailScript("Exception caught appending to existing file: " + e.toString());
	        }
	        
	        log("Apend to output share globalTimings.csv successful");	        
	        

	        
	        // If necessary also output allTImings and globalTimings to output share
	        if(Boolean.parseBoolean(Utils.getProperty("COPY_OUTPUT_TO_NETWORK_SHARE"))) {
	        	fileExists = false;

	        	tempFile = new File(Utils.getProperty("NETWORK_SHARE_PATH") + "/" + System.getenv("COMPUTERNAME") + "/allTimings.csv");

	        	// Create file if it doesn't already exist
	        	// allTimings.csv
	            if(!tempFile.exists()) {
	            	log(tempFile.getAbsolutePath() + " does not exist so creating");
        			try {
        				Files.createParentDirs(tempFile);
        				Files.touch(tempFile);
        				
					} catch (IOException e) {
						customFailScript("Exception caught creating new file: " + e.toString());
					}
	            } else
	            	fileExists = true;

	            	

	            // Output header row (if required) and timingsOutputBuffer
		        try {
		        	
		        	out = new PrintWriter(new BufferedWriter(new FileWriter(Utils.getProperty("NETWORK_SHARE_PATH") + "/" + System.getenv("COMPUTERNAME") + "/allTimings.csv", true)));
		        	
		            if(!fileExists)
		            	out.print(timingsHeaderRow);
		            
		            out.print(timingsOutputBuffer);
			        out.flush();
		        } catch (Exception e) {
		        	customFailScript("Exception caught appending to existing file: " + e.toString());
		        }
		        
		        log("Apend to output share allTimings.csv successful");
	
		  
		        // globalTimings.csv
	        	fileExists = false;

	        	tempFile = new File(Utils.getProperty("NETWORK_SHARE_PATH") + "/globalTimings.csv");

	        	// Create file if it doesn't already exist
	            if(!tempFile.exists()) {
	            	log(tempFile.getAbsolutePath() + " does not exist so creating");
        			try {
        				Files.createParentDirs(tempFile);
        				Files.touch(tempFile);
        				
					} catch (IOException e) {
						customFailScript("Exception caught creating new file: " + e.toString());
					}
	            } else
	            	fileExists = true;

	            // Output header row (if required) and timingsOutputBuffer
		        try {
		        	
		        	out = new PrintWriter(new BufferedWriter(new FileWriter(Utils.getProperty("NETWORK_SHARE_PATH") + "/globalTimings.csv", true)));
		        	
		            if(!fileExists)
		            	out.print(timingsHeaderRow);
		            
		            out.print(timingsOutputBuffer);
			        out.flush();
		        } catch (Exception e) {
		        	customFailScript("Exception caught appending to existing file: " + e.toString());
		        }

		        
		        log("Apend to output share globalTimings.csv successful");
		        
		        

	        }
	        
        // Build HTML file
			// TODO: Future enhancement - pass a template to be used?
			
	        StringBuilder html = new StringBuilder();
	        html.append( "<!doctype html>\n" );
	        html.append( "<html lang='en'>\n" );
	
	        html.append( "<head>\n" );
	        html.append( "<meta charset='utf-8'>\n" );
	        html.append( "<title>Automation Test Execution Log</title>\n" );
	        html.append( "</head>\n\n" );
	
	        html.append( "<body>\n" );
	        html.append( "<h1 style='color:blue'>Automation Test Execution Log</h1>\n" );
	
	        html.append( "<ul>\n" );
	        
	        // Loop the list argument and add to report
	        for ( String reportEntry : listOfReportEntries ) {
	            html.append(reportEntry);
	        }
	        
	        html.append( "</ul>\n" );
	        html.append( "</body>\n\n" );
	
	        html.append( "</html>" );

        
        // save report.html
	        try {
				out = new PrintWriter(screenshotDirectoryPath + "/report.html");
		        out.println(html.toString());
		        out.flush();
		        out.close();
			} catch (Exception e) {
				customFailScript("Exception8 caught: " + e.toString());
			}

	
	        // Copy output folder to network share

	        if(Boolean.parseBoolean(Utils.getProperty("COPY_OUTPUT_TO_NETWORK_SHARE"))) {
		        try {
		        	log("\n\nCopying local output folder: " + screenshotDirectoryPath);
		        	log("to output share: " + Utils.getProperty("NETWORK_SHARE_PATH") + testRunOutputPath);
		        	
		            FileUtils.copyDirectory(new File(screenshotDirectoryPath), new File(Utils.getProperty("NETWORK_SHARE_PATH") + testRunOutputPath));
		        } catch (IOException e) {
		        	customFailScript("Exception caught copying output folder to output share: " + e.toString());
		        }
	        }
	        
	        


    }

	public String runSystemCommand(String command) {

		String output = "";
		
		if(Utils.getProperty("PLATFORM").equalsIgnoreCase("WINDOWS")) {
			log("Executing following system command: " + command);
			
			
		    try {
		        Process p = Runtime.getRuntime().exec(command);
		        BufferedReader inputStream = new BufferedReader(
		                new InputStreamReader(p.getInputStream()));
	
		        String s = "";
		        // reading output stream of the command
		        while ((s = inputStream.readLine()) != null) {
		            log(s);
		            output+=s;
		        }
	
		    } catch (Exception e) {
		    	customFailScript("Exception9 caught: " + e.toString());
		    }
		} else
			output = "PLATFORM is set to " + Utils.getProperty("PLATFORM") + " in config.properties. This is currently unsupported in runSystemCommand method.";
		
		return output;
	}
	
	public void recordSystemUsage() {
		
		log("\n\n\t---------------JVM Runtime Details-------------");
		long maxMemory = Runtime.getRuntime().maxMemory() ;
		log("\tAvailable processors (Cores): " +   Runtime.getRuntime().availableProcessors());
		log("\tInitial Memory (-Xms)       : " +  (Runtime.getRuntime().freeMemory()/(1024*1024))+" MB");
		log("\tMaximum JVM Memory (-Xmx)   : " + (maxMemory/(1024*1024))+" MB");
		log("\tTotal Used JVM Memory       : " + (Runtime.getRuntime().totalMemory()/(1024*1024))+" MB");
		 
		log("\n\n\t---------------CPU USAGES-------------\n");

		OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
		
		for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {

			method.setAccessible(true);
			if (method.getName().startsWith("get") && Modifier.isPublic(method.getModifiers())) {
				Object value;
				try {
					value = method.invoke(operatingSystemMXBean);
				} catch (Exception e) {
					value = e;
				}
		
				log("\t" + method.getName() + " = " + value);
			}
		}
	}

	public void outputElementHTML(WebElement tempWebElement) {
		log("\n\ntempWebElement.getAttribute(\"innerHTML\"): \n\n" + tempWebElement.getAttribute("innerHTML") + "\n\n");
	}
}



