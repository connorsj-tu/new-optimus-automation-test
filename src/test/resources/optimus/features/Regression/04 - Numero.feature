@optimus @numero 
Feature: Optimus - Numero - Regression

  Scenarios used to prove the readiness of Numero in an Optimus environment


	@positive @basiccheck
  Scenario: Numero Sign In page displayed

		Given the Numero Sign In page is displayed
		
		
	@positive @login
  Scenario: Log in to Numero

#		Given the Numero Sign In page is displayed
#  #	When valid credentials are submitted to Numero
#  	When a 'Numero Admin User' valid username and valid password are submitted to Numero
#    Then Numero main page is displayed

		Given the Numero Interactive URL is submitted
		And any logon screens are navigated
		Then Numero main page is displayed

	@positive @regression
  Scenario: View Dispute in Numero

		Given the Numero Sign In page is displayed
  	When a 'Numero Admin User' valid username and valid password are submitted to Numero
    Then Numero main page is displayed

		And dispute is present in Numero Interactive 

	@positive @regression @callreport
  Scenario: Request a new report from Call Report 

		Given the Numero Sign In page is displayed
  	When a 'Numero Admin User' valid username and valid password are submitted to Numero
    Then Numero main page is displayed

		And dispute is present in Numero Interactive
		And a new Call Report credit report can be requested from Numero 

