package com.ims.pages;

import com.github.javafaker.Faker;
import com.ims.utilities.BrowserUtils;
import com.ims.utilities.Driver;
import com.ims.utilities.JavascriptShadowRoot;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SignUpPage {
    public SignUpPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    List<WebElement> inputFields = JavascriptShadowRoot.jsShadowRootList("sign-component", "input");
    Faker faker = new Faker();

    public void createAccountButton(){
        wait.until(ExpectedConditions.titleIs("Portal"));
        BrowserUtils.sleep(5);
        List<WebElement> createAcc = JavascriptShadowRoot.jsShadowRootList("login-component", "span");
        createAcc.get(1).click();
    }
    public void verifySignUpPage(){
        BrowserUtils.sleep(3);
        WebElement signUpText = JavascriptShadowRoot.jsShadowRoot("signup-component", "h2");
        Assert.assertTrue(signUpText.isDisplayed());
    }
    public void nameField(){
        BrowserUtils.sleep(1);
        inputFields.get(0).sendKeys(faker.name().firstName());
    }
    public void emailField(){
        BrowserUtils.sleep(1);
        inputFields.get(1).sendKeys(faker.internet().emailAddress());
    }
    public void password(){

            inputFields.get(2).sendKeys("password123");
            BrowserUtils.sleep(1);
            inputFields.get(3).sendKeys("password123");
    }
    public void checkCheckbox(){
        BrowserUtils.sleep(2);
        inputFields.get(4).click();
    }

    public void submitButton(){
        BrowserUtils.sleep(1);
        List<WebElement> buttons = JavascriptShadowRoot.jsShadowRootList("login-component", "button");
        buttons.get(1).click();
    }

}
