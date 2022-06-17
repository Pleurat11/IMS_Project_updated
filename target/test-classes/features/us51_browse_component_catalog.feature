@browseComponentCatalog
Feature: As a user I should be able to browse component catalog
  @componentsColumns
  Scenario: User wants to see components listed in a grid
    Given I am on the dashboard page
    When I click on catalogs module
    And I click on components module
    Then I should see the components listed as grid, with the following columns:
    |COMPONENT|
    |CUSTOMER|
    |VENDOR|
    |PART #|
    |LAST MODIFIED|
    |LAST MODIFIED BY|

    @componentsPaginated
    Scenario: User wants to see the components results paginated
      Given I am on the dashboard page
      When I click on catalogs module
      And I click on components module
      Then I should be able to see the results paginated, 50 records at a time

      @customerDropdown
      Scenario: User wants to filter the components by selecting a customer from the dropdown
        Given I am on the dashboard page
        When I click on catalogs module
        And I click on components module
        When I click on Select Customers dropdown on components page
        Then After I select a customer, the dropdown will show vendors associated with that customer

        @vendorDropdownEmpty
        Scenario: User wants vendor list to be empty after selecting a vendor
          Given I am on the dashboard page
          When I click on catalogs module
          And I click on components module
          When A vendor was selected already
          Then vendor dropdown will be reset to empty
      #vendor dropdown is not empty!!
