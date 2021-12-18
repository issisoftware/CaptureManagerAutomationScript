package org.issi.driver;

import org.issi.factory.DriverFactory;

import java.net.MalformedURLException;
import java.util.Objects;

public final class
Driver {
    private Driver() {
    }

    public static void initDriver(String browser) {

        if (Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser)); // if it is local you can invoke the browser in this way
            } catch (MalformedURLException e) {
                throw new RuntimeException("Browser Invocation was failed");
            }
        }

    }

    /**
     * Terminates the browser instance. Sets the threadlocal to default value, i.e null.
     */
    public static void quiteDriver() {

        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }

    }
}

