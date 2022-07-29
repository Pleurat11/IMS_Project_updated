@create
Feature: User creates a new vendor
  @createNewVendor
  Scenario: As a user I want to be able to create a new vendor
    Given I am on the dashboard page
    When I click on references module
    And I click on vendors module
    And I click on the new button
    And I send valid data to the required fields
    And I click on the Save button
    Then A new vendor should be created successfully
