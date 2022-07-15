Feature: As a user I want to create multiple components at once
  @componentAddsss
  Scenario Outline: User creates multiple components
    Given I am on the dashboard page
    When I click on catalogs module
    And I click on components module
    And I click on the new button
    And I send "<Component name>" to component field
    And I select the first customer from the dropdown
    And I send "<Component name>" to part number field
    And I send "<Revision number>" to revision nr field
#    And I click on the Save button
    Then A new component should be created successfully
    Examples:
    |Component name|Revision number|
    |PRT-4         |RN-4           |
    |PRT-5         |RN-5           |
    |PRT-6         |RN-6           |
    |PRT-7         |RN-7           |
    |PRT-8         |RN-8           |
    |PRT-9         |RN-9           |
    |PRT-10        |RN-10          |

