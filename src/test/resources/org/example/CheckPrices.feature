Feature: Check prices for charging at a location

  Scenario: View current prices at a specific location
    Given I am a registered customer or the owner
    When I look up the location "A"
    Then I should see the price for all available power types at location "A"

  Scenario: View prices at two locations
    Given I am a registered customer or the owner
    When I view the prices for two locations "B" and "C"
    Then I should see the price differences between the two "B" and "C" locations for kWh AC, kWh DC