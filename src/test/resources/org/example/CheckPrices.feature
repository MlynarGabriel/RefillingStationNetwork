Feature: Check prices for charging at a location

  Scenario: View current price for DC at a specific location
    Given I am a registered customer or the owner
    When I look up the location "A"
    Then I should see the price "0.15" for DC at location "A"


  #Error Case: Price is null
  Scenario: Attempt to view prices at location without set price
    Given I am a registered customer or the owner
    When I look up the location "A"
    And the price is not set
    Then I should see an error message "no prices available for this location"

  #Edge Case: price set to 0
  Scenario: View current price for DC at a location with a price near zero or negative
    Given I am a registered customer or the owner
    When I look up the location "C"
    And the price for DC at location "C" is set to 0.00 EUR
    Then I should see the price "0.00" for DC at location "C"