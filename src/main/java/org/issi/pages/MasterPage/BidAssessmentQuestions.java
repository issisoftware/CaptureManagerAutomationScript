package org.issi.pages.MasterPage;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class BidAssessmentQuestions extends BasePage {
    private BidAssessmentQuestions() {
    }

    private static final By bidassesmentquestionsoption = By.xpath("//div[@id='collapsibleNavbar']/ul/li[3]/div/a[4]");
    public static void clickOnBidAssQueOption(){
        clickOn(bidassesmentquestionsoption, WaitStrategy.CLICKABLE,"Bid Assesment Questions Option");
        waitupto(500);
    }

    private static final By addbidassesmentqueslink = By.xpath("//a[text()='Add Bid Assessment Questions']");
    public static void clickOnAddBidAssQuesLink(){
        clickOn(addbidassesmentqueslink,WaitStrategy.CLICKABLE,"Add Bid Assessment Questions");
        waitupto(500);
    }

    private static final By bidassesmentquestext = By.xpath("//textarea[@name='assesmentquestions']");
    public static void enterBidAssesmentQuesText(String Bidassvalue){
        enterText(bidassesmentquestext,Bidassvalue,WaitStrategy.PRESENCE,"Bid Assesment Questions");
        waitupto(500);
    }

    private static final By bidassesmentcategorytext = By.xpath("//select[@name='assesmentcategory']");
    public static void selectBidassmentCategory(String Bidassvalue){
       selectFromDrpDwn(bidassesmentcategorytext,WaitStrategy.VISIBLE,Bidassvalue," in Bid assesment category");
        waitupto(500);
    }


    private static final By bidassmentquessubmtbtn = By.xpath("//input[@class='btn btn-success']");
    public static void clickOnBidAssQuesSubBtn(){
        clickOn(bidassmentquessubmtbtn,WaitStrategy.CLICKABLE,"Bid Assesment Questions submit button");
        waitupto(500);
    }

    private static final By bidassmentquesearhcbox = By.xpath("//input[@id='id_assessment_questions']");
    public static void enterBidAssesmentQuesInSearhTextbox(String BidAssesValue){
        enterText(bidassmentquesearhcbox,BidAssesValue,WaitStrategy.PRESENCE,"Bid assesment Questions search information");
        waitupto(500);
    }

    public static void clearBidAssementQueSearchinfo(){
        clearText(bidassmentquesearhcbox,WaitStrategy.PRESENCE,"Bid Assesment category search information");
        waitupto(500);
    }
    private static final By searchresultintable = By.xpath("//table[@id='example']/tbody//td[3]");
    public static String bidAssesmentQueSearchResult(){
        return gettext(searchresultintable,WaitStrategy.VISIBLE);
    }


    private static final By assementcategorysearhcbox = By.xpath("//input[@id='id_assessment_category']");
    public static void enterAssesmentCatInSearhTextbox(String BidAssesValue){
        enterText(assementcategorysearhcbox,BidAssesValue,WaitStrategy.PRESENCE,"Assesment Category search information");
        waitupto(500);
    }

    public static void clearAssementQueSearchinfo(){
        clearText(assementcategorysearhcbox,WaitStrategy.PRESENCE,"Assesment category search information");
        waitupto(500);
    }
    private static final By asscatsearchresultintable = By.xpath("//table[@id='example']/tbody//td[4]");
    public static String assesmentCatSearchResult(){
        return gettext(asscatsearchresultintable,WaitStrategy.VISIBLE);
    }
}
