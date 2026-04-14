
@searchFuntionality
Feature: Search Functionality

Scenario: User is able to search product by using  search functionality
Given user is on the Home Page
When user is enter the product name "iphone" in search bar
And user is click on the search button
Then user should be able to see the search products

Scenario: User is able to search product by using  search functionality
Given user is on the Home Page
When user is enter the product name "iMac" in search bar
And user is click on the search button
Then user should be able to see the search products


Scenario Outline: User is able to see the No product found message if the product is not available on the WebSite

Given user is on the Home Page
When user is enter the product name "<ProductName>" in search bar
And user is click on the search button
Then user should be able to see the message "There is no product that matches the search criteria."

Examples:

|ProductName|
|Fitbit|
|MitPit|


Scenario: User is able to see the No product found message when user is not giving any input into the search box
Given user is on the Home Page
And user is click on the search button
Then user should be able to see the message "There is no product that matches the search criteria."