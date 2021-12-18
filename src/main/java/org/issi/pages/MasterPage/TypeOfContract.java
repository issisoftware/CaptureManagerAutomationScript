package org.issi.pages.MasterPage;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class TypeOfContract extends BasePage {
    private TypeOfContract() {
    }

    private static final By typeofcontractoption = By.xpath("//a[@href='/typeofcontract']");
    public static void clickOnTypeOfConractOption(){
        clickOn(typeofcontractoption, WaitStrategy.CLICKABLE,"Type Of Contract Option");
        waitupto(500);
    }

    private static final By addtypeofconractlink = By.xpath("//a[text()='Add Type of Contract']");
    public static void clickOnAddTypeOfContractLink(){
        clickOn(addtypeofconractlink,WaitStrategy.CLICKABLE,"Add Type of Contract Link");
        waitupto(500);
    }

    private static final By typeofcontractsubmtbtn = By.xpath("//input[@class='btn btn-success']");
    public static void clickOnTypeOfContractSubBtn(){
        clickOn(typeofcontractsubmtbtn,WaitStrategy.CLICKABLE,"Type of contract Submit button");
        waitupto(500);
    }


    private static final By typeofconracttext = By.xpath("//input[@name='contract_type']");
    public static void enterTypeOfContractText(String depart){
        enterText(typeofconracttext,depart,WaitStrategy.PRESENCE,"Type of contract");
        waitupto(500);
    }

    private static final By typeofcontractsearchtext = By.xpath("//input[@id='id_Contract_type']");
    public static void enterTypeOfContractSearchInfo(String comp){
        enterText(typeofcontractsearchtext,comp,WaitStrategy.PRESENCE,"Type of conract search information");
        waitupto(500);
    }

    public static void clearTypeOfConractText(){
        clearText(typeofcontractsearchtext,WaitStrategy.PRESENCE,"Type of conract");
        waitupto(500);
    }
    private static final By typeofconractsearchresult = By.xpath("//table[@id='example']/tbody//td[3]");
    public static String typeOfContractSearchResult(){
        return gettext(typeofconractsearchresult,WaitStrategy.VISIBLE);
    }

    private static final By typeofcontactdestext = By.xpath("//textarea[@id='id_description']");
    public static void enterTypeOfContractDesText(String depart){
        enterText(typeofcontactdestext,depart,WaitStrategy.PRESENCE,"Type Of Conract Description");
        waitupto(500);
    }

    private static final By typeofconractdessearchtext = By.xpath("//input[@id='id_Description']");
    public static void enterTypeOfContractDesSearchInfo(String comp){
        enterText(typeofconractdessearchtext,comp,WaitStrategy.PRESENCE,"Type Of Contract Description search information");
        waitupto(500);
    }

    public static void clearTypeOfContractDesText(){
        clearText(typeofconractdessearchtext,WaitStrategy.PRESENCE,"Type Of Contract Description");
        waitupto(500);
    }
    private static final By typeofconractdessearchresult = By.xpath("//table[@id='example']/tbody//td[4]");
    public static String typeOfContractDesSearchResult(){
        return gettext(typeofconractdessearchresult,WaitStrategy.VISIBLE);
    }
}
