@optimus @noddle
Feature: Optimus - Noddle - Regression

  Scenarios used to prove the readiness of Noddle in an Optimus environment


	@positive @basiccheck
  Scenario: Noddle home page displayed

		Given the Noddle home page is displayed
		
		
	@positive @login
  Scenario: Log in to Noddle

  	Given the Noddle home page is displayed
  	When the 'Log in' button is clicked in the Noddle header
  	Then the Noddle 'Log In' page should be displayed
  
    #When a 'Noddle Standard Consumer' valid username and valid password are entered
    When a 'Noddle Other Consumer' valid username and valid password are submitted to Noddle
    Then Noddle main page is displayed


	@positive @regression @james
  Scenario: View Credit Report in Noddle
  
  	Given the Noddle home page is displayed
  	When the 'Log in' button is clicked in the Noddle header
  	Then the Noddle 'Log In' page should be displayed
  
    #When a 'Noddle Standard Consumer' valid username and valid password are entered
    When a 'Noddle Other Consumer' valid username and valid password are submitted to Noddle
    Then Noddle main page is displayed
      
		Then Credit Report is viewed in Noddle      
      
	@positive @regression 
  Scenario: Create a Dispute in Noddle

  	Given the Noddle home page is displayed
  	When the 'Log in' button is clicked in the Noddle header
  	Then the Noddle 'Log In' page should be displayed
  
    #When a 'Noddle Standard Consumer' valid username and valid password are entered
    When a 'Noddle Other Consumer' valid username and valid password are submitted to Noddle
    Then Noddle main page is displayed
    
    Then Credit Report is viewed in Noddle      
    
		When a Consumer disputes a Noddle "single Credit Card (SHARE)" data item with reason "The start date on the account is incorrect"
#		When a Consumer disputes a Noddle "alias link" data item with reason "I have never been known by this name"
    
    When Noddle main page is displayed
    And the 'Log out' button is clicked in the Noddle header
    Then User is returned to the Noddle home page
    #And The browser is closed
 
 
 #		Then dispute is present in noddle admin panel
 
#		Then dispute is present in numero interactive 

