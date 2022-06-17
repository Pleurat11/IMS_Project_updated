package com.ims.step_definitions;

import com.ims.pages.BasePage;
import com.ims.pages.LocationsPage;
import com.ims.pages.LoginPage;
import com.ims.utilities.BrowserUtils;
import com.ims.utilities.ConfigurationReader;
import com.ims.utilities.Driver;
import org.junit.Test;

public class GetData_UAT extends BasePage {
    LoginPage loginPage = new LoginPage();
    LocationsPage locations = new LocationsPage();

    @Test
    public void readLocationsTable(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginEmail();
        loginPage.loginPassword();
        BrowserUtils.sleep(2);
        locationsModule.click();
        BrowserUtils.sleep(3);
        locations.readLocationTable();

    }
    @Test
    public void readVendorsTable(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginEmail();
        loginPage.loginPassword();
        BrowserUtils.sleep(2);
        vendorsModule.click();
        BrowserUtils.sleep(3);
        locations.readLocationTable();
    }

    @Test
    public void readCustomersTable(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginEmail();
        loginPage.loginPassword();
        BrowserUtils.sleep(2);
        customersModule.click();
        BrowserUtils.sleep(3);
        locations.readLocationTable();
    }
    @Test
    public void readComponentsTable(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginEmail();
        loginPage.loginPassword();
        BrowserUtils.sleep(2);
        catalogModule.click();
        BrowserUtils.sleep(1);
        componentsModule.click();
        BrowserUtils.sleep(3);
        locations.readLocationTable();
    }
}
