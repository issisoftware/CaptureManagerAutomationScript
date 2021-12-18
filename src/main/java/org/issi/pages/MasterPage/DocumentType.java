package org.issi.pages.MasterPage;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class DocumentType extends BasePage {
    private DocumentType() {
    }

    private static final By documenttypeoption = By.xpath("//div[@id='collapsibleNavbar']/ul/li[3]/div/a[11]");
    public static void clickOnDocumentTypeOption(){
        clickOn(documenttypeoption, WaitStrategy.CLICKABLE,"Document Type Option");
        waitupto(500);
    }

    private static final By adddocumenttypelink = By.xpath("//a[text()='Add Document Type']");
    public static void clickOnAddDocumentTypeLink(){
        clickOn(adddocumenttypelink,WaitStrategy.CLICKABLE,"Add Document Type Link");
        waitupto(500);
    }

    private static final By documenttypesubmtbtn = By.xpath("//input[@class='btn btn-success']");
    public static void clickOnDocumentTypeSubBtn(){
        clickOn(documenttypesubmtbtn,WaitStrategy.CLICKABLE,"Document Type Submit button");
        waitupto(500);
    }


    private static final By documenttypetext = By.xpath("//input[@name='file_type']");
    public static void enterDocumentTypeText(String depart){
        enterText(documenttypetext,depart,WaitStrategy.PRESENCE,"Document Type");
        waitupto(500);
    }

    private static final By documenttypedestext = By.xpath("//textarea[@id='id_description']");
    public static void enterDocumentTypeDescriptionText(String departDes){
        enterText(documenttypedestext,departDes,WaitStrategy.PRESENCE,"Document Type Description");
        waitupto(500);
    }


    private static final By documenttypesearchtext = By.xpath("//input[@id='id_document_type']");
    public static void enterDocumentTypeSearchInfo(String comp){
        enterText(documenttypesearchtext,comp,WaitStrategy.PRESENCE,"Document Type search information");
        waitupto(500);
    }
    public static void clearDocumentTypeSearchText(){
        clearText(documenttypesearchtext,WaitStrategy.PRESENCE,"Document type text");
        waitupto(500);
    }
    private static final By documenttypesearchresult = By.xpath("//table[@id='example']/tbody//td[3]");
    public static String documentTypeSearchResult(){
        return gettext(documenttypesearchresult,WaitStrategy.VISIBLE);
    }

    private static final By docuemnttypedestext = By.xpath("//input[@id='id_description']");
    public static void enterdocumentTypeDesSearchInfo(String poten){
        enterText(docuemnttypedestext,poten,WaitStrategy.PRESENCE,"Document type Description search information");
        waitupto(500);
    }
    public static void clearDocumentTyoeDescText(){
        clearText(docuemnttypedestext,WaitStrategy.PRESENCE,"Document type description text");
        waitupto(500);
    }
    private static final By documenttypedessearchresult = By.xpath("//table[@id='example']/tbody//td[4]");
    public static String documentTypeDesSearchResult(){
        return gettext(documenttypedessearchresult,WaitStrategy.VISIBLE);
    }

}
