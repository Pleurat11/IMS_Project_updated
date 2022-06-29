package com.ims.step_definitions;

import com.ims.pages.ProductPage;
import com.ims.utilities.BrowserUtils;
import com.ims.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class CreateProduct_StepDefs {
    ProductPage productPage =  new ProductPage();

    @Then("I should be redirected to product editor page")
    public void iShouldBeRedirectedToProductEditorPage() {
        int b =5;
    }

    @When("I enter valid data on the required fields")
    public void iEnterValidDataOnTheRequiredFields() {
        productPage.inputFields();
    }

    @Then("a new product should be created")
    public void aNewProductShouldBeCreated() {
        int a =4;
    }

    @When("I click on the add component button")
    public void iClickOnTheAddComponentButton() {
        BrowserUtils.sleep(6);
        productPage.addComponentButton.click();
    }

    @And("I enter {string} as part number")
    public void iEnterAsPartNumber(String partNr) {
        BrowserUtils.sleep(2);
        productPage.inputFieldsComponents(partNr);
    }

    @And("I enter {int} as lot size")
    public void iEnterAsLotSize(int lotSize) {
        BrowserUtils.sleep(3);
        productPage.lotSize(lotSize);
        BrowserUtils.sleep(1);
        productPage.addToList();
    }
    @And("I click on product module")
    public void i_click_on_product_module(){
        BrowserUtils.sleep(3);
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

    @And("I click on products module")
    public void iClickOnProductsModule() {
        Driver.getDriver().findElement(By.xpath("//a[.='Products']")).click();
    }
}
