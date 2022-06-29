Feature: User creates a new product
  @createProduct
  Scenario: As a user I want to be able to create a new product
    Given I am on the dashboard page
    When I click on catalogs module
    And I click on products module
    And I click on the new button
    Then I should be redirected to product editor page
    When I enter valid data on the required fields
    And I click on the Save button


