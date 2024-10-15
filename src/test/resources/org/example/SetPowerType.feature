Feature: Set Power Type

  Scenario: Owner changes power type
    Given the owner wants to change the power type
    And a power station is available
    When the set power type is "AC"
    Then there should be an option to set it to "DC"

  Scenario: Owner sets power type
    Given the owner wants to set the power type
    And a power station is available
    When there is no power type set
    Then there should be an option to choose the power type between AC and DC
