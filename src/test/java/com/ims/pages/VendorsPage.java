package com.ims.pages;

import com.ims.utilities.BrowserUtils;
import com.ims.utilities.JavascriptShadowRoot;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class VendorsPage extends BasePage{

    public List<String> seeVendorsAsGrid(){
        List<String> newList = new ArrayList<>();
        List<WebElement> vendorsList = JavascriptShadowRoot.jsShadowRootList("ipd-ims-vendor-browser-component", "thead > tr > th");

        for (int i = 0; i <vendorsList.size()-1; i++) {
            newList.add(vendorsList.get(i).getText());
        }
        return newList;
    }

    public int vendorsResult(){
        List<WebElement> myList = JavascriptShadowRoot.jsShadowRootList("ipd-ims-vendor-browser-component", "tbody > tr");
        return myList.size();
    }

    public void createNewVendor(){
        List<WebElement> vendorName = JavascriptShadowRoot.jsShadowRootList("ipd-ims-vendor-editor-component", "input");
        BrowserUtils.sleep(1);

        vendorName.get(0).sendKeys("AutomatedVendor");

        BrowserUtils.sleep(2);
        vendorName.get(1).click();

        BrowserUtils.sleep(2);
        WebElement selectCustomer = JavascriptShadowRoot.jsShadowRoot("ipd-ims-vendor-editor-component", "select");

        Select select = new Select(selectCustomer);
        BrowserUtils.sleep(1);
        select.selectByIndex(4);
    }

    @Test
    public void createVendor() {
        vendorsModule.click();

        for (int i = 1; i <53; i++) {

            LocationsPage locationsPage = new LocationsPage();
            locationsPage.newLocation.click();

            BrowserUtils.sleep(3);

            List<WebElement> vendorName = JavascriptShadowRoot.jsShadowRootList("ipd-ims-vendor-editor-component", "input");
            BrowserUtils.sleep(1);

            vendorName.get(0).sendKeys("Vendor Test P " +i);

            BrowserUtils.sleep(2);
            vendorName.get(1).click();

            BrowserUtils.sleep(2);
//            WebElement selectCustomer = JavascriptShadowRoot.jsShadowRoot("ipd-ims-vendor-editor-component", "select");
//
//            Select select = new Select(selectCustomer);
//            BrowserUtils.sleep(1);
//            select.selectByIndex(4);
        }
    }
}
