Feature: Check invoice details (as customer)

  Scenario: View my latest invoice
    Given I am a registered customer
    When I check my latest invoice
    Then I should see the details of my most recent charging session including the location, charging point, duration, energy loaded, and total cost

  Scenario: View account top-up and balance status
    Given I am a registered customer
    When I check my account balance
    Then I should see the total balance available and a history of recent top-ups