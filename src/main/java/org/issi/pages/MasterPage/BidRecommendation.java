package org.issi.pages.MasterPage;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

import java.security.PublicKey;

public final class BidRecommendation extends BasePage {
    private BidRecommendation() {
    }

    private static final By bidrecommendationoption = By.xpath("//div[@id='collapsibleNavbar']/ul/li[3]/div/a[5]");
    public static void clickOnBidRecommendatonOption(){
        clickOn(bidrecommendationoption, WaitStrategy.CLICKABLE," Bid Recommendation Option");
        waitupto(500);
    }

    private static final By addbidrecommendationlink = By.xpath("//a[text()='Add Bid Recommendation']");
    public static void clickOnAddBidRecommendationLink(){
        clickOn(addbidrecommendationlink,WaitStrategy.CLICKABLE,"Add Bid Recommendation");
        waitupto(500);
    }


    private static final By bidrecommendationtext = By.xpath("//input[@name='bid_nobid_recomm']");
    public static void enterBidRecommendation(String BidRecommendation){
        enterText(bidrecommendationtext,BidRecommendation,WaitStrategy.PRESENCE,"Bid Recommendation");
        waitupto(500);
    }

    private static final By bidrecommendationdesctext = By.xpath("//textarea[@id='id_description']");
    public static void enterBidRecommendationDes(String BidRecommendationDes){
        enterText(bidrecommendationdesctext,BidRecommendationDes,WaitStrategy.PRESENCE,"Bid Recommendation Description");
        waitupto(500);
    }

    private static final By bidrecomsearchtext = By.xpath("//input[@id='id_bid_recommendation']");
    public static void enterBidRecomSearchInfo(String BidRecommsearc){
        enterText(bidrecomsearchtext,BidRecommsearc,WaitStrategy.PRESENCE,"Bid Recommendation search information");
        waitupto(500);
    }

    public static void clearBidRecommendationText(){
        clearText(bidrecomsearchtext,WaitStrategy.PRESENCE,"Bid Reommendation text");
        waitupto(500);
    }
    private static final By bidrecomsearchresult = By.xpath("//table[@id='example']/tbody//td[3]");
    public static String bidRecomSearchResult(){
        return gettext(bidrecomsearchresult,WaitStrategy.VISIBLE);
    }

    private static final By bidrecomdestext = By.xpath("//input[@id='id_description']");
    public static void enterBidRecommedDescription(String BidRecommsearc){
        enterText(bidrecomdestext,BidRecommsearc,WaitStrategy.PRESENCE,"Bid Recommendation description search information");
        waitupto(500);
    }

    public static void clearBidRecomDes(){
        clearText(bidrecomdestext,WaitStrategy.PRESENCE,"Bid Reommendation descripton text");
        waitupto(500);
    }
    private static final By bidrecomdessearchresult = By.xpath("//table[@id='example']/tbody//td[4]");
    public static String bidRecomDesSearchResult(){
        return gettext(bidrecomdessearchresult,WaitStrategy.VISIBLE);
    }

}
