package org.issi.pages;

import org.issi.enums.WaitStrategy;
import org.openqa.selenium.By;

/**
 * Making this class as final to avoid multiple inheritance (or) not to extend this class
 * and extending Base page to utilize reusable methods
 */
public final class LoginPage extends BasePage {
    /**
     * Creating private constructor to restrict on creating object for this login page class
     */
    private LoginPage() {
    }

    //identifying the elements in login page using 'By' locator
    private static final By loginUsernameText = By.xpath("//input[@id='username']");
    private static final By loginPasswordText = By.xpath("//input[@id='password']");
    private static final By loginBtn = By.xpath("//input[@id='loginbtn']");

    // Action methods for elements identified
    public static void enterUserName(String usrnm) {
        enterText(loginUsernameText, usrnm, WaitStrategy.PRESENCE, "Login username");
        waitupto(500);
    }

    public static void enterPassword(String pwd) {
        enterText(loginPasswordText, pwd, WaitStrategy.PRESENCE, "Login Password");
        waitupto(500);
    }

    public static void clickOnLogin() {
        clickOn(loginBtn, WaitStrategy.CLICKABLE, "Login Button");
        waitupto(500);
    }


    public static DashboardPage doLogin(String un, String pwd) {
        enterUserName(un);
        enterPassword(pwd);
        clickOnLogin();
        return new DashboardPage();
    }

    /**
     *  invalid login element
     */
    private static final By errormessage = By.xpath("//div[@class='inlogin']/h6/strong");

    public static String actualErrorMessage(){
        return gettext(errormessage,WaitStrategy.PRESENCE);
    }

}
