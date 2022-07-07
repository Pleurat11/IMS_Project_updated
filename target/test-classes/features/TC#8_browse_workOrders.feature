@all
Feature: User wants to browse work orders
  @browseWorkOrders
  Scenario: User wants to see work orders listed in grid
    Given I am on the dashboard page
    When I click on inventory module
    And I click on Work Orders module
    Then I should see the work orders listed as grid with the following columns:
      |WORK ORDER #  |
      |CUSTOMER |
      |PURCHASE ORDER #  |
      |STATUS  |
      |LAST MODIFIED|
      |LAST MODIFIED BY|

    @workOrdersEditor
  Scenario: User wants to open the work orders editor
    Given I am on the dashboard page
    When I click on inventory module
    And I click on Work Orders module
    And I click on one of the rows on work orders page
    Then the work order editor should be opened