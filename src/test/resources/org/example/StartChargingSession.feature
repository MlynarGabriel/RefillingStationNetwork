Feature: Start charging session

Scenario: Start charging session with sufficient balance
    Given I am a register customer with a balance of 69.00 EUR
    And I am at a charging point that is "IN_OPERATION_FREE"
    When I select "DC" as my charging mode and start a charging session
    Then the charging session should begin with the current DC price per kWh locked in
    And my balance should be reduced based on the usage at the locked-in rate

  Scenario: Attempt to start charging with insufficient balance
    Given I am a registered customer with a balance of 3.00 EUR
    And the estimated cost for DC charging is 10.00 EUR
    When I attempt to start a charging session
    Then I should receive an error message "Insufficient funds. Please top up your account to start charging."

  Scenario: Deny charging session if station is out of order
    Given I am a registered customer at a charging point that is "OUT_OF_ORDER"
    When I attempt to start a charging session
    Then I should see an error message "Charging station is currently out of order. Please try another station."

Scenario: Attempt to start multiple charging session attempt on a single account at once
    Given I am a registered customer with a single account
    When I attempt to start multiple charging session at once
    Then I should see an error message "Account can not start multiple session"




