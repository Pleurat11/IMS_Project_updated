@smokeTest
Feature: User wants to see the basic functions of the application working
  @referencesTest
  Scenario: As a user I want to see references working properly
    Given User is on the ims page
    Then User wants to see locations working
    And User wants to see vendors working
    And User wants to see customers working

    @catalogTest
  Scenario: As a user I want to see Catalog working properly
    Given User is on the ims page
    Then User wants to see components working as expected
    And User wants to see products working as expected