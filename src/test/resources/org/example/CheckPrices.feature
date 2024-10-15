Feature: Check prices for charging at a location

  Scenario: View current prices at a specific location
    Given I am a registered customer or the owner
    When I view the prices for a location
    Then I should see the price for all available power types

  Scenario: View prices at multiple locations
    Given I am a registered customer or the owner
    When I view the prices for multiple locations
    Then I should see the price differences between the two locations for kWh AC, kWh DC, and per-minute charging rates