Feature: API Tests for User Account Service

@api @GetUserSettings @positive
Scenario: API Test - GET to GetUserSettings with valid creds 
	When valid credentials are used
	And a 'GET' request is sent to 'GetUserSettings'
	Then a '200' response code is received
	And an authentication token is returned
			
@api @GetUserSettings @negative
Scenario: API Test - GET to GetUserSettings with invalid creds 
	When invalid credentials are used
	And a 'GET' request is sent to 'GetUserSettings'
	Then a '401' response code is received

@api @GetAllUsers @positive
Scenario: API Test - GET to GetAllUsers as authenticated user 
	When user is authenticated
	And a 'GET' request is sent to 'GetAllUsers'
	Then a '200' response code is received
	And the returned json array is not null
	
@api @GetAllUsers @negative
Scenario: API Test - GET to GetAllUsers as unauthenticated user 
	When user is not authenticated
	And a 'GET' request is sent to 'GetAllUsers'
	Then a '401' response code is received
	

@api @GetAllUsers @negative
Scenario: API Test - POST to GetAllUsers as authenticated user 
	When user is authenticated
	And a 'POST' request is sent to 'GetAllUsers'
	Then a '411' response code is received

@api @GetAllUsers @negative
Scenario: API Test - POST to GetAllUsers as unauthenticated user 
	When user is not authenticated
	And a 'POST' request is sent to 'GetAllUsers'
	Then a '411' response code is received		
	

@api @GetAllUserSettings @positive
Scenario: API Test - GET to GetAllUserSettings as authenticated user 
	When user is authenticated
	And a 'GET' request is sent to 'GetAllUserSettings'
	Then a '200' response code is received
	And the returned json object is not null


@api @GetAllProfiles @positive
Scenario: API Test - GET to GetAllProfiles as authenticated user 
	When user is authenticated
	And a 'GET' request is sent to 'GetAllProfiles'
	Then a '200' response code is received
	And the returned json array is not null
	

@api @GetWorkspaceUsers @positive
Scenario: API Test - GET to GetWorkspaceUsers as authenticated user 
	When user is authenticated
	And a 'GET' request is sent to 'GetWorkspaceUsers'
	Then a '200' response code is received
	And the returned json array is not null
	

@api @GetAllPrimaryRoles @positive
Scenario: API Test - GET to GetAllPrimaryRoles as authenticated user 
	When user is authenticated
	And a 'GET' request is sent to 'GetAllPrimaryRoles'
	Then a '200' response code is received
	And the returned json array is not null
	

@api @GetEmptyMultiUser @positive
Scenario: API Test - GET to GetEmptyMultiUser as authenticated user 
	When user is authenticated
	And a 'GET' request is sent to 'GetEmptyMultiUser'
	Then a '200' response code is received
	And the returned json object is not null
	

@api @GetUserFilterTypes @positive @ignore
Scenario: API Test - GET to GetUserFilterTypes as authenticated user 
	When user is authenticated
	And a 'GET' request is sent to 'GetUserFilterTypes'
	Then a '200' response code is received
	And the returned json array is not null
	

@api @VerifyWindowsUser @positive
Scenario: API Test - GET to VerifyWindowsUser as authenticated user 
	When user is authenticated
	And a 'GET' request is sent to 'VerifyWindowsUser'
	Then a '200' response code is received
	And the returned json object is not null
	

@api @AcknowledgeLogin @positive @wip
Scenario: API Test - POST to AcknowledgeLogin as authenticated user 
	When user is authenticated
	And a 'POST' request is sent to 'AcknowledgeLogin'
	Then a '200' response code is received
	And the returned json object is not null
	

	