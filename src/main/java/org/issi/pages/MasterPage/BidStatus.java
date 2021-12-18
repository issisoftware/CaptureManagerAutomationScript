package org.issi.pages.MasterPage;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class BidStatus extends BasePage {
    private BidStatus() {
    }

    private static final By bidstatusoption = By.xpath("//div[@id='collapsibleNavbar']/ul/li[3]/div/a[8]");
    public static void clickOnBidStatusOption(){
        clickOn(bidstatusoption, WaitStrategy.CLICKABLE," Bid Status Option");
        waitupto(500);
    }

    private static final By addbidstatuslink = By.xpath("//a[text()='Add Bid Status']");
    public static void clickOnAddBidStatusLink(){
        clickOn(addbidstatuslink,WaitStrategy.CLICKABLE,"Add Bid Status Link");
        waitupto(500);
    }

    private static final By bidstatustypesubmtbtn = By.xpath("//input[@class='btn btn-success']");
    public static void clickOnBidStatusSubBtn(){
        clickOn(bidstatustypesubmtbtn,WaitStrategy.CLICKABLE,"Bid Status submit button");
        waitupto(500);
    }


    private static final By bidstatustext = By.xpath("//input[@name='bid_status']");
    public static void enterBidStatus(String BidStatus){
        enterText(bidstatustext,BidStatus,WaitStrategy.PRESENCE,"Bid Status");
        waitupto(500);
    }

    private static final By bidstatusdes = By.xpath("//textarea[@id='id_description']");
    public static void enterBidStatusDes(String BidStatusDes){
        enterText(bidstatusdes,BidStatusDes,WaitStrategy.PRESENCE,"Bid status Description");
        waitupto(500);
    }

    private static final By bidstatussearchtext = By.xpath("//input[@id='id_bid_status']");
    public static void enterBidStatusSearchInfo(String BidType){
        enterText(bidstatussearchtext,BidType,WaitStrategy.PRESENCE,"Bid Status search information");
        waitupto(500);
    }
    public static void clearBidStatusText(){
        clearText(bidstatussearchtext,WaitStrategy.PRESENCE,"Bid Status text");
        waitupto(500);
    }
    private static final By bidstatussearchresult = By.xpath("//table[@id='example']/tbody//td[3]");
    public static String bidStatusSearchResult(){
        return gettext(bidstatussearchresult,WaitStrategy.VISIBLE);
    }

    private static final By bidstatusdesctext = By.xpath("//input[@id='id_description']");
    public static void enterBidStatusDescription(String BidTypeDes){
        enterText(bidstatusdesctext,BidTypeDes,WaitStrategy.PRESENCE,"Bid status description search information");
        waitupto(500);
    }

    public static void clearBidStatusDes(){
        clearText(bidstatusdesctext,WaitStrategy.PRESENCE,"Bid status description text");
        waitupto(500);
    }
    private static final By bidstatusdessearchresult = By.xpath("//table[@id='example']/tbody//td[4]");
    public static String bidStatusDesSearchResult(){
        return gettext(bidstatusdessearchresult,WaitStrategy.VISIBLE);
    }

}
