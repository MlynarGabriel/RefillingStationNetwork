Feature: Set station details

  Scenario: Add a new charging station to a location
    Given I am the owner
    When I add a charging station to a new location
    And I specify the station as "AC" type
    Then the new AC charging station should be available at the location

