
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file
	
	Background:
	Given I landed on Ecommerce Page


  @RegressionTwo
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username<name> and password<password>
    When I add the product <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | name                 | password      | productName   |
      | abc@learning.com     | Sahaj2003@    | IPHONE 13 PRO |
