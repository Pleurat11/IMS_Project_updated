package com.ims.step_definitions;

import com.ims.pages.CustomersPage;
import com.ims.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CreateNewCustomer_StepDefs {
    CustomersPage customersPage = new CustomersPage();
    @And("I input valid data to the required fields")
    public void i_input_valid_data_to_the_required_fields(){
        BrowserUtils.sleep(1);
        customersPage.createNewCustomer();
    }

    @Then("A new customer will be created successfully")
    public void aNewCustomerWillBeCreatedSuccessfully() {
        customersPage.verifyCustomerCreated();
    }
}
