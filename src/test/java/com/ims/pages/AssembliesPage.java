package com.ims.pages;

import com.ims.utilities.BrowserUtils;
import com.ims.utilities.Driver;
import com.ims.utilities.JavascriptShadowRoot;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AssembliesPage extends BasePage{
    public AssembliesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='toast-body']")
    public WebElement toastMessage;
    @FindBy(xpath = "(//a[.='Components'])[2]")
    public WebElement componentsTab;

    public void clickOnAnAssembly(){
        BrowserUtils.sleep(2);
        List<WebElement> assemblies = JavascriptShadowRoot.jsShadowRootList("ipd-ims-assembly-browser-component", "tbody > tr");
        assemblies.get(3).click();
    }

    public void clickComponents(){
        BrowserUtils.sleep(2);
        componentsTab.click();
    }

    public void verifyRequiredComponentsVisible(){
        BrowserUtils.sleep(3);
        WebElement requiredComponents = JavascriptShadowRoot.jsShadowRoot("ipd-ims-assembly-components-tab-component", "span");
        Assert.assertTrue(requiredComponents.isDisplayed());
    }

    public void plusSign(){
        BrowserUtils.sleep(5);
        WebElement plusSign = JavascriptShadowRoot.jsShadowRoot("ipd-ims-assembly-components-tab-component", "i");
        plusSign.click();
    }
    public void verifyWizardVisible(){
        BrowserUtils.sleep(5);
        List<WebElement> requiredComponents = JavascriptShadowRoot.jsShadowRootList("ipd-ims-assembly-components-tab-component", "h5");
        Assert.assertTrue(requiredComponents.get(1).isDisplayed());
    }
    public void selectComponentLot(){
        BrowserUtils.sleep(3);
        WebElement componentLot = JavascriptShadowRoot.jsShadowRoot("ipd-ims-assembly-components-tab-component", "input");
        componentLot.click();
    }
    public void allocationSize(String allocationSize){
        BrowserUtils.sleep(3);
        List<WebElement> componentLot = JavascriptShadowRoot.jsShadowRootList("ipd-ims-assembly-components-tab-component", "input");
        componentLot.get(1).click();
        BrowserUtils.sleep(1);
        BrowserUtils.sleep(1);
        componentLot.get(1).sendKeys(allocationSize + Keys.ENTER);
    }

    public void saveAllocationButton(){
        BrowserUtils.sleep(2);
//        List<WebElement> buttons = JavascriptShadowRoot.jsShadowRootList("ipd-ims-assembly-components-tab-component", "button");
//        buttons.get(20).click();
    }
    public void verifyAllocationSuccessful(){
        BrowserUtils.sleep(5);
        Assert.assertTrue(toastMessage.isDisplayed());
    }
}
