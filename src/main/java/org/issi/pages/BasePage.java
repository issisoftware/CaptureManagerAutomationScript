package org.issi.pages;


import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.issi.constants.FrameworkConstants;
import org.issi.driver.DriverManager;
import org.issi.enums.WaitStrategy;
import org.issi.factory.ExplicitWaitFactory;
import org.issi.utilities.DynamicXpathUtils;
import org.issi.utilities.FrameworkConfig;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class BasePage {

    /**
     * Framework related Generic Methods
     *
     */

    public static FrameworkConfig configreader() {
        return ConfigFactory.create(FrameworkConfig.class);
    }

    public static Logger log() {
        Logger logger = Logger.getLogger("CaptureManager");
        PropertyConfigurator.configure(FrameworkConstants.getLoggerPath());
        return logger;
    }

    public static void clickOn(By by, WaitStrategy waitstrategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitstrategy);
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].click();", element);
        }
        log().info(" Clicked on " + elementName);

    }
    // to work on org.openqa.selenium.ElementClickInterceptedException i am writing this another click method using actions
    public static void clickOnAction(By by, WaitStrategy waitStrategy, String elementName) {
        Actions act = new Actions(DriverManager.getDriver());
        act.moveToElement(DriverManager.getDriver().findElement(by)).click().perform();
    }

    public static void enterText(By by, String value, WaitStrategy waitstrategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitstrategy);
        element.sendKeys(value);
        log().info("Entered " + elementName + " as " + value + "");
    }

    public static void clearText(By by, WaitStrategy waitStrategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        element.clear();
        log().info("cleared data from " + elementName);

    }

    public static String gettext(By by, WaitStrategy waitStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        return DriverManager.getDriver().findElement(by).getText();
    }

    public static String getAlertMessage() {
        Alert alert = DriverManager.getDriver().switchTo().alert();
        return alert.getText();
    }

    public static void selectFromDrpDwn(By by, WaitStrategy waitStrategy, String value, String elementName) {
        DriverManager.getDriver().findElement(by);
        WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        element.click();
        Select select = new Select(element);
        List<WebElement> allOptions = select.getOptions();
        for (int i = 0; i < allOptions.size(); i++) {
            WebElement option = allOptions.get(i);
            String optionValue = option.getText();
            if (optionValue.equalsIgnoreCase(value)) {
                select.selectByVisibleText(value);
                waitupto(200);
                break;
            }
        }
        log().info("selected  " + elementName + " as " + value);
    }

    public static void selectDate(By by, WaitStrategy waitStrategy) {
        DriverManager.getDriver().findElement(by);
        WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        element.click();

    }

    public static void scrollByElement(By by, WaitStrategy waitstrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitstrategy);
        element = DriverManager.getDriver().findElement(by);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();", element);
    }

    public static String switchToWindow(String previousWindowId) {
        Set<String> windowHandles = DriverManager.getDriver().getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!previousWindowId.equals(windowHandle)) {
                DriverManager.getDriver().switchTo().window(windowHandle);
            }
        }
        return DriverManager.getDriver().getWindowHandle();
    }

    public static void selectMenuItemDrpDwn(By by, String enterMenuItem) {
        List<WebElement> menuList = DriverManager.getDriver().findElements(by);
        try {
            for (int i = 0; i < menuList.size(); i++) {
                String menuItem = menuList.get(i).getText();
                if (menuItem.equals(enterMenuItem)) {
                    menuList.get(i).click();
                    System.out.println("Selected " + enterMenuItem + " option from menu");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mouseOver(By by, WaitStrategy waitstrategy, String elementName) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", DriverManager.getDriver().findElement(by));
            WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitstrategy);
        } catch (Exception e) {
            WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitstrategy);
            element = DriverManager.getDriver().findElement(by);
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(element).perform();
            System.out.println("Mouse overed on " + elementName + "");
        }
    }

    public static void waitupto(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getPage_Title() {
        return DriverManager.getDriver().getTitle();
    }

    public static String getFirstWord(String str){
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ')
            {
                return str.substring(0, i);
            }
        }
        return str;
    }

    /**
     * Project Related Generic Methods
     */
    private static final String tabheading = "//div[@role='tabpanel']/div/div[contains(text(),'%s')]";
    public static String tabHeading(String value){
        String newXpath = DynamicXpathUtils.getXpath(tabheading,value);
        return gettext(By.xpath(newXpath), WaitStrategy.PRESENCE);

    }

    private static final String heading = "//a[text()='%s']";
    public static String getHeading(String value){
        String newXpath = DynamicXpathUtils.getXpath(heading,value);
        return gettext(By.xpath(newXpath),WaitStrategy.PRESENCE);
    }

    private static final String windowheading = "//h5[text()='%s']";
    public static String getOpenWindowHeading(String value){
        String newXpath = DynamicXpathUtils.getXpath(windowheading,value);
        return gettext(By.xpath(newXpath),WaitStrategy.PRESENCE);
    }
}

