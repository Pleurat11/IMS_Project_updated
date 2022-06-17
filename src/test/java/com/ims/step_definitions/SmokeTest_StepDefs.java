package com.ims.step_definitions;

import com.ims.smoke_test.Catalog;
import com.ims.smoke_test.References;
import com.ims.utilities.JavascriptShadowRoot;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SmokeTest_StepDefs {
    References references = new References();
    Catalog catalog = new Catalog();

    @Given("User is on the ims page")
    public void user_is_on_the_ims_page(){
        int a = 1;
    }

    @Then("User wants to see locations working")
    public void userWantsToSeeLocationsWorking() {
        references.locationsTest();
    }

    @And("User wants to see vendors working")
    public void userWantsToSeeVendorsWorking() {
        references.vendorsTest();
    }

    @And("User wants to see customers working")
    public void userWantsToSeeCustomersWorking() {
        references.customersTest();
    }


    @Then("User wants to see components working as expected")
    public void userWantsToSeeComponentsWorkingAsExpected() {
        catalog.componentsTest();
    }

    @And("User wants to see products working as expected")
    public void userWantsToSeeProductsWorkingAsExpected() {
        catalog.productsTest();
    }

    @When("I click on catalog module")
    public void iClickOnCatalogModule() {
        catalog.catalogModule.click();
    }

    @And("I click on components tab")
    public void iClickOnComponentsTab() {
        catalog.componentsModule.click();
    }

    @Then("I want to add data with the following:")
    public void iWantToAddDataWithTheFollowing(List<String> uatData) {
        List<WebElement> inputFields = JavascriptShadowRoot.jsShadowRootList("ipd-ims-component-editor-component", "input");

        inputFields.get(0).sendKeys(uatData.get(0));
        inputFields.get(1).sendKeys("PN-E66");
        inputFields.get(2).sendKeys("RN-E66");
    }
}
