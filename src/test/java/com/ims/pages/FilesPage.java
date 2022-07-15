package com.ims.pages;

import com.ims.utilities.BrowserUtils;
import com.ims.utilities.Driver;
import com.ims.utilities.JavascriptShadowRoot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage extends BasePage{
    public FilesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Upload']")
    public WebElement uploadButton;

    public void existingComponentLots(){
        BrowserUtils.sleep(3);
        WebElement componentLots = JavascriptShadowRoot.jsShadowRoot("ipd-ims-component-lot-browser-component", "tbody > tr");
        componentLots.click();


    }
}
