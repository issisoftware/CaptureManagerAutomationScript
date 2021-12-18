package org.issi.pages.MasterPage;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class BidSources extends BasePage {
    private BidSources() {
    }

    private static final By bidsourceoption = By.xpath("//div[@id='collapsibleNavbar']/ul/li[3]/div/a[6]");
    public static void clickOnBidSourceOption(){
        clickOn(bidsourceoption, WaitStrategy.CLICKABLE," Bid Source Option");
        waitupto(500);
    }

    private static final By addbidsourceslink = By.xpath("//a[text()='Add Bid Source']");
    public static void clickOnAddBidSourcesLink(){
        clickOn(addbidsourceslink,WaitStrategy.CLICKABLE,"Add Bid Sources");
        waitupto(500);
    }

    private static final By bidsourcessubmtbtn = By.xpath("//input[@class='btn btn-success']");
    public static void clickOnBidSourcesSubBtn(){
        clickOn(bidsourcessubmtbtn,WaitStrategy.CLICKABLE,"Bid Sources submit button");
        waitupto(500);
    }


    private static final By bidsourcestext = By.xpath("//input[@name='bid_source']");
    public static void enterBidSources(String BidSoruces){
        enterText(bidsourcestext,BidSoruces,WaitStrategy.PRESENCE,"Bid Sources");
        waitupto(500);
    }

    private static final By bidsourcedescription = By.xpath("//textarea[@id='id_description']");
    public static void enterBidSourcesDes(String BidRecommendationDes){
        enterText(bidsourcedescription,BidRecommendationDes,WaitStrategy.PRESENCE,"Bid Source Description");
        waitupto(500);
    }

    private static final By bidsourcessearchtext = By.xpath("//input[@id='id_bid_sources']");
    public static void enterBidSourceSearchInfo(String BidSource){
        enterText(bidsourcessearchtext,BidSource,WaitStrategy.PRESENCE,"Bid Source search information");
        waitupto(500);
    }
    public static void clearBidSourceText(){
        clearText(bidsourcessearchtext,WaitStrategy.PRESENCE,"Bid Source text");
        waitupto(500);
    }
    private static final By bidsourcesearchresult = By.xpath("//table[@id='example']/tbody//td[3]");
    public static String bidSourcesSearchResult(){
        return gettext(bidsourcesearchresult,WaitStrategy.VISIBLE);
    }

    private static final By bidsorucedesctext = By.xpath("//input[@id='id_description']");
    public static void enterBidSourceDescription(String BidSoruceDec){
        enterText(bidsorucedesctext,BidSoruceDec,WaitStrategy.PRESENCE,"Bid Sources description search information");
        waitupto(500);
    }

    public static void clearBidSourceDes(){
        clearText(bidsorucedesctext,WaitStrategy.PRESENCE,"Bid Sources description text");
        waitupto(500);
    }
    private static final By bidsourcedessearchresult = By.xpath("//table[@id='example']/tbody//td[4]");
    public static String bidSourceDesSearchResult(){
        return gettext(bidsourcedessearchresult,WaitStrategy.VISIBLE);
    }

}
