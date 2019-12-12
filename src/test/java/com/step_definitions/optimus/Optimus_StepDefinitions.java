package com.step_definitions.optimus;

import java.sql.ResultSet;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


import com.common.helpers.BrowserHelper;
import com.common.helpers.DatabaseHelper;
import com.common.helpers.ReporterHelper;
import com.common.helpers.Utils;
import com.common.hooks.Hooks;
import com.common.page_objects.Optimus_Generic_LocatorLibrary;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.joda.time.*;
import org.joda.time.format.*;

public class Optimus_StepDefinitions {
	
	// Class variables
	private static boolean performSync = true;

	private ReporterHelper reporterHelper = Optimus_Hooks.reporterHelper;
	private BrowserHelper browserHelper = Optimus_Hooks.browserHelper;
	private Optimus_Generic_LocatorLibrary optimusLocatorLibrary = Optimus_Hooks.optimusLocatorLibrary;
	
	private String applicationName = Optimus_Hooks.applicationName;

	private WebDriver driver = Optimus_Hooks.driver;
	
	private WebElement tempWebElement;

	private String strFirstWindowHandle;

	
	@Before
	public void initialise() {
		System.out.println("In Optimus_StepDefinitions.initialise() method");
	}



	private void callURLWithWindowsAuthCreds(String persona) {
		
		Hooks.currentPersona = persona;
		
		driver.get(Hooks.getApplicationURL(applicationName + "_URL"));
		
	}

	
    /**
     * Used to drag widget icon from the selected site in the
     * Search widget.
     * 
     * @param newWidgetIdentifierString is the name of the widget icon 
     * 			that should be dragged. Example is <code>Pricing</code>
     *          
     * @param targetContainer is the container number. Example is <code>2</code> 
     * 
     */
	
	@When("^a '(.*)' valid username and valid password are submitted to ck$")
	public void aPersonaNameValidUsernameAndValidPasswordAreEntered(String persona) {
		
//		String tempString = setPersonaIdentifier(persona);
		String tempString = persona;
	
        // Enter Valid Password
//      String tempPassword = Utils.getProperty("DEFAULT_PASSWORD");
      String tempPassword = Hooks.getCredentials(tempString, "password");
      BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_login_main_Password_TextBox, "clickable").sendKeys(tempPassword);
      reporterHelper.log("Password entered Successfully: " + tempPassword);
      
		// Enter Valid Username
		String tempUsername = Hooks.getCredentials(tempString, "username");
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_login_main_Username_TextBox, "clickable").sendKeys(tempUsername);
        reporterHelper.log("Username entered Successfully: " + tempUsername);


        
        reporterHelper.takeScreenshot(driver, "Login-Populated");
        
        theLoginButtonIsClicked("Login");

	}

	
	@When("^the Login button is clicked$")
	public void theLoginButtonIsClicked() {

		theLoginButtonIsClicked("Login");
		
	}

	public void theLoginButtonIsClicked(String timerName) {

		if(timerName == null)
			timerName = "Login";
		
		// Submit the form 
		
		tempWebElement = BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_generic_main_Login_Button, "clickable");
        reporterHelper.startTimer(timerName);
        
        tempWebElement.click();
        
        reporterHelper.log("\nButton clicked Successfully, syncing with Optmius summary page...");
	}
	

	
	@Given("^the ck home page is displayed$")
	public void theckHomePageIsDisplayed() throws Throwable {

		// Check if browser is already at ck login page
		if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.ck_home_main_Header_1, 3)) {
			reporterHelper.log("ck home page already displayed");
			reporterHelper.takeScreenshot(driver, "General-Optimus_ck_Main_Page_Displayed");
		} else {
		
			// Open ck URL
			String environmentName = Utils.getProperty("ENVIRONMENT");
			browserHelper.openURL(Utils.getProperty(environmentName + "_CREDITKARMA_URL"));
			
		}
		
		// Check if popup messages displayed on login and close if necessary
		if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.ck_generic_lighbox_popup, 5)) {
			reporterHelper.log("ck home page displayed");
			reporterHelper.takeScreenshot(driver, "General-Optimus_Login_Popup_Displayed");
			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_generic_lighbox_popup_close_link, "displayed").click();;
		}
		
		reporterHelper.log("ck home page displayed and in correct state for Login");
		reporterHelper.takeScreenshot(driver, "General-Optimus_Home_Page_Displayed");

		// Check if cookies messages displayed and accept if necessary
		acceptckCookiesIfAsked();
	}
	
	private void acceptckCookiesIfAsked() {
		
		if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.ck_generic_cookies_acceptCookies_Button, 5)) {
			reporterHelper.log("ck Accept Cookies message displayed, clicking Accept cookeis...");
			reporterHelper.takeScreenshot(driver, "General-Optimus_AcceptCookies_Displayed");
			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_generic_cookies_acceptCookies_Button, "clickable").click();
		}
		
	}


	@Then ("^User is returned to the ck home page$") 
	public void userIsReturnedToTheHomePage() {
		
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_home_main_Header_1, "visible");
        
		reporterHelper.stopTimer("Click Logout to home page");

	    reporterHelper.log("Logged out Successfully");
		reporterHelper.log("User returned to home page successfully");
		
		BrowserHelper.customSleep(5 * 1000);
		BrowserHelper.checkForConsoleErrors();
	}	
	
	
	@When("^the '(.*)' button is clicked in the ck header$")
	public void theLogInButtonIsClickedInTheckHeader(String buttonName) throws Throwable {
		
		switch(buttonName) {
    	case "Log in":
    		tempWebElement = BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_generic_header_Login_Button, "present");
			break;
    	case "Log out":
    		tempWebElement = BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_generic_header_LogOut_Button, "present");
			break;
	    default:
	        reporterHelper.customFailScript("Unknown buttonName name in method theLogInButtonIsClickedInTheHeader: " + buttonName);
		}
		
		reporterHelper.startTimer("Click Logout to home page");
		
		tempWebElement.click();
	}
	
	@Then("^the ck 'Log In' page should be displayed$")
	public void theLogInPageShouldBeDisplayed() throws Throwable {
		
		if(performSync)
			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_login_main_Username_TextBox, "present");

		reporterHelper.log("ck Log in page displayed");
		reporterHelper.takeScreenshot(driver, "General-Optimus_Log_In_Page_Displayed");

	}

	@Given("^the Supplier Portal URL is submitted$")
	public void theSupplierPortalURLIsSubmitted() throws Throwable {
		
		// Open Supplier Portal URL
		String environmentName = Utils.getProperty("ENVIRONMENT");
		browserHelper.openURL(Utils.getProperty(environmentName + "_NUMEROSUPPLIERPORTAL_URL"));
	
	}
	
	
	@Given("^any Supplier Portal logon screens are navigated$")
	public void anySupplierPortalLogonScreensAreNavigated() throws Throwable {

		Boolean logonSuccess = false;
		
		// In a loop for MAX_SYNC_RETRIES, check for and progress any logon screens
		// and exit loop once Supplier Portal TBC is displayed
		for (int i = 0; i < Integer.parseInt(Utils.getProperty("MAX_SYNC_RETRIES")); i++) {
			
			BrowserHelper.customSleep(5 * 1000);
			
			// Check for expected browser certificate problem page
			if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.generic_securityCertificateProblem_Contimue_Link, 1)) {
				reporterHelper.log("Browser Certificate Problem page identified, clickimng continue link");
				reporterHelper.takeScreenshot(driver, "General-Browser_Certificate_Problem_Page_Displayed");
				
				BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.generic_securityCertificateProblem_Contimue_Link, "present").click();
			}
			
			// Check for acceptance page
			if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.supplierPortal_AcceptancePage_SignIn_Button, 1)) {
				BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_AcceptancePage_SignIn_Button, "present");
				reporterHelper.log("Supplier Portal SIgn In page identified");
				reporterHelper.takeScreenshot(driver, "SupplierPortal-AcceptancePage-Initial_View");
				
				// Click Sign In to show acceptance
				tempWebElement = BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_AcceptancePage_SignIn_Button, "present");
				reporterHelper.log("Clicking Sign In button to show acceptance...");
				tempWebElement.click();
				
				// Sync On Microsoft Online login page
				BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_MicrosoftOnline_TransUnion_Image, "present");
				reporterHelper.takeScreenshot(driver, "SupplierPortal-MicrosoftOnline-Initial_View");
				
				reporterHelper.log("Clicking on Use Another Account field if present");
				if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.supplierPortal_MicrosoftOnline_UseAnotherAccount_Field, 1)) {
					BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_MicrosoftOnline_UseAnotherAccount_Field, "present").click();
				}
				
				reporterHelper.takeScreenshot(driver, "SupplierPortal-MicrosoftOnline-Before_Populated");
				
				// Hardcode Persona for Call Report
				String persona = "Numero Supplier Portal User";

				String tempUsername = Hooks.getCredentials(persona, "username");
				BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_MicrosoftOnline_Username_Field, "present").sendKeys(tempUsername);
		        reporterHelper.log("Call Report Username entered Successfully: " + tempUsername);

		        // Enter Valid Password
				String tempPassword = Hooks.getCredentials(persona, "password");
				BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_MicrosoftOnline_Password_Field, "present").sendKeys(tempPassword);
				reporterHelper.log("Call Report Password entered Successfully: " + tempPassword);
		      
				reporterHelper.takeScreenshot(driver, "SupplierPortal-MicrosoftOnline-Populated");

				// Click Login
				BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_MicrosoftOnline_SignIn_Button, "present").click();

			}

			if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.supplierPortal_DisputePortalHome_Heading, 1)) {
				reporterHelper.log("Dispute Portal Home Page Identified - breaking out of loop as all logon screens navgated or skipped...");
				break;
			}
			
		}
	}
	
	@When("^Log Out is selected from Supplier Portal Menu$")
	public void logOutIsSelectedFromSupplierPortalMenu() throws Throwable {
		// Click Menu Hamburger Icon
		reporterHelper.log("Clicking Burger Icon");
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_DisputePortalHome_Burger_Link, "present").click();
		reporterHelper.takeScreenshot(driver, "SupplierPortal-DisputePortalHome-Menu_Burger_Clicked");
		
		// Click Signout
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_DisputePortalHome_Menu_SignOut_Link, "present").click();
		

	}
	
	@Then("^user is logged out of Supplier Portal$")
	public void userIsLoggedOutOfSupplierPortal() throws Throwable {
//		// Sync on Acceptance Page
//		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_AcceptancePage_SignIn_Button, "present");
//		reporterHelper.log("Supplier Portal SIgn In page identified - Log out confirmed");
//		reporterHelper.takeScreenshot(driver, "SupplierPortal-AcceptancePage-Logged_Out");

//		// Sync on LOgged Out  Page
//		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_LoggedOut_Logged_Out_Text, "present");
//		reporterHelper.log("Supplier Portal Logged Out page identified");
//		reporterHelper.takeScreenshot(driver, "SupplierPortal-LoggedOutPage-Initial_View");

		BrowserHelper.customSleep(10 * 1000);
		reporterHelper.takeScreenshot(driver, "SupplierPortal-LoggedOut");
	}
	
	@Then("^the Supplier Portal Welcome page is displayed$")
	public void theSupplierPortalWelcomePageIsDisplayed() throws Throwable {
		// Sync on the Dispute Portal Home Page
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_DisputePortalHome_Heading, "present");
		reporterHelper.log("Dispute Portal Home Page Identified");
		reporterHelper.takeScreenshot(driver, "SupplierPortal-DisputePortalHome-Initial_View");
	}	
	
	
	@Given("^the Supplier Portal Sign In page is displayed$")
	public void theSupplierPortalSignInPageIsDisplayed() throws Throwable {

		// Open Supplier Portal URL
		String environmentName = Utils.getProperty("ENVIRONMENT");
		browserHelper.openURL(Utils.getProperty(environmentName + "_NUMEROSUPPLIERPORTAL_URL"));
		
		// Check for expected browser certificate problem page
		if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.generic_securityCertificateProblem_Contimue_Link, 3)) {
			reporterHelper.log("Browser Certificate Problem page identified, clickimng continue link");
			reporterHelper.takeScreenshot(driver, "General-Browser_Certificate_Problem_Page_Displayed");
			
			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.generic_securityCertificateProblem_Contimue_Link, "present").click();
		}
		
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_AcceptancePage_SignIn_Button, "present");
		reporterHelper.log("Supplier Portal SIgn In page identified");
		reporterHelper.takeScreenshot(driver, "SupplierPortal-AcceptancePage-Initial_View");
		
		// Below to go in separate method
		
		// Click Sign In to show acceptance
		tempWebElement = BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_AcceptancePage_SignIn_Button, "present");
		reporterHelper.log("Clicking Sign In button to show acceptance...");
		tempWebElement.click();
		
		// Sync On Microsoft Online login page
//		reporterHelper.log("Clicking Sign In button to show acceptance...");
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_MicrosoftOnline_TransUnion_Image, "present");
		reporterHelper.takeScreenshot(driver, "SupplierPortal-MicrosoftOnline-Initial_View");
		
		reporterHelper.log("Clicking on Use Another Account field if present");
		if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.supplierPortal_MicrosoftOnline_UseAnotherAccount_Field, 1)) {
			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_MicrosoftOnline_UseAnotherAccount_Field, "present").click();
		}
		
		reporterHelper.takeScreenshot(driver, "SupplierPortal-MicrosoftOnline-Before_Populated");
		
		// Hardcode Persona for Call Report
		String persona = "Numero Supplier Portal User";

		String tempUsername = Hooks.getCredentials(persona, "username");
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_MicrosoftOnline_Username_Field, "present").sendKeys(tempUsername);
        reporterHelper.log("Call Report Username entered Successfully: " + tempUsername);

        // Enter Valid Password
		String tempPassword = Hooks.getCredentials(persona, "password");
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_MicrosoftOnline_Password_Field, "present").sendKeys(tempPassword);
		reporterHelper.log("Call Report Password entered Successfully: " + tempPassword);
      
		reporterHelper.takeScreenshot(driver, "SupplierPortal-MicrosoftOnline-Populated");

		// Click Login
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_MicrosoftOnline_SignIn_Button, "present").click();
		
		// Sync on the Dispute Portal Home Page
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_DisputePortalHome_Heading, "present");
		reporterHelper.log("Dispute Portal Home Page Identified");
		reporterHelper.takeScreenshot(driver, "SupplierPortal-DisputePortalHome-Initial_View");
		
		// Click Menu Hamburger Icon
		reporterHelper.log("Clicking Burger Icon");
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_DisputePortalHome_Burger_Link, "present").click();
		reporterHelper.takeScreenshot(driver, "SupplierPortal-DisputePortalHome-Menu_Burger_Clicked");
		
		// Click Signout
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_DisputePortalHome_Menu_SignOut_Link, "present").click();
		
//		// Sync on Acceptance Page
//		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_AcceptancePage_SignIn_Button, "present");
//		reporterHelper.log("Supplier Portal SIgn In page identified - Log out confirmed");
//		reporterHelper.takeScreenshot(driver, "SupplierPortal-AcceptancePage-Logged_Out");

//		// Sync on LOgged Out  Page
//		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.supplierPortal_LoggedOut_Logged_Out_Text, "present");
//		reporterHelper.log("Supplier Portal Logged Out page identified");
//		reporterHelper.takeScreenshot(driver, "SupplierPortal-LoggedOutPage-Initial_View");

		BrowserHelper.customSleep(10 * 1000);
		reporterHelper.takeScreenshot(driver, "SupplierPortal-LoggedOut");
	}
	
	@Given("^the Call Report Login page is displayed$")
	public void theCallReportLoginPageIsDisplayed() throws Throwable {

		// Open Call Report URL
		String environmentName = Utils.getProperty("ENVIRONMENT");
		browserHelper.openURL(Utils.getProperty(environmentName + "_CALLREPORT_URL"));
		
		// Check for expected browser certificate problem page
		if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.generic_securityCertificateProblem_Contimue_Link, 3)) {
			reporterHelper.log("Browser Certificate Problem page identified, clickimng continue link");
			reporterHelper.takeScreenshot(driver, "General-Browser_Certificate_Problem_Page_Displayed");
			
			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.generic_securityCertificateProblem_Contimue_Link, "present").click();
		}
		
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.callReport_logon_Heading, "present");
		reporterHelper.log("Call Report logon page identified");
		reporterHelper.takeScreenshot(driver, "CallReport-Login-Initial_View");
		
	}
	
	@When("^valid credentials are submitted to Call Report$")
	public void validCredentialsAreSubmittedToCallReport() throws Throwable {

		// Hardcode Persona for Call Report
		String persona = "Call Report User";

		String tempCompany = Hooks.getCredentials(persona, "company");
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.callReport_logon_companyName_TextBox, "present").sendKeys(tempCompany);
        reporterHelper.log("Call Report Compamy entered Successfully: " + tempCompany);

        
		String tempUsername = Hooks.getCredentials(persona, "username");
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.callReport_logon_userName_TextBox, "present").sendKeys(tempUsername);
        reporterHelper.log("Call Report Username entered Successfully: " + tempUsername);

        // Enter Valid Password
		String tempPassword = Hooks.getCredentials(persona, "password");
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.callReport_logon_password_TextBox, "present").sendKeys(tempPassword);
		reporterHelper.log("Call Report Password entered Successfully: " + tempPassword);
      
        reporterHelper.takeScreenshot(driver, "CallReport-Login-Populated");

		// Click Login
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.callReport_logon_Login_Button, "present").click();

	}
	

	
	@Given("^the Ginger Sign In page is displayed$")
	public void theGingerSignInPageIsDisplayed() throws Throwable {

		// Check if browser is already at Ginger login page
		if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.ginger_logon_Heading, 3)) {
			reporterHelper.log("Ginger logon page already displayed");
			reporterHelper.takeScreenshot(driver, "General-Optimus_Ginger_Logon_Page_Displayed");
		} else {
		
			// Open Ginger URL
			String environmentName = Utils.getProperty("ENVIRONMENT");
			browserHelper.openURL(Utils.getProperty(environmentName + "_GINGER_URL"));
			
		}
		
		// Sync on Ginger Administration Panel Heading
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ginger_logon_Heading, "present");
	}


	
	@When("^a '(.*)' valid username and valid password are submitted to Ginger$")
	public void aPersonaNameValidUsernameAndValidPasswordAreSubmittedToGinger(String persona) {
		
		// Enter Valid Username
		String tempUsername = Hooks.getCredentials(persona, "username");
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ginger_logon_username_TextBox, "present").sendKeys(tempUsername);
        reporterHelper.log("Ginger Username entered Successfully: " + tempUsername);

        // Enter Valid Password
		String tempPassword = Hooks.getCredentials(persona, "password");
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ginger_logon_password_TextBox, "present").sendKeys(tempPassword);
		reporterHelper.log("Ginger Password entered Successfully: " + tempPassword);
      
        reporterHelper.takeScreenshot(driver, "Login-Populated");

		// Click Sign In
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ginger_logon_SignIn_Button, "present").click();

	}	

	
	@Then("^Call Report Welcome page is displayed$")
	public void callReportWelcomePageIsDisplayed() throws Throwable {

		// SYnc on the Call Report main page being displayed
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.callReport_main_Welcome_Image, "callcreditmain", "present");
		
		reporterHelper.takeScreenshot(driver, "CallReport-Main-Initial");
		
	}
	
	@Then("^Ginger Dashboard is displayed$")
	public void gingerDashboardIsDisplayed() throws Throwable {

		// Sync on Ginger Dashboard Heading
		
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ginger_dashboard_Heading, "present");
		reporterHelper.takeScreenshot(driver, "Ginger-Dashboard-Initial");
		
//		BrowserHelper.customSleep(20 * 1000);
	}
	
	@Then("^Credit Report is viewed in Ginger$")
	public void creditReportIsViewedInGinger() throws Throwable {


		// Click Users
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ginger_nav_users_Button, "present").click();
		
		// Sync on Ginger Users Heading
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ginger_users_Heading, "present");
		
		// enter user identifier
		// TODO - Currently hardcoded, need to pull from config file
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ginger_users_userIdentifier_TextBox, "present").sendKeys("7537B2EF-2ED9-4D83-9823-A0E1D5AE3D95");
		
		// Click Search
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ginger_users_search_Button, "present").click();
		
		// Sync on Total Count Heading
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ginger_users_totalCount_Heading, "present");

		// click on the user row
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ginger_users_userList_RowItem, "present").click();
		
		// click on the All Credit Reports link
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ginger_users_selectedRow_allCreditReports_Link, "present").click();
		
		// Sync on User credit reports Heading
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ginger_users_totalCount_Heading, "present");

		// click on the report row
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ginger_userCreditReports_RowItem, "present").click();
		
		
		// ###########
		
		strFirstWindowHandle = driver.getWindowHandle();
		
		// click on the View credit report link
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ginger_userCreditReports_selectedRow_viewCreditReport_Link, "present").click();
		
		reporterHelper.startTimer("Open Ginger Credit Report");
		
		// Switch to new browser tab
		BrowserHelper.customSleep(2 * 1000);
		
		Set<String> setWindowHandles = driver.getWindowHandles();
		
		for(String strWindowHandle: setWindowHandles){
			//If the window handle is not same as the one stored before opening up second window, it is the new window
			if(!strWindowHandle.equals(strFirstWindowHandle)){
				//Switch to the new window
				driver.switchTo().window(strWindowHandle);
				
				BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ginger_creditReport_CreditReportFor_Heading, "default", "present");
				
				reporterHelper.stopTimer("Open Ginger Credit Report");
				//Exit from loop
				break;
			}
		}

		reporterHelper.log("driver.getTitle(): " + driver.getTitle());
		reporterHelper.takeScreenshot(driver, "Ginger-CreditReport-Initial_View");

		//Close the Credit Report browser tab
        driver.close();
		driver.switchTo().window(strFirstWindowHandle);
		
		// Sync on User credit reports Heading
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ginger_users_totalCount_Heading, "present");

	}
	
	@When("^a dispute is raised in Ginger$")
	public void a_dispute_is_created_in_Ginger_admin_panel() throws Throwable {

		// Sync on User credit reports Heading
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ginger_users_totalCount_Heading, "present");

		
		// TODO: Raise Ginger dispute
	

		
//		BrowserHelper.customSleep(60 * 1000);
		
	}
	
	
	@Given("^the Numero Interactive URL is submitted$")
	public void theNumeroInteractiveURLIsSubmitted() throws Throwable {
		// Added for repeatability
		// Check for 'User is logged in elsewhere' screen and progress is identified
		if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.numero_signedOut_SignOut_Label, "default", 5)) {
			
			browserHelper.navigateBack();
			
			// Check for 'User is logged in elsewhere' screen and progress is identified
			if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.numero_areYouAlready_confirm_checkbox, 5)) {
				reporterHelper.log("User is logged in elsewhere' screen displayed, clicking checkbox and clicking Login");
				reporterHelper.takeScreenshot(driver, "Numero-Already_Logged_In-Initial_View");
				BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_areYouAlready_confirm_checkbox, "clickable").click();
				reporterHelper.takeScreenshot(driver, "Numero-Already_Logged_In-Populated");
				BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_areYouAlready_Login_Button, "clickable").click();
			}
			
		} else {
			// Open Numero URL
			String environmentName = Utils.getProperty("ENVIRONMENT");
			browserHelper.openURL(Utils.getProperty(environmentName + "_NUMEROINTERACTIVE_URL"));
		}
		
	}
	
	
	@Given("^any logon screens are navigated$")
	public void anyLogonScreensAreNavigated() throws Throwable {
		reporterHelper.log("ZZZZZZZZZZ - Start Checking for various screens");
		reporterHelper.log("ZZZZZZZZZZ - Start Checking for various screens");
		reporterHelper.log("ZZZZZZZZZZ - Start Checking for various screens");

		
		Boolean logonSuccess = false;
		
		// In a loop for MAX_SYNC_RETRIES, check for and progress any logon screens
		// and exit loop once Numero Interactive main menu is displayed
		for (int i = 0; i < Integer.parseInt(Utils.getProperty("MAX_SYNC_RETRIES")); i++) {
			
			BrowserHelper.customSleep(5 * 1000);
			
			// Check to see if Logged In and exit loop if so
			reporterHelper.log("Checking for presence of Numero Interactive Main Menu Link...");
			if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.numero_main_Menu_Link, 1)) {
				reporterHelper.log("Numero Interactive Main Menu Link identified - Logon complete");
				logonSuccess = true;
				break;
			}

			// Check for 'User is logged in elsewhere' screen and progress if identified
			reporterHelper.log("Checking for presence of 'User is logged in elsewhere' screen...");
			if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.numero_areYouAlready_confirm_checkbox, 1)) {
				reporterHelper.log("'User is logged in elsewhere' screen displayed, clicking checkbox and clicking Login");
				reporterHelper.takeScreenshot(driver, "Numero-Already_Logged_In-Initial_View");
				BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_areYouAlready_confirm_checkbox, "clickable").click();
				reporterHelper.takeScreenshot(driver, "Numero-Already_Logged_In-Populated");
				BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_areYouAlready_Login_Button, "clickable").click();
			}
	
			// Check for 'Your account is pending approval by an administrator' screen and progress if identified
			reporterHelper.log("Checking for presence of 'Your account is pending approval by an administrator' screen...");
			if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.numero_yourAccountIsPendingText, 1)) {
				reporterHelper.log("'Your account is pending approval by an administrator' screen displayed, clicking Login");
				reporterHelper.takeScreenshot(driver, "Numero-Account_Pending-Initial_View");
				BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_yourAccountIsPending_Login_Button, "clickable").click();
			}
	
			// Check for logon credentials entry page
			reporterHelper.log("Checking for logon credentials screen...");
			if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.numero_logon_emailAddress_TextBox, 1)) {
				reporterHelper.log("Logon credentials screen identified, progressing...");
				BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_logon_emailAddress_TextBox, "present");
				reporterHelper.takeScreenshot(driver, "Numero-Sign_In-Initial_View");
				
				// Note - Hardcoding the persona here
				String persona = "Numero Admin User";
				
				// Enter Valid Username
				String tempUsername = Hooks.getCredentials(persona, "username");
				BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_logon_emailAddress_TextBox, "present").sendKeys(tempUsername);
		        reporterHelper.log("Ginger Username entered Successfully: " + tempUsername);
	
		        // Enter Valid Password
				String tempPassword = Hooks.getCredentials(persona, "password");
				BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_logon_password_TextBox, "present").sendKeys(tempPassword);
				reporterHelper.log("Ginger Password entered Successfully: " + tempPassword);
		      
		        reporterHelper.takeScreenshot(driver, "Login-Populated");
	
				// Click Sign In
				BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_logon_SignIn_Button, "present").click();
	
				// Check for 'User is logged in elsewhere' screen and progress is identified
				if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.numero_areYouAlready_confirm_checkbox, 5)) {
					reporterHelper.log("USer is logged in elsewhere' screen displayed, clicking checkbox and clicking Login");
					reporterHelper.takeScreenshot(driver, "Numero-Already_Logged_In-Initial_View");
					BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_areYouAlready_confirm_checkbox, "clickable").click();
					reporterHelper.takeScreenshot(driver, "Numero-Already_Logged_In-Populated");
					BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_areYouAlready_Login_Button, "clickable").click();
				}
				
			}
		}
		
		if(logonSuccess) {
			reporterHelper.takeScreenshot(driver, "Numero-Logged_On-Initial_View");
		} else {
			reporterHelper.customFailScript("Logon failed");
		}
		
	}
	
	@Given("^the Numero Sign In page is displayed$")
	public void theNumeroSignInPageIsDisplayed() throws Throwable {

		// Added for repeatability
		// Check for 'User is logged in elsewhere' screen and progress is identified
		if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.numero_signedOut_SignOut_Label, "default", 5)) {
			
			browserHelper.navigateBack();
			
			// Check for 'User is logged in elsewhere' screen and progress is identified
			if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.numero_areYouAlready_confirm_checkbox, 5)) {
				reporterHelper.log("User is logged in elsewhere' screen displayed, clicking checkbox and clicking Login");
				reporterHelper.takeScreenshot(driver, "Numero-Already_Logged_In-Initial_View");
				BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_areYouAlready_confirm_checkbox, "clickable").click();
				reporterHelper.takeScreenshot(driver, "Numero-Already_Logged_In-Populated");
				BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_areYouAlready_Login_Button, "clickable").click();
			}
			
		} else {
			// Open Numero URL
			String environmentName = Utils.getProperty("ENVIRONMENT");
			browserHelper.openURL(Utils.getProperty(environmentName + "_NUMEROINTERACTIVE_URL"));
		}
		
		reporterHelper.log("QQQQQQQQQQ - Start Checking for various screens");
		reporterHelper.log("QQQQQQQQQQ - Start Checking for various screens");
		reporterHelper.log("QQQQQQQQQQ - Start Checking for various screens");
		
		
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_logon_emailAddress_TextBox, "present");
		reporterHelper.takeScreenshot(driver, "Numero-Sign_In-Initial_View");
		
	}

//	@When("^valid credentials are submitted to Numero$")
//	public void validCredentialsAreSubmittedToNumero() throws Throwable {
//		
//		// Enter Numero logon email address
//		// TODO - Currently hardcoded, need to pull from credentials.json
//		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_logon_emailAddress_TextBox, "present").sendKeys("james.connors@callcreditgroup.com");
//		
//		// Enter Numero logon password
//		// TODO - Currently hardcoded, need to pull from credentials.json
//		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_logon_password_TextBox, "present").sendKeys("$Hannon19022");
//
//		// Click Sign In
//		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_logon_SignIn_Button, "present").click();
//
//		// Check for 'User is logged in elsewhere' screen and progress is identified
//		if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.numero_areYouAlready_confirm_checkbox, 5)) {
//			reporterHelper.log("USer is logged in elsewhere' screen displayed, clicking checkbox and clicking Login");
//			reporterHelper.takeScreenshot(driver, "Numero-Already_Logged_In-Initial_View");
//			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_areYouAlready_confirm_checkbox, "clickable").click();
//			reporterHelper.takeScreenshot(driver, "Numero-Already_Logged_In-Populated");
//			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_areYouAlready_Login_Button, "clickable").click();
//		}
//		
//	}
	
	@When("^a '(.*)' valid username and valid password are submitted to Numero$")
	public void aPersonaNameValidUsernameAndValidPasswordAreSubmittedToNumero(String persona) {
		
		// Enter Valid Username
		String tempUsername = Hooks.getCredentials(persona, "username");
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_logon_emailAddress_TextBox, "present").sendKeys(tempUsername);
        reporterHelper.log("Ginger Username entered Successfully: " + tempUsername);

        // Enter Valid Password
		String tempPassword = Hooks.getCredentials(persona, "password");
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_logon_password_TextBox, "present").sendKeys(tempPassword);
		reporterHelper.log("Ginger Password entered Successfully: " + tempPassword);
      
        reporterHelper.takeScreenshot(driver, "Login-Populated");

		// Click Sign In
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_logon_SignIn_Button, "present").click();

		// Check for 'User is logged in elsewhere' screen and progress is identified
		if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.numero_areYouAlready_confirm_checkbox, 5)) {
			reporterHelper.log("USer is logged in elsewhere' screen displayed, clicking checkbox and clicking Login");
			reporterHelper.takeScreenshot(driver, "Numero-Already_Logged_In-Initial_View");
			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_areYouAlready_confirm_checkbox, "clickable").click();
			reporterHelper.takeScreenshot(driver, "Numero-Already_Logged_In-Populated");
			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_areYouAlready_Login_Button, "clickable").click();
		}

	}	
	

	@Then("^Numero main page is displayed$")
	public void numeroMainPageIsDisplayed() throws Throwable {
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_main_Menu_Link, "present");
		reporterHelper.takeScreenshot(driver, "Numero-Logged_On-Initial_View");
	}
	
	
	@Then("^dispute is present in Numero Interactive$")
	public void dispute_is_present_in_numero_interactive() throws Throwable {

		// Dispute Case ID currently hardcoded, but should be fed in from ck/Ginger earlier steps 
		String disputeCaseId = "355";

		// Sync on Menu link being present
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_main_Menu_Link, "present").click();

		// Select 'CDP Outstanding Disputes' from Menu
        Actions action = new Actions(driver);
        action.moveToElement(BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_main_Reporting_MenuItem, "present"));
        action.moveToElement(BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_main_ReportingQueries_MenuSubItem, "present"));
        action.moveToElement(BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_main_CDPOutstandingDisputes_MenuSubSubItem, "present"));
        action.click().build().perform();
		
//        BrowserHelper.customSleep(5 * 1000);
        
        // sync on disputes table being displayed
        BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_CDPOutstandingDisputes_DisputeCaseIdFilter_TextBox, "iframeContentPanel_44", "present");

        reporterHelper.takeScreenshot(driver, "Numero-CDP_Outstanding_Disputes-Initial_View");

        // Get Initial record count
        tempWebElement = BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_CDPOutstandingDisputes_RecordsCount_Label, "iframeContentPanel_44", "present");
        String tempWebElementText = tempWebElement.getText();
        int initialRecordCount = Integer.parseInt(tempWebElementText.substring(0, tempWebElementText.indexOf(" ")));
        reporterHelper.log("Initial record (dipsute) count is " + initialRecordCount);

        
        // Enter Dispute Case Id filter
        BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_CDPOutstandingDisputes_DisputeCaseIdFilter_TextBox, "iframeContentPanel_44", "present").sendKeys(disputeCaseId);
        // cannot find a way to sync on filter being appleid so doing a hard wait of 5 seconds
        BrowserHelper.customSleep(5 * 1000);
        reporterHelper.takeScreenshot(driver, "Numero-CDP_Outstanding_Disputes-Filtered_View");

        // Get New record count
        tempWebElement = BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_CDPOutstandingDisputes_RecordsCount_Label, "iframeContentPanel_44", "present");
        tempWebElementText = tempWebElement.getText();

        int filteredRecordCount = Integer.parseInt(tempWebElementText.substring(0, tempWebElementText.indexOf(" ")));
        reporterHelper.log("Number of records (disputes) returned after applying filter of '" + disputeCaseId + "' is " + filteredRecordCount);
        
        if(filteredRecordCount != 1) {
        	reporterHelper.log("Dispute not yet present in Numero, entering wait loop...");
        	// TODO
        	reporterHelper.customFailScript("TODO - Wait loop not yet implemented"); 
        }
        
        reporterHelper.log("Clicking on dispute...");
    	
    	BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_main_CDPOutstandingDisputes_DisputeRows, "iframeContentPanel_44", "present").click();
    	
    	reporterHelper.startTimer("Open Disupte");
    	// Sync on the WorkItem 'Consumer Details' heading
    	BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_main_WorkItem_ConsumerDetails_Heading, "applicationContainer", "present");
    	
    	reporterHelper.stopTimer("Open Disupte");
    	
    	reporterHelper.takeScreenshot(driver, "Numero-WorkItem-Initial_View");
        	

		
	}
	
	@Then("^a new Call Report credit report can be requested from Numero$")
	public void aNewRreportCanBeRequestedFromCallReport() throws Throwable {

        // Check how many reports are present
        List<WebElement> listElements = BrowserHelper.syncOnElements(driver, optimusLocatorLibrary.numero_main_WorkItem_CreditReports_Row, "applicationContainer", "present");
        int initialCreditReportCount = listElements.size();
		reporterHelper.log("\tNumber of credit report(s) found: " + initialCreditReportCount);
		
		// select the most recent credit report
		listElements.get(listElements.size()-1).click();
		reporterHelper.takeScreenshot(driver, "Numero-WorkItem-Last_Credit_Report_Selected");
		
		// Click New Version button to request refreshed report from Call Report
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_main_WorkItem_NewVersion_Button, "applicationContainer", "present").click();
		
		reporterHelper.startTimer("Request New Version Of Report");
		
		// Sync on the page not being busy
		BrowserHelper.customSleep(1 * 1000);
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_main_body_not_busy, "applicationContainer", "present");
		
		reporterHelper.stopTimer("Request New Version Of Report");
		
        // Check how many reports are present
        listElements = BrowserHelper.syncOnElements(driver, optimusLocatorLibrary.numero_main_WorkItem_CreditReports_Row, "applicationContainer", "present");
        int updatedCreditReportCount = listElements.size();
		reporterHelper.log("\tNumber of credit report(s) found after requesting new report: " + updatedCreditReportCount);

		// If credit report count has not increased then fail script
		if(!(updatedCreditReportCount > initialCreditReportCount)) {
			reporterHelper.customFailScript("Requested credit report present after clicking New Version");
		}
		
		reporterHelper.takeScreenshot(driver, "Numero-WorkItem-New_Credit_Report_Present");
		
		// click on the new report
		listElements.get(listElements.size()-1).click();
		
		BrowserHelper.customSleep(1 * 1000);
		
		String strFirstWindowHandle = driver.getWindowHandle();
		
		// click view button
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_main_WorkItem_View_Button, "applicationContainer", "present").click();
		
		reporterHelper.startTimer("Open New Version Of Report");
		
		BrowserHelper.customSleep(2 * 1000);
		
		Set<String> setWindowHandles = driver.getWindowHandles();
		
		for(String strWindowHandle: setWindowHandles){
			//If the window handle is not same as the one stored before opening up second window, it is the new window
			if(!strWindowHandle.equals(strFirstWindowHandle)){
				//Switch to the new window
				driver.switchTo().window(strWindowHandle);
				
				BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_main_CreditReport_CreditReportFor_Heading, "default", "present");
				
				reporterHelper.stopTimer("Open New Version Of Report");
				
				reporterHelper.log("driver.getTitle(): " + driver.getTitle());
				reporterHelper.takeScreenshot(driver, "Numero-CreditReport-Initial_View");

				//Close this browser window
		        driver.close();
				driver.switchTo().window(strFirstWindowHandle);
		        
				//Exit from loop
				break;
			}
		}

		// Switch back to default iframe
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_main_Menu_Link, "default", "present");
		
		// Click Delete Credit Report button
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_main_WorkItem_Delete_Button, "applicationContainer", "present").click();
		
		reporterHelper.takeScreenshot(driver, "Numero-CreditReport-AreYouSure-Modal");
		
		// Progress the confirmation Modal that is presented
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_main_WorkItem_AreYouSure_Modal_Delete_Button, "applicationContainer", "present").click();
		
		reporterHelper.startTimer("Delete New Version Of Report");
		
		BrowserHelper.customSleep(1 * 1000);
		
		// Sync on the page not being busy
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_main_body_not_busy, "applicationContainer", "present");

		reporterHelper.stopTimer("Delete New Version Of Report");
		
		reporterHelper.takeScreenshot(driver, "Numero-CreditReport-Deleted");
		
        // Check how many reports are present
        listElements = BrowserHelper.syncOnElements(driver, optimusLocatorLibrary.numero_main_WorkItem_CreditReports_Row, "applicationContainer", "present");
        int postDeletedCreditReportCount = listElements.size();
		reporterHelper.log("\tNumber of credit report(s) found after deleting new report: " + postDeletedCreditReportCount);

		// If credit report count has not increased then fail script
		if(postDeletedCreditReportCount != initialCreditReportCount) {
			reporterHelper.customFailScript("Credit report count has not reduced after reqwuesting deltion of new credit report");
		}
		
		// Logout
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.numero_main_Logout_Button, "default", "present").click();
		
//		BrowserHelper.customSleep(20 * 1000);
		
	}

	
	
	@Then("^dispute is present in ck admin panel$")
	public void dispute_is_present_in_ck_admin_panel() throws Throwable {
		
		browserHelper.openURL("https://devtest.ck.co.uk/youwillnevergetthere");
//		BrowserHelper.customSleep(5 * 1000);
		
		aPersonaNameValidUsernameAndValidPasswordAreEntered("Admin Panel User"); 
		theLoginButtonIsClicked();
		
//		ckMainPageIsDisplayed();

		 
		// Click 'User Disputes'
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ckAdmin_generic_header_UserDisputes_Link, "clickable").click();
		
		// Set the required ck state
		selectckState("All");
		 
		// Enter the user name of consumer that dispute was raised by
//		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ckAdmin_userDisputesAdmin_Username_TextBox, "present").sendKeys("ck_JF_auto");
		 
		// Click Search
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ckAdmin_userDisputesAdmin_Search_Button, "clickable").click();
		 
		tempWebElement = BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ckAdmin_userDisputesAdmin_TotalCount_Heading, "clickable");
		String disputeCount = tempWebElement.getText().replace("Total count: ", "");

		reporterHelper.log("Number of disputes retured from search: " + disputeCount);
		
		// Find dispute that was raised
		
			String targetckReferenceNo = "8037032";
			
	        List<WebElement> listElements = BrowserHelper.syncOnElements(driver, optimusLocatorLibrary.ckAdmin_userDisputesAdmin_dispute_table_item, "present");
	        
			reporterHelper.log("\tNumber of dispute(s) found: " + listElements.size());
			reporterHelper.log("\tSearching for dispute that has a 'ck Reference no' text value of '" + targetckReferenceNo + "'");
			
			Boolean success = false;
			String attributeName = "id";
			
			for (int j = 0; j < listElements.size(); j++) {
				
				tempWebElement = listElements.get(j);
				
				String tempString = tempWebElement.getAttribute(attributeName);
	//			tempString = tempString.substring(tempString.indexOf("-"));
				
				reporterHelper.log("\tItem number " + (j+1) + " attribute '" + attributeName + "' has the value: " + tempString);
				
				if(tempString.substring(tempString.indexOf("-") + 1).equalsIgnoreCase(targetckReferenceNo)) {
					reporterHelper.log("\tFound target item in list, clicking element...");
					
					tempWebElement.click();
					success = true;
					break;
				}
			}
			
			if(!success)
				reporterHelper.customFailScript("Count not find item '" + targetckReferenceNo + "'");

			// Scroll so all of dispute detail can be viewed
				reporterHelper.log("dispute row top-left coordiantes is : " + tempWebElement.getLocation().toString());
				reporterHelper.log("scrolling vertically by: " + tempWebElement.getLocation().y + " in 5 seconds...");
				
				BrowserHelper.customSleep(5 * 1000);
								
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollTo(0, " + tempWebElement.getLocation().y+")");			
			// End of Scroll
				
			reporterHelper.takeScreenshot(driver, "ckAdmin-UserDisputesAdmin_Dispute_Expanded");
		
		// End of find dispute
		
		BrowserHelper.customSleep(10 * 1000);
	}
	
	
	@Then("^ck main page is displayed$")
	public void ckMainPageIsDisplayed() throws Throwable {
		
		if(BrowserHelper.isElementPresent(driver, optimusLocatorLibrary.ck_tsandcs_main_Header, 5)) {
			reporterHelper.log("ck T's and C's page displayed, clicking Continue");
			reporterHelper.takeScreenshot(driver, "General-Optimus_TsAndCs_Page_Displayed");
			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_generic_main_Continue_Button, "clickable").click();
		}
		
		if(performSync)
			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_account_summary_main_Header, "present");		
		
		reporterHelper.stopTimer("Login");
        reporterHelper.log("Logged in Successfully");
        
		reporterHelper.log("ck Account Summary page displayed");
		reporterHelper.takeScreenshot(driver, "General-Optimus_Account_Summary_Page_Displayed");

	}

	public void searchForDIsputeInckAdmin(String itemName, String reasonName) throws Throwable {
		
		// Click 'User Disputes' link
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ckAdmin_generic_header_UserDisputes_Link, "clickable").click();		
		
		// Sync that 'User Disputes administration' page has displayed
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ckAdmin_userDisputesAdmin_Title, "clickable");
		reporterHelper.takeScreenshot(driver, "General-Optimus_My_Credit_Report_Page_Displayed");

		// Select All from ck state drop-down
		
		
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ckAdmin_userDisputesAdmin_Search_Button, "clickable");

		
		
		
		// Select Appropriate Report Tab
		selectMyCreditReportTab(itemName);
		reporterHelper.takeScreenshot(driver, "General-Optimus_Report_Tab_Selected");
		
		fetchLineItem(itemName);
	}
	
	@Then("^Credit Report is viewed in ck$")
	public void creditReportIsViewedInck() throws Throwable {

		// Click 'View my full report' button
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_generic_main_ViewMuFullReport_Button, "clickable").click();		
		
		// Sync that 'My credit report' page has displayed
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_mycreditreport_main_Title, "present");
		reporterHelper.takeScreenshot(driver, "General-Optimus_My_Credit_Report_Page_Displayed");
	}

		
	@When("^a Consumer disputes an? ck \"(.*)\" data item with reason \"(.*)\"$")
	public void aConsumerDisputesDataItemWithReason(String itemName, String reasonName) throws Throwable {
		
		//When a Consumer disputes a "single MODA" data item with reason "number of overdue payments are incorrect"
		
		// Select Appropriate Report Tab
		selectMyCreditReportTab(itemName);
		reporterHelper.takeScreenshot(driver, "General-Optimus_Report_Tab_Selected");
		
		// Identify Line Item and return WebElement representing the row
		WebElement selectedRowElement = fetchLineItem(itemName);
		
		// Click the line item to Expand
		selectedRowElement.click();
		reporterHelper.takeScreenshot(driver, "General-Optimus_Line_Item_Expanded");
		
		// Click the Dispute Link for the Line Item
		clickDisputeLink(selectedRowElement);
		reporterHelper.takeScreenshot(driver, "General-Optimus_Dispute_Link_Clicked");
		
		reporterHelper.log("HERE N1");
		// In the case of address disputes, if presented, selected first address radio button
		if(BrowserHelper.isElementDisplayed(driver, optimusLocatorLibrary.ck_raiseDisputeModal_SelectAddressModel_Heading)) {
			reporterHelper.log("Select Address modal identified.  Selecting first address...");
			
			// Click first radio button
			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeModal_SelectAddressModel_Address_RadioButton_Labels, "present").click();
			reporterHelper.log("HERE N2");
			// Click 'Use this address' button 
			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeModal_SelectAddressModel_UseThisAddress_Button, "present").click();
			reporterHelper.log("HERE N3");
			

		} 

		// Sync on the Dispute Form
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeModal_Title, "visible");	

		// Check if there are two reasons to select from dropdown, indicated by : in the reasonName
		if(reasonName.contains(":")) {
			// Select Dispute Group Name from Drop-DOwn
			selectDisputeGroupName(reasonName.split(":")[0].trim());
			
			// Select Dispute Reason from Drop-Down
			selectDisputeReasonCode(reasonName.split(":")[1].trim());
			reporterHelper.takeScreenshot(driver, "General-Optimus_Dispute_Reason_Selected");
		} 
		
		// 
		else {

			// Select Dispute Reason from Drop-Down
			selectDisputeReasonCode(reasonName);
			reporterHelper.takeScreenshot(driver, "General-Optimus_Dispute_Reason_Selected");

		}
		
		
		// If confirmation radio box is present then select yes
		if (BrowserHelper.isElementDisplayed(driver, optimusLocatorLibrary.ck_raiseDisputeModal_Yes_RadioButton)) {
			selectRaiseDisputeConfirmation(true);
			reporterHelper.takeScreenshot(driver, "General-Optimus_Confirmation_Radio_Selected");
		}
		

		addSupportingInformation(reasonName);
		reporterHelper.takeScreenshot(driver, "General-Optimus_Supporting_Information_Added");

		// Select Cancel Button
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeModal_Cancel_Button, "visible").click();
		reporterHelper.takeScreenshot(driver, "General-Optimus_Raise_Disputed_Modal_Cancelled");
		
		// Select 'My Dashboard' from Secondary Navigation Panel
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_generic_header_secondaryNav_MyDashboard_Link, "visible").click();
		reporterHelper.takeScreenshot(driver, "General-Optimus_Returned_To_My_Dashboard");
		
	}	

//	@When("^a Consumer disputes an? \"(.*)\" data item$")
//	public void aConsumerDisputesDataItemWithNoReason(String itemName) throws Throwable {
//		
//		//When a Consumer disputes a "single MODA" data item with reason "number of overdue payments are incorrect"
//		
//		// Select Appropriate Report Tab
//		selectMyCreditReportTab(itemName);
//		reporterHelper.takeScreenshot(driver, "General-Optimus_Report_Tab_Selected");
//		
//		// Identify Line Item and return WebElement representing the row
//		WebElement selectedRowElement = fetchLineItem(itemName);
//		
//		// Click the line item to Expand
//		selectedRowElement.click();
//		reporterHelper.takeScreenshot(driver, "General-Optimus_Line_Item_Expanded");
//		
//		// Click the Dispute Link for the Line Item
//		clickDisputeLink(selectedRowElement);
//		reporterHelper.takeScreenshot(driver, "General-Optimus_Dispute_Link_Clicked");
//		
//		reporterHelper.log("HERE N1");
//		// In the case of address disputes, if presented, selected first address radio button
//		if(BrowserHelper.isElementDisplayed(driver, optimusLocatorLibrary.ck_raiseDisputeModal_SelectAddressModel_Heading)) {
//			reporterHelper.log("Select Address modal identified.  Selecting first address...");
//			
//			// Click first radio button
//			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeModal_SelectAddressModel_Address_RadioButton_Labels, "present").click();
//			reporterHelper.log("HERE N2");
//			// Click 'Use this address' button 
//			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeModal_SelectAddressModel_UseThisAddress_Button, "present").click();
//			reporterHelper.log("HERE N3");
//			
//
//		} 
//
//		// Sync on the Dispute Form
//		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeModal_Title, "visible");	
//
//		// Check if there are two reasons to select from dropdown, indicated by : in the reasonName
//		if(reasonName.contains(":")) {
//			// Select Dispute Group Name from Drop-DOwn
//			selectDisputeGroupName(reasonName.split(":")[0].trim());
//			
//			// Select Dispute Reason from Drop-Down
//			selectDisputeReasonCode(reasonName.split(":")[1].trim());
//			reporterHelper.takeScreenshot(driver, "General-Optimus_Dispute_Reason_Selected");
//		} 
//		
//		// 
//		else {
//
//			// Select Dispute Reason from Drop-Down
//			selectDisputeReasonCode(reasonName);
//			reporterHelper.takeScreenshot(driver, "General-Optimus_Dispute_Reason_Selected");
//
//		}
//		
//		
//		// If confirmation radio box is present then select yes
//		if (BrowserHelper.isElementDisplayed(driver, optimusLocatorLibrary.ck_raiseDisputeModal_Yes_RadioButton)) {
//			selectRaiseDisputeConfirmation(true);
//			reporterHelper.takeScreenshot(driver, "General-Optimus_Confirmation_Radio_Selected");
//		}
//		
//
//		addSupportingInformation(reasonName);
//		reporterHelper.takeScreenshot(driver, "General-Optimus_Supporting_Information_Added");
//
//		// Select Cancel Button
//		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeModal_Cancel_Button, "visible").click();
//		reporterHelper.takeScreenshot(driver, "General-Optimus_Raise_Disputed_Modal_Cancelled");
//		
//		// Select 'My Dashboard' from Secondary Navigation Panel
//		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_generic_header_secondaryNav_MyDashboard_Link, "visible").click();
//		reporterHelper.takeScreenshot(driver, "General-Optimus_Returned_To_My_Dashboard");
//		
//	}	
	
	private void addSupportingInformation(String reasonName) {

		// If date field is displayed then populate
		if(BrowserHelper.isElementDisplayed(driver, optimusLocatorLibrary.ck_raiseDisputeModal_Corrected_Date_Field)) {
			reporterHelper.log("Additional Information Date Picker identified.  Populating...");
			
			// Select Date from date picker
			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeModal_Corrected_Date_Field, "present").click();
			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeModal_DatePicker_Second_Row_Second_Day, "present").click();
		} 
			
		// If free text field is displayed then populate
		else if(BrowserHelper.isElementDisplayed(driver, optimusLocatorLibrary.ck_raiseDisputeModal_TextArea)) {
			reporterHelper.log("Additional Information Free Text Field identified.  Populating...");
			
			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeModal_TextArea, "present").sendKeys("Some text is entered");
		} 
			
		// If radio buttons are displayed then select first one		
		else if(BrowserHelper.isElementDisplayed(driver, optimusLocatorLibrary.ck_raiseDisputeModal_First_RadioButton)) {
			reporterHelper.log("Additional Information Radio Buttons identified.  Selecting first...");
			
			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeModal_First_RadioButton, "present").click();
		}
		
		else
			reporterHelper.log("No Additional Information fields present");
		
	} 
	
	private void addSupportingInformationAlternativeApproach(String reasonName) {

    	switch(reasonName) {
    	
	    	case "The start date on the account is incorrect":
	    	case "The settlement date on the account is incorrect":
	    	case "The default satisfaction date on the account is incorrect":
	    	case "The default date on the account is incorrect":
	    	case "The default has been satisfied":
	    	case "The account has been closed":	
	    		// Select new Date
	    		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeModal_Corrected_Date_Field, "present").click();
	    		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeModal_DatePicker_Second_Row_Second_Day, "present").click();
				break;
				
	    	case "The credit limit on the account is incorrect":
	    	case "The account type is incorrect":
	    	case "The account appears on my credit file more than once":
	    	case "The regular payment amount on the account is incorrect":
	    	case "The account history is incorrect":
	    	case "Other: The Bankruptcy/Sequestration doesn't belong to me":
	    	case "Other: The Bankruptcy/Sequestration should be removed from my credit file":
	    	case "Other: The Administration Order doesn't belong to me":
	    	case "Other: The Administration Order should be removed from my credit file":
	    	case "The number of overdue payments are incorrect":
	    	case "This account has never been overdue / is now up to date":
	    	case "The next payment amount is incorrect":
	    		// Enter text in textarea
	    		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeModal_TextArea, "present").sendKeys("Some text is entered");
				break;
				
	    	case "This account should be removed from my credit file":
	    	case "The repayment frequency is incorrect":
	    		// Select account is over 6 years old Radio button
	    		// TODO: Change to select first radio
//	    		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeModal_Over6YearsOld_RadioButton, "present").click();
	    		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeModal_First_RadioButton, "present").click();
				break;
				
	    	case "The Gone-away marker on the account is incorrect":    		
	    	case "The account didn't go into default":
	    	case "I don't recognise this account":
	    	case "Other: A Bankruptcy/Sequestration should be present on my credit file":
	    	case "Other: The Bankruptcy/Sequestration appears on my credit file more than once":
	    	case "Status Incorrect: The Bankruptcy/Sequestration is still active":
	    	case "Status Incorrect: The Bankruptcy/Sequestration has been annulled":
	    	case "Status Incorrect: The Bankruptcy/Sequestration has been discharged":
	    	case "Date Incorrect: The discharge date on the Bankruptcy/Sequestration is incorrect":
	    	case "Date Incorrect: The order date on the Bankruptcy/Sequestration is incorrect":
	    	case "Status incorrect: The Administration Order is still active":
	    	case "Status incorrect: The Administration Order has been anulled/cancelled":
	    	case "Status incorrect: The Administration Order has been completed":
	    	case "Incorrect Date: The completion date on the Administration Order is incorrect":
	    	case "Incorrect Date: The start date on the Administration Order is incorrect":
	    	case "Other: The Administration  Order appears on my file more than once":
	    	case "Other: An Administration Order should be present on my credit file":
	    	case "Status incorrect: The CCJ/Decree has been cancelled":
	    	case "Status incorrect: The CCJ/Decree has been satisfied":
	    	case "Status incorrect: The CCJ/Decree has been set aside":
	    	case "Date incorrect: The order date on the CCJ/Decree is incorrect":
	    	case "Date incorrect: The satisfaction date on the CCJ/Decree is incorrect":
	    	case "Other: The CCJ/Decree doesn't belong to me":
	    	case "Other: The CCJ/Decree appears on my credit file more than once":
	    	case "Other: The amount of the CCJ/Decree is incorrect":
	    	case "Other: A CCJ/Decree should be present on my credit file":
	    		
	    	
	    	
	    	case "The rollover data is incorrect" :
	    	case "The payment term is incorrect" :
	    	
	    	
	    	case "The credit extension information is incorrect" :
//	    	case "The credit limit on the account is incorrect" :
//	    	case "The start date on the account is incorrect" :
//	    	case "The account has been closed" :
//	    	case "I don't recognise this account" :
//	    	case "This account should be removed from my credit file" :
//	    	case "The account appears on my credit file more than once" :
	    		
	    		
	    		// No additional information fields therefore do nothing
				break;			
	    	default:
		        reporterHelper.customFailScript("Unknown reason in method addSupportingInformation: " + reasonName);
		        
		}

        
	} 
	

	private void selectRaiseDisputeConfirmation(boolean selectYes) {
		if(selectYes)
			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeModal_Yes_RadioButton, "clickable").click();
		else
			BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeModal_No_RadioButton, "clickable").click();
	}

	
	private void selectckState(String stateName) {
		// click select to expand
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ckAdmin_userDisputesAdmin_ckState_Select, "clickable").click();
		

		
        List<WebElement> listElements = BrowserHelper.syncOnElements(driver, optimusLocatorLibrary.ckAdmin_userDisputesAdmin_ckState_Select_Items, "present");
        
		reporterHelper.log("\tNumber of select items found: " + listElements.size());
		reporterHelper.log("\tSearching for select item that has a text value of '" + stateName + "'");
		
		Boolean success = false;
		
		for (int j = 0; j < listElements.size(); j++) {
			
			tempWebElement = listElements.get(j);
			String tempString = tempWebElement.getText();
			
			reporterHelper.log("\tItem number " + (j+1) + " has the value: " + tempString);
			
			if(tempString.equalsIgnoreCase(stateName)) {
				reporterHelper.log("\tFound target item in list, clicking element...");
				
				tempWebElement.click();
				success = true;
				break;
			}
		}
		
		if(!success)
			reporterHelper.customFailScript("Count not find item '" + stateName + "'");
		
		
	}
	
	private void selectDisputeReasonCode(String reasonName) {
		// click select to expand
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeCodeModal_Select, "clickable").click();
		

		
        List<WebElement> listElements = BrowserHelper.syncOnElements(driver, optimusLocatorLibrary.ck_raiseDisputeCodeModal_Select_Items, "present");
        
		reporterHelper.log("\tNumber of select items found: " + listElements.size());
		reporterHelper.log("\tSearching for select item that has at text value of '" + reasonName + "'");
		
		Boolean success = false;
		
		for (int j = 0; j < listElements.size(); j++) {
			
			tempWebElement = listElements.get(j);
			String tempString = tempWebElement.getText();
			
			reporterHelper.log("\tItem number " + (j+1) + " has the value: " + tempString);
			
			if(tempString.equalsIgnoreCase(reasonName)) {
				reporterHelper.log("\tFound target item in list, clicking element...");
				
				tempWebElement.click();
				success = true;
				break;
			}
		}
		
		if(!success)
			reporterHelper.customFailScript("Count not find item '" + reasonName + "'");
		
		
	}

	
	private void selectDisputeGroupName(String reasonName) {
		// click select to expand
		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeGroupNameModal_Select, "clickable").click();
		

		
        List<WebElement> listElements = BrowserHelper.syncOnElements(driver, optimusLocatorLibrary.ck_raiseDisputeGroupNameModal_Select_Items, "present");
        
		reporterHelper.log("\tNumber of select items found: " + listElements.size());
		reporterHelper.log("\tSearching for select item that has at text value of '" + reasonName + "'");
		
		Boolean success = false;
		
		for (int j = 0; j < listElements.size(); j++) {
			
			tempWebElement = listElements.get(j);
			String tempString = tempWebElement.getText();
			
			reporterHelper.log("\tItem number " + (j+1) + " has the value: " + tempString);
			
			if(tempString.equalsIgnoreCase(reasonName)) {
				reporterHelper.log("\tFound target item in list, clicking element...");
				
				tempWebElement.click();
				success = true;
				break;
			}
		}
		
		if(!success)
			reporterHelper.customFailScript("Count not find item '" + reasonName + "'");
		
		
	}
	

	private void clickDisputeLink(WebElement selectedRowElement) {
//		WebElement tempWebElement_DisputeLink = tempWebElement.findElement(By.xpath(".//a[contains(@class, 'raise-dispute-link')]"));
		WebElement tempWebElement_DisputeLink = tempWebElement.findElement(By.xpath(".//a[contains(@class, 'raise-dispute-link') or contains(@class, 'raise-address-links-dispute')]"));
//		WebElement tempWebElement_DisputeLink = tempWebElement.findElement(By.xpath(".//a[contains(@class, 'raise-address-links-dispute')]"));
		
		tempWebElement_DisputeLink.click();
		
		// Sync on the Dispute Form
//		BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_raiseDisputeModal_Title, "visible");	
		
	}


	private WebElement fetchLineItem(String lineItemName) {
		String attributeNameString = "text";
		String attributeTargetValueString = "";
		
		By rowItemsByLocator = null;
		By rowSubElementByLocator = null;
		
		Boolean success = false;
		
    	switch(lineItemName) {
    	case "single Credit Card (SHARE)":
    		rowItemsByLocator = optimusLocatorLibrary.ck_mycreditreport_main_financialAccountInformation_reportLineItems;
    		rowSubElementByLocator = By.xpath(".//strong");	
    		attributeTargetValueString = "Credit Cards - Default";
			break;
    	case "Public Information item (B&I) of Type: Bankruptcy Order":
    		rowItemsByLocator = optimusLocatorLibrary.ck_mycreditreport_main_publicInformation_reportLineItems;
    		rowSubElementByLocator = By.xpath(".//div[contains(@class, 'expandable-row-overview__pair')][div/text() = 'TYPE']/div[contains(@class, 'public-overview__value')]");
    		attributeTargetValueString = "Bankruptcy Order";
			break;
    	case "Public Information item (B&I) of Type: County Court Judgment":
    		rowItemsByLocator = optimusLocatorLibrary.ck_mycreditreport_main_publicInformation_reportLineItems;
    		rowSubElementByLocator = By.xpath(".//div[contains(@class, 'expandable-row-overview__pair')][div/text() = 'TYPE']/div[contains(@class, 'public-overview__value')]");
    		attributeTargetValueString = "County Court Judgment";
			break;
    	case "Public Information item (B&I) of Type: Administration Order":
    		rowItemsByLocator = optimusLocatorLibrary.ck_mycreditreport_main_publicInformation_reportLineItems;
    		rowSubElementByLocator = By.xpath(".//div[contains(@class, 'expandable-row-overview__pair')][div/text() = 'TYPE']/div[contains(@class, 'public-overview__value')]");
    		attributeTargetValueString = "Administration Order";
			break;
    	case "single MODA":
    		rowItemsByLocator = optimusLocatorLibrary.ck_mycreditreport_main_shortTermLoans_reportLineItems;
    		rowSubElementByLocator = By.xpath(".//div[contains(@class, 'expandable-row-overview__pair')][div/text() = 'STATUS']/div[contains(@class, 'moda-overview__value')]");	
    		attributeTargetValueString = "Overdue";
			break;
    	case "associate link":
    		// return first financial connections row
    		tempWebElement = BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_mycreditreport_main_connectionsOtherNames_FinancialLineItems, "present");
    		
//    		reporterHelper.outputElementHTML(tempWebElement);
    		success = true;
    		break;
    	case "alias link":
    		// return first financial connections row
    		tempWebElement = BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_mycreditreport_main_connectionsOtherNames_OtherNamesLineItems, "present");
    		
//    		reporterHelper.outputElementHTML(tempWebElement);
    		success = true;
    		break;   		
    	case "address link":
    		// return first address row web element
    		tempWebElement = BrowserHelper.syncOnElement(driver, optimusLocatorLibrary.ck_mycreditreport_main_addressLinks_reportLineItems, "present");
    		
//    		reporterHelper.outputElementHTML(tempWebElement);
    		success = true;
    		break;
 	    default:
	        reporterHelper.customFailScript("Unknown line item in method fetchLineItem: " + lineItemName);
		}
    	
    	// If single row item not already identified...
    	if(!success) {
		
	        List<WebElement> listElements = BrowserHelper.syncOnElements(driver, rowItemsByLocator, "present");
	        
			reporterHelper.log("\tNumber of items found: " + listElements.size());
			reporterHelper.log("\tSearching for item that has at attribute of '" + attributeNameString + "' with a value of '" + attributeTargetValueString + "'");
			
			
			
			for (int j = 0; j < listElements.size(); j++) {
				
				tempWebElement = listElements.get(j);
				WebElement tempWebElemnt_SubElement = tempWebElement.findElement(rowSubElementByLocator);
				
				//String tempString = tempWebElement.getAttribute(attributeNameString);
				String tempString = tempWebElemnt_SubElement.getText();
				
				reporterHelper.log("\tItem number " + (j+1) + " has the value: " + tempString);
				
				if(tempString.equals(attributeTargetValueString)) {
					reporterHelper.log("\tFound target item in list, clicking element...");
					
					success = true;
					break;
				}
			}
    	}
		
		if(!success)
			reporterHelper.customFailScript("Count not find item '" + attributeTargetValueString + "'");
		
		return tempWebElement;
	}


	private void selectMyCreditReportTab(String lineItemName) {
		
		String attributeNameString = "text";
		String attributeTargetValueString = "";
		
		
    	switch(lineItemName) {
    	case "single Credit Card (SHARE)":
    		attributeTargetValueString = "Financial Account Information";
			break;
    	case "Public Information item (B&I) of Type: Bankruptcy Order":
    	case "Public Information item (B&I) of Type: Administration Order":
    	case "Public Information item (B&I) of Type: County Court Judgment":
    		attributeTargetValueString = "Public Information";
			break;
    	case "single MODA":
    		attributeTargetValueString = "Short Term Loans";
			break;
    	case "address link":
    		attributeTargetValueString = "Address Links";
			break;			
    	case "associate link":
    	case"alias link":
    		attributeTargetValueString = "Connections & Other Names";
			break;		
			
 	    default:
	        reporterHelper.customFailScript("Unknown line item in method selectMyCreditReportTab: " + lineItemName);
		}

		
        List<WebElement> listElements = BrowserHelper.syncOnElements(driver, optimusLocatorLibrary.ck_mycreditreport_main_tabListItems_Links, "present");
        
		reporterHelper.log("\tNumber of items found: " + listElements.size());
		reporterHelper.log("\tSearching for item that has at attribute of '" + attributeNameString + "' with a value of '" + attributeTargetValueString + "'");
		
		Boolean success = false;
		
		for (int j = 0; j < listElements.size(); j++) {
			
			tempWebElement = listElements.get(j);
			String tempString = tempWebElement.getAttribute(attributeNameString);
			
			reporterHelper.log("\tItem number " + (j+1) + " has the value: " + tempString);
			
			if(tempString.equalsIgnoreCase(attributeTargetValueString)) {
				reporterHelper.log("\tFound target item in list, clicking element...");
				
				tempWebElement.click();
				success = true;
				break;
			}
		}
		
		if(!success)
			reporterHelper.customFailScript("Count not find item '" + attributeTargetValueString + "'");
		
	}


	
	@Then("^The browser is closed$")
	public void theBrowserIsClosed() {
	    driver.quit();
	    reporterHelper.log("Broswer closed");
	}



}	
