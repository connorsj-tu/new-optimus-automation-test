Feature: API Tests for Penetration Testing

@api @optimus
Scenario: API Test - Pen Test 1 - POST to SaveWidgetData as authenticated user 
	And new 'numero create dispute' 'POST' request is sent to 'NumeroCreateDispute'
	Then a '500' response code is received
#	And the returned json object is not null
	

			