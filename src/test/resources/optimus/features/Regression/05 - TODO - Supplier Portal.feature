@optimus @supplierportal @wip
Feature: Optimus - Supplier Portal - Regression

  Scenarios used to prove the readiness of the Supplier Portal in an Optimus environment


	@positive @basiccheck
  Scenario: Supplier Portal Login page displayed

		Given the Supplier Portal Login page is displayed
		
		
	@positive @login
  Scenario: Log in to the Supplier Portal

		Given the Supplier Portal Login page is displayed
  	When valid credentials are submitted to the Supplier Portal
    Then the Supplier Portal Welcome page is displayed
    
    
	@positive @regression
  Scenario: View Dispute in the Supplier Portal

		Given the Supplier Portal Login page is displayed
  	When valid credentials are submitted to the Supplier Portal
    Then the Supplier Portal Welcome page is displayed

		And dispute is present in the Supplier Portal