package com.ims.pages;

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
        List<WebElement> componentLots = JavascriptShadowRoot.jsShadowRootList("ipd-ims-component-lot-browser-component", "tbody > tr");
        componentLots.get(0).click();
    }
}
