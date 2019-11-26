package com.common.helpers;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.common.hooks.Hooks;
//import cucumber.api.java.it.Date;
import io.appium.java_client.AppiumDriver;

 

public class BrowserHelper {

	private static WebDriver driver;
	private static AppiumDriver appiumDriver;
	private static ReporterHelper reporterHelper;
	
	public Robot robot;
	private static int totalNetworkLogsCount;
	
	private static WebElement tempWebElement;
	private static String currentFrame;
	private static Hooks hooks;
	
	public BrowserHelper(Hooks hooks) {
	
		this.hooks = hooks;
		
		driver = hooks.driver;
		appiumDriver = hooks.appiumDriver;
		
		reporterHelper = hooks.reporterHelper;
		
	}
	
    public static void waitUntil(Date date) {
    	
        final Object o = new Object();
        TimerTask tt = new TimerTask() {
            public void run() {
                synchronized (o) {
                    o.notify();
                }
            }
        };
        Timer t = new Timer();
        t.schedule(tt, date);
        synchronized(o) {
            try {
                o.wait();
            } catch (InterruptedException ie) {}
        }
        t.cancel();
        t.purge();
        
    }

	public void messageBox(String message) {
		
		if (Boolean.parseBoolean(Utils.getProperty("ALLOW_FRAMEWORK_ALERTS"))) {
		    Toolkit.getDefaultToolkit().beep();
		    JOptionPane optionPane = new JOptionPane(message, JOptionPane.WARNING_MESSAGE);
		    JDialog dialog = optionPane.createDialog("Warning!");
		    dialog.setAlwaysOnTop(true);
		    dialog.setVisible(true);
		} else
			reporterHelper.log("\n Suppressed Framework Alert '" + message + "' as ALLOW_FRAMEWORK_ALERTS is set to false in config");

	}

	public void openURL(String url) {

		reporterHelper.log("\n In method BrowserHelper.openURL. Opening url: '" + url + "'");
		
		driver.get(url);

	}
	
	public static WebElement syncOnElement(WebDriver driver, By byLocator, String frameName, String syncType) {
		
		switchToFrame(frameName);

		return syncOnElement(driver, byLocator, syncType);
//		return tempWebElement;
	}
		
		
	public static WebElement syncOnElement(WebDriver driver, By byLocator, String syncType) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		boolean exitLoop = false;
		boolean passed = false;
		
		int loopCount = 0;
		
		reporterHelper.log("\nSynchronising on element using: " + byLocator.toString());
		
		while(!exitLoop && !passed) {
			
			reporterHelper.log("syncOnElement loopCount: " + loopCount);

			if(isElementPresent(driver, byLocator)) {

				try {
					reporterHelper.log("\tElement identified, checking is " + syncType);
					
					switch(syncType) {
					
						case "present":
							
							wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	//						wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(byLocator, 0));
							passed = true;
							break;
							
						case "visible":
	
							wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
							passed = true;
							break;
							
						case "clickable":
							
							wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
							wait.until(ExpectedConditions.elementToBeClickable(byLocator));
							passed = true;
							break;
					
					}
					
				} catch (Exception e) {
					reporterHelper.customFailScript("\tElement identified, however is not " + syncType);
					break;
				}
				
			}

			if(loopCount++ == Integer.parseInt(Utils.getProperty("MAX_SYNC_RETRIES")) ) {
				reporterHelper.log("\tSync failed as element not present after " + loopCount + " attempts");
				break;
			}
			
			customSleep(Integer.parseInt(Utils.getProperty("DEFAULT_SYNC_WAIT")));
			
		}
		
		if(!passed) {
			checkForConsoleErrors();
			reporterHelper.customFailScript(syncType + " sync failed for element using by locator " + byLocator);
		}

		reporterHelper.log("\tElement identified, and is " + syncType);
		return driver.findElement(byLocator);
	}	

	public static WebElement syncOnElement(AppiumDriver appiumDriver, By byLocator, String syncType) {
		
		WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
		
		boolean exitLoop = false;
		boolean passed = false;
		
		int loopCount = 0;
		
		reporterHelper.log("\nSynchronising on element using: " + byLocator.toString());
		
		while(!exitLoop && !passed) {
			
			reporterHelper.log("syncOnElement loopCount: " + loopCount);

			if(isDeviceElementPresent(appiumDriver, byLocator)) {

				try {
					reporterHelper.log("\tElement identified, checking is " + syncType);
					
					switch(syncType) {
					
						case "present":
							
							wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	//						wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(byLocator, 0));
							passed = true;
							break;
							
						case "visible":
	
							wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
							passed = true;
							break;
							
						case "clickable":
							
							wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
							wait.until(ExpectedConditions.elementToBeClickable(byLocator));
							passed = true;
							break;
					
					}
					
				} catch (Exception e) {
					reporterHelper.customFailScript("\tElement identified, however is not " + syncType);
					break;
				}
				
			}

			if(loopCount++ == Integer.parseInt(Utils.getProperty("MAX_SYNC_RETRIES") )) {
				reporterHelper.log("\tSync failed as element not present after " + loopCount + " attempts");
				break;
			}
			
			customSleep(Integer.parseInt(Utils.getProperty("DEFAULT_SYNC_WAIT")));
			
		}
		
		if(!passed) {
			checkForConsoleErrors();
			reporterHelper.customFailScript(syncType + " sync failed for element using by locator " + byLocator);
		}		

		reporterHelper.log("\tElement identified, and is " + syncType);
		return appiumDriver.findElement(byLocator);
	}	
	
	public static List<WebElement> syncOnElements(WebDriver driver, By byLocator, String frameName, String syncType) {
		
		switchToFrame(frameName);
		
		return syncOnElements(driver, byLocator, syncType);
	}		
		

	public static List<WebElement> syncOnElements(WebDriver driver, By byLocator, String syncType) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		boolean exitLoop = false;
		boolean passed = false;
		
		int loopCount = 0;
		
		reporterHelper.log("\nSynchronising on element using - " + byLocator);
		
		while(!exitLoop && !passed) {
			
			reporterHelper.log("syncOnElement loopCount: " + loopCount);

			if(isElementPresent(driver, byLocator)) {

				try {
					reporterHelper.log("\tElement identified, checking is " + syncType);
					
					
					switch(syncType) {
					
					case "present":
						
						wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
						wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(byLocator, 0));
						passed = true;
						break;
						
					case "visible":

						wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
						passed = true;
						break;
						
					case "clickable":
						
						wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
						wait.until(ExpectedConditions.elementToBeClickable(byLocator));
						passed = true;
						break;
				
					}					
					
				
				} catch (Exception e) {
					reporterHelper.customFailScript("\tElement identified, however is not " + syncType);
					break;
				}
				
			}

			if(loopCount++ == Integer.parseInt(Utils.getProperty("MAX_SYNC_RETRIES"))) {
				reporterHelper.log("\tSync failed as element not present after " + loopCount + " attempts");
				exitLoop = true;
				break;
			}
			
			customSleep(Integer.parseInt(Utils.getProperty("DEFAULT_SYNC_WAIT")));			
		}
		
		if(!passed) {
			checkForConsoleErrors();
			reporterHelper.customFailScript(syncType + " sync failed for element using by locator " + byLocator);
		}		

		reporterHelper.log("\tElement identified, and is " + syncType);
		return driver.findElements(byLocator);
		
	}	
		
	public static boolean isElementPresent (WebDriver driver, By by) {
		
		return isElementPresent(driver, by, 1);

	}

	public static void switchToFrame(String frameName) {
		
		reporterHelper.log("\nCurrent frame: " + currentFrame);
		
		if(!frameName.equals(currentFrame)) {

			reporterHelper.log("\nSwitching to frame: " + frameName);

			driver.switchTo().defaultContent();
			
			if(!frameName.equalsIgnoreCase("default")) {
				
//				tempWebElement = syncOnElement(driver, By.xpath(".//IFRAME[contains(@name, '" + frameName + "')] | .//IFRAME[contains(@id, '" + frameName + "')] | .//IFRAME[contains(@class, '" + frameName + "')]"), "default", "present");
				tempWebElement = syncOnElement(driver, By.xpath(".//frame[contains(@name, '" + frameName + "')] | .//frame[contains(@id, '" + frameName + "')] | .//frame[contains(@class, '" + frameName + "')]"), "default", "present");
				

				reporterHelper.log("\tAbout to switch to the identified frame: " + frameName);
				driver.switchTo().frame(tempWebElement);
				reporterHelper.log("\tSwitch complete");
				
			}
			
			currentFrame = frameName;
			
//			tempWebElement =  syncOnElement(driver, byLocator, syncType);
//			driver.switchTo().defaultContent();

		}
	}
	
	
	public static boolean isElementPresent (WebDriver driver, By by, String frameName, int retryAttempts) {
		
		switchToFrame(frameName);

		return isElementPresent(driver, by, retryAttempts);

	}
	
	public static boolean isElementPresent (WebDriver driver, By by, int retryAttempts) {

		Boolean returnValue = false;
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		reporterHelper.log("Checking for presence of following webelement for " + retryAttempts + " attempts: " + by.toString());
		
		for(int i=0; i<retryAttempts; i++) {

			try {  
				driver.findElement(by); 
				reporterHelper.log("call to isElementPresent returning true for: " + by.toString());
				returnValue = true;
				break;
			}
			catch(Exception e) {
				if(e instanceof NoSuchElementException) {
					reporterHelper.log("call to isElementPresent returning false for: " + by.toString());
				} else
					reporterHelper.customFailScript("Exception caught in method isElementPresent: " + e.toString());
			}

			customSleep(1 * 1000);
			
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return returnValue;

	}
	
	public static boolean isElementDisplayed (WebDriver driver, By by) {
		
		Boolean returnValue = false;
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		try {  
			tempWebElement = driver.findElement(by); 
			if(tempWebElement.isDisplayed() ) {
				reporterHelper.log("call to isElementDisplayed returning true for: " + by.toString());
				returnValue =  true;  
			} else {
				reporterHelper.log("call to isElementDisplayed returning false for: " + by.toString());
			}
				
			
		}  
		catch(Exception e) {
			if(e instanceof NoSuchElementException) {
				reporterHelper.log("call to isElementDisplayed returning false for: " + by.toString());
			} else 
				reporterHelper.customFailScript("Exception caught in method isElementDisplayed: " + e.toString());
		}
		finally {  
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
		}
		
		return returnValue;

	}
	public static boolean isDeviceElementPresent (AppiumDriver appiumDriver, By by) {
		
		appiumDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		try {  
			appiumDriver.findElement(by); 
			return true;  
		}  
		catch(NoSuchElementException e) {  
			return false;  
		}  
		finally {  
			appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
		}  

	}

	public static void customSleep(int sleepTimeMilliseconds) {
		
		reporterHelper.log("\nPerforming a sleep via customSleep method for following number of milliseconds: " + sleepTimeMilliseconds + " (" + sleepTimeMilliseconds/1000 + " seconds)");
	    
		try {
			Thread.sleep(sleepTimeMilliseconds);
		} catch (InterruptedException e) {
			reporterHelper.customFailScript("Exception caught: " + e.toString());
		}
	}
	
	public void clipboardType(String stringToSend) {

		try {
			robot = new Robot();
		} catch (AWTException e) {
			reporterHelper.customFailScript(e.toString()); 
		}
		
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    StringSelection stringSelection = new StringSelection( stringToSend );
	    clipboard.setContents(stringSelection, stringSelection);
	    
	    reporterHelper.log("\nSending the following string to OS via clipboard: " + stringToSend);
	    
	    customSleep(500);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    customSleep(500);

	}

	public static void syncOnElementText(WebDriver driver, By kalibrateMainWorkspacemenuheader, String workSpaceName) {
		
		boolean exitLoop = false;
		int loopCount = 0;
		
		while(!exitLoop) {
			
			tempWebElement = syncOnElement(driver, kalibrateMainWorkspacemenuheader, "clickable");
		
			if(tempWebElement.getText().equalsIgnoreCase(workSpaceName)) {
				break;
			}
		
			if(loopCount++ > Integer.parseInt(Utils.getProperty("MAX_SYNC_RETRIES")) ) {
				reporterHelper.log("\tSync failed as element text not present after " + loopCount + " attempts");
				break;
			}
			
			customSleep(Integer.parseInt(Utils.getProperty("DEFAULT_SYNC_WAIT")));
			
		}
		
	}

	public void moveToElement(WebElement tempElement) {
		reporterHelper.log("\nMoving to element: " + tempElement.toString());
		new Actions(driver).moveToElement(tempElement).perform();
	}
	

	public static void checkForConsoleErrors() {
		
		reporterHelper.log("\n\n\n############################################################");
		
		if((!driver.toString().contains("null")) && Boolean.parseBoolean(Utils.getProperty("EXTENDED_BROWSER_LOG_MONITORING")) && Utils.getProperty("BROWSER_NAME").equals("CHROME")) {
			
			Boolean terminateScript = false;;
			
			
			reporterHelper.log("Checking console output...\n");
			
		    LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		    
		    for (LogEntry logEntry : logEntries) {
	    		reporterHelper.log("\t" + logEntry.toString());
		    }
	
			if(!logEntries.filter(Level.SEVERE).isEmpty()) {
				terminateScript = true;
				reporterHelper.error("\n\n\tSEVERE console output identified - suggest BUG should be raised");
			}
	
			reporterHelper.log("\nFinished checking console");
			reporterHelper.log("############################################################\n\n\n");
			
			if(terminateScript && Boolean.parseBoolean(Utils.getProperty("FAIL_ON_SEVERE_CONSOLE_OUTPUT")))
				reporterHelper.customFailScript("SEVERE console entry identified");
			
			checkNetwork();
			
		} else {
			reporterHelper.log("\nNot performing extended browser logging (console errors and network calls)\n");
			reporterHelper.log("as browser is closed and/or EXTENDED_BROWSER_LOG_MONITORING set to false in config.properties\n");
			reporterHelper.log("and/or BROWSER is not set to CHROME - currently only suported in CHROME\n");
			reporterHelper.log("############################################################\n\n\n");
		}

	}
	

	
	public static void checkNetwork() {
		

		reporterHelper.log("\n\n\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		reporterHelper.log("Checking Network...\n");

		reporterHelper.log("driver.manage().logs().getAvailableLogTypes(): " + driver.manage().logs().getAvailableLogTypes());

	    Set<String> logTypes = driver.manage().logs().getAvailableLogTypes();

	    
		int getMinalyticsDataCount = 0;
		int loadingFinishedCount = 0;
		
	    for(String logType: logTypes)
	    {
			List<LogEntry> entries = driver.manage().logs().get(logType).getAll();
			
			reporterHelper.log(entries.size() + " " + logType + " log entries found");
			totalNetworkLogsCount += entries.size();
			
			for (LogEntry entry : entries) {
				
				String entryMessage = entry.getMessage();
				
				if(entryMessage.contains("GetMinalyticsData")) {
					getMinalyticsDataCount++;

//					String requestIdIdentifier = ",\"requestId\":\"";
//					String tempEntryMessage = entryMessage.substring(entryMessage.indexOf(requestIdIdentifier) + requestIdIdentifier.length());
//					String requestId = tempEntryMessage.substring(0, tempEntryMessage.indexOf("\""));
//					reporterHelper.log("\nGetMinalyticsData requestId: " + requestId);
//					reporterHelper.log("entryMessage: " + entryMessage);
				}
				
				if(entryMessage.contains("GetUserSettings")) {

					reporterHelper.log("");
					reporterHelper.log("GetUserSettings network call identified;");
					reporterHelper.log("entry.getMessage(): "+ entryMessage);
//					reporterHelper.log("entry.toString(): "+ entryMessage);
					reporterHelper.log("");
					
				}


			}
			
	    }
		
		reporterHelper.log("\ngetMinalyticsDataCount: " + getMinalyticsDataCount);
//		reporterHelper.log("\nloadingFinishedCount: " + loadingFinishedCount);
		
		reporterHelper.log("\nFinished checking Network");
		reporterHelper.log("\nCumulative Network Logs count: " + totalNetworkLogsCount);
		reporterHelper.log("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\n\n");
	}

	public void navigateBack() {
		
		reporterHelper.log("\nNavigateing back in Browser");
		
		driver.navigate().back();
		
	}

	

}


