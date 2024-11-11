Feature: Manage prices for locations

  Scenario: Set initial prices for a new location
    Given I am the owner
    When I add a new location "A" with prices for 0.34 kWh AC ,0.44 kWh DC
    Then the prices should be set for the new location "A" 0.34 kWh AC ,0.44 kWh DC

  Scenario: Update prices for one or multiple locations
    Given I am the owner
    When I update the price of kWh AC to 0.24 EUR at a specific location or all locations
    Then the price for kWh AC at that location or all locations should be updated to 0.24 EUR

  #Error Case: negative price
  Scenario: Attempt to update price with a negative value
    Given I am the owner
    When I update the price of kWh AC to -0.24 EUR at a specific location or all locations
    Then I should receive an error message "no negative value" for the Price_AC

  #Error Case: price is 0
  Scenario: Attempt to update price to zero
    Given I am the owner
    When I update the price of kWh AC to 0 EUR at a specific location or all locations
    Then I should receive an error message "price must be a above zero" for the Price_AC

  #Edge Case: try to delete price
    Given I am the owner
    When I delete the price for location "A"
    Then I should receive an error message "price cannot be deleted"