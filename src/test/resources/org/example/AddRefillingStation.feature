Feature: Add new refilling station to a location

  Scenario: Add a new refilling station to a location
    Given I am the owner
    When I add a new refilling station at location "A"
    Then the refilling station should be created at location "A"

  #Error Case: Name is too short
  Scenario: Entered name is too short
    Given I am the owner
    When I try to enter the station name "X"
    Then I should see an error message "the name has to be at least 3 characters long"

  #Edge Case
  Scenario: Assure that a station has a location
    Given I am the owner
    And this is the refilling station:
    | name        | location |
    | LocationA   | A        |
    When the owner tries to delete the name "LocationA"
    Then an error message should be display "location can't be deleted"

    


