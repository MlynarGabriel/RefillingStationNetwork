Feature: Set operating status of charging stations

  Scenario: Set a charging station to "in operation"
    Given I am the owner
    And a charging station is currently "out of order"
    When I set the status of the station to "in operation"
    Then the charging station should be marked as "in operation free"

  Scenario: Set a charging station to "out of order"
    Given I am the owner
    And a charging station is currently "in operation"
    When I set the status to "out of order"
    Then the charging station should be marked as "out of order"

  Scenario: Set a charging station to "occupied"
    Given I am the owner
    And a charging station is currently "in operation free"
    When a customer starts charging
    Then the charging station should automatically be marked as "occupied"