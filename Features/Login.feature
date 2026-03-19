@opencart

   Feature: Login Feature
   
   Scenario: Successful Login with Valid Credentials
   Given the user navigate to login page
   When user enters email and password
   And the user clicks on the login button
   Then the user should be redirected to the MyAccount 
   
   
   