package com.ims.step_definitions;

import com.ims.pages.BasePage;
import com.ims.pages.LoginPage;
import com.ims.utilities.*;
import org.junit.Test;
import org.openqa.selenium.*;
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

        WebElement nextButton = JavascriptShadowRoot.jsShadowRoot("ipd-ims-component-lot-browser-component", "div.d-grid.gap-2.d-md-flex.justify-content-md-end");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        Actions actions = new Actions(Driver.getDriver());


            BrowserUtils.sleep(6);
            nextButton.click();

            BrowserUtils.sleep(7);

        List<WebElement> selectClass2 = JavascriptShadowRoot.jsShadowRootList("ipd-ims-component-lot-browser-component", "select");
        BrowserUtils.sleep(2);

        Select selectCustomer2 = new Select(selectClass2.get(0));
        selectCustomer2.selectByIndex(1);

        BrowserUtils.sleep(4);

        WebElement nextBttn = JavascriptShadowRoot.jsShadowRoot("ipd-ims-component-lot-browser-component", "button.btn.btn-primary");
        wait.until(ExpectedConditions.elementToBeClickable(nextBttn));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", nextBttn);
    }

}
