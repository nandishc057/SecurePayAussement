Feature: SecurePay Assesment Test 

Scenario: Navigate to SecurePay Contact Page and fill the Contact Us form using Random Data 
	Given Searches for "SecurePay" on "https://www.google.com.au/" 
	When Clicks through to the SecurePay website 
	And Navigates to the contact us page 
	Then Verifies that the contact us page is loaded 
	And Generates random data using an open-source library 
	Then Uses the generated data to fill in the contact us form 
	And The test must not submit the form 
	
