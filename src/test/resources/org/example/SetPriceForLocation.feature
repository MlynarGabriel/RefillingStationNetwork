Feature: Set Power Type

  Scenario: Owner changes power type
    Given the owner wants to change the power type
    And a power station is available
    When there is already a power type set
    Then there should be an option to choose the contrary power type
