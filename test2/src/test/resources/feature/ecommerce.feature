
Feature: Testing the e-commerce site 

Background:
 Given the user launches the site 

Scenario: Removing the lowest price item from cart 
 Given I add four random items to my cart
 When I view my cart
 Then I find total four items listed in my cart
 When I search for the lowest price item
 And I am able to remove the lowest price item from my cart
 Then I am able to verify the three items in my cart 
 
 
