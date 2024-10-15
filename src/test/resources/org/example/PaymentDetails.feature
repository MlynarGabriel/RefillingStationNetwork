Feature: Enter payment details and confirm order

  Scenario: Enter payment details for account top-up
    Given I am a registered customer
    When I enter my payment details and amount to top up my account
    Then my payment details should be validated
    And my account should be credited with the entered amount

  Scenario: Confirm top-up order
    Given I have entered my payment details
    When I confirm the top-up order
    Then the system should display a confirmation message with the top-up amount

  Scenario: Receive payment notification
    Given I have successfully topped up my account
    When the payment is processed
    Then I should receive a notification confirming the payment and the new account balance