Feature: User sign up
  @signUp
  Scenario: As a user I want to be able to sign up
    Given I am on the ims login page
    When I click on the Create Account button
    Then I should be navigated to the sign up page
    When I enter a name on on the name field
    And I enter an email on the email field
    And I enter a password on the password field
    And I click on I agree to the terms of use checkbox
    And I click on the Submit button
