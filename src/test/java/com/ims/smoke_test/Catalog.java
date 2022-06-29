package com.ims.smoke_test;

import com.ims.pages.BasePage;
import com.ims.utilities.BrowserUtils;
import com.ims.utilities.Driver;
import com.ims.utilities.JavascriptShadowRoot;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Catalog extends BasePage {
    @Test
    public void componentsTest(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        catalogModule.click();
        componentsModule.click();

        newButton.click();
        BrowserUtils.sleep(3);

        List<WebElement> inputFields = JavascriptShadowRoot.jsShadowRootList("ipd-ims-component-editor-component", "input");

        inputFields.get(0).sendKeys("Component Test");
        inputFields.get(1).sendKeys("PN-E66");
        inputFields.get(2).sendKeys("RN-E66");

        List <WebElement> selectFields = JavascriptShadowRoot.jsShadowRootList("ipd-ims-component-editor-component", "select");


        Select selectCustomer = new Select(selectFields.get(0));
        selectCustomer.selectByIndex(1);

        Select selectVendor = new Select(selectFields.get(1));
        selectVendor.selectByIndex(1);

        Select selectProduct = new Select(selectFields.get(2));
        selectProduct.selectByIndex(1);

         saveButton.click();
    }

    @Test
    public void productsTest(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.titleIs("Portal"));


        catalogModule.click();
        productsModule.click();

        newButton.click();
        BrowserUtils.sleep(2);

        List<WebElement> inputFields = JavascriptShadowRoot.jsShadowRootList("ipd-ims-product-editor-component", "input");

        BrowserUtils.sleep(2);
        inputFields.get(3).sendKeys("productName");
        BrowserUtils.sleep(2);
        inputFields.get(4).sendKeys("pn-66");
        BrowserUtils.sleep(2);
        inputFields.get(5).sendKeys("rn-66");

        Select selectCustomer = new Select(JavascriptShadowRoot.jsShadowRoot("ipd-ims-product-editor-component", "select"));
        BrowserUtils.sleep(2);
        selectCustomer.selectByIndex(1);

        BrowserUtils.sleep(2);
        WebElement descriptionField = JavascriptShadowRoot.jsShadowRoot("ipd-ims-product-editor-component", "textarea");
        descriptionField.sendKeys("productDescription");

        saveButton.click();

//        BrowserUtils.sleep(10);
//
//        WebElement addComponentButton = Driver.getDriver().findElement(By.xpath("//button[.='Add Component']"));
//
//        addComponentButton.click();
//
//        List<WebElement> fieldsInput = JavascriptShadowRoot.jsShadowRootList("ipd-ims-product-editor-component", "input");
//
//        WebElement partNumber = fieldsInput.get(0);
//        WebElement lotSize = fieldsInput.get(1);
//        partNumber.sendKeys("PRT-1");
//        lotSize.sendKeys("10");
//
//        List<WebElement> addToList = JavascriptShadowRoot.jsShadowRootList("ipd-ims-product-editor-component", "button");
//
//        WebElement addToListButton = addToList.get(9);
//
//        addToListButton.click();
    }
}
