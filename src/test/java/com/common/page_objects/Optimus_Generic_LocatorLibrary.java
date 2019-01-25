package com.common.page_objects;

import org.openqa.selenium.By;


public class Optimus_Generic_LocatorLibrary  {

	public By ginger_logon_Heading = By.xpath("//h1/a[text() = 'Administration Panel']");
	public By ginger_logon_username_TextBox = By.id("Username");
	public By ginger_logon_password_TextBox = By.id("Password");
	public By ginger_logon_SignIn_Button = By.xpath("//input[@value = 'Sign in']");

	public By ginger_nav_users_Button = By.xpath("//a[text() = 'Users']");
	public By ginger_nav_userDisputes_Button = By.xpath("//a[text() = 'User disputes']");
	public By ginger_nav_registrationHistory_Button = By.xpath("//a[text() = 'Registration history']");
	public By ginger_nav_signOut_Link = By.id("SignOutButton");

	public By ginger_dashboard_Heading = By.xpath("//h1[text() = 'Dashboard']");
	public By ginger_users_Heading = By.xpath("//h1[text() = 'Users']");

	public By ginger_users_userIdentifier_TextBox = By.id("GingerIdentifier");
	public By ginger_users_search_Button = By.id("Search");
	
	public By ginger_users_totalCount_Heading = By.xpath("//h3[contains(text(), 'Total count: ')]");
	public By ginger_users_userList_RowItem = By.xpath("//div[contains(@id, 'user-')]");
	
	public By ginger_users_selectedRow_disputes_Link = By.xpath("//a[text() = 'Disputes']");
	public By ginger_users_selectedRow_allCreditReports_Link = By.xpath("//a[text() = 'All credit reports']");
	
	public By ginger_userCreditReports_Heading = By.xpath("//h1[contains(text(), 'User credit reports')]");
	public By ginger_userCreditReports_RowItem = By.xpath("//div[@id = 'userCreditReportsList']/div/div[contains(@class, 'mod-second-level')]");
	
	public By ginger_userCreditReports_selectedRow_viewCreditReport_Link = By.xpath("//a[text() = 'View credit report']");
	
	public By ginger_creditReport_CreditReportFor_Heading = By.xpath("//p[@class = 'mas'][contains(text(), 'Credit report for user')]");
	
	
	
	public By numero_logon_emailAddress_TextBox = By.id("userNameInput");
	public By numero_logon_password_TextBox = By.id("passwordInput");
	public By numero_logon_SignIn_Button = By.id("submitButton");
	
	public By numero_areYouAlready_confirm_checkbox = By.id("chkChangeAvailability");
	public By numero_areYouAlready_Login_Button = By.id("btnLogin");
	
	public By numero_main_Menu_Link = By.id("applicationMenu_view_41_menuHandle");
	public By numero_main_Reporting_MenuItem = By.xpath("//ul[@role = 'menu']//a[@aria-label = 'Reporting']");
	public By numero_main_ReportingQueries_MenuSubItem = By.xpath("//ul[@role = 'menu']//a[@aria-label = 'Results (Queries)']");
	public By numero_main_CDPOutstandingDisputes_MenuSubSubItem = By.xpath("//ul[@role = 'menu']//a[@aria-label = 'CDP Outstanding Disputes']");
	
	public By numero_main_CDPOutstandingDisputes_DisputeRows = By.xpath("//tr[@class = 'summaryList-row']");
	public By numero_main_WorkItem_ConsumerDetails_Heading = By.xpath("//span[contains(text(), 'Consumer Details')]");
	public By numero_main_WorkItem_CreditReports_Row = By.xpath("//div[contains(@class, 'manualDisputeCaseLinkingTable')]//div[contains(@class, 'ui-grid-canvas')]/*[.//div[contains(@class, 'ui-grid-cell-contents ng-binding ng-scope')]]");
	public By numero_main_WorkItem_NewVersion_Button = By.xpath("//button/span[contains(text(), 'New Version')]");
	public By numero_main_WorkItem_View_Button = By.xpath("//a[contains(text(), 'View')]");
	public By numero_main_WorkItem_Delete_Button = By.xpath("//span[text() = 'Delete']");
	public By numero_main_WorkItem_AreYouSure_Modal_Delete_Button = By.xpath("//div[contains(@class, 'modal-dialog')]//span[contains(text(), 'Delete')]");
	
	public By numero_main_body_not_busy = By.xpath("//html/body[@aria-busy = 'false'][not(@block-ui-active)]");
	
	public By numero_main_CreditReport_CreditReportFor_Heading = By.xpath("//h2[contains(text(), 'Credit Report For:')]");
	
	public By numero_main_Logout_Button = By.id("btnLogout");
	
	public By numero_signedOut_SignOut_Label = By.xpath("//div[contains(@class, 'instruction')][contains(text(), 'Sign out')]");
	
	public By numero_CDPOutstandingDisputes_DisputeCaseIdFilter_TextBox = By.xpath("//tr[contains(@class, 'summaryList-row')]//input[contains(@id, '7_tb')]");
	public By numero_CDPOutstandingDisputes_RecordsCount_Label = By.xpath("//span[contains(text(), 'Records found')] | //span[contains(text(), 'Record found')]");
	

	public By noddleAdmin_generic_header_UserDisputes_Link = By.xpath("//body//nav[contains(@class, 'primary-nav')]//a[contains(text(), 'User Disputes')]");
	public By noddleAdmin_userDisputesAdmin_Title = By.xpath("//body//div[contains(@class, 'page')]//div[contains(@class, 'mbl')]//h1[contains(text(), 'User Disputes administration')]");
	public By noddleAdmin_userDisputesAdmin_Search_Button = By.xpath("//body//div[contains(@class, 'main')]//button[contains(text(), 'Search')]");
	public By noddleAdmin_userDisputesAdmin_NoddleState_Select = By.xpath("//body//div[contains(@class, 'main')]//select[contains(@name, 'NoddleState')]");
	public By noddleAdmin_userDisputesAdmin_NoddleState_Select_Items = By.xpath("//body//div[contains(@class, 'main')]//select[contains(@name, 'NoddleState')]/option");
	public By noddleAdmin_userDisputesAdmin_Username_TextBox = By.xpath("//body//div[contains(@class, 'main')]//input[contains(@name, 'UserName')]");
	public By noddleAdmin_userDisputesAdmin_TotalCount_Heading = By.xpath("//body//div[contains(@class, 'main')]//div[@id = 'disputesList']//h2[contains(text(), 'Total count: ')]");
	public By noddleAdmin_userDisputesAdmin_dispute_table_item = By.xpath("//body//div[contains(@class, 'page')]//div[contains(@class, 'mbl')]//div[contains(@id, 'dispute-')][contains(@class, 'dispute-admin')]");
	
	public By noddle_generic_header_noddle_Title_Image= By.xpath("//header//img[contains(@src, 'noddle-logo')]");
	public By noddle_generic_header_Login_Button = By.xpath("//header//a[contains(@title, 'Log in')]");
	public By noddle_generic_header_Signup_Button = By.xpath("//header//a[contains(text(), 'Sign up')]");
	public By noddle_generic_header_LogOut_Button = By.xpath("//header//a[contains(@title, 'Log out')]");
	
	public By noddle_generic_header_secondaryNav_MyDashboard_Link = By.xpath("//header//nav[contains(@class, 'secondary-nav')]//a[contains(text(), 'My Dashboard')]");
	public By noddle_generic_header_secondaryNav_MyCreditReport_Link = By.xpath("//header//nav[contains(@class, 'secondary-nav')]//a[contains(text(), 'My Credit Report')]");
	public By noddle_generic_header_secondaryNav_NoddleExtras_Link = By.xpath("//header//nav[contains(@class, 'secondary-nav')]//a[contains(text(), 'Noddle Extras')]");
	public By noddle_generic_header_secondaryNav_CardMatcher_Link = By.xpath("//header//nav[contains(@class, 'secondary-nav')]//a[contains(text(), 'Card Matcher')]");
	public By noddle_generic_header_secondaryNav_LoanMatcher_Link = By.xpath("//header//nav[contains(@class, 'secondary-nav')]//a[contains(text(), 'Loan Matcher')]");
	public By noddle_generic_header_secondaryNav_Utilities_Link = By.xpath("//header//nav[contains(@class, 'secondary-nav')]//a[contains(text(), 'Utilities')]");
	public By noddle_generic_header_secondaryNav_MyAccount_Link = By.xpath("//header//nav[contains(@class, 'secondary-nav')]//a[contains(text(), 'My Account')]");

	public By noddle_generic_main_Login_Button = By.xpath("//main//input[@value='Log in']");
	public By noddle_generic_main_Continue_Button = By.xpath("//main//a[contains(text(), 'Continue')]");
	public By noddle_generic_main_ViewMuFullReport_Button = By.xpath("//main//a[contains(text(), 'View my full report')]");

	public By noddle_generic_cookies_acceptCookies_Button = By.xpath("//div[contains(@class, 'cc-cookies')]/a[contains(@class, 'cc-cookie-accept')]");
	public By noddle_generic_lighbox_popup = By.xpath("//div[@id = 'messages-lightbox'][contains(@style, 'display: block;')]");
	public By noddle_generic_lighbox_popup_close_link = By.xpath("//div[@id = 'messages-lightbox'][contains(@style, 'display: block;')]//a[contains(@class, 'close-x')]");
	
	
	
	
	public By noddle_home_main_Header_1 = By.xpath("//main//h1[contains(text(), 'Your credit report & score')]");
	
	public By noddle_login_main_Username_TextBox = By.xpath("//main//input[@id='Username']");
	public By noddle_login_main_Password_TextBox = By.xpath("//main//input[@id='Password']");
	public By noddle_login_main_RememberUsername_CheckBox = By.xpath("//main//input[@id='RememberUsername']");
	
	public By noddle_tsandcs_main_Header = By.xpath("//main//h2[contains(text(), 'New Terms and Conditions and Privacy Notice')]");
	
	public By noddle_account_summary_main_Header = By.xpath("//main//h1[contains(text(), 'My account summary')]");
	
	public By noddle_mycreditreport_main_Title = By.xpath("//main//h1[contains(text(), 'My credit report')]");
	public By noddle_mycreditreport_main_tabListItems_Links = By.xpath("//main//ul[contains(@class, 'credit-report-nav')]//a[contains(@class, 'credit-report-nav__link')]");
	public By noddle_mycreditreport_main_financialAccountInformation_reportLineItems = By.xpath("//main//div[@id='financialInformationOpenAccounts']/div[contains(@class, 'expandable-row')]");
	public By noddle_mycreditreport_main_publicInformation_reportLineItems = By.xpath("//main//div[@id='public-information']/div/div[contains(@class, 'expandable-row')]");
	public By noddle_mycreditreport_main_shortTermLoans_reportLineItems = By.xpath("//main//div[@id='modaOpenAccounts']/div[contains(@class, 'expandable-row')]");
	public By noddle_mycreditreport_main_addressLinks_reportLineItems = By.xpath("//main//div[@id='address-links']//div[contains(@class, 'address-details__item')]");
	public By noddle_mycreditreport_main_connectionsOtherNames_reportLineItems = By.xpath("//main//div[@id='connections-and-other-names']//div[contains(@class, 'credit-report-section-content')]//div[@class = 'expandable-row']");
	public By noddle_mycreditreport_main_connectionsOtherNames_FinancialLineItems = By.xpath("//main//div[@id='connections-and-other-names']//div[@class = 'expandable-row'][preceding::div[contains(@class, 'credit-report-subsection')]/h3[text() = 'Financial connections']][following::div[contains(@class, 'credit-report-subsection')]/h3[text() = 'Other names']]");
	public By noddle_mycreditreport_main_connectionsOtherNames_OtherNamesLineItems = By.xpath("//main//div[@id='connections-and-other-names']//div[@class = 'expandable-row'][preceding::div[contains(@class, 'credit-report-subsection')]/h3[text() = 'Other names']] ");
	
	public By noddle_raiseDisputeModal_Title = By.xpath("//div[contains(@id, 'DisputeTemplate_content')]//h2[contains(@class, 'modal-title')]");
	public By noddle_raiseDisputeCodeModal_Select = By.xpath("//div[contains(@id, 'DisputeTemplate_content')]//select[@name = 'DisputeCode']");
	public By noddle_raiseDisputeCodeModal_Select_Items = By.xpath("//div[contains(@id, 'DisputeTemplate_content')]//select[@name = 'DisputeCode']/option");
	public By noddle_raiseDisputeGroupNameModal_Select = By.xpath("//div[contains(@id, 'DisputeTemplate_content')]//select[@name = 'DisputeGroupName']");
	public By noddle_raiseDisputeGroupNameModal_Select_Items = By.xpath("//div[contains(@id, 'DisputeTemplate_content')]//select[@name = 'DisputeGroupName']/option");
	public By noddle_raiseDisputeModal_Yes_RadioButton = By.xpath("//div[contains(@id, 'DisputeTemplate_content')]//label[@for = 'HasConfirmed']");
	public By noddle_raiseDisputeModal_No_RadioButton = By.xpath("//div[contains(@id, 'DisputeTemplate_content')]//label[@for = 'HasNotConfirmed']");
	public By noddle_raiseDisputeModal_Corrected_Date_Field = By.xpath("//div[contains(@id, 'DisputeTemplate_content')]//input[@id = 'ExtraDateInfoFromCustomer']");
	public By noddle_raiseDisputeModal_TextArea = By.xpath("//div[contains(@id, 'DisputeTemplate_content')]//div[@id = 'extra-info-from-customer-wrapper'][contains(@style, 'display: block;')]//textarea");
	public By noddle_raiseDisputeModal_DatePicker_Second_Row_Second_Day = By.xpath("//div[contains(@class, 'datepicker')]//tbody/tr[2]/td[2]");
	public By noddle_raiseDisputeModal_First_RadioButton = By.xpath("//div[contains(@id, 'DisputeTemplate_content')]//div[@id = 'extra-info']//input[1]");
//	public By noddle_raiseDisputeModal_Over6YearsOld_RadioButton = By.xpath("//div[contains(@id, 'DisputeTemplate_content')]//input[contains(@value, 'This account is over 6 yrs old, closed and should be removed from my credit file')]");
//	public By noddle_raiseDisputeModal_AccountIsFraudulent_RadioButton = By.xpath("//div[contains(@id, 'DisputeTemplate_content')]//input[contains(@value, 'This account is fraudulent and should be removed from my credit file')]");
	public By noddle_raiseDisputeModal_SelectAddressModel_Heading = By.xpath("//div[@class='modal-content']//h4[contains(text(), 'Please select the address you wish to raise the dispute against')]");
	public By noddle_raiseDisputeModal_SelectAddressModel_Address_RadioButtons = By.xpath("//div[@class='modal-content']//input[contains(@class, 'form__radiobutton-input')]");
	public By noddle_raiseDisputeModal_SelectAddressModel_Address_RadioButton_Labels = By.xpath("//div[@class='modal-content']//label[contains(@id, 'LinkAddress')]");
	public By noddle_raiseDisputeModal_SelectAddressModel_UseThisAddress_Button = By.xpath("//div[@class='modal-content']//a[@id = 'submit-form']");
	
	public By noddle_raiseDisputeModal_Submit_Button = By.xpath("//div[contains(@id, 'DisputeTemplate_content')]//a[contains(text(), 'Submit')]");
	public By noddle_raiseDisputeModal_Cancel_Button = By.xpath("//div[contains(@id, 'DisputeTemplate_content')]//a[contains(text(), 'Cancel')]");

}

