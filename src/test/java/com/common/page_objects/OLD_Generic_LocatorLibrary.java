package com.common.page_objects;

import org.openqa.selenium.By;


public class OLD_Generic_LocatorLibrary  {
	
	public By kalibrate_login_LoginButton = By.xpath(".//*[@id='login-form']/div/form/button");
	public By kalibrate_login_PasswordTextBox = By.xpath(".//*[@id='login-form']/div/form/input[2]");
	public By kalibrate_login_UsernameTextBox = By.xpath(".//*[@id='login-form']/div/form/input[1]");
	public By kalibrate_login_LoginErrorMessage = By.xpath("//div[@id='login-form']//div[contains(@class, 'error login-error')]");
	
	public By kalibrate_main_ConfigureWidgetsIcon = By.xpath("//img[@title='Configure Widgets and Quick Widgets']");
	public By kalibrate_main_HamburgerIcon = By.xpath(".//*[@id='MainMenu'][not(contains(@class, 'loggedout'))]/div[@class='menu-block settings']/img");
	public By kalibrate_main_MainMenuLogoutItem = By.xpath(".//*[@id='SettingsMenu']/ul[3]/li");
	public By kalibrate_main_MarketPricingWidgetIcon = By.xpath("//div[@title='Market Pricing']");
	public By kalibrate_main_PriceRequestWidgetIcon = By.xpath("//div[@title='Price Request']");
	public By kalibrate_main_SearchWidgetIcon = By.xpath("//div[@title='Search']");
	public By kalibrate_main_SiteStrategyWidgetIcon = By.xpath("//div[@title='Site Strategy']");
	public By kalibrate_main_ToolsWidgetIcon = By.xpath("//div[@id='QuickWidgetMenu']//li[contains(text(), 'Tools')]");

	public By kalibrate_main_WorkspaceContainers = By.xpath("//div[starts-with(@id, 'container')]");
	public By kalibrate_main_WorkspaceLastContainerSynced = By.xpath("//div[contains(@id, 'container')][@class='widget-container equal-width ng-not-empty ui-droppable last-container']");
	
	public By kalibrate_main_WorkspaceContainer1 = By.id("container1");
	public By kalibrate_main_WorkspaceContainer2 = By.id("container2");
	public By kalibrate_main_WorkspaceContainer3 = By.id("container3");
	
	public By kalibrate_main_Workspace2WideContainer1Synced = By.xpath("//div[@id='container1'][@class='widget-container equal-width ng-not-empty ui-droppable']");
	public By kalibrate_main_Workspace2WideContainer2Synced = By.xpath("//div[@id='container2'][@class='widget-container equal-width ng-not-empty ui-droppable last-container']");
	public By kalibrate_main_Workspace3WideContainer1Synced = By.xpath("//div[@id='container1'][@class='widget-container equal-width ng-not-empty ui-droppable'] | //div[@id='container1'][@class='widget-container equal-width ui-droppable']");
	public By kalibrate_main_Workspace3WideContainer2Synced = By.xpath("//div[@id='container2'][@class='widget-container equal-width ng-not-empty ui-droppable'] | //div[@id='container2'][@class='widget-container equal-width ui-droppable']");
	public By kalibrate_main_Workspace3WideContainer3Synced = By.xpath("//div[@id='container3'][@class='widget-container equal-width ng-not-empty ui-droppable last-container'] | //div[@id='container3'][@class='widget-container equal-width ui-droppable last-container']");

	public By kalibrate_main_WorkspaceMenuHeader = By.xpath(".//*[@id='MainMenu'][not(contains(@class, 'loggedout'))]/div[@class='menu-block workspaces']/span[contains(@data-ng-click, 'toggleMenu')]");
	public By kalibrate_main_WorkspaceMenuCollapsed = By.xpath(".//*[@id='MainMenu'][not(contains(@class, 'loggedout'))]/div[@class='menu-block workspaces']");
	public By kalibrate_main_WorkspaceMenuExpanded = By.xpath(".//*[@id='MainMenu'][not(contains(@class, 'loggedout'))]/div[@class='menu-block workspaces current']");
	
	public By kalibrate_main_WorkspaceMenuAddWorkspaceItem = By.xpath("//img[contains(@src, 'Add_Workspace')]/..");
//	public By kalibrate_main_WorkspaceMenuAddWorkspaceNameInputField = By.xpath(".//input[@placeholder='Enter Workspace name']");
	public By kalibrate_main_WorkspaceMenuAddWorkspaceNameInputField = By.xpath("//div[contains(@class, 'selected')]//input[@placeholder='Enter Workspace name']");
	
	public By kalibrate_main_WorkspaceMenuAddWorkspaceLayout1ColumnIcon = By.xpath("//div[contains(@class, 'selected')]//img[@title='Screen Layout (1 column)']");
	
//	public By kalibrate_main_WorkspaceMenuDeleteWorkspaceItem = By.xpath(".//div[@class='workspace-block selected']//button[contains(text(),'Delete')]");
	public By kalibrate_main_WorkspaceMenuDeleteWorkspaceItem = By.xpath(".//div[contains(@class, 'workspace-block')]//button[contains(text(),'Delete')]");
	public By kalibrate_main_WorkspaceMenuSelectedWorspace = By.xpath(".//div[contains(@class, 'workspace-block')][contains(@class, 'selected')]");
	public By kalibrate_main_WorkspaceMenuSelectedWorspaceSettingsIcon = By.xpath(".//div[contains(@class, 'workspace-block')][contains(@class, 'selected')]//img[@title= 'Settings']");
	
	public By kalibrate_main_WidgetContainers = By.xpath("//div[@widget='widget'][contains(@name, 'widget')]");
	
	public By kalibrate_main_WidgetHelper = By.xpath(".//div[contains(@class, 'widget-helper')]");
	
	public By kalibrate_main_Sync = kalibrate_main_WorkspaceContainer1;

	public By kalibrate_mapWidget_OwnSiteBubbleIcon = By.xpath("//canvas[contains(@class, 'own-site')][not(contains(@class, 'teardrop'))]");
	public By kalibrate_mapWidget_OwnSiteTearDropIcon = By.xpath("//canvas[contains(@class, 'own-site')][contains(@class, 'teardrop')]");
	public By kalibrate_mapWidget_OwnSiteAnyIcon = By.xpath("//canvas[contains(@class, 'own-site')]");
	
	public By kalibrate_mapWidget_SiteBubbleIcon = By.xpath("//canvas[contains(@class, ' site')][not(contains(@class, 'own-site'))][not(contains(@class, 'teardrop'))]");
	public By kalibrate_mapWidget_SiteTearDropIcon = By.xpath("//canvas[contains(@class, ' site')][contains(@class, 'own-site')][contains(@class, 'teardrop')]");
	public By kalibrate_mapWidget_SiteAnyIcon = By.xpath("//canvas[contains(@class, ' site')][contains(@class, 'own-site')]");

	public By kalibrate_mapWidget_PricingBubble = By.xpath("//bubble[contains(@class, 'pricing-bubble')]");
	public By kalibrate_mapWidget_PricingBubbleAveragrSiteMargin = By.xpath("//bubble[contains(@class, 'pricing-bubble')]//label[contains(@title, 'Average Site Margin')]");
	
	public By kalibrate_mapWidget_GoogleMapsPegman = By.xpath("//k-map-widget//div[contains(@aria-label, 'Street View Pegman Control')]");
	public By kalibrate_mapWidget_WhiteGoogleText_ClickToOpenInWindow_Image = By.xpath("//k-map-widget//a[contains(@title, 'Click to see this area on Google Maps')]");
	public By kalibrate_mapWidget_SearchIcon = By.xpath("//k-map-widget//map-menu//img[contains(@title, 'Search')]");
	public By kalibrate_mapWidget_SettingsIcon = By.xpath("//k-map-widget//map-menu//img[contains(@title, 'Settings')]");
	public By kalibrate_mapWidget_PointsIcon = By.xpath("//k-map-widget//map-menu//img[contains(@title, 'Points')]");
	public By kalibrate_mapWidget_ShapesIcon = By.xpath("//k-map-widget//map-menu//img[contains(@title, 'Shapes')]");
	public By kalibrate_mapWidget_ToolsIcon = By.xpath("//k-map-widget//map-menu//img[contains(@title, 'Tools')]");
	public By kalibrate_mapWidget_Search_FilterInput = By.xpath("//k-map-widget//div[@class='adv-search']//input[contains(@placeholder, 'Enter search text')]");
	public By kalibrate_mapWidget_Search_SearchButton = By.xpath("//k-map-widget//div[@class='adv-search']//div[contains(@class, 'search-input')]/button[contains(., 'Search')]");
	public By kalibrate_mapWidget_Search_SearchButtonActive = By.xpath("//k-map-widget//div[@class='adv-search']//div[contains(@class, 'search-input')]/button[contains(., 'Search')]/img[contains(@style, 'display: inline;')]");
	public By kalibrate_mapWidget_Search_SearchButtonNotActive = By.xpath("//k-map-widget//div[@class='adv-search']//div[contains(@class, 'search-input')]/button[contains(., 'Search')]/img[contains(@style, 'display: none;')]");
	public By kalibrate_mapWidget_Search_ResultsCountText = By.xpath("//k-map-widget//div[@class='adv-search']//div[@class='search-results-outer']//span[contains(text(), 'Showing')]");
	public By kalibrate_mapWidget_Search_ResultsCountText_SingleResult = By.xpath("//k-map-widget//div[@class='adv-search']//div[@class='search-results-outer']//span[contains(text(), 'Showing 1 to 1 of 1 matches')]");
	
	
	public By kalibrate_mapWidget_Sync = null;

	
	public By kalibrate_intelWidget_AverageBrandPrice_NoSiteSelected = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-content')]//div[contains(@class, 'chart-div')]//div[contains(@class, 'chart-name')][starts-with(@title, 'Average brand price   ')]");
	public By kalibrate_intelWidget_AverageBrandPrice_SiteSelected = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-content')]//div[contains(@class, 'chart-div')]//div[contains(@class, 'chart-name')][starts-with(@title, 'Average brand price - ')]");

	public By kalibrate_intelWidget_ResultSetCounter = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-footer-right')]//span[contains(@title, 'Number of own sites')]");
	public By kalibrate_intelWidget_ProfitabilityRankingGraphLabel_NoSiteSelected = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-content')]//div[contains(@class, 'chart-div')]//div[contains(@class, 'chart-name')][(@title = 'Profitability ranking  ')]");
	public By kalibrate_intelWidget_AverageBrandPriceGraphLabel_NoSiteSelected = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-content')]//div[contains(@class, 'chart-div')]//div[contains(@class, 'chart-name')][contains(@title, 'Average brand price   ')]"); // 2.4.1
	public By kalibrate_intelWidget_ProfitabilityRankingGraphLabel_SiteSelected = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-content')]//div[contains(@class, 'chart-div')]//div[contains(@class, 'chart-name')][starts-with(@title, 'Profitability ranking - ')]");
	public By kalibrate_intelWidget_PumpPriceVsTotalCostLabel_NoSiteSelected = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-content')]//div[contains(@class, 'chart-div')]//div[contains(@class, 'chart-name')][starts-with(@title, 'Pump price vs total cost   ')]");
	public By kalibrate_intelWidget_PumpPriceVsTotalCostLabel_SiteSelected = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-content')]//div[contains(@class, 'chart-div')]//div[contains(@class, 'chart-name')][starts-with(@title, 'Pump price vs total cost - ')]");
	
	public By kalibrate_intelWidget_SearchIcon = By.xpath("//div[@name='k-intel-widget'][not(contains(@class, 'refreshing'))]//div[contains(@class, 'widget-content')]//k-intel-widget//img[contains(@title, 'Search')]");
	public By kalibrate_intelWidget_VisualizeIcon = By.xpath("//div[@name='k-intel-widget'][not(contains(@class, 'refreshing'))]//div[contains(@class, 'widget-content')]//k-intel-widget//img[contains(@title, 'Visualize')]");
	public By kalibrate_intelWidget_SetupCustomChartsIcon = By.xpath("//div[@name='k-intel-widget'][not(contains(@class, 'refreshing'))]//div[contains(@class, 'widget-content')]//k-intel-widget//img[contains(@title, 'Setup Custom Charts')]");
	public By kalibrate_intelWidget_SettingsIcon = By.xpath("//div[@name='k-intel-widget'][not(contains(@class, 'refreshing'))]//div[contains(@class, 'widget-content')]//k-intel-widget//img[contains(@title, 'Settings')]");
	public By kalibrate_intelWidget_SaveAndExportIcon = By.xpath("//div[@name='k-intel-widget'][not(contains(@class, 'refreshing'))]//div[contains(@class, 'widget-content')]//k-intel-widget//img[contains(@title, 'Save & Export')]");
	
	
	public By kalibrate_intelWidget_Sync = kalibrate_intelWidget_SearchIcon;		
	
	public By kalibrate_pumpPriceUpdateWidget_ConfigurationIcon = By.xpath("//site-mixer-widget//img[contains(@title, 'Configuration')]");
	public By kalibrate_pumpPriceUpdateWidget_Sync = kalibrate_pumpPriceUpdateWidget_ConfigurationIcon;	
	
	public By kalibrate_pricingWidget_Title= null; //By.xpath("//div[@name='pricing-widget']//span[contains(@class, 'widget-head-pricing')]");
	public By kalibrate_pricingWidget_RunRate = By.xpath("//div[@name='pricing-widget'][not(contains(@class, 'refreshing'))]//div[contains(@class, 'run-rate')]/span[contains(text(), 'Run rate:')]");
	public By kalibrate_pricingWidget_ErrorMessage = By.xpath("//div[@name='pricing-widget'][contains(@class, 'refreshing')]//div[contains(@class, 'error-message')]");
	public By kalibrate_pricingWidget_PleaseRefreshErrorMessage = By.xpath("//div[@name='pricing-widget']//div[contains(@class, 'error-message')][contains(.,'')]");
	public By kalibrate_pricingWidget_PleaseRefreshErrorMessage2 = By.xpath("//div[@name='pricing-widget']//div[contains(@class, 'error-message')][contains(.,'Prices were not applied.  Please refresh the widget and try again.')]");
	public By kalibrate_pricingWidget_AnyErrorMessage = By.xpath("//div[@name='pricing-widget']//div[contains(@class, 'error-message')]");
	
	
	public By kalibrate_pricingWidget_WidgetLinkedIcon = By.xpath("//div[@name='pricing-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Widget Linked')]");
	public By kalibrate_pricingWidget_ReloadWidgetIcon = By.xpath("//div[@name='pricing-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Reload Widget')]");
	public By kalibrate_pricingWidget_WidgetSettingsIcon = By.xpath("//div[@name='pricing-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Widget Settings')]");
	public By kalibrate_pricingWidget_MaximimseWidgetIcon = By.xpath("//div[@name='pricing-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Maximize Widget')]");
	public By kalibrate_pricingWidget_CloseWidgetIcon = By.xpath("//div[@name='pricing-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Close Widget')]");
	
	public By kalibrate_pricingWidget_ConfigurationIcon = By.xpath("//div[@name='pricing-widget']//div[contains(@class, 'widget-menu')]//img[@title='Configuration']");
	public By kalibrate_pricingWidget_SaveAndExportIcon = By.xpath("//div[@name='pricing-widget']//div[contains(@class, 'widget-menu')]//img[@title='Save & Export']");
	public By kalibrate_pricingWidget_Configuration_PricingItems = null;  // See child class definition of locator
	public By kalibrate_pricingWidget_Configuration_SelectedItemsHeader = By.xpath("//div[@name='pricing-widget']//div[contains(text(), 'Selected Pricing Data Items')]");
	public By kalibrate_pricingWidget_Configuration_AvailableItemsHeader = By.xpath("//div[@name='pricing-widget']//div[contains(@class, 'pricing-group-available-header')]");
	public By kalibrate_pricingWidget_Configuration_SaveAsDefaultButton = By.xpath("//div[@name='pricing-widget']//button[contains(., 'Save as default')]");
	
	
	
//	public By kalibrate_pricingWidget_ProposedPrices_Inputs = By.xpath("//div[@name='pricing-widget']//div[@data-section='pricing-proposed-price']//input[@type='text']");
	public By kalibrate_pricingWidget_ProposedPrices_Inputs = By.xpath("//div[@name='pricing-widget']//div[@data-section='pricing-proposed-price']//div[@ng-model='product']");
	
	
	public By kalibrate_pricingWidget_ApplyButton = By.xpath("//div[@name='pricing-widget']//button[contains(., 'Apply')][not(contains(@disabled, 'disabled'))]");
	public By kalibrate_pricingWidget_RejectButton = By.xpath("//div[@name='pricing-widget']//button[contains(., 'Reject')][not(contains(@disabled, 'disabled'))]");
//	public By kalibrate_pricingWidget_Sync = By.xpath("//div[@name='pricing-widget']//div[contains(@class, 'run-rate')]/span | //div[@name='pricing-widget']//div[contains(@class, 'error-message')]");
//	public By kalibrate_pricingWidget_Sync = By.xpath("//div[@name='pricing-widget']//button[contains(., 'Apply')][not(contains(@disabled, 'disabled'))]");
	public By kalibrate_pricingWidget_Sync = kalibrate_pricingWidget_ApplyButton;

	
	public By kalibrate_multiPricingWidget_ProductsTableHeaders = By.xpath("//div[@name='multi-pricing-widget']//div[contains(@class, 'pricing-container multi')]//div[contains(@class, 'pricing-product')]");
	public By kalibrate_multiPricingWidget_SelectAllSitesCheckbox = By.xpath("//div[@name='multi-pricing-widget']//input[contains(@id, 'AllSitesCheck')]/../label");
	public By kalibrate_multiPricingWidget_ShowGeneratePricesPanelButton = By.xpath("(//div[@name='multi-pricing-widget']//button[contains(., 'Generate Prices')])[1]");
	public By kalibrate_multiPricingWidget_ExportCurrentPriceButton = By.xpath("(//div[@name='multi-pricing-widget']//button[contains(., 'Export Current Price')])[1]");
	public By kalibrate_multiPricingWidget_ApplySelectedSitesButton = By.xpath("//div[@name='multi-pricing-widget']//div[contains(@class, 'pricing-bottom-panel')]//button[contains(., 'Apply')][not(contains(., 'Note'))]");
	public By kalibrate_multiPricingWidget_ApplySelectedSitesButton_NotBusy = By.xpath("//div[@name='multi-pricing-widget']//div[contains(@class, 'pricing-bottom-panel')]//button[contains(., 'Apply')][not(contains(., 'Note'))]/img[@style='display: none;']");
	public By kalibrate_multiPricingWidget_SitePricesAppliedIcons = By.xpath("//div[@name='multi-pricing-widget']//div[@class='flex-container pricing-title']//span[@title='Site prices applied']"); //'Site waiting', 'Site applying prices', 'Site prices not applied'
	public By kalibrate_multiPricingWidget_ApplySelectedSitesWithNoteButton = By.xpath("//div[@name='multi-pricing-widget']//button[contains(., 'Note')]");
	public By kalibrate_multiPricingWidget_RejectSelectedSitesButton = By.xpath("//div[@name='multi-pricing-widget']//button[contains(@text, 'Reject')][contains(@text, 'Sites')]");
	public By kalibrate_multiPricingWidget_GeneratePricesButton = By.xpath("//div[@name='multi-pricing-widget']//div[@class='pricing-generate-panel'][contains(@style, 'display: block')]//button[contains(., 'Generate Prices')][not(contains(@disabled, 'disabled'))]");
	public By kalibrate_multiPricingWidget_GenerateOptionsSelect = By.xpath("//div[@name='multi-pricing-widget']//div[@class='pricing-generate-panel'][contains(@style, 'display: block') or contains(@style, 'display: none;')]//select");
	public By kalibrate_multiPricingWidget_CloseWidgetIcon = By.xpath("//div[@name='multi-pricing-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Close Widget')]");
	
	public By kalibrate_multiPricingWidget_SearchIcon = By.xpath("//div[@name='multi-pricing-widget']//div[contains(@class, 'widget-menu')]//img[contains(@title, 'Search')]");
	public By kalibrate_multiPricingWidget_ConfigurationIcon = By.xpath("//div[@name='multi-pricing-widget']//div[contains(@class, 'widget-menu')]//img[contains(@title, 'Configuration')]");
	public By kalibrate_multiPricingWidget_SaveAndExportIcon = By.xpath("//div[@name='multi-pricing-widget']//div[contains(@class, 'widget-menu')]//img[contains(@title, 'Save & Export')]");
	public By kalibrate_multiPricingWidget_SettingsIcon = By.xpath("//div[@name='multi-pricing-widget']//div[contains(@class, 'widget-menu')]//img[contains(@title, 'Settings')]");

	public By kalibrate_multiPricingWidget_Settings_SitesPerPageTextBox = By.xpath("//div[@name='multi-pricing-widget']//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'pricing-settings')]//input");

	
	public By kalibrate_multiPricingWidget_SiteTable = By.xpath("//div[@name='multi-pricing-widget']//div[@class='pricing-container multi']");
	public By kalibrate_multiPricingWidget_SiteTable_RowItems = By.xpath("//div[@name='multi-pricing-widget']//div[@class='pricing-container multi']//div[contains(@class, 'pricing-div-site')]");
	public By kalibrate_multiPricingWidget_SiteTable_RowItems_SiteStateIcons = By.xpath("//div[@name='multi-pricing-widget']//div[@class='pricing-container multi']//div[contains(@class, 'pricing-div-site')]//div[contains(@class, 'pricing-title')]//span[contains(@class, 'site-state')]");
	public By kalibrate_multiPricingWidget_SiteTable_SiteProcessingIcon = By.xpath("//div[@name='multi-pricing-widget']//div[@class='pricing-container multi']//span[contains(@class, 'site-state')][contains(@class, 'processing-on')][not(contains(@class, 'ng-hide'))]");
	public By kalibrate_multiPricingWidget_SiteTable_SiteNotProcessingIcon = By.xpath("//div[@name='multi-pricing-widget']//div[@class='pricing-container multi']//span[contains(@class, 'site-state')][contains(@class, 'processing-off')][not(contains(@class, 'ng-hide'))]");
	public By kalibrate_multiPricingWidget_SiteTable_SiteAwaitingReviewIcon = By.xpath("//div[@name='multi-pricing-widget']//div[@class='pricing-container multi']//span[contains(@class, 'site-state')][contains(@class, 'review-on')][not(contains(@class, 'ng-hide'))]");
	public By kalibrate_multiPricingWidget_SiteTable_SiteNotAwaitingReviewIcon = By.xpath("//div[@name='multi-pricing-widget']//div[@class='pricing-container multi']//span[contains(@class, 'site-state')][contains(@class, 'review-off')][not(contains(@class, 'ng-hide'))]");
	
	public By kalibrate_multiPricingWidget_SiteTable_FirstPagePaginationButton = By.xpath("(//div[@name='multi-pricing-widget']//li[@title = 'First page'])[2]");
	public By kalibrate_multiPricingWidget_SiteTable_PaginationNumberedButtons = By.xpath("//div[@name='multi-pricing-widget']//li[contains(@ng-repeat, 'page in pricingPages')]");
	public By kalibrate_multiPricingWidget_SiteTable_LastPagePaginationButton = By.xpath("(//div[@name='multi-pricing-widget']//li[@title = 'Last page'])[2]");
	
	public By kalibrate_multiPricingWidget_ReloadWidgetIcon = By.xpath("//div[@name='multi-pricing-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Reload Widget')]");		
	public By kalibrate_multiPricingWidget_Sync = kalibrate_multiPricingWidget_SelectAllSitesCheckbox;

	
	public By kalibrate_gettingStartedWidget_Title = By.xpath("//div[@id='main-content']//h1[contains(text(), 'Getting to know Kalibrate')]");
	public By kalibrate_gettingStartedWidget_Sync = kalibrate_gettingStartedWidget_Title;
	

	public By kalibrate_administratorWidget_UsersCard = By.xpath("//administrator-widget//div[contains(@class, 'default-card administrator')]//div[contains(text(), 'Users')]");
	public By kalibrate_administratorWidget_Sync = kalibrate_administratorWidget_UsersCard;

	public By kalibrate_dataManagerWidget_DataManagerBreadcrumb = By.xpath("//manage-data-widget//span[contains(@title, 'Data Manager')]");
	public By kalibrate_dataManagerWidget_Sync = kalibrate_dataManagerWidget_DataManagerBreadcrumb;

	public By kalibrate_eventsManagerWidget_Header = By.xpath("//manage-events-widget//div[contains(@class, 'event-header-div')]");
	public By kalibrate_eventsManagerWidget_Sync = kalibrate_eventsManagerWidget_Header;
	
	public By kalibrate_exportManagerWidget_ExportManagerBreadcrumb = By.xpath("//manage-export-widget//div[contains(@class, 'default-breadcrumbs')]//span[contains(text(), 'Export Manager')]");
	public By kalibrate_exportManagerWidget_Sync = kalibrate_exportManagerWidget_ExportManagerBreadcrumb;

	public By kalibrate_batchAuditWidget_SettingsIcon = By.xpath("//batch-audit-widget//img[contains(@title, 'Settings')]");
	public By kalibrate_batchAuditWidget_TableHeaderColumnLabelDate = By.xpath("//batch-audit-widget//table/tbody/tr/th[contains(text(), 'Date')]");
	public By kalibrate_batchAuditWidget_TableDataRows = By.xpath("//batch-audit-widget//table/tbody/tr[contains(@data-ng-repeat, 'audit in batchAudits')]");
	public By kalibrate_batchAuditWidget_TableDataFirstRowPopulated = By.xpath("//batch-audit-widget//table/tbody/tr[contains(@data-ng-repeat, 'audit in batchAudits')][1]/td[1][contains(translate(text(),'0123456789',''),'// : ')]");
//	public By kalibrate_batchAuditWidget_Sync = kalibrate_batchAuditWidget_TableDataFirstRowPopulated;
	public By kalibrate_batchAuditWidget_Sync = kalibrate_batchAuditWidget_TableHeaderColumnLabelDate;
	

	public By kalibrate_configurationWidget_TableHeaderColumnLabelConfiguration = By.xpath("//configuration-widget//table/tbody/tr/th[contains(text(), 'Configuration')]");
	public By kalibrate_configurationWidget_TableDataRows = By.xpath("//configuration-widget//table/tbody[contains(@data-ng-repeat, 'configuration in configurations')]");
	public By kalibrate_configurationWidget_TableDataFirstRowPopulated = By.xpath("//configuration-widget//table/tbody[contains(@data-ng-repeat, 'configuration in configurations')][1]/tr/td[1]/div[. !='']");
	public By kalibrate_configurationWidget_Sync = kalibrate_configurationWidget_TableDataFirstRowPopulated;

	public By kalibrate_ETLLogWidget_TableHeaderColumnLabelDescription = By.xpath("//etl-log-widget//table/tbody/tr/th[contains(@data-ng-repeat, 'column in columnsInfo')]//span[contains(text(), 'Description')]");
	public By kalibrate_ETLLogWidget_TableDataRows = By.xpath("//etl-log-widget//table/tbody[contains(@data-ng-repeat, 'log in etlLogs')]");
	public By kalibrate_ETLLogWidget_TableDataFirstRowPopulated = By.xpath("//etl-log-widget//table/tbody[contains(@data-ng-repeat, 'log in etlLogs')][1]/tr/td[1][. !='']");
	public By kalibrate_ETLLogWidget_Sync = kalibrate_ETLLogWidget_TableHeaderColumnLabelDescription;


	public By kalibrate_importLogWidget_TableHeaderColumnLabelFile = By.xpath("//import-log-widget//table/tbody/tr/th[contains(@data-ng-repeat, 'column in dataset.columns')][contains(text(), 'File')]");
	public By kalibrate_importLogWidget_TableDataRows = By.xpath("//import-log-widget//table/tbody/tr[contains(@ng-repeat, 'in datasetData')]");
	public By kalibrate_importLogWidget_TableDataFirstRowPopulated = By.xpath("//import-log-widget//table/tbody/tr[contains(@ng-repeat, 'in datasetData')][1]/td[1][. !='']");
	public By kalibrate_importLogWidget_Sync = kalibrate_importLogWidget_TableHeaderColumnLabelFile;
	

	public By kalibrate_installLogWidget_TableHeaderColumnLabelComponent = By.xpath("//install-log-widget//table/tbody/tr/th[contains(text(), 'Component')]");
	public By kalibrate_installLogWidget_TableDataRows = By.xpath("//install-log-widget//table/tbody/tr[contains(@data-ng-repeat, 'history in installationHistories')]");
	public By kalibrate_installLogWidget_TableDataFirstRowPopulated = By.xpath("//install-log-widget//table/tbody/tr[contains(@data-ng-repeat, 'history in installationHistories')][1]/td[1][. !='']");
	public By kalibrate_installLogWidget_Sync = kalibrate_installLogWidget_TableHeaderColumnLabelComponent;

	public By kalibrate_systemHealthCheckWidget_TableDataRows = By.xpath("//system-health-check-widget//div[contains(@class, 'default-property')]");
	public By kalibrate_systemHealthCheckWidget_TableDataPriceNetVersionRow = By.xpath("//system-health-check-widget//div[contains(@class, 'default-property')]/div[.//div[contains(text(), 'PriceNet version')]]");
	public By kalibrate_systemHealthCheckWidget_TableDataPriceNetVersionRowValuePopulated = By.xpath("//system-health-check-widget//div[contains(@class, 'default-property')]/div[.//div[contains(text(), 'PriceNet version')]]/div[2][. !='']");
	public By kalibrate_systemHealthCheckWidget_Sync = kalibrate_systemHealthCheckWidget_TableDataPriceNetVersionRowValuePopulated;

	public By kalibrate_notesWidget_TabLabelGlobalNotes = By.xpath("//notes-widget//ul[contains(@class, 'nav-tabs')]/li[@heading='Global Notes']");
	public By kalibrate_notesWidget_GlobalNotesTab_CurrentSelectionCheckbox = By.xpath("//notes-widget//global-notes//div[contains(@class, 'check-item')]");
	public By kalibrate_notesWidget_Sync = kalibrate_notesWidget_GlobalNotesTab_CurrentSelectionCheckbox;

	public By kalibrate_RSSFeedWidget_URLTextField = By.xpath("//rss-feed-widget//input[contains(@placeholder, 'Enter RSS Feed URL')]");
	public By kalibrate_RSSFeedWidget_Sync = kalibrate_RSSFeedWidget_URLTextField;

	public By kalibrate_toDoWidget_newToDoTextField = By.xpath("//to-do-list-widget//input[contains(@placeholder, 'Enter new to do')]");
	public By kalibrate_toDoWidget_Sync = kalibrate_toDoWidget_newToDoTextField;
	
	public By kalibrate_twitterWidget_newToDoTextField = By.xpath("//tweet-widget//input[contains(@placeholder, 'Enter Twitter @reply')]");
	public By kalibrate_twitterWidget_Sync = kalibrate_twitterWidget_newToDoTextField;

	public By kalibrate_universityWidget_KalibrateIcon = By.xpath("//university-widget//div[contains(@class, 'uni-info')]/h3[.='Kalibrate']");
	public By kalibrate_universityWidget_Sync = kalibrate_universityWidget_KalibrateIcon;

	public By kalibrate_userSettingsWidget_TabLabelSettings = By.xpath("//user-widget//ul[contains(@class, 'nav-tabs')]/li[@heading='Settings']");
	public By kalibrate_userSettingsWidget_TableDataLanguageRow = By.xpath("//user-widget//div[contains(@class, 'default-property')]/div[.//div[contains(text(), 'Language')]]");
	public By kalibrate_userSettingsWidget_TableDataLanguageRowValuePopulated = By.xpath("//user-widget//div[contains(@class, 'default-property')]/div[.//div[contains(text(), 'Language')]]/div[2]/div[@class='select-box']//option[@selected='selected'][. !='']");
	public By kalibrate_userSettingsWidget_Sync = kalibrate_userSettingsWidget_TableDataLanguageRowValuePopulated;

	public By kalibrate_sevenElementsWidget_PricingIntelligenceHeader = By.xpath("//seven-elements-widget//div[contains(@data-ng-repeat, 'item in sevenElementsService.data.items')]//div[contains(@class, 'pricing-intel-title-div')][contains(., 'Pricing Intelligence')]");
	public By kalibrate_sevenElementsWidget_Sync = kalibrate_sevenElementsWidget_PricingIntelligenceHeader;

	public By kalibrate_sevenElementsOtherWidget_7eImage = By.xpath("//element-widget//div[contains(@class, 'elements-div')]/img");
	public By kalibrate_sevenElementsOtherWidget_Sync = kalibrate_sevenElementsOtherWidget_7eImage;

	public By kalibrate_reportViewerWidget_SearchIcon = By.xpath("//report-viewer-widget//img[contains(@title, 'Search')]");
	public By kalibrate_reportViewerWidget_ReportsIcon = By.xpath("//report-viewer-widget//img[contains(@title, 'Reports')]");
	public By kalibrate_reportViewerWidget_SettingsIcon = By.xpath("//report-viewer-widget//img[contains(@title, 'Settings')]");
	public By kalibrate_reportViewerWidget_Sync = kalibrate_reportViewerWidget_SearchIcon;
	
	public By kalibrate_siteManagerWidget_SearchIcon = By.xpath("//manage-sites-widget//img[contains(@title, 'Search')]");
	public By kalibrate_siteManagerWidget_ConfigurationIcon = By.xpath("//manage-sites-widget//img[contains(@title, 'Configuration')]");
	public By kalibrate_siteManagerWidget_Sync = kalibrate_siteManagerWidget_SearchIcon;

	public By kalibrate_siteMetricsWidget_SetupGroupsIcon = By.xpath("//site-metrics-widget//img[contains(@title, 'Select Groups')]");
	public By kalibrate_siteMetricsWidget_SelectGroupsIcon = By.xpath("//site-metrics-widget//img[contains(@title, 'Setup Groups')]");
	public By kalibrate_siteMetricsWidget_Sync = kalibrate_siteMetricsWidget_SetupGroupsIcon;
	
	public By kalibrate_sitePlannerWidget_SearchIcon = By.xpath("//planner//img[contains(@title, 'Search')]");
	public By kalibrate_sitePlannerWidget_Sync = kalibrate_sitePlannerWidget_SearchIcon;

	public By kalibrate_marketPricingWidget_ActiveGeneralPriceChanges_BlockHeader = By.xpath("//market-pricing-widget//div[contains(@class, 'block-header')]//div[contains(@class, 'block-title')][contains(text(), 'Active General Price Changes')]");
	public By kalibrate_marketPricingWidget_ActiveGeneralPriceChanges_AddGPCButton = By.xpath("//market-pricing-widget//div[contains(@title, 'Add General Price Change')]");
	public By kalibrate_marketPricingWidget_ActiveGeneralPriceChanges_ExistingGPCButton = By.xpath("//market-pricing-widget//div[contains(@title, 'Existing GPC')]");
	public By kalibrate_marketPricingWidget_ActiveGeneralPriceChanges_SetActualPriceGPCButton = By.xpath("//market-pricing-widget//div[contains(@title, 'Set Actual Price GPC')]");
	public By kalibrate_marketPricingWidget_ActiveGeneralPriceChanges_IncreaseDecreaseButton = By.xpath("//market-pricing-widget//div[contains(@title, 'Increase/Decrease GPC')]");
	public By kalibrate_marketPricingWidget_ActiveGeneralPriceChanges_ReferencePriceGPCButton = By.xpath("//market-pricing-widget//div[contains(@title, 'Reference Price GPC')]");
	public By kalibrate_marketPricingWidget_ActiveGeneralPriceChanges_CreateGPCButton = By.xpath("//market-pricing-widget//button[contains(@text, 'Create GPC')]");
	
	public By kalibrate_marketPricingWidget_ActiveGeneralPriceChanges_DurationFromDate = By.xpath("//market-pricing-widget//div[@date='newGpc.startTime']//input[contains(@class, 'datepicker')]");
	public By kalibrate_marketPricingWidget_ActiveGeneralPriceChanges_DurationFromTime = By.xpath("//market-pricing-widget//div[@date='newGpc.startTime']//input[contains(@class, 'timepicker')]");
	public By kalibrate_marketPricingWidget_ActiveGeneralPriceChanges_DurationToDate = By.xpath("//market-pricing-widget//div[@date='newGpc.endTime']//input[contains(@class, 'datepicker')]");
	public By kalibrate_marketPricingWidget_ActiveGeneralPriceChanges_DurationToTime = By.xpath("//market-pricing-widget//div[@date='newGpc.endTime']//input[contains(@class, 'timepicker')]");
	public By kalibrate_marketPricingWidget_ActiveGeneralPriceChanges_ProcessAtDate = By.xpath("//market-pricing-widget//div[@date='newGpc.processTime']//input[contains(@class, 'datepicker')]");
	public By kalibrate_marketPricingWidget_ActiveGeneralPriceChanges_ProcessAtTime = By.xpath("//market-pricing-widget//div[@date='newGpc.processTime']//input[contains(@class, 'timepicker')]");
	public By kalibrate_marketPricingWidget_ActiveGeneralPriceChanges_ExportAtDate = By.xpath("//market-pricing-widget//div[@date='newGpc.exportTime']//input[contains(@class, 'datepicker')]");
	public By kalibrate_marketPricingWidget_ActiveGeneralPriceChanges_ExportAtTime = By.xpath("//market-pricing-widget//div[@date='newGpc.exportTime']//input[contains(@class, 'timepicker')]");
	
	public By kalibrate_marketPricingWidget_ActiveGeneralPriceChanges_SearchIcon = By.xpath("//market-pricing-widget//img[@title='Search']");
	public By kalibrate_marketPricingWidget_ActiveGeneralPriceChanges_EmbeddedSearchSearchButtonNotDisabled = By.xpath("(//market-pricing-widget//div[contains(@class, 'search active')]//button[@text='Search'])[1][not(contains(@disabled, 'disabled'))]");
	
	public By kalibrate_marketPricingWidget_ActiveGeneralPriceChanges_ProductsTableAdjustmentValueCells = By.xpath("//market-pricing-widget//table[contains(@class, 'gpc-products-outer')]//tr[contains(@class, 'gpc-product-row')]//div[contains(@ng-model, 'product.value')]//input");
	
	public By kalibrate_marketPricingWidget_SuccessNotificationDisplayed = By.xpath("//div[@name='market-pricing-widget']//div[contains(@class, 'notification success')][not(contains(@style, 'display: none;'))]");
	public By kalibrate_marketPricingWidget_SuccessNotification = By.xpath("//div[@name='market-pricing-widget']//div[contains(@class, 'notification success')]");
	
	public By kalibrate_marketPricingWidget_ActiveGeneralPriceChanges_FirstActiveGPC = By.xpath("(//div[contains(@data-ng-repeat, 'gpc in activeGpcsPage')]//div[contains(@class, 'gpc-overview')])[1]");
	
	public By kalibrate_marketPricingWidget_Sync = kalibrate_marketPricingWidget_ActiveGeneralPriceChanges_BlockHeader;
	
	
	public By kalibrate_marketStrategyWidget_DifferentialsOverviewBlockHeader = By.xpath("//market-strategy-widget//div[contains(@class, 'block-header')]//div[contains(@class, 'block-title')]/span[contains(text(), 'Differentials Overview')]");
	public By kalibrate_marketStrategyWidget_SearchIcon = By.xpath("//market-strategy-widget//img[contains(@title, 'Search')]");
	public By kalibrate_marketStrategyWidget_ConfigurationIcon = By.xpath("//market-strategy-widget//img[contains(@title, 'Configuration')]");
	public By kalibrate_marketStrategyWidget_Sync = kalibrate_marketStrategyWidget_DifferentialsOverviewBlockHeader;

	public By kalibrate_priceRequestsWidget_RequestIdInputField = null;
	public By kalibrate_priceRequestsWidget_PriceRequestsBreadcrumb = By.xpath("//price-request-widget//span[contains(@title, 'Price Requests')]");
	public By kalibrate_priceRequestsWidget_ConfigurationIcon = By.xpath("//price-request-widget//img[contains(@title, 'Configuration')]");
	public By kalibrate_priceRequestsWidget_Sync = null;

	public By kalibrate_siteStrategyWidget_SearchIcon = By.xpath("//strategy//img[contains(@title, 'Search')]");
	public By kalibrate_siteStrategyWidget_Sync = kalibrate_siteStrategyWidget_SearchIcon;

	
	public By kalibrate_searchWidget = By.xpath("//div[@name='adv-search-widget']");
	public By kalibrate_searchWidget_ResultsCountText = By.xpath("//div[@name='adv-search-widget']//div[@class='search-results-outer']//*[contains(text(), 'Showing')]");
	public By kalibrate_searchWidget_ResultsCountText_2Matches = By.xpath("//div[@name='adv-search-widget']//div[@class='search-results-outer']//*[contains(text(), 'Showing 1 to 2 of 2 matches')]");
	public By kalibrate_searchWidget_SearchButton = By.xpath("//div[@name='adv-search-widget']//adv-search-widget//button[contains(@text, 'Search')][not(contains(@disabled, 'disabled'))]");
	public By kalibrate_searchWidget_FilterInput = By.xpath("//div[@name='adv-search-widget']//input[contains(@placeholder, 'Enter search text')]");
	public By kalibrate_searchWidget_FilterCategorySelect = By.xpath("//div[contains(@name, 'adv-search')]//div[contains(@class, 'search-filter advanced-widget')]//select[contains(@data-ng-model, 'filter.filterId')]");
//	public By kalibrate_searchWidget_FilterListSelect = By.xpath("//div[contains(@name, 'adv-search')]//div[contains(@class, 'search-filter advanced-widget')]//select[contains(@data-ng-model, 'variable.value')]");
//	public By kalibrate_searchWidget_FilterListCheckbox = By.xpath("//div[contains(@name, 'adv-search')]//div[contains(@class, 'search-filter advanced-widget')]//div[contains(@class, 'filter-variable')]//*[@data-ng-model='variable.value']/../input");
	public By kalibrate_searchWidget_FilterListCheckbox = By.xpath("//div[contains(@name, 'adv-search')]//div[contains(@class, 'search-filter advanced-widget')]//div[contains(@class, 'filter-variable')]//input[@type='checkbox']");
	public By kalibrate_searchWidget_FilterListCheckboxLabel = By.xpath("//div[contains(@name, 'adv-search')]//div[contains(@class, 'search-filter advanced-widget')]//div[contains(@class, 'filter-variable')]//*[@data-ng-model='variable.value']/../label");
	public By kalibrate_searchWidget_FilterListSelect = By.xpath("//div[contains(@name, 'adv-search')]//div[contains(@class, 'search-filter advanced-widget')]//div[contains(@class, 'filter-variable')]//*[@data-ng-model='variable.value']");
	public By kalibrate_searchWidget_SearchTypeDropDownButton = By.xpath("//div[@name='adv-search-widget']//button[contains(@title, 'Search Types')]");
	public By kalibrate_searchWidget_SearchTypeDropDownListItems = By.xpath("//div[@name='adv-search-widget']//ul[contains(@class, 'search-type-list')]//li[contains(@data-ng-repeat, 'searchType in searchTypes')]");
	public By kalibrate_searchWidget_PreDefinedFiltersButton = By.xpath("//div[@name='adv-search-widget']//button[contains(@title, 'Filters')]");
	public By kalibrate_searchWidget_FiltersCountBubble = By.xpath("//div[@name='adv-search-widget']//div[contains(@class, 'filter-count')]");
	public By kalibrate_searchWidget_ToggleGroupByButton = By.xpath("//div[@name='adv-search-widget']//button[contains(@title, 'Show search grouping options')]");
	public By kalibrate_searchWidget_SaveSearchButton = By.xpath("//div[@name='adv-search-widget']//button[contains(@title, 'Save Search')]");
	public By kalibrate_searchWidget_AddToMyToDoButton = By.xpath("//div[@name='adv-search-widget']//button[contains(@title, 'Add to my To Do List')]");
	public By kalibrate_searchWidget_OwnSitesTab = By.xpath("//div[@name='adv-search-widget']//li[contains(@heading, 'Own Sites')]");
	public By kalibrate_searchWidget_AdvancedTab = By.xpath("//div[@name='adv-search-widget']//li[contains(@heading, 'Advanced')]");
	public By kalibrate_searchWidget_SavedSearchesTab = By.xpath("//div[@name='adv-search-widget']//li[contains(@heading, 'Saved Searches')]");
	public By kalibrate_searchWidget_UniversityButton = By.xpath("//div[@name='adv-search-widget']//span[contains(@title, 'University')]");
	
	public By kalibrate_searchWidget_RemoveFilterButton = By.xpath("//div[@name='adv-search-widget']//div[contains(@class, 'search-filter-panel')][not(contains(@class, 'hide'))]//button[contains(@title, 'Remove filter')]");
	public By kalibrate_searchWidget_Search_ResultsCountText_SingleResult = By.xpath("//div[@class='adv-search']//div[@class='search-results-outer']//*[contains(text(), 'Showing 1 to 1 of 1 matches')]");
//	public By kalibrate_searchWidget_SearchResults_RowItems = By.xpath("//div[@class='adv-search']//div[@class='search-results default-list']/div");
	public By kalibrate_searchWidget_SearchResults_RowItems = By.xpath("//div[@class='adv-search']//div[contains(@class, 'search-results default-list')]/div");
	
	public By kalibrate_searchWidget_SearchResults_FirstItemHoverMenuIcon = By.xpath("//div[@class='adv-search']//div[contains(@class, 'search-results default-list')]/div[1]/div[contains(@class, 'default-item-icons')]");
	public By kalibrate_searchWidget_SearchResults_SelectedItemHoverMenuIcon = By.xpath("//div[@class='adv-search']//div[contains(@class, 'search-results default-list')]/div[contains(@class, 'selected')]/div[contains(@class, 'default-item-icons')]");
	public By kalibrate_searchWidget_SearchResults_FirstItemHoverMenuContainer = By.xpath("//div[@class='adv-search']//div[contains(@class, 'search-results default-list')]/div[1]/div[contains(@class, 'default-item-icons')]/div[contains(@class, 'default-item-icons-list')]");
	public By kalibrate_searchWidget_SearchResults_SelectedItemHoverMenuContainer = By.xpath("//div[@class='adv-search']//div[contains(@class, 'search-results default-list')]/div[contains(@class, 'selected')]/div[contains(@class, 'default-item-icons')]/div[contains(@class, 'default-item-icons-list')]");
	public By kalibrate_searchWidget_SearchResults_FirstItemHoverMenuItems = By.xpath("//div[@class='adv-search']//div[contains(@class, 'search-results default-list')]/div[1]/div[contains(@class, 'default-item-icons')]/div[contains(@class, 'default-item-icons-list')]/img");
	public By kalibrate_searchWidget_SearchResults_SelectedItemHoverMenuItems = By.xpath("//div[@class='adv-search']//div[contains(@class, 'search-results default-list')]/div[contains(@class, 'selected')]/div[contains(@class, 'default-item-icons')]/div[contains(@class, 'default-item-icons-list')]/img");
	
	public By kalibrate_searchWidget_SearchResults_FooterMultiPricingIcon = By.xpath("//div[@name='adv-search-widget']//div[@class='widget-footer']//img[@title='Multi Pricing']");
	
	public By kalibrate_searchWidget_Sync = kalibrate_searchWidget_SearchButton;

	

	
	// *** Start of Gayathri's Locators ***
	

				public By kalibrate_Site_Manager_CloseWidgetIcon = By.xpath("//div[@name='manage-sites-widget']//span//a[@title= 'Close Widget']");
				public By kalibrate_Site_Manager_SearchIcon = By.xpath("//div[@name='manage-sites-widget']//div//img[@title= 'Search']");
				public By kalibrate_Site_Manager_Sync = kalibrate_Site_Manager_SearchIcon;
				public By kalibrate_Site_Manager_title = By.xpath("//div[@name='manage-sites-widget']//span//h4[contains(.,'Site Manager')]");

				public By kalibrate_DTA_Site_Manager_Sync = kalibrate_Site_Manager_SearchIcon;

			
				public By kalibrate_Site_Manager_CreateCopylink = By.xpath("//div[@name='manage-sites-widget']//div//div[@title='Create/Copy']");
				public By kalibrate_Site_Manager_SiteType_List = By.xpath("//div[@name='manage-sites-widget']//div//select[@data-ng-model='clone.newSite.typeSite']");
				public By kalibrate_Site_Manager_Selection_Create_Copy = By.xpath("//div[@name='manage-sites-widget']//div//div[@title='Create/Copy']");
				public By kalibrate_Site_Manager_Create_Site_Button = By.xpath("//div[@name='manage-sites-widget']//div//button[@text='Create Site']");
				public By kalibrate_Site_Manager_Copy_Site_Button = By.xpath("//div[@name='manage-sites-widget']//div//button[@text='Copy Site']");

						

				public By kalibrate_Site_Manager_RetailSiteName = By.xpath("//div[@name='manage-sites-widget']//div//input[@data-ng-model='clone.newSite.siteName']");
				public By kalibrate_Site_Manager_RetailImportCode = By.xpath("//div[@name='manage-sites-widget']//div//input[@data-ng-model='clone.newSite.importCode']");
				public By kalibrate_Site_Manager_RetailSiteBrandList = By.xpath("//div[@name='manage-sites-widget']//div//select[@data-ng-model='clone.newSite.brandId']");
				public By kalibrate_Site_Manager_RetailSiteAreaList = By.xpath("//div[@name='manage-sites-widget']//div//select[@data-ng-model='clone.newSite.areaId']");
				public By kalibrate_Site_Manager_RetailSiteNetworkList = By.xpath("//div[@name='manage-sites-widget']//div//select[@data-ng-model='clone.newSite.networkId']");
				public By kalibrate_Site_Manager_RetailSitePriorityList =By.xpath("//div[@name='manage-sites-widget']//div//select[@data-ng-model='clone.newSite.contractTypeId']");
				public By kalibrate_Site_Manager_RetailCompSiteGroup = By.xpath("//div[@name='manage-sites-widget']//div//select[@data-ng-model='clone.newSite.competitorGroupId']");

				
				public By kalibrate_Site_Manager_DTAAreaname = By.xpath("//div[@name='manage-sites-widget']//div//input[@data-ng-model='clone.newSite.siteName']");
				public By kalibrate_Site_Manager_DTAImportCode = By.xpath("//div[@name='manage-sites-widget']//div//input[@data-ng-model='clone.newSite.importCode']");
				public By kalibrate_Site_Manager_DTAManagerName = By.xpath("//div[@name='manage-sites-widget']//div//input[@data-ng-model='clone.newSite.managerName']");
				public By kalibrate_Site_Manager_DTAManagerEmail = By.xpath("//div[@name='manage-sites-widget']//div//input[@data-ng-model='clone.newSite.managerEmail']");
				public By kalibrate_Site_Manager_DTAManagerPhone = By.xpath("//div[@name='manage-sites-widget']//div//input[@data-ng-model='clone.newSite.managerPhone']");

				
				
				public By kalibrate_Site_Manager_BasicProperties_tab = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//li[@heading='Basic Properties']");
				public By kalibrate_Site_Manager_BasicProperties_tab_Sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//li[@heading='Basic Properties']");

				public By kalibrate_Site_Manager_Pricing_tab = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]/ul/li[@heading='Pricing']");
				public By kalibrate_Site_Manager_Pricing_tab_Sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//pricing-info//div//button[@text='Save']");

				
				

				//KP-1313
				public By kalibrate_Site_Manager_Pricing_tab_AmendExport_Title = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//pricing-info//div[@class='default-property']//div[contains(@title , 'Amend Export to be X minutes')]");
				public By kalibrate_Site_Manager_Pricing_tab_AmendExportTime_Checkbox = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//pricing-info//div[@class='default-property']//div/label[contains(@for, 'chkExportMinutesPastTheHourSwitch')]");
				public By kalibrate_Site_Manager_Pricing_tab_AmendExport_Minutes_Dropdown = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//pricing-info//div[@class='default-property']//div//div[@class='select-box']/select[@name ='exportMinutesPastTheHour']");

				public By kalibrate_Site_Manager_History_tab = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]/ul/li[@heading='History']");
				public By kalibrate_Site_Manager_History_tab_Sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//history-tab/div/table/tbody/tr/td/input[@date='startDate']");
				public By kalibrate_Site_Manager_History_Price = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//history-tab//div/ul/li[@heading='Prices']");

				public By kalibrate_Site_Manager_History_PriceType = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//history-tab//div[@class='tab-content']//div/history-prices//form[@name='productFrm']//div[@class='price-type-group']//select");
				public By kalibrate_Site_Manager_History_ProposedPrice_Sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//history-tab//history-prices//form[@name='productFrm']//table[contains(@class,'product-history-table')]//tbody/tr/td[contains(@class,'price-proposed')]");
				public By kalibrate_Site_Manager_History_ProposedPrice_Status = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//history-tab//history-prices//form[@name='productFrm']//table[contains(@class,'product-history-table')]//tbody/tr/td[contains(@class,'status')]");
				public By kalibrate_Site_Manager_History_ProposedPrice_CreationTime = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//history-tab//history-prices//form[@name='productFrm']//table[contains(@class,'product-history-table')]//tbody/tr/td[contains(@class,'creation-time')]");

				
				//G3
				//Dealer Pricing:
				//Dealer Pricing:Search

				public By kalibrate_searchWidget_SelectDTA = By.xpath("//div[@name='adv-search-widget']//ul[contains(@class,'search-type-list')]/li[text()='Dealer Trade Areas']");
				public By kalibrate_searchWidget_DTATab = By.xpath("//div[@name='adv-search-widget']//li[contains(@heading, 'Dealer Trade Areas')]");

				public By kalibrate_searchWidget_DTAhovericon = By.xpath("//div[@name='adv-search-widget']//div[contains(@class, 'default-item-icons')]");
				public By kalibrate_searchWidget_DTAavailablemenu =  By.xpath("//div[@name='adv-search-widget']//div[contains(@class, 'default-item-icons')]/div[(@class, 'default-item-icons-list')]");
				public By kalibrate_searchWidget_DTAPricing = By.xpath("//div[@name='adv-search-widget']//div[@class='default-item-icons-list']/img[@title='Pricing']");
				public By kalibrate_searchWidget_DTASiteManager = By.xpath("//div[@name='adv-search-widget']//div[@class='default-item-icons-list']/img[@title='Site Manager']");
				public By kalibrate_searchWidget_DTAIntel =  By.xpath("//div[@name='adv-search-widget']//div[@class='default-item-icons-list']/img[@title='Intel']");
				public By kalibrate_searchWidget_DTANotes = By.xpath("//div[@name='adv-search-widget']//div[@class='default-item-icons-list']/img[@title='Notes']");
				public By kalibrate_searchWidget_DTAStrategy = By.xpath("//div[@name='adv-search-widget']//div[@class='default-item-icons-list']/img[@title='Dealer Trade Strategy']");
				
				public By kalibrate_searchWidget_WidgetLinkedIcon = By.xpath("//div[@name='adv-search-widget']//span//a[contains(@title, 'Widget Linked')]");
				public By kalibrate_searchWidget_ReloadWidgetIcon = By.xpath("//div[@name='adv-search-widget']//span//a[contains(@title, 'Reload Widget')]");
				public By kalibrate_searchWidget_WidgetSettingsIcon = By.xpath("//div[@name='adv-search-widget']//span//a[contains(@title, 'Widget Settings')]");
				public By kalibrate_searchWidget_MaximimseWidgetIcon = By.xpath("//div[@name='adv-search-widget']//span//a[contains(@title, 'Maximize Widget')]");
				
				public By kalibrate_searchWidget_DTASearch_1_Result = By.xpath("//div[@name='adv-search-widget']//adv-search-widget//div[contains(@class, 'default-item-data default-item-data-small')]");
				
				public By kalibrate_searchWidget_CloseWidgetIcon = By.xpath("//div[@name='adv-search-widget']//span//a[@title= 'Close Widget']");

				
				//Dealer Pricing - Site Manager

				public By kalibrate_DTA_Site_Manager_Widget_WidgetLinkedIcon = By.xpath("//div[@name='manage-sites-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Widget Linked')]");
				public By kalibrate_DTA_Site_Manager_Widget_ReloadWidgetIcon = By.xpath("//div[@name='manage-sites-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Reload Widget')]");
				public By kalibrate_DTA_Site_Manager_Widget_WidgetSettingsIcon = By.xpath("//div[@name='manage-sites-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Widget Settings')]");
				public By kalibrate_DTA_Site_Manager_Widget_MaximimseWidgetIcon = By.xpath("//div[@name='manage-sites-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Maximize Widget')]");
				public By kalibrate_DTA_Site_Manager_Widget_CloseWidgetIcon = By.xpath("//div[@name='manage-sites-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Close Widget')]");
				
				public By kalibrate_DTA_Site_Manager_DTA_NAME = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class, 'default-header')]//span[contains(@class, 'msw-site-name')]");

				
				//DTA Site Manager Configuration & Options
				
				public By kalibrate_DTA_Site_Manager_Configuration_Spannar = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class, 'widget-menu-item')]//img[contains(@title, 'Configuration')]");
				public By kalibrate_DTA_Site_Manager_Default_Config = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'widget-configuration')]//span[contains(@class, 'default-option')]");
				
				public By kalibrate_DTA_Site_Manager_Default_Config_List = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class, 'widget-menu-item')]//default-option-widget//div[contains(@class, 'default-option-widget')]//div[contains(@class, 'default-option-container')]//div[contains(@class, 'default-add animate-show-hide default-option-item')]");
				public By kalibrate_DTA_Site_Manager_Default_Config_Check_Box = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class, 'widget-menu-item')]//default-option-widget//div[contains(@class, 'default-option-widget')]//div[contains(@class, 'default-option-container')]//div[contains(@class, 'default-add animate-show-hide default-option-item')]//div[contains(@class, 'selection-item')]//div//input");
				public By kalibrate_DTA_Site_Manager_Default_Config_Check_Box_1 = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class, 'widget-menu-item')]//default-option-widget//div[contains(@class, 'default-option-widget')]//div[contains(@class, 'default-option-container')]//div[contains(@class, 'default-add animate-show-hide default-option-item')]//div[contains(@class, 'selection-item')]//div");
				public By kalibrate_DTA_Site_Manager_Default_Config_Apply_Button = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class, 'widget-menu-item')]//default-option-widget//div[contains(@class, 'default-option-widget')]//button[contains(@text, 'Apply')]");
				public By kalibrate_DTA_Site_Manager_Default_Config_Cancel_Button = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class, 'widget-menu-item')]//default-option-widget//div[contains(@class, 'default-option-widget')]//button[contains(@text, 'Cancel')]");

				
				public By kalibrate_DTA_Site_Manager_History_tab = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]/ul/li[@heading='History']");
				public By kalibrate_DTA_Site_Manager_History_tab_Sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//history-tab/div/table/tbody/tr/td/input[@date='startDate']");
				public By kalibrate_DTA_Site_Manager_Products_tab = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]/ul/li[@heading='Products']");
				public By kalibrate_DTA_Site_Manager_Products_tab_Sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//products/div/list-products/form//div/span[contains(@class ,'filter-label')]");
				
				public By kalibrate_DTA_Site_Manager_Products_tab_ProductList = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//products/div/list-products/form//div/div[contains(@class ,'select-box')]/select");
				public By kalibrate_DTA_Site_Manager_Products_tab_Product_Add_new = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//products/div/list-products/form//div/span/button[@text ='Add New']");
				public By kalibrate_DTA_Site_Manager_Products_tab_Product_Active = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//products/div/own-product//div/form/div//div[@class = 'tab-content']//div/label[contains(@for,'ckcActiveProduct')]");
				public By kalibrate_DTA_Site_Manager_Products_tab_Product_Save = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//products/div/own-product//div/form/div[@class = 'buttonbar']/div[@class = 'buttonrights']/span/button");

				public By kalibrate_DTA_Site_Manager_Ownproducts_Sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//products/div/own-product//div/form/div/ul/li[@heading='Settings']");

				public By kalibrate_DTA_Site_Manager_Product_Groups_tab = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class,'product-history-tab')]/ul/li[@heading='Product Groups']");
				public By kalibrate_DTA_Site_Manager_Product_Groups_sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//div/site-setup/div/own-product-group//div[contains(.,'Current Selection')]");
				public By kalibrate_DTA_Site_Manager_Own_Product_Groups_sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//div/site-setup/div/own-product-group-detail//div/form/div[@class = 'buttonbar']/div[@class = 'buttonrights']/span/button");
				public By kalibrate_DTA_Site_Manager_Product_Groups_All_Products = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//div/site-setup/div/own-product-group//div[@class= 'img-group']/img[@title='All Products']");
				public By kalibrate_DTA_Site_Manager_Own_Product_Groups_Active = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//div/site-setup/div/own-product-group-detail//div/form/div//div[@class = 'tab-content']//div[@class='tab-pane active']/table//span/label[@for='ckcActive-41ty6s5g']");

				//DTA SITE MANAGER - TABs
				public By kalibrate_DTA_Site_Manager_DP_COSTS_tab = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]/ul/li[@heading='Dealer Pricing - Costs']");
				public By kalibrate_DTA_Site_Manager_DP_Pricing_tab = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]/ul/li[@heading='Dealer Pricing - Pricing']");
				public By kalibrate_DTA_Site_Manager_DP_Settings_tab = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]/ul/li[@heading='Dealer Pricing - Settings']");
				public By kalibrate_DTA_Site_Manager_DP_Add_new_Sites_tab = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]/ul/li[@heading='Dealer Pricing - Add New Sites']");
				public By kalibrate_DTA_Site_Manager_DP_Existing_Sites_tab = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]/ul/li[@heading='Dealer Pricing - Existing Sites']");
				
				
				//DTA COST Formula
				public By kalibrate_DTA_Site_Manager_DP_COSTS_Sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//manage-dta-costs/form/table/tbody//tr/td[contains(.,'Cost Types')]");
				public By kalibrate_DTA_Site_Manager_DP_COSTS_Cost_Type_Selection = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//manage-dta-costs/form/table/tbody//tr//td//div//select");
				public By kalibrate_DTA_Site_Manager_DP_COSTS_Product_BOX = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//manage-dta-costs/form/table/tbody//tr[contains(@data-ng-repeat , 'product in dta.products')]//td[@class='dta-costs-formula']/textarea");
				public By kalibrate_DTA_Site_Manager_DP_COSTS_Product_Text_Box = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//manage-dta-costs/form/table/tbody//tr[contains(@data-ng-repeat , 'product in dta.products')]//td[@class='dta-costs-formula']/textarea");
				public By kalibrate_DTA_Site_Manager_DP_COSTS_Save = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//manage-dta-costs/form//div[@class='default-property-save']//div//button[@text = 'Save']");

				//DTA Add New Sites
				
				public By kalibrate_DTA_Site_Manager_DP_Add_new_Sites_Sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//manage-dta-add-sites//div/adv-search-widget//div[@class = 'search-box']//div//button[@text = 'Search']");
				public By kalibrate_DTA_Site_Manager_DP_Add_new_Sites_SearchType = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//manage-dta-add-sites//div/adv-search-widget//div[@class = 'search-box']//div//button[@title ='Search Types']");
				public By kalibrate_DTA_Site_Manager_DP_Add_new_Sites_Own_Sites = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//manage-dta-add-sites//div/adv-search-widget//div[@class = 'search-box']//div//ul[contains(@class,'search-type-list')]/li[text()='Own Sites']");
				public By kalibrate_DTA_Site_Manager_DP_Add_new_Sites_Competitor_Sites = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//manage-dta-add-sites//div/adv-search-widget//div[@class = 'search-box']//div//ul[contains(@class,'search-type-list')]/li[text()='Competitor Sites']");
				public By kalibrate_DTA_Site_Manager_DP_Add_new_Sites_Search_Text_Box = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//manage-dta-add-sites//div/adv-search-widget//div[@class = 'search-box']//div//input[contains(@placeholder,'Enter search text')]");
				public By kalibrate_DTA_Site_Manager_DP_Add_new_Sites_Search_Button = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//manage-dta-add-sites//div/adv-search-widget//div[@class = 'search-box']//div//button[@text = 'Search']");
				public By kalibrate_DTA_Site_Manager_DP_Add_new_Sites_Search_SelectAll = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//manage-dta-add-sites//div/adv-search-widget//div[@class = 'search-results-outer']//div//span[@class = 'search-select-all']");
				public By kalibrate_DTA_Site_Manager_DP_Add_new_Sites_Search_Add_Selected = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//manage-dta-add-sites//div//div[@class='default-property-save']//div//button[contains(@text , 'Add Selected')]");

				
				//DTA SM - Pricing tab
				public By kalibrate_DTA_Site_Manager_DP_Pricing_Sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//manage-dta-pricing/form//div[@class='default-property-save']//div//button[@text = 'Save']");
				public By kalibrate_DTA_Site_Manager_DP_Pricing_NSPDelta = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//manage-dta-pricing/form//div[@class='default-property-group']//div//input[@name = 'nspDelta']");
				public By kalibrate_DTA_Site_Manager_DP_Pricing_NSP_Method = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//manage-dta-pricing/form//div[@class='default-property-group']//div//div[@class='select-box']/select[@name = 'nspCalculation']");
				public By kalibrate_DTA_Site_Manager_DP_Pricing_Export_DTW = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//manage-dta-pricing/form//div[@class='default-property-group']//div//div[@class='select-box']/select[@data-ng-model = 'dta.exportedPriceType']");

				public By kalibrate_DTA_Site_Manager_DP_Pricing_DTW_Pricing_Method = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//manage-dta-pricing/form//div[@class='default-property-group']//div//div[@class='select-box']/select[@name = 'dtwPricingMethodOption']");
				public By kalibrate_DTA_Site_Manager_DP_Pricing_DTA_Margin = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//manage-dta-pricing/form//div[@class='default-property-group']//div//table[@class='default-table full-width']/tbody//tr[contains(@data-ng-repeat , 'product in dta.products')]//td/input[contains(@data-ng-model,'Margin')] ");
				public By kalibrate_DTA_Site_Manager_DP_Pricing_Save = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//manage-dta-pricing/form//div[@class='default-property-save']//div//button[@text = 'Save']");


				//Dealer Pricing - Dealer Trade Strategy

				public By kalibrate_DTAStrategyWidget_WidgetLinkedIcon = By.xpath("//div[@name='strategy']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Widget Linked')]");
				public By kalibrate_DTAStrategyWidget_ReloadWidgetIcon = By.xpath("//div[@name='strategy']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Reload Widget')]");
				public By kalibrate_DTAStrategyWidget_WidgetSettingsIcon = By.xpath("//div[@name='strategy']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Widget Settings')]");
				public By kalibrate_DTAStrategyWidget_MaximimseWidgetIcon = By.xpath("//div[@name='strategy']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Maximize Widget')]");
				public By kalibrate_DTAStrategyWidget_CloseWidgetIcon = By.xpath("//div[@name='strategy']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Close Widget')]");
				public By kalibrate_DTAStrategyWidget_DTAName_Sync = By.xpath("//div[@name='strategy']//div[contains(@class, 'widget-head')]//span//h4[contains(., 'Dealer Trade Strategy')]");

				
				public By kalibrate_DTAStrategy_Pricing_Strategy = By.xpath("//div[@name='strategy']//strategy//form//div[contains(@data-ng-if, 'pricingStrategy')]");
				public By kalibrate_DTAStrategy_Pricing_Strategy_Expand = By.xpath("//div[@name='strategy']//strategy//form//div[contains(@data-ng-if, 'pricingStrategy')]//div[contains(@title, 'Expand/Collapse')]");
				public By kalibrate_DTAStrategy_Pricing_Strategy_Stage = By.xpath("//div[@name='strategy']//pricing-strategy//div[@class='tab-content']//pricing-strategy-standard//pricing-strategy-stage-details//table//tbody[@class='stage-item']");
				public By kalibrate_DTAStrategy_Pricing_Strategy_Stage_ProductLevel = By.xpath("//div[@name='strategy']//pricing-strategy//div[@class='tab-content']//pricing-strategy-standard//pricing-strategy-stage-details//table//tbody[@class='stage-item']//tr/td/img[@title='Product Level Ruleset']");
				public By kalibrate_DTAStrategy_Pricing_Strategy_Stage_ProductLevel_table = By.xpath("//div[@name='strategy']//pricing-strategy//div[@class='tab-content']//pricing-strategy-standard//pricing-strategy-stage-details//table//tbody[@class='stage-item']//tr/td/table[@class='profile-product-table']");
				public By kalibrate_DTAStrategy_Pricing_Strategy_Stage_ProductLevel_table_Product_Repeat = By.xpath("//div[@name='strategy']//pricing-strategy//div[@class='tab-content']//pricing-strategy-standard//pricing-strategy-stage-details//table//tbody[@class='stage-item']//tr/td/table[@class='profile-product-table']//tr/td[contains(@data-ng-repeat , 'product in productGroup.products')]");
				public By kalibrate_DTAStrategy_Pricing_Strategy_Stage_ProductLevel_Ruleset = By.xpath("//div[@name='strategy']//pricing-strategy//div[@class='tab-content']//pricing-strategy-standard//pricing-strategy-stage-details//table//tbody[@class='stage-item']//tr/td/table[@class='profile-product-table']//tr/td[contains(@data-ng-repeat , 'product in productGroup.products')]//div//form[@name = 'profileStageRule']//div//div[@class = 'select-box']//select[contains(@class , 'profile-ruleset')]");
				public By kalibrate_DTAStrategy_Pricing_Strategy_Stage_ProductLevel_Save = By.xpath("//div[@name='strategy']//pricing-strategy//div[@class='tab-content']//pricing-strategy-standard//pricing-strategy-stage-details//table//tbody[@class='stage-item']//tr/td/table[@class='profile-product-table']//tr/td[contains(@data-ng-repeat , 'product in productGroup.products')]//div//form[@name = 'profileStageRule']//div//div[@class = 'flex-div']//button[contains(@text , 'Save')]");

				public By kalibrate_DTAStrategy_Pricing_Strategy_Add_Stage_button = By.xpath("//div[@name='strategy']//pricing-strategy//div[@class='tab-content']//pricing-strategy-standard//pricing-strategy-stage-details//div[@class='strategy-button-action']//div/button(., 'Add Stage')");

				//Dealer Pricing - Pricing Widget

				public By kalibrate_DTA_Pricing_Widget_WidgetLinkedIcon = By.xpath("//div[@name='pricing-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Widget Linked')]");
				public By kalibrate_DTA_Pricing_Widget_ReloadWidgetIcon = By.xpath("//div[@name='pricing-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Reload Widget')]");
				public By kalibrate_DTA_Pricing_Widget_WidgetSettingsIcon = By.xpath("//div[@name='pricing-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Widget Settings')]");
				public By kalibrate_DTA_Pricing_Widget_MaximimseWidgetIcon = By.xpath("//div[@name='pricing-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Maximize Widget')]");
				public By kalibrate_DTA_Pricing_Widget_CloseWidgetIcon = By.xpath("//div[@name='pricing-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Close Widget')]");
				public By kalibrate_DTA_Pricing_Widget_Sync = By.xpath("//div[@name='pricing-widget']//div[contains(@class, 'widget-head')]//span[contains(@class, 'widget-head-pricing')]//span[contains(@ng-if , 'titleLoaded')]//span/img[contains(@src , 'images/core/Dealer_Trade_Area.png')]");

				public By kalibrate_DTA_Pricing_Widget_Generate_Price_Button_1 = By.xpath("//div[@name='pricing-widget']//pricing-widget//div[contains(@class, 'flex-container')]//div[contains(@class, 'pricing-generate-generate-button')]/button[contains(.,'Generate Prices')]");
				public By kalibrate_DTA_Pricing_Widget_Generate_Price_Button_2 = By.xpath("//div[@name='pricing-widget']//pricing-widget//div[contains(@class, 'pricing-bottom-panel')]//div[contains(@class, 'pricing-generate-panel')]/button[contains(@text,'Generate Prices')]");

				public By kalibrate_DTA_Pricing_Widget_Successful_Price_Generation_Notification_Message = By.xpath ("//div[@name='pricing-widget']//div[contains(.,'New prices have successfully been generated.')]");
				public By kalibrate_DTA_Pricing_Widget_Successful_Price_Generation_Notification = By.xpath("//div[@name='pricing-widget']//div[contains(@class, 'notification success flex-container')]//div//img[contains(.,'New prices have successfully been generated.')]");

				public By kalibrate_searchWidget_SearchResults_HoverMenu = By.xpath("//div[@class='adv-search']//div[contains(@class, 'search-results default-list')]/div/div[@class='default-item-icons']");
				public By kalibrate_searchWidget_SearchResults_HoverMenuList = By.xpath("//div[@class='adv-search']//div[contains(@class, 'search-results default-list')]/div/div[@class='default-item-icons']//div[@class='default-item-icons-list']");
				//public By kalibrate_searchWidget_SearchResults_HoverMenu_Pricing = By.xpath("//div[@class='adv-search']//div[contains(@class, 'search-results default-list')]/div/div[@class='default-item-icons']//div[contains(@class='default-item-icons-list')]//img[contains(@title ,'pricing')]");
				public By kalibrate_searchWidget_SearchResults_HoverMenu_Pricing = By.xpath("//div[@class='adv-search']//div[contains(@class, 'search-results default-list')]/div/div[@class='default-item-icons']//div[contains(@class ,'default-item-icons-list')]//img[contains(@title ,'pricing')]");
				public By kalibrate_searchWidget_FooterWidgets_MultiPricing = By.xpath("//div[@name='adv-search-widget']//div[@class= 'widget-footer']//div[contains(@class ,'widget-footer-resultset')]/img[@title ='Multi Pricing']");
				public By kalibrate_searchWidget_FooterWidgets_SiteManager = By.xpath("//div[@name='adv-search-widget']//div[@class= 'widget-footer']//div[contains(@class ,'widget-footer-resultset')]/img[@title ='Site Manager']");
				public By kalibrate_searchWidget_FooterWidgets_Intel = By.xpath("//div[@name='adv-search-widget']//div[@class= 'widget-footer']//div[contains(@class ,'widget-footer-resultset')]/img[@title ='Intel']");
				public By kalibrate_searchWidget_FooterWidgets_Map = By.xpath("//div[@name='adv-search-widget']//div[@class= 'widget-footer']//div[contains(@class ,'widget-footer-resultset')]/img[@title ='Map']");
				public By kalibrate_searchWidget_FooterWidgets_MarketStrategy = By.xpath("//div[@name='adv-search-widget']//div[@class= 'widget-footer']//div[contains(@class ,'widget-footer-resultset')]/img[@title ='Market Strategy']");
				public By kalibrate_searchWidget_FooterWidgets_MarketPricing = By.xpath("//div[@name='adv-search-widget']//div[@class= 'widget-footer']//div[contains(@class ,'widget-footer-resultset')]/img[@title ='Market Pricing']");


			
				public By kalibrate_main_ManagementWidgetIcon = By.xpath("//div[@id='QuickWidgetMenu']/div[1]/div[1]/ul/li[2]");
				public By kalibrate_main_SiteManagerWidgetIcon = By.xpath("//div[@title='Site Manager']");
				
				//Administrator Widget
				public By kalibrate_main_WorkspaceMenuList = By.xpath(".//*[@id='MainMenu'][not(contains(@class, 'loggedout'))]/div[@class='menu-block workspaces current']//div[@id='WorkspacesMenu']//div[@class='workspace-block']//div[@class='workspace-text']");
				public By kalibrate_main_WorkspaceMenuTextList = By.xpath(".//*[@id='MainMenu'][not(contains(@class, 'loggedout'))]/div[@class='menu-block workspaces current']//div[@id='WorkspacesMenu']//div[@class='workspace-block']//div[@class='workspace-text']");
				public By kalibrate_main_AdministratorWidgetIcon = By.xpath("//div[@title='Administrator']");
				public By kalibrate_main_DataManagerWidgetIcon = By.xpath("//div[@title='Data Manager']");			

				public By kalibrate_administratorWidget_title = By.xpath("//administrator-widget//span[contains(@title, 'Administrator')]");
				public By kalibrate_administratorWidget_ReloadWidgetIcon = By.xpath("//div[@name='administrator-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Reload Widget')]");
				public By kalibrate_administratorWidget_WidgetSettingsIcon = By.xpath("//div[@name='administrator-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Widget Settings')]");
				public By kalibrate_administratorWidget_MaximimseWidgetIcon = By.xpath("//div[@name='administrator-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Maximize Widget')]");
				public By kalibrate_administratorWidget_CloseWidgetIcon = By.xpath("//div[@name='administrator-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Close Widget')]");
				
				
				public By kalibrate_administratorWidget_Selected_Options_Container = By.xpath("//div[@name='administrator-widget']//administrator-widget//div[contains(@class, 'dyn-content default-list')]");
				public By kalibrate_administratorWidget_Selected_Options_List = By.xpath("//div[@name='administrator-widget']//administrator-widget//div[contains(@class, 'dyn-content default-list')]/div");
				public By kalibrate_administratorWidget_Selected_Options_List_title = By.xpath("//div[@name='administrator-widget']//administrator-widget//div[contains(@class, 'dyn-content default-list')]/div/div");

				
		//Default Options in Administrator widget
				public By kalibrate_administratorWidget_Configuration_Spannar = By.xpath("//div[@name='administrator-widget']//administrator-widget//div[contains(@class, 'widget-menu-item')]//img[contains(@title, 'Configuration')]");
				public By kalibrate_administratorWidget_Default_Config = By.xpath("//div[@name='administrator-widget']//administrator-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'widget-configuration')]//span[contains(@class, 'default-option')]");
				public By kalibrate_administratorWidget_Default_Config_List = By.xpath("//div[@name='administrator-widget']//administrator-widget//div[contains(@class, 'widget-menu-item')]//default-option-widget//div[contains(@class, 'default-option-widget')]//div[contains(@class, 'default-option-container')]//div[contains(@class, 'default-add animate-show-hide default-option-item')]");
				public By kalibrate_administratorWidget_Default_Config_Check_Box = By.xpath("//div[@name='administrator-widget']//administrator-widget//div[contains(@class, 'widget-menu-item')]//default-option-widget//div[contains(@class, 'default-option-widget')]//div[contains(@class, 'default-option-container')]//div[contains(@class, 'default-add animate-show-hide default-option-item')]//div[contains(@class, 'selection-item')]//div//input");
				public By kalibrate_administratorWidget_Default_Config_Check_Box_1 = By.xpath("//div[@name='administrator-widget']//administrator-widget//div[contains(@class, 'widget-menu-item')]//default-option-widget//div[contains(@class, 'default-option-widget')]//div[contains(@class, 'default-option-container')]//div[contains(@class, 'default-add animate-show-hide default-option-item')]//div[contains(@class, 'selection-item')]//div");
				public By kalibrate_administratorWidget_Default_Config_Apply_Button = By.xpath("//div[@name='administrator-widget']//administrator-widget//div[contains(@class, 'widget-menu-item')]//default-option-widget//div[contains(@class, 'default-option-widget')]//button[contains(@text, 'Apply')]");
				public By kalibrate_administratorWidget_Default_Config_Cancel_Button = By.xpath("//div[@name='administrator-widget']//administrator-widget//div[contains(@class, 'widget-menu-item')]//default-option-widget//div[contains(@class, 'default-option-widget')]//button[contains(@text, 'Cancel')]");

				public By kalibrate_administratorWidget_config_AllItems_Name = By.xpath("//div[@name='administrator-widget']//administrator-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]/div/div/h4");

				
				public By kalibrate_administratorWidget_notification_banner_success_close = By.xpath("//div[@name='administrator-widget']//div[contains(@class, 'notification success')]//div[contains(@class, 'close')]//span[contains(@data-ng-click, 'toggleNotification()')]");
				
				public By kalibrate_administratorWidget_notification_banner_success_message = By.xpath("//div[@name='administrator-widget']//div[contains(.,'Changes saved successfully.')]");
				public By kalibrate_administratorWidget_notification_banner_success_sync_before_close = By.xpath("//div[@name='administrator-widget']//div[contains(@style, 'display: block')]");

				public By kalibrate_administratorWidget_notification_banner_success_sync_after_close = By.xpath("//div[@name='administrator-widget']//div[contains(@style, 'display: none')]");	
			
		// Administrator -> User Profile
				public By kalibrate_adminstratorWidget_UserProfiles = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//span[contains(.,'User Profiles')]");
				public By kalibrate_adminstratorWidget_UserProfiles_Sync = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//span[contains(.,'User Profiles')]");
				public By kalibrate_adminstratorWidget_UserProfiles_AddNew_TextBox = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//manage-profiles//div//input[contains(@data-ng-model, 'newProfile')]");
				public By kalibrate_adminstratorWidget_UserProfiles_AddNew_button = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//manage-profiles//div//button[contains(@text, 'Add New')]");
				public By kalibrate_adminstratorWidget_UserProfiles_Profile_form = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//manage-profile-detail//div//manage-profile-detail-setting//form[contains(@name, 'settingForm')]");
				public By kalibrate_adminstratorWidget_UserProfiles_Profile_form_Save = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//manage-profile-detail//div//div[contains(@class, 'default-property-save')]//div//button[contains(@text, 'Save')]");
				public By kalibrate_adminstratorWidget_UserProfiles_Profile_form_Delete = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//manage-profile-detail//div//div[contains(@class, 'default-property-save')]//div//button[contains(@text, 'Delete')]");

				public By kalibrate_adminstratorWidget_UserProfiles_Profile_form_Application = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//manage-profile-detail//div//manage-profile-detail-setting//form[contains(@name, 'settingForm')]//div//div[@title = 'Applications']");
				public By kalibrate_adminstratorWidget_UserProfiles_Profile_form_Application_box = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//manage-profile-detail//div//manage-profile-detail-setting//form[contains(@name, 'settingForm')]//div//div[@title = 'Applications']/div/label[@class = 'check-label']");
				public By kalibrate_adminstratorWidget_UserProfiles_Profile_form_Application_box1 = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//manage-profile-detail//div//manage-profile-detail-setting//form[contains(@name, 'settingForm')]//div//div[@title = 'Applications']/div");

				
		// Administrator->Users
				public By kalibrate_adminstratorWidget_Users = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//span[contains(.,'Users')]");
				public By kalibrate_adminstratorWidget_Users_Sync = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//span[contains(.,'Users')]");
				public By kalibrate_adminstratorWidget_Users_AddNew_TextBox = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//manage-users//div//input[contains(@data-ng-model, 'newUser.name')]");
				public By kalibrate_adminstratorWidget_Users_AddNew_button = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//manage-users//div//button[contains(@text, 'Add New')]");
				public By kalibrate_adminstratorWidget_Users_Users_form = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//manage-user-detail//div//manage-user-detail-settings//form[contains(@name, 'manageUserDetailForm')]");
				
				public By kalibrate_adminstratorWidget_Users_Users_form_FullName = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//manage-user-detail//div//manage-user-detail-settings//form//div[@class = 'default-property-group']//div//input[contains(@data-ng-model, 'fullName')]");
				public By kalibrate_adminstratorWidget_Users_Users_form_LoginName = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//manage-user-detail//div//manage-user-detail-settings//form//div[@class = 'default-property-group']//div//input[contains(@data-ng-model, 'userName')]");
		
				public By kalibrate_adminstratorWidget_Users_Users_form_Profile_Select = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//manage-user-detail//div//manage-user-detail-settings//form//div[@class = 'default-property-group']//div//select[contains(@data-ng-model, 'profileId')]");
				public By kalibrate_adminstratorWidget_Users_Users_form_Language_Select = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//manage-user-detail//div//manage-user-detail-settings//form//div[@class = 'default-property-group']//div//select[contains(@data-ng-model, 'preferredLanguage')]");
				public By kalibrate_adminstratorWidget_Users_Users_form_DistanceUnit_Select = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//manage-user-detail//div//manage-user-detail-settings//form//div[@class = 'default-property-group']//div//select[contains(@data-ng-model, 'preferredDistanceUnit')]");

				public By kalibrate_adminstratorWidget_Users_Users_form_Password = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//manage-user-detail//div//manage-user-detail-settings//form//div[@class = 'default-property-group']//div//input[contains(@data-ng-model, 'password')]");
				public By kalibrate_adminstratorWidget_Users_Users_form_ConfirmPassword = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//manage-user-detail//div//manage-user-detail-settings//form//div[@class = 'default-property-group']//div//input[contains(@data-ng-model, 'currentUser.passwordConfirmation')]");
		
				public By kalibrate_adminstratorWidget_Users_Users_form_Save = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//manage-user-detail//div//manage-user-detail-settings//div[contains(@class, 'default-property-save')]//div//button[contains(@text, 'Save')]");
				public By kalibrate_adminstratorWidget_Users_Users_form_Delete = By.xpath("//div[@name='administrator-widget']//administrator-widget//div//manage-user-detail//div//manage-user-detail-settings//div[contains(@class, 'default-property-save')]//div//button[contains(@text, 'Delete')]");

				
				
		// Administrator->System Settings 
		
				public By kalibrate_adminstratorWidget_Sync = By.xpath("//div[@name='administrator-widget']//div[@class='widget-content']//div[@class='msw-content administrator-main']//div[contains(@class, 'administrator-navigator')]//span[@title='Administrator']");
				public By kalibrate_adminstratorWidget_SystemSettings = By.xpath("//div[@name='administrator-widget']//div[@class='widget-content']//div[@class='msw-content administrator-main']//div[@class='default-card administrator']//span[@class='system-setup']");
				public By kalibrate_adminstratorWidget_SystemSettings_Sync = By.xpath("//div[@name='administrator-widget']//div[@class='widget-content']//div[@class='msw-content administrator-main']//div[contains(@class, 'administrator-navigator')]//span[@title='System Settings']");
				public By kalibrate_adminstratorWidget_ModelConstant = By.xpath("//div[@name='administrator-widget']//div[@class='widget-content']//div[@class='msw-content administrator-main']//div[@class='adminitrator-content-palceholder']//div[contains(@class, 'administrator-content-data')]//system-setup//div[@class='default-list']//div[contains(@class, 'flex-container default')]");
				public By kalibrate_adminstratorWidget_ModelConstant_Sync = By.xpath("//div[@name='administrator-widget']//div[@class='widget-content']//div[@class='msw-content administrator-main']//div[contains(@class, 'administrator-navigator')]//span[@title='Model Constants']");
				public By kalibrate_adminstratorWidget_ModelConstant_Save = By.xpath("//div[@name='administrator-widget']//div[@class='widget-content']//div[@class='msw-content administrator-main']//div[@class='adminitrator-content-palceholder']//div[contains(@class, 'administrator-content-data')]//system-setup-detail//form[contains(@class, 'system-settings')]//div[@class='default-property-save']//button[@text='Save']");

				
		//Administrator DELETION (DTA)
				public By kalibrate_adminstratorWidget_Deletion = By.xpath("//div[@name='administrator-widget']//div[@class='widget-content']//div[@class='msw-content administrator-main']//div[@class='default-card administrator']//span[@class='deletions']");
				public By kalibrate_adminstratorWidget_Deletion_Sync = By.xpath("//div[@name='administrator-widget']//div/deletions//div/adv-search-widget");
				
				public By kalibrate_adminstratorWidget_Deletion_Search_type = By.xpath("//div[@name='administrator-widget']//div/deletions//div/adv-search-widget/div//div[@class='search-box']/div/button[@class='search-type']");
				
				public By kalibrate_administratorWidget_Deletion_SelectDTA = By.xpath("//div[@name='administrator-widget']//div/deletions//div/adv-search-widget/div//div[@class='search-box']/div/ul[contains(@class,'search-type-list')]/li[text()='Dealer Trade Areas']");
				
				public By kalibrate_adminsitratWidget_Deletion_DTATab = By.xpath("//div[@name='administrator-widget']//div/deletions//div/adv-search-widget/div//div/ul/li[contains(@heading, 'Dealer Trade Areas')]");
				
				public By kalibrate_administratorWidget_Deletion_Input = By.xpath("//div[@name='administrator-widget']//div/deletions//div/adv-search-widget/div//div[@class='search-box']//div/input[contains(@placeholder, 'Enter search text')]");

				public By kalibrate_administratorWidget_Deletion_SearchButton = By.xpath("//div[@name='administrator-widget']//div/deletions//div/adv-search-widget/div//div[@class='search-box']//div/button[contains(@text, 'Search')][not(contains(@disabled, 'disabled'))]");
				
				public By kalibrate_administratorWidget_Deletion_SelectedDTA = By.xpath("//div[@name='administrator-widget']//div/deletions//div/adv-search-widget/div//div[@class='search-results-outer']//div[@class = 'search-results default-list']");
				public By kalibrate_administratorWidget_Deletion_DeleteSite_Button = By.xpath("//div[@name='administrator-widget']//div/deletions//div/button[@class = 'delete-button']");

				public By kalibrate_administratorWidget_Deletion_Confirmation_banner = By.xpath("//div[@name='administrator-widget']//div/deletions//div[contains(@class , 'warning-message')]");
				public By kalibrate_administratorWidget_Deletion_Confirmation_Yes = By.xpath("//div[@name='administrator-widget']//div/deletions//div[contains(@class , 'warning-message')]/div/button[contains(@data-ng-click , 'deleteSites()')]");
				public By kalibrate_administratorWidget_Deletion_Confirmation_No = By.xpath("//div[@name='administrator-widget']//div/deletions//div[contains(@class , 'warning-message')]/div/button[contains(@data-ng-click , 'cancel()')]");
			
				public By kalibrate_administratorWidget_Deletion_SearchResult = By.xpath("//div[@name='administrator-widget']//div/deletions//div/adv-search-widget/div//div[@class='search-results-outer']//div[@class = 'default-header']/span");
				public By kalibrate_searchWidget_Search_ResultsNoMatching = By.xpath("//div[@class='adv-search']//div[@class='search-results-outer']//div/span[contains(text(), ' No matching results found')]");
				
				
							
	// **** DATA MANAGER *****
				
				public By kalibrate_dataManagerWidget_title = By.xpath("//manage-data-widget//span[contains(@title, 'Data Manager')]");
				public By kalibrate_dataManagerWidget_sync = By.xpath("//manage-data-widget//span[contains(@title, 'Data Manager')]/parent::div");
				public By kalibrate_dataManagerWidget_ReloadWidgetIcon = By.xpath("//div[@name='manage-data-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Reload Widget')]");
				public By kalibrate_dataManagerWidget_WidgetSettingsIcon = By.xpath("//div[@name='manage-data-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Widget Settings')]");
				public By kalibrate_dataManagerWidget_MaximimseWidgetIcon = By.xpath("//div[@name='manage-data-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Maximize Widget')]");
				public By kalibrate_dataManagerWidget_CloseWidgetIcon = By.xpath("//div[@name='manage-data-widget']//div[contains(@class, 'widget-head')]//a[contains(@title, 'Close Widget')]");
				

				
				public By kalibrate_dataManagerWidget_Selected_Options_Container = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'dyn-content default-list')]");
				public By kalibrate_dataManagerWidget_Selected_Options_List = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'dyn-content default-list')]/div");
				public By kalibrate_dataManagerWidget_Selected_Options_List_title = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'dyn-content default-list')]/div/div");

				
				public By kalibrate_dataManagerWidget_notification_banner_success_close = By.xpath("//div[@name='manage-data-widget']//div[contains(@class, 'notification success')]//div[contains(@class, 'close')]//span[contains(@data-ng-click, 'toggleNotification()')]");
				public By kalibrate_dataManagerWidget_notification_banner_success_message = By.xpath("//div[@name='manage-data-widget']//div[contains(.,'Changes saved successfully.')]");
				public By kalibrate_dataManagerWidget_notification_banner_success_sync_before_close = By.xpath("//div[@name='manage-data-widget']//div[contains(@style, 'display: block')]");

				public By kalibrate_dataManagerWidget_notification_banner_success_sync_after_close = By.xpath("//div[@name='manage-data-widget']//div[contains(@style, 'display: none')]");
				
				
		//Default Options in Data Manager widget
				public By kalibrate_dataManagerWidget_Configuration_Spannar = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//img[contains(@title, 'Configuration')]");
				public By kalibrate_dataManagerWidget_Default_Config = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'widget-configuration')]//span[contains(@class, 'default-option')]");
				public By kalibrate_dataManagerWidget_Default_Config_List = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//default-option-widget//div[contains(@class, 'default-option-widget')]//div[contains(@class, 'default-option-container')]//div[contains(@class, 'default-add animate-show-hide default-option-item')]");
				public By kalibrate_dataManagerWidget_Default_Config_Check_Box = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//default-option-widget//div[contains(@class, 'default-option-widget')]//div[contains(@class, 'default-option-container')]//div[contains(@class, 'default-add animate-show-hide default-option-item')]//div[contains(@class, 'selection-item')]//div//input");
				public By kalibrate_dataManagerWidget_Default_Config_Check_Box_1 = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//default-option-widget//div[contains(@class, 'default-option-widget')]//div[contains(@class, 'default-option-container')]//div[contains(@class, 'default-add animate-show-hide default-option-item')]//div[contains(@class, 'selection-item')]//div");
				public By kalibrate_dataManagerWidget_Default_Config_Apply_Button = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//default-option-widget//div[contains(@class, 'default-option-widget')]//button[contains(@text, 'Apply')]");
				public By kalibrate_dataManagerWidget_Default_Config_Cancel_Button = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//default-option-widget//div[contains(@class, 'default-option-widget')]//button[contains(@text, 'Cancel')]");

				public By kalibrate_dataManagerWidget_config_AllItems_Name = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]/div/div/h4");

				
				public By kalibrate_dataManagerWidget_config_SelectedItems = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]/div[contains(@class, 'selected')]");
				public By kalibrate_dataManagerWidget_config_AllItems = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]/div");
			/*
				public By kalibrate_dataManagerWidget_config_Brands = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]//div/h4[contains(., 'Brands')]");
				public By kalibrate_dataManagerWidget_config_Competitor_Visibility = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]//div/h4[contains(., 'Competitor Visibility')]");
				public By kalibrate_dataManagerWidget_config_Cost_Types = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]//div/h4[contains(., 'Cost Types')]");
				public By kalibrate_dataManagerWidget_config_Custom_Display_Data = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]//div/h4[contains(., 'Custom Display Data')]");
				public By kalibrate_dataManagerWidget_config_Extended_Properties = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]//div/h4[contains(., 'Extended Properties')]");
				public By kalibrate_dataManagerWidget_config_Data_Sources = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]//div/h4[contains(., 'Data Sources')]");
				public By kalibrate_dataManagerWidget_config_Global_Costs = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]//div/h4[contains(., 'Global Costs')]");
				public By kalibrate_dataManagerWidget_config_OPIS_Sources = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]//div/h4[contains(., 'OPIS Sources')]");
				public By kalibrate_dataManagerWidget_config_Payment_Offsets = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]//div/h4[contains(., 'Payment Offsets')]");
				public By kalibrate_dataManagerWidget_config_Payment_Types = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]//div/h4[contains(., 'Payment Types')]");
				public By kalibrate_dataManagerWidget_config_Price_Points = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]//div/h4[contains(., 'Price Points')]");
				public By kalibrate_dataManagerWidget_config_Product_Groups = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]//div/h4[contains(., 'Product Groups')]");
				public By kalibrate_dataManagerWidget_config_Products = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]//div/h4[contains(., 'Products')]");
				public By kalibrate_dataManagerWidget_config_Sales_Impact = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]//div/h4[contains(., 'Sales Impact')]");
				public By kalibrate_dataManagerWidget_config_Sales_Types = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]//div/h4[contains(., 'Sales Types')]");
				public By kalibrate_dataManagerWidget_config_Site_Groupings = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]//div/h4[contains(., 'Site Groupings')]");
				public By kalibrate_dataManagerWidget_config_Store_Sales_Types = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]//div/h4[contains(., 'Store Sales Types')]");
				public By kalibrate_dataManagerWidget_config_Survey_Credit = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]//div/h4[contains(., 'Survey Credit')]");
				public By kalibrate_dataManagerWidget_config_System_Codes = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'manage-data-sections')]//div/h4[contains(., 'System Codes')]");

	*/
		// Data Manager - Competitor Data Source		
				public By kalibrate_dataManagerWidget_DataSource = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'default-list')]//div[contains(@title, 'Create data sources')]");
				public By kalibrate_dataManagerWidget_DataSource_sync = By.xpath("//manage-data-widget//span[contains(@title, 'Data Sources')]");
				public By kalibrate_dataManagerWidget_DataSource_Add_new_Textbox = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-data-sources//div//input[contains(@data-ng-model, 'dataSourceInput')]");
				public By kalibrate_dataManagerWidget_DataSource_Add_new_Button = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-data-sources//div//button[contains(@text, 'Add New')]");

				public String[] kalibrate_dataManagerWidget_DataSource_new = {"Kalibrate","XML","Virtual","CSV","KMOBILE"};
				public By kalibrate_dataManagerWidget_DataSource_new_form = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-data-source-detail//form[contains(@name, 'dataSourceForm')]");
				public By kalibrate_dataManagerWidget_DataSource_new_form_name = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-data-source-detail//form[contains(@name, 'dataSourceForm')]//div//input[contains(@data-ng-model, 'currentDataSource.source')]");
				public By kalibrate_dataManagerWidget_DataSource_new_form_map = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-data-source-detail//form[contains(@name, 'dataSourceForm')]//div//label[contains(@for, 'chkShowOnMapWidget')]");
				public By kalibrate_dataManagerWidget_DataSource_new_form_pricing = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-data-source-detail//form[contains(@name, 'dataSourceForm')]//div//label[contains(@for, 'chkShowOnPricingWidget')]");
				public By kalibrate_dataManagerWidget_DataSource_save = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-data-source-detail//form[contains(@name, 'dataSourceForm')]//div//button[contains(@text, 'Save')]");
							
				

				public By kalibrate_dataManagerWidget_CostTypes = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'default-list')]//div[contains(@title, 'Create cost types')]");
				public By kalibrate_dataManagerWidget_CostTypes_sync = By.xpath("//manage-data-widget//span[contains(@title, 'Cost Types')]");

				
				public By kalibrate_dataManagerWidget_CostTypes_clickable_parent = By.xpath("//manage-data-widget//span[contains(@title, 'Cost Types')]/parent::div");

				public By kalibrate_dataManagerWidget_CostTypes_SelectAll_checkbox = By.xpath("//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-cost-type-tab//div[contains(@class, 'multi-select')]//div//label[contains(@class, 'check-label')]");
				public By kalibrate_dataManagerWidget_CostTypes_CurrentSelection = By.xpath("//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-cost-type-tab//div[contains(@class, 'multi-select')]//div[contains(.,'Current Selection')]");
				public By kalibrate_dataManagerWidget_CostTypes_MultipleCostType_DisplayOnPricingWidget = By.xpath("//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-multiple-cost-type-detail//form[contains(@name, 'costTypeForm')]//div[contains(@class, 'select-box')]//select[contains(@data-ng-model,'displayOnPricingPage')]");
				public By kalibrate_dataManagerWidget_CostTypes_MultipleCostType_ValidateCostImport = By.xpath("//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-multiple-cost-type-detail//form[contains(@name, 'costTypeForm')]//div[contains(@class, 'select-box')]//select[contains(@data-ng-model,'validateCostPrice')]");
				public By kalibrate_dataManagerWidget_CostTypes_MultipleCostType_Save = By.xpath("//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-multiple-cost-type-detail//form[contains(@name, 'costTypeForm')]//div//button[contains(@text, 'Save')]");
				
				public By kalibrate_dataManagerWidget_CostTypes_Add_new_Textbox = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-cost-type-tab//div//input[contains(@data-ng-model, 'costTypeNameInput')]");
				public By kalibrate_dataManagerWidget_CostTypes_Add_new_Button = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-cost-type-tab//div//button[contains(@text, 'Add New')]");
				
				public By kalibrate_dataManagerWidget_CostTypes_new_form_save = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-cost-type-detail//form[contains(@name, 'costTypeForm')]//div//button[contains(@text, 'Save')]");
				public By kalibrate_dataManagerWidget_CostTypes_new_form = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-cost-type-detail//form[contains(@name, 'costTypeForm')]");
				public By kalibrate_dataManagerWidget_CostTypes_new_form_sync = kalibrate_dataManagerWidget_CostTypes_new_form_save;
				public By kalibrate_dataManagerWidget_CostTypes_new_name = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-cost-type-detail//form[contains(@name, 'costTypeForm')]//div//input[contains(@data-ng-model, 'CostTypeDetail.name')]");
				public By kalibrate_dataManagerWidget_CostTypes_new_importCode = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-cost-type-detail//form[contains(@name, 'costTypeForm')]//div//input[contains(@name, 'costTypeImportCode')]");
				public By kalibrate_dataManagerWidget_CostTypes_new_Pricing_Widget = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-cost-type-detail//form[contains(@name, 'costTypeForm')]//div//label[contains(@for, 'DisplayOnPricingPage')]");
				public By kalibrate_dataManagerWidget_CostTypes_new_Validate = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-cost-type-detail//form[contains(@name, 'costTypeForm')]//div//label[contains(@for, 'ValidateCostPrice')]");
				public By kalibrate_dataManagerWidget_CostTypes_new_AggregatedCost = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-cost-type-detail//form[contains(@name, 'costTypeForm')]//div//label[contains(@for, 'ckc_aggregatedCost')]");
				public By kalibrate_dataManagerWidget_CostTypes_new_form_AggregatedCost_Formula = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-cost-type-detail//form[contains(@name, 'costTypeForm')]//div//textarea[contains(@data-ng-model, 'selectedCostTypeDetail.aggregatedCostFormula')]");
				public By kalibrate_dataManagerWidget_CostTypes_new_form_TotalCost = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-cost-type-detail//form[contains(@name, 'costTypeForm')]//div//label[contains(@for, 'ckc_totalCost')]");

	// Data Manager - Custom Data	
				public By kalibrate_dataManagerWidget_CustomData = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'default-list')]//div[contains(@title, 'create custom pricing data')]");
				public By kalibrate_dataManagerWidget_CustomData_sync = By.xpath("//manage-data-widget//span[contains(@title, 'Custom Display Data')]");

				public By kalibrate_dataManagerWidget_CustomData_Add_new_Textbox = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-custom-display-object-tab//div//input[contains(@data-ng-model, 'customDisplayObjectImportCodeInput')]");
				public By kalibrate_dataManagerWidget_CustomData_Add_new_Button = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-custom-display-object-tab//div//button[contains(@text, 'Add New')]");
				
				public By kalibrate_dataManagerWidget_CustomData_new_form_save = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-custom-display-object-detail//form[contains(@name, 'customDisplayObjectForm')]//div//button[contains(@text, 'Save')]");
				public By kalibrate_dataManagerWidget_CustomData_new_form = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-custom-display-object-detail//form[contains(@name, 'customDisplayObjectForm')]");
				public By kalibrate_dataManagerWidget_CustomData_new_form_sync = kalibrate_dataManagerWidget_CustomData_new_form_save;
				public By kalibrate_dataManagerWidget_CustomData_new_name = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-custom-display-object-detail//form[contains(@name, 'customDisplayObjectForm')]//div//input[contains(@data-ng-model, 'selectedCustomDisplayObjectDetail.displayName')]");
				public By kalibrate_dataManagerWidget_CustomData_new_importCode = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-custom-display-object-detail//form[contains(@name, 'customDisplayObjectForm')]//div//input[contains(@data-ng-model, 'selectedCustomDisplayObjectDetail.importCode')]");
				public By kalibrate_dataManagerWidget_CustomData_new_formula = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-custom-display-object-detail//form[contains(@name, 'customDisplayObjectForm')]//div//textarea[contains(@data-ng-model, 'selectedCustomDisplayObjectDetail.formula')]");
				public By kalibrate_dataManagerWidget_CustomData_new_Pricing_Widget = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-custom-display-object-detail//form[contains(@name, 'customDisplayObjectForm')]//div//label[contains(@for, 'VisibleOnPricingPage')]");

				
				
	// Data Manager - Sales Type	
		
				public By kalibrate_dataManagerWidget_SalesTypes = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'default-list')]//div[contains(@title, 'Create sales types')]");
				public By kalibrate_dataManagerWidget_SalesTypes_sync = By.xpath("//manage-data-widget//span[contains(@title, 'Sales Types')]");
				
				public By kalibrate_dataManagerWidget_SalesTypes_Add_new_Textbox = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-sales-type-tab//div//input[contains(@data-ng-model, 'salesTypeNameInput')]");
				public By kalibrate_dataManagerWidget_SalesTypes_Add_new_Button = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-sales-type-tab//div//button[contains(@text, 'Add New')]");
				
				public By kalibrate_dataManagerWidget_SalesTypes_new_form_save = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-sales-type-detail//form[contains(@name, 'salesTypeForm')]//div//button[contains(@text, 'Save')]");
				public By kalibrate_dataManagerWidget_SalesTypes_new_form = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-sales-type-detail//form[contains(@name, 'salesTypeForm')]");
				public By kalibrate_dataManagerWidget_SalesTypes_new_form_sync = kalibrate_dataManagerWidget_SalesTypes_new_form_save;
				public By kalibrate_dataManagerWidget_SalesTypes_new_name = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-sales-type-detail//form[contains(@name, 'salesTypeForm')]//div//input[contains(@data-ng-model, 'selectedSalesTypeDetail.name')]");
				public By kalibrate_dataManagerWidget_SalesTypes_new_importCode = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-sales-type-detail//form[contains(@name, 'salesTypeForm')]//div//input[contains(@data-ng-model, 'selectedSalesTypeDetail.importCode')]");
				public By kalibrate_dataManagerWidget_SalesTypes_new_include_agg = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-sales-type-detail//form[contains(@name, 'salesTypeForm')]//div//label[contains(@for, 'IncludeInAggregation')]");

				
				public By kalibrate_dataManagerWidget_SalesTypes_new_Payment_Type = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-sales-type-detail//form[contains(@name, 'salesTypeForm')]//div//select[contains(@data-ng-model, 'selectedSalesTypeDetail.paymentTypeId')]");
				public By kalibrate_dataManagerWidget_SalesTypes_new_Payment_Offset = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'content-data-widget')]//manage-sales-type-detail//form[contains(@name, 'salesTypeForm')]//div//select[contains(@data-ng-model, 'selectedSalesTypeDetail.promotionId')]");

				public By kalibrate_dataManagerWidget_ExtendedProperties = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'default-list')]//div[contains(@title, 'custom properties')]");
				public By kalibrate_dataManagerWidget_ExtendedProperties_sync = By.xpath("//manage-data-widget//span[contains(@title, 'Extended Properties')]");
				
						
				public By kalibrate_dataManagerWidget_SiteGrouping = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'default-list')]//div[contains(@title, 'create your own site groupings')]");
				public By kalibrate_dataManagerWidget_SiteGrouping_sync = By.xpath("//manage-data-widget//span[contains(@title, 'Site Groupings')]");
				
				public By kalibrate_dataManagerWidget_SystemCodes = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'default-list')]//div[contains(@title, 'Create import codes for any external systems')]");
				public By kalibrate_dataManagerWidget_SystemCodes_sync = By.xpath("//manage-data-widget//span[contains(@title, 'System Codes')]");
				
				public By kalibrate_dataManagerWidget_Products = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'default-list')]//div[contains(@title, 'Manage global products')]");
				public By kalibrate_dataManagerWidget_Products_sync = By.xpath("//manage-data-widget//span[contains(@title, 'Products')]");
				
				public By kalibrate_dataManagerWidget_ProductGroups = By.xpath("//div[@name='manage-data-widget']//manage-data-widget//div[contains(@class, 'default-list')]//div[contains(@title, 'Manage your product groups')]");
				public By kalibrate_dataManagerWidget_ProductGroups_sync = By.xpath("//manage-data-widget//span[contains(@title, 'Product Groups')]");
				
		//Retail Regression - Search 		
				
//				public By kalibrate_searchWidget_SearchTypeDropDownButton = By.xpath("//div[@name='adv-search-widget']//button[contains(@title, 'Search Types')]");
				public By kalibrate_searchWidget_SearchTypeDropDownList= By.xpath("//div[@name='adv-search-widget']//ul[contains(@class, 'search-type-list')]");
				public By kalibrate_searchWidget_SearchTypeOwnSite = By.xpath("//div[@name='adv-search-widget']//ul[contains(@class, 'search-type-list')]/li[text()='Own Sites']");
				public By kalibrate_searchWidget_SearchTypeCompetitorSite = By.xpath("//div[@name='adv-search-widget']//ul[contains(@class, 'search-type-list')]/li[text()='Competitor Sites']");
				public By kalibrate_searchWidget_SearchTypeDTA = By.xpath("//div[@name='adv-search-widget']//ul[contains(@class, 'search-type-list')]/li[text()='Dealer Trade Areas']");
				public By kalibrate_searchWidget_SearchTypeAllSites = By.xpath("//div[@name='adv-search-widget']//ul[contains(@class, 'search-type-list')]/li[text()='All Sites']");
				
				public By kalibrate_searchWidget_OwnSiteTab = By.xpath("//div[@name='adv-search-widget']//li[contains(@heading, 'Own Sites')]");
				public By kalibrate_searchWidget_CompetitorSitesTab = By.xpath("//div[@name='adv-search-widget']//li[contains(@heading, 'Competitor Sites')]");
				public By kalibrate_searchWidget_AllSitesTab = By.xpath("//div[@name='adv-search-widget']//li[contains(@heading, 'All Sites')]");

				public By kalibrate_searchWidget_OwnSite_1_Result = By.xpath("//div[@name='adv-search-widget']//adv-search-widget//div[contains(@class, 'default-item-data default-item-data-small')]");

				public By kalibrate_searchWidget_OwnSiteshovericon = By.xpath("//div[@name='adv-search-widget']//div[contains(@class, 'default-item-icons')]");
				
				
				public By kalibrate_searchWidget_OwnSite_SiteImage = By.xpath("//div[@name='adv-search-widget']//adv-search-widget//div[contains(@class, 'search-results default-list')]//span[@class = 'search-image']");
				public By kalibrate_searchWidget_OwnSite_SiteBrandImage = By.xpath("//div[@name='adv-search-widget']//adv-search-widget//div[contains(@class, 'search-results default-list')]//span[@class = 'search-image']//img[contains(@ng-src,'images/core')]");
				public By kalibrate_searchWidget_OwnSite_LeadFollowImage = By.xpath("//div[@name='adv-search-widget']//adv-search-widget//div[contains(@class, 'search-results default-list')]//span[@class = 'search-image']//img[contains(@src,'Overlay')]");

				
				public By kalibrate_searchWidget_OwnSitesAvailableMenu =  By.xpath("//div[@name='adv-search-widget']//div[contains(@class, 'default-item-icons')]/div[(@class, 'default-item-icons-list')]");
				public By kalibrate_searchWidget_OwnSitesPricing = By.xpath("//div[@name='adv-search-widget']//div[@class='default-item-icons-list']/img[@title='Pricing']");
				public By kalibrate_searchWidget_OwnSitesSiteManager = By.xpath("//div[@name='adv-search-widget']//div[@class='default-item-icons-list']/img[@title='Site Manager']");
				public By kalibrate_searchWidget_OwnSitesPumpPriceUpdate = By.xpath("//div[@name='adv-search-widget']//div[@class='default-item-icons-list']/img[@title='Pump Price Update']");

				public By kalibrate_searchWidget_OwnSitesIntel =  By.xpath("//div[@name='adv-search-widget']//div[@class='default-item-icons-list']/img[@title='Intel']");
				public By kalibrate_searchWidget_OwnSitesNotes = By.xpath("//div[@name='adv-search-widget']//div[@class='default-item-icons-list']/img[@title='Notes']");
				public By kalibrate_searchWidget_OwnSitesStrategy = By.xpath("//div[@name='adv-search-widget']//div[@class='default-item-icons-list']/img[@title='Site Strategy']");
				public By kalibrate_searchWidget_OwnSitesEventManager =  By.xpath("//div[@name='adv-search-widget']//div[@class='default-item-icons-list']/img[@title='Event Manager']");
				public By kalibrate_searchWidget_OwnSitesSiteMetrics = By.xpath("//div[@name='adv-search-widget']//div[@class='default-item-icons-list']/img[@title='Site Metrics']");
				public By kalibrate_searchWidget_OwnSitesReportViewer = By.xpath("//div[@name='adv-search-widget']//div[@class='default-item-icons-list']/img[@title='Report Viewer']");
				public By kalibrate_searchWidget_OwnSitesSitePlanner = By.xpath("//div[@name='adv-search-widget']//div[@class='default-item-icons-list']/img[@title='Site Planner']");

				
				
				public By kalibrate_pumppriceupdate_pumppricetext = By.xpath("//site-mixer-widget//span[contains(., 'Pump Price')]");
				public By kalibrate_pumppriceupdate_Sync = kalibrate_pumppriceupdate_pumppricetext;

				
	/// Retail Regression - Site Manager
				
				
				
				public By kalibrate_siteManagerWidget_availabletabs_list = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//li");
				public By kalibrate_siteManagerWidget_availabletabs = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//li");
				public By kalibrate_siteManagerWidget_availabletabs_heading = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//li/a");

				
				
				public By kalibrate_siteManagerWidget_Configuration_Spannar = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class, 'widget-menu-item')]//img[contains(@title, 'Configuration')]");
				public By kalibrate_siteManagerWidget_Default_Config = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'widget-configuration')]//span[contains(@class, 'default-option')]");
				public By kalibrate_siteManagerWidget_Default_Config_List = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'pricing-sections')]//div[contains(@class, 'default-add animate-show-hide')]");
				public By kalibrate_siteManagerWidget_Default_Config_Check_Box = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class, 'widget-menu-item')]//default-option-widget//div[contains(@class, 'default-option-widget')]//div[contains(@class, 'default-option-container')]//div[contains(@class, 'default-add animate-show-hide default-option-item')]//div[contains(@class, 'selection-item')]//div//input");
				public By kalibrate_siteManagerWidget_Default_Config_Check_Box_1 = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class, 'widget-menu-item')]//default-option-widget//div[contains(@class, 'default-option-widget')]//div[contains(@class, 'default-option-container')]//div[contains(@class, 'default-add animate-show-hide default-option-item')]//div[contains(@class, 'selection-item')]//div");
				public By kalibrate_siteManagerWidget_Default_Config_Apply_Button = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class, 'widget-menu-item')]//default-option-widget//div[contains(@class, 'default-option-widget')]//button[contains(@text, 'Apply')]");
				public By kalibrate_siteManagerWidget_Default_Config_Cancel_Button = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class, 'widget-menu-item')]//default-option-widget//div[contains(@class, 'default-option-widget')]//button[contains(@text, 'Cancel')]");

				public By kalibrate_siteManagerWidget_config_AllItems_Name = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class, 'widget-menu-item')]//div[contains(@class, 'default-option-container')]/div/div/h4");
				
				
				// Site Manager - PRODUCTS TAB
				public By kalibrate_siteManagerWidget_Products_tab_Sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//div[@data-data-tab='products']");
				public By kalibrate_siteManagerWidget_Products_title_Sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//div[@data-data-tab='products']//products//div[@class = 'ownproductnavigator']/span[@title='Products']");

				public By kalibrate_siteManagerWidget_Products_list_Products = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//div[@data-data-tab='products']//products//list-products//form//div//select[contains(@data-ng-model , 'selectedGlobalProductId')]");
				public By kalibrate_siteManagerWidget_Products_Add_New = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//div[@data-data-tab='products']//products//list-products//form//div//span//button[@text = 'Add New']");

				public By kalibrate_siteManagerWidget_Products_default_list = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//div[@data-data-tab='products']//products//list-products//form//div[@class = 'default-list']");
				
				public By kalibrate_siteManagerWidget_Products_defaultContainer = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//div[@data-data-tab='products']//products//list-products//form//div[@class = 'default-list']//div[@class ='default-item-container']");
				public By kalibrate_siteManagerWidget_Products_OwnProduct_list_form = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//div[@data-data-tab='products']//products//list-products//form//div[@class = 'default-list']//div[@class ='default-item-container']//div[contains(@data-ng-click , 'setCurrentProduct')]");
				public By kalibrate_siteManagerWidget_Products_OwnProduct_image_name = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//div[@data-data-tab='products']//products//list-products//form//div[@class = 'default-list']//div[@class ='default-item-container']//div[contains(@data-ng-click , 'setCurrentProduct')]//img");

				public By kalibrate_siteManagerWidget_Products_OwnProducts_form = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//div[@data-data-tab='products']//products//own-product//form[@name ='ownProductForm']//div//ng-form[@name='ownProductSettingsForm']");

				public By kalibrate_siteManagerWidget_Products_OwnProducts_Save = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//div[@data-data-tab='products']//products//own-product//form[@name ='ownProductForm']//div//span//button[@text='Save']");
				
				
				public By kalibrate_siteManagerWidget_Products_OwnProducts_Update_Save = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//div[@data-data-tab='products']//products//own-product//form[@name ='ownProductForm']//div//span//button[contains(@click ,'saveOwnProduct')]");

				
				public By kalibrate_siteManagerWidget_Products_OwnProducts_Delete = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//div[@data-data-tab='products']//products//own-product//form[@name ='ownProductForm']//div//span[text='Delete']");
				public By kalibrate_siteManagerWidget_Products_OwnProducts_Sync = kalibrate_siteManagerWidget_Products_OwnProducts_Save;
				public By kalibrate_siteManagerWidget_Products_OwnProducts_Active_property = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//div[@data-data-tab='products']//products//own-product//form[@name ='ownProductForm']//div//ng-form[@name='ownProductSettingsForm']//div[@class='default-property']//div[contains(. , 'Active')]");
				public By kalibrate_siteManagerWidget_Products_OwnProducts_Active_checkbox = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//div[@data-data-tab='products']//products//own-product//form[@name ='ownProductForm']//div//ng-form[@name='ownProductSettingsForm']//div[@class='default-property']//div//input[contains(@name , 'ckcActiveProduct')]");

				public By kalibrate_siteManagerWidget_Products_CompProducts_form = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//div[@data-data-tab='products']//products//competitor-product-detail//form[@name ='ownProductForm']//div//ng-form[@name='ownProductSettingsForm']");

				public By kalibrate_siteManagerWidget_Products_CompProducts_Save = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//div[@data-data-tab='products']//products//competitor-product-detail//form[@name ='ownProductForm']//div//span//button[@text='Save']");
				
				
				public By kalibrate_siteManagerWidget_Products_CompProducts_Update_Save = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//div[@data-data-tab='products']//products//competitor-product-detail//form[@name ='ownProductForm']//div//span//button[contains(@click ,'saveCompetitorProduct')]");

				
				public By kalibrate_siteManagerWidget_Products_CompProducts_Delete = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//div[@data-data-tab='products']//products//competitor-product-detail//form[@name ='ownProductForm']//div//span[text='Delete']");
				public By kalibrate_siteManagerWidget_Products_CompProducts_Sync = kalibrate_siteManagerWidget_Products_CompProducts_Save;
				public By kalibrate_siteManagerWidget_Products_CompProducts_Active_property = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//div[@data-data-tab='products']//products//competitor-product-detail//form[@name ='ownProductForm']//div//div[@class='default-property']//div[contains(. , 'Active')]");
				public By kalibrate_siteManagerWidget_Products_CompProducts_Active_checkbox = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//div[@data-data-tab='products']//products//competitor-product-detail//form[@name ='ownProductForm']//div//div[@class='default-property']//div//label[contains(@data-ng-class , 'ckcActiveCompetitorProduct')]");


				//Site Manager - PRODUCTS GROUP TAB
				
				public By kalibrate_siteManagerWidget_ProductGroups_tab_Sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//li[@heading='Product Groups']");
				public By kalibrate_siteManagerWidget_ProductGroups_title_Sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//site-setup//div[@class = 'ownproductnvigator']/span[@title='Product Groups']");

		
				public By kalibrate_siteManagerWidget_ProductGroups_OwnProductGroup_list = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//site-setup//own-product-group//div[contains(@class ,'default-list')]");
				
				public By kalibrate_siteManagerWidget_ProductGroups_OwnProductGroup_list_form = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//site-setup//own-product-group//div[contains(@class ,'default-list')]//div[contains(@data-ng-click, 'setCurrentProductGroup')]");
				public By kalibrate_siteManagerWidget_ProductGroups_OwnProductGroup_image_name = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//site-setup//own-product-group//div[contains(@class ,'default-list')]//div[contains(@data-ng-click, 'setCurrentProductGroup')]//div//img");

				public By kalibrate_siteManagerWidget_ProductGroups_OwnProductGroup_form =  By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//site-setup//own-product-group-detail//form[@name = 'ownProductGroupForm']");
				
				
				public By kalibrate_siteManagerWidget_ProductGroups_OwnProductGroup_Save = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'aproduct-history-tab']//site-setup//own-product-group-detail//form[@name = 'ownProductGroupForm']//div//span/button[contains(@click,'assignProductGroupToSite')]");
				public By kalibrate_siteManagerWidget_ProductGroups_OwnProductGroup_Update_Save = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//site-setup//own-product-group-detail//form[@name = 'ownProductGroupForm']//div//span/button[contains(@text,'Save')]");

				public By kalibrate_siteManagerWidget_ProductGroups_OwnProductGroup_Delete = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//site-setup//own-product-group-detail//form[@name = 'ownProductGroupForm']");
				
				
				
				public By kalibrate_siteManagerWidget_ProductGroups_OwnProductGroup_Sync =kalibrate_siteManagerWidget_ProductGroups_title_Sync;
				
				// Settings tab
				public By kalibrate_siteManagerWidget_ProductGroups_OwnProductGroup_Settings_tab = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//site-setup//own-product-group-detail//form[@name = 'ownProductGroupForm']//div//ul/li[@heading = 'Settings']");

				public By kalibrate_siteManagerWidget_ProductGroups_OwnProductGroup_Active_property = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//site-setup//own-product-group-detail//form[@name = 'ownProductGroupForm']//div//table/tbody/tr/td[contains(.,'Active')]");
			//	public By kalibrate_siteManagerWidget_ProductGroups_OwnProductGroup_Active_checkbox = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//site-setup//own-product-group-detail//form[@name = 'ownProductGroupForm']//div//table/tbody/tr/td//input[contains(@type , 'checkbox')]");
				public By kalibrate_siteManagerWidget_ProductGroups_OwnProductGroup_Active_checkbox = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//site-setup//own-product-group-detail//form[@name = 'ownProductGroupForm']//div//table/tbody/tr/td//label[contains(@class , 'check-label')]");

				
				public By kalibrate_siteManagerWidget_ProductGroups_OwnProductGroup_Lead_Follow_property = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//site-setup//own-product-group-detail//form[@name = 'ownProductGroupForm']//div//div[@class = 'tab-pane active']/table/tbody/tr/td[contains(.,'Lead Follow Automatically Implement')]");
				public By kalibrate_siteManagerWidget_ProductGroups_OwnProductGroup_Lead_Follow_List = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//site-setup//own-product-group-detail//form[@name = 'ownProductGroupForm']//div//table/tbody/tr/td//span//Select[contains(@name , 'lfAutoImplements')]");

				public By kalibrate_siteManagerWidget_ProductGroups_OwnProductGroup_Auto_Implement_property = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//site-setup//own-product-group-detail//form[@name = 'ownProductGroupForm']//div//table/tbody/tr/td[contains(.,'Automatically Implement')]");
				public By kalibrate_siteManagerWidget_ProductGroups_OwnProductGroup_Auto_Implement_List = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//site-setup//own-product-group-detail//form[@name = 'ownProductGroupForm']//div//table/tbody/tr/td//span//Select[contains(@data-ng-class , 'ddl_autoImplement')]");

				public By kalibrate_siteManagerWidget_ProductGroups_OwnProductGroup_Price_Generation_property = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//site-setup//own-product-group-detail//form[@name = 'ownProductGroupForm']//div//table/tbody/tr/td[contains(.,'Generate Prices')]");
				public By kalibrate_siteManagerWidget_ProductGroups_OwnProductGroup_Price_Generation_List = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//site-setup//own-product-group-detail//form[@name = 'ownProductGroupForm']//div//table/tbody/tr/td//span//Select[contains(@name , 'ddl_generatePrices')]");

				public By kalibrate_siteManagerWidget_ProductGroups_OwnProductGroup_Main_Marker_property = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//site-setup//own-product-group-detail//form[@name = 'ownProductGroupForm']//div//table/tbody/tr/td[contains(.,'Main Marker')]");
				public By kalibrate_siteManagerWidget_ProductGroups_OwnProductGroup_Main_Marker_List = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//site-setup//own-product-group-detail//form[@name = 'ownProductGroupForm']//div//table/tbody/tr/td//span//Select[contains(@name , 'ownSiteCompetitor')]");

				// Product Tab
				public By kalibrate_siteManagerWidget_ProductGroups_OwnProductGroup_Products_tab = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//site-setup//own-product-group-detail//form[@name = 'ownProductGroupForm']//div//ul/li[@heading = 'Products']");

				
				//Site Manager Local Market
				
				public By kalibrate_siteManagerWidget_LocalMarket_tab_Sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//li[@heading='Local Market']");
				public By kalibrate_siteManagerWidget_LocalMarket_title_Sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//local-market//span[@title='Local Market']");

				public By kalibrate_siteManagerWidget_LocalMarket_selection_box = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//local-market//local-market-site//div[contains(@class , 'select-box-relation')]//select[@data-ng-model='selectedSiteType']");

				public By kalibrate_siteManagerWidget_LocalMarket_SearchType = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//local-market//local-market-site//adv-search-widget//div[@class = 'search-box']//div//button[@title ='Search Types']");
				public By kalibrate_siteManagerWidget_LocalMarket_Own_Sites = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//local-market//local-market-site//adv-search-widget//div[@class = 'search-box']//div//ul[contains(@class,'search-type-list')]/li[text()='Own Sites']");
				public By kalibrate_siteManagerWidget_LocalMarket_Competitor_Sites = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//local-market//local-market-site//adv-search-widget//div[@class = 'search-box']//div//ul[contains(@class,'search-type-list')]/li[text()='Competitor Sites']");
				public By kalibrate_siteManagerWidget_LocalMarket_Search_Text_Box = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//local-market//local-market-site//adv-search-widget//div[@class = 'search-box']//div//input[contains(@placeholder,'Enter search text')]");
				public By kalibrate_siteManagerWidget_LocalMarket_Search_Button = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//local-market//local-market-site//adv-search-widget//div[@class = 'search-box']//div//button[@text = 'Search']");

				public By kalibrate_siteManagerWidget_LocalMarket_Search_SelectAll = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//local-market//local-market-site//adv-search-widget//div[@class = 'search-results-outer']//div//span[@class = 'search-select-all']");
				public By kalibrate_siteManagerWidget_LocalMarket_Search_Add_Selected = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[contains(@class , 'product-history-tab')]//local-market//local-market-site//div[contains(@class,'default-property-save')]//button[contains(@text , 'Add Selected')]");

				//Site Manager Lead  and Follow
				
				public By kalibrate_siteManagerWidget_Lead_Follow_tab_Sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//li[@heading='Lead & Follow']");
				public By kalibrate_siteManagerWidget_Lead_Follow_form_Sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow");
				public By kalibrate_siteManagerWidget_Lead_Follow_Relationship = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/ul/li[contains(@heading,'Relationships')]");
				public By kalibrate_siteManagerWidget_Lead_Follow_Settings = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/ul/li[contains(@heading,'Settings')]");
				public By kalibrate_siteManagerWidget_Lead_Follow_Relationship_form = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']");
				public By kalibrate_siteManagerWidget_Lead_Follow_Relationship_ProductGroup = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//button[contains(@title,'Product Group Level')]");
				public By kalibrate_siteManagerWidget_Lead_Follow_Relationship_Product = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//button[contains(@title,'Product Level')]");

				//Lead Follow ProductGroup

				public By kalibrate_siteManagerWidget_Lead_Follow_Product_group_Form = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product-group//div[@class = 'lead-follow-relationships']");
				
				public By kalibrate_siteManagerWidget_Lead_Follow_Product_group_OwnProductGroup_dropdown = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product-group//div[@class = 'lead-follow-relationships']//table/tbody//select[contains(@data-ng-model,'productGroupRelation.ownProductGroupId')]");
		
				public By kalibrate_siteManagerWidget_Lead_Follow_Product_group_Search = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product-group//div[@class ='lead-follow-relationships']/table//tbody//tr//td//div[@class = 'select-box-relation']");
				public By kalibrate_siteManagerWidget_Lead_Follow_Product_group_Search_Drop = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product-group//div[@class ='lead-follow-relationships']/table//tbody//tr//td//div[@class = 'select-box-relation']//button[@title = 'Search']");
				public By kalibrate_siteManagerWidget_Lead_Follow_Product_group_Search_popup = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product-group//div[@class ='lead-follow-relationships']/table//tbody//tr//td//div[@class = 'select-box-relation']//div//adv-search-widget//div[@class = 'adv-search']");
				public By kalibrate_siteManagerWidget_Lead_Follow_Product_group_Search_Text = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product-group//div[@class ='lead-follow-relationships']/table//tbody//tr//td//div[@class = 'select-box-relation']//div//adv-search-widget//div[@class = 'adv-search']//div//input[@type = 'search']");
				public By kalibrate_siteManagerWidget_Lead_Follow_Product_group_Search_button = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product-group//div[@class ='lead-follow-relationships']/table//tbody//tr//td//div[@class = 'select-box-relation']//div//adv-search-widget//div[@class = 'adv-search']//div//button[@text = 'Search']");
				public By kalibrate_siteManagerWidget_Lead_Follow_Product_group_Search_result = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product-group//div[@class ='lead-follow-relationships']/table//tbody//tr//td//div[@class = 'select-box-relation']//div//adv-search-widget//div[@class = 'adv-search']//div[contains(@class , 'search-results')]");
				public By kalibrate_siteManagerWidget_Lead_Follow_Product_group_Search_Select_Site = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product-group//div[@class ='lead-follow-relationships']/table//tbody//tr//td//div[@class = 'select-box-relation']//div//adv-search-widget//div[@class = 'adv-search']//div[contains(@class , 'search-results')]//div//span[contains(@class , 'search-title')]");

				public By kalibrate_siteManagerWidget_Lead_Follow_Product_group_Relation_ProductGroup = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product-group//div[@class = 'lead-follow-relationships']//table/tbody//select[contains(@data-ng-model,'productGroupRelation.relatedOwnProductGroupId')]");


				//public By kalibrate_siteManagerWidget_Lead_Follow_Product_group_Offset = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product-group//div[@class = 'lead-follow-relationships']//table/tbody//div//input[contains(@data-ng-model,'productGroupRelation.offset')]");
				public By kalibrate_siteManagerWidget_Lead_Follow_Product_group_Offset = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product-group//div[@class = 'lead-follow-relationships']//table/tbody//td//div//input[contains(@type,'number')]");

				public By kalibrate_siteManagerWidget_Lead_Follow_Product_group_Save_Sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product-group//div//button[contains(@click , 'saveProductGroupRelationships()')]");
				public By kalibrate_siteManagerWidget_Lead_Follow_Product_group_Save = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product-group//div//button[contains(@class , 'lead-follow-button-update loading-button')]");



				//Lead Follow Product
				public By kalibrate_siteManagerWidget_Lead_Follow_Product_Form = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product//div[@class = 'lead-follow-relationships']");
				
				public By kalibrate_siteManagerWidget_Lead_Follow_Product_OwnProduct_dropdown = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product//div[@class = 'lead-follow-relationships']//table/tbody//select[contains(@data-ng-model,'productRelation.ownProductId')]");
		
				public By kalibrate_siteManagerWidget_Lead_Follow_Product_Search = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product//div[@class ='lead-follow-relationships']/table//tbody//tr//td//div[@class = 'select-box-relation']");
				public By kalibrate_siteManagerWidget_Lead_Follow_Product_Search_Drop = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product//div[@class ='lead-follow-relationships']/table//tbody//tr//td//div[@class = 'select-box-relation']//button[@title = 'Search']");
				public By kalibrate_siteManagerWidget_Lead_Follow_Product_Search_popup = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product//div[@class ='lead-follow-relationships']/table//tbody//tr//td//div[@class = 'select-box-relation']//div//adv-search-widget//div[@class = 'adv-search']");
				public By kalibrate_siteManagerWidget_Lead_Follow_Product_Search_Text = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product//div[@class ='lead-follow-relationships']/table//tbody//tr//td//div[@class = 'select-box-relation']//div//adv-search-widget//div[@class = 'adv-search']//div//input[@type = 'search']");
				public By kalibrate_siteManagerWidget_Lead_Follow_Product_Search_button = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product//div[@class ='lead-follow-relationships']/table//tbody//tr//td//div[@class = 'select-box-relation']//div//adv-search-widget//div[@class = 'adv-search']//div//button[@text = 'Search']");
				public By kalibrate_siteManagerWidget_Lead_Follow_Product_Search_result = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product//div[@class ='lead-follow-relationships']/table//tbody//tr//td//div[@class = 'select-box-relation']//div//adv-search-widget//div[@class = 'adv-search']//div[contains(@class , 'search-results')]");
				public By kalibrate_siteManagerWidget_Lead_Follow_Product_Search_Select_Site = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product//div[@class ='lead-follow-relationships']/table//tbody//tr//td//div[@class = 'select-box-relation']//div//adv-search-widget//div[@class = 'adv-search']//div[contains(@class , 'search-results')]//div//span[contains(@class , 'search-title')]");

				public By kalibrate_siteManagerWidget_Lead_Follow_Product_Relation_Product = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product//div[@class = 'lead-follow-relationships']//table/tbody//select[contains(@data-ng-model,'productRelation.relatedOwnProductId')]");
				public By kalibrate_siteManagerWidget_Lead_Follow_Product_Offset = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product//div[@class = 'lead-follow-relationships']//table/tbody//input[contains(@data-ng-model,'productRelation.offset')]");

				public By kalibrate_siteManagerWidget_Lead_Follow_Product_Save_Sync = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product//div//button[contains(@click , 'save()')]");
				public By kalibrate_siteManagerWidget_Lead_Follow_Product_Save = By.xpath("//div[@name='manage-sites-widget']//manage-sites-widget//div[@class= 'product-history-tab']//lead-follow//div/lead-follow-relationships//div[@class = 'lead-follow']//lead-follow-product//div//button[contains(@class , 'lead-follow-button-update loading-button')]");



				/// PUMP PRICE UPDATE
				public By kalibrate_pumpPriceUpdateWidget_Title = By.xpath("//div[@name='site-mixer-widget']//div/span//h4[contains(.,'Pump Price Update')]");

				public By kalibrate_pumpPriceUpdateWidget_Close = By.xpath("//div[@name='site-mixer-widget']//div/span/a[@title = 'Close Widget']");
				public By kalibrate_pumpPriceUpdateWidget_Refresh = By.xpath("//div[@name='site-mixer-widget']//div/span/a[@title = 'Reload Widget']");
				public By kalibrate_pumpPriceUpdateWidget_Maximize = By.xpath("//div[@name='site-mixer-widget']//div/span/a[@title = 'Maximise Widget']");

				//PPU Own Site Details
				public By kalibrate_pumpPriceUpdateWidget_Ownsite_name = By.xpath("//div[@name='site-mixer-widget']//site-mixer-widget//form[@name = 'mixingDeskForm']//div[contains(@class , 'pump-price-update own-site ')]/span");
				public By kalibrate_pumpPriceUpdateWidget_Own_Pump_Price = By.xpath("//div[@name='site-mixer-widget']//site-mixer-widget//form[@name = 'mixingDeskForm']//div[contains(@class,'flex-container mixer-widget')]//div/span");
				public By kalibrate_pumpPriceUpdateWidget_Product_Price_All = By.xpath("//div[@name='site-mixer-widget']//site-mixer-widget//form[@name = 'mixingDeskForm']//div[contains(@class,'flex-container mixer-widget')]//div[@class='flex-div mixer-product-data']");
				public By kalibrate_pumpPriceUpdateWidget_Product_Price_Input = By.xpath("//div[@name='site-mixer-widget']//site-mixer-widget//form[@name = 'mixingDeskForm']//div[contains(@class,'flex-container mixer-widget')]//div[contains(@class,'flex-div mixer-product-data')]//div[@data-ng-if='product.Active']//input[@data-ng-model='pricevalue']");
				public By kalibrate_pumpPriceUpdateWidget_Apply_Price = By.xpath("//div[@name='site-mixer-widget']//site-mixer-widget//form[@name = 'mixingDeskForm']//div[contains(@class,'mixer-buttons')]//button[contains (@text,'Apply')]");
				public By kalibrate_pumpPriceUpdateWidget_Resumbit_Price = By.xpath("//div[@name='site-mixer-widget']//site-mixer-widget//form[@name = 'mixingDeskForm']//div[contains(@class,'mixer-buttons')]//button[contains (@text,'Resubmit prices')]");

				// Pricing Widget
				
		
				public By kalibrate_pricing_Widget_Generate_Price_Button_1 = By.xpath("//div[@name='pricing-widget']//pricing-widget//div[contains(@class, 'flex-container')]//div[contains(@class, 'pricing-generate-generate-button')]/button[contains(.,'Generate Prices')]");
				public By kalibrate_pricing_Widget_Generate_Price_Button_2 = By.xpath("//div[@name='pricing-widget']//pricing-widget//div[contains(@class, 'pricing-bottom-panel')]//div[contains(@class, 'pricing-generate-panel')]/button[contains(@text,'Generate Prices')]");
				public By kalibrate_pricing_Widget_Successful_Price_Generation_Notification_Message = By.xpath ("//div[@name='pricing-widget']//div[contains(.,'New prices have successfully been generated.')]");
				public By kalibrate_pricing_Widget_Successful_Price_Generation_Notification = By.xpath("//div[@name='pricing-widget']//div[contains(@class, 'notification success flex-container')]//div//img[contains(.,'New prices have successfully been generated.')]");

				
				public By kalibrate_pricingWidget_ExporttoCsv = By.xpath("//div[@name='pricing-widget']//div[contains(@class, 'widget-menu')]//button[@text='Export to CSV']");

				//MultiPricing Widget
				public By kalibrate_multiPricingWidget_ExporttoCsv = By.xpath("//div[@name='multi-pricing-widget']//div[contains(@class, 'widget-menu')]//button[@text='Export to CSV']");

				
				// REPORT VIEWER
				//public By kalibrate_reportViewerWidget_Sync =  kalibrate_reportViewerWidget_Reports;
				public By kalibrate_reportViewerWidget_Close = By.xpath("//div[@name='report-viewer-widget']//div/span/a[@title = 'Close Widget']");
				public By kalibrate_reportViewerWidget_Refresh = By.xpath("//div[@name='report-viewer-widget']//div/span/a[@title = 'Reload Widget']");
				public By kalibrate_reportViewerWidget_Maximize = By.xpath("//div[@name='report-viewer-widget']//div/span/a[@title = 'Maximise Widget']");
				public By kalibrate_reportViewerWidget_Settings = By.xpath("//div[@name='report-viewer-widget']//div/span/a[@title = 'Widget Settings']");

				public By kalibrate_reportViewerWidget_Pricing_Reports_tab = By.xpath("//div[@name='report-viewer-widget']//report-viewer-widget//div[contains(@class ,'widget-menu-content')]//ul/li[@heading='Pricing Reports']");
				
				public By kalibrate_reportViewerWidget_Pricing_Reports_list = By.xpath("//div[@name='report-viewer-widget']//report-viewer-widget//div[contains(@class ,'widget-menu-content')]//div[contains(@data-ng-repeat , 'report in reports')]//div/h4");

				public By kalibrate_reportViewerWidget_Title_name = By.xpath("//div[@name='report-viewer-widget']//div/span//h4");

				public By kalibrate_reportViewerWidget_report_container = By.xpath("//div[@name='report-viewer-widget']//report-viewer-widget//div[@class = 'reports-container']");

				public By kalibrate_reportViewerWidget_report_menu_button = By.xpath("//div[@name='report-viewer-widget']//report-viewer-widget//div[@class = 'reports-container']//div[@class = 'ui-grid-menu-button']");
				public By kalibrate_reportViewerWidget_report_menu_option_list = By.xpath("//div[@name='report-viewer-widget']//report-viewer-widget//div[@class = 'reports-container']//div[@class = 'ui-grid-menu-button']//ul[@class = 'ui-grid-menu-items']//li");
				public By kalibrate_reportViewerWidget_report_menu_option_Export_All = By.xpath("//div[@name='report-viewer-widget']//report-viewer-widget//div[@class = 'reports-container']//div[@class = 'ui-grid-menu-button']//ul[@class = 'ui-grid-menu-items']//li[@id='menuitem-1']");

				
				// Intel Widget 
				
				public By kalibrate_intelWidget_Title = By.xpath("//div[@name='k-intel-widget']//div/span//h4");

				public By kalibrate_intelWidget_Close = By.xpath("//div[@name='k-intel-widget']//div/span/a[@title = 'Close Widget']");
				public By kalibrate_intelViewerWidget_Refresh = By.xpath("//div[@name='k-intel-widget']//div/span/a[@title = 'Reload Widget']");
				public By kalibrate_intelViewerWidget_Maximize = By.xpath("//div[@name='k-intel-widget']//div/span/a[@title = 'Maximise Widget']");
				public By kalibrate_intelViewerWidget_Settings = By.xpath("//div[@name='k-intel-widget']//div/span/a[@title = 'Widget Settings']");
				public By kalibrate_intelWidget_sync = kalibrate_intelWidget_Title;

			
				public By kalibrate_intelWidget_SaveandExport = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-menu')]//img[@title='Save & Export']");
				public By kalibrate_intelWidget_ExporttoCsv = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-menu')]//div[contains(@class,'intel-export active')]//button[contains(.,'Export to CSV')]");

				public By kalibrate_intelWidget_Visualize = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-menu')]//img[@title='Visualize']");
				public By kalibrate_intelWidget_Search = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-menu')]//img[@title='Search']");
				public By kalibrate_intelWidget_SetupCustomChart = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-menu')]//img[@title='Setup Custom Charts']");
				public By kalibrate_intelWidget_Settings = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-menu')]//img[@title='Settings']");

				public By kalibrate_intelWidget_Settings_Reporting_Type = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-menu')]//div[contains(@class, 'default-property')]//div[contains(.,  'Reporting Type:')]");
				public By kalibrate_intelWidget_Visualize_Sync = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-menu')]//div[contains(@class, 'visualise active')]//div[contains(.,  'Available Visualizations')]");
				public By kalibrate_intelWidget_Visualize_StandardChart_Tab = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-menu')]//div//ul/li[@heading = 'Standard Charts']");
				public By kalibrate_intelWidget_Visualize_CustomChart_Tab = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-menu')]//div//ul/li[@heading = 'Custom Charts']");
				
				public By kalibrate_intelWidget_Visualize_StandardChart_ChartList = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-menu')]//div//div[@class = 'charts']//div[contains(@data-ng-repeat ,'chartType in availablePricingCharts')]");

				public By kalibrate_intelWidget_Visualize_CustomChart_ChartList = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-menu')]//div//div[@class = 'charts']//div[contains(@data-ng-repeat ,'customChart in customCharts')]");

				public By kalibrate_intelWidget_Visualize_StandardChart_Chartname = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-menu')]//div//div[@class = 'charts']//div[contains(@data-ng-repeat ,'chartType in availablePricingCharts')]//div[contains(@class , 'default-add-name')]//h4[contains(.,*)]");
				public By kalibrate_intelWidget_Visualize_CustomChart_Chartname = By.xpath("//div[@name='k-intel-widget']//div[contains(@class, 'widget-menu')]//div//div[@class = 'charts']//div[contains(@data-ng-repeat ,'customChart in customCharts')]//div[contains(@class , 'default-add-name')]//h4[contains(.,*)]");
				
				
				public By kalibrate_intelWidget_Visualize_Chart_NoChartdisplayed = By.xpath("//div[@name='k-intel-widget']//div[contains(@class , 'chart-content')]//div[contains(@class , 'intel-message-image')]//div[contains(.,'No data was returned')]");
				public By kalibrate_intelWidget_Visualize_Chart_CoreChart = By.xpath("//div[@name='k-intel-widget']//div[contains(@class , 'chart-content')]/*[name()='svg']/*[contains(@class ,'intel-corechart-chart')]");

				
				///*** End of Gayathri's Locators ***	
		

	
	
}
