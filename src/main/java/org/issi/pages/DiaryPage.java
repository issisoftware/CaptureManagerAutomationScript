package org.issi.pages;

import org.issi.enums.WaitStrategy;
import org.issi.utilities.DynamicXpathUtils;
import org.openqa.selenium.By;

public final class DiaryPage extends BasePage {
    private DiaryPage() {
    }


    /**
     * elements identified and corresponding Action methods for @DiaryDatepickerValidation
     */
    public static final By diarymenu = By.xpath("//a[contains(text(),'Diary')]");

    public static void clickOnDiary() {
        clickOn(diarymenu, WaitStrategy.CLICKABLE, "Dashboard Menu");
        waitupto(500);
    }

    public static final By diarypageheading = By.xpath("//h1[contains(text(),'Diary')]");

    public static String diaryHeading() {
        return gettext(diarypageheading, WaitStrategy.PRESENCE);
    }

    public static final By datepickermonthdrpdwn = By.xpath("//select[@class='ui-datepicker-month']");
    public static final By datepickeryeardrpdwn = By.xpath("//select[@class='ui-datepicker-year']");

    public static final String datevalue = "//div[@id='diarydatepicker']/div/table/tbody/tr//a[text()='%s']";
    public static void selectdatefromcalander(String date, String month, String year) {
        if (month.equalsIgnoreCase("Feb") && Integer.parseInt(date) > 29) {
            System.out.println(" worng date: " + month + " : " + date);
            return;
        }
        if (Integer.parseInt(date) > 31) {
            System.out.println(" worng date: " + month + " : " + date);
            return;
        }

        selectFromDrpDwn(datepickermonthdrpdwn, WaitStrategy.CLICKABLE, month, "Month");
        waitupto(500);
        selectFromDrpDwn(datepickeryeardrpdwn, WaitStrategy.CLICKABLE, year, "Year");
        waitupto(500);
        String newXpath = DynamicXpathUtils.getXpath(datevalue, date);
        waitupto(500);
        clickOn(By.xpath(newXpath), WaitStrategy.CLICKABLE, "" + date + " as date ");
    }

    /**
     * elements identified and corresponding Action methods for @NavigationsinDiaryModule
     */
    public static final By prevbtn = By.xpath("//button[@aria-label='prev']");
    public static void clickingOnPrevBtn(){
        clickOn(prevbtn,WaitStrategy.CLICKABLE,"Previous button");
        waitupto(500);
    }


    public static final By nextbtn = By.xpath("//button[@aria-label='next']");
    public static void clickingOnNextBtn(){
            clickOn(nextbtn,WaitStrategy.CLICKABLE,"Next button");
            waitupto(500);
    }

    public static final By monthbtn = By.xpath("//button[contains(text(),'month')]");
    public static void clickingOnMonthBtn(){
        clickOn(monthbtn,WaitStrategy.CLICKABLE,"Month button");
        waitupto(500);
    }

    public static final By weekbtn = By.xpath("//button[contains(text(),'week')]");
    public static void clickingOnWeekBtn(){
        clickOn(weekbtn,WaitStrategy.CLICKABLE,"week button");
        waitupto(500);
    }

    public static final By daybtn = By.xpath("//div[@id='calendar']//button[3]");
    public static void clickingOnDayBtn(){
        clickOn(daybtn,WaitStrategy.CLICKABLE,"day button");
        waitupto(500);
    }


    public static final By heding = By.xpath("//h2[@class='fc-toolbar-title']");
    public static String pageheading(){
       return gettext(heding,WaitStrategy.VISIBLE);
    }

}

