package org.issi.pages.BidsAndProposals;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class ISSIcapabilityTab extends BasePage {
    private ISSIcapabilityTab() {
    }
    private static final By issicapttab = By.xpath("//a[@id='issicapability-tab']");
    public static void clickOnIssICapTabLink(){
        clickOn(issicapttab, WaitStrategy.CLICKABLE,"ISSI Capability tab");
        waitupto(500);
    }

    private static final By typetext = By.xpath("//input[@id='id_type']");
    public static void enterTypeSearchText(String value){
        enterText(typetext,value,WaitStrategy.PRESENCE,"Type");
        waitupto(500);
    }

    private static final By gettype = By.xpath("//table[@id='issicapdatatable']/tbody/tr/td[2]");
    public static String getSearchTypeResult(){
        return gettext(gettype,WaitStrategy.PRESENCE);
    }

    private static final By optionyes = By.xpath("//input[@id='Yes_306']");
    private static final By optionmaybe = By.xpath("//input[@id='Maybe_306']");
    private static final By optionno = By.xpath("//input[@id='No_306']");
    public static void selectIssiOption(String value){
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

    private static final By issinextbtn = By.xpath("//button[@id='issinexttab']");
    public static void clickOnIssInextBtn(){
        clickOn(issinextbtn,WaitStrategy.CLICKABLE,"IssI next button");
        waitupto(500);
    }

}
