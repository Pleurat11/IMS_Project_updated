package com.ims.pages;

import com.ims.utilities.JavascriptShadowRoot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ComponentInventoryPage extends BasePage {


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

}
