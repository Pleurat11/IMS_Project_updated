package com.ims.step_definitions;

import com.ims.pages.AssemblyLotPage;
import com.ims.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssemblyLots_StepDefs {
    AssemblyLotPage assemblyLotPage = new AssemblyLotPage();

    @And("I click on the Assembly Lots tab")
    public void iClickOnTheAssemblyLotsTab(){
        BrowserUtils.sleep(4);
        assemblyLotPage.clickAssemblyLotsTab();
    }

    @And("I click the Add Lot button at the top")
    public void iClickTheAddLotButtonAtTheTop() {
        BrowserUtils.sleep(4);
        assemblyLotPage.clickAddLot();
    }

    @Then("I will be redirected to assembly lot editor")
    public void iWillBeRedirectedToAssemblyLotEditor() {
        BrowserUtils.sleep(6);
        assemblyLotPage.verifyAssemblyLotPage();
    }

    @When("I enter a Lot number in the # field")
    public void iEnterALotNumberInTheField() {
        BrowserUtils.sleep(2);
        assemblyLotPage.sendLotNumber();
    }

    @And("I enter a number as lot size")
    public void iEnterANumberAsLotSize() {
        BrowserUtils.sleep(1);
        assemblyLotPage.sendLotSize();
    }

    @Then("a new assembly lot will be created successfully")
    public void aNewAssemblyLotWillBeCreatedSuccessfully() {
        BrowserUtils.sleep(6);
        assemblyLotPage.verifyAssemblyLotCreated();
    }

    @And("I select {string} from the location dropdown")
    public void iSelectFromTheLocationDropdown(String location) {
        assemblyLotPage.selectCustomer(location);
    }
}
