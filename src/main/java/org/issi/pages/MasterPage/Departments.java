package org.issi.pages.MasterPage;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class Departments extends BasePage {
    private Departments() {
    }

    private static final By departmentoption = By.xpath("//div[@id='collapsibleNavbar']/ul/li[3]/div/a[10]");
    public static void clickOnDepartmentOption(){
        clickOn(departmentoption, WaitStrategy.CLICKABLE," Department Option");
        waitupto(500);
    }

    private static final By adddepartmentlink = By.xpath("//a[text()='Add Department']");
    public static void clickOnAddDepartmentLink(){
        clickOn(adddepartmentlink,WaitStrategy.CLICKABLE,"Add Department Link");
        waitupto(500);
    }

    private static final By departmentsubmtbtn = By.xpath("//input[@class='btn btn-success']");
    public static void clickOnDepartmentSubBtn(){
        clickOn(departmentsubmtbtn,WaitStrategy.CLICKABLE,"Department Submit button");
        waitupto(500);
    }


    private static final By departmenttext = By.xpath("//input[@name='departments']");
    public static void enterDepartment(String depart){
        enterText(departmenttext,depart,WaitStrategy.PRESENCE,"Compliance");
        waitupto(500);
    }

    private static final By potentialgencydrpdwn = By.xpath("//select[@name='agency']");
    public static void selectPotentialAgency(String PotAgen){
        selectFromDrpDwn(potentialgencydrpdwn,WaitStrategy.PRESENCE,PotAgen,"Potential agency");
    }

    private static final By departmentdestext = By.xpath("//textarea[@id='id_description']");
    public static void enterDepartmentDes(String departDes){
        enterText(departmentdestext,departDes,WaitStrategy.PRESENCE,"Department Description");
        waitupto(500);
    }


    private static final By departmentsearchtext = By.xpath("//input[@id='id_department']");
    public static void enterDepartmentSearchInfo(String comp){
        enterText(departmentsearchtext,comp,WaitStrategy.PRESENCE,"Department search information");
        waitupto(500);
    }
    public static void clearDepartmentText(){
        clearText(departmentsearchtext,WaitStrategy.PRESENCE,"Department text");
        waitupto(500);
    }
    private static final By departmentsearchresult = By.xpath("//table[@id='example']/tbody//td[3]");
    public static String departmentSearchResult(){
        return gettext(departmentsearchresult,WaitStrategy.VISIBLE);
    }


    private static final By potentialagenytext = By.xpath("//input[@id='id_potential_agency_firm']");
    public static void enterPotentialagencySearchInfo(String poten){
        enterText(potentialagenytext,poten,WaitStrategy.PRESENCE,"Department Potentials agency search information");
        waitupto(500);
    }
    public static void clearDepartmentPotentailagencyText(){
        clearText(potentialagenytext,WaitStrategy.PRESENCE,"Department Potential agency text");
        waitupto(500);
    }
    private static final By departmentpotentialsearchresult = By.xpath("//table[@id='example']/tbody//td[4]");
    public static String departmentPotentialAgencySearchResult(){
        return gettext(departmentpotentialsearchresult,WaitStrategy.VISIBLE);
    }


    private static final By depdesctiptiontext = By.xpath("//input[@id='id_description']");
    public static void enterDepDesSearchInfo(String poten){
        enterText(depdesctiptiontext,poten,WaitStrategy.PRESENCE,"Department Description search information");
        waitupto(500);
    }
    public static void clearDepartmentdesText(){
        clearText(depdesctiptiontext,WaitStrategy.PRESENCE,"Department description text");
        waitupto(500);
    }
    private static final By departmentdescriptionsearchresult = By.xpath("//table[@id='example']/tbody//td[5]");
    public static String departmentDesSearchResult(){
        return gettext(departmentdescriptionsearchresult,WaitStrategy.VISIBLE);
    }

}
