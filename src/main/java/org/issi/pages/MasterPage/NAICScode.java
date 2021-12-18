package org.issi.pages.MasterPage;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class NAICScode extends BasePage {
    private NAICScode() {
    }

    private static final By naicscodeoption = By.xpath("//div[@id='collapsibleNavbar']/ul/li[3]/div/a[13]");
    public static void clickOnNAICScodeOption(){
        clickOn(naicscodeoption, WaitStrategy.CLICKABLE,"NAICS code Option");
        waitupto(500);
    }

    private static final By addnaicscodeink = By.xpath("//a[text()='Add NAICS Code']");
    public static void clickOnAddNAICScodeLink(){
        clickOn(addnaicscodeink,WaitStrategy.CLICKABLE,"Add NAICS code Link");
        waitupto(500);
    }

    private static final By naicscodesubmtbtn = By.xpath("//input[@class='btn btn-success']");
    public static void clickOnNAOCScodeSubBtn(){
        clickOn(naicscodesubmtbtn,WaitStrategy.CLICKABLE,"NAICS code Submit button");
        waitupto(500);
    }


    private static final By naicscodetext = By.xpath("//input[@name='naicscode_name']");
    public static void enterNAICScodeText(String depart){
        enterText(naicscodetext,depart,WaitStrategy.PRESENCE,"NAICS code");
        waitupto(500);
    }

    private static final By naicscodedesctext = By.xpath("//textarea[@name='naicscode_description']");
    public static void enterNAICScodeDesText(String depart){
        enterText(naicscodedesctext,depart,WaitStrategy.PRESENCE,"NAICS code Description");
        waitupto(500);
    }

    private static final By naicscodesearchtext = By.xpath("//input[@id='id_NAICS_code_name']");
    public static void enterNAICScodeSearchInfo(String comp){
        enterText(naicscodesearchtext,comp,WaitStrategy.PRESENCE,"NAICS code search information");
        waitupto(500);
    }

    private static final By naicscodedessearchtext = By.xpath("//input[@id='id_description']");
    public static void enterNAICScodedesSearchInfo(String comp){
        enterText(naicscodedessearchtext,comp,WaitStrategy.PRESENCE,"NAICS code description search information");
        waitupto(500);
    }

    public static void clearNAICScodeDesSearchText(){
        clearText(naicscodedessearchtext,WaitStrategy.PRESENCE,"NAICS code description text");
        waitupto(500);
    }
    private static final By naicscodedessearchresult = By.xpath("//table[@id='example']/tbody//td[4]");
    public static String NAICScodeDesSearchResult(){
        return gettext(naicscodedessearchresult,WaitStrategy.VISIBLE);
    }


    public static void clearNAICScodeSearchText(){
        clearText(naicscodesearchtext,WaitStrategy.PRESENCE,"NAICS code text");
        waitupto(500);
    }
    private static final By naicscodesearchresult = By.xpath("//table[@id='example']/tbody//td[3]");
    public static String NAICScodeSearchResult(){
        return gettext(naicscodesearchresult,WaitStrategy.VISIBLE);
    }

}
