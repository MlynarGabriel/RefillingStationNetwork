Feature: Enter registration details and receive customer ID

  Scenario Outline: Register a new customer
    Given I am a new user
    When I  enter "<name>" as a name, "<email>" as the email address, and "<password>" as a password
    Then my registration should be processed
    And I should receive a unique customer ID
    Examples:
    | name    | email               | password   |
    |John Doe | johndoe@example.com | passwort123|

  Scenario Outline: Registration with missing required fields
    Given I am a new user
    When I  enter "<name>" as a name, "<email>" as the email address, and "<password>" as a password
    Then the system should display an error message "please enter a name"
    And the system should display an error message "please enter an email"
    And the system should display an error message "please enter a password"
    Examples:
      | name    | email             | password   |
      |         |johndoe@example.com|Pwrt1234    |
      | John Doe|                   |Pwrt1234    |
      | John Doe|johndoe@example.com|            |


  Scenario Outline: Register with too short password
    Given I am a new user
    When I enter "<name>" as a name, "<email>" as the email address, and "<password>" as a password
    Then my registration should not be processed
    And the system should display an error message "the password is too short"

    Examples:
      | name       | email               | password |
      | John Doe   | johndoe@example.com | P1       |

#Error Case: Wrong Email Format
  Scenario Outline: Attempt to register email without the correct email format
    Given I am a new user
    When I enter <name> as a name, <email> as the email address, and <passwort> as a password into the registration form
    Then my registration should not be processed
    And the system should display an error message "please enter a correct email"
    Examples:
      | name       | email         | passwort |
      | "John Doe" | "johndoe.com" | "Pw1234" |


