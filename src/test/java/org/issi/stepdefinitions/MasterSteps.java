package org.issi.stepdefinitions;

import io.cucumber.java.en.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.assertj.core.api.Assertions;
import org.issi.constants.FrameworkConstants;
import org.issi.driver.DriverManager;
import org.issi.utilities.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.issi.pages.BasePage.waitupto;
import static org.issi.pages.MasterPage.AgencyOrFrim.*;
import static org.issi.pages.MasterPage.AgencyOrFirmType.*;
import static org.issi.pages.MasterPage.BidAssessmentCategory.*;
import static org.issi.pages.MasterPage.BidAssessmentQuestions.*;
import static org.issi.pages.MasterPage.BidRecommendation.*;
import static org.issi.pages.MasterPage.BidSources.*;
import static org.issi.pages.MasterPage.BidSourceTypes.*;
import static org.issi.pages.MasterPage.BidStatus.*;
import static org.issi.pages.MasterPage.Compliance.*;
import static org.issi.pages.MasterPage.Departments.*;
import static org.issi.pages.MasterPage.DocumentType.*;
import static org.issi.pages.MasterPage.EvaluationCriteria.*;
import static org.issi.pages.MasterPage.NAICScode.*;
import static org.issi.pages.MasterPage.NewOrRecompete.*;
import static org.issi.pages.MasterPage.P4Actions.*;
import static org.issi.pages.MasterPage.P4Status.*;
import static org.issi.pages.MasterPage.Priority.*;
import static org.issi.pages.MasterPage.RequirementType.*;
import static org.issi.pages.MasterPage.RFPType.*;
import static org.issi.pages.MasterPage.SetAside.*;
import static org.issi.pages.MasterPage.TeamingPartners.*;
import static org.issi.pages.MasterPage.TypeOfContract.*;


public class MasterSteps {
    public List<Map<String, String>> testdata;
    ExcelReader reader = new ExcelReader();

    public static String parentwindow;
    public static String deleteParentwindow;

    @When("user clicks on master menu")
    public void user_clicks_on_master_menu() {
        clickOnMasterMenu();
        waitupto(500);
    }

    @Then("user found {string} option under master menu")
    public void user_found_option_under_master_menu(String actualOption) {

       // log().info(menuOption());
        Assertions.assertThat(menuOption()).contains(actualOption);
        log().info("Found '" + actualOption + "' option in master menu ");
    }

    @When("user clicks on Agency or Frim option")
    public void user_clicks_on_agency_or_frim_option() {
        clickOnAgenyOrFrim();
    }

    @Then("page heading should be as {string}")
    public void page_heading_should_be_as(String expectedHeading) {
        Assertions.assertThat(actualHeading()).isEqualTo(expectedHeading);
        log().info("Found page heading as " + actualHeading());
    }

    @When("user clicks on Add Agency or Frim link")
    public void user_clicks_on_add_agency_or_frim_link() {
        clickOnAgencyOrFrimLink();
    }

    @Then("user should navigate to {string} window")
    public void user_should_navigate_to_window(String actualWindow) {
        Assertions.assertThat(expectedWindowtitle()).isEqualTo(actualWindow);
        log().info("User navigated to " + expectedWindowtitle() + " window");
        waitupto(500);
      //  clickOnEditCancleBtn();
    }

    @When("user enters Agency or firm detilas from {string} sheet and {int}")
    public void user_enters_agency_or_firm_detilas_from_sheet_and(String sheetname, Integer rownumber) {

        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String agencyorfrimtext = testdata.get(rownumber).get("Agency or Firm");
            enterAgencyOrFirm(agencyorfrimtext);

            String agencyorfrimstate = testdata.get(rownumber).get("Agency or Firm state");
            selectState(agencyorfrimstate);

            String agencyorfirmdescriptiontext = testdata.get(rownumber).get("Agency or Firm Description");
            enterAgencyOrFrimDes(agencyorfirmdescriptiontext);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    @When("clicks on submit button")
    public void clicks_on_submit_button() {
        if ((getAgencyOrFrimtext().equals("SoftTech Agency"))) {
            clickOnSbtBtn();
            waitupto(500);
            throw new RuntimeException(displayErrorMessage());
        } else {
            clickOnSbtBtn();
            waitupto(500);
        }
    }

    @When("user enters search agency information in search field")
    public void user_enters_search_agency_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("Agency or Firm");
            enterSearchAgency(agencyorfrimtext);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    @Then("user should find agency record in search grid")
    public void user_should_find_agency_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("Agency or Firm");
            Assertions.assertThat(searchResultInGrid()).isEqualTo(agencyorfrimtext);
            // agencySearchResult(agencyorfrimtext);
            log().info("Found '" + agencyorfrimtext + "' in, Agency or Firm search filed");
            clearAgenydata();
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }

    }

    @When("user enters State in state search filed")
    public void user_enters_state_in_state_search_filed() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("Agency or Firm state");
            enterStateSearchAgency(agencyorfrimtext);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    @Then("user should find state in search grid")
    public void user_should_find_state_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("Agency or Firm state");
            Assertions.assertThat(sateSearchResutInGrid()).isEqualTo(agencyorfrimtext);
            // agencySearchResult(agencyorfrimtext);
            log().info("Found state as '" + agencyorfrimtext + "' in, Agency or Firm search filed");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearStatedata();
    }

    @When("user enter agency or firm description in search field")
    public void user_enter_agency_or_firm_description_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("Agency or Firm Description");
            enterSearchDescdata(agencyorfrimtext);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    @Then("user should find the agency or firm description in search field")
    public void user_should_find_the_agency_or_firm_description_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("Agency or Firm Description");
            Assertions.assertThat(descriptionSearchResutInGrid()).isEqualTo(agencyorfrimtext);
            // agencySearchResult(agencyorfrimtext);
            log().info("Found description as '" + agencyorfrimtext + "' in, Agency or Firm search filed");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearDescData();
    }

    @When("user clicks on Edit icon")
    public void user_clicks_on_edit_icon() {
        clickOnEditIcon();
    }

    @When("user clicks on delete icon")
    public void user_clicks_on_delete_icon() {
        clickOnDeleteIcon();
    }

    @Then("user get a confirmation window to choose the option")
    public void user_get_a_confirmation_window_to_choose_the_option() {
        log().info("found delete pop up window as " + deletePopUpWindow());
        waitupto(500);
        chooseOptionOnDeletePopup("No");
    }

    @When("user clicks on print button")
    public void user_clicks_on_print_button() {
        clickOnSelectAllcheckBox();
        clickOnPrintIcon();
        waitupto(500);
        parentwindow = DriverManager.getDriver().getWindowHandle();
    }

    @Then("user should found the record in new tab and close")
    public void user_should_found_the_record_in_new_tab_and_close() {
        String childwindow = switchToWindow(parentwindow);
        DriverManager.getDriver().switchTo().window(childwindow);
        waitupto(2500);
        DriverManager.getDriver().close();
        log().info("Closed new tab print window");
        waitupto(500);
    }

    /**
     * Agency or Firm Type
     */

    @When("user clicks on Agency or Frim Type option")
    public void user_clicks_on_agency_or_frim_type_option() {
        clickOnAgencyOrFirmTypeOption();
    }
    @When("user clicks on Add Agency or Firm Type link")
    public void user_clicks_on_add_agency_or_firm_type_link() {
        clickOnAddAgencyOrFrimTypeLink();
    }

    @When("user enters Agency or firm type detilas from {string} sheet and {int}")
    public void user_enters_agency_or_firm_type_detilas_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String agencyorfrimtext = testdata.get(rownumber).get("Agency Type");
            enterAgencyTypeText(agencyorfrimtext);

            String agencyorfrimstate = testdata.get(rownumber).get("Agency or Frim Type Description");
            enterAgencyTypeDesc(agencyorfrimstate);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    @When("clicks on Create Agency or Firm Type submit button")
    public void clicks_on_create_agency_or_firm_type_submit_button() {
                clickOnAgencyOrFrimTypeSubmitBtn();
    }

    /**
     * Agency or firm type search functionality
     */
    @When("user enters search agency or firm type information in search field")
    public void user_enters_search_agency_or_firm_type_information_in_search_field() {

        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("Agency Type");
            enterAgencyOrFrimTypeSearchinfo(agencyorfrimtext);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }

    }
    @Then("user should find agency or firm type record in search grid")
    public void user_should_find_agency_or_firm_type_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("Agency Type");
            Assertions.assertThat(searchResultInGrid()).isEqualTo(agencyorfrimtext);
            // agencySearchResult(agencyorfrimtext);
            log().info("Found '" + agencyorfrimtext + "' in, Agency or Firm search filed");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearAgencyOrFirmTypeSearchInfo();
    }

    @When("user enters agency or firm type description in descripton search filed")
    public void user_enters_agency_or_firm_type_description_in_descripton_search_filed() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("Agency or Frim Type Description");
            enterAgencyOrFrimTypeDescription(agencyorfrimtext);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find the agency or firm type description in search field")
    public void user_should_find_the_agency_or_firm_type_description_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("Agency or Frim Type Description");
            Assertions.assertThat(agencyOrFirmTypeDesSearchResult()).isEqualTo(agencyorfrimtext);
            log().info("Found '" + agencyorfrimtext + "' in, Agency or Firm Type description filed");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearAgencyOrFirmTypeDescription();
    }

    @Then("user get delete confirmation window to choose the option")
    public void user_get_delete_confirmation_window_to_choose_the_option() {
        log().info("found delete pop up window as " + deletePopUpWindow());
        waitupto(500);
        chooseOptionOnAFTDeletePopup("No");
    }

    //Bid Assesment Category

    @When("user clicks on Bid Assessment Category option")
    public void user_clicks_on_bid_assessment_category_option() {
       clickOnBidAssCatOption();
    }

    @When("user clicks on Add Bid Assessment Category link")
    public void user_clicks_on_add_bid_assessment_category_link() {
        clickOnAddBidAssCateLink();
    }

    @When("user enters Bid Assesment Category detilas from {string} sheet and {int}")
    public void user_enters_bid_assesment_category_detilas_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String agencyorfrimtext = testdata.get(rownumber).get("Bid Assessment Category");
            enterBidAssesmentCategoryText(agencyorfrimtext);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("clicks on Bid Assesment Category submit button")
    public void clicks_on_bid_assesment_category_submit_button() {
        clickOnBidAssCateSubBtn();
    }

    @When("user enters search Bid Assessment Category information in search field")
    public void user_enters_search_bid_assessment_category_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("Bid Assessment Category");
            enterBidAssesmentInSearhTextbox(agencyorfrimtext);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Bid Assessment Category record in search grid")
    public void user_should_find_bid_assessment_category_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("Bid Assessment Category");
            Assertions.assertThat(bidAssesmentCatSearchResult()).isEqualTo(agencyorfrimtext);
            log().info("Found '" + agencyorfrimtext + "' in, Bid Assesment Category search filed");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearBidAssementSearchinfo();
    }

    /**
     * Bid Assesment Questions
     */
    @When("user clicks on Bid Assessment Questions option")
    public void user_clicks_on_bid_assessment_Questions_option() {
        clickOnBidAssQueOption();
    }

    @When("user clicks on Add Bid Assessment Questions link")
    public void user_clicks_on_add_bid_assessment_Questions_link() {
        clickOnAddBidAssQuesLink();
    }

    @When("user enters Bid Assesment Questions detilas from {string} sheet and {int}")
    public void user_enters_bid_assesment_Questions_detilas_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String agencyorfrimtext = testdata.get(rownumber).get("Bid Assessment Questions");
            enterBidAssesmentQuesText(agencyorfrimtext);
            waitupto(500);
            String bidassesmentcat = testdata.get(rownumber).get("BidAssesmentCategory");
            selectBidassmentCategory(bidassesmentcat);
            waitupto(500);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    @When("clicks on Bid Assesment Questions submit button")
    public void clicks_on_bid_assesment_Questions_submit_button() {
        clickOnBidAssQuesSubBtn();
    }

    @When("user enters search Bid Assessment Questions information in search field")
    public void user_enters_search_bid_assessment_Questions_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("Bid Assessment Questions");
            enterBidAssesmentQuesInSearhTextbox(agencyorfrimtext);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Bid Assessment Questions record in search grid")
    public void user_should_find_bid_assessment_Questions_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("Bid Assessment Questions");
            Assertions.assertThat(bidAssesmentQueSearchResult()).isEqualTo(agencyorfrimtext);
            log().info("Found '" + agencyorfrimtext + "' in, Bid Assesment Questions search filed");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearBidAssementQueSearchinfo();
    }


    @When("user enters search Assessment Category information in search field")
    public void user_enters_search_assessment_category_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("BidAssesmentCategory");
            enterAssesmentCatInSearhTextbox(agencyorfrimtext);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Assessment Category record in search grid")
    public void user_should_find_assessment_category_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("BidAssesmentCategory");
            Assertions.assertThat(assesmentCatSearchResult()).isEqualTo(agencyorfrimtext);
            log().info("Found '" + agencyorfrimtext + "' in, Bid Assesment Questions search filed");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearAssementQueSearchinfo();
    }


    /**
     * Bid Recommedations
     */

    @When("user clicks on Bid Recommendations option")
    public void user_clicks_on_bidRecommendations_option() {
        clickOnBidRecommendatonOption();
    }

    @When("user clicks on Add Bid recommendations link")
    public void user_clicks_on_add_bid_recommendations_link() {
       clickOnAddBidRecommendationLink();
    }

    @When("clicks on Bid Recommendation submit button")
    public void clicks_on_bid_Recommendation_submit_button() {
        clickOnBidAssQuesSubBtn();
    }


    @When("user enters Bid Recommendation detilas from {string} sheet and {int}")
    public void user_enters_bid_recommendation_detilas_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String bidrecommtext = testdata.get(rownumber).get("BidRecommendation");
            enterBidRecommendation(bidrecommtext);
            waitupto(500);
            String bidrecomdesctext = testdata.get(rownumber).get("BidRecommendationDescription");
            enterBidRecommendationDes(bidrecomdesctext);
            waitupto(500);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    @When("user enters search Bid Recommendation information in search field")
    public void user_enters_search_bid_recommendation_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String bidrecommtext = testdata.get(0).get("BidRecommendation");
            enterBidRecomSearchInfo(bidrecommtext);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }

    }
    @Then("user should find Bid Recommendation record in search grid")
    public void user_should_find_bid_recommendation_record_in_search_grid() {

        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("BidRecommendation");
            Assertions.assertThat(bidRecomSearchResult()).isEqualTo(agencyorfrimtext);
            log().info("Found '" + agencyorfrimtext + "' in, Bid Recommendation search filed");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearBidRecommendationText();
    }
    @When("user enters search Bid Recommendation descripton information in search field")
    public void user_enters_search_bid_recommendation_descripton_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String bidrecommtext = testdata.get(0).get("BidRecommendationDescription");
            enterBidRecommedDescription(bidrecommtext);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }

    }
    @Then("user should find Bid Recommendation descripton record in search grid")
    public void user_should_find_bid_recommendation_descripton_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("BidRecommendationDescription");
            Assertions.assertThat(bidRecomDesSearchResult()).isEqualTo(agencyorfrimtext);
            log().info("Found '" + agencyorfrimtext + "' in, Bid Recommendation desctiption search filed");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearBidRecomDes();
    }

    /**
     * Bid Sources
     */

    @When("user clicks on Bid Sources option")
    public void user_clicks_on_bid_sources_option() {
        clickOnBidSourceOption();
    }
    @When("user clicks on Add Bid Sources link")
    public void user_clicks_on_add_bid_sources_link() {
        clickOnAddBidSourcesLink();
    }
    @When("user enters Bid Sources detilas from {string} sheet and {int}")
    public void user_enters_bid_sources_detilas_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String bidsorucetext = testdata.get(rownumber).get("BidSources");
            enterBidSources(bidsorucetext);
            waitupto(500);
            String bidsourcedestext = testdata.get(rownumber).get("BidSourcesDescription");
            enterBidSourcesDes(bidsourcedestext);
            waitupto(500);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("clicks on Bid Sources submit button")
    public void clicks_on_bid_sources_submit_button() {
        clickOnBidSourcesSubBtn();
    }


    @When("user enters search Bid Source information in search field")
    public void user_enters_search_bid_source_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String bidrecommtext = testdata.get(0).get("BidSources");
            enterBidSourceSearchInfo(bidrecommtext);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Bid Source record in search grid")
    public void user_should_find_bid_source_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("BidSources");
            Assertions.assertThat(bidSourcesSearchResult()).isEqualTo(agencyorfrimtext);
            log().info("Found '" + agencyorfrimtext + "' in, Bid Sources search filed");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearBidSourceText();
    }
    @When("user enters search Bid Source descripton information in search field")
    public void user_enters_search_bid_source_descripton_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String bidrecommtext = testdata.get(0).get("BidSourcesDescription");
            enterBidSourceDescription(bidrecommtext);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Bid Source descripton record in search grid")
    public void user_should_find_bid_source_descripton_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("BidSourcesDescription");
            Assertions.assertThat(bidSourceDesSearchResult()).isEqualTo(agencyorfrimtext);
            log().info("Found '" + agencyorfrimtext + "' in, Bid Sources search filed");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearBidSourceDes();
    }

    /**
     * Bid Source Type
     */

    @When("user clicks on Bid Source Types option")
    public void user_clicks_on_bid_source_types_option() {
        clickOnBidSourceTypeOption();
    }
    @When("user clicks on Add Bid Source Type link")
    public void user_clicks_on_add_bid_source_type_link() {
       clickOnAddBidSourceTypeLink();
    }
    @When("user enters Bid Source type detilas from {string} sheet and {int}")
    public void user_enters_bid_source_type_detilas_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String bidtypetext = testdata.get(rownumber).get("BidSourceType");
            enterBidType(bidtypetext);
            waitupto(500);
            String bidsourcedestext = testdata.get(rownumber).get("BidSourceTypeDescription");
            enterBidTypeDes(bidsourcedestext);
            waitupto(500);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("clicks on Bid Source type submit button")
    public void clicks_on_bid_source_type_submit_button() {
        clickOnBidSourceTypeSubBtn();
    }


    @When("user enters search Bid Source type information in search field")
    public void user_enters_search_bid_source_type_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String bidtype = testdata.get(0).get("BidSourceType");
            enterBidTypeSearchInfo(bidtype);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Bid Source type record in search grid")
    public void user_should_find_bid_source_type_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String bidtypetext = testdata.get(0).get("BidSourceType");
            Assertions.assertThat(bidTypeSearchResult()).isEqualTo(bidtypetext);
            log().info("Found '" + bidtypetext + "' in, Bid type search filed");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearBidTypeText();
    }
    @When("user enters search Bid Source type descripton information in search field")
    public void user_enters_search_bid_source_type_descripton_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String bidtypedes = testdata.get(0).get("BidSourceTypeDescription");
            enterBidTypeDescription(bidtypedes);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Bid Source type descripton record in search grid")
    public void user_should_find_bid_source_type_descripton_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("BidSourceTypeDescription");
            Assertions.assertThat(bidTypeDesSearchResult()).isEqualTo(agencyorfrimtext);
            log().info("Found '" + agencyorfrimtext + "' in, Bid Source type search filed");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearBidTypeDes();
    }

    /**
     * BidStatus
     */

    @When("user clicks on Bid Status option")
    public void user_clicks_on_bid_status_option() {
        clickOnBidStatusOption();
    }
    @When("user clicks on Add Bid Status Type link")
    public void user_clicks_on_add_bid_status_type_link() {
        clickOnAddBidStatusLink();
    }
    @When("user enters Bid Status detilas from {string} sheet and {int}")
    public void user_enters_bid_status_detilas_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String bidstatustext = testdata.get(rownumber).get("BidStatusType");
            enterBidStatus(bidstatustext);
            waitupto(500);
            String bidstatusdesc = testdata.get(rownumber).get("BidStatusTypeDescription");
            enterBidStatusDes(bidstatusdesc);
            waitupto(500);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("clicks on Bid Create Bid Status submit button")
    public void clicks_on_bid_create_bid_status_submit_button() {
        clickOnBidStatusSubBtn();
    }


    @When("user enters search Bid Status information in search field")
    public void user_enters_search_bid_status_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String bidstatus = testdata.get(0).get("BidStatusType");
            enterBidStatusSearchInfo(bidstatus);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Bid Status record in search grid")
    public void user_should_find_bid_status_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String bidstatusetext = testdata.get(0).get("BidStatusType");
            Assertions.assertThat(bidStatusSearchResult()).isEqualTo(bidstatusetext);
            log().info("Found '" + bidstatusetext + "' in, Bid status search filed");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearBidStatusText();
    }
    @When("user enters search Bid Status descripton information in search field")
    public void user_enters_search_bid_status_descripton_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String bidstatus = testdata.get(0).get("BidStatusTypeDescription");
            enterBidStatusDescription(bidstatus);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Bid Status descripton record in search grid")
    public void user_should_find_bid_status_descripton_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String agencyorfrimtext = testdata.get(0).get("BidStatusTypeDescription");
            Assertions.assertThat(bidStatusDesSearchResult()).isEqualTo(agencyorfrimtext);
            log().info("Found '" + agencyorfrimtext + "' in, Bid Status search filed");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearBidStatusDes();
    }

    /**
     * Compliance
     */

    @When("user clicks on Compliance option")
    public void user_clicks_on_compliance_option() {
       clickOnComplianceOption();
    }

    @When("user clicks on Add Compliance Type link")
    public void user_clicks_on_add_compliance_type_link() {
        clickOnAddComplianceLink();
    }
    @When("user enters Compliance detilas from {string} sheet and {int}")
    public void user_enters_compliance_detilas_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String bidstatustext = testdata.get(rownumber).get("Compliance");
            enterCompliance(bidstatustext);
            waitupto(500);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("clicks on Compliance submit button")
    public void clicks_on_compliance_submit_button() {
        clickOnComplianceSubBtn();
    }

    @When("user enters search compliance information in search field")
    public void user_enters_search_compliance_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String bidstatus = testdata.get(0).get("Compliance");
            enterComplianceSearchInfo(bidstatus);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find compliance record in search grid")
    public void user_should_find_compliance_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String bidstatusetext = testdata.get(0).get("BidStatusType");
            Assertions.assertThat(complianceSearchResult()).isEqualTo(bidstatusetext);
            log().info("Found '" + bidstatusetext + "' in, compliance search filed");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearComplianceText();
    }


    /**
     * Departments
     */

    @When("user clicks on Departments option")
    public void user_clicks_on_departments_option() {
        clickOnDepartmentOption();
    }
    @When("user clicks on Add Departments link")
    public void user_clicks_on_add_departments_link() {
        clickOnAddDepartmentLink();
    }
    @When("user enters Departments detilas from {string} sheet and {int}")
    public void user_enters_departments_detilas_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String dep = testdata.get(rownumber).get("Department");
            enterDepartment(dep);
            waitupto(500);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String potenagency = testdata.get(rownumber).get("Potential Agency/Firm");
            selectPotentialAgency(potenagency);
            waitupto(500);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String depdesc = testdata.get(rownumber).get("DepartmentDescription");
            enterDepartmentDes(depdesc);
            waitupto(500);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("clicks on Department submit button")
    public void clicks_on_department_submit_button() {
        clickOnDepartmentSubBtn();
    }

    @When("user enters search Department information in search field")
    public void user_enters_search_department_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("Department");
            enterDepartmentSearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Department record in search grid")
    public void user_should_find_department_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("Department");
            Assertions.assertThat(complianceSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, Department search filed");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearDepartmentText();
    }
    @When("user enters Potential Agency or Firm search information in search field")
    public void user_enters_potential_agency_or_firm_search_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("Potential Agency/Firm");
            enterPotentialagencySearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Potential Agency or Firm record in search grid")
    public void user_should_find_potential_agency_or_firm_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("Potential Agency/Firm");
            Assertions.assertThat(departmentPotentialAgencySearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, Potential Agency/Firm search filed");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearDepartmentPotentailagencyText();
    }
    @When("user enters Department description search information in search field")
    public void user_enters_department_description_search_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("DepartmentDescription");
            enterDepDesSearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Department description record in search grid")
    public void user_should_find_department_description_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("DepartmentDescription");
            Assertions.assertThat(departmentDesSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, DepartmentDescription search filed");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearDepartmentdesText();
    }

    /**
     * Document Type
     */

    @When("user clicks on Document Type option")
    public void user_clicks_on_document_type_option() {
       clickOnDocumentTypeOption();
    }
    @When("user clicks on Add Document Type link")
    public void user_clicks_on_add_document_type_link() {
        clickOnAddDocumentTypeLink();
    }
    @When("user enters Document Type detilas from {string} sheet and {int}")
    public void user_enters_document_type_detilas_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String dep = testdata.get(rownumber).get("DocumentType");
            enterDocumentTypeText(dep);
            waitupto(500);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String depdesc = testdata.get(rownumber).get("DocumentTypeDescription");
            enterDocumentTypeDescriptionText(depdesc);
            waitupto(500);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("clicks on Document Type submit button")
    public void clicks_on_document_type_submit_button() {
      clickOnDocumentTypeSubBtn();
    }

    @When("user enters search Document type information in search field")
    public void user_enters_search_document_type_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("DocumentType");
            enterDocumentTypeSearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Document type record in search grid")
    public void user_should_find_document_type_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("DocumentType");
            Assertions.assertThat(documentTypeSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, Document Type search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearDocumentTypeSearchText();
    }
    @When("user enters Document type description search information in search field")
    public void user_enters_document_type_description_search_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("DocumentTypeDescription");
            enterdocumentTypeDesSearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Document type description record in search grid")
    public void user_should_find_document_type_description_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("DocumentTypeDescription");
            Assertions.assertThat(documentTypeDesSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, Document Type Description search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearDocumentTyoeDescText();
    }

    /**
     * Evaluation Criteria
     */

    @When("user clicks on Evaluation Criteria option")
    public void user_clicks_on_evaluation_criteria_option() {
        clickOnEvalutationCriteriaOption();
    }
    @When("user clicks on Add Evaluation Criteria link")
    public void user_clicks_on_add_evaluation_criteria_link() {
       clickOnAddEvaluationCriteriaLink();
    }
    @When("user enters Evaluation Criteria detilas from {string} sheet and {int}")
    public void user_enters_evaluation_criteria_detilas_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String dep = testdata.get(rownumber).get("EvaluationCriteria");
            enterEvaluationCriteriaText(dep);
            waitupto(500);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("clicks on Evaluation Criteria submit button")
    public void clicks_on_evaluation_criteria_submit_button() {
        clickOnEvaluationCriteriaSubBtn();
    }

    @When("user enters search Evaluation Criteria information in search field")
    public void user_enters_search_evaluation_criteria_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("EvaluationCriteria");
            enterEvaluationCriteriaSearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Evaluation Criteria record in search grid")
    public void user_should_find_evaluation_criteria_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("EvaluationCriteria");
            Assertions.assertThat(evaluationCriteriaSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, Evaluation Criteria search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearEvaluationCriteriaSearchText();
    }

    /**
     * NAICS code
     */

    @When("user clicks on NAICS Code option")
    public void user_clicks_on_naics_code_option() {
        clickOnNAICScodeOption();
    }
    @When("user clicks on Add NAICS Code link")
    public void user_clicks_on_add_naics_code_link() {
        clickOnAddNAICScodeLink();
    }
    @When("user enters NAICS code detilas from {string} sheet and {int}")
    public void user_enters_naics_code_detilas_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String dep = testdata.get(rownumber).get("NAICScode");
            enterNAICScodeText(dep);
            waitupto(500);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String nacisdes = testdata.get(rownumber).get("NAICScodeDescription");
            enterNAICScodeDesText(nacisdes);
            waitupto(500);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("clicks on NAICS code submit button")
    public void clicks_on_naics_code_submit_button() {
        clickOnNAOCScodeSubBtn();
    }

    @When("user enters search NAICS code information in search field")
    public void user_enters_search_naics_code_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("NAICScode");
            enterNAICScodeSearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }

    }
    @Then("user should find NAICS code record in search grid")
    public void user_should_find_naics_code_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("NAICScode");
            Assertions.assertThat(NAICScodeSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, NAICS code search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearNAICScodeSearchText();
    }
    @When("user enters search NAICS code description information in search field")
    public void user_enters_search_naics_code_description_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("NAICScodeDescription");
            enterNAICScodedesSearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find NAICS code description record in search grid")
    public void user_should_find_naics_code_description_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("NAICScodeDescription");
            Assertions.assertThat(NAICScodeDesSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, NAICS code Description search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearNAICScodeDesSearchText();
    }
    /**
     * NewOrRecompete
     */

    @When("user clicks on New Or Recompete option")
    public void user_clicks_on_new_or_recompete_option() {
        clickOnNewOrRecompeteOption();
    }
    @When("user clicks on Add New or Recompete link")
    public void user_clicks_on_add_new_or_recompete_link() {
        clickOnAddNewOrRecompeteLink();
    }
    @When("user enters New or Recompete detilas from {string} sheet and {int}")
    public void user_enters_new_or_recompete_detilas_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String dep = testdata.get(rownumber).get("Type");
            enterTypeText(dep);
            waitupto(500);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String nacisdes = testdata.get(rownumber).get("Description");
            enterDescriptionText(nacisdes);
            waitupto(500);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("clicks on New or Recompete submit button")
    public void clicks_on_new_or_recompete_submit_button() {
       clickOnNewOrRecompeteSubBtn();
    }

    @When("user enters search Type information in search field")
    public void user_enters_search_type_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("Type");
            enterTypeSearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Type record in search grid")
    public void user_should_find_type_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("Type");
            Assertions.assertThat(typeSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, Type Description search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearTypeSearchText();
    }
    @When("user enters search description information in search field")
    public void user_enters_search_description_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("Description");
            enterDescrptionSearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find description record in search grid")
    public void user_should_find_description_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("Description");
            Assertions.assertThat(descriptionSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, Description search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearDesSearchText();
    }

    /**
     * P4 Actions
     */

    @When("user clicks on P4 Actions option")
    public void user_clicks_on_p4_actions_option() {
        clickOnP4ActionsOption();
    }
    @When("user clicks on Add P4 Actions link")
    public void user_clicks_on_add_p4_actions_link() {
        clickOnAddp4ActionsLink();
    }
    @When("user enters P4 Actions detilas from {string} sheet and {int}")
    public void user_enters_p4_actions_detilas_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String dep = testdata.get(rownumber).get("P4Actions");
            enterp4ActionsText(dep);
            waitupto(500);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String nacisdes = testdata.get(rownumber).get("P4Actions Description");
            enterP4ActionsDescriptionText(nacisdes);
            waitupto(500);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("clicks on P4 Action submit button")
    public void clicks_on_p4_action_submit_button() {
       clickOnp4ActionSubBtn();
    }

    @When("user enters search P4 Actions information in search field")
    public void user_enters_search_p4_actions_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("P4Actions");
            enterP4ActionsSearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find P4 Actions record in search grid")
    public void user_should_find_p4_actions_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("P4Actions");
            Assertions.assertThat(p4ActionsSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, P4 Actions search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearP4ActionsText();
    }
    @When("user enters search P4 Actions description information in search field")
    public void user_enters_search_p4_actions_description_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("P4Actions Description");
            enterP4ActionsDescrptionSearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find P4 Actions description record in search grid")
    public void user_should_find_p4_actions_description_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("P4Actions Description");
            Assertions.assertThat(p4ActionsDesSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, P4 Actions description search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearP4ActionsDesSearchText();
    }

    @When("user clicks on P4 Status option")
    public void user_clicks_on_p4_status_option() {
        clickOnP4StatuaOption();
    }
    @When("user clicks on Add P4 Status link")
    public void user_clicks_on_add_p4_status_link() {
        clickOnAddp4StatusLink();
    }
    @When("user enters P4 Status detilas from {string} sheet and {int}")
    public void user_enters_p4_status_detilas_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String dep = testdata.get(rownumber).get("P4Status");
            enterp4StatusText(dep);
            waitupto(500);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String nacisdes = testdata.get(rownumber).get("P4Status Description");
            enterP4StatusDescriptionText(nacisdes);
            waitupto(500);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("clicks on P4 Status submit button")
    public void clicks_on_p4_status_submit_button() {
        clickOnp4StatusSubBtn();
    }

    @When("user enters search P4 Status information in search field")
    public void user_enters_search_p4_status_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("P4Status");
            enterP4StatusSearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find P4 Status record in search grid")
    public void user_should_find_p4_status_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("P4Status");
            Assertions.assertThat(p4StatusSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, P4 Status description search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearP4StatusText();
    }
    @When("user enters search P4 Status description information in search field")
    public void user_enters_search_p4_status_description_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("P4Status Description");
            enterP4StatusDescrptionSearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find P4 Status description record in search grid")
    public void user_should_find_p4_status_description_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("P4Status Description");
            Assertions.assertThat(p4StatusDesSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, P4 Status description search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearP4StatusDesSearchText();
    }

    /**
     * Priority
     */

    @When("user clicks on Priority option")
    public void user_clicks_on_priority_option() {
      clickOnPriorityOption();
    }
    @When("user clicks on Add Priority link")
    public void user_clicks_on_add_priority_link() {
        clickOnAddPriorityLink();
    }
    @When("user enters Priority detilas from {string} sheet and {int}")
    public void user_enters_priority_detilas_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String dep = testdata.get(rownumber).get("Priority");
            enterpriorityText(dep);
            waitupto(500);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("clicks on Priority submit button")
    public void clicks_on_priority_submit_button() {
       clickOnPrioritySubBtn();
    }

    @When("user enters search Priority information in search field")
    public void user_enters_search_priority_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("Priority");
            enterPrioritySearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Priority record in search grid")
    public void user_should_find_priority_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("Priority");
            Assertions.assertThat(prioritySearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, Priority search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearPriorityText();
    }

    /**
     * Reqyirement type
     */


    @When("user clicks on Requirement Types option")
    public void user_clicks_on_requirement_types_option() {
        clickOnReqTypeOption();
    }
    @When("user clicks on Add Requirement Type link")
    public void user_clicks_on_add_requirement_type_link() {
        clickOnAddReqTypeLink();
    }
    @When("user enters Requirement Type detilas from {string} sheet and {int}")
    public void user_enters_requirement_type_detilas_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String dep = testdata.get(rownumber).get("RequirementType");
            enterReqTypeText(dep);
            waitupto(500);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String reqDes = testdata.get(rownumber).get("ReqTypeDescription");
            enterReqDesTypeText(reqDes);
            waitupto(500);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("clicks on Requirement Type submit button")
    public void clicks_on_requirement_type_submit_button() {
        clickOnReqTypeSubBtn();
    }

    @When("user enters search Requirement Type information in search field")
    public void user_enters_search_requirement_type_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("RequirementType");
            enterReqTypeSearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Requirement Type record in search grid")
    public void user_should_find_requirement_type_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("RequirementType");
            Assertions.assertThat(reqTypeSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, Requirement Type search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearReqTypeText();
    }
    @When("user enters search Requirement Type Description information in search field")
    public void user_enters_search_requirement_type_description_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("ReqTypeDescription");
            enterReqTypeDesSearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Requirement Type Description record in search grid")
    public void user_should_find_requirement_type_description_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("ReqTypeDescription");
            Assertions.assertThat(reqTypeDesSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, Requirement Type Description search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearReqTypeDesText();
    }

    /**
     * RFP Types
     */

    @When("user clicks on RFP Types option")
    public void user_clicks_on_rfp_types_option() {
       clickOnRfpTypeOption();
    }
    @When("user clicks on Add RFP Type link")
    public void user_clicks_on_add_rfp_type_link() {
       clickOnAddRfpTypeLink();
    }
    @When("user enters RFP Type detilas from {string} sheet and {int}")
    public void user_enters_rfp_type_detilas_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String dep = testdata.get(rownumber).get("RFPType");
            enterRfpTypeText(dep);
            waitupto(500);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String reqDes = testdata.get(rownumber).get("RFPTypeDescription");
            enterRfpDesTypeText(reqDes);
            waitupto(500);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("clicks on RFP Type submit button")
    public void clicks_on_rfp_type_submit_button() {
        clickOnRfpTypeSubBtn();
    }

    @When("user enters search RFP Type information in search field")
    public void user_enters_search_rfp_type_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("RFPType");
            enterRfpTypeSearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find RFP Type record in search grid")
    public void user_should_find_rfp_type_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("RFPType");
            Assertions.assertThat(rfpTypeSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, RFP Type Description search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
            clearRfpTypeText();

    }
    @When("user enters search RFP Type Description information in search field")
    public void user_enters_search_rfp_type_description_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("RFPTypeDescription");
            enterRfpTypeDesSearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find RFP Type Description record in search grid")
    public void user_should_find_rfp_type_description_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("RFPTypeDescription");
            Assertions.assertThat(rfpTypeDesSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, RFP Type Description search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearRfpTypeDesText();
    }

    /**
     * Set Aside
     */
    @When("user clicks on Set Aside option")
    public void user_clicks_on_set_aside_option() {
       clickOnSetAsideOption();
    }
    @When("user clicks on Add Set Aside link")
    public void user_clicks_on_add_set_aside_link() {
        clickOnAddSetAsideLink();
    }
    @When("user enters Set Aside detilas from {string} sheet and {int}")
    public void user_enters_set_aside_detilas_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String dep = testdata.get(rownumber).get("SetAside");
            enterSetAsideText(dep);
            waitupto(500);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String setasiddes = testdata.get(rownumber).get("SetAsideDescription");
            enterSetAsideDesText(setasiddes);
            waitupto(500);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("clicks on Set Aside submit button")
    public void clicks_on_set_aside_submit_button() {
        clickOnSetAsideSubBtn();
    }

    @When("user enters search Set Aside information in search field")
    public void user_enters_search_set_aside_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("SetAside");
            enterSetAsideSearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Set Aside record in search grid")
    public void user_should_find_set_aside_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("SetAside");
            Assertions.assertThat(setAsideSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, Set Aside search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearSetAsideText();
    }
    @When("user enters search Set Aside Description information in search field")
    public void user_enters_search_set_aside_description_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("SetAsideDescription");
            enterSetAsideDesSearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Set Aside Description record in search grid")
    public void user_should_find_set_aside_description_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("SetAsideDescription");
            Assertions.assertThat(setasideDesSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, Set Aside description search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearSetAsideDesText();
    }

    /**
     * Type Of Contract
     */

    @When("user clicks on Type of Contract option")
    public void user_clicks_on_type_of_contract_option() {
        clickOnTypeOfConractOption();
    }
    @When("user clicks on Add Type of Contract link")
    public void user_clicks_on_add_type_of_contract_link() {
       clickOnAddTypeOfContractLink();
    }
    @When("user enters Type of Contract detilas from {string} sheet and {int}")
    public void user_enters_type_of_contract_detilas_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String dep = testdata.get(rownumber).get("TypeOfContract");
            enterTypeOfContractText(dep);
            waitupto(500);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String setasiddes = testdata.get(rownumber).get("TypeOfContractDescription");
            enterTypeOfContractDesText(setasiddes);
            waitupto(500);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("clicks on Type of Contract submit button")
    public void clicks_on_type_of_contract_submit_button() {
        clickOnTypeOfContractSubBtn();
    }


    @When("user enters search Type of Contract information in search field")
    public void user_enters_search_type_of_contract_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("TypeOfContract");
            enterTypeOfContractSearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Type of Contract record in search grid")
    public void user_should_find_type_of_contract_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("TypeOfContract");
            Assertions.assertThat(typeOfContractSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, Type of conract search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearTypeOfConractText();
    }
    @When("user enters search Type of Contract Description information in search field")
    public void user_enters_search_type_of_contract_description_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departmentinfo = testdata.get(0).get("TypeOfContractDescription");
            enterTypeOfContractDesSearchInfo(departmentinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Type of Contract Description record in search grid")
    public void user_should_find_type_of_contract_description_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "Master");
            String departinfo = testdata.get(0).get("TypeOfContractDescription");
            Assertions.assertThat(typeOfContractDesSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, Type of conract description search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearTypeOfContractDesText();
    }


    /**
     * Teaming Partner
     */


    @When("user clicks on Teaming Partner option")
    public void user_clicks_on_teaming_partner_option() {
        clickOnTeamingPartnersOption();
    }
    @When("user clicks on Add Teaming Partners link")
    public void user_clicks_on_add_teaming_partners_link() {
        clickOnAddTeamingPartnerLink();
    }

    @Then("user should navigate to the {string} window")
    public void user_should_navigate_to_the_window(String exptitle) {
        Assertions.assertThat(actualPageTitle()).isEqualTo(exptitle);
        log().info("User navigated to " + actualPageTitle() + " window");
        waitupto(500);

    }
    @When("user enters Teaming partners detilas from {string} sheet and {int}")
    public void user_enters_teaming_partners_detilas_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String cmpname = testdata.get(rownumber).get("Company Name");
            enterCompanyNameText(cmpname);
            waitupto(500);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String web = testdata.get(rownumber).get("Website");
            enterWesiteText(web);
            waitupto(500);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String address = testdata.get(rownumber).get("Address");
            enterAddressText(address);
            waitupto(500);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String city = testdata.get(rownumber).get("City");
            enterCityText(city);
            waitupto(500);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String state = testdata.get(rownumber).get("State");
            selectTeamingParterState(state);
            waitupto(500);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String zipcode = testdata.get(rownumber).get("ZIP Code");
            enterZipCodeText(zipcode);
            waitupto(500);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String phone = testdata.get(rownumber).get("Phone");
            enterPhonenumberText(phone);
            waitupto(500);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String email = testdata.get(rownumber).get("Email");
            enterEmailText(email);
            waitupto(500);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String cap = testdata.get(rownumber).get("Capability");
            enterCapability(cap);
            waitupto(500);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String role = testdata.get(rownumber).get("Role");
            selectRole(role);
            waitupto(500);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String agency = testdata.get(rownumber).get("Agency");
            selectAgnencyOrFirmTeamingPartner(agency);
            waitupto(500);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("clicks on teaming parner save button")
    public void clicks_on_teaming_parner_save_button() {
      clickOnTeamingPartnerSaveBtn();
    }

    @When("user enters search Company Name information in search field")
    public void user_enters_search_company_name_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "TeamingPartner");
            String compnameinfo = testdata.get(0).get("Company Name");
            enterCompanyNameSearchText(compnameinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Company Name record in search grid")
    public void user_should_find_company_name_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "TeamingPartner");
            String departinfo = testdata.get(0).get("Company Name");
            Assertions.assertThat(companyNameSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, company name search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearCompNameText();
    }
    @When("user enters search Address information in search field")
    public void user_enters_search_address_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "TeamingPartner");
            String compnameinfo = testdata.get(0).get("Address");
            enterAddressSearchText(compnameinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find Address record in search grid")
    public void user_should_find_address_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "TeamingPartner");
            String departinfo = testdata.get(0).get("Address");
            Assertions.assertThat(addressSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, Address search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearAddressSearchText();
    }
    @When("user enters search Email information in search field")
    public void user_enters_search_email_information_in_search_field() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "TeamingPartner");
            String compnameinfo = testdata.get(0).get("Email");
            enterEmailSearchText(compnameinfo);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
           }
    @Then("user should find Email record in search grid")
    public void user_should_find_email_record_in_search_grid() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), "TeamingPartner");
            String departinfo = testdata.get(0).get("Email");
            Assertions.assertThat(emailSearchResult()).isEqualTo(departinfo);
            log().info("Found '" + departinfo + "' in, Email search field");

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        clearEmailSearchText();
    }

    @When("user clicks on Exit button")
    public void user_clicks_on_exit_button() {

    }

    @When("user clicks on Teaming partner Edit icon")
    public void user_clicks_on_teaming_partner_edit_icon() {
      clickOnTeaminEditButton();
    }
    @When("user clicks on Teaming partner Exit button")
    public void user_clicks_on_teaming_partner_exit_button() {
        clickOnTeamingPartnerExitButton();
    }

    @Then("user should navigate to teaming partner {string} page")
    public void user_should_navigate_to_teaming_partner_page(String expected) {
        Assertions.assertThat(expTeamingPartnerTitle()).isEqualTo(expected);
        log().info("User navigated to " + expTeamingPartnerTitle() + " window");
        waitupto(500);
    }

    @Then("user should navigate to the {string} page")
    public void user_should_navigate_to_the_page(String exp) {
        Assertions.assertThat(actualHeading()).isEqualTo(exp);
        log().info("Found page heading as " + actualHeading());
    }

}


