@all
@browseProductCatalog
Feature: As a user I should be able to browse product catalog
  @productColumns
  Scenario: User wants to see products listed in a grid
    Given I am on the dashboard page
    When I click on catalogs module
    And I click on product module
    Then I should see the products listed as grid with the following columns:
      |PRODUCT|
      |PART NUMBER|
      |REVISION|
      |DESCRIPTION|

    @productsPaginated
  Scenario: User wants to see the products results paginated
    Given I am on the dashboard page
    When I click on catalogs module
    And I click on product module
    Then I should be able to see products results paginated 1 or more records at a time

    @filterProducts
   Scenario: User wants to filter products by selecting a customer
     Given I am on the dashboard page
     When I click on catalogs module
     And I click on product module
     And I select a customer from the dropdown
     Then The components should be filtered

   @productEditor
   Scenario: User clicks on a row, the editor will display the existing data
     Given I am on the dashboard page
     When I click on catalogs module
     And I click on product module
     And I click on a given row
     Then I should be able tp see the existing product data