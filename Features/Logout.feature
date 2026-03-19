@opencart

Feature: Logout feature


Scenario: Successful Login
   Given the user navigate to login page
   When user enters email and password
   And the user clicks on the login button
   Then the user should be redirected to the MyAccount
   When the user click on the logout button
   Then the user should be redirected to the logout page
   