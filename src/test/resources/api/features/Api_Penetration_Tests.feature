Feature: API Tests for Penetration Testing

@api @pen
Scenario: API Test - Pen Test 1 - POST to SaveWidgetData as authenticated user 
	When user is authenticated
	And 'pen test 1' 'POST' request is sent to 'SaveWidgetData'
	Then a '500' response code is received
	And the returned json object is not null
	

@api @pen
Scenario: API Test - Pen Test 2 - POST to SaveWidgetData as authenticated user 
	When user is authenticated
	And 'pen test 2' 'POST' request is sent to 'SaveWidgetData'
	Then a '500' response code is received
	And the returned json object is not null

@api @pen
Scenario: API Test - Pen Test 3 - POST to SaveWidgetData as authenticated user 
	When user is authenticated
	And 'pen test 3' 'POST' request is sent to 'SaveWidgetData'
	Then a '500' response code is received
	And the returned json object is not null
			