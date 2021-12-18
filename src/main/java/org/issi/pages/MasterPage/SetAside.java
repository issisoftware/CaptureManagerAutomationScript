package org.issi.pages.MasterPage;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class SetAside extends BasePage {
    private SetAside() {
    }

    private static final By setasideoption = By.xpath("//a[@href='/setaside']");
    public static void clickOnSetAsideOption(){
        clickOn(setasideoption, WaitStrategy.CLICKABLE,"Set Aside Option");
        waitupto(500);
    }

    private static final By addsetasidelink = By.xpath("//a[text()='Add Set Aside']");
    public static void clickOnAddSetAsideLink(){
        clickOn(addsetasidelink,WaitStrategy.CLICKABLE,"Add Set Aside Link");
        waitupto(500);
    }

    private static final By setasidesubmtbtn = By.xpath("//input[@class='btn btn-success']");
    public static void clickOnSetAsideSubBtn(){
        clickOn(setasidesubmtbtn,WaitStrategy.CLICKABLE,"Set Aside Submit button");
        waitupto(500);
    }


    private static final By setasidetext = By.xpath("//input[@name='set_aside']");
    public static void enterSetAsideText(String depart){
        enterText(setasidetext,depart,WaitStrategy.PRESENCE,"Set Aside");
        waitupto(500);
    }

    private static final By setasidesearchtext = By.xpath("//input[@id='id_Set_aside']");
    public static void enterSetAsideSearchInfo(String comp){
        enterText(setasidesearchtext,comp,WaitStrategy.PRESENCE,"Set Aside search information");
        waitupto(500);
    }

    public static void clearSetAsideText(){
        clearText(setasidesearchtext,WaitStrategy.PRESENCE,"Set Aside");
        waitupto(500);
    }
    private static final By setasidesearchresult = By.xpath("//table[@id='example']/tbody//td[3]");
    public static String setAsideSearchResult(){
        return gettext(setasidesearchresult,WaitStrategy.VISIBLE);
    }

    private static final By setasdiedestext = By.xpath("//textarea[@id='id_description']");
    public static void enterSetAsideDesText(String depart){
        enterText(setasdiedestext,depart,WaitStrategy.PRESENCE,"Set Aside Description");
        waitupto(500);
    }

    private static final By setasidedessearchtext = By.xpath("//input[@id='id_Description']");
    public static void enterSetAsideDesSearchInfo(String comp){
        enterText(setasidedessearchtext,comp,WaitStrategy.PRESENCE,"Set Aside Description search information");
        waitupto(500);
    }

    public static void clearSetAsideDesText(){
        clearText(setasidedessearchtext,WaitStrategy.PRESENCE,"Set Aside Description");
        waitupto(500);
    }
    private static final By setasidedessearchresult = By.xpath("//table[@id='example']/tbody//td[4]");
    public static String setasideDesSearchResult(){
        return gettext(setasidedessearchresult,WaitStrategy.VISIBLE);
    }
}
