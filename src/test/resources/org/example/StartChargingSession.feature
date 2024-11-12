Feature: Start charging session

Scenario: Start charging session with sufficient balance
    Given I am a register customer with a balance of 69.00 EUR
    And I am at a charging point that is "IN_OPERATION_FREE"
    When I select "DC" as my charging mode and start a charging session
    Then the charging session should begin with the current DC price per kWh locked in
    And my balance should be reduced based on the usage at the locked-in rate

#ErrorCase:
  Scenario: Deny charging session if station is out of order
    Given I am a registered customer at a charging point that is "OUT_OF_ORDER"
    When I attempt to start a charging session
    Then I should see an error message "Charging station is currently out of order. Please try another station."




