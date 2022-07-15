package com.ims.step_definitions;

import com.google.common.base.Verify;
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

    @And("I click on Select Customers dropdown")
    public void iClickOnSelectCustomersDropdown() {
        BrowserUtils.sleep(2);
        locationsPage.selectCustomersDropdown.click();
    }

    @Then("I should be able to select a customer and filter locations")
    public void iShouldBeAbleToSelectACustomerAndFilterLocations() {
        BrowserUtils.sleep(2);
        locationsPage.selectCustomer();
    }


    @And("I click on one of the rows")
    public void iClickOnOneOfTheRows() {

        locationsPage.clickOnARow();
    }

    @When("I click on locations module")
    public void iClickOnLocationsModule() {
        wait.until(ExpectedConditions.visibilityOf(locationsPage.locationsModule));
        locationsPage.locationsModule.click();
    }

    @Then("the locations editor should be opened")
    public void theLocationsEditorShouldBeOpened() {
        wait.until(ExpectedConditions.visibilityOf(locationsPage.deleteButton));
        Assert.assertTrue(locationsPage.deleteButton.isDisplayed());
    }

    @Then("I should see the results paginated {int} or more records at a time")
    public void iShouldSeeTheResultsPaginatedOrMoreRecordsAtATime(int numOfResults) {
        wait.until(ExpectedConditions.visibilityOf(locationsPage.selectCustomersDropdown));
        Assert.assertTrue(locationsPage.locationsResults() > numOfResults);


    }

    @When("I click on references module")
    public void iClickOnReferencesModule() {
        if (!locationsPage.locationsModule.isDisplayed()){
            locationsPage.referencesModule.click();
        }

    }
}
