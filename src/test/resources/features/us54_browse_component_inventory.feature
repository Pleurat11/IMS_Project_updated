@browseComponentInventory
Feature: As a user I should be able to browse the component inventory
  @componentColumns
  Scenario: User wants to see components listed in a grid
    Given I am on the dashboard page
    When I click on inventory module
    And I click on component lots module
    Then I should see the components listed as grid with the following columns:
      |CUSTOMER|
      |VENDOR  |
      |PART #  |
      |DESCRIPTION|
      |QUANTITY   |
      |LAST MODIFIED|
      |LAST MODIFIED BY|

    @componentsInventoryPaginated
  Scenario: User wants to see the components results paginated
    Given I am on the dashboard page
    When I click on inventory module
    And I click on component lots module
    Then I should be able to see the results paginated 50, records at a time

      @checkboxInventory
    Scenario: User wants to filter for lots "acd" by checking a box
      Given I am on the dashboard page
      When I click on inventory module
      And I click on component lots module
      And I click the Awaiting customer disposition checkbox
      Then The lots should be filtered