@
Feature: As a user I should be able to login to ims page
  @loginValidCredentials
    @smoke
    Scenario: User logs in to ims page
    Given I am on the ims login page
    When I send a valid email to the email field
    And I send a valid password to the password field
    Then I should be logged in

  @loginIncorrectCredentials
  Scenario: User wants to login with incorrect credentials
    Given I am on the ims login page
    When I send an invalid email to the email field
    And I send an invalid password to the password field
    Then I should get the following error "Email or password is incorrect."