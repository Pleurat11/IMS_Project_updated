package com.ims.step_definitions;

import com.ims.pages.BasePage;
import com.ims.pages.CustomerReportsPage;
import com.ims.utilities.BrowserUtils;
import com.ims.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerReport_StepDefs extends BasePage {
    CustomerReportsPage reportsPage = new CustomerReportsPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

    @When("user clicks on reports module")
    public void user_clicks_on_reports_module(){
        BrowserUtils.sleep(1);
        reportsModule.click();
    }
    @When("user clicks on customer inventory tab")
    public void user_clicks_on_customer_inventory_tab() {
        BrowserUtils.sleep(2);
        customerInventory.click();
    }
    @When("user clicks on the new button")
    public void user_clicks_on_the_new_button() {
        wait.until(ExpectedConditions.elementToBeClickable(newButton));
        newButton.click();
    }
    @When("user selects a customer from the dropdown")
    public void user_selects_a_customer_from_the_dropdown() {

        BrowserUtils.sleep(5);
        reportsPage.customerReportDropdown();
    }
    @When("user clicks on Create Customer button")
    public void user_clicks_on_create_customer_button() {
        BrowserUtils.sleep(3);
        reportsPage.createCustomerButton();
    }
    @Then("a new Customer Report Entry will be created")
    public void a_new_customer_report_entry_will_be_created() {
        BrowserUtils.sleep(5);
        reportsPage.verifyReportCreated();
    }
}
