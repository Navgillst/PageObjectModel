Feature: registration
  Scenario:As a user when I enter registration details I should be able to register
    Given I am on registration page
    When I enter registration details
    And I click on register button
    Then I should able to register successfully
    And register message should appear