package org.issi.pages.MasterPage;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class Compliance extends BasePage {
    private Compliance() {
    }

    private static final By complianceoption = By.xpath("//div[@id='collapsibleNavbar']/ul/li[3]/div/a[9]");
    public static void clickOnComplianceOption(){
        clickOn(complianceoption, WaitStrategy.CLICKABLE," Compliance Option");
        waitupto(500);
    }

    private static final By addcomplinacelink = By.xpath("//a[text()='Add Compliance']");
    public static void clickOnAddComplianceLink(){
        clickOn(addcomplinacelink,WaitStrategy.CLICKABLE,"Add Compliance Link");
        waitupto(500);
    }

    private static final By compliancesubmtbtn = By.xpath("//input[@class='btn btn-success']");
    public static void clickOnComplianceSubBtn(){
        clickOn(compliancesubmtbtn,WaitStrategy.CLICKABLE,"Compliance submit button");
        waitupto(500);
    }


    private static final By compliancetext = By.xpath("//input[@name='compliance']");
    public static void enterCompliance(String comp){
        enterText(compliancetext,comp,WaitStrategy.PRESENCE,"Compliance");
        waitupto(500);
    }

    private static final By compliancesearchtext = By.xpath("//input[@id='id_compliance']");
    public static void enterComplianceSearchInfo(String comp){
        enterText(compliancesearchtext,comp,WaitStrategy.PRESENCE,"Compliance search information");
        waitupto(500);
    }
    public static void clearComplianceText(){
        clearText(compliancesearchtext,WaitStrategy.PRESENCE,"Compliance text");
        waitupto(500);
    }
    private static final By compliancesearchresult = By.xpath("//table[@id='example']/tbody//td[3]");
    public static String complianceSearchResult(){
        return gettext(compliancesearchresult,WaitStrategy.VISIBLE);
    }

}
