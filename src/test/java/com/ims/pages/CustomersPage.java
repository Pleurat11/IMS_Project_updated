package com.ims.pages;

import com.ims.utilities.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CustomersPage extends BasePage {

    @FindBy(xpath = "//ipd-ims-customer-editor-component")
    public WebElement rootHost;

    @FindBy(xpath = "//button[.='New']")
    public WebElement newBttn;

    @FindBy(xpath = "//div[@class='toast-header text-white bg-success']")
    public WebElement customerCreatedToastMsg;

    public List<String> actualColumns(){
        List<String> myList = new ArrayList<>();
        List<WebElement> elements = JavascriptShadowRoot.jsShadowRootList("ipd-ims-customer-browser-component", "thead > tr > th");

        for (int i = 0; i < elements.size()-1; i++) {
            myList.add(elements.get(i).getText());
        }
        return myList;
    }

    public int seeResults(){
        BrowserUtils.sleep(5);
        List<WebElement> seeAllResults = JavascriptShadowRoot.jsShadowRootList("ipd-ims-customer-browser-component", "tbody > tr");

        return seeAllResults.size();

    }

    public void seeExistingData(){
        BrowserUtils.sleep(5);
        List<WebElement> seeAllResults = JavascriptShadowRoot.jsShadowRootList("ipd-ims-customer-browser-component", "tbody > tr");

        BrowserUtils.sleep(3);
        seeAllResults.get(1).click();
    }

    public void verifyCustomerDataVisible(){
        SearchContextShadowRoot.shadowRoot(rootHost);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(SearchContextShadowRoot.shadowRoot.findElement(By.id("f_name_0"))));

        Assert.assertTrue(SearchContextShadowRoot.shadowRoot.findElement(By.id("f_name_0")).isDisplayed());

        Assert.assertTrue(SearchContextShadowRoot.shadowRoot.findElement(By.id("f_code_1")).isDisplayed());

        System.out.println(SearchContextShadowRoot.shadowRoot.findElement(By.id("f_code_1")).getText());

    }

    public void createNewCustomer(){

        List<WebElement> inputFields = JavascriptShadowRoot.jsShadowRootList("ipd-ims-customer-editor-component", "input");

        WebElement customerField = JavascriptShadowRoot.jsShadowRoot("ipd-ims-customer-editor-component", "input");


        customerField.sendKeys("Automated customer");
        inputFields.get(1).clear();
        inputFields.get(1).sendKeys("85");


    }

    public void verifyCustomerCreated(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(customerCreatedToastMsg));

        Assert.assertTrue(customerCreatedToastMsg.isDisplayed());
    }

    @Test
    public void createCustomer(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        LoginPage loginPage = new LoginPage();
        loginPage.loginEmail();
        loginPage.loginPassword();

        BrowserUtils.sleep(8);

        customersModule.click();

        BrowserUtils.sleep(4);

        for (int i = 13; i <57; i++) {
            LocationsPage locationsPage = new LocationsPage();

            locationsPage.newLocation.click();

            List<WebElement> inputFields = JavascriptShadowRoot.jsShadowRootList("ipd-ims-customer-editor-component", "input");

            WebElement customerField = JavascriptShadowRoot.jsShadowRoot("ipd-ims-customer-editor-component", "input");


            customerField.sendKeys("Customer Test P" + i);
            inputFields.get(1).clear();
            inputFields.get(1).sendKeys(i +"");

            locationsPage.saveButton.click();

            BrowserUtils.sleep(5);
        }
    }
}
