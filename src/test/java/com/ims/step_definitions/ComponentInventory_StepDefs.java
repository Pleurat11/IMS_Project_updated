package com.ims.step_definitions;

import com.ims.pages.ComponentInventoryPage;
import com.ims.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class ComponentInventory_StepDefs {
    ComponentInventoryPage comPage = new ComponentInventoryPage();
    public void i_click_on_inventory_module() {
        BrowserUtils.sleep(2);
        comPage.inventoryModule.click();
    }
    public void i_click_on_component_lots_module() {
        BrowserUtils.sleep(2);
        comPage.componentLots.click();
    }
    @Then("I should see the components listed as grid with the following columns:")
    public void i_should_see_the_components_listed_as_grid_with_the_following_columns(List<String> expectedColumns) {
        BrowserUtils.sleep(2);
        Assert.assertEquals(expectedColumns, comPage.componentLotColumns());
    }

    @Then("I should be able to see the results paginated {int}, records at a time")
    public void iShouldBeAbleToSeeTheResultsPaginatedRecordsAtATime(int expectedColumns) {
        BrowserUtils.sleep(3);
        Assert.assertEquals(expectedColumns, comPage.actualColumns());
    }

    @And("I click the Awaiting customer disposition checkbox")
    public void iClickTheAwaitingCustomerDispositionCheckbox() {
        BrowserUtils.sleep(4);
        comPage.awcCheckbox.click();
    }

    @Then("The lots should be filtered")
    public void theLotsShouldBeFiltered() {
        BrowserUtils.sleep(2);
        System.out.println("Columns after clicking the checkbox: " + comPage.actualColumns());

        BrowserUtils.sleep(5);
        comPage.awcCheckbox.click();

        BrowserUtils.sleep(2);
        System.out.println("Columns after un-clicking the checkbox: " + comPage.actualColumns());
    }

    @And("I click on component lots module")
    public void iClickOnComponentLotsModule() {
        comPage.componentLots.click();
    }

    @When("I click on inventory module")
    public void iClickOnInventoryModule() {
        comPage.inventoryModule.click();
    }
}
