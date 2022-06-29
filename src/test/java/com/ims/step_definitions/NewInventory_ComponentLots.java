package com.ims.step_definitions;

import com.ims.pages.BasePage;
import com.ims.pages.LoginPage;
import com.ims.utilities.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class NewInventory_ComponentLots extends BasePage {
    LoginPage loginPage = new LoginPage();
    @Test
    public void newInventory(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        loginPage.loginEmail();
        BrowserUtils.sleep(1);
        loginPage.loginPassword();
        BrowserUtils.sleep(4);
        inventoryModule.click();
        BrowserUtils.sleep(1);
        componentLots.click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("(//button[@class='btn btn-sm btn-light '])[1]")).click();

        List<WebElement> selectClass = JavascriptShadowRoot.jsShadowRootList("ipd-ims-component-lot-browser-component", "select");
        BrowserUtils.sleep(2);

        Select selectCustomer = new Select(selectClass.get(0));
        selectCustomer.selectByVisibleText("Vertos");

        List<WebElement> nextButton = JavascriptShadowRoot.jsShadowRootList("ipd-ims-component-lot-browser-component", "div > button");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(2);
//        WebElement shadowHost = Driver.getDriver().findElement(By.xpath("ipd-ims-component-lot-browser-component"));
//        SearchContextShadowRoot.shadowRoot(shadowHost);
//        WebElement nextBttn = SearchContextShadowRoot.shadowRoot.findElement(By.xpath("//button[.='Next']"));

        BrowserUtils.sleep(4);
        nextButton.get(7).click();


    }
}
