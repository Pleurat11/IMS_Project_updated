@create
Feature: User sends customer report as email
  @sendEmail
  Scenario: As a user I want to send customer report via email
    Given I am on the dashboard page
    When user clicks on reports module
    And user clicks on customer inventory tab
    And I select a customer from the list
    And I click on the Email button at the top
    And I input a valid email to the email field
    Then the email should be sent successfully