@browseVirtualVendors
Feature: As a user I want to be able to browse vendors
  @browseVendors
  Scenario: User wants to see vendors listed in a grid
    Given I am on the dashboard page
    When I click on vendors module
    Then I should see vendors listed as grid, with the following columns:
    |VENDOR|
    |CUSTOMER|
    |LAST MODIFIED|
    |LAST MODIFIED BY|

    @vendorsResults
    Scenario: User wants to see the results paginated
      Given I am on the dashboard page
      When I click on vendors module
      Then I should see the results paginated ,50 records at a time
      #expected results = 50, actual results = 3 !!

    @vendorsSelect
    Scenario: User wants to filter the vendors by selecting a customer
      Given I am on the dashboard page
      When I click on vendors module
      And I click on Select Customers dropdown
      Then I should be able to select a customer and filter locations

  Scenario: When clicking on a row, user wants to see the existing data
    Given I am on the dashboard page
    When I click on vendors module
    And I click on one of the rows
