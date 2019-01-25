@optimus @ginger 
Feature: Optimus - Ginger - Regression

  Scenarios used to prove the readiness of Ginger in an Optimus environment


	@positive @basiccheck
  Scenario: Ginger Log in page displayed

		Given the Ginger Sign In page is displayed
   
    
	@positive @login
  Scenario: Log in to Ginger

		Given the Ginger Sign In page is displayed
  	When valid credentials are submitted to Ginger
    Then Ginger Dashboard is displayed

    
	@positive @regression
  Scenario: View Credit Report in Ginger

		Given the Ginger Sign In page is displayed
  	When valid credentials are submitted to Ginger
    Then Ginger Dashboard is displayed

		Then Credit Report is viewed in Ginger


	@positive @regression
  Scenario: Create a Dispute in Ginger

		Given the Ginger Sign In page is displayed
  	When valid credentials are submitted to Ginger
    Then Ginger Dashboard is displayed

		Then Credit Report is viewed in Ginger
		And a dispute is raised in Ginger