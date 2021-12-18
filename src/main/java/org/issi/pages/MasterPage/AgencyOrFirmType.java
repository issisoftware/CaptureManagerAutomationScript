package org.issi.pages.MasterPage;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class AgencyOrFirmType extends BasePage {
    private AgencyOrFirmType() {
    }

    private static final By agencyorfirmtypelink = By.xpath("//div[@id='collapsibleNavbar']/ul/li[3]/div/a[2]");
    public static void clickOnAgencyOrFirmTypeOption() {
        clickOn(agencyorfirmtypelink, WaitStrategy.CLICKABLE,"Agency or Firm Type");
        waitupto(500);
    }

    private static final By addagencyorfirmtypelink = By.xpath("//a[contains(text(),'Add Agency or Firm Type')]");
    public static void clickOnAddAgencyOrFrimTypeLink(){
        clickOn(addagencyorfirmtypelink,WaitStrategy.CLICKABLE,"Agency or Firm Type link");
        waitupto(500);
    }

    private static final By addagencytypetext = By.xpath("//input[@name='agency_firm_type']");
    public static void enterAgencyTypeText(String AgencyType){
        enterText(addagencytypetext,AgencyType,WaitStrategy.PRESENCE,"Agency Type");
        waitupto(500);
    }

    private static final By adddescriptiontext = By.xpath("//textarea[@id='id_description']");
    public static void enterAgencyTypeDesc(String AgencyTypeDes){
        enterText(adddescriptiontext,AgencyTypeDes,WaitStrategy.PRESENCE,"Agency Type Description");
        waitupto(500);
    }

    private static final By agencyorfirmtypesubmitbtn = By.xpath("//input[@value='Submit']");
    public static void clickOnAgencyOrFrimTypeSubmitBtn(){
        clickOn(agencyorfirmtypesubmitbtn,WaitStrategy.CLICKABLE,"Agency or Firm Type submit button");
        waitupto(500);
    }

    /**
     * Agency or firm type search functionality
     */

    private static final By agencyorfirmtypetextbox = By.xpath("//input[@placeholder='Search Agency or Firm Type']");
    public static void enterAgencyOrFrimTypeSearchinfo(String SearchAgency){
        enterText(agencyorfirmtypetextbox,SearchAgency,WaitStrategy.PRESENCE,"Agency or  Firm type search information");
        waitupto(500);
    }

    public static void clearAgencyOrFirmTypeSearchInfo(){
        clearText(agencyorfirmtypetextbox,WaitStrategy.PRESENCE,"Agency or  Firm type search information");
    }
    private static final By agencyorfirmtypedesc = By.xpath("//input[@id='id_descr']");
    public static void enterAgencyOrFrimTypeDescription(String SearchDesc){
        enterText(agencyorfirmtypedesc,SearchDesc,WaitStrategy.PRESENCE,"Agency or firm type search description");
        waitupto(500);
    }
    public static void clearAgencyOrFirmTypeDescription(){
        clearText(agencyorfirmtypedesc,WaitStrategy.PRESENCE,"Agency or firm type search description");
        waitupto(500);
    }

    private static final By agencyorfirmtypedecsearchpath = By.xpath("//table[@id='example']/tbody//td[4]");
    public static String agencyOrFirmTypeDesSearchResult(){
        return gettext(agencyorfirmtypedecsearchpath,WaitStrategy.VISIBLE);
    }

}


