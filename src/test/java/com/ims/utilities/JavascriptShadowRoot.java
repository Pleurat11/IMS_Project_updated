package com.ims.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JavascriptShadowRoot {
    public static List<WebElement> jsShadowRootList(String shadowRoot, String element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        List<WebElement> dataTable = (List<WebElement>)js.executeScript("return document.querySelector('"+shadowRoot+"').shadowRoot.querySelectorAll('"+element+"')");

        return dataTable;
    }
    public static WebElement jsShadowRoot(String shadowRoot, String element){

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement dataTable = (WebElement)js.executeScript("return document.querySelector('"+shadowRoot+"').shadowRoot.querySelector('"+element+"')");

        return dataTable;
    }
}
