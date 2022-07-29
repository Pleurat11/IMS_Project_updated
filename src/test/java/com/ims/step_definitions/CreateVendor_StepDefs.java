package com.ims.step_definitions;

import com.ims.pages.VendorsPage;
import com.ims.utilities.BrowserUtils;
import com.ims.utilities.Driver;
import com.ims.utilities.JavascriptShadowRoot;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CreateVendor_StepDefs {
    VendorsPage vendorsPage = new VendorsPage();
    @And("I send valid data to the required fields")
    public void i_send_valid_data_to_the_required_fields() {
        BrowserUtils.sleep(4);
        vendorsPage.createNewVendor();
    }
    @Then("A new vendor should be created successfully")
    public void a_new_vendor_should_be_created_successfully() {

    }

    @And("I send {string} to the fieldd")
    public void iSendToTheFieldd(String vendorsName) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));


        List<WebElement> vendorName = JavascriptShadowRoot.jsShadowRootList("ipd-ims-vendor-editor-component", "input");

        wait.until(ExpectedConditions.elementToBeClickable(vendorName.get(0)));

        BrowserUtils.sleep(1);

        vendorName.get(0).sendKeys(vendorsName);

        BrowserUtils.sleep(4);

        vendorName.get(1).click();

        WebElement selectField = JavascriptShadowRoot.jsShadowRoot("ipd-ims-vendor-editor-component", "input");

        BrowserUtils.sleep(3);
        Select select = new Select(selectField);
        select.selectByVisibleText("Vertos");

        if (!vendorsPage.saveButton.isDisplayed()){
            Driver.getDriver().navigate().refresh();
        }

    }
}
