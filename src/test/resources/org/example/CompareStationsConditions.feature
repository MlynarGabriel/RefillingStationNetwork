Feature: Compare charging stations by distance, prices, and power type

  Scenario: Compare stations by distance
    Given I am looking for the nearest station
    When I compare stations by distance
    Then the system should display the closest stations first, along with their distances from my location

  Scenario: Compare stations by prices
    Given there are several stations in my area
    When I compare the prices for kWh AC and DC
    Then I should see a list of stations sorted by the cheapest charging rates

  Scenario: Compare stations by power type (AC/DC)
    Given I need a specific type of charging station
    When I compare stations by power type
    Then the system should show me all the available AC or DC stations in the selected area