package com.ims.step_definitions;

import com.ims.pages.LocationsPage;
import com.ims.pages.LoginPage;
import com.ims.utilities.BrowserUtils;
import com.ims.utilities.ConfigurationReader;
import com.ims.utilities.Driver;
import com.ims.utilities.JavascriptShadowRoot;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateNewLocation_StepDefs {
    LocationsPage locations = new LocationsPage();

    @And("I enter valid data to the required fields")
    public void iEnterValidDataToTheRequiredFields() {
        locations.createNewLocation();
    }
    @And("I click on the Save button")
    public void click_on_the_save_button(){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        if (!locations.saveButton.isEnabled()){
            Driver.getDriver().navigate().refresh();
        }
        wait.until(ExpectedConditions.elementToBeClickable(locations.saveButton));
        locations.saveButton.click();
    }

    @Then("A new location should be created successfully")
    public void aNewLocationShouldBeCreatedSuccessfully() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(locations.toastMessageSuccess));

        Assert.assertTrue(locations.toastMessageSuccess.isDisplayed());
    }

    @And("I send {string} to the field")
    public void iSendToTheField(String locationNames) {
        BrowserUtils.sleep(4);
        WebElement locationField = JavascriptShadowRoot.jsShadowRoot("ipd-ims-location-editor-component", "input");
        locationField.sendKeys(locationNames);
        BrowserUtils.sleep(5);
    }
}
