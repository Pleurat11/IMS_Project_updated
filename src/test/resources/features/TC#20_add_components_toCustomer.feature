Feature: User adds components to a customer

  Scenario: As a user I want to add components to a customer
    Given I am on the dashboard page
    When I click on the customers module
    And I click on one of the rows on customers page
    And I click on the add component button
    And I select a part number from the part number dropdown
    And I select a revision number from the revision number dropdown
    And I click the add component button to add the component
    Then the component should be added successfully
