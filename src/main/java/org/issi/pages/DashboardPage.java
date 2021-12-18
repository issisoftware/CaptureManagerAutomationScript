package org.issi.pages;

import org.issi.driver.DriverManager;
import org.issi.enums.WaitStrategy;
import org.issi.utilities.DynamicXpathUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public final class DashboardPage extends BasePage{
    protected DashboardPage() {
    }

    public static final By dashboarmenu = By.xpath("//a[contains(text(),'Dashboard')]");
    public static void clickOnDashboar(){
        clickOn(dashboarmenu, WaitStrategy.CLICKABLE,"Dashboard Menu");
        waitupto(500);
    }

    public static final By pageheading = By.xpath("//h1[contains(text(),'Dashboar')]");
    public static String dashboardHeading(){
        return gettext(pageheading,WaitStrategy.PRESENCE);
    }

    public static final By yeardrpdwn = By.xpath("//select[@id='year_id']");
    public static void selectYear(){
        selectFromDrpDwn(yeardrpdwn,WaitStrategy.CLICKABLE,"2021","Year");
        waitupto(500);
    }

    public static final By monthdrpdwn = By.xpath("//select[@id='month_id']");
    public static void selectMonth(){
        selectFromDrpDwn(monthdrpdwn,WaitStrategy.CLICKABLE,"October","Month");
        waitupto(500);
    }

    /**
     * Bid Status functionality
     */
    public static final String bidstatusvalue = "//table[@class='table table-bordered bidstatus-table']/tbody/tr//td[text()='%s']";
    public static void scrollToBidStatusValue(String BidStatus){
        String newXpath = DynamicXpathUtils.getXpath(bidstatusvalue,BidStatus);
        scrollByElement(By.xpath(newXpath),WaitStrategy.PRESENCE);
    }

    public static final String bidstatuswithcount = "//table[@class='table table-bordered bidstatus-table']/tbody/tr//td[text()='%s']/../td/a[contains(text(),'%s')]";
    public static void clickOnSpecificBidStatus(String BidStatus, String BidCount){
        String newXpath = DynamicXpathUtils.getXpath(bidstatuswithcount,BidStatus,BidCount);
        //scrollByElement(By.xpath(newXpath),WaitStrategy.PRESENCE);
        waitupto(500);
        clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE," Bid Status "+ BidStatus +", count value "+ BidCount);
    }

    /**
     * Bid Data window
     */
    public static final By biddatawindowheading = By.xpath("//h5[contains(text(),'Bid Data')]");
    public static String biddataHeading(){
        return gettext(biddatawindowheading,WaitStrategy.PRESENCE);
    }

    public static final By titlelink = By.xpath("//a[contains(text(),'OMEGA SYSTEMS Proposal')]");
    public static void clickOnTitle(){
        clickOn(titlelink,WaitStrategy.CLICKABLE,"OMEGA SYSTEMS Proposal");
        waitupto(500);
    }

    public static final By rfpandproposalheading = By.xpath("//h6[contains(text(),'Add New / Edit RFP and Proposals')]");
    public static String rfpPageHeading(){
        return gettext(rfpandproposalheading,WaitStrategy.PRESENCE);
    }

    /**
     * Bid Source functionality
     */
    public static final String bidsourcevalue = "//table[@class='table table-bordered bidsource-table']/tbody/tr//td[text()='%s']";
    public static void scrollToBidSourceValue(String BidSource){
        String newXpath = DynamicXpathUtils.getXpath(bidsourcevalue,BidSource);
        scrollByElement(By.xpath(newXpath),WaitStrategy.PRESENCE);
    }

    public static final String bidsourcewithcount = "//table[@class='table table-bordered bidsource-table']/tbody/tr//td[text()='%s']/../td/a[contains(text(),'%s')]";
    public static void clickOnSpecificBidSource(String BidSource, String BidCount){
        String newXpath = DynamicXpathUtils.getXpath(bidsourcewithcount,BidSource,BidCount);
        //scrollByElement(By.xpath(newXpath),WaitStrategy.PRESENCE);
        waitupto(500);
        clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE," Bid Source "+ BidSource +", count value "+ BidCount);
    }

    public static final By sourcetitle = By.xpath("//a[contains(text(),'Apple Dev Supp')]");
    public static void clickOnSourceTitle(){
        clickOn(sourcetitle,WaitStrategy.CLICKABLE,"Apple Dev Supp");
        waitupto(500);
    }

    /**
     * identified by functionality
     */
    public static final String bididentifiedbyvalue = "//table[@class='table table-bordered identified-table']/tbody/tr//td[text()='%s']";
    public static void scrollToIdentifiedbyValue(String BidIdentified){
        String newXpath = DynamicXpathUtils.getXpath(bididentifiedbyvalue,BidIdentified);
        scrollByElement(By.xpath(newXpath),WaitStrategy.PRESENCE);
    }

    public static final String bididentifiedbywithcount = "//table[@class='table table-bordered identified-table']/tbody/tr//td[text()='%s']/../td/a[contains(text(),'%s')]";
    public static void clickOnSpecificBidIdentified(String BidIdentified, String BidCount){
        String newXpath = DynamicXpathUtils.getXpath(bididentifiedbywithcount,BidIdentified,BidCount);
        //scrollByElement(By.xpath(newXpath),WaitStrategy.PRESENCE);
        waitupto(500);
        clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE," Bid Identified by "+ BidIdentified +", count value "+ BidCount);
    }

    public static final By identifiedtitle = By.xpath("//a[contains(text(),'ebs')]");
    public static void clickOnIdentifiedByTitle(){
        clickOn(identifiedtitle,WaitStrategy.CLICKABLE,"ebs");
        waitupto(500);
    }

    /**
     * Contract Type functionality
     */

    public static final String bidcontracttypevalue = "//table[@class='table table-bordered contracttype-table']/tbody/tr//td[text()='%s']";
    public static void scrollToContractTypeValue(String BidContractType){
        String newXpath = DynamicXpathUtils.getXpath(bidcontracttypevalue,BidContractType);
        scrollByElement(By.xpath(newXpath),WaitStrategy.PRESENCE);
    }

    public static final String bidcontracttypecount = "//table[@class='table table-bordered contracttype-table']/tbody/tr//td[text()='%s']/../td/a[contains(text(),'%s')]";
    public static void clickOnSpecificBidcontracttype(String Bidcontracttype, String BidCount){
        String newXpath = DynamicXpathUtils.getXpath(bidcontracttypecount,Bidcontracttype,BidCount);
        //scrollByElement(By.xpath(newXpath),WaitStrategy.PRESENCE);
        waitupto(500);
        clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE," Bid contract type "+ Bidcontracttype +", count value "+ BidCount);
    }

    public static final By contracttypetitle = By.xpath("//a[contains(text(),'ibts - ARMS project')]");
    public static void clickOnContractTypeTitle(){
        clickOn(contracttypetitle,WaitStrategy.CLICKABLE,"ibts - ARMS project");
        waitupto(500);
    }

    /**
     * Set Aside
     */
    public static final String bidsetasidevalue = "//table[@class='table table-bordered setaside-table']/tbody/tr//td[text()='%s']";
    public static void scrollToSetAsideValue(String BidSetAside){
        String newXpath = DynamicXpathUtils.getXpath(bidsetasidevalue,BidSetAside);
        scrollByElement(By.xpath(newXpath),WaitStrategy.PRESENCE);
    }

    public static final String bidsetasidecount = "//table[@class='table table-bordered setaside-table']/tbody/tr//td[text()='%s']/../td/a[contains(text(),'%s')]";
    public static void clickOnSpecificBidsetaside(String Bidsetaside, String BidCount){
        String newXpath = DynamicXpathUtils.getXpath(bidsetasidecount,Bidsetaside,BidCount);
        //scrollByElement(By.xpath(newXpath),WaitStrategy.PRESENCE);
        waitupto(500);
        clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE," Bid contract type "+ Bidsetaside +", count value "+ BidCount);
    }

    public static final By setasidetitle = By.xpath("//a[contains(text(),'Telenor systems capture proposal')]");
    public static void clickOnSetAsideTitle(){
        clickOn(setasidetitle,WaitStrategy.CLICKABLE,"Telenor systems capture proposal");
        waitupto(500);
    }
}
