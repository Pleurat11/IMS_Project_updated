package com.ims.step_definitions;

import com.ims.pages.LoginPage;
import com.ims.utilities.BrowserUtils;
import com.ims.utilities.ConfigurationReader;
import com.ims.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.dom.model.ShadowRootPopped;
import org.openqa.selenium.devtools.v85.dom.model.ShadowRootType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login_StepDefs {
    LoginPage loginPage = new LoginPage();
    @Given("I am on the ims login page")
    public void i_am_on_the_ims_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("I send a valid email to the email field")
    public void i_send_a_valid_email_to_the_email_field() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.titleIs("Portal"));
        loginPage.loginEmail();
    }
    @And("I send a valid password to the password field")
    public void i_send_on_password_field(){
        loginPage.loginPassword();
    }
    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        loginPage.verifyLoggedIn();
    }

    @When("I send an invalid email to the email field")
    public void iSendAnInvalidEmailToTheEmailField() {
        loginPage.loginIncorrectEmail();
    }

    @And("I send an invalid password to the password field")
    public void iSendAnInvalidPasswordToThePasswordField() {
        loginPage.loginIncorrectPassword();

    }


    @Then("I should get the following error {string}")
    public void iShouldGetTheFollowingError(String expectedError) {
        BrowserUtils.sleep(5);
        Assert.assertEquals(expectedError, loginPage.actualError());
    }
}
