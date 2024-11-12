Feature: Enter payment details and confirm order


 Scenario: Top-up account and view updated balance
  Given I am a registered customer
  And I have an account with balance of 10.00 EUR
  When I top up my account with 50.00 EUR
  Then my account balance should be updated
  And I should see my new balance as 60.00 EUR

#Error Case:
 Scenario: Attempt to topUp with zero
  Given I am a registered customer
  And I have an account with balance of 10.00 EUR
  When I top up my account with 0 EUR
  Then I should receive an error message "value needs to be greater than zero"


#Error Case: negative value
 Scenario: Attempt to topUp with negative value
  Given I am a registered customer
  And I have an account with balance of 10.00 EUR
  When I top up my account with -5.00 EUR
  Then I should receive an error message "no negative values allowed"

#Edge Case: very large top up amount
  Scenario: Attempt to top up with a ver large amount
    Given I am a registered customer
    And I have an account with balance of 10.00 EUR
    When I top up my account with 1000000.00 EUR
    Then my account balance should be updated
    And I should see my new balance as 1000010.00 EUR