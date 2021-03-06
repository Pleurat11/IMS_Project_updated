package com.ims.pages;

import com.ims.utilities.ConfigurationReader;
import com.ims.utilities.Driver;
import io.cucumber.java.BeforeAll;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='New']")
    public WebElement newButton;

    @FindBy(xpath = "//button[.='Delete']")
    public WebElement deleteButton;
    @FindBy(xpath = "//button[.='Save']")
    public WebElement saveButton;
    @FindBy(xpath = "(//button[@class='btn btn-sm btn-light'])[1]")
    public WebElement newLocation;

    @FindBy(xpath = "//button[.='Reset filters']")
    public WebElement resetFiltersButton;

    @FindBy(xpath = "//a[.='Vertos']")
    public WebElement selectCustomer;

    @FindBy(xpath = "//button[.='Email']")
    public WebElement emailButton;

    @FindBy(xpath = "//a[.='Attachments']")
    public WebElement attachmentsTab;
    @FindBy(xpath = "//a[.='Inventory']")
    public WebElement inventoryModule;
    @FindBy(xpath = "//a[.='Catalog']")
    public WebElement catalogModule;

    @FindBy(xpath = "//a[.='Delivery']")
    public WebElement deliveryModule;

    @FindBy(xpath = "//a[.='Reports']")
    public WebElement reportsModule;

    @FindBy(xpath = "//a[.='Component Lots']")
    public WebElement componentLots;

    @FindBy(xpath = "//a[.='Components']")
    public WebElement componentsModule;

    @FindBy(xpath = "//a[.='Customers']")
    public WebElement customersModule;

    @FindBy(xpath = "//a[.='Locations']")
    public WebElement locationsModule;

    @FindBy(xpath = "//a[.='Products']")
    public WebElement productsModule;

    @FindBy(xpath = "//a[.='Vendors']")
    public WebElement vendorsModule;

    @FindBy(xpath = "//a[.='Work Order']")
    public WebElement workOrdersModule;

    @FindBy(xpath = "//a[.='Assemblies']")
    public WebElement assembliesModule;

    @FindBy(xpath = "//a[.='Assembly Lots']")
    public WebElement assemblyLotsModule;

    @FindBy(xpath = "//a[.='Shipments']")
    public WebElement shipmentsModule;

    @FindBy(xpath = "//a[.='Customer Inventory']")
    public WebElement customerInventory;

    @FindBy(xpath = "//a[.='References']")
    public WebElement referencesModule;

}