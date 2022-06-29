@browseVirtualLocations
Feature: As a user I should be able to browse virtual locations
  @browseLocations
  Scenario: User wants to see locations listed as grid
    Given I am on the dashboard page
    When I click on locations module
    Then I should see locations listed as grid, with the following columns:
    |LOCATION CUSTOMER REFRIGERATED USED FOR LAST MODIFIED LAST MODIFIED BY|

    @locationsResults
    Scenario: User wants to see the results paginated
      Given I am on the dashboard page
      When I click on locations module
      Then I should see the results paginated 50 records at a time

  @filterLocations
  Scenario: User wants to filter locations
    Given I am on the dashboard page
    When I click on locations module
    And I click on Select Customers dropdown
    Then I should be able to select a customer and filter locations

