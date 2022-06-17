package com.ims.step_definitions;

import com.ims.pages.VendorsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateVendor_StepDefs {
    VendorsPage vendorsPage = new VendorsPage();
    public void i_send_valid_data_to_the_required_fields() {
        vendorsPage.createNewVendor();
    }
    @Then("A new vendor should be created successfully")
    public void a_new_vendor_should_be_created_successfully() {

    }
}
