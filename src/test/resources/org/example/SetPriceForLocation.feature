Feature: Set prices for each location

  Scenario: Set initial prices for a new location
    Given I am the owner
    When I add a new location "A" with prices for "0.34" kWh AC ,"0.44" kWh DC
    Then the prices should be set for the new location "A" "0.34" kWh AC ,"0.44" kWh DC

  Scenario: Set the same prices for all locations
    Given I have multiple locations
    And I am the owner of those locations
    When I set the prices for all locations
    Then all locations should reflect the new prices


