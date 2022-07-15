Feature: User wants to upload file
  Scenario: As a user I want to attach a file to a component lot
    Given I am on the dashboard page
    When I click on inventory module
    And I click on component lots module
    And user clicks on an existing component lot
    And user clicks on attachments tab
    And user clicks the upload button
    Then the upload wizard will be visible
    When user selects a file to upload
    And user clicks on the upload button
    Then the file will be uploaded successfully