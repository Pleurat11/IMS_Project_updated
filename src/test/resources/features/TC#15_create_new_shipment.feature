@create
Feature: User creates a new shipment
  @newShipment
  Scenario: As a user I want to create a new shipment
    Given I am on the dashboard page
    When I click on delivery module
    And I click on shipments module
    And I click on the new button
    And I fill the fields with valid data
    And I click on the Save button
    Then a new shipment should be created