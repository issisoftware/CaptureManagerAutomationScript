package org.issi.pages.BidsAndProposals;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class IncumbentAndContacts extends BasePage {
    private IncumbentAndContacts() {
    }

    private static final By incumanccontacttab = By.xpath("//a[@id='incumbentcontats-tab']");
    public static void clickOnIncumbentAndContactsTab(){
        clickOn(incumanccontacttab,WaitStrategy.CLICKABLE,"Incumbent And Contacts Tab");
        waitupto(500);
    }

    private static final By addincumbentcontlink = By.xpath("//a[text()='Add Incumbent and Contact']");
    public static void clickOnAddIncumbentAndContactLink(){
        clickOn(addincumbentcontlink,WaitStrategy.CLICKABLE,"Add Incumbent and contact link");
        waitupto(500);
    }



    private static final By companynametext = By.xpath("//textarea[@id='id_company_name']");
    public static void enterCompanyNameText(String value){
        enterText(companynametext,value,WaitStrategy.PRESENCE,"Company Name");
        waitupto(500);
    }

    private static final By taskaratext =By.xpath("//textarea[@id='id_task_areas']");
    public static void enterTaskAreaText(String value){
        enterText(taskaratext,value,WaitStrategy.PRESENCE,"Task area");
        waitupto(500);
    }

    private static final By busineessize =By.xpath("//textarea[@id='id_business_size']");
    public static void enterBusinessSizeText(String value){
        enterText(busineessize,value,WaitStrategy.PRESENCE,"Business Size");
        waitupto(500);
    }

    private static final By addresstext =By.xpath("//textarea[@id='id_address']");
    public static void enterAddressText(String value){
        enterText(addresstext,value,WaitStrategy.PRESENCE,"Address");
        waitupto(500);
    }

    private static final By progmangertext = By.xpath("//textarea[@id='id_programmanager_name']");
    public static void enterProgManagerNameText(String value){
        enterText(progmangertext,value,WaitStrategy.PRESENCE,"Program manager name");
        waitupto(500);
    }

    private static final By prgmangarphntext =By.xpath("//input[@id='id_programmanager_phone']");
    public static void enterProgManagerPhoneText(String value){
        enterText(prgmangarphntext,value,WaitStrategy.PRESENCE,"Program Manager Phone");
        waitupto(500);
    }


    private static final By progmanageremail =By.xpath("//textarea[@id='id_programmanager_email']");
    public static void enterProgMangerEmail(String value){
        enterText(progmanageremail,value,WaitStrategy.PRESENCE,"Program Manger email");
        waitupto(500);
    }

    private static final By incumandcontactsbtbtn =By.xpath("//input[@class='btn btn-success']");
    public static void clickOnIncumbentAndContacSbtBtn(){
        clickOn(incumandcontactsbtbtn,WaitStrategy.CLICKABLE,"Incumbent And contact sumbit button");
        waitupto(500);
    }

    private static final By incumnextbtn = By.xpath("//button[@id='incnexttab']");
    public static void clickOnIncumbNextBtn(){
        clickOn(incumnextbtn,WaitStrategy.CLICKABLE,"Next button in Incumbent and contacts tab");
        waitupto(500);
    }
}
