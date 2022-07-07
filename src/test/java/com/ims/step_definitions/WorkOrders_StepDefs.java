package com.ims.step_definitions;

import com.ims.pages.BasePage;
import com.ims.pages.WorkOrdersPage;
import com.ims.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class WorkOrders_StepDefs extends BasePage {
    WorkOrdersPage workOrdersPage = new WorkOrdersPage();
    @And("I click on Work Orders module")
    public void i_click_on_work_orders_module(){
        BrowserUtils.sleep(3);
        workOrdersModule.click();
    }

    @And("I click the new button")
    public void iClickTheNewButton() {
        BrowserUtils.sleep(2);
        workOrdersPage.newWorkOrder.click();
    }

    @And("I send valid data on all the fields")
    public void iSendValidDataOnAllTheFields() {
        BrowserUtils.sleep(4);
        workOrdersPage.selectCustomer();
        workOrdersPage.inputFields();
    }

    @Then("a new work order will be created")
    public void aNewWorkOrderWillBeCreated() {
        BrowserUtils.sleep(5);
        workOrdersPage.verifyWorkOrderCreated();
    }

    @Then("I should see the work orders listed as grid with the following columns:")
    public void iShouldSeeTheWorkOrdersListedAsGridWithTheFollowingColumns(List<String> actualColumns) {
        Assert.assertEquals(actualColumns, workOrdersPage.workOrderColumns());
    }

    @And("I click on one of the rows on work orders page")
    public void iClickOnOneOfTheRowsOnWorkOrdersPage() {
        workOrdersPage.clickOnARow();
    }


    @Then("the work order editor should be opened")
    public void theWorkOrderEditorShouldBeOpened() {
        Assert.assertTrue(workOrdersPage.deleteButton.isDisplayed());
    }
}
