package com.ims.step_definitions;

import com.ims.pages.LoginPage;
import com.ims.utilities.BrowserUtils;
import com.ims.utilities.ConfigurationReader;
import com.ims.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {


    @BeforeAll
    public static void before_or_after_all() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.loginEmail();
        loginPage.loginPassword();
    }

    @After
    public void tearDownScenario (Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] image = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(image, "image/png", scenario.getName());
        }

    }
}
