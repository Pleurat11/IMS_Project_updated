package com.ims.pages;

import com.ims.utilities.BrowserUtils;
import com.ims.utilities.Driver;
import com.ims.utilities.JavascriptShadowRoot;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WorkOrdersPage {
    public WorkOrdersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='New Work Order']")
    public WebElement newWorkOrder;

    @FindBy(xpath = "//div[@class='toast-body']")
    public WebElement toastMessage;

    public void selectCustomer(){
        WebElement selectId = JavascriptShadowRoot.jsShadowRoot("ipd-ims-work-order-editor-component", "select");

        Select select = new Select(selectId);
        select.selectByIndex(1);
    }
    public void inputFields(){
        List<WebElement> inputFields = JavascriptShadowRoot.jsShadowRootList("ipd-ims-work-order-editor-component", "input");
        BrowserUtils.sleep(2);
        inputFields.get(0).sendKeys("WO-13");
        BrowserUtils.sleep(2);
        inputFields.get(1).sendKeys("PO-13");
    }

    public void verifyWorkOrderCreated(){
        Assert.assertTrue(toastMessage.isDisplayed());
    }
}
