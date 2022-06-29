package com.ims.pages;

import com.github.javafaker.Faker;
import com.ims.utilities.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage{
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
    Faker faker = new Faker();

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//login-component")
    public static WebElement rootHost;

    @FindBy(xpath = "//ul[@class='navbar-nav px-3']")
    public WebElement signOutButton;

    public void loginEmail(){

        SearchContextShadowRoot.shadowRoot(rootHost);

        WebElement email = SearchContextShadowRoot.shadowRoot.findElement(By.id("f_email_0"));

        wait.until(ExpectedConditions.elementToBeClickable(email));
        email.sendKeys(ConfigurationReader.getProperty("email"));
    }
    public void loginPassword(){
        WebElement password = SearchContextShadowRoot.shadowRoot.findElement(By.id("f_password_0"));
        password.sendKeys(ConfigurationReader.getProperty("password") + Keys.ENTER);
    }

    public void verifyLoggedIn(){
        wait.until(ExpectedConditions.visibilityOf(signOutButton));
        Assert.assertTrue(signOutButton.isDisplayed());
    }

    public void loginIncorrectEmail(){
        SearchContextShadowRoot.shadowRoot(rootHost);

        WebElement email = SearchContextShadowRoot.shadowRoot.findElement(By.id("f_email_0"));

        wait.until(ExpectedConditions.elementToBeClickable(email));
        email.sendKeys(faker.internet().emailAddress());
    }

    public void loginIncorrectPassword(){
        WebElement password = SearchContextShadowRoot.shadowRoot.findElement(By.id("f_password_0"));
        password.sendKeys(faker.internet().password() + Keys.ENTER);
    }

    public String actualError(){
        WebElement loginError = JavascriptShadowRoot.jsShadowRoot("login-component", "div > div > div");
        wait.until(ExpectedConditions.visibilityOf(loginError));

        return loginError.getText();
    }
}
