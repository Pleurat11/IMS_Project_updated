package com.ims.step_definitions;

import com.ims.pages.BasePage;
import com.ims.pages.LoginPage;
import com.ims.utilities.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class CreateWorkOrder extends BasePage {
    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

    @Test
    public void createWorkOrderTest(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        BrowserUtils.sleep(3);
        loginPage.loginEmail();
        loginPage.loginPassword();
        BrowserUtils.sleep(4);
        inventoryModule.click();
        workOrdersModule.click();
        BrowserUtils.sleep(2);


        Driver.getDriver().findElement(By.xpath("(//button[@class='btn btn-sm btn-light '])[1]")).click();

        BrowserUtils.sleep(2);
        WebElement customerSelect = JavascriptShadowRoot.jsShadowRoot("ipd-ims-work-order-editor-component", "select");
        BrowserUtils.sleep(2);

        Select select = new Select(customerSelect);
        select.selectByIndex(4);
        BrowserUtils.sleep(4);
        List<WebElement> inputFields = JavascriptShadowRoot.jsShadowRootList("ipd-ims-work-order-editor-component", "input");

        inputFields.get(0).sendKeys("workOrderNr");
        BrowserUtils.sleep(1);
        inputFields.get(1).sendKeys("purchaseOrderNr");

//        WebElement addAssemblyButton = Driver.getDriver().findElement(By.xpath("//button[contains(text(),'Add Assembly')]"));
//        addAssemblyButton.click();


    }
}
