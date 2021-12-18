package org.issi.pages.MasterPage;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class RequirementType extends BasePage {
    private RequirementType() {
    }

    private static final By reqtypeoption = By.xpath("//a[@href='/requirementtype']");
    public static void clickOnReqTypeOption(){
        clickOn(reqtypeoption, WaitStrategy.CLICKABLE,"Requirement type Option");
        waitupto(500);
    }

    private static final By addreqtypeink = By.xpath("//a[text()='Add Requirement Type']");
    public static void clickOnAddReqTypeLink(){
        clickOn(addreqtypeink,WaitStrategy.CLICKABLE,"Add Requirement Type Link");
        waitupto(500);
    }

    private static final By reqtypesubmtbtn = By.xpath("//input[@class='btn btn-success']");
    public static void clickOnReqTypeSubBtn(){
        clickOn(reqtypesubmtbtn,WaitStrategy.CLICKABLE,"Requirement type Submit button");
        waitupto(500);
    }


    private static final By reqtypetext = By.xpath("//input[@name='requirment_type']");
    public static void enterReqTypeText(String depart){
        enterText(reqtypetext,depart,WaitStrategy.PRESENCE,"Requirement Type");
        waitupto(500);
    }

    private static final By reqtypesearchtext = By.xpath("//input[@id='id_requirement_type']");
    public static void enterReqTypeSearchInfo(String comp){
        enterText(reqtypesearchtext,comp,WaitStrategy.PRESENCE,"Requirement Type search information");
        waitupto(500);
    }

    public static void clearReqTypeText(){
        clearText(reqtypesearchtext,WaitStrategy.PRESENCE,"Requirement Type");
        waitupto(500);
    }
    private static final By reqtypesearchresult = By.xpath("//table[@id='example']/tbody//td[3]");
    public static String reqTypeSearchResult(){
        return gettext(reqtypesearchresult,WaitStrategy.VISIBLE);
    }

    private static final By reqtypedestext = By.xpath("//textarea[@id='id_description']");
    public static void enterReqDesTypeText(String depart){
        enterText(reqtypedestext,depart,WaitStrategy.PRESENCE,"Requirement Type Description");
        waitupto(500);
    }

    private static final By reqtypedessearchtext = By.xpath("//input[@id='id_Description']");
    public static void enterReqTypeDesSearchInfo(String comp){
        enterText(reqtypedessearchtext,comp,WaitStrategy.PRESENCE,"Requirement Type Description search information");
        waitupto(500);
    }

    public static void clearReqTypeDesText(){
        clearText(reqtypedessearchtext,WaitStrategy.PRESENCE,"Requirement Type Description");
        waitupto(500);
    }
    private static final By reqtypedessearchresult = By.xpath("//table[@id='example']/tbody//td[4]");
    public static String reqTypeDesSearchResult(){
        return gettext(reqtypedessearchresult,WaitStrategy.VISIBLE);
    }
}
