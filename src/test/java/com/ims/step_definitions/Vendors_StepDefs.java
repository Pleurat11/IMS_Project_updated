package com.ims.step_definitions;

import com.ims.pages.BasePage;
import com.ims.pages.VendorsPage;
import com.ims.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class Vendors_StepDefs extends BasePage {
    VendorsPage vendorsPage = new VendorsPage();

    public void i_click_on_vendors_module() {
        BrowserUtils.sleep(3);
        vendorsPage.vendorsModule.click();
    }
    @Then("I should see vendors listed as grid, with the following columns:")
    public void i_should_see_vendors_listed_as_grid_with_the_following_columns(List<String> expectedColumns) {
        BrowserUtils.sleep(5);
        Assert.assertEquals(expectedColumns, vendorsPage.seeVendorsAsGrid());
    }

    @Then("I should see the results paginated ,{int} records at a time")
    public void i_should_see_the_results_paginated_records_at_a_time(int numOfVendors) {
        BrowserUtils.sleep(4);
        Assert.assertEquals(numOfVendors, vendorsPage.vendorsResult());
    }

    @When("I click on vendors module")
    public void iClickOnVendorsModule() {
        vendorsModule.click();
    }
}
