package com.ims.smoke_test;

import com.ims.pages.BasePage;
import com.ims.pages.LoginPage;
import com.ims.utilities.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class References extends BasePage {

    @Test
    public void locationsTest() {
//        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
//
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//        loginPage.loginEmail();
//        loginPage.loginPassword();

        locationsModule.click();

        newButton.click();
        WebElement locationField = JavascriptShadowRoot.jsShadowRoot("ipd-ims-location-editor-component", "input");
        locationField.sendKeys("Location Test");

        WebElement descriptionField = JavascriptShadowRoot.jsShadowRoot("ipd-ims-location-editor-component", "textarea");

        descriptionField.sendKeys("Location Description");

//        saveButton.click();
        BrowserUtils.sleep(3);
    }

    @Test
    public void vendorsTest(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        vendorsModule.click();
        newButton.click();

        List<WebElement> vendorName = JavascriptShadowRoot.jsShadowRootList("ipd-ims-vendor-editor-component", "input");
        BrowserUtils.sleep(1);

        vendorName.get(0).sendKeys("Vendor Test");

        //saveButton.click();
    }

    @Test()
    public void customersTest(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        customersModule.click();
        newButton.click();

        List<WebElement> inputFields = JavascriptShadowRoot.jsShadowRootList("ipd-ims-customer-editor-component", "input");

        WebElement customerField = JavascriptShadowRoot.jsShadowRoot("ipd-ims-customer-editor-component", "input");


        customerField.sendKeys("Automated customer");
        inputFields.get(1).clear();
        inputFields.get(1).sendKeys("23");

        saveButton.click();
        BrowserUtils.sleep(4);

        WebElement addComponentButton = Driver.getDriver().findElement(By.xpath("//button[.='Add Component']"));
        addComponentButton.click();

        WebElement selectPartNr = JavascriptShadowRoot.jsShadowRoot("ipd-ims-customer-editor-component", "select");

        Select selectPartNumber = new Select(selectPartNr);
        selectPartNumber.selectByIndex(2);

        List<WebElement> addComponentButtons = JavascriptShadowRoot.jsShadowRootList("ipd-ims-customer-editor-component", "button");

        addComponentButtons.get(3).click();
    }

    @Test
    public void addComponentsUat(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));


    }

}
