package com.ims.utilities;

import com.sun.source.tree.BreakTree;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void scroll(int scrollFrom, int scrollUntil){
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("window.scrollBy("+scrollFrom+","+scrollUntil+")", "");
    }

    public static void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }


    public static List<String> getElements(List<WebElement> myList){
        List<String> myList2 = new ArrayList<>();

        for (int i = 0; i <myList.size(); i++) {
            myList2.add(myList.get(i).getText());
        }
        return myList2;
    }
}
