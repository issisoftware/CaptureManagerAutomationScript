package org.issi.pages.MasterPage;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class P4Status extends BasePage {
    private P4Status() {
    }

    private static final By p4stausoption = By.xpath("//div[@id='collapsibleNavbar']/ul/li[3]/div/a[16]");
    public static void clickOnP4StatuaOption(){
        clickOn(p4stausoption, WaitStrategy.CLICKABLE,"P4 Status Option");
        waitupto(500);
    }

    private static final By addp4statusink = By.xpath("//a[text()='Add P4 Status']");
    public static void clickOnAddp4StatusLink(){
        clickOn(addp4statusink,WaitStrategy.CLICKABLE,"Add P4 Status code Link");
        waitupto(500);
    }

    private static final By p4statussubmtbtn = By.xpath("//input[@class='btn btn-success']");
    public static void clickOnp4StatusSubBtn(){
        clickOn(p4statussubmtbtn,WaitStrategy.CLICKABLE,"P4 Status Submit button");
        waitupto(500);
    }


    private static final By p4statustext = By.xpath("//input[@name='statusnamep4']");
    public static void enterp4StatusText(String depart){
        enterText(p4statustext,depart,WaitStrategy.PRESENCE,"P4 Status");
        waitupto(500);
    }

    private static final By p4statusdescriptiontext = By.xpath("//textarea[@name='statusdescription']");
    public static void enterP4StatusDescriptionText(String depart){
        enterText(p4statusdescriptiontext,depart,WaitStrategy.PRESENCE,"P4 Status Description");
        waitupto(500);
    }

    private static final By p4statussearchtext = By.xpath("//input[@id='id_P4_status']");
    public static void enterP4StatusSearchInfo(String comp){
        enterText(p4statussearchtext,comp,WaitStrategy.PRESENCE,"P4 Status search information");
        waitupto(500);
    }

    public static void clearP4StatusText(){
        clearText(p4statussearchtext,WaitStrategy.PRESENCE,"P4 Status");
        waitupto(500);
    }
    private static final By p4statussearchresult = By.xpath("//table[@id='example']/tbody//td[3]");
    public static String p4StatusSearchResult(){
        return gettext(p4statussearchresult,WaitStrategy.VISIBLE);
    }

    private static final By p4statusdessearchtext = By.xpath("//input[@id='id_Description']");
    public static void enterP4StatusDescrptionSearchInfo(String comp){
        enterText(p4statusdessearchtext,comp,WaitStrategy.PRESENCE,"P4 Status description search information");
        waitupto(500);
    }

    public static void clearP4StatusDesSearchText(){
        clearText(p4statusdessearchtext,WaitStrategy.PRESENCE,"P4 Status description text");
        waitupto(500);
    }
    private static final By p4statusdessearchresult = By.xpath("//table[@id='example']/tbody//td[4]");
    public static String p4StatusDesSearchResult(){
        return gettext(p4statusdessearchresult,WaitStrategy.VISIBLE);
    }


}
