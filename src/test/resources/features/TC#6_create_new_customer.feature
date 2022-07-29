@create
Feature: User creates a new customer
  @createNewCustomer
  Scenario: As a user I want to be able to create a new Customer
    Given I am on the dashboard page
    When I click on references module
    And I click on the customers module
    And I click on the new button
    And I input valid data to the required fields
    And I click on the Save button
    Then A new customer will be created successfully

