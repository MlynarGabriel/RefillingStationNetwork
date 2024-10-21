Feature: Set operating status of charging stations

  Scenario: Set a charging station to "in operation"
    Given I am the owner
    And a charging point is currently "out of order"
    When I set the status of the station to "in operation"
    Then the charging point should be marked as "in operation free"

  Scenario: Set a charging station to "out of order"
    Given I am the owner
    And a charging point is currently "in operation"
    When I set the status to "out of order"
    Then the charging point should be marked as "out of order"

  Scenario: Set a charging station to "occupied"
    Given a charging point is currently "in operation free"
    When a customer starts charging
    Then the charging point should automatically be marked as "occupied"

  Scenario: Attempt to set a charging station status without permissions
    Given I am not the owner
    And a charging point is currently "in operation free"
    When I attempt to set the status of the station to "in operation"
    Then a message should be displayed saying "You do not have permission to change the status."

  Scenario: Attempt to set a charging station status when already in the desired state
    Given I am the owner
    And a charging point is currently "in operation"
    When I set the status of the station to "in operation"
    Then a message should be displayed saying "The charging station is already in the desired state."

  Scenario: Attempt to set a charging station status to an invalid state
    Given I am the owner
    And a charging point is currently "out of order"
    When I set the status of the station to "unknown status"
    Then a message should be displayed saying "Invalid status: unknown status."

  Scenario: Attempt to set a charging station status when the station is busy
    Given I am the owner
    And a charging point is currently "occupied"
    When I attempt to set the status of the station to "in operation"
    Then a message should be displayed saying "Cannot change status: Charging point is currently occupied."