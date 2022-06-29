package com.ims.pages;

import com.ims.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssemblyLotPage {
    public AssemblyLotPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//a[.='Assembly Lots'])[2]")
    public WebElement assemblyLotTab;

    @FindBy(xpath = "//button[.='Add Lot']")
    public WebElement addLot;

    public void clickAssemblyLotsTab(){
        assemblyLotTab.click();
    }
    public void clickAddLot(){
        addLot.click();
    }
}
