package org.issi.pages.MasterPage;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class BidAssessmentCategory extends BasePage {
    private BidAssessmentCategory() {
    }

    private static final By bidassesmentcategoryoption = By.xpath("//div[@id='collapsibleNavbar']/ul/li[3]/div/a[3]");
    public static void clickOnBidAssCatOption(){
        clickOn(bidassesmentcategoryoption, WaitStrategy.CLICKABLE,"Bid Assesment Category Option");
        waitupto(500);
    }

    private static final By addbidassesmentcategorylink = By.xpath("//a[text()='Add Bid Assessment Category']");
    public static void clickOnAddBidAssCateLink(){
        clickOn(addbidassesmentcategorylink,WaitStrategy.CLICKABLE,"Add Bid Assessment Category");
        waitupto(500);
    }

    private static final By bidassesmentcategorytext = By.xpath("//input[@name='bidassesmentcategory']");
    public static void enterBidAssesmentCategoryText(String Bidassvalue){
        enterText(bidassesmentcategorytext,Bidassvalue,WaitStrategy.PRESENCE,"Bid Assesment Category");
        waitupto(500);
    }

    private static final By bidassmentcatesubmtbtn = By.xpath("//input[@class='btn btn-success']");
    public static void clickOnBidAssCateSubBtn(){
        clickOn(bidassmentcatesubmtbtn,WaitStrategy.CLICKABLE,"Bid Assesment Category submit button");
        waitupto(500);
    }

    private static final By bidassmentsearhcbox = By.xpath("//input[@id='id_bid_assessment_category']");
    public static void enterBidAssesmentInSearhTextbox(String BidAssesValue){
        enterText(bidassmentsearhcbox,BidAssesValue,WaitStrategy.PRESENCE,"Bid assesment Category search information");
        waitupto(500);
    }

    public static void clearBidAssementSearchinfo(){
        clearText(bidassmentsearhcbox,WaitStrategy.PRESENCE,"Bid Assesment category search information");
        waitupto(500);
    }
    private static final By searchresultintable = By.xpath("//table[@id='example']/tbody//td[3]");
    public static String bidAssesmentCatSearchResult(){
        return gettext(searchresultintable,WaitStrategy.VISIBLE);
    }
}
