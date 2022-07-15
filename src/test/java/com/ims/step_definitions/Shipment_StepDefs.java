package com.ims.step_definitions;

import com.ims.pages.ShipmentPage;
import com.ims.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Shipment_StepDefs {
    ShipmentPage shipmentPage = new ShipmentPage();

    @When("I click on delivery module")
    public void i_click_on_delivery_module() {
        if (!shipmentPage.shipmentsModule.isDisplayed()) {
            shipmentPage.deliveryModule.click();
        }
    }
    @And("I click on shipments module")
    public void iClickOnShipmentsModule() {
        shipmentPage.shipmentsModule.click();
    }

    @And("I fill the fields with valid data")
    public void iFillTheFieldsWithValidData() {
        BrowserUtils.sleep(4);
        shipmentPage.selectFields();
    }

    @Then("a new shipment should be created")
    public void aNewShipmentShouldBeCreated() {
        shipmentPage.verifyShipmentCreated();
    }
}
