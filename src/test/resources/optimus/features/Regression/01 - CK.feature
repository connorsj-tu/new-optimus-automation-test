@optimus @ck
Feature: Optimus - ck - Regression

  Scenarios used to prove the readiness of ck in an Optimus environment


	@positive @basiccheck
  Scenario: ck home page displayed

		Given the ck home page is displayed
		
		
	@positive @login
  Scenario: Log in to ck

  	Given the ck home page is displayed
  	When the 'Log in' button is clicked in the ck header
  	Then the ck 'Log In' page should be displayed
  
    #When a 'ck Standard Consumer' valid username and valid password are entered
    When a 'ck Other Consumer' valid username and valid password are submitted to ck
    Then ck main page is displayed


	@positive @regression 
  Scenario: View Credit Report in ck
  
  	Given the ck home page is displayed
  	When the 'Log in' button is clicked in the ck header
  	Then the ck 'Log In' page should be displayed
  
    #When a 'ck Standard Consumer' valid username and valid password are entered
    When a 'ck Other Consumer' valid username and valid password are submitted to ck
    Then ck main page is displayed
      
		Then Credit Report is viewed in ck      
      
	@positive @regression @james
  Scenario: Create a Dispute in ck

  	Given the ck home page is displayed
  	When the 'Log in' button is clicked in the ck header
  	Then the ck 'Log In' page should be displayed
  
    #When a 'ck Standard Consumer' valid username and valid password are entered
    When a 'ck Other Consumer' valid username and valid password are submitted to ck
    Then ck main page is displayed
    
    Then Credit Report is viewed in ck      
    
		When a Consumer disputes a ck "single Credit Card (SHARE)" data item with reason "The start date on the account is incorrect"
#		When a Consumer disputes a ck "alias link" data item with reason "I have never been known by this name"
    
    When ck main page is displayed
    And the 'Log out' button is clicked in the ck header
    Then User is returned to the ck home page
    #And The browser is closed
 
 
 #		Then dispute is present in ck admin panel
 
#		Then dispute is present in numero interactive 

