package com.common.helpers;

import java.awt.Robot;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.common.hooks.Hooks;
import com.common.page_objects.OLD_Generic_LocatorLibrary;
import com.step_definitions.optimus.Optimus_Hooks;

 

public class OLDHelper {

	private static WebDriver driver;
	private static ReporterHelper reporterHelper;
	
	public Robot robot;
	
	private static int maxRetries;
	
	private static WebElement tempWebElement;
	private static String currentFrame;
	
	private OLD_Generic_LocatorLibrary oldLocatorLibrary;
	
	public OLDHelper(Hooks hooks) {
	
		driver = Hooks.driver;
		reporterHelper = Hooks.reporterHelper;
		oldLocatorLibrary = Optimus_Hooks.OLDLocatorLibrary;
	
	}

	public void closeAllOpenWidgets() {
		
		if(BrowserHelper.isElementPresent(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_main_WidgetContainers)) {
			
			reporterHelper.log("\nClosing displayed widgets...");
			
			List<WebElement> elements = BrowserHelper.syncOnElements(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_main_WidgetContainers, "present");
			
			reporterHelper.log("\tNumber of widgets identified: " + elements.size());
			
			WebElement currentWidgetCloseIcon = null;
			
			reporterHelper.takeScreenshot(driver, "General-Before_Closing_" + elements.size() + "_Widgets");
			
			for (int i = 0; i < elements.size(); i++) {
				
				reporterHelper.log("\n\tClosing widget #" + (i + 1));
				try {
					currentWidgetCloseIcon = elements.get(i).findElement(By.xpath(".//a[contains(@class, 'remove')]"));
					currentWidgetCloseIcon.click();
				} catch (Exception e) {
					reporterHelper.customFailScript("Exeception caught trying to close widget: " + e.toString());
				}
				
				reporterHelper.takeScreenshot(driver, "General-After_Closing_Widget_Number_" + (i + 1));
			}

			
		} else {
			reporterHelper.log("\tNumber of widgets identified: 0");
		}
	}
	
	public void syncAllPresentWidgets() {

		// decrease timeout so the findElement does not wait 
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		
		if(BrowserHelper.isElementPresent(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_main_WidgetContainers)) {
			
			reporterHelper.log("\nSyncing displayed widgets...");
			
			List<WebElement> elements = BrowserHelper.syncOnElements(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_main_WidgetContainers, "present");
			
			reporterHelper.log("\tNumber of widgets identified: " + elements.size());
			
			String currentWidgetHeader = "";
			
			int titleWaitCount;
			
			for (int i = 0; i < elements.size(); i++) {
				
				reporterHelper.log("\n\tChecking widget #" + (i + 1));
				
				titleWaitCount = 0;
				Boolean skipWidigetCheck = false;
				
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				
				while(true) {
					titleWaitCount++;
					
					try {
						currentWidgetHeader = elements.get(i).findElement(By.xpath(".//h4 | .//span[contains(@ng-switch, 'widget.obj')]/span/span/span/span")).getText();
					} catch (Exception e) {
						// check to see if there is a error message regarding linked site e.g. 'No site selected.  Select a site from the linked Search widget'
						// if an error containing 'linked' is displayed then skip this one
						try {
							tempWebElement = elements.get(i).findElement(By.xpath(".//div[@class = 'error-message'][contains(., 'site from the linked')]"));
							// if error found then drop out of while loop and move onto next widget
							reporterHelper.log("No title identified where it is linked to a widget with no site selected.  Skipping and moving on to next widget");
							skipWidigetCheck = true;
							break;
						} catch (Exception e1) {
							// Do nothing
						}
					}
					

					if(currentWidgetHeader.equalsIgnoreCase("")) {
						
						try {
							// see if it is the header of a MAP widget

							tempWebElement = elements.get(i).findElement(By.xpath("//div[@name='k-map-widget']"));
							
							if(Boolean.parseBoolean(Utils.getProperty("RELAX_MAP_VALIDATION"))) {
								reporterHelper.log("Wiget has been identified as a MAP widget and RELAX_MAP_VALIDATION is set to true in config, therefore skipping title check");
								skipWidigetCheck = true;
								break;
							}
						} catch (Exception e3) {
							reporterHelper.log("Could not find \"//div[@name='k-map-widget']\" of current widget");
							reporterHelper.log(elements.get(i).toString());
						}
						
						reporterHelper.log("\t## Widget Title not yet populated... attempt " + titleWaitCount + " ##");
					}
					else {
						break;
					}
	
					if(titleWaitCount > Integer.parseInt(Utils.getProperty("MAX_SYNC_RETRIES")) ) {
						reporterHelper.customFailScript("\tSync failed widget title not present after " + titleWaitCount + " attempts");
						break;
					}
					
					BrowserHelper.customSleep(Integer.parseInt(Utils.getProperty("DEFAULT_SYNC_WAIT")));
				}
				
				// remove client name from the widget title
				try {
					currentWidgetHeader = currentWidgetHeader.split(" -")[0];
				} catch (Exception e) {
					// Do nothing as Widget does not contain Client name
				}
				
				if(!skipWidigetCheck) {
					reporterHelper.log("\tWidget title identified: " + currentWidgetHeader);
					checkWidgetLoadComplete(currentWidgetHeader);
				}
			}
			
		} else {
			reporterHelper.log("\tNumber of widgets identified: 0");
		}
		
		// reset default timeout 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);

		
	}
	
	public void checkWidgetLoadComplete(String currentWidgetHeader) {
		
		switch (currentWidgetHeader) {
        case "Search":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_searchWidget_Sync, "visible");
            break;
        case "Pricing":
//        	browserHelper.syncOnElement(driver, Optimus_Hooks.oldLocatorLibrary.kalibrate_pricingWidget_RunRate, "visible");
        	// Switched to following for BP script on 04/05/2017
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_pricingWidget_Sync, "present");
        	
            break;
        case "Map":
        	if(Boolean.parseBoolean(Utils.getProperty("RELAX_MAP_VALIDATION")))
        		reporterHelper.log("Wiget has been identified as a MAP widget and RELAX_MAP_VALIDATION is set to true in config, therefore skipping title check");
        	else
        		BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_mapWidget_Sync, "present");
            break;
        case "Report Viewer":
        	BrowserHelper.syncOnElements(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_reportViewerWidget_Sync, "present");
            break;            
        case "Intel":
        	BrowserHelper.syncOnElements(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_intelWidget_Sync, "present");
            break;
        case "Multi Pricing":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_multiPricingWidget_Sync, "present");
            break;
        case "Getting Started":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_gettingStartedWidget_Sync, "university", "present");
        	break;
        case "Administrator":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_administratorWidget_Sync, "present");
        	break;        
        case "Data Manager":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_dataManagerWidget_Sync, "present");
        	break;
        case "Events Manager":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_eventsManagerWidget_Sync, "present");
        	break;
        case "Export Manager":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_exportManagerWidget_Sync, "present");
        	break;        	
        case "Site Manager":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_siteManagerWidget_Sync, "present");
        	break;        	
        case "Site Planner":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_sitePlannerWidget_Sync, "present");
        	break;        
        case "Market Pricing":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_marketPricingWidget_Sync, "present");
        	break;  
        case "Market Strategy":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_marketStrategyWidget_Sync, "present");
        	break;        	
        case "Price Requests":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_priceRequestsWidget_Sync, "present");
        	break;        	
        case "Site Strategy":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_siteStrategyWidget_Sync, "present");
        	break;    
            
        case "Batch Audit":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_batchAuditWidget_Sync, "present");
        	break;   
        case "Configuration":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_configurationWidget_Sync, "present");
        	break;   
        case "ETL Log":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_ETLLogWidget_Sync, "present");
        	break;   
        case "Import Log":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_importLogWidget_Sync, "present");
        	break;   
        case "Install Log":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_installLogWidget_Sync, "present");
        	break;   
        case "System Health Check":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_systemHealthCheckWidget_Sync, "present");
        	break;
        case "Notes":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_notesWidget_Sync, "present");
        	break;
        case "RSS Feed":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_RSSFeedWidget_Sync, "present");
        	break;
        case "To Do":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_toDoWidget_Sync, "present");
        	break;
        case "Twitter":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_twitterWidget_Sync, "present");
        	break;
        case "University":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_universityWidget_Sync, "present");
        	break;
        case "User Settings":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_userSettingsWidget_Sync, "present");
        	break;
        case "Competitor Surveys":
        	//TODO: finish this
//        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.oldLocatorLibrary.kalibrate_userSettingsWidget_Sync, "present");
        	break;
        case "Pump Price Update":
        	//TODO: finish this
//        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.oldLocatorLibrary.kalibrate_userSettingsWidget_Sync, "present");
        	break;       	
        case "Site Metrics":
        	BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_siteMetricsWidget_Sync, "present");
        	break;
        	
        case "Seven Elements of Fuel Retail Success":
        	// there are more than one widgets with this title so have to check for each
        	Boolean widgetIdentified = true;
        	int widgetCount = 0;
        	
        	if(BrowserHelper.isElementPresent(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_sevenElementsWidget_Sync)) {
        		BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_sevenElementsWidget_Sync, "present");
        		widgetIdentified = true;
        		widgetCount++;
        	}
        	if(BrowserHelper.isElementPresent(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_sevenElementsOtherWidget_Sync)) {
        		BrowserHelper.syncOnElement(driver, Optimus_Hooks.OLDLocatorLibrary.kalibrate_sevenElementsOtherWidget_Sync, "present");
        		widgetIdentified = true;
        		widgetCount++;
        	}
        	if(widgetIdentified)
        		reporterHelper.log("\nNumber of 'Seven Elements of Fuel Retail Success' widgets synched: " + widgetCount);
        	else
        		reporterHelper.error("'Seven Elements of Fuel Retail Success' widget(s) could not be synched");
        	break;
        	
        default:
        	reporterHelper.customFailScript("Invalid widget title '" + currentWidgetHeader + "' This is currently not supported by checkWidgetLoadComplete method - please update method.");
		}
		
	}	

}
