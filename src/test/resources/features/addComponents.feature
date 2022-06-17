Feature: I want to add components in bulk
  Scenario: As a user I want to fill UAT with valid data
    Given I am on the dashboard page
    When I click on catalog module
    And I click on components tab
    And I click on the new button
    Then I want to add data with the following:
    |ASM-00119|
    |ASM-00120|
    |ASM-00121|
    |ASM-00122|
    |ASM-00123|
    |ASM-00124|
    |ASM-00130|
    |ASM-00131|
    |ASM-00132|
    |ASM-00133|
    |ASM-00134|
