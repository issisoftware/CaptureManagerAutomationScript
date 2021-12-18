package org.issi.pages.MasterPage;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class NewOrRecompete extends BasePage {
    private NewOrRecompete() {
    }

    private static final By neworrecompeteoption = By.xpath("//div[@id='collapsibleNavbar']/ul/li[3]/div/a[14]");
    public static void clickOnNewOrRecompeteOption(){
        clickOn(neworrecompeteoption, WaitStrategy.CLICKABLE,"New Or Recompete Option");
        waitupto(500);
    }

    private static final By addneworrecompeteink = By.xpath("//a[text()='Add New or Recompete']");
    public static void clickOnAddNewOrRecompeteLink(){
        clickOn(addneworrecompeteink,WaitStrategy.CLICKABLE,"Add New or Recompete code Link");
        waitupto(500);
    }

    private static final By neworrecompetesubmtbtn = By.xpath("//input[@class='btn btn-success']");
    public static void clickOnNewOrRecompeteSubBtn(){
        clickOn(neworrecompetesubmtbtn,WaitStrategy.CLICKABLE,"New Or Recompete Submit button");
        waitupto(500);
    }


    private static final By typetext = By.xpath("//input[@name='type']");
    public static void enterTypeText(String depart){
        enterText(typetext,depart,WaitStrategy.PRESENCE,"Type");
        waitupto(500);
    }

    private static final By descriptiontext = By.xpath("//textarea[@name='description']");
    public static void enterDescriptionText(String depart){
        enterText(descriptiontext,depart,WaitStrategy.PRESENCE,"New Or Recompete Description");
        waitupto(500);
    }

    private static final By typesearchtext = By.xpath("//input[@id='id_Type']");
    public static void enterTypeSearchInfo(String comp){
        enterText(typesearchtext,comp,WaitStrategy.PRESENCE,"New Or Recompete Type search information");
        waitupto(500);
    }

    public static void clearTypeSearchText(){
        clearText(typesearchtext,WaitStrategy.PRESENCE,"Type text");
        waitupto(500);
    }
    private static final By typesearchresult = By.xpath("//table[@id='example']/tbody//td[3]");
    public static String typeSearchResult(){
        return gettext(typesearchresult,WaitStrategy.VISIBLE);
    }

    private static final By dessearchtext = By.xpath("//input[@id='id_description']");
    public static void enterDescrptionSearchInfo(String comp){
        enterText(dessearchtext,comp,WaitStrategy.PRESENCE,"New Or Recompete description search information");
        waitupto(500);
    }

    public static void clearDesSearchText(){
        clearText(dessearchtext,WaitStrategy.PRESENCE,"description text");
        waitupto(500);
    }
    private static final By dessearchresult = By.xpath("//table[@id='example']/tbody//td[4]");
    public static String descriptionSearchResult(){
        return gettext(dessearchresult,WaitStrategy.VISIBLE);
    }


}
