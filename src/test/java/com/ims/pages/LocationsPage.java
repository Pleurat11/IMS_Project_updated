package com.ims.pages;

import com.ims.utilities.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LocationsPage extends BasePage {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

    @FindBy(xpath = "//div[@class='toast-header text-white bg-success']")
    public WebElement toastMessageSuccess;
    @FindBy(xpath = "//button[.='Select Customer']")
    public WebElement selectCustomersDropdown;

    @FindBy(xpath = "//a[.='Vertos']")
    public WebElement selectCustomer;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public List<WebElement> dropdownList;

    @FindBy(xpath = "ipd-ims-location-editor-component")
    public WebElement shadowRoot;

    @FindBy(xpath = "//button[.='Delete']")
    public WebElement deleteButton;

    public List<String> seeLocationsAsGrid() {

        List<WebElement> locationsList = JavascriptShadowRoot.jsShadowRootList("ipd-ims-location-browser-component", "thead > tr");
        List<String> newList = new ArrayList<>();

        for (int i = 0; i < locationsList.size(); i++) {
            newList.add(locationsList.get(i).getText());
        }


        return newList;
    }

    public void readLocationTable(){
        List<WebElement> locationsList = JavascriptShadowRoot.jsShadowRootList("ipd-ims-component-browser-component", "tbody > tr");
        List<String> newList = new ArrayList<>();

        for (int i = 0; i < locationsList.size(); i++) {
            newList.add(locationsList.get(i).getText());
        }


        System.out.println(newList);
    }

    public int locationsResults() {
        BrowserUtils.sleep(4);
        List<WebElement> myList = JavascriptShadowRoot.jsShadowRootList("ipd-ims-location-browser-component", "tbody > tr");
        for (int i = 0; i < myList.size(); i++) {

        }
        return myList.size();
    }


    public void selectCustomerE1() {
        selectCustomer.click();
    }

    public void clickOnARow() {
        BrowserUtils.sleep(6);
        List<WebElement> locationsList = JavascriptShadowRoot.jsShadowRootList("ipd-ims-location-browser-component", "table > tbody > tr");
        try {
            locationsList.get(1).click();
        }
        catch (StaleElementReferenceException e){
            e.printStackTrace();
        }
    }

    public void createNewLocation() {
//        for (int i = 0; i <30; i++) {

            locationsModule.click();
            newButton.click();
            BrowserUtils.sleep(2);
            WebElement locationField = JavascriptShadowRoot.jsShadowRoot("ipd-ims-location-editor-component", "input");
            locationField.sendKeys("Location Test - P");
            BrowserUtils.sleep(2);
            WebElement descriptionField = JavascriptShadowRoot.jsShadowRoot("ipd-ims-location-editor-component", "textarea");

            descriptionField.sendKeys("This is automated locations description");

            BrowserUtils.sleep(2);
            WebElement selectCustomer = JavascriptShadowRoot.jsShadowRoot("ipd-ims-location-editor-component", "select");

            Select select = new Select(selectCustomer);

//        }
    }
//    @Test
//    public void test(){
//        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
//        LoginPage loginPage = new LoginPage();
//        loginPage.loginEmail();
//        loginPage.loginPassword();
//
//        BrowserUtils.sleep(6);
//
//        for (int i = 17; i <=30; i++) {
//
//            locationsModule.click();
//            newLocation.click();
//            BrowserUtils.sleep(2);
//            WebElement locationField = JavascriptShadowRoot.jsShadowRoot("ipd-ims-location-editor-component", "input");
//            locationField.sendKeys("Location Test - P" + i);
//            BrowserUtils.sleep(2);
//            WebElement descriptionField = JavascriptShadowRoot.jsShadowRoot("ipd-ims-location-editor-component", "textarea");
//
//            descriptionField.sendKeys("This is automated locations description " + i);
//
//            BrowserUtils.sleep(2);
//            WebElement selectCustomer = JavascriptShadowRoot.jsShadowRoot("ipd-ims-location-editor-component", "select");
//
//            Select select = new Select(selectCustomer);
//            select.selectByIndex(1);
//
//            saveButton.click();
//
//            BrowserUtils.sleep(5);
//        }
//    }
}

