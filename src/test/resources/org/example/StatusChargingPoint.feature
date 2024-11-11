Feature: Charging Point Availability

  Scenario: View the status of a specific charging point
    Given I am a registered customer
    When I check the status of the charging point at location "A"
    Then I should see the status of the charging point (e.g., "IN_OPERATION_FREE", "OCCUPIED", "OUT_OF_ORDER")

    

