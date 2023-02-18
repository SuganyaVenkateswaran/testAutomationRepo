@WeatherApp
Feature: To validate the response of WeatherApp APIs


  Background:
    Given Configure RestAssured

  @WorkWithScenarioOutline
  Scenario Outline: To hit weather app
    Given Query params are "<q>" and "<appId>"
    When GET WeatherApp API call is made and assert statusCode 200
    Then Validate the response lat "51.51", lon "-0.13", description "light intensity drizzle", pressure "1012", country "GB" and name "London"
    Examples:
      | q         | appId                             |
      | London    | b1b15e88fa797225412429c1c50c122a1 |
      | London,us | b1b15e88fa797225412429c1c50c122a1 |

  Scenario: To hit weatherApp API using multiple q and appId and validate response
    Given Query params are q "London", q "uk" and appId "b1b15e88fa797225412429c1c50c122a1"
    When GET WeatherApp API call is made and assert statusCode 200
    Then Validate the response lat "0.1", lon "-0.13", description "light intensity drizzle", pressure "1012", country "GB" and name "London"

    @WorkWithQueryParams
  Scenario: To hit weatherApp API using multiple q and appId and validate response
    Given Query params are id 2172797 and appId "b1b15e88fa797225412429c1c50c122a1"
    When GET WeatherApp API call is made and assert statusCode 200
    Then Validate the response lat "-16.92", lon "145.77", description "scattered clouds", pressure "1007", country "AU" and name "Cairns"

  Scenario: To hit weatherApp API using multiple q and appId and validate response
    Given Query params are lat 35, lon 139 and appId "b1b15e88fa797225412429c1c50c122a1"
    When GET WeatherApp API call is made and assert statusCode 200
    Then Validate the response lat "35.02", lon "139.01", description "clear sky", pressure "1013.75", country "JP" and name "Tawarano"

  Scenario: To hit weatherApp API using multiple q and appId and validate response
    Given Query params are zip "94040", zip "us" and app
    When GET WeatherApp API call is made and assert error statusCode 200
    Then Validate the error response cod 401 and message "Invalid API key. Please see http://openweathermap.org/faq#error401 for more info."


