package com.ims.step_definitions;

import com.ims.pages.CustomersPage;
import com.ims.pages.LoginPage;
import com.ims.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class Customers_StepDefs {
    LoginPage loginPage  = new LoginPage();
    CustomersPage customersPage = new CustomersPage();
    @Given("I am on the dashboard page")
    public void i_am_on_the_dashboard_page() {
        loginPage.verifyLoggedIn();
    }
    public void i_click_on_the_customers_module() {
        BrowserUtils.sleep(3);
        customersPage.customersModule.click();
    }
    @Then("I should see the customers listed as a grid with the following columns:")
    public void i_should_see_the_customers_listed_as_a_grid_with_the_following_columns(List<String> expectedColumns) {
        BrowserUtils.sleep(7);
        Assert.assertEquals(expectedColumns, customersPage.actualColumns());
    }

    @Then("I should see the results paginated, {int} records at a time")
    public void iShouldSeeTheResultsPaginatedRecordsAtATime(int nrOfRecords) {
        Assert.assertEquals(nrOfRecords, customersPage.seeResults());
    }

    @And("I click on a random row")
    public void iClickOnARandomRow() {
        BrowserUtils.sleep(4);
        customersPage.seeExistingData();
    }

    @Then("I should be able to see the existing customer data")
    public void iShouldBeAbleToSeeTheExistingCustomerData() {
        customersPage.verifyCustomerDataVisible();
    }

    @And("I click on the new button")
    public void iClickOnTheNewButton() {
        customersPage.newBttn.click();
    }


    @Then("the results should be blank")
    public void theResultsShouldBeBlank() {

    }

    @When("I click on the customers module")
    public void iClickOnTheCustomersModule() {
        customersPage.customersModule.click();
    }
}
