@searchFuntionality
Feature: Search Functionality

Scenario: User is able to search product by using  search functionality

Given user is on the Home Page
When user is enter the product name "iphone" in search bar
And user is click on the search button
Then user should be able to see the search products

