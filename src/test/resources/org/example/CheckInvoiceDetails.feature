Feature: Check invoice details

  Scenario: View account balance
    Given I am a registered customer
    And I am logged in
    When I access my account information
    Then I should see my account balance "50"

  Scenario Outline: View account top-up history
    Given I am a registered customer
    When I check my account top-up history
    Then I should see a history of recent top-ups, including dates and amounts
    Examples:
      | date       | amount |
      | 15.08.2024 | 100    |
      | 16.09.2024 | 50     |
      
  #Edge Case: Top-up history is empty
  Scenario: Edge Case - Top-up history is empty
    Given I am a registered customer
    When I check my account top-up history
    And I have never topped up
    Then I should see an empty history
    Examples:
      | date          | amount            |
      | null          | null              | 

      #test