@opencartunc

   Feature: Login Feature
   
   Scenario: Successful Login with Valid Credentials
   Given the user navigate to login page
   When user enters email and password
   And the user clicks on the login button
   Then the user should be redirected to the MyAccount 
   
   

   Scenario: Unsuccessful login with invalid Credentials
   Given the user navigate to login page
   When user enter "<email>" and "<password>"
   And the user clicks on the login button
   Then the warning message should be displayed "Warning: No match for E-Mail Address and/or Password."
   
   Examples:
   
   |email|password|
   |xyzabc123@gmail.com|xyzabc123|
   |xyzabc123@gmail.com|12345|
   
   
   
   