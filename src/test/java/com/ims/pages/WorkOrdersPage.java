package com.ims.pages;

import com.ims.utilities.BrowserUtils;
import com.ims.utilities.Driver;
import com.ims.utilities.JavascriptShadowRoot;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WorkOrdersPage extends BasePage{
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

    public List<String> workOrderColumns(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(newWorkOrder));
        List<String> newList = new ArrayList<>();
        List<WebElement> vendorsList = JavascriptShadowRoot.jsShadowRootList("ipd-ims-work-order-browser-component", "thead > tr > th");

        for (int i = 0; i <vendorsList.size()-1; i++) {
            newList.add(vendorsList.get(i).getText());
        }
        return newList;
    }
    public void clickOnARow() {
        BrowserUtils.sleep(6);
        List<WebElement> customersList = JavascriptShadowRoot.jsShadowRootList("ipd-ims-work-order-browser-component", "table > tbody > tr");
        try {
            customersList.get(1).click();
        }
        catch (StaleElementReferenceException e){
            e.printStackTrace();
        }
    }
}
