Feature: Enter registration details and receive customer ID

  Scenario: Register a new customer
    Given I am a new user
    When I enter my name, email, and password into the registration form
    Then my registration should be processed
    And I should receive a unique customer ID

  Scenario: Receive a confirmation email with customer ID
    Given I have successfully registered
    When the registration is completed
    Then I should receive a confirmation email with my unique customer ID

  Scenario: Registration with missing required fields
    Given I am a new user
    When I attempt to register with missing fields
    Then the system should display an error message indicating that the name is missing
    And the system should display an error message indicating that the email is missing
    And the system should display an error message indicating that the password is missing

  Scenario: Registration with an invalid email
    Given I am a new user
    When I enter my name, an invalid email, and a valid password into the registration form
    Then my registration should not be processed
    And the system should display an error message for the invalid email

  Scenario: Registration with a short password
    Given I am a new user
    When I enter my name, a valid email, and a short password into the registration form
    Then my registration should not be processed
    And the system should display an error message indicating that the password is too short

  Scenario: Registration with a name containing invalid characters
    Given I am a new user
    When I enter a name containing invalid characters, a valid email, and a valid password
    Then my registration should not be processed
    And the system should display an error message for invalid characters in the name