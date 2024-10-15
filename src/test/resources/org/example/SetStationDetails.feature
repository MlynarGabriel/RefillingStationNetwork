Feature: Set station details

  Scenario: Add a new charging station to a location
    Given I am the owner
    When I add a charging station to a new location
    And I specify the station as "AC" type
    Then the new AC charging station should be available at the location

  Scenario: Set multiple charging stations for a location
    Given a location has no charging stations
    When I add three charging stations to this location
    And I specify two of them as "AC" type and one as "DC" type
    Then this location should have two AC charging stations and one DC charging station