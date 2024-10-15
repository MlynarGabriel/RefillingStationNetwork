Feature: Set prices for each location

  Scenario: Set initial prices for a new location
    Given I am the owner
    When I add a new location with prices for kWh AC ,kWh DC and per minute AC charging
    Then the prices should be set for the new location

  Scenario: Set the same prices for all locations
    Given I have multiple locations
    And I am the owner of those locations
    When I set the prices for all locations
    Then all locations should reflect the new prices

  Scenario: Set negative price
    Given I am the owner
    When I try inputing -1 EUR as the price
    Then an error message should be displayed

