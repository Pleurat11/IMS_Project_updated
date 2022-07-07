package com.ims.step_definitions;

import com.ims.pages.ComponentsPage;
import com.ims.utilities.BrowserUtils;
import com.ims.utilities.JavascriptShadowRoot;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Components_StepDefs {

    ComponentsPage componentsPage = new ComponentsPage();
    public void i_click_on_components_module() {
        BrowserUtils.sleep(4);
        componentsPage.componentsModule.click();
    }
    @Then("I should see the components listed as grid, with the following columns:")
    public void i_should_see_the_components_listed_as_grid_with_the_following_columns(List<String> expectedColumns) {
        BrowserUtils.sleep(3);
        Assert.assertEquals(componentsPage.actualColumns(), expectedColumns);
    }

    public void iClickOnCatalogsModule() {
        BrowserUtils.sleep(4);
        componentsPage.catalogModule.click();
    }

    @Then("I should be able to see the results paginated, {int} records at a time")
    public void iShouldBeAbleToSeeTheResultsPaginatedRecordsAtATime(int numOfRecords) {
        BrowserUtils.sleep(5);
        Assert.assertEquals(numOfRecords, componentsPage.numOfRecords());
    }

    @And("After I select a customer, the dropdown will show vendors associated with that customer")
    public void iSelectACustomerTheDropdownWillShowVendorsAssociatedWithThatCustomer() {
        componentsPage.vendorsListAfterClickingCustomer();
    }

    @When("I click on Select Customers dropdown on components page")
    public void iClickOnSelectCustomersDropdownOnComponentsPage() {
        BrowserUtils.sleep(5);
        componentsPage.componentsDropdown.click();

        componentsPage.clickOnACustomer();
    }
    @When("A vendor was selected already")
    public void aVendorWasSelectedAlready() {
        componentsPage.clickOnAVendor();
    }

    @Then("vendor dropdown will be reset to empty")
    public void vendorDropdownWillBeResetToEmpty() {
        componentsPage.vendorShouldBeEmpty();

    }

    @And("I send {string} to component field")
    public void iSendToComponentField(String componentName) {

        List <WebElement> inputFields = JavascriptShadowRoot.jsShadowRootList("ipd-ims-component-editor-component", "input");

        inputFields.get(0).sendKeys(componentName);
        BrowserUtils.sleep(1);


        List <WebElement> selectFields = JavascriptShadowRoot.jsShadowRootList("ipd-ims-component-editor-component", "select");

        BrowserUtils.sleep(2);
        Select selectCustomer = new Select(selectFields.get(0));
        selectCustomer.selectByIndex(1);
    }

    @And("I send {string} to part number field")
    public void iSendToPartNumberField(String componentName) {
        List <WebElement> inputFields = JavascriptShadowRoot.jsShadowRootList("ipd-ims-component-editor-component", "input");

        inputFields.get(1).sendKeys(componentName);
    }

    @And("I send {string} to revision nr field")
    public void iSendToRevisionNrField(String revisionNr) {
        List <WebElement> inputFields = JavascriptShadowRoot.jsShadowRootList("ipd-ims-component-editor-component", "input");

        inputFields.get(2).sendKeys(revisionNr);
    }

    @And("I select the first customer from the dropdown")
    public void iSelectTheFirstCustomerFromTheDropdown() {
     WebElement select = JavascriptShadowRoot.jsShadowRoot("ipd-ims-component-editor-component", "select");

     Select select1 = new Select(select);

     select1.selectByIndex(1);
    }


    @And("I click on one of the rows on components page")
    public void iClickOnOneOfTheRowsOnComponentsPage() {
        componentsPage.clickOnARow();
    }



    @And("I click the add component button to add the component")
    public void iClickTheAddComponentButtonToAddTheComponent() {
        componentsPage.clickAddComponent();
    }

    @And("I select a part number from the part number dropdown")
    public void iSelectAPartNumberFromThePartNumberDropdown() {
        componentsPage.partNr(1);
    }

    @And("I select a revision number from the revision number dropdown")
    public void iSelectARevisionNumberFromTheRevisionNumberDropdown() {
        componentsPage.revisionNr(1);
    }

    @Then("the component should be added successfully")
    public void theComponentShouldBeAddedSuccessfully() {
        //TODO when QA up
    }
}
