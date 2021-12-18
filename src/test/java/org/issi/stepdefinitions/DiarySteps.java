package org.issi.stepdefinitions;

import com.aventstack.extentreports.util.Assert;
import io.cucumber.java.en.*;
import org.assertj.core.api.Assertions;

import static org.issi.pages.DiaryPage.*;
public class DiarySteps {
    private static String diaryheading;
    private static String calenderheading;

    /**
     * Steps for @DiaryDatepickerValidation
     */
    @When("user clicks on Diary menu")
    public void user_clicks_on_diary_menu() {
       clickOnDiary();
       waitupto(500);
    }
    @When("user get the Diary page heading")
    public void user_get_the_diary_page_heading() {
       diaryheading = diaryHeading();
       waitupto(500);
    }
    @Then("Diary page heading should be as {string}")
    public void diary_page_heading_should_be_as(String Actualdiaryheading) {
        Assertions.assertThat(diaryheading).isEqualTo(Actualdiaryheading);
        log().info("Found Dashboard page heading as : "+ diaryheading);
    }

    @When("user select date, month and year from drop down")
    public void user_select_date_month_and_year_from_drop_down() {
        selectdatefromcalander("1","Nov","2021");
        waitupto(500);
    }

    /**
     * steps for @NavigationsinDiaryModule
     */

    @When("user clicks on previous button")
    public void user_clicks_on_previous_button() {
        clickingOnPrevBtn();
    }

    @When("user clicks on Next button")
    public void user_clicks_on_next_button() {
        clickingOnNextBtn();
    }

    @When("user clicks on Month button")
    public void user_clicks_on_month_button() {
        clickingOnMonthBtn();
    }

    @When("user clicks on week button")
    public void user_clicks_on_week_button() {
        clickingOnWeekBtn();
    }

    @When("user clicks on day button")
    public void user_clicks_on_day_button() {
        clickingOnDayBtn();
    }


    @When("user gets the page heading")
    public void user_gets_the_page_heading() {
        calenderheading = pageheading();
        waitupto(500);
    }
    @Then("page heading should be {string}")
    public void page_heading_should_be(String Actualheading) {
       Assertions.assertThat(calenderheading).isEqualTo(Actualheading);
       log().info("Found  page title as : "+ calenderheading);
    }

}
