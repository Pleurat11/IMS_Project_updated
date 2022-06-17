package com.ims.utilities;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class SearchContextShadowRoot {
    public static SearchContext shadowRoot;
    public static void shadowRoot(WebElement shadowHostt){
        //WebElement shadowHost = Driver.getDriver().findElement(By.xpath("//login-component"));
        //SearchContext shadowRoot = shadowHost.getShadowRoot();
        // WebElement shadowContent = shadowRoot.findElement(By.id("f_email_0"));


        shadowRoot = shadowHostt.getShadowRoot();

    }
}
