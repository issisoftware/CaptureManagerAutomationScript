package org.issi.pages.MasterPage;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class TeamingPartners extends BasePage {
    private TeamingPartners() {
    }

    // identifiying elements and spliting into declaration and identification

    private static final By teamingpartneroption;
    private static final By addteamingpartnerlink;
    private static final By actualtitle;
    private static final By teamingpartnersavebtn;
    private static final By companynametext;
    private static final By websiteurltext;
    private static final By addresstext;
    private static final By citytext;
    private static final By statedrpdwn;
    private static final By zipcodetext;
    private static final By phonetext;
    private static final By emailtext;
   // private static final By typeofconractsearchresult;
    //private static final By typeofcontractsearchtext;
    private static final By capabilitytext;
    private static final By roledrpdwn;
    private static final By agneydrpdwn;


    static {
        teamingpartneroption = By.xpath("//a[@href='/teaming_partners']");
        addteamingpartnerlink = By.xpath("//a[text()='Add Teaming Partners']");
        actualtitle = By.xpath("//h5[contains(text(),'Add/Edit Teaming Partners')]");
        companynametext = By.xpath("//input[@name='company_name']");
        websiteurltext = By.xpath("//input[@name='websiteurl']");
        addresstext = By.xpath("//input[@name='address']");
        citytext = By.xpath("//input[@name='city']");
        statedrpdwn = By.xpath("//select[@name='state']");
        zipcodetext = By.xpath("//input[@name='zipcode']");
        phonetext = By.xpath("//input[@name='phone']");
        emailtext = By.xpath("//input[@id='id_email']");
        capabilitytext = By.xpath("//textarea[@name='workdescription']");
        roledrpdwn = By.xpath("//select[@name='partner_role']");
        agneydrpdwn = By.xpath("//select[@name='agency']");
        teamingpartnersavebtn = By.xpath("//button[@id='tpsave']");
    }

    public static void clickOnTeamingPartnersOption() {
        clickOn(teamingpartneroption, WaitStrategy.CLICKABLE, "Teaming Parteners Option");
        waitupto(500);
    }

    public static void clickOnAddTeamingPartnerLink() {
        clickOn(addteamingpartnerlink, WaitStrategy.CLICKABLE, "Add Teaming Partners Link");
        waitupto(500);
    }

    public static String actualPageTitle(){
        return gettext(actualtitle,WaitStrategy.PRESENCE);
    }
    public static void clickOnTeamingPartnerSaveBtn() {
        clickOn(teamingpartnersavebtn, WaitStrategy.CLICKABLE, "Teaming Partner save button");
        waitupto(500);
    }

    public static void enterCompanyNameText(String compname) {
        enterText(companynametext, compname, WaitStrategy.PRESENCE, "Company Name");
        waitupto(500);
    }

    public static void enterWesiteText(String website) {
        enterText(websiteurltext, website, WaitStrategy.PRESENCE, "WebSite");
        waitupto(500);
    }

    public static void enterAddressText(String address) {
        enterText(addresstext, address, WaitStrategy.PRESENCE, "Address");
        waitupto(500);
    }

    public static void enterCityText(String city) {
        enterText(citytext, city, WaitStrategy.PRESENCE, "City");
        waitupto(500);
    }

    public static void selectTeamingParterState(String state) {
        selectFromDrpDwn(statedrpdwn, WaitStrategy.CLICKABLE, state, "Indiana");
        waitupto(500);
    }

    public static void enterZipCodeText(String zipcode) {
        enterText(zipcodetext, zipcode, WaitStrategy.PRESENCE, "Zip Code");
        waitupto(500);
    }

   public static void enterPhonenumberText(String phnum){
        enterText(phonetext,phnum,WaitStrategy.PRESENCE,"Phone number");
        waitupto(500);
   }

    public static void enterEmailText(String email){
        enterText(emailtext,email,WaitStrategy.PRESENCE,"Email number");
        waitupto(500);
    }

    public static void enterCapability(String comp){
        enterText(capabilitytext,comp,WaitStrategy.PRESENCE,"Capability");
        waitupto(500);
    }

    public static void selectRole(String role){
        selectFromDrpDwn(roledrpdwn,WaitStrategy.CLICKABLE,role,"Hubzone");
        waitupto(500);
    }

    public static void selectAgnencyOrFirmTeamingPartner(String agency){
        selectFromDrpDwn(agneydrpdwn,WaitStrategy.CLICKABLE,agency,"Agency or Firm");
        waitupto(500);
    }

    
    private static final By comnamesearchtext = By.xpath("//input[@id='id_cmpnyname']");
    public static void enterCompanyNameSearchText(String comnmtex){
        enterText(comnamesearchtext,comnmtex,WaitStrategy.PRESENCE,"Company Name");
        waitupto(500);
    }
    private static final By compnamesearchresult = By.xpath("//table[@id='example']/tbody//td[3]");
    public static String companyNameSearchResult() {
        return gettext(compnamesearchresult,WaitStrategy.VISIBLE);

    }
    public static void clearCompNameText() {
        clearText(comnamesearchtext, WaitStrategy.PRESENCE, "Company Name");
        waitupto(500);
    }

    private static final By addresssearchtext = By.xpath("//input[@id='id_address']");
    public static void enterAddressSearchText(String comnmtex){
        enterText(addresssearchtext,comnmtex,WaitStrategy.PRESENCE,"Address Text");
        waitupto(500);
    }
    private static final By addressserachresult = By.xpath("//table[@id='example']/tbody//td[4]");
    public static String addressSearchResult() {
        return gettext(addressserachresult,WaitStrategy.VISIBLE);
    }
    public static void clearAddressSearchText() {
        clearText(addresssearchtext, WaitStrategy.PRESENCE, "Address Text");
        waitupto(500);
    }

    private static final By emailsearchtext = By.xpath("//input[@id='id_email']");
    public static void enterEmailSearchText(String comnmtex){
        enterText(emailsearchtext,comnmtex,WaitStrategy.PRESENCE,"Email Text");
        waitupto(500);
    }
    private static final By emailserachresult = By.xpath("//table[@id='example']/tbody//td[5]");
    public static String emailSearchResult() {
        return gettext(emailserachresult,WaitStrategy.VISIBLE);
    }
    public static void clearEmailSearchText() {
        clearText(emailsearchtext, WaitStrategy.PRESENCE, "Email Text");
        waitupto(500);
    }

    private static final By editbutton = By.xpath("//table[@id='example']/tbody/tr/td[2]/a[@href='/teaming_partners/edit/86']");
    public static void clickOnTeaminEditButton(){
        clickOn(editbutton,WaitStrategy.CLICKABLE,"Teaming Partner Edit button");
        waitupto(500);
    }

    private static final By exitlink = By.xpath("//form[@id='teamingpartnerform']/div[2]/div/a/button");
    public static void clickOnTeamingPartnerExitButton(){
        clickOn(exitlink,WaitStrategy.CLICKABLE,"Exit button");
        waitupto(500);
    }

    private static final By exptitle = By.xpath("//div[@id='root']/div[2]/div/div[1]/div/div[1]/h5");
    public static String expTeamingPartnerTitle() {
        return gettext(exptitle, WaitStrategy.PRESENCE);
    }
}

