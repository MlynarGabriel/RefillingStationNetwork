Feature: Change prices for each location

  Scenario: Change prices for a specific location
    Given I am the owner
    When I update the price of kWh AC to 0.24 EUR at a location
    Then the price for kWh AC at a location should be 0.24 EUR

  Scenario: Change prices multiple times a day
    Given the current price for kWh DC is 0.35 EUR at a location
    When I change the price of kWh DC to 0.38 EUR in the afternoon
    And I change it again to 0.40 EUR in the evening
    Then the price of kWh DC should be 0.40 EUR by the end of the day