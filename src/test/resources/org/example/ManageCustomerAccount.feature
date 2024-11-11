Feature: Manage Customer Account

  Scenario: Change Password
    Given I am a registered customer
    When I want to change my password to "pwd56789"
    And the previous password is not "pwd56789"
    Then the password will be change to "pwd56789"

  Scenario: Delete Account
    Given I am a registered customer
    When I want to delete my account
    Then my account should be deleted

  #ErrorCase: Password changes are too short
  Scenario: Attempt to change password with less than 4 characters
    Given I am a registered customer
    When I try to change my password to "123"
    Then an error message should be display "the password too short"

   #Edge Case: Attempt to change password to the same one
  Scenario: Attempt to change password to the same old password
    Given I am a registered customer
    When I try to change my password to "pwd12345"
    And the new password is the same as the old password "pwd12345"
    Then an error message should be displayed "New password cannot be the same as the old password"