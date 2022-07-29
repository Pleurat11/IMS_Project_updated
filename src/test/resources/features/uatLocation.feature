Feature: As a user I should be able to fill UAT with data
  @locationsAdd
  Scenario Outline: I want to send data to locations
    Given I am on the dashboard page
    When I click on references module
    And I click on locations module
    And I click on the new button
    And I send "<Location name>" to the field
    And I click on the Save button
    Then A new location should be created successfully
    Examples:
    |Location name               |
    |Receiving                   |
    |Pending Receiving Inspection|
    |Pending QA Release          |
    |Warehouse                   |
    |Quarantine                  |
    |Inventory WH                |
    |Sterilizer                  |
    |Hazardous Material Cabinet  |