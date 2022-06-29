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

    @FindBy(xpath = "//button[.='Add Component']")
    public WebElement addComponentButton;

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

    public void productEditorPage(){
        int a = 4;
    }
    public void inputFields(){
        List<WebElement> inputFields = JavascriptShadowRoot.jsShadowRootList("ipd-ims-product-editor-component", "input");

        inputFields.get(3).sendKeys("Product-20");
        BrowserUtils.sleep(3);
        inputFields.get(4).sendKeys("PN-20");
        BrowserUtils.sleep(2);
        inputFields.get(5).sendKeys("RN-20");

        WebElement selectCustomer = JavascriptShadowRoot.jsShadowRoot("ipd-ims-product-editor-component", "select");

        Select select = new Select(selectCustomer);
        select.selectByIndex(1);
    }
    List<WebElement> inputFields = JavascriptShadowRoot.jsShadowRootList("ipd-ims-product-editor-component", "input");

    public void inputFieldsComponents(String partNr){

        inputFields.get(0).sendKeys(partNr);
    }
    public void lotSize(int num){
        inputFields.get(1).sendKeys(num + toString());
    }
    public void addToList(){
        List<WebElement> addToList = JavascriptShadowRoot.jsShadowRootList("ipd-ims-product-editor-component", "button");
        addToList.get(8).click();

    }
}
