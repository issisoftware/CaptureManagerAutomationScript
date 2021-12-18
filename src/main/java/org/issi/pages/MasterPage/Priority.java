package org.issi.pages.MasterPage;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class Priority extends BasePage {
    private Priority() {
    }

    private static final By priorityoption = By.xpath("//div[@id='collapsibleNavbar']/ul/li[3]/div/a[17]");
    public static void clickOnPriorityOption(){
        clickOn(priorityoption, WaitStrategy.CLICKABLE,"priority Option");
        waitupto(500);
    }

    private static final By addpriorityink = By.xpath("//a[text()='Add Priority']");
    public static void clickOnAddPriorityLink(){
        clickOn(addpriorityink,WaitStrategy.CLICKABLE,"Add Priority code Link");
        waitupto(500);
    }

    private static final By prioritysubmtbtn = By.xpath("//input[@class='btn btn-success']");
    public static void clickOnPrioritySubBtn(){
        clickOn(prioritysubmtbtn,WaitStrategy.CLICKABLE,"Priority Submit button");
        waitupto(500);
    }


    private static final By prioritytext = By.xpath("//input[@name='priority']");
    public static void enterpriorityText(String depart){
        enterText(prioritytext,depart,WaitStrategy.PRESENCE,"priority");
        waitupto(500);
    }

    private static final By prioritysearchtext = By.xpath("//input[@id='id_priority']");
    public static void enterPrioritySearchInfo(String comp){
        enterText(prioritysearchtext,comp,WaitStrategy.PRESENCE,"priority search information");
        waitupto(500);
    }

    public static void clearPriorityText(){
        clearText(prioritysearchtext,WaitStrategy.PRESENCE,"Priority");
        waitupto(500);
    }
    private static final By prioritysearchresult = By.xpath("//table[@id='example']/tbody//td[3]");
    public static String prioritySearchResult(){
        return gettext(prioritysearchresult,WaitStrategy.VISIBLE);
    }

}
