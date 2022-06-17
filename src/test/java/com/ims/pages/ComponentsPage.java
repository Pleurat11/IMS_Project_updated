package com.ims.pages;

import com.ims.utilities.BrowserUtils;
import com.ims.utilities.JavascriptShadowRoot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ComponentsPage extends BasePage{

    @FindBy(xpath = "(//div[@class='dropdown'])[1]")
    public WebElement componentsDropdown;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public List<WebElement> dropdownList;

    @FindBy(xpath = "//button[.='Select Vendor']")
    public WebElement selectVendor;

    @FindBy(xpath = "//a[.='Vendors E1']")
    public WebElement vendorE1;

    @FindBy(xpath = "//a[.='Customer E1']")
    public WebElement customerE1;



    public List<String> actualColumns(){
        List<String> newList = new ArrayList<>();
        List<WebElement> vendorsList = JavascriptShadowRoot.jsShadowRootList("ipd-ims-component-browser-component", "thead > tr > th");

        for (int i = 0; i <vendorsList.size()-1; i++) {
            newList.add(vendorsList.get(i).getText());
        }
        return newList;
    }

    public int numOfRecords(){
        List<WebElement> vendorsList = JavascriptShadowRoot.jsShadowRootList("ipd-ims-component-browser-component", "tbody > tr");

        return vendorsList.size();
    }

    public void clickOnACustomer(){

        BrowserUtils.sleep(3);
        customerE1.click();

    }

    public void vendorsListAfterClickingCustomer(){
        selectVendor.click();
        BrowserUtils.sleep(2);
        for (int i = 10; i < dropdownList.size(); i++) {
            System.out.println("Vendors list : " + dropdownList.get(i).getText());
        }
    }

    public void clickOnAVendor(){
        BrowserUtils.sleep(2);
        selectVendor.click();
        BrowserUtils.sleep(3);
        vendorE1.click();
    }

    public void vendorShouldBeEmpty(){
        BrowserUtils.sleep(2);
        selectVendor.click();
        BrowserUtils.sleep(3);
        for (int i = 10; i < dropdownList.size(); i++) {
            System.out.println("vendors list after selecting a vendor : " + dropdownList.get(i).getText());
        }
    }

    public void createNewComponent(){
        List <WebElement> inputFields = JavascriptShadowRoot.jsShadowRootList("ipd-ims-component-editor-component", "input");

        inputFields.get(0).sendKeys("Automated Component");
        inputFields.get(1).sendKeys("PN-E66");
        inputFields.get(2).sendKeys("RN-E66");

        List <WebElement> selectFields = JavascriptShadowRoot.jsShadowRootList("ipd-ims-component-editor-component", "select");

        BrowserUtils.sleep(2);
        Select selectCustomer = new Select(selectFields.get(0));
        selectCustomer.selectByIndex(3);

        BrowserUtils.sleep(2);
        Select selectVendor = new Select(selectFields.get(1));
        selectVendor.selectByIndex(1);

        BrowserUtils.sleep(2);
        Select selectProduct = new Select(selectFields.get(2));
        selectProduct.selectByIndex(1);


    }
}
