Feature: Set a charging station to a specific status

  Scenario: Set a charging station to a specific status
    Given a charging point is currently "IN_OPERATION_FREE"
    When I set the status of the station to "IN_OPERATION_FREE"
    Then the charging point should be marked as "IN_OPERATION_FREE"

  Scenario: Charging has started
    Given a charging point is currently "IN_OPERATION_FREE"
    When a customer starts charging
    Then the charging point should automatically be marked as "OCCUPIED"

  Scenario: Charging has stopped
    Given a charging point is currently "OCCUPIED"
    When a customer stops charging
    Then the charging point should automatically be marked as "IN_OPERATION_FREE"



