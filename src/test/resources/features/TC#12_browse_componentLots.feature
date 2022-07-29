@all
@browseComponentLots
Feature: As a user I should be able to browse the component inventory
  @componentColumns
  Scenario: User wants to see components listed in a grid
    Given I am on the dashboard page
    When I click on inventory module
    And I click on component lots module
    Then I should see the components listed as grid with the following columns:
      |NAME\nPART #\nREVISION\nQUANTITY\nRECEIVING NUMBER\nLOT #\nDESCRIPTION|

    @componentsInventoryPaginated
  Scenario: User wants to see the components results paginated
    Given I am on the dashboard page
    When I click on inventory module
    And I click on component lots module
    Then I should be able to see component lots results paginated 1 or more records at a time

      @checkboxInventory
    Scenario: User wants to filter for lots "acd" by checking a box
      Given I am on the dashboard page
      When I click on inventory module
      And I click on component lots module
      And I click the Awaiting customer disposition checkbox
      Then The lots should be filtered

    @componentLotEditor
    Scenario: User wants to open the component lots editor
      Given I am on the dashboard page
      When I click on inventory module
      And I click on component lots module
      And I click on an existing component lot
      Then the component lot editor will be opened