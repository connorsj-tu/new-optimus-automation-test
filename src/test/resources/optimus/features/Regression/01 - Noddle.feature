@optimus @noddle
Feature: Optimus - Noddle - Regression

  Scenarios used to prove the readiness of Noddle in an Optimus environment


	@positive @basiccheck
  Scenario: Noddle home page displayed

		Given the noddle home page is displayed
		
		
	@positive @login
  Scenario: Log in to Noddle

  	Given the noddle home page is displayed
  	When the 'Log in' button is clicked in the header
  	Then the 'Log In' page should be displayed
  
    #When a 'Standard Consumer' valid username and valid password are entered
    When a 'Other Consumer' valid username and valid password are entered
    And the Login button is clicked
    Then noddle main page is displayed


	@positive @regression @james
  Scenario: View Credit Report in Noddle
  
  	Given the noddle home page is displayed
  	When the 'Log in' button is clicked in the header
  	Then the 'Log In' page should be displayed
  
    #When a 'Standard Consumer' valid username and valid password are entered
    When a 'Other Consumer' valid username and valid password are entered
    And the Login button is clicked
    Then noddle main page is displayed
      
		Then Credit Report is viewed in Noddle      
      
	@positive @regression 
  Scenario: Create a Dispute in Noddle

  	Given the noddle home page is displayed
  	When the 'Log in' button is clicked in the header
  	Then the 'Log In' page should be displayed
  
    #When a 'Standard Consumer' valid username and valid password are entered
    When a 'Other Consumer' valid username and valid password are entered
    And the Login button is clicked
    Then noddle main page is displayed
    
    Then Credit Report is viewed in Noddle      
    
		When a Consumer disputes a "single Credit Card (SHARE)" data item with reason "The start date on the account is incorrect"
#		When a Consumer disputes an "alias link" data item with reason "I have never been known by this name"
    
    When noddle main page is displayed
    And the 'Log out' button is clicked in the header
    Then User is returned to the home page
    #And The browser is closed
 
 
 #		Then dispute is present in noddle admin panel
 
#		Then dispute is present in numero interactive 

