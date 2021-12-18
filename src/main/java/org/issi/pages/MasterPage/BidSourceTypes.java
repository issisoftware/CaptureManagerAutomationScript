package org.issi.pages.MasterPage;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class BidSourceTypes extends BasePage {
    private BidSourceTypes() {
    }

    private static final By bidsourcetypeoption = By.xpath("//div[@id='collapsibleNavbar']/ul/li[3]/div/a[7]");
    public static void clickOnBidSourceTypeOption(){
        clickOn(bidsourcetypeoption, WaitStrategy.CLICKABLE," Bid Source Type Option");
        waitupto(500);
    }

    private static final By addbidsourcetypelink = By.xpath("//a[text()='Add Bid Source Type']");
    public static void clickOnAddBidSourceTypeLink(){
        clickOn(addbidsourcetypelink,WaitStrategy.CLICKABLE,"Add Bid Source Type Link");
        waitupto(500);
    }

    private static final By bidsourcestypesubmtbtn = By.xpath("//input[@class='btn btn-success']");
    public static void clickOnBidSourceTypeSubBtn(){
        clickOn(bidsourcestypesubmtbtn,WaitStrategy.CLICKABLE,"Bid Source type submit button");
        waitupto(500);
    }


    private static final By bidtypetext = By.xpath("//input[@name='bid_type']");
    public static void enterBidType(String BidType){
        enterText(bidtypetext,BidType,WaitStrategy.PRESENCE,"Bid Type");
        waitupto(500);
    }

    private static final By bidtypedesc = By.xpath("//textarea[@id='id_description']");
    public static void enterBidTypeDes(String BidRecommendationDes){
        enterText(bidtypedesc,BidRecommendationDes,WaitStrategy.PRESENCE,"Bid type Description");
        waitupto(500);
    }

    private static final By bidtypesearchtext = By.xpath("//input[@id='id_notice_types']");
    public static void enterBidTypeSearchInfo(String BidType){
        enterText(bidtypesearchtext,BidType,WaitStrategy.PRESENCE,"Bid Type search information");
        waitupto(500);
    }
    public static void clearBidTypeText(){
        clearText(bidtypesearchtext,WaitStrategy.PRESENCE,"Bid Type text");
        waitupto(500);
    }
    private static final By bidtypesearchresult = By.xpath("//table[@id='example']/tbody//td[3]");
    public static String bidTypeSearchResult(){
        return gettext(bidtypesearchresult,WaitStrategy.VISIBLE);
    }

    private static final By bidtyoedesctext = By.xpath("//input[@id='id_description']");
    public static void enterBidTypeDescription(String BidTypeDes){
        enterText(bidtyoedesctext,BidTypeDes,WaitStrategy.PRESENCE,"Bid Type description search information");
        waitupto(500);
    }

    public static void clearBidTypeDes(){
        clearText(bidtyoedesctext,WaitStrategy.PRESENCE,"Bid Type description text");
        waitupto(500);
    }
    private static final By bidTypedessearchresult = By.xpath("//table[@id='example']/tbody//td[4]");
    public static String bidTypeDesSearchResult(){
        return gettext(bidTypedessearchresult,WaitStrategy.VISIBLE);
    }

}
