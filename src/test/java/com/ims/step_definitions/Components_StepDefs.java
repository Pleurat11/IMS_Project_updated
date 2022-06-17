package com.ims.step_definitions;

import com.ims.pages.ComponentsPage;
import com.ims.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Components_StepDefs {
    ComponentsPage componentsPage = new ComponentsPage();
    public void i_click_on_components_module() {
        BrowserUtils.sleep(4);
        componentsPage.componentsModule.click();
    }
    @Then("I should see the components listed as grid, with the following columns:")
    public void i_should_see_the_components_listed_as_grid_with_the_following_columns(List<String> expectedColumns) {
        BrowserUtils.sleep(3);
        Assert.assertEquals(componentsPage.actualColumns(), expectedColumns);
    }

    public void iClickOnCatalogsModule() {
        BrowserUtils.sleep(4);
        componentsPage.catalogModule.click();
    }

    @Then("I should be able to see the results paginated, {int} records at a time")
    public void iShouldBeAbleToSeeTheResultsPaginatedRecordsAtATime(int numOfRecords) {
        BrowserUtils.sleep(5);
        Assert.assertEquals(numOfRecords, componentsPage.numOfRecords());
    }

    @And("After I select a customer, the dropdown will show vendors associated with that customer")
    public void iSelectACustomerTheDropdownWillShowVendorsAssociatedWithThatCustomer() {
        componentsPage.vendorsListAfterClickingCustomer();
    }

    public void iClickOnSelectCustomersDropdownOnComponentsPage() {
        BrowserUtils.sleep(5);
        componentsPage.componentsDropdown.click();

        componentsPage.clickOnACustomer();
    }

    public void aVendorWasSelectedAlready() {
        componentsPage.clickOnAVendor();
    }

    @Then("vendor dropdown will be reset to empty")
    public void vendorDropdownWillBeResetToEmpty() {
        componentsPage.vendorShouldBeEmpty();

    }
}
