package com.ims.step_definitions;

import com.ims.pages.AssembliesPage;
import com.ims.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class Assemblies_StepDefs {
    AssembliesPage assembliesPage = new AssembliesPage();
    @And("I click on assemblies module")
    public void i_click_on_assemblies_module(){
        assembliesPage.assembliesModule.click();
    }

    @And("I click on an existing assembly")
    public void iClickOnAnExistingAssembly() {
        BrowserUtils.sleep(4);
        assembliesPage.clickOnAnAssembly();
    }

    @And("I click on components tab on the top")
    public void iClickOnComponentsTabOnTheTop() {
        assembliesPage.clickComponents();
    }

    @Then("I should see required components data table")
    public void iShouldSeeRequiredComponentsDataTable() {
        assembliesPage.verifyRequiredComponentsVisible();
    }

    @When("I click on the plus sign on the far right")
    public void iClickOnThePlusSignOnTheFarRight() {
        assembliesPage.plusSign();
    }

    @Then("Select Component Lot Entry wizard will be visible")
    public void selectComponentLotEntryWizardWillBeVisible() {
        assembliesPage.verifyWizardVisible();
    }

    @When("I select an available component lot to allocate")
    public void iSelectAnAvailableComponentLotToAllocate() {
        assembliesPage.selectComponentLot();
    }

    @And("I input the allocation size")
    public void iInputTheAllocationSize() {
        assembliesPage.allocationSize("3");
    }

    @And("I click on the Save Allocation button")
    public void iClickOnTheSaveAllocationButton() {
        assembliesPage.saveAllocationButton();
    }

    @Then("the component lot will be allocated successfully")
    public void theComponentLotWillBeAllocatedSuccessfully() {
        BrowserUtils.sleep(4);
        assembliesPage.verifyAllocationSuccessful();
    }

    @Then("I should see the assemblies listed as grid with the following columns:")
    public void iShouldSeeTheAssembliesListedAsGridWithTheFollowingColumns(List<String> expectedColumns) {
        Assert.assertEquals(expectedColumns, assembliesPage.workOrderColumns());
    }

    @Then("the assembly editor should be opened")
    public void theAssemblyEditorShouldBeOpened() {
        Assert.assertTrue(assembliesPage.deleteButton.isDisplayed());
    }

    @And("I click on one of the rows on assemblies page")
    public void iClickOnOneOfTheRowsOnAssembliesPage() {
        assembliesPage.clickOnARow();
    }
}
