Feature: Check invoice status and details

  Scenario: Check the status of unpaid invoices
    Given I am a registered customer
    When I check my invoice status
    Then I should see a list of unpaid invoices with the total amounts due

  Scenario: Check if there are any outstanding balances
    Given I have completed charging sessions
    When I check my account
    Then the system should display any outstanding balances from unpaid invoices