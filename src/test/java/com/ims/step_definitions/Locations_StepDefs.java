package com.ims.step_definitions;

import com.ims.pages.LocationsPage;
import com.ims.utilities.BrowserUtils;
import com.ims.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Locations_StepDefs{
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

    LocationsPage locationsPage = new LocationsPage();
    @Then("I should see locations listed as grid, with the following columns:")
    public void i_should_see_locations_listed_as_grid_with_the_following_columns(List<String> expectedList) {
        wait.until(ExpectedConditions.visibilityOf(locationsPage.selectCustomersDropdown));
        Assert.assertEquals(expectedList, locationsPage.seeLocationsAsGrid());
    }

    @Then("I should see the results paginated {int} records at a time")
    public void iShouldSeeTheResultsPaginatedRecordsAtATime(int numOfResults) {
        wait.until(ExpectedConditions.visibilityOf(locationsPage.selectCustomersDropdown));
        Assert.assertEquals(numOfResults, locationsPage.locationsResults());
    }

    @And("I click on Select Customers dropdown")
    public void iClickOnSelectCustomersDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(locationsPage.selectCustomersDropdown));
        locationsPage.selectCustomersDropdown.click();
    }

    @Then("I should be able to select a customer and filter locations")
    public void iShouldBeAbleToSelectACustomerAndFilterLocations() {
        BrowserUtils.sleep(1);
        locationsPage.selectCustomerE1();
    }


    @And("I click on one of the rows")
    public void iClickOnOneOfTheRows() {

        locationsPage.clickOnARow();
    }

    @When("I click on locations module")
    public void iClickOnLocationsModule() {
        BrowserUtils.sleep(3);
        locationsPage.locationsModule.click();
    }

    @Then("the locations editor should be opened")
    public void theLocationsEditorShouldBeOpened() {
        wait.until(ExpectedConditions.visibilityOf(locationsPage.deleteButton));
        Assert.assertTrue(locationsPage.deleteButton.isDisplayed());
    }
}
