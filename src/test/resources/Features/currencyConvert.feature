@CurrencyConvert
Feature: To validate the currency conversion

  Background:
    Given Configure WebDriver instance

  Scenario: To convert amount from USD to INR and validate the result
    Given User navigates to xe website
    And Enter amount 5 from "US Dollar" and To "Indian Rupee"
    And Clicks on convert button
    Then Converted value should be "413"


