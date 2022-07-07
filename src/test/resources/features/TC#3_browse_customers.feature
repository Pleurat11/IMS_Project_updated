@all
@browseVirtualCustomers
Feature: As a user I should be able to browse customers

  @customerColumns
  Scenario: User wants to see customers listed as grid
    Given I am on the dashboard page
    When I click on the customers module
    Then I should see the customers listed as a grid with the following columns:
    |#|
    |CUSTOMER|
    |LAST MODIFIED|
    |LAST MODIFIED BY|

    @customerResults
    Scenario: User wants to see the results paginated, 50 records at a time
      Given I am on the dashboard page
      When I click on the customers module
      Then I should see the results paginated, 50 records at a time

    @editorBlank
    Scenario: When user clicks on new button, editor should be blank
      Given I am on the dashboard page
      When I click on the customers module
      And I click on the new button
      Then the results should be blank

      @customerEditor
      Scenario: User wants to open the customers editor
        Given I am on the dashboard page
        When I click on the customers module
        And I click on one of the rows on customers page
        Then the customers editor should be opened