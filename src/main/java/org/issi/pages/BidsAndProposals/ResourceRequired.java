package org.issi.pages.BidsAndProposals;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class ResourceRequired extends BasePage {
    private ResourceRequired() {
    }

    private static By resourcesrequiredtab = By.xpath("//a[@id='resourcerequired-tab']");
    public static void clickOnResourceRequiredtab(){
        clickOn(resourcesrequiredtab, WaitStrategy.CLICKABLE,"ResourceRequired tab");
        waitupto(500);
    }

    private static By addnewresourcelink = By.xpath("//a[text()='Add New Resource']");
    public static void clickOnAddNewResourceLink(){
        clickOn(addnewresourcelink,WaitStrategy.CLICKABLE,"Add new Resource link");
        waitupto(500);
    }

    private static By resourcefirstname = By.xpath("//input[@id='id_resourcefirstname']");
    public static void enterResourceFirstName(String value){
        enterText(resourcefirstname,value,WaitStrategy.PRESENCE,"Resource First Name");
        waitupto(500);
    }

    private static By resourcelastname = By.xpath("//input[@id='id_resourcelastname']");
    public static void enterResourceLastName(String value){
        enterText(resourcelastname,value,WaitStrategy.PRESENCE,"Resource Last Name");
        waitupto(500);
    }

    private static By jobtitletext = By.xpath("//input[@name='jobtitle']");
    public static void enterJobTitle(String value){
        enterText(jobtitletext,value,WaitStrategy.PRESENCE,"Job title");
        waitupto(500);
    }

    private static By selectyearsofexp = By.xpath("//select[@id='id_year_exp']");
    public static void selectYearsOfExp(String value){
        selectFromDrpDwn(selectyearsofexp,WaitStrategy.CLICKABLE,value,"Years of experience");
        waitupto(500);
    }

    private static By selectresourcelevel = By.xpath("//select[@id='id_resourcelevel']");
    public static void selectResourceLevel(String value){
        selectFromDrpDwn(selectresourcelevel,WaitStrategy.CLICKABLE,value,"Resource level");
        waitupto(500);
    }

    private static By jobdescripton = By.xpath("//textarea[@id='id_job_description']");
    public static void enterJobDescription(String value){
        enterText(jobdescripton,value,WaitStrategy.PRESENCE,"Job description");
        waitupto(500);
    }

    private static By attachment = By.xpath("//input[@class='textinput textInput form-control resreqresume']");
    public static void enterAttachment(String value){
        enterText(attachment,value,WaitStrategy.PRESENCE,"Attachment");
        waitupto(500);
    }

    private static By rsubbtn = By.xpath("//input[@class='btn btn-success']");
    public static void clickOnResourceSubBtn(){
        clickOn(rsubbtn,WaitStrategy.CLICKABLE,"Submit button");
        waitupto(500);
    }

    private static By rnextbtn = By.xpath("//button[@id='resnexttab']");
    public static void clickOnResouceNextBth(){
        clickOn(rnextbtn,WaitStrategy.CLICKABLE,"Resource required next btn");
        waitupto(500);
    }
}
