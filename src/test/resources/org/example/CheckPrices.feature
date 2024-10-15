Feature: Check prices for charging at a location

  Scenario: View current prices at a specific location
    Given I am a registered customer or the owner
    When I look up the location "A"
    Then I should see the price for all available power types at location "A"

  Scenario: View prices at multiple locations
    Given I am a registered customer or the owner
    When I view the prices for multiple locations "B" and "C"
    Then I should see the price differences between the two "B" and "C" locations for kWh AC, kWh DC, and per-minute charging rates