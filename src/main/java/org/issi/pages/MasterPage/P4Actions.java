package org.issi.pages.MasterPage;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class P4Actions extends BasePage {
    private P4Actions() {
    }

    private static final By p4actionsoption = By.xpath("//div[@id='collapsibleNavbar']/ul/li[3]/div/a[15]");
    public static void clickOnP4ActionsOption(){
        clickOn(p4actionsoption, WaitStrategy.CLICKABLE,"P4 Actions Option");
        waitupto(500);
    }

    private static final By addp4actionsink = By.xpath("//a[text()='Add P4 Actions']");
    public static void clickOnAddp4ActionsLink(){
        clickOn(addp4actionsink,WaitStrategy.CLICKABLE,"Add P4 Actions code Link");
        waitupto(500);
    }

    private static final By p4actionssubmtbtn = By.xpath("//input[@class='btn btn-success']");
    public static void clickOnp4ActionSubBtn(){
        clickOn(p4actionssubmtbtn,WaitStrategy.CLICKABLE,"P4 Actions Submit button");
        waitupto(500);
    }


    private static final By p4actionstext = By.xpath("//input[@name='actionnamep4']");
    public static void enterp4ActionsText(String depart){
        enterText(p4actionstext,depart,WaitStrategy.PRESENCE,"P4 Actions");
        waitupto(500);
    }

    private static final By p4actionsdescriptiontext = By.xpath("//textarea[@name='actiondescription']");
    public static void enterP4ActionsDescriptionText(String depart){
        enterText(p4actionsdescriptiontext,depart,WaitStrategy.PRESENCE,"P4 Actions Description");
        waitupto(500);
    }

    private static final By p4actionssearchtext = By.xpath("//input[@id='id_P4_action']");
    public static void enterP4ActionsSearchInfo(String comp){
        enterText(p4actionssearchtext,comp,WaitStrategy.PRESENCE,"P4 Actions search information");
        waitupto(500);
    }

    public static void clearP4ActionsText(){
        clearText(p4actionssearchtext,WaitStrategy.PRESENCE,"P4 Actions");
        waitupto(500);
    }
    private static final By p4actionssearchresult = By.xpath("//table[@id='example']/tbody//td[3]");
    public static String p4ActionsSearchResult(){
        return gettext(p4actionssearchresult,WaitStrategy.VISIBLE);
    }

    private static final By p4actionsdessearchtext = By.xpath("//input[@id='id_description']");
    public static void enterP4ActionsDescrptionSearchInfo(String comp){
        enterText(p4actionsdessearchtext,comp,WaitStrategy.PRESENCE,"P4 Actions description search information");
        waitupto(500);
    }

    public static void clearP4ActionsDesSearchText(){
        clearText(p4actionsdessearchtext,WaitStrategy.PRESENCE,"P4 Actionsdescription text");
        waitupto(500);
    }
    private static final By p4actionsdessearchresult = By.xpath("//table[@id='example']/tbody//td[4]");
    public static String p4ActionsDesSearchResult(){
        return gettext(p4actionsdessearchresult,WaitStrategy.VISIBLE);
    }


}
