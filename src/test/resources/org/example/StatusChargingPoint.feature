Feature: See current status of charging station

  Scenario: Check if a charging point is available
    Given I am a registered customer or the owner
    When I view the status of charging point at a location
    Then I should see whether each station is "in operation free", "occupied", or "out of order"