package org.issi.pages.BidsAndProposals;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class CapturePlanTab extends BasePage {
    private CapturePlanTab() {
    }

    private static final By captureplantablink = By.xpath("//a[@id='captureplan-tab']");
    public static void clickOnCapturePlanTab(){
        clickOn(captureplantablink, WaitStrategy.CLICKABLE,"Captuer Plan Tab");
        waitupto(500);
    }

    private static final By capturenametext = By.xpath("//textarea[@id='id_title']");
    public static void enterCaptureNameText(String capturename){
        enterText(capturenametext,capturename,WaitStrategy.PRESENCE,"Capture Name");
        waitupto(500);
    }

    private static final By soliciationidtext = By.xpath("//input[@id='id_rfq_rfp_number']");
    public static void enterSoliciationIDText(String soliciationid){
        enterText(soliciationidtext,soliciationid,WaitStrategy.PRESENCE,"Soliciation id");
        waitupto(500);
    }

    private static final By issidrpdwn = By.xpath("//select[@name='issi']");
    public static void selectIssIDrpDwn(String value){
        selectFromDrpDwn(issidrpdwn,WaitStrategy.CLICKABLE,value,"PRIME");
        waitupto(500);
    }

    private static final By bidsourcetypedrpdwn = By.xpath("//select[@name='bidtype']");
    public static void selectBidSourceTypeDrpDwn(String value){
        selectFromDrpDwn(bidsourcetypedrpdwn,WaitStrategy.CLICKABLE,value,"Bid Source Type");
        waitupto(500);
    }

    private static final By bidsourcedrpdwn = By.xpath("//select[@name='source']");
    public static void selectBidSourceDrpDwn(String value){
        selectFromDrpDwn(bidsourcedrpdwn,WaitStrategy.CLICKABLE,value,"Bid Source");
        waitupto(500);
    }

    private static final By datepostedText = By.xpath("//input[@name='bid_date']");
    public static void enterDatePostedDate(String value){
        enterText(datepostedText,value,WaitStrategy.PRESENCE,"Date posted");
        waitupto(500);
    }

    private static final By naicscodedrpdwn = By.xpath("//select[@name='naicscode']");
    public static void selectNaicsCodeDrpDwn(String value){
        selectFromDrpDwn(naicscodedrpdwn,WaitStrategy.CLICKABLE,value,"NAICS Code");
        waitupto(500);
    }

    private static final By agencydrpdwn = By.xpath("//select[@name='agency']");
    public static void selectAgencyDrpDwn(String value){
        selectFromDrpDwn(agencydrpdwn,WaitStrategy.CLICKABLE,value,"Agency");
        waitupto(500);
    }

    private static final By bidstatusdrpdwn = By.xpath("//select[@name='bidstatus']");
    public static void selectBidStatusDrpDwn(String value){
        selectFromDrpDwn(bidstatusdrpdwn,WaitStrategy.CLICKABLE,value,"Bid Staus");
        waitupto(500);
    }

    private static final By identifiedbydrpdwn = By.xpath("//select[@name='analysisby']");
    public static void selectIdentifiedByDrpDwn(String value){
        selectFromDrpDwn(identifiedbydrpdwn,WaitStrategy.CLICKABLE,value,"Identified by");
        waitupto(500);
    }

    private static final By duedatetext = By.xpath("//input[@name='bid_duedate']");
    public static void enterDueDateText(String value){
        enterText(duedatetext,value,WaitStrategy.PRESENCE,"Due Date");
        waitupto(500);
    }

    private static final By captureplansavebtn = By.xpath("//button[@id='save']");
    public static void clickOnCapturePlanSaveBtn(){
        clickOn(captureplansavebtn,WaitStrategy.CLICKABLE,"Capture plan tab save button");
        waitupto(500);
    }

    private static final By confirmtext = By.xpath("//div[@class='swal-text']");
    public static String getConfirmText(){
        return gettext(confirmtext,WaitStrategy.PRESENCE);
    }

    private static final By nextbtnincaptureplantab = By.xpath("//button[@id='nexttab']");
    public static void clickOnNextBtnInCapTab(){

        clickOn(nextbtnincaptureplantab, WaitStrategy.CLICKABLE,"Captureplan Next button");
        waitupto(500);
    }
}
