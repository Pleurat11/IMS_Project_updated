@create
Feature: User creates a new component
  @createComponent
  Scenario: As a user I want to be able to create a new component
    Given I am on the dashboard page
    When I click on catalogs module
    And I click on components module
    And I click on the new button
    And I enter valid data on all of the fields
    And I click on the Save button
    Then A new component should be created successfully
