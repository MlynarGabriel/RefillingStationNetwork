Feature: Add new refilling station to a location

  Scenario: Add a new refilling station to a location
    Given I am the owner
    When I add a new refilling station at location "A"
    Then the refilling station should be created at location "A"


