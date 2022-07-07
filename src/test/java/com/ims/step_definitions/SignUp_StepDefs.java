package com.ims.step_definitions;

import com.ims.pages.SignUpPage;
import com.ims.utilities.BrowserUtils;
import com.ims.utilities.ConfigurationReader;
import com.ims.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUp_StepDefs {

    SignUpPage signUpPage = new SignUpPage();
    @When("I click on the Create Account button")
    public void iClickOnTheCreateAccountButton(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        BrowserUtils.sleep(6);
        signUpPage.createAccountButton();
    }

    @Then("I should be navigated to the sign up page")
    public void iShouldBeNavigatedToTheSignUpPage() {
        signUpPage.verifySignUpPage();
    }

    @When("I enter a name on on the name field")
    public void iEnterANameOnOnTheNameField() {
        signUpPage.nameField();
    }

    @And("I enter an email on the email field")
    public void iEnterAnEmailOnTheEmailField() {
        signUpPage.emailField();
    }

    @And("I enter a password on the password field")
    public void iEnterAPasswordOnThePasswordField() {
        signUpPage.password();
    }

    @And("I click on I agree to the terms of use checkbox")
    public void iClickOnIAgreeToTheTermsOfUseCheckbox() {
        signUpPage.checkCheckbox();
    }

    @And("I click on the Submit button")
    public void iClickOnTheSubmitButton() {
        signUpPage.submitButton();
    }
}
