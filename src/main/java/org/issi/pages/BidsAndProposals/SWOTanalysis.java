package org.issi.pages.BidsAndProposals;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class SWOTanalysis extends BasePage {
    private SWOTanalysis() {
    }

    private static final By sowtanalysistab = By.xpath("//a[@id='swotanalysis-tab']");
    public static void clickOnSWOTanalysisTab(){
        clickOn(sowtanalysistab, WaitStrategy.CLICKABLE,"SWOT analysis tab");
        waitupto(500);
    }

    private static final By strength = By.xpath("//textarea[@id='id_strengths']");
    public static void enterStrengthText(String value){
        enterText(strength,value,WaitStrategy.PRESENCE,"strengths");
        waitupto(500);
    }

    private static final By weakness = By.xpath("//textarea[@id='id_weakness']");
    public static void enterWeaknessText(String value){
        enterText(weakness,value,WaitStrategy.PRESENCE,"weakness");
        waitupto(500);
    }

    private static final By customerissues = By.xpath("//textarea[@id='id_swotanalysis-0-customerissues']");
    public static void enterCustomerIssuesText(String value){
        enterText(customerissues,value,WaitStrategy.PRESENCE,"Coustomer issues");
        waitupto(500);
    }

    private static final By availablesol = By.xpath("//textarea[@id='id_swotanalysis-0-availablesolutions']");
    public static void enterAvailableSoluText(String value){
        enterText(availablesol,value,WaitStrategy.PRESENCE,"available solutions");
        waitupto(500);
    }

    private static final By discriminator = By.xpath("//textarea[@id='id_swotanalysis-0-discriminator']");
    public static void enterDiscriminatorText(String value){
        enterText(discriminator,value,WaitStrategy.PRESENCE,"Discriminator ");
        waitupto(500);
    }

    private static final By ga = By.xpath("//textarea[@id='id_swotanalysis-0-gap']");
    public static void enterGaText(String value){
        enterText(ga,value,WaitStrategy.PRESENCE,"GA ");
        waitupto(500);
    }

    private static final By savebtn = By.xpath("//form[@id='swotform']/div[3]/div/button[3]");
    public static void clickOnSWOTsubBtn(){
        clickOn(savebtn,WaitStrategy.CLICKABLE,"SWOT Submit Button");
        waitupto(500);
    }

    private static final By nextbtn = By.xpath("//button[@id='swnexttab']");
    public static void clickOnSWOTnextBtn(){
        clickOn(nextbtn,WaitStrategy.CLICKABLE,"SWOT next button");
        waitupto(500);
    }
}
