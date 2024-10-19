Feature: Manage prices for locations

  Scenario: Set initial prices for a new location
    Given I am the owner
    When I add a new location "A" with prices for "0.34" kWh AC ,"0.44" kWh DC
    Then the prices should be set for the new location "A" "0.34" kWh AC ,"0.44" kWh DC

  Scenario: Change prices for a specific location
    Given I am the owner
    When I update the price of kWh AC to 0.24 EUR at a location
    Then the price for kWh AC at a location should be 0.24 EUR

  Scenario: Set the same prices for all locations
    Given I am the owner
    And have multiple locations
    When I set the prices for all locations
    Then all locations should reflect the new prices