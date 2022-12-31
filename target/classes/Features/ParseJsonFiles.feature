@ParseJSONFile
Feature: To parse the json file and log the values

  Scenario: To parse the json file and validate response
    When Read JSON file from resources and Map JSON to POJO objects
    Then Parse the response fields
