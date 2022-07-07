@all
Feature: User wants to browse assemblies
  @browseAssemblies
  Scenario: User wants to see assemblies listed in grid
    Given I am on the dashboard page
    When I click on inventory module
    And I click on assemblies module
    Then I should see the assemblies listed as grid with the following columns:
      |CUSTOMER |
      |PRODUCT |
      |WORK ORDER #  |
      |STATUS  |
      |LAST MODIFIED|
      |LAST MODIFIED BY|

  @assemblyEditor
  Scenario: User wants to open the assembly editor
    Given I am on the dashboard page
    When I click on inventory module
    And I click on assemblies module
    And I click on one of the rows on assemblies page
    Then the assembly editor should be opened