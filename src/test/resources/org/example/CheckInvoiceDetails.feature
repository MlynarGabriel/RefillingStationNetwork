Feature: Check invoice details

  Scenario: View my invoices
    Given I am a registered customer
    When I check my invoices
    Then I should see the details of my most recent charging session including the location, charging point, duration, energy loaded, and total cost

  Scenario 2: View account balance
    Given I am a registered customer
    When I check my account balance
    Then I should see the total balance available

  Scenario 3: View account top-up history
    Given I am a registered customer
    When I check my account top-up history
    Then I should see a history of recent top-ups, including dates and amounts
