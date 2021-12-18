package org.issi.pages.MasterPage;

import org.issi.driver.DriverManager;
import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public final class AgencyOrFrim extends BasePage {
    private AgencyOrFrim() {
    }

    private static final By mastermenulink = By.xpath("//a[contains(text(),'Master')]");

    public static void clickOnMasterMenu() {
        clickOn(mastermenulink, WaitStrategy.CLICKABLE, "Master Menu");
        waitupto(500);
    }
    private static final By mastermenuoptionslist = By.xpath("//div[@id='collapsibleNavbar']/ul/li[3]/div");
    public static String menuOption() {
        List<WebElement> listofoptions = DriverManager.getDriver().findElements(mastermenuoptionslist);
        for (WebElement element : listofoptions) {
            String option = element.getText();
            return option;
        }
        return null;
    }

    private static final By agenyorfirmoption = By.xpath("//a[@href='/agencyfirm']");
    public static void clickOnAgenyOrFrim() {
          clickOn(agenyorfirmoption, WaitStrategy.CLICKABLE, "Agency or Firm");
        waitupto(500);
    }

    private static final By cardtitle = By.xpath("//h5[@class='cardtitle']");
    public static String actualHeading() {
        return gettext(cardtitle, WaitStrategy.VISIBLE);
    }

    private static final By addagencyorfirmlink = By.xpath("//a[contains(text(),'Add Agency or Firm')]");

    public static void clickOnAgencyOrFrimLink() {
        clickOn(addagencyorfirmlink, WaitStrategy.CLICKABLE, "Agency or Frim link");
        waitupto(500);
    }

    private static final By editWindow = By.xpath("//div[@id='modal-book']/div/div/form/div[1]/h5");

    public static String expectedWindowtitle() {
        return gettext(editWindow, WaitStrategy.PRESENCE);
    }

    private static final By editwindowcancelbutton = By.xpath("//input[@value='Cancel']");

    public static void clickOnEditCancleBtn() {
        clickOn(editwindowcancelbutton, WaitStrategy.CLICKABLE, "Edit window cancel button");
        waitupto(500);
    }

    private static final By agencyorfirmtext = By.xpath("//input[@name='agencyandfirm_name']");

    public static void enterAgencyOrFirm(String value) {
        enterText(agencyorfirmtext, value, WaitStrategy.PRESENCE, "Agency or firm");
        waitupto(500);
    }

    public static String getAgencyOrFrimtext() {
        return DriverManager.getDriver().findElement(agencyorfirmtext).getAttribute("value");
    }

    private static final By statedrpdwn = By.xpath("//select[@id='id_statecode']");

    public static void selectState(String statevalue) {
        selectFromDrpDwn(statedrpdwn, WaitStrategy.CLICKABLE, statevalue, "state");
        waitupto(500);
    }

    private static final By agencyorfirmdesctext = By.xpath("//textarea[@name='agencyandfirm_description']");

    public static void enterAgencyOrFrimDes(String des) {
        enterText(agencyorfirmdesctext, des, WaitStrategy.VISIBLE, "Description");
        waitupto(500);
    }

    private static final By submtbtn = By.xpath("//input[@class='btn btn-success']");

    public static void clickOnSbtBtn() {
        clickOn(submtbtn, WaitStrategy.CLICKABLE, "Submit button");
        waitupto(500);
    }

    private static final By errorText = By.xpath("//div[@id='nameexist']");

    public static String displayErrorMessage() {
        return gettext(errorText, WaitStrategy.VISIBLE);
    }

    private static final By searchagencytext = By.xpath("//input[@id='id_name']");

    public static void enterSearchAgency(String searhAgnecy) {
        enterText(searchagencytext, searhAgnecy, WaitStrategy.PRESENCE, "Search Agency");
        waitupto(500);
    }

    public static void clearAgenydata() {
        clearText(searchagencytext, WaitStrategy.PRESENCE, "Agency or Firm");
    }

    private static final By agencysearchresult = By.xpath("//table[@id='example']/tbody//td[3]");

    public static String searchResultInGrid() {
        return gettext(agencysearchresult, WaitStrategy.VISIBLE);
    }

    private static final By statesearchtextfield = By.xpath("//input[@id='id_state']");

    public static void enterStateSearchAgency(String statevalue) {
        enterText(statesearchtextfield, statevalue, WaitStrategy.PRESENCE, "state value");
        waitupto(500);
    }

    public static void clearStatedata() {
        clearText(statesearchtextfield, WaitStrategy.VISIBLE, "Sate field");
    }

    private static final By statepath = By.xpath("//table[@id='example']/tbody//td[4]");

    public static String sateSearchResutInGrid() {
        return gettext(statepath, WaitStrategy.VISIBLE);
    }

    private static final By descrpsearchtextfield = By.xpath("//input[@id='id_descr']");

    public static void enterSearchDescdata(String descvalue) {
        enterText(descrpsearchtextfield, descvalue, WaitStrategy.PRESENCE, "Agency or firm description");
        waitupto(500);
    }

    public static void clearDescData() {
        clearText(descrpsearchtextfield, WaitStrategy.VISIBLE, "description");
    }

    private static final By descriptionpath = By.xpath("//table[@id='example']/tbody//td[5]");

    public static String descriptionSearchResutInGrid() {
        return gettext(descriptionpath, WaitStrategy.VISIBLE);
    }

    /**
     * Agency or Firm Action functionalites
     */

    private static final By editicon = By.xpath("//table[@id='example']/tbody/tr/td[2]/a[@class='show-form-update']/span/i");

    public static void clickOnEditIcon() {
        clickOn(editicon, WaitStrategy.CLICKABLE, "Edit icon");
        waitupto(500);
    }

    private static final By deleteicon = By.xpath("//table[@id='example']/tbody/tr/td[2]/a[@class='show-form-delete']/span/i");

    public static void clickOnDeleteIcon() {
        clickOn(deleteicon, WaitStrategy.CLICKABLE, "Delete icon");
        waitupto(500);
    }

    private static final By deletepopup = By.xpath("//div[@id='modal-book']/div/div/form/div[1]/h5");

    public static String deletePopUpWindow() {
        return gettext(deletepopup, WaitStrategy.PRESENCE);
    }

    private static final By deletecloseicon = By.xpath("//div[@id='modal-book']//span[@aria-hidden='true']");

    public static void clickOnDeleteCloseIcon() {
        clickOn(deletecloseicon, WaitStrategy.CLICKABLE, "Delete close icon");
    }

    private static final By clickOptionYes = By.xpath("//div[@id='modal-book']//input[@class='btn btn-success pull-left']");
    private static final By clickOptioonNo = By.xpath("//div[@id='modal-book']//input[@class='btn btn-danger pull-right']");

    public static void chooseOptionOnDeletePopup(String option) {
        if (option.equalsIgnoreCase("Yes")) {
            clickOn(clickOptionYes, WaitStrategy.CLICKABLE, "option Yes");
            waitupto(500);
        } else if (option.equalsIgnoreCase("No")) {
            clickOn(clickOptioonNo, WaitStrategy.CLICKABLE, "option No");
            waitupto(500);
        }
    }

   // private static final By printicon = By.xpath("//table[@id='example']/tbody/tr/td[2]/a[3]/span/i");
    private static final By printbtn = By.xpath("//input[@id='btnprnt']");
    private static final By selectallchekbox = By.xpath("//input[@id='select_all']");
    public static void clickOnPrintIcon() {
        clickOn(printbtn,WaitStrategy.CLICKABLE, "Print icon");
        waitupto(500);
    }

    public static void clickOnSelectAllcheckBox(){
        clickOn(selectallchekbox,WaitStrategy.CLICKABLE,"All records");
        waitupto(500);
    }
    /**
     * Agency or Firm Type
     */
    private static final By optionyes = By.xpath("//div[@id='modal-book']/div/div/form/div[3]/div/div/div/input[1]");
    private static final By optionno = By.xpath("//div[@id='modal-book']/div/div/form/div[3]/div/div/div/input[2]");

    public static void chooseOptionOnAFTDeletePopup(String option) {
        if (option.equalsIgnoreCase("Yes")) {
            clickOn(optionyes, WaitStrategy.CLICKABLE, "option Yes");
            waitupto(500);
        } else if (option.equalsIgnoreCase("No")) {
            clickOn(optionno, WaitStrategy.CLICKABLE, "option No");
            waitupto(500);
        }

    }
}
