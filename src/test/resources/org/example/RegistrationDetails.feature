Feature: Enter registration details and receive customer ID

  Scenario: Register a new customer
    Given I am a new user
    When I enter my name, email, and password into the registration form
    Then my registration should be processed
    And I should receive a unique customer ID

  Scenario: Attempt registration with missing details
    Given I have not entered all required fields
    When I attempt to register
    Then the system should display an error message asking for the missing details

