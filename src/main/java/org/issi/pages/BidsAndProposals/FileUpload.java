package org.issi.pages.BidsAndProposals;

import org.issi.constants.FrameworkConstants;
import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class FileUpload extends BasePage {
    private FileUpload() {
    }

    private static final By fileuploadtab = By.xpath("//a[@id='fileuploads-tab']");
    public static void clickOnFileUploadTab(){
        clickOn(fileuploadtab, WaitStrategy.CLICKABLE,"File Upload tab");
        waitupto(500);
    }

    private static final By fileuploadbtn = By.xpath("//input[@id='id_file_data']");
    public static void uploadFile(){
        enterText(fileuploadbtn, FrameworkConstants.getFilePath(),WaitStrategy.PRESENCE,"file upload");
        waitupto(500);
    }

    private static final By attachbtn = By.xpath("//button[text()='Attach']");
    public static void clickOnAttachButton(){
        clickOn(attachbtn,WaitStrategy.CLICKABLE,"Attach Button");
        waitupto(500);
    }

    private static final By tableresult = By.xpath("//table[@id='resumetable']/tbody/tr/td[2]");
    public static String getResultFrmSearchTable(){
        return gettext(tableresult,WaitStrategy.PRESENCE);
    }
    private static final By filename = By.xpath("//input[@id='id_filename']");
    public static void enterFileNameinSearchBox(String value){
        enterText(filename,value,WaitStrategy.PRESENCE,"File name");
        waitupto(500);
    }

    private static final By filenextbtn = By.xpath("//button[@id='flnexttab']");
    public static void clickOnFileUploadNextbtn(){
        clickOn(filenextbtn,WaitStrategy.CLICKABLE,"Next btn in file upload");
        waitupto(500);
    }
}
