package com.ims.step_definitions;

import com.ims.pages.ProductPage;
import com.ims.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Product_StepDefs {
    ProductPage productPage = new ProductPage();

    @And("I click on product module")
    public void i_click_on_products_module(){
        productPage.productsModule.click();
    }


    @Then("I should see the products listed as grid with the following columns:")
    public void iShouldSeeTheProductsListedAsGridWithTheFollowingColumns(List<String> expectedColumns) {
        BrowserUtils.sleep(4);
        Assert.assertEquals(expectedColumns, productPage.actualProductsColumns());

    }

    @Then("I should be able to see the results paginated {int} records at a time")
    public void iShouldBeAbleToSeeTheResultsPaginatedRecordsAtATime(int expectedNr) {
        BrowserUtils.sleep(4);
        Assert.assertEquals(expectedNr, productPage.actualNumberOfResults());
    }

    @And("I select a customer from the dropdown")
    public void iSelectACustomerFromTheDropdown() {
        productPage.customerDropdown.click();
    }

    @Then("The components should be filtered")
    public void theComponentsShouldBeFiltered() {
        productPage.selectCustomerE2.click();
    }

    @And("I click on a given row")
    public void iClickOnAGivenRow() {
        BrowserUtils.sleep(3);
        productPage.clickOnARow();
    }

    @Then("I should be able tp see the existing product data")
    public void iShouldBeAbleTpSeeTheExistingProductData() {
        BrowserUtils.sleep(7);
        productPage.existingProductData();
    }
}
