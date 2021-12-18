package org.issi.pages.BidsAndProposals;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class TeamingMatrix extends BasePage {
    private TeamingMatrix() {
    }
    private static final By teamingmatrixtab = By.xpath("//a[@id='teamingmatrix-tab']");
    public static void clickOnTeamingMatrixTab(){
        clickOn(teamingmatrixtab, WaitStrategy.CLICKABLE,"Teaming Matrix tab");
        waitupto(500);
    }

    private static final By getreq = By.xpath("//table[@id='tmdatatable']/tbody/tr/td[2]");
    public static String getRequirementResult(){
        return gettext(getreq,WaitStrategy.PRESENCE);
    }

    private static final By optionyes = By.xpath("//input[@id='tmissi_Yes_306']");
    private static final By optionmaybe = By.xpath("//input[@id='tmissi_Maybe_306']");
    private static final By optionno = By.xpath("//input[@id='tmissi_No_306']");
    public static void selectTeamingOption(String value){
        if (value.equalsIgnoreCase("Yes")){
            clickOn(optionyes,WaitStrategy.CLICKABLE,"Option Yes");
            waitupto(500);
        }else if (value.equalsIgnoreCase("Maybe")){
            clickOn(optionmaybe,WaitStrategy.CLICKABLE,"Option Maybe");
            waitupto(500);
        }else if(value.equalsIgnoreCase("No")){
            clickOn(optionno,WaitStrategy.CLICKABLE,"Option No");
            waitupto(500);
        }
    }


    private static final By tmoptionyes = By.xpath("//input[@id='tm2_Yes_234']");
    private static final By tmoptionmaybe = By.xpath("//input[@id='tm2_Maybe_234']");
    private static final By tmoptionno = By.xpath("//input[@id='tm2_No_234']");
    public static void selectTeamingCompTechOption(String value){
        if (value.equalsIgnoreCase("Yes")){
            clickOn(tmoptionyes,WaitStrategy.CLICKABLE,"Option Yes");
            waitupto(500);
        }else if (value.equalsIgnoreCase("Maybe")){
            clickOn(tmoptionmaybe,WaitStrategy.CLICKABLE,"Option Maybe");
            waitupto(500);
        }else if(value.equalsIgnoreCase("No")){
            clickOn(tmoptionno,WaitStrategy.CLICKABLE,"Option No");
            waitupto(500);
        }
    }


    private static final By teamingnext = By.xpath("//button[@id='tmnexttab']");
    public static void clickOnTeamingInextBtn(){
        clickOn(teamingnext,WaitStrategy.CLICKABLE,"Teaming next button");
        waitupto(500);
    }

}
