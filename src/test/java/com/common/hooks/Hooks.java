package com.common.hooks;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.common.helpers.BrowserHelper;
import com.common.helpers.DatabaseHelper;
import com.common.helpers.ReporterHelper;
import com.common.helpers.Utils;
import com.common.page_objects.Optimus_Generic_LocatorLibrary;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Hooks {

	public static ReporterHelper reporterHelper;
	public static DatabaseHelper databaseHelper;
	public static BrowserHelper browserHelper;
	
	public static AppiumDriver appiumDriver = null;
	public static WebDriver driver = null;
	
	public static Statement dbStatement;
	public static ResultSet dbResultSet;
	public static Connection dbConn;

	public static Statement priceNetDbStatement;
	public static ResultSet priceNetDbResultSet;
	public static Connection priceNetDbConn;
	
	public static String browserName;
	public static String applicationName;
	public static String testName;

	public static boolean browserAuthRequired;
	public static boolean useGrid;
	
	public static boolean nextTimeHA;
	public static boolean connectToDatabase;

	public String testRunDateTimeStamp;
	public String gridNodeURL = "NA";
	public String applicationURL;
	public static String applicationVersion;
	public static String applicationVersionSimplified;
	
	public static Optimus_Generic_LocatorLibrary optimusLocatorLibrary;
	
	
	private static String kssToken;
	
	private static ArrayList<String> desiredPersonasUsernameList;
	private static List<String> desiredPersonasList;
	
	public static String currentPersona = "";
	
	
	public Hooks() {
		loadConfig();
	}

	public void loadConfig() {
//		applicationName = Utils.getProperty("APPLICATION_NAME");
		System.out.println("applicationName: " + applicationName);
		browserName = Utils.getProperty("BROWSER_NAME");
		useGrid = Boolean.parseBoolean(Utils.getProperty("USE_GRID"));
		connectToDatabase = Boolean.parseBoolean(Utils.getProperty("CONNECT_TO_DATABASE"));	
		
//		
//		// Persona Stuff
//		String desiredPersonasItems = Utils.getProperty("PERSONAS_TO_CREATE");
//		desiredPersonasList = Arrays.asList(desiredPersonasItems.split("\\s*,\\s*"));
//		
//		desiredPersonasUsernameList = new ArrayList<String>();
//		
//		for (int j = 0; j < desiredPersonasList.size(); j++) {
//			// See if a credentials file has been provided, if not create username and use default password
//			if(Utils.getProperty("CREDENTIALS_FILE_PATH") == null) {
//				String tempUsername = System.getenv("COMPUTERNAME") + "_" + desiredPersonasList.get(j) + "_" + Utils.getProperty("AUTO_RUNNER_IDENTIFIER");
//				System.out.println("CREDENTIALS_FILE_PATH not proivided therefore creating username using format <COMPUTERNAME>_<PERSONA_NAME>_<AUTO_RUNNER_IDENTIFIER> : " + tempUsername);
//				
//				desiredPersonasUsernameList.add(tempUsername);
//			} else {
//				System.out.println("desiredPersonasList.get(" + j + "):" + desiredPersonasList.get(j));
//				String tempUsername = getCredentials(desiredPersonasList.get(j), "user");
//				System.out.println("username sourced from creds file: " + tempUsername);
//				desiredPersonasUsernameList.add(tempUsername);
//			}
//	    }
	}
	
	public boolean createDBConnectionJDBC() {

		// Create a variable for the connection string.
		String connectionString = Utils.getProperty("SQLSERVER_JDBC_CONNECT_STRING");
		
		System.out.println("\nCreating JDBC connection using: " + connectionString);
		
		try {
    		// Establish the connection.
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		dbConn = DriverManager.getConnection(connectionString);		
     	}
        
		// Handle any errors that may have occurred.
		catch (Exception e) {
			System.out.println("Exception caught attemptin to JDBC connect to DB: " + e.toString());
			return false;
		}
		
		System.out.println("\t...JDBC connection success!\n");
		
		return true;
	}

	
	public void setupDeviceDriver()  {	
		
		System.out.println("Launching Device Application...");

		// define the app to be sent to the device
		File app = new File("C:/Apps/KMobile/latest", "KalibrateMobile-debug.apk");

		// create and configure capabilities object to be used when creating device driver
		DesiredCapabilities capabilities = getDesiredCapabilities(app, Utils.getProperty("DEVICE_ID"));

		System.out.println("config.getProperty(\"APPIUM_URI\"):" + Utils.getProperty("APPIUM_URI"));
		
		// instantiate driver, installing and launching app on device (removing existing installations)
		try {
			appiumDriver = new AndroidDriver(new URL(Utils.getProperty("APPIUM_URI")), capabilities);
		} catch (MalformedURLException e) {
			reporterHelper.customFailScript("Exception caught creating appiumDriver:" + e.toString());
		}
		
		System.out.println("Contexts identified on device;");
		System.out.println("	" + appiumDriver.getContextHandles());
	}
	
	public void setupBrowserDriver()  {	

		if(Boolean.parseBoolean(Utils.getProperty("TERMINATE_PROCESSES_ON_INITIALISE"))) {
			System.out.println("Terminating any processes resident in memory...");
			killProcesses();
		}
		
		switch (Utils.getProperty("PLATFORM").toUpperCase()) {
			case "WINDOWS":
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/Drivers/BrowserDriverBinaries/Windows/Firefox/Latest/64 Bit/geckodriver.exe");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/Drivers/BrowserDriverBinaries/Windows/Chrome/Latest/chromedriver.exe");
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/src/test/resources/Drivers/BrowserDriverBinaries/Windows/IE/Latest/32 Bit/IEDriverServer.exe");
				break;
			case "LINUX":
				System.setProperty("webdriver.chrome.driver", Utils.getProperty("AUTOMATION_RESOURCES_DIRECTORY_PATH") + "/chromedriver");
				break;
			case "DOCKER":
				System.setProperty("webdriver.chrome.driver", Utils.getProperty("AUTOMATION_RESOURCES_DIRECTORY_PATH") + "/chromedriver.exe");
				break;
			case "IOS":
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/Drivers/BrowserDriverBinaries/iOS/Firefox/Latest/geckodriver");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/Drivers/BrowserDriverBinaries/iOS/Chrome/Latest/chromedriver");
				break;
		}
		
		if(useGrid) {
			gridNodeURL = Utils.getProperty("NODE_IDENTIFIER");
	        
	        DesiredCapabilities capabilities = null; 
	        		
			if (browserName.equalsIgnoreCase("FIREFOX")) {
				
		        capabilities = DesiredCapabilities.firefox();
		        capabilities.setBrowserName("firefox");	
		        
			}
			
			else if (browserName.equalsIgnoreCase("CHROME")) {
				
				// James added 10/07/2017
				BrowserHelper.customSleep(5 * 1000);
				
				ChromeOptions chromeDriverOptions = new ChromeOptions();

				if (Utils.getProperty("HEADLESS","false").equalsIgnoreCase("true")) {
					chromeDriverOptions.addArguments("--headless");
					chromeDriverOptions.addArguments("--no-sandbox");
					chromeDriverOptions.addArguments("--window-size="+Utils.getProperty("WINDOW_SIZE","1920,1200"));
				} else {
					chromeDriverOptions.addArguments("start-maximized");
				}
				
				chromeDriverOptions.addArguments("--disable-popup-blocking");
				chromeDriverOptions.addArguments("--disable-default-apps");
				chromeDriverOptions.addArguments("test-type=browser");
				chromeDriverOptions.addArguments("disable-infobars");
				
		        capabilities = DesiredCapabilities.chrome();
		        capabilities.setBrowserName("chrome");	
		        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeDriverOptions);
		 		        
			} else if (browserName.equalsIgnoreCase("IE")) {

		        capabilities = DesiredCapabilities.internetExplorer();

				capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
		        capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
				capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");

			}
			
	        try {
	        	System.out.println("Creating RemoteWebDriver with URL: " + gridNodeURL);
				driver = new RemoteWebDriver(new URL(gridNodeURL), capabilities);
			} catch (MalformedURLException e) {
				Assert.fail("MalformedURLException caught: " + e.toString());
			}
		}		
		else { // NOT USE_GRID
			
	        // Check whether proxy required
	        System.out.println("Checking whether Browser should use PROXY: " + Utils.getProperty("BROWSER_USE_PROXY"));
	        String PROXY;
			if(Boolean.parseBoolean(Utils.getProperty("BROWSER_USE_PROXY")))
				PROXY = Utils.getProperty("BRPOWSER_PROXY_STRING");
			else
				PROXY = null;//Utils.getProperty("");
			
			System.out.println("Browser PROXY will be set to: " + PROXY);

				
				
			if (browserName.equalsIgnoreCase("FIREFOX")) {
				FirefoxOptions firefoxOptions = new FirefoxOptions();

				// Create Proxy object and set properties
				org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
				if(Boolean.parseBoolean(Utils.getProperty("BROWSER_USE_PROXY"))) {
					proxy.setHttpProxy(PROXY)
				     .setFtpProxy(PROXY)
				     .setSslProxy(PROXY);

				}
				else
					proxy.setProxyType(ProxyType.AUTODETECT);
				
				firefoxOptions.setProxy(proxy);
				driver = new FirefoxDriver(firefoxOptions);
			}
			else if (browserName.equalsIgnoreCase("CHROME")) {
				ChromeOptions chromeDriverOptions = new ChromeOptions();

				if (Utils.getProperty("HEADLESS","false").equalsIgnoreCase("true")) {
					chromeDriverOptions.addArguments("--headless");
					chromeDriverOptions.addArguments("--no-sandbox");
					chromeDriverOptions.addArguments("--window-size="+Utils.getProperty("WINDOW_SIZE","1920,1200"));
				} else {
					chromeDriverOptions.addArguments("start-maximized");
				}
				
				chromeDriverOptions.addArguments("--disable-infobars");

				// Commented out following 3 on 17/01/2018 to try to minimise options and these don't appear to be required
				chromeDriverOptions.addArguments("--disable-popup-blocking");
				chromeDriverOptions.addArguments("--disable-default-apps");
				chromeDriverOptions.addArguments("test-type=browser");
				
//				System.out.println("\n\n$$$$ Adding ChromeOptions extension C:/Credentials.zip $$$$\n\n");
//				chromeDriverOptions.addExtensions(new File("C:/", "credentials.zip"));
		
		        // Enable browser logging if required
		        if(Boolean.parseBoolean(Utils.getProperty("EXTENDED_BROWSER_LOG_MONITORING"))) {
			        LoggingPreferences logPrefs = new LoggingPreferences();
			        logPrefs.enable(LogType.BROWSER, Level.ALL);
			        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
			        chromeDriverOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        		}
		        
		        System.out.println("Setting chromedriver option: CapabilityType.ACCEPT_SSL_CERTS, true");
		        chromeDriverOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		        chromeDriverOptions.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
		        
		        // Create Proxy object and set properties
				org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
				
				if(Boolean.parseBoolean(Utils.getProperty("BROWSER_USE_PROXY"))) {
					proxy.setHttpProxy(PROXY)
				     .setFtpProxy(PROXY)
				     .setSslProxy(PROXY);

				}
				else
					proxy.setProxyType(ProxyType.AUTODETECT);
				
				
				     
//				proxy.setAutodetect(true);
				
//				proxy.isAutodetect();
//				proxy.setProxyType(ProxyType.AUTODETECT);
//				proxy.setNoProxy("");
//				proxy.setHttpProxy("localhost:8888")
//			     .setFtpProxy("localhost:8888")
//			     .setSslProxy("localhost:8888");
				
				
				chromeDriverOptions.setCapability(CapabilityType.PROXY, proxy);
				chromeDriverOptions.setProxy(proxy);

				driver = new ChromeDriver(chromeDriverOptions);
			}
			else if (browserName.equalsIgnoreCase("IE")) {

				DesiredCapabilities ieDc = DesiredCapabilities.internetExplorer();
				

				org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
				if(Boolean.parseBoolean(Utils.getProperty("BROWSER_USE_PROXY"))) {
					proxy.setHttpProxy(PROXY)
				     .setFtpProxy(PROXY)
				     .setSslProxy(PROXY);

				}
				else
					proxy.setProxyType(ProxyType.AUTODETECT);
				
//				proxy.setNoProxy("DIRECT");
				
//				ieDc.setCapability(CapabilityType.ForSeleniumServer.AVOIDING_PROXY, true);
//				ieDc.setCapability(CapabilityType.ForSeleniumServer.ONLY_PROXYING_SELENIUM_TRAFFIC, true);
//				ieDc.setCapability(CapabilityType.ForSeleniumServer.PROXYING_EVERYTHING, false);
//				ieDc.setCapability("ie.usePerProcessProxy", true);
//				ieDc.setCapability("ie.setProxyByServer", true);
				ieDc.setCapability(CapabilityType.PROXY, proxy);
				
				ieDc.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
				

				driver = new InternetExplorerDriver(ieDc);
			}
			else if (browserName.equalsIgnoreCase("GRID")) {
		        gridNodeURL = Utils.getProperty("NODE_IDENTIFIER");
		        try {
					driver = new RemoteWebDriver(new URL(gridNodeURL), new ChromeOptions());
				} catch (MalformedURLException e) {
					Assert.fail("MalformedURLException caught: " + e.toString());
				}
			}		
		}

        // set driver behavior and initial state
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();	
        
        System.out.println("Browser Session ID: " + ((RemoteWebDriver) driver).getSessionId());
	}


	private void killProcesses() {
		
		Process p;
		BufferedReader inputStream;
		String s;
		
	    try {
	        p = Runtime.getRuntime().exec("taskkill /im chrome* /f");
	        inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));

	        // reading output stream of the command
	        while ((s = inputStream.readLine()) != null) {
	        	System.out.println(s);
	        }


	        p = Runtime.getRuntime().exec("taskkill /im geckodriver.exe /f");
	        inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));

	        // reading output stream of the command
	        while ((s = inputStream.readLine()) != null) {
	            System.out.println(s);
	        }
	        
	        
	        p = Runtime.getRuntime().exec("taskkill /im IEDriverServer.exe /f");
	        inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));

	        // reading output stream of the command
	        while ((s = inputStream.readLine()) != null) {
	            System.out.println(s);
	        }
	        
	        p = Runtime.getRuntime().exec("taskkill /im Firefox.exe /f");
	        inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));

	        // reading output stream of the command
	        while ((s = inputStream.readLine()) != null) {
	            System.out.println(s);
	        }
	        
	    } catch (Exception e) {
	    	reporterHelper.customFailScript("Exception caught: " + e.toString());
	    }
		
	}

	public void instantiateHelpers() {	
		
		// create reporterHelper for screenshots/logging
		reporterHelper = new ReporterHelper(this);

		// create databaseHelper
		databaseHelper = new DatabaseHelper(this);
		
		reporterHelper.initialise();
		
		// create browserHelper for synchronisation methods including bespoke
		browserHelper = new BrowserHelper(this);
		
	}


	public static void tidyDB() {

		reporterHelper.log("In Hooks.tidyDB(). Note this does not do anything yet for Optimus");
//		// Kalibrate Workspaces Tidyup
//		if(!Utils.getProperty("RUN_TYPE").equals("JENKINS")) {
//
//			reporterHelper.log("\tTidying Up Kalibrate WorkSpaces returning to known state - DEFAULT workspace as active");
//		
//			// TODO - maybe run all scripts in the defined directory?
//			
//			for (int j = 0; j < desiredPersonasList.size(); j++) {
////				databaseHelper.executeSQLFile("createDEFAULTWorkspace.sql", desiredPersonasUsernameList);
////				databaseHelper.executeSQLFile("tidyWorkspaces.sql", desiredPersonasUsernameList);
//
//				databaseHelper.executeSQLFile("createDEFAULTWorkspace.sql", desiredPersonasUsernameList);
//				databaseHelper.executeSQLFile("tidyWorkspaces.sql", desiredPersonasUsernameList);
//			}
//			
//		} else {
//			reporterHelper.log("\n************************************************************************************************************");
//			reporterHelper.log("\tTest was executed via Jenkins, therefore no DB connections are possible");
//			reporterHelper.log("\tNOTE: This is a temporary measure until a JENKINS/SQL Server authentication solution is found");
//			reporterHelper.log("************************************************************************************************************\n");
//		}

	}
    


	public void launchApplication()  {	
		
		reporterHelper.log("Attempting to source applicationURL from: " + applicationName + "_URL");
		applicationURL = getApplicationURL(applicationName + "_URL");

		
//		// Added 25/05/2017 to ensure browser has started correctly, due to intermittent issue in docker
//		reporterHelper.log("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//		reporterHelper.log("@@ Performing browser initial checks - Launching browser: " + applicationURL);
//		driver.get(applicationURL);
//		
//		By initialScreenElement = null;
//		
//		switch(applicationName) {
//		
//			case "KALIBRATE":
//				initialScreenElement = OLDLocatorLibrary.kalibrate_login_UsernameTextBox;
//				break;
//			case "OPTIMUS":
//				initialScreenElement = optimusLocatorLibrary.noddle_home_main_Header_1;
//				break;
//			}
//		
//		if (Utils.getProperty("AUTHENTICATION_METHOD").equalsIgnoreCase("FORMS")) {	
//			boolean browserInitSuccess = false;
//			
//			int retryCount=0;
//			while(!(browserInitSuccess = BrowserHelper.isElementDisplayed(driver, initialScreenElement)) && retryCount<10) {
//				reporterHelper.log("@@ Initial screen not yet displayed, retryCount: " + retryCount);
//				BrowserHelper.customSleep(1 * 1000);
//				retryCount++;
//			}
//			
//			if(!browserInitSuccess) {
//				reporterHelper.log("@@ Initial screen not displayed after " + retryCount + " attempts.  Refreshing browser and retrying");
//				reporterHelper.takeScreenshot(driver, "Login-Browser_Initialisation_Failed_After_" + retryCount + "_Retry_Attempts");
//				driver.navigate().refresh();
//				
//				retryCount=0;
//				while(!(browserInitSuccess = BrowserHelper.isElementDisplayed(driver, initialScreenElement)) && retryCount<10) {
//					reporterHelper.log("@@ Initial screen not yet displayed, retryCount: " + retryCount);
//					BrowserHelper.customSleep(1 * 1000);
//					retryCount++;
//				}
//			}
//			
//			if(!browserInitSuccess) {
//				reporterHelper.log("@@ Initial screen not displayed after refreshing and " + retryCount + " attempts.  Killing driver and restarting");
//				reporterHelper.takeScreenshot(driver, "Login-Browser_Initialisation_Failed_After_Refresh_And_" + retryCount + "_Retry_Attempts");
//				
//				driver = null;
//				setupBrowserDriver();
//				driver.get(applicationURL);
//				
//				retryCount=0;
//				while(!(browserInitSuccess = BrowserHelper.isElementDisplayed(driver, initialScreenElement)) && retryCount<10) {
//					reporterHelper.log("@@ Initial screen not yet displayed, retryCount: " + retryCount);
//					BrowserHelper.customSleep(1 * 1000);
//					retryCount++;
//				}
//			}
//	
//			if(browserInitSuccess) {
//				reporterHelper.takeScreenshot(driver, "Initial-Browser_Initialisation_Success");
//				reporterHelper.log("@@ Initial screen displayed, starting scenario execution...");
//			} else {
//				reporterHelper.takeScreenshot(driver, "Initial-Browser_Initialisation_Failed_After_Driver_Reinitialised");
//				// Could fail here but leaving test to start as usual and fail on login attaempt.
//			}
//		}
		
		reporterHelper.log("Launching browser: " + applicationURL);		
		
		// Launch Application        
	    driver.get("about:blank");

//	    reporterHelper.log("navigating to applicaiton...");
//	    reporterHelper.startTimer("Launch Application: " + applicationName);
//	    driver.get(applicationURL);
	    
	}

	private static DesiredCapabilities getDesiredCapabilities(File app, String DEVICE_ID) {

		System.out.println("\nConfiguring DesiredCapailities for: " + DEVICE_ID);
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		switch (DEVICE_ID) {
			case "PHYSICAL_7.1.1":
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ce061716437748120d7e"); 	
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
				break;
			case "EMULATED_4.0.4_15api_720x1280_267ppi":
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); 		
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.0.4");
				break;
			case "EMULATED_4.1.2_16api_720x1280_267ppi":
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); 			
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.1.2");
				break;
			case "EMULATED_4.2.2_16api_720x1280_267ppi":
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.2.2");
				break;
			case "EMULATED_4.3.1_16api_720x1280_267ppi":
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); 	
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.3.1");
				break;
			case "PHYSICAL_4.3_18api_720x1280_306ppi":
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "3230cd13d220805d"); 
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.3");
				break;
			case "EMULATED_4.4.2_19api_720x1280_267ppi":
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); 
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.2");
				break;
			case "PHYSICAL_4.4.2_19api_720x1280_267ppi":
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "4df179d60ec38fd7"); 
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.2");
				break;
			case "PHYSICAL_5.0_21api_1080x1920_432ppi":
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "9232d497"); 	
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0");
				break;
			case "EMULATED_5.0.2":
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); 
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0.2");
				break;
			case "PHYSICAL_5.1.1_22api_1080x1920_445ppi":
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "085953cd0c8583e9"); 
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
				break;
			case "EMULATED_5.1.1":
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); 
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
				break;
			case "EMULATED_6.0":
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); 
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
				break;
			case "PHYSICAL_6.0.1_23api_1080x1920_445ppi":
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "06c695490074fc29");
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
				break;
			case "PHYSICAL_7.0_24api_1080x1920_401ppi":
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "9196e33b"); 	
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
				break;
			case "EMULATED_7.0":
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); 
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
				break;				
			case "EMULATED_7.1":
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); 
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1");
				break;
		}
		capabilities.setCapability(MobileCapabilityType.APP, "com.android.calculator2");

		
		// note following method may not work when used for ios due to issue with absolute path returned 
		System.out.println("app.getPath() to: " + app.getPath());
		System.out.println("Setting capabilities MobileCapabilityType.APP to: " + app.getAbsolutePath());
		
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		// following is not required but used in output helperm may be reuqired for ios when implemented
//		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		return capabilities;
	}

	public static boolean performHttpRequestCheck(String personaName) {
		
		int responseCode = 0;
		
		// Do a call to GetUserSettings to establish if environment is ready for test

		reporterHelper.log("\n\n*******************************************************************");
		reporterHelper.log("* Doing http call to GetUserSettings to check ensure 200 response *");
		reporterHelper.log("*******************************************************************");
		
		
		String applicationURL = getApplicationURL("KALIBRATE_URL");
		
		reporterHelper.log("Utils.getProperty(\"KALIBRATE_URL\"): " + Utils.getProperty("KALIBRATE_URL"));
		reporterHelper.log("Utils.getProperty(\"PERSONAS_TO_CREATE\"): " + Utils.getProperty("PERSONAS_TO_CREATE"));
		
		String endPointUrl = "/useraccount/api/AccessControl/GetUserSettings";
		String requestMethod = "GET";

		String url = applicationURL + endPointUrl;
		
		reporterHelper.log("\nURL: " + url);
		
		HttpURLConnection con = null;

		try {
			URL obj = new URL(url);
			
            if (obj.getProtocol().toLowerCase().equals("https")) {
                trustAllHosts();
                HttpsURLConnection https = (HttpsURLConnection) obj.openConnection();
                https.setHostnameVerifier(DO_NOT_VERIFY);
                con = https;
            } else {
                con = (HttpURLConnection) obj.openConnection();
            }
            
			// set request method
			con.setRequestMethod(requestMethod);

            con.setDoInput(true);
            con.setDoOutput(true);

            String username = "";
            String password = "";

            reporterHelper.log("personaName: " + personaName);
            if(personaName.equals("DEFAULT_ADMINISTRATOR"))
            	username = Utils.getProperty("DEFAULT_ADMINISTRATOR_USERNAME");
            else
	        	username = (String) getCredentials(personaName, "user");
            
	        password = Utils.getProperty("DEFAULT_PASSWORD");

            reporterHelper.log("username: " + username);
            reporterHelper.log("password: " + password);
            
            String authStringEncoded = DatatypeConverter.printBase64Binary((username + ":" + password).getBytes());
            
            
			//add request headers
            con.setRequestProperty("Accept","application/json, text/plain, */*");
//            con.setRequestProperty("Accept-Encoding","gzip, deflate");
            con.setRequestProperty("Accept-Language","en-GB,en-US;q=0.9,en;q=0.8");
            con.setRequestProperty("Authorization","Basic " + authStringEncoded);
            con.setRequestProperty("Connection","keep-alive");
            con.setRequestProperty("Cookie","_hjIncludedInSample=1");
//            con.setRequestProperty("Host", "localhost");
            con.setRequestProperty("Referer", applicationURL);
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");

			responseCode = con.getResponseCode();
			
			
			
			reporterHelper.log("\nSending '" + requestMethod + "requestMethod' request to: " + url);
			reporterHelper.log("Response Code: " + responseCode);

			String inputLine;
			StringBuffer response = new StringBuffer();
			BufferedReader in = null;
			
			if(responseCode >= 400) {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			} else {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
		
			in.close();

			if(responseCode != 200) {
				//output result
				reporterHelper.log("response.toString(): " + response.toString());
				reporterHelper.log("");
				reporterHelper.log("");
				
				try {
					Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
					reporterHelper.log(gsonBuilder.toJson(new JsonParser().parse(response.toString())));
				} catch (Exception e) {
					// Do nothing
				}
				
				reporterHelper.customFailScriptNoHttpCheck("Call to GetUserSettings failed");
			} else {
				reporterHelper.log("Response Message: " + con.getResponseMessage());
				kssToken = con.getHeaderField("KSS-Token");
				reporterHelper.log("KSS-Token: " + kssToken);
			}
			
			
		} catch (Exception e) {
			reporterHelper.customFailScriptNoHttpCheck("Exception caught:" + e.toString());
		}
		
		reporterHelper.log("\n*******************************************************************");
		reporterHelper.log("* Finished doing http call to GetUserSettings.                    *");
		reporterHelper.log("*******************************************************************\n\n");

		return responseCode == 200;
	}
	


	
	public static String getApplicationURL(String string) {
		String applicationURL = Utils.getProperty(string);
		
		if (string != "KALIBRATE_URL" && StringUtils.trimToNull(applicationURL) == null) {
			reporterHelper.log("\tapplicationURL sourced is null therefore sourcing from: KALIBRATE_URL");
			applicationURL = getApplicationURL("KALIBRATE_URL");
			reporterHelper.log("\tapplicationURL sourced: " + applicationURL);
		}

//		// Add creds to URL if using windows auth
//		if (Utils.getProperty("AUTHENTICATION_METHOD").equalsIgnoreCase("WINDOWS")) {
//			reporterHelper.log("Need to pass username and password in URL: https://<username>:<password>@<application_url>");
//			
//			String splitMatchString = "://";
//			String newURL = "";
//			
//			List<String> urlSplit = Arrays.asList(applicationURL.split(splitMatchString));
//			
//			// If persona has not yet been set by Scenario step, default to first persona defined in config item PERSONAS_TO_CREATE
//			if(currentPersona.equals("")) {
//				currentPersona = desiredPersonasList.get(0);
//				reporterHelper.log("currentPersona currently not set, selecting first persona from available personas list: " + currentPersona);
//			}
//			
//			newURL += urlSplit.get(0);
//			newURL += splitMatchString;
//			newURL += getCredentials(currentPersona, "user").split("\\\\")[1];
//			newURL += ":";
//			newURL += getCredentials(currentPersona, "password");
//			newURL += "@";
//			newURL += urlSplit.get(1);
//			
//			applicationURL = newURL;
//		}
//		
//		applicationURL = applicationURL.replaceAll("\\\\", "\\\\\\\\");
		reporterHelper.log("applicationURL: " + applicationURL);
		
		return applicationURL;
	}

	public static void performHttpAddUser(String payload) {

		reporterHelper.log("\n\n*****************************************************************");
		reporterHelper.log("* Doing http call to AddUser *");
		reporterHelper.log("*****************************************************************");
		
		
		String applicationURL = getApplicationURL("KALIBRATE_URL");
		
		String endPointUrl = "/useraccount/api/AccessControl/AddUser";
		String requestMethod = "POST";

		String url = applicationURL + endPointUrl;
		
		reporterHelper.log("\nURL: " + url);
		
		HttpURLConnection con = null;
		
		try {
			URL obj = new URL(url);
			
            if (obj.getProtocol().toLowerCase().equals("https")) {
                trustAllHosts();
                HttpsURLConnection https = (HttpsURLConnection) obj.openConnection();
                https.setHostnameVerifier(DO_NOT_VERIFY);
                con = https;
            } else {
                con = (HttpURLConnection) obj.openConnection();
            }
            
			// set request method
			con.setRequestMethod(requestMethod);

            con.setDoInput(true);
            
            String adminUsername = Utils.getProperty("DEFAULT_ADMINISTRATOR_USERNAME");
            reporterHelper.log("adminUsername: " + adminUsername);

            String authStringEncoded = DatatypeConverter.printBase64Binary((adminUsername + ":" + kssToken).getBytes());

            reporterHelper.log("payloadString: " + payload);
            
			//add request headers
            con.setRequestProperty("Accept","application/json, text/plain, */*");
//            con.setRequestProperty("Accept-Encoding","gzip, deflate");
            con.setRequestProperty("Accept-Language","en-GB,en-US;q=0.9,en;q=0.8");
            con.setRequestProperty("Authorization","Basic " + authStringEncoded);
            con.setRequestProperty("Connection","keep-alive");
            con.setRequestProperty("Content-Length", Integer.toString(payload.length()));
            con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            con.setRequestProperty("Cookie", "_hjIncludedInSample=1");
//            con.setRequestProperty("Host", "localhost");
            con.setRequestProperty("locale", "en-US");
//            con.setRequestProperty("Origin", "http://773358-uststa02.cloud.kalibratetech.com");
            con.setRequestProperty("Referer", applicationURL);
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");

            con.setDoOutput(true);

            OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
            writer.write(payload);
            writer.close();
            
			int responseCode = con.getResponseCode();
			
			reporterHelper.log("\nSending '" + requestMethod + "' request to: " + url);
			reporterHelper.log("Response Code: " + responseCode);

			String inputLine;
			StringBuffer response = new StringBuffer();
			BufferedReader in = null;
			
			if(responseCode >= 400) {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			} else {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
		
			in.close();

			if(responseCode != 200) {
				//output result
				reporterHelper.log("response.toString(): " + response.toString());
				reporterHelper.log("");
				reporterHelper.log("");
				
				try {
					Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
					reporterHelper.log(gsonBuilder.toJson(new JsonParser().parse(response.toString())));
				} catch (Exception e) {
					// Do nothing
				}
				
				// Update cmn.User record to set TemporaryPassword to 0
				
			} else {
				reporterHelper.log("Response Message: " + con.getResponseMessage());
			}
			
		} catch (Exception e) {
			reporterHelper.customFailScript("Exception caught:" + e.toString());
		}
		
		
		
		reporterHelper.log("\n*****************************************************************");
		reporterHelper.log("* Finished doing http call to AddUser.                    *");
		reporterHelper.log("*****************************************************************\n\n");
	}	
	
	public static void deleteThenAddNewUsersViaHttpRequest() {
	
        reporterHelper.log("deleting then creating users for the following personas: " + desiredPersonasList);

        JSONArray jsonArray = performHttpGetAllUsers();
        
        // delete users
        for (int i = 0 ; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String userName = jsonObject.getString("userName");
            
            if(desiredPersonasUsernameList.contains(userName)) {
            	reporterHelper.log("userName '" + userName + "' identified, calling DeleteUser: " + jsonObject.toString());
            	performHttpDeleteUser(jsonObject.toString());
            }
        }

        // add users
		for (int j = 0; j < desiredPersonasUsernameList.size(); j++) {
			
			String tempTargetPassword = Utils.getProperty("DEFAULT_PASSWORD");
			
//			// If a credentials file has been provided then source password from that
//			if(!Utils.getProperty("CREDENTIALS_FILE_PATH").equals(""))
//				tempTargetPassword = getCredentials(desiredPersonasList.get(j), "password");
			
			String tempUsername = desiredPersonasUsernameList.get(j);
			
			// Replace \ with \\ as required
			tempUsername = tempUsername.replaceAll("\\\\", "\\\\\\\\");

			String payloadString = "{'userName':'" + tempUsername + "','fullName':'','password':'" + tempTargetPassword + "','passwordConfirmation':'" + tempTargetPassword + "','preferredLanguage':'en-US','preferredDistanceUnit':'imperial','profileId':1,'isNew':true}";
                    
			performHttpAddUser(payloadString);
	    }
  

		if(connectToDatabase)
			tidyDB();
		
		// check first persona created successfully
		
		String tempPersonasList = Utils.getProperty("PERSONAS_TO_CREATE");
		reporterHelper.log("tempPersonasList: " + tempPersonasList);
		String firstPersonaCreated;
		
		if(tempPersonasList.contains(","))
			firstPersonaCreated = tempPersonasList.split(",")[0];
		else
			firstPersonaCreated = tempPersonasList;
			
		reporterHelper.log("Calling performHttpRequestCheck for user: " + firstPersonaCreated);
		performHttpRequestCheck(firstPersonaCreated);

	}

	public static JSONArray performHttpGetAllUsers() {

		JSONArray jsonArray = null;
		
		reporterHelper.log("\n\n*****************************************************************");
		reporterHelper.log("* Doing http call to GetAllUsers *");
		reporterHelper.log("*****************************************************************");
		
		
		String applicationURL = getApplicationURL("KALIBRATE_URL");
		
		String endPointUrl = "/useraccount/api/AccessControl/GetAllUsers";
		String requestMethod = "GET";

		String url = applicationURL + endPointUrl;
		
		reporterHelper.log("\nURL: " + url);
		
		HttpURLConnection con = null;
		
		try {
			URL obj = new URL(url);
			
            if (obj.getProtocol().toLowerCase().equals("https")) {
                trustAllHosts();
                HttpsURLConnection https = (HttpsURLConnection) obj.openConnection();
                https.setHostnameVerifier(DO_NOT_VERIFY);
                con = https;
            } else {
                con = (HttpURLConnection) obj.openConnection();
            }
            
			// set request method
			con.setRequestMethod(requestMethod);

            con.setDoInput(true);
            con.setDoOutput(true);
            
            String adminUsername = Utils.getProperty("DEFAULT_ADMINISTRATOR_USERNAME");
            String authStringEncoded = DatatypeConverter.printBase64Binary((adminUsername + ":" + kssToken).getBytes());
            
            reporterHelper.log("adminUsername: " + adminUsername);

			//add request headers
            con.setRequestProperty("Accept","application/json, text/plain, */*");
//            con.setRequestProperty("Accept-Encoding","gzip, deflate");
            con.setRequestProperty("Accept-Language","en-GB,en-US;q=0.9,en;q=0.8");
            con.setRequestProperty("Authorization","Basic " + authStringEncoded);
            con.setRequestProperty("Connection","keep-alive");
            con.setRequestProperty("Cookie","_hjIncludedInSample=1");
//            con.setRequestProperty("Host", "localhost");
            con.setRequestProperty("locale", "en-US");
            con.setRequestProperty("Referer", applicationURL);
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");

			int responseCode = con.getResponseCode();
			
			reporterHelper.log("\nSending '" + requestMethod + "' request to: " + url);
			reporterHelper.log("Response Code: " + responseCode);
		    
			
			
		    try {
				String inputLine;
				StringBuilder response = new StringBuilder();
				BufferedReader in = null;
				
				if(responseCode >= 400) {
					in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				} else {
					in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				}
				
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
			
				reporterHelper.log("Response: " + response.toString());
				
		    	jsonArray = new JSONArray(response.toString());

		    } catch (IOException e) {
		    	reporterHelper.customFailScript("JSON -> Can't read Stream : IO Exception");
		    } 
		}
		catch (Exception e) {
			reporterHelper.customFailScript("Exception caught creating http connection:" + e.toString());
		}
		
		reporterHelper.log("\n*****************************************************************");
		reporterHelper.log("* Finished doing http call to GetAllUsers.                    *");
		reporterHelper.log("*****************************************************************\n\n");
		
		return jsonArray;
	}
	
	public static void performHttpDeleteUser(String payload) {
		

		reporterHelper.log("\n\n*****************************************************************");
		reporterHelper.log("* Doing http call to DeleteUser *");
		reporterHelper.log("*****************************************************************");
		
		
		String applicationURL = getApplicationURL("KALIBRATE_URL");
		
		String endPointUrl = "/useraccount/api/AccessControl/DeleteUser";
		String requestMethod = "POST";

		String url = applicationURL + endPointUrl;
		
		reporterHelper.log("\nURL: " + url);
		
		HttpURLConnection con = null;
		
		try {
			URL obj = new URL(url);
			
            if (obj.getProtocol().toLowerCase().equals("https")) {
                trustAllHosts();
                HttpsURLConnection https = (HttpsURLConnection) obj.openConnection();
                https.setHostnameVerifier(DO_NOT_VERIFY);
                con = https;
            } else {
                con = (HttpURLConnection) obj.openConnection();
            }
            
			// set request method
			con.setRequestMethod(requestMethod);

            con.setDoInput(true);
            
            String adminUsername = Utils.getProperty("DEFAULT_ADMINISTRATOR_USERNAME");

            String authStringEncoded = DatatypeConverter.printBase64Binary((adminUsername + ":" + kssToken).getBytes());

            
            String payloadString = payload;
            
			//add request headers
            con.setRequestProperty("Accept","application/json, text/plain, */*");
//            con.setRequestProperty("Accept-Encoding","gzip, deflate");
            con.setRequestProperty("Accept-Language","en-GB,en-US;q=0.9,en;q=0.8");
            con.setRequestProperty("Authorization","Basic " + authStringEncoded);
            con.setRequestProperty("Connection","keep-alive");
            con.setRequestProperty("Content-Length", Integer.toString(payloadString.length()));
            con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            con.setRequestProperty("Cookie", "_hjIncludedInSample=1");
//            con.setRequestProperty("Host", "localhost");
            con.setRequestProperty("locale", "en-US");
//            con.setRequestProperty("Origin", "http://773358-uststa02.cloud.kalibratetech.com");
            con.setRequestProperty("Referer", applicationURL);
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");

            con.setDoOutput(true);

            OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
            writer.write(payloadString);
            writer.close();
            
			int responseCode = con.getResponseCode();
			
			reporterHelper.log("\nSending '" + requestMethod + "' request to: " + url);
			reporterHelper.log("Response Code: " + responseCode);

			String inputLine;
			StringBuffer response = new StringBuffer();
			BufferedReader in = null;
			
			if(responseCode >= 400) {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			} else {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
		
			in.close();

			if(responseCode != 204) {
				//output result
				reporterHelper.log("response.toString(): " + response.toString());
				reporterHelper.log("");
				reporterHelper.log("");
				
				try {
					Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
					reporterHelper.log(gsonBuilder.toJson(new JsonParser().parse(response.toString())));
				} catch (Exception e) {
					// Do nothing
				}
			} else {
				reporterHelper.log("Response Message: " + con.getResponseMessage());
			}
			
			
		} catch (Exception e) {
			reporterHelper.customFailScript("Exception caught:" + e.toString());
		}
		
		reporterHelper.log("\n*****************************************************************");
		reporterHelper.log("* Finished doing http call to DeleteUser.                    *");
		reporterHelper.log("*****************************************************************\n\n");
	}


    private static void trustAllHosts() {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[] {};
            }

			@Override
			public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
				// TODO Auto-generated method stub
				
			}
        } };

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
        	reporterHelper.customFailScript("Exception in method trustAllHosts setting SSL:" + e.toString());
        }
    }
    
    final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {

		@Override
		public boolean verify(String hostname, SSLSession session) {
			// TODO Auto-generated method stub
			return true;
		}
    };
    
	public static String getCredentials(String personaName, String credsField) {

    	JSONParser parser = new JSONParser();
    	JSONObject jsonObject;
    	JSONArray jsonArray;
    	JSONObject credsJsonObject = null;
    	boolean success = false;
    	String returnString  = "";

    	String environmentName =  Utils.getProperty("ENVIRONMENT");
    	System.out.println("environment: '" + environmentName + "'");

    	String compositePersonaName;
    	
    	if(environmentName.length() == 0)
    		compositePersonaName = personaName;
    	else
    		compositePersonaName = environmentName + "_" + personaName;
    	
    			
    	String personaFilePath =  Utils.getProperty("CREDENTIALS_FILE_PATH");

    	System.out.println("Looking for credentials for persona " + compositePersonaName + " in credentials file: " + personaFilePath);
    	System.out.println();
    	
    	if(!(StringUtils.trimToNull(personaFilePath) == null) ) {
    		
    		FileReader fr = null;
			try {
				fr = new FileReader(personaFilePath);
				
				List<String> fileData = new ArrayList<String>();
			    BufferedReader reader = new BufferedReader(fr);
			    String line;
			    while ((line = reader.readLine()) != null)
			    {
			    	System.out.println(line);
			    }
			    System.out.println();
			    reader.close();
			    
			    fr = new FileReader(personaFilePath);
				    
			} catch (FileNotFoundException e1) {
				System.out.println("FileNotFoundException caught reading credentials file: " + e1.toString());
				Assert.fail();
			} catch (IOException e2) {
				System.out.println("IOException caught reading credentials file: " + e2.toString());
				Assert.fail();
			}
    		

    		Object obj = null;
			try {
				obj = parser.parse(fr);
			} catch (IOException e) {
				System.out.println("IOException caught reading credentials file: " + e.toString());
				Assert.fail();
			} catch (ParseException e) {
				System.out.println("ParseException caught reading credentials file: " + e.toString());
				Assert.fail();
			}

			jsonObject= new JSONObject( obj.toString());
	    		
    	    JSONArray usersArray = jsonObject.getJSONArray("users");

    	    		
    	    for (int i = 0; i < usersArray.length(); i++) {
    	        JSONObject jsonObjectRow = (JSONObject) usersArray.get(i);
    	        String credsPersona = (String) jsonObjectRow.get("persona");
    	        
    	        System.out.println("credsPersona: " + credsPersona);
    	        
    	        if(credsPersona.equalsIgnoreCase(compositePersonaName)) {
    	        	credsJsonObject = jsonObjectRow;
    	        	
    	        	System.out.println("\nCredentials JSON Object identified in creds file: " + credsJsonObject.toString());
    	        	System.out.println("CredsJsonObject.getString(\"password\"): " + credsJsonObject.getString("password"));
    	        	success = true;
    	        	break;
    	        }
    	    }
	
	    	if(!success) {
	    		System.out.println("unable to find credentials for persona '" + compositePersonaName + "' in credentials file: " + personaFilePath);
	    		Assert.fail();
	    	}
	    	
	    	returnString = credsJsonObject.getString(credsField);
    	} else {
    		if(credsField.equalsIgnoreCase("username")) 
    			returnString = System.getenv("COMPUTERNAME") + "_" + compositePersonaName + "_" + Utils.getProperty("AUTO_RUNNER_IDENTIFIER");
    		else if(credsField.equalsIgnoreCase("password"))
    			returnString = System.getenv("DEFAULT_PASSWORD");
    	}
    	
//    	if(credsField.equalsIgnoreCase("password")) 
//    		returnString = System.getenv("DEFAULT_PASSWORD");
    	
    	return returnString;
	}
}

