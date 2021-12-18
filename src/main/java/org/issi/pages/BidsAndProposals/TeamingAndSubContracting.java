package org.issi.pages.BidsAndProposals;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class TeamingAndSubContracting extends BasePage {
    private TeamingAndSubContracting() {
    }

    private static final By teamingsubcontrtab = By.xpath("//a[@id='teamingsubcontracting-tab']");
    public static void clickOnTeamingAndSubContractingTab(){
        clickOn(teamingsubcontrtab,WaitStrategy.CLICKABLE,"Teaming And Sub Contracting Tab");
        waitupto(500);
    }

    private static final By addteamingandsublink = By.xpath("//a[text()='Add Teaming and Subcontracting']");
    public static void clickOnAddTeamingAndSubContLink(){
        clickOn(addteamingandsublink,WaitStrategy.CLICKABLE,"Add Teaming and Sub contacting link");
        waitupto(500);
    }

    private static final By idpartnerlin = By.xpath("//select[@id='id_partner']");
    public static void selectPartnerFrmDrpDwn(String value){
        selectFromDrpDwn(idpartnerlin,WaitStrategy.CLICKABLE,value,"Partner");
        waitupto(500);
    }

    private static final By contactinfo = By.xpath("//select[@id='id_contactinformation']");
    public static void selectContactinfoFrmDrpDwn(String value){
        selectFromDrpDwn(contactinfo,WaitStrategy.CLICKABLE,value,"Contact information");
        waitupto(500);
    }

    private static final By role =By.xpath("//select[@id='id_role']");
    public static void selectRoleFrmDrpDwn(String value){
        selectFromDrpDwn(role,WaitStrategy.CLICKABLE,value,"Role");
        waitupto(500);
    }

    private static final By responded =By.xpath("//select[@id='id_responded']");
    public static void selectRespondedFrmDrpDwn(String value){
        selectFromDrpDwn(responded,WaitStrategy.CLICKABLE,value,"Responded");
        waitupto(500);
    }

    private static final By workstartdate = By.xpath("//input[@id='id_workstartdate']");
    public static void enterWorkStartDate(String value){
        enterText(workstartdate,value,WaitStrategy.PRESENCE,"Work Start Date");
        waitupto(500);
    }

    private static final By workenddate = By.xpath("//input[@id='id_workenddate']");
    public static void enterWorkEndDate(String value){
        enterText(workenddate,value,WaitStrategy.PRESENCE,"Work End Date");
        waitupto(500);
    }

    private static final By percentageofwrk =By.xpath("//input[@id='id_percentageofwork']");
    public static void enterPercentageOfWrk(String value){
        enterText(percentageofwrk,value,WaitStrategy.PRESENCE,"Percentage of work");
        waitupto(500);
    }

    private static final By workshare =By.xpath("//textarea[@id='id_workshare']");
    public static void enterWorkShareText(String value){
        enterText(workshare,value,WaitStrategy.PRESENCE,"work share");
        waitupto(500);
    }

    private static final By rationale =By.xpath("//textarea[@id='id_rationale']");
    public static void enterRationaleText(String value){
        enterText(rationale,value,WaitStrategy.PRESENCE,"Rationale");
        waitupto(500);
    }

    private static final By comments =By.xpath("//textarea[@id='id_comments']");
    public static void enterCommentsText(String value){
        enterText(comments,value,WaitStrategy.PRESENCE,"Comments");
        waitupto(500);
    }

    private static final By teamingandsubcntsbtbtn =By.xpath("//input[@class='btn btn-success']");
    public static void clickOnTeamingSubContSbtBtn(){
        clickOn(teamingandsubcntsbtbtn,WaitStrategy.CLICKABLE,"Teaming Sub contracting sumbit button");
        waitupto(500);
    }

    private static final By teamingandsub = By.xpath("//button[@id='tsnexttab']");
    public static void clickOnTeamingAndSubNextBtn(){
        clickOn(teamingandsub,WaitStrategy.CLICKABLE,"Next button in Teaming And Subcontracting tab");
        waitupto(500);
    }
}
