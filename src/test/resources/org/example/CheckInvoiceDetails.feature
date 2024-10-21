Feature: Check invoice details

  Scenario: View account balance and invoice details
    Given I am a registered customer
    When I access my account information
    Then I should see my account balance and the details of my most recent charging session

  Scenario: View account top-up history
    Given I am a registered customer
    When I check my account top-up history
    Then I should see a history of recent top-ups, including dates and amounts
