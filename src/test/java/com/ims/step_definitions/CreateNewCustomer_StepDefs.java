package com.ims.step_definitions;

import com.ims.pages.CustomersPage;
import com.ims.utilities.BrowserUtils;
import com.ims.utilities.Driver;
import com.ims.utilities.JavascriptShadowRoot;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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

    @And("I send {string} to the given field")
    public void iSendToTheGivenField(String customersName) {
        WebElement customerField = JavascriptShadowRoot.jsShadowRoot("ipd-ims-customer-editor-component", "input");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(customerField));
        BrowserUtils.sleep(4);

        customerField.sendKeys(customersName);
    }

    @And("I send {string} to the required field")
    public void iSendToTheRequiredField(String code) {
        List<WebElement> inputFields = JavascriptShadowRoot.jsShadowRootList("ipd-ims-customer-editor-component", "input");
        inputFields.get(1).clear();
        BrowserUtils.sleep(2);
        inputFields.get(1).sendKeys(code);
    }
}
