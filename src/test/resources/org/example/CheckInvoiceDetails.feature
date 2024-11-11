Feature: Check invoice details

  Scenario: View account balance
    Given I am a registered customer
    And I am logged in
    When I access my account information
    Then I should see my account balance "50"


  Scenario: View account top-up history
    Given I am a registered customer
    When I check my account top-up history
    Then I should see a history of recent top-ups, including dates and amounts
    Examples:
      | date          | amount            |
      | 15.08.2024    | 100               |
      | 16.09.2024    | 50                |
      
