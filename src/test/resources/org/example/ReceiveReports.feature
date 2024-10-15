Feature: Receive operational reports

  Scenario: Generate a report on charging station usage
    Given I am the owner
    When I request a report for a location on charging station usage
    Then I should receive a report showing the total number of sessions, energy consumed, and average charging time for that location

  Scenario: Generate a financial report for all locations
    Given I am the owner
    When I request a financial report for all locations
    Then I should receive a report showing total revenue, top-ups, and expenses for each location
