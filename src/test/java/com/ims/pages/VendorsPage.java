package com.ims.pages;

import com.ims.utilities.BrowserUtils;
import com.ims.utilities.JavascriptShadowRoot;
import org.junit.Test;
import org.openqa.selenium.StaleElementReferenceException;
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
        BrowserUtils.sleep(4);
        List<WebElement> myList = JavascriptShadowRoot.jsShadowRootList("ipd-ims-vendor-browser-component", "tbody > tr");
        return myList.size();
    }

    public void createNewVendor(){
        BrowserUtils.sleep(3);
        List<WebElement> vendorName = JavascriptShadowRoot.jsShadowRootList("ipd-ims-vendor-editor-component", "input");
        BrowserUtils.sleep(1);

        vendorName.get(0).sendKeys("AutomatedVendor");

        BrowserUtils.sleep(2);
        vendorName.get(1).click();

        BrowserUtils.sleep(2);
        WebElement selectCustomer = JavascriptShadowRoot.jsShadowRoot("ipd-ims-vendor-editor-component", "select");

        Select select = new Select(selectCustomer);
        BrowserUtils.sleep(1);
        select.selectByIndex(1);
    }

    public void clickOnARow() {
        BrowserUtils.sleep(6);
        List<WebElement> locationsList = JavascriptShadowRoot.jsShadowRootList("ipd-ims-vendor-browser-component", "table > tbody > tr");
        try {
            locationsList.get(1).click();
        }
        catch (StaleElementReferenceException e){
            e.printStackTrace();
        }
    }

}
