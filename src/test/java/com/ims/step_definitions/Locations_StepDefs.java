package com.ims.step_definitions;

import com.ims.pages.LocationsPage;
import com.ims.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class Locations_StepDefs{
    LocationsPage locationsPage = new LocationsPage();
    @Then("I should see locations listed as grid, with the following columns:")
    public void i_should_see_locations_listed_as_grid_with_the_following_columns(List<String> expectedList) {
        BrowserUtils.sleep(3);
        Assert.assertEquals(expectedList, locationsPage.seeLocationsAsGrid());
    }

    @Then("I should see the results paginated {int} records at a time")
    public void iShouldSeeTheResultsPaginatedRecordsAtATime(int numOfResults) {
        BrowserUtils.sleep(2);
        Assert.assertEquals(numOfResults, locationsPage.locationsResults());
    }

    @And("I click on Select Customers dropdown")
    public void iClickOnSelectCustomersDropdown() {
        BrowserUtils.sleep(3);
        locationsPage.selectCustomersDropdown.click();
    }

    @Then("I should be able to select a customer and filter locations")
    public void iShouldBeAbleToSelectACustomerAndFilterLocations() {
        BrowserUtils.sleep(3);
        locationsPage.selectCustomerE1();
    }


    @And("I click on one of the rows")
    public void iClickOnOneOfTheRows() {
        BrowserUtils.sleep(3);
        locationsPage.clickOnARow();
    }

    @Then("I should be able to see the existing locations data")
    public void iShouldBeAbleToSeeTheExistingLocationsData() {
        BrowserUtils.sleep(8);
        locationsPage.existingLocationData();
    }

    @When("I click on locations module")
    public void iClickOnLocationsModule() {
        BrowserUtils.sleep(3);
        locationsPage.locationsModule.click();
    }
}
