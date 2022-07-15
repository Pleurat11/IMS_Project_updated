Feature: User creates a new location
  @createNewLocation
  Scenario: As a user I want to be able to create a new location
    Given I am on the dashboard page
    When I click on references module
    And I click on locations module
    And I click on the new button
    And I enter valid data to the required fields
    And I click on the Save button
    Then A new location should be created successfully
