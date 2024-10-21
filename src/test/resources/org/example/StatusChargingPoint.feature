Feature: Charging Point Availability

  Scenario: Check charging point availability
    Given I view the status of charging points at location "A"
    Then I should see the availability of each charging point