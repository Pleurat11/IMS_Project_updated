package com.ims.pages;

import com.ims.utilities.Driver;
import com.ims.utilities.JavascriptShadowRoot;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AssemblyLotPage {
    public AssemblyLotPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//a[.='Assembly Lots'])[2]")
    public WebElement assemblyLotTab;

    @FindBy(xpath = "//button[.='Add Lot']")
    public WebElement addLot;

    @FindBy(xpath = "//a[.='Assembly Lot']")
    public WebElement assemblyLotVisible;

    @FindBy(xpath = "//div[@class='toast-header text-white bg-success']")
    public WebElement toastMessage;

    public void clickAssemblyLotsTab(){
        assemblyLotTab.click();
    }
    public void clickAddLot(){
        addLot.click();
    }
    public void verifyAssemblyLotPage(){
        Assert.assertTrue(assemblyLotVisible.isDisplayed());
    }
    public void sendLotNumber(){
        List<WebElement> inputFields = JavascriptShadowRoot.jsShadowRootList("ipd-ims-assembly-lot-editor-component", "input");

        inputFields.get(0).sendKeys("5");
    }
    public void sendLotSize(){
        List<WebElement> inputFields = JavascriptShadowRoot.jsShadowRootList("ipd-ims-assembly-lot-editor-component", "input");

        inputFields.get(1).sendKeys("5");
    }

    public void selectCustomer(String string){
        List<WebElement> select = JavascriptShadowRoot.jsShadowRootList("ipd-ims-assembly-lot-editor-component", "select");

        Select select1 = new Select(select.get(1));
        select1.selectByVisibleText(string);
    }

    public void verifyAssemblyLotCreated(){
        Assert.assertTrue(toastMessage.isDisplayed());
    }
}
