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

public class ShipmentPage extends BasePage{
    public ShipmentPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//div[@class='toast-body']")
    public WebElement toastMessage;
    public void selectFields(){
        List<WebElement> select = JavascriptShadowRoot.jsShadowRootList("ipd-ims-shipment-editor-component", "select");
        List<WebElement> cartons = JavascriptShadowRoot.jsShadowRootList("ipd-ims-shipment-editor-component", "input");


        Select customerSelect = new Select(select.get(0));
        customerSelect.selectByVisibleText("Vertos");
        BrowserUtils.sleep(3);

        Select destinationSelect = new Select(select.get(1));
        destinationSelect.selectByVisibleText("End Customer");

        BrowserUtils.sleep(3);
        Select shipTo = new Select(select.get(2));
        shipTo.selectByIndex(1);

        BrowserUtils.sleep(3);

        cartons.get(1).sendKeys("3");


        BrowserUtils.sleep(3);
        Select shipVia = new Select(select.get(3));
        shipVia.selectByVisibleText("Customer Pickup");
    }

    public void verifyShipmentCreated(){
        BrowserUtils.sleep(3);
        Assert.assertTrue(toastMessage.isDisplayed());
    }
}
