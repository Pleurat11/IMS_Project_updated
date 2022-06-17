package com.ims.step_definitions;

import com.ims.pages.ComponentsPage;
import com.ims.pages.LocationsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CreateComponent_StepDefs {
    ComponentsPage componentsPage = new ComponentsPage();
    LocationsPage locations = new LocationsPage();
    @And("I enter valid data on all of the fields")
    public void i_enter_valid_data_on_all_the_fields(){
        componentsPage.createNewComponent();
    }

    @Then("A new component should be created successfully")
    public void aNewComponentShouldBeCreatedSuccessfully() {
        Assert.assertTrue(locations.toastMessageSuccess.isDisplayed());
    }
}
