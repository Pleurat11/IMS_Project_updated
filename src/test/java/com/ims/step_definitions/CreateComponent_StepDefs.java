package com.ims.step_definitions;

import com.ims.pages.ComponentsPage;
import com.ims.pages.LocationsPage;
import com.ims.smoke_test.Catalog;
import com.ims.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CreateComponent_StepDefs {
    ComponentsPage componentsPage = new ComponentsPage();
    LocationsPage locations = new LocationsPage();

    Catalog catalog = new Catalog();
    @And("I enter valid data on all of the fields")
    public void i_enter_valid_data_on_all_the_fields(){
        BrowserUtils.sleep(3);
        componentsPage.createNewComponent();
    }

    @Then("A new component should be created successfully")
    public void aNewComponentShouldBeCreatedSuccessfully() {
        BrowserUtils.sleep(5);
        Assert.assertTrue(locations.toastMessageSuccess.isDisplayed());
    }

    @When("I click on catalogs module")
    public void iClickOnCatalogsModule() {
        if (!catalog.productsModule.isDisplayed()) {
            catalog.catalogModule.click();
        }
    }

    @And("I click on components module")
    public void iClickOnComponentsModule() {
        catalog.componentsModule.click();
    }
}
