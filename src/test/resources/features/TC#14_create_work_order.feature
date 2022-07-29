@create
Feature: User creates a new Work Order
  @newWorkOrder
  Scenario: As a user I want to create a new work order
    Given I am on the dashboard page
    When I click on inventory module
    And I click on Work Orders module
    And I click the new button
    And I send valid data on all the fields
    And I click on the Save button
    Then a new work order will be created