
Feature: User creates a new report
  @report
  Scenario: As a user I want to create a new customer report
    Given I am on the dashboard page
    When user clicks on reports module
    And user clicks on customer inventory tab
    And user clicks on the new button
    And user selects a customer from the dropdown
    And user clicks on Create Customer button
    Then a new Customer Report Entry will be created