package org.issi.pages.MasterPage;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class RFPType extends BasePage {
    private RFPType() {
    }

    private static final By rfptypeoption = By.xpath("//a[@href='/rfptype']");
    public static void clickOnRfpTypeOption(){
        clickOn(rfptypeoption, WaitStrategy.CLICKABLE,"RFP type Option");
        waitupto(500);
    }

    private static final By addrfptypeink = By.xpath("//a[text()='Add RFP Type']");
    public static void clickOnAddRfpTypeLink(){
        clickOn(addrfptypeink,WaitStrategy.CLICKABLE,"Add RFP Type Link");
        waitupto(500);
    }

    private static final By rfptypesubmtbtn = By.xpath("//input[@class='btn btn-success']");
    public static void clickOnRfpTypeSubBtn(){
        clickOn(rfptypesubmtbtn,WaitStrategy.CLICKABLE,"RFP type Submit button");
        waitupto(500);
    }


    private static final By rfptypetext = By.xpath("//input[@name='sow_type']");
    public static void enterRfpTypeText(String depart){
        enterText(rfptypetext,depart,WaitStrategy.PRESENCE,"RFP Type");
        waitupto(500);
    }

    private static final By rfptypesearchtext = By.xpath("//input[@id='id_RFP_type']");
    public static void enterRfpTypeSearchInfo(String comp){
        enterText(rfptypesearchtext,comp,WaitStrategy.PRESENCE,"RFP Type search information");
        waitupto(500);
    }

    public static void clearRfpTypeText(){
        clearText(rfptypesearchtext,WaitStrategy.PRESENCE,"RFP Type");
        waitupto(500);
    }
    private static final By rfptypesearchresult = By.xpath("//table[@id='example']/tbody//td[3]");
    public static String rfpTypeSearchResult(){
        return gettext(rfptypesearchresult,WaitStrategy.VISIBLE);
    }

    private static final By rfptypedestext = By.xpath("//textarea[@id='id_description']");
    public static void enterRfpDesTypeText(String depart){
        enterText(rfptypedestext,depart,WaitStrategy.PRESENCE,"RFP Type Description");
        waitupto(500);
    }

    private static final By rfptypedessearchtext = By.xpath("//input[@id='id_Description']");
    public static void enterRfpTypeDesSearchInfo(String comp){
        enterText(rfptypedessearchtext,comp,WaitStrategy.PRESENCE,"RFP Type Description search information");
        waitupto(500);
    }

    public static void clearRfpTypeDesText(){
        clearText(rfptypedessearchtext,WaitStrategy.PRESENCE,"RFP Type Description");
        waitupto(500);
    }
    private static final By rfptypedessearchresult = By.xpath("//table[@id='example']/tbody//td[4]");
    public static String rfpTypeDesSearchResult(){
        return gettext(rfptypedessearchresult,WaitStrategy.VISIBLE);
    }
}
