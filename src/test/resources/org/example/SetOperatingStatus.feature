Feature: Set a charging point to a specific status

  Scenario: Set a charging point to a specific status
    Given a charging point is currently "IN_OPERATION_FREE"
    When I set the status of the station to "IN_OPERATION_FREE"
    Then the charging point should be marked as "IN_OPERATION_FREE"

  Scenario: Charging has started
    Given a charging point is currently "IN_OPERATION_FREE"
    When a customer starts charging
    Then the charging point should automatically be marked as "OCCUPIED"

  #Error Case: Set invalid status
  Scenario: Try to set a charging point to "UNKNOWN"
    Given a charging point is currently "IN_OPERATION_FREE"
    When I try to set the status of the station to "UNKNOWN"
    Then the charging point should return an error message saying "Invalid status"

  #Edge Case: delete "IN_OPERATION_FREE" status
  Scenario: Attempt to delete "IN_OPERATION_FREE" status
    Given the status is set to "IN_OPERATION_FREE"
    When I try to remove the status
    Then I should the error message "status cant be deleted"