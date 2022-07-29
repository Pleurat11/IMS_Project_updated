package com.ims.pages;

import com.ims.utilities.BrowserUtils;
import com.ims.utilities.Driver;
import com.ims.utilities.JavascriptShadowRoot;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ComponentLotsPage extends BasePage {


    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement awcCheckbox;

    public List<String> componentLotColumns(){
        List<String> newList = new ArrayList<>();
        List<WebElement> actualColumns = JavascriptShadowRoot.jsShadowRootList("ipd-ims-component-lot-browser-component", "thead > tr");

        for (int i = 0; i <actualColumns.size(); i++) {
            newList.add(actualColumns.get(i).getText());
        }
        return newList;
    }

    public int actualColumns(){
        List<WebElement> actualColumns = JavascriptShadowRoot.jsShadowRootList("ipd-ims-component-lot-browser-component", "tbody > tr");

        return actualColumns.size();
    }

    public void clickOnARow() {
        BrowserUtils.sleep(6);
        List<WebElement> customersList = JavascriptShadowRoot.jsShadowRootList("ipd-ims-component-lot-browser-component", "table > tbody > tr");
        try {
            customersList.get(1).click();
        }
        catch (StaleElementReferenceException e){
            e.printStackTrace();
        }
    }

    public void readdComponentLots(){
        List<WebElement> actualColumns = JavascriptShadowRoot.jsShadowRootList("ipd-ims-component-lot-browser-component", "tbody > tr");

        for (int i = 0; i <actualColumns.size(); i++) {
            System.out.println(actualColumns.get(i).getText() + "\n");
        }
    }
}
