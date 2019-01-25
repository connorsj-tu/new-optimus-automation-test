@optimus @callreport @wip
Feature: Optimus - Call Report - Regression

  Scenarios used to prove the readiness of Call Report in an Optimus environment

	#https://pllwindvweb005/CallReport/

            #<company>Optimus CR CTest</company>
            #<username>Optimus CR API CTest</username>
            #<password>password123</password>

	@positive @basiccheck
  Scenario: Call Report Log in page displayed

		Given the Call Report Login page is displayed
		
		
	@positive @login
  Scenario: Log in to Call Report

		Given the Call Report Login page is displayed
  	When valid credentials are submitted to Call Report
    Then Call Report Welcome page is displayed

    
    
	@positive @regression
  Scenario: View Credit Report in Call Report

		Given the Call Report Login page is displayed
  	When valid credentials are submitted to Call Report
    Then Call Report Welcome page is displayed

		Then Credit Report is viewed in Call Report