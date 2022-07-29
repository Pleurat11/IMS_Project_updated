package com.ims.pages;

import com.ims.utilities.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CustomerReportsPage extends BasePage{

    @FindBy(id = "viewer")
    public WebElement report;

    public void customerReportDropdown(){
        WebElement selectId = JavascriptShadowRoot.jsShadowRoot("ipd-ims-report-browser-component", "select");

        Select select = new Select(selectId);
        select.selectByIndex(1);
    }

    public void createCustomerButton(){

        WebElement createReportButton = JavascriptShadowRoot.jsShadowRoot("ipd-ims-report-browser-component", "div.position-relative.h-100 > div.h-100 > div.container > div.container > div.row");
        BrowserUtils.sleep(4);
        createReportButton.click();
    }

    public void verifyReportCreated(){
        List<WebElement> form = JavascriptShadowRoot.jsShadowRootList("ipd-ims-report-browser-component", "h5");
        Assert.assertTrue(form.get(10).isDisplayed());
    }

    public void selectCustomer(){
        WebElement customer1 = JavascriptShadowRoot.jsShadowRoot("ipd-ims-report-browser-component", "tr > td > input");

        customer1.click();
    }

    public void clickEmailButton(){
        emailButton.click();
    }

    public void sendEmail(){
        WebElement emailField = JavascriptShadowRoot.jsShadowRoot("ipd-ims-report-browser-component", "div > input");

        emailField.sendKeys(ConfigurationReader.getProperty("email") + Keys.ENTER);
    }

}
