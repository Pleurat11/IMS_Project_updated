package com.ims.pages;

import com.ims.utilities.BrowserUtils;
import com.ims.utilities.ConfigurationReader;
import com.ims.utilities.Driver;
import com.ims.utilities.SearchContextShadowRoot;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestPage extends BasePage{
    LoginPage loginPage = new LoginPage();


    @FindBy(xpath = "//ipd-ims-location-browser-component")
    public WebElement shadowHost;

    @Test
    public void test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginEmail();
        BrowserUtils.sleep(1);
        loginPage.loginPassword();
        BrowserUtils.sleep(3);

        locationsModule.click();
        SearchContextShadowRoot.shadowRoot(shadowHost);
        WebElement table = SearchContextShadowRoot.shadowRoot.findElement(By.xpath("//table/tbody/tr"));

        System.out.println(table.getText());

    }


}
