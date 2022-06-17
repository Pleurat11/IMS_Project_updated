package com.ims.pages;

import com.ims.utilities.BrowserUtils;
import com.ims.utilities.Driver;
import com.ims.utilities.JavascriptShadowRoot;
import com.ims.utilities.SearchContextShadowRoot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));


    @FindBy(xpath = "//button[.='Select Customer']")
    public WebElement customerDropdown;

    @FindBy(xpath = "//a[.='Customer E2']")
    public WebElement selectCustomerE2;

    public List<String> actualProductsColumns(){
        List<String> newList = new ArrayList<>();
        List<WebElement> productsList = JavascriptShadowRoot.jsShadowRootList("ipd-ims-product-browser-component", "thead > tr > th");

        for (int i = 0; i <productsList.size()-1; i++) {
            newList.add(productsList.get(i).getText());
        }
        return newList;
    }

    public int actualNumberOfResults(){
        List<WebElement> productsList = JavascriptShadowRoot.jsShadowRootList("ipd-ims-product-browser-component", "tbody > tr");

        return productsList.size();
    }

    public void clickOnARow(){
        WebElement row = JavascriptShadowRoot.jsShadowRoot("ipd-ims-product-browser-component", "tbody > tr");
        row.click();

    }
    public void existingProductData(){
        WebElement selectId = JavascriptShadowRoot.jsShadowRoot("ipd-ims-product-browser-component", "select");
        SearchContextShadowRoot.shadowRoot(Driver.getDriver().findElement(By.xpath("ipd-ims-product-browser-component")));

        WebElement customer = SearchContextShadowRoot.shadowRoot.findElement(By.id("f_name_0"));
        System.out.println(customer.getText());
    }
}
