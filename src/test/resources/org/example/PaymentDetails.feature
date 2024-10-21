Feature: Enter payment details and confirm order


 Scenario: Top-up account and view updated balance
  Given I am a registered customer
  And I have an account with balance of 10.00 EUR
  When I top up my account with 50.00 EUR
  Then my account balance should be updated
  And I should see my new balance as 60.00 EUR