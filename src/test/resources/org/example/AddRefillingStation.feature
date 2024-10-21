Feature: Add new refilling station to a location

  Scenario: Add a new refilling station to a location
    Given I am the owner
    When I add a new refilling station at location "A"
    Then the refilling station should be created at location "A"

  Scenario: Attempt to add a refilling station with no name
    Given I am the owner
    When I try to add a new refilling station without adding the name of a location
    Then i should see an error message "location name required"


