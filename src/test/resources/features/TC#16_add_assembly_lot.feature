Feature: User adds new assembly lot
  @assemblyLot
  Scenario: As a user I want to be able to create a new assembly lot
    Given I am on the dashboard page
    When I click on inventory module
    And I click on assemblies module
    And I click on an existing assembly
    And I click on the Assembly Lots tab
    And I click the Add Lot button at the top
    Then I will be redirected to assembly lot editor
    When I enter a Lot number in the # field
    And I enter a number as lot size
    And I select "Warehouse" from the location dropdown
    And I click on the Save button
    Then a new assembly lot will be created successfully
