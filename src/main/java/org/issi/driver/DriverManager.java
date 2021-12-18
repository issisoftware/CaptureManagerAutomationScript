package org.issi.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private DriverManager() {
    }
    /**
     * Creating Thread local variable to avoid issue on parallel execution
     * Here we created Thread local variable for Webdriver reference/generic
     */
    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    /**
     *  'get Driver' method returns the thread safe WebDriver instance fetched from ThreadLocal variable.
     */
    public static WebDriver getDriver(){
        return dr.get();
    }

    /**
     * Assigning WebDriver instance to thread local variable
     */
    public static void setDriver(WebDriver driverref){
        dr.set(driverref);
    }

    /**
     * we can set the default value to Threadlocal variable using this 'remove()'.
     *  It is much safer than assigning null value to ThreadLocal variable.
     */
    public static void unload(){
        dr.remove();
    }
}
