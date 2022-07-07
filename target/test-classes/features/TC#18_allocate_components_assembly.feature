
Feature: User wants to allocate components to an assembly
  @allocation
  Scenario: As a user I want to be able to allocate components
    Given I am on the dashboard page
    When I click on inventory module
    And I click on assemblies module
    And I click on an existing assembly
    And I click on components tab on the top
    Then I should see required components data table
    When I click on the plus sign on the far right
    Then Select Component Lot Entry wizard will be visible
    When I select an available component lot to allocate
    And I input the allocation size
    And I click on the Save Allocation button
    Then the component lot will be allocated successfully
