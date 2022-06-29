package com.ims.step_definitions;

import com.ims.pages.BasePage;
import com.ims.pages.WorkOrdersPage;
import com.ims.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class WorkOrders_StepDefs extends BasePage {
    WorkOrdersPage workOrdersPage = new WorkOrdersPage();
    @And("I click on Work Orders module")
    public void i_click_on_work_orders_module(){
        workOrdersModule.click();
    }

    @And("I click the new button")
    public void iClickTheNewButton() {
        BrowserUtils.sleep(2);
        workOrdersPage.newWorkOrder.click();
    }

    @And("I send valid data on all the fields")
    public void iSendValidDataOnAllTheFields() {
        BrowserUtils.sleep(3);
        workOrdersPage.selectCustomer();
        workOrdersPage.inputFields();
    }

    @Then("a new work order will be created")
    public void aNewWorkOrderWillBeCreated() {
        BrowserUtils.sleep(5);
        workOrdersPage.verifyWorkOrderCreated();
    }
}
