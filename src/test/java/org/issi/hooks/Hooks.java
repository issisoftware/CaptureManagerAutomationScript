package org.issi.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.issi.driver.Driver;
import org.issi.driver.DriverManager;
import org.issi.pages.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends BasePage {

    @Before(order = 1)
    public void launchBrowser() {
       // Driver.initDriver(PropertyUtils.getValue(ConfigProperties.BROWSER));
        Driver.initDriver(configreader().browser());
       // log().info(PropertyUtils.getValue(ConfigProperties.BROWSER) + " was started successfully");
        log().info(configreader().browser() + " was started successfully");
        DriverManager.getDriver().manage().window().maximize(); // maximizing the browser window.

    }

    @After(order = 0)
    public void quitBrowser() {
        waitupto(500);
        Driver.quiteDriver();
        //log().info(PropertyUtils.getValue(ConfigProperties.BROWSER) + " was closed successfully");
        log().info(configreader().browser() + " was closed successfully");
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }
}
