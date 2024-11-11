Feature: Charging Point Availability

  Scenario: View the status of a specific charging point
    Given I am a registered customer
    When I check the status of the charging point at location "A"
    Then I should see the status of the charging point "IN_OPERATION_FREE"

  Scenario: Check if charging point has a "DC"
    Given I am a registered customer
    When I check the power type of a charging point at location "A"
    Then I should see "DC"

  #EdgeCase
  Scenario: Attempt to view an location with an empty status
    Given I am a registered customer
    When I try to check the status of the charging point at location "A"
    And status is empty
    Then I should receive an error message "Status unavailable"




    

