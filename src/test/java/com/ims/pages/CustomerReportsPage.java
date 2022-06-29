package com.ims.pages;

import com.ims.utilities.Driver;
import com.ims.utilities.JavascriptShadowRoot;
import com.ims.utilities.SearchContextShadowRoot;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

        List<WebElement> createReportButton = JavascriptShadowRoot.jsShadowRootList("ipd-ims-report-browser-component", "button");
        createReportButton.get(50).click();
    }

    public void verifyReportCreated(){
        List<WebElement> form = JavascriptShadowRoot.jsShadowRootList("ipd-ims-report-browser-component", "h5");
        Assert.assertTrue(form.get(10).isDisplayed());
    }
}
