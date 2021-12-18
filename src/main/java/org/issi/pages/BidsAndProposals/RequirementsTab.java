package org.issi.pages.BidsAndProposals;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class RequirementsTab extends BasePage {
    private RequirementsTab() {
    }

    private static final By reqtab = By.xpath("//a[@id='requirements-tab']");
    public static void clickOnReqTab(){
        clickOn(reqtab,WaitStrategy.CLICKABLE,"Requirements Tab");
        waitupto(500);
    }

    private static final By addnewreqlink = By.xpath("//a[text()='Add New Requirement']");
    public static void clickOnAddNewRequirementLink(){
        clickOn(addnewreqlink,WaitStrategy.CLICKABLE,"Add New Requirement link");
        waitupto(500);
    }

    private static final By tasktypetext = By.xpath("//select[@id='id_task_type']");
    public static void selectTaskType(String value){
        selectFromDrpDwn(tasktypetext,WaitStrategy.CLICKABLE,value,"Task Type drop down");
        waitupto(500);
    }

    private static final By taskaratext =By.xpath("//textarea[@id='id_task_area']");
    public static void enterTaskArea(String value){
        enterText(taskaratext,value,WaitStrategy.PRESENCE,"Task area");
        waitupto(500);
    }

    private static final By rfpreqtext =By.xpath("//textarea[@id='id_task_requirement']");
    public static void enterRfpRequirementText(String value){
        enterText(rfpreqtext,value,WaitStrategy.PRESENCE,"Rfp Requirement");
        waitupto(500);
    }

    private static final By rfpsectext =By.xpath("//textarea[@id='id_rfp_section']");
    public static void enterRfpSectionTect(String value){
        enterText(rfpsectext,value,WaitStrategy.PRESENCE,"RFP Section");
        waitupto(500);
    }

    private static final By evaluationtext = By.xpath("//select[@id='id_evaluation_criteria']");
    public static void selectEvalutaionvalue(String value){
        selectFromDrpDwn(evaluationtext,WaitStrategy.CLICKABLE,value,"Evaluation Criteria");
        waitupto(500);
    }

    private static final By summarytext =By.xpath("//textarea[@id='id_summary']");
    public static void enterSummaryText(String value){
        enterText(summarytext,value,WaitStrategy.PRESENCE,"Summary");
        waitupto(500);
    }

    private static final By exptext =By.xpath("//textarea[@id='id_experience']");
    public static void enterExpText(String value){
        enterText(exptext,value,WaitStrategy.PRESENCE,"Experience");
        waitupto(500);
    }

    private static final By priority = By.xpath("//select[@id='id_priority']");
    public static void selectPriority(String value){
        selectFromDrpDwn(priority,WaitStrategy.CLICKABLE,value,"Priority");
        waitupto(500);
    }

    private static final By addreqsbtbtn =By.xpath("//input[@value='Submit']");
    public static void clickOnAddReqSbtBtn(){
        clickOn(addreqsbtbtn,WaitStrategy.CLICKABLE,"Add Rrequirement sumbit button");
        waitupto(500);
    }

    private static final By reqnextbtn = By.xpath("//button[@id='rnexttab']");
    public static void clickOnReqNextBtn(){
        clickOn(reqnextbtn,WaitStrategy.CLICKABLE,"Next button in Requirements tab");
        waitupto(500);
    }
}
