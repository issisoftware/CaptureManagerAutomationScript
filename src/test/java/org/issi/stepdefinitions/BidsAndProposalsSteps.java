package org.issi.stepdefinitions;

import io.cucumber.java.en.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.assertj.core.api.Assertions;
import org.issi.constants.FrameworkConstants;
import org.issi.utilities.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.issi.pages.BidsAndProposals.BidsAndProposalsPage.*;
import static org.issi.pages.BidsAndProposals.CapturePlanTab.*;
import static org.issi.pages.BidsAndProposals.RequirementsTab.*;
import static org.issi.pages.BidsAndProposals.ISSIcapabilityTab.*;
import static org.issi.pages.BidsAndProposals.IncumbentAndContacts.*;
import static org.issi.pages.BidsAndProposals.TeamingAndSubContracting.*;
import static org.issi.pages.BidsAndProposals.TeamingMatrix.*;
import static org.issi.pages.BidsAndProposals.SWOTanalysis.*;
import static org.issi.pages.BidsAndProposals.FileUpload.*;
import static org.issi.pages.BidsAndProposals.ResourceRequired.*;
import static org.issi.pages.BidsAndProposals.CommentsPage.*;
import static org.issi.pages.BidsAndProposals.HistoryTab.*;


public class BidsAndProposalsSteps {

    public List<Map<String, String>> testdata;
    ExcelReader reader = new ExcelReader();


    @When("user clicks on Bids and Proposals module")
    public void user_clicks_on_bids_and_proposals_module() {
       clickOnBidsAndProposalMenu();
    }
    @Then("user should find {string} option")
    public void user_should_find_option(String expected) {
        Assertions.assertThat(getRfpAndProposalText()).isEqualTo(expected);
        log().info("Found "+ getRfpAndProposalText()+" option");
    }
    @When("user clicks on RFP and Proposals option")
    public void user_clicks_on_rfp_and_proposals_option() {
       clickOnRfpAndProposalOption();
    }

    @Then("user sholuld navigate to {string} page")
    public void user_sholuld_navigate_to_page(String expected) {
        Assertions.assertThat(getPageHeading()).isEqualTo(expected);
        log().info("Found page heading as : "+ getPageHeading());
    }
    @When("user clicks on Add New Bid link")
    public void user_clicks_on_add_new_bid_link() {
        clickOnAddNewBidLink();
    }

    @Then("user should navigate the page heading as {string}")
    public void user_should_navigate_the_page_heading_as(String expected) {
       Assertions.assertThat(pageHeadingForAddNewBid()).isEqualTo(expected);
       log().info("Found page heading after navigation as :" + pageHeadingForAddNewBid());
    }
    /**
     * Search functionality
     */

    @When("user enters Solicitation Id in search box")
    public void user_enters_solicitation_id_in_search_box() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), FrameworkConstants.getCapturPlanSheetName());
            String idValue= testdata.get(FrameworkConstants.getRowNumberFromSheet()).get("Solicitation ID");
            enterSearchSolicitationId(idValue);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    @When("clicks on search button")
    public void clicks_on_search_button() {
       clickOnRFPandPropSearchBtn();
    }

    @Then("user should find solicitation id in search table")
    public void user_should_find_solicitation_id_in_search_table() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), FrameworkConstants.getCapturPlanSheetName());
            String idValue= testdata.get(FrameworkConstants.getRowNumberFromSheet()).get("Solicitation ID");

            Assertions.assertThat(getRFPandProSearchResult()).isEqualTo(idValue);
            log().info("Found Solicitation id in search table as : " + getRFPandProSearchResult());

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("user clicks on Edit icon in search table")
    public void user_clicks_on_edit_icon_in_search_table() {
        clickOnRFPandProEditIcon();
    }

    /**
     * Capture Plan tab
     */
    @Given("user clicks on Capture Plan tab")
    public void user_clicks_on_capture_plan_tab() {
        clickOnCapturePlanTab();
    }

    @Then("user should navigate to {string} tab")
    public void user_should_navigate_to_tab(String exp) {
        Assertions.assertThat(tabHeading(exp)).isEqualTo(exp);
        log().info("Found tab heading as "+ tabHeading(exp));
    }

    @When("user fills Capture Plan details from {string} sheet and {int}")
    public void user_fills_capture_plan_details_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  capturenamefrmsheet= testdata.get(rownumber).get("Capture Name");
            enterCaptureNameText(capturenamefrmsheet);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  soliciationidfrmsheet= testdata.get(rownumber).get("Solicitation ID");
            enterSoliciationIDText(soliciationidfrmsheet);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  issifrmsheet= testdata.get(rownumber).get("ISSI");
            selectIssIDrpDwn(issifrmsheet);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  bidsourcetypefrmsheet= testdata.get(rownumber).get("Bid Source Type");
            selectBidSourceTypeDrpDwn(bidsourcetypefrmsheet);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  bidsourcefrmsheet= testdata.get(rownumber).get("Bid Sources");
            selectBidSourceDrpDwn(bidsourcefrmsheet);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  datepostedvalue= testdata.get(rownumber).get("Date Posted");
            enterDatePostedDate(datepostedvalue);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  naicscode= testdata.get(rownumber).get("NAICS Code");
            selectNaicsCodeDrpDwn(naicscode);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  agecny= testdata.get(rownumber).get("Agency");
            selectAgencyDrpDwn(agecny);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  bidstatusvalue= testdata.get(rownumber).get("Bid Status");
            selectBidStatusDrpDwn(bidstatusvalue);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  identifiedbyvalue= testdata.get(rownumber).get("Identified by");
            selectIdentifiedByDrpDwn(identifiedbyvalue);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  duedatevalue= testdata.get(rownumber).get("Due Date");
            enterDueDateText(duedatevalue);


        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("user clicks on Capture Plan submit button")
    public void user_clicks_on_capture_plan_submit_button() {
        clickOnCapturePlanSaveBtn();
        log().info("'" + getConfirmText() +"' Message displayed");
        waitupto(500);
    }

    @When("user clicks on next button in capture plan tab")
    public void user_clicks_on_next_button_in_capture_plan_tab() {
        clickOnNextBtnInCapTab();
    }


    /**
     * Requirements Tab
     */

    @When("user clicks on Requirements tab")
    public void user_clicks_on_requirements_tab() {
       clickOnReqTab();
    }

    @Then("user should navigate to the {string} tab")
    public void user_should_navigate_to_the_tab(String heading) {
        Assertions.assertThat(getHeading(heading)).isEqualTo(heading);
        log().info("Found the tab heading as " + getHeading(heading));
    }

    @When("user clicks on Add New Requirement link")
    public void user_clicks_on_add_new_requirement_link() {
        clickOnAddNewRequirementLink();
    }

    @Then("user should get {string} window open")
    public void user_should_get_window_open(String expected) {
        Assertions.assertThat(getOpenWindowHeading(expected)).isEqualTo(expected);
        log().info("found page heading as : "+ getOpenWindowHeading(expected));
    }
    @When("user fills Requirements details from {string} sheet and {int}")
    public void user_fills_requirements_details_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  tasktype= testdata.get(rownumber).get("Task Type");
            selectTaskType(tasktype);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  taskarea= testdata.get(rownumber).get("Task Area");
            enterTaskArea(tasktype);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  rfpreq= testdata.get(rownumber).get("RFP Requirement");
            enterRfpRequirementText(rfpreq);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  rfpsec= testdata.get(rownumber).get("RFP Section");
            enterRfpSectionTect(rfpsec);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  ec= testdata.get(rownumber).get("Evaluation Criteria");
            selectEvalutaionvalue(ec);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  sumr= testdata.get(rownumber).get("Summary");
            enterSummaryText(sumr);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  exp= testdata.get(rownumber).get("Experience");
            enterExpText(exp);
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  prio= testdata.get(rownumber).get("Priority");
            selectPriority(prio);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }

    }
    @When("user clicks on add requirement window submit button")
    public void user_clicks_on_add_requirement_window_submit_button() {
        clickOnAddReqSbtBtn();
        log().info("'" + getConfirmText() +"' Message displayed");
        waitupto(500);
    }

    @When("user clicks on Next button in Requirements tab")
    public void user_clicks_on_next_button_in_requirements_tab() {
        clickOnReqNextBtn();
    }

    /**
     * IssI Capability
     */

    @When("user clicks on ISSI Capability tab")
    public void user_clicks_on_issi_capability_tab() {
        clickOnIssICapTabLink();
    }
    @When("user enter Task type details from {string} sheet and {int}")
    public void user_enter_task_type_details_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  tasktype= testdata.get(rownumber).get("Task Type");
            enterTypeSearchText(tasktype);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @Then("user should find added requirement task type in issi capability search table")
    public void user_should_find_added_requirement_task_type_in_issi_capability_search_table() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), FrameworkConstants.getRequirementSheetName());
            String  tasktype= testdata.get(FrameworkConstants.getRowNumberFromSheet()).get("Task Type");

            Assertions.assertThat(getSearchTypeResult()).isEqualTo(tasktype);
            log().info("Found Task type in ISSI Capability search field as "+ getSearchTypeResult());
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("user select ISSI option in search table")
    public void user_select_issi_option_in_search_table() {
       selectIssiOption("Maybe");
        log().info("'" + getConfirmText() +"' Message displayed");
        waitupto(500);

    }
    @When("user clicks on issi capability next button")
    public void user_clicks_on_issi_capability_next_button() {
       clickOnIssInextBtn();
    }


    /**
     * Incumbent And Contacts
     */
    @When("user clicks on IncumbentAndContact tab")
    public void user_clicks_on_incumbent_and_contact_tab() {
       clickOnIncumbentAndContactsTab();
    }
    @When("user clicks on Add Incumbent and Contact link")
    public void user_clicks_on_add_incumbent_and_contact_link() {
       clickOnAddIncumbentAndContactLink();
    }

    @When("user fills incumbent details from {string} sheet and {int}")
    public void user_fills_incumbent_details_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  compname= testdata.get(rownumber).get("Company Name");
            enterCompanyNameText(compname);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  taskarea= testdata.get(rownumber).get("Task Area");
            enterTaskAreaText(taskarea);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  busssize= testdata.get(rownumber).get("Business Size");
            enterBusinessSizeText(busssize);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  address= testdata.get(rownumber).get("Address");
            enterAddressText(address);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  prgmanname= testdata.get(rownumber).get("Program Manager Name");
            enterProgManagerNameText(prgmanname);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  prgmanph= testdata.get(rownumber).get("Program Manager Phone");
            enterProgManagerPhoneText(prgmanph);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  prgmanemail= testdata.get(rownumber).get("Program Manager Email");
            enterProgMangerEmail(prgmanemail);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    @When("user clicks on add incumbentAndContact window submit button")
    public void user_clicks_on_add_incumbent_and_contact_window_submit_button() {
      clickOnIncumbentAndContacSbtBtn();
        log().info("'" + getConfirmText() +"' Message displayed");
        waitupto(500);
    }
    @When("user clicks on Next button in incumbentAndContact tab")
    public void user_clicks_on_next_button_in_incumbent_and_contact_tab() {
        clickOnIncumbNextBtn();
    }

    /**
     * TeamingAndSubContracting
     */

    @When("user clicks on Teaming and sub contacting tab")
    public void user_clicks_on_teaming_and_sub_contacting_tab() {
       clickOnTeamingAndSubContractingTab();
    }

    @When("user clicks on Add Teaming and sub contracting link")
    public void user_clicks_on_add_teaming_and_sub_contracting_link() {
       clickOnAddTeamingAndSubContLink();
    }

    @When("user fills teaming and subcontracting details from {string} sheet and {int}")
    public void user_fills_teaming_and_subcontracting_details_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  partner= testdata.get(rownumber).get("Partner");
            selectPartnerFrmDrpDwn(partner);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  contacinfo= testdata.get(rownumber).get("Contact Information");
            selectContactinfoFrmDrpDwn(contacinfo);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  role = testdata.get(rownumber).get("Role");
            selectRoleFrmDrpDwn(role);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  respon = testdata.get(rownumber).get("Responded");
            selectRespondedFrmDrpDwn(respon);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  wrkstrdate = testdata.get(rownumber).get("Work Start Date");
            enterWorkStartDate(wrkstrdate);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  wrkenddate = testdata.get(rownumber).get("Work End Date");
            enterWorkEndDate(wrkenddate);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  perofwrk = testdata.get(rownumber).get("Percentage of Work");
            enterPercentageOfWrk(perofwrk);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  wrkshare = testdata.get(rownumber).get("Workshare");
            enterWorkShareText(wrkshare);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  ration = testdata.get(rownumber).get("Rationale");
            enterRationaleText(ration);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  cmts = testdata.get(rownumber).get("Comments");
            enterCommentsText(cmts);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }

    }
    @When("user clicks on add teamingandsubcontracting window submit button")
    public void user_clicks_on_add_teamingandsubcontracting_window_submit_button() {
        clickOnTeamingSubContSbtBtn();
        log().info("'" + getConfirmText() +"' Message displayed");
        waitupto(500);
    }
    @When("user clicks on Next button in teaming and subcontacting tab")
    public void user_clicks_on_next_button_in_teaming_and_subcontacting_tab() {
        clickOnTeamingAndSubNextBtn();
    }

    /**
     * Teaming Matrix
     */

    @When("user clicks on Teaming Matrix tab")
    public void user_clicks_on_teaming_matrix_tab() {
        clickOnTeamingMatrixTab();
    }

    @Then("user should find added requirement in teaming matrix page")
    public void user_should_find_added_requirement_in_teaming_matrix_page() {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), FrameworkConstants.getRequirementSheetName());
            String  req = testdata.get(FrameworkConstants.getRowNumberFromSheet()).get("RFP Requirement");

            Assertions.assertThat(getRequirementResult()).isEqualTo(req);
            log().info("Found "+ getRequirementResult() +"in Teaming Matrix page");
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    @When("user select teaming ISSI option in search table")
    public void user_select_teaming_issi_option_in_search_table() {
        selectTeamingOption("Maybe");
        waitupto(500);
        selectTeamingCompTechOption("Yes");
        waitupto(500);
        log().info("'" + getConfirmText() +"' Message displayed");
        waitupto(500);

    }

    @When("user clicks on Teamnig Matrix next button")
    public void user_clicks_on_teamnig_matrix_next_button() {
      clickOnTeamingInextBtn();
    }


    /**
     * SWOT analysis
     */

    @When("user clicks on SWOT analysis tab")
    public void user_clicks_on_swot_analysis_tab() {
        clickOnSWOTanalysisTab();
    }

    @When("user fills SWOT details from {string} sheet and {int}")
    public void user_fills_swot_details_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  strengths= testdata.get(rownumber).get("Strengths");
            enterStrengthText(strengths);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  weakness= testdata.get(rownumber).get("Weakness");
            enterWeaknessText(weakness);


            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  custissue= testdata.get(rownumber).get("CustomerIssues");
            enterCustomerIssuesText(custissue);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  avasolu= testdata.get(rownumber).get("AvailableSolutions");
            enterAvailableSoluText(avasolu);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  dis= testdata.get(rownumber).get("Discriminator");
            enterDiscriminatorText(dis);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  ga= testdata.get(rownumber).get("GA");
            enterGaText(ga);



        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }

    }

    @When("user clicks on SWOT analysis save button")
    public void user_clicks_on_swot_analysis_save_button() {
        clickOnSWOTsubBtn();
        log().info("'" + getConfirmText() +"' Message displayed");
        waitupto(500);

    }
    @When("user clicks on SWOT analysis Next button")
    public void user_clicks_on_swot_analysis_next_button() {
        clickOnSWOTnextBtn();
    }


    /**
     * File Upload
     */

    @When("user clicks on File Upload tab")
    public void user_clicks_on_file_upload_tab() {
       clickOnFileUploadTab();
    }

    @When("user upload a file and click on Attach button")
    public void user_upload_a_file_and_click_on_attach_button() {
        uploadFile();
        clickOnAttachButton();
        waitupto(1000);
        log().info("'" + getConfirmText() +"' Message displayed");
        waitupto(500);
    }


    @Then("user should find attached file in search grid")
    public void user_should_find_attached_file_in_search_grid() {
        enterFileNameinSearchBox("Selenium");
        Assertions.assertThat(getResultFrmSearchTable()).isEqualTo("Selenium.pdf");
        log().info("found "+getResultFrmSearchTable()+" From search table");
    }
    @Then("user clicks on file upload next button")
    public void user_clicks_on_file_upload_next_button() {
        clickOnFileUploadNextbtn();
    }

    /**
     * Resource Required
     */

    @When("user clicks on Resource Required tab")
    public void user_clicks_on_resource_required_tab() {
        clickOnResourceRequiredtab();
    }
    @When("user clicks on Add New Resource link")
    public void user_clicks_on_add_new_resource_link() {
       clickOnAddNewResourceLink();
    }

    @When("user fills resource details from {string} sheet and {int}")
    public void user_fills_resource_details_from_sheet_and(String sheetname, Integer rownumber) {
        try {
            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  resourcefirstname= testdata.get(rownumber).get("Resource First Name");
            enterResourceFirstName(resourcefirstname);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  rsourcelastname= testdata.get(rownumber).get("Resource LastName");
            enterResourceLastName(rsourcelastname);


            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  jobtitle = testdata.get(rownumber).get("Job Title");
            enterJobTitle(jobtitle);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  exp = testdata.get(rownumber).get("years of Experience");
            selectYearsOfExp(exp);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  rlevel = testdata.get(rownumber).get("Resource Level");
            selectResourceLevel(rlevel);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  jbdes = testdata.get(rownumber).get("Job Description");
            enterJobDescription(jbdes);

            testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String  attachment = testdata.get(rownumber).get("File path ");
            enterAttachment(attachment);



        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }

    }

    @When("user clicks on add resource window submit button")
    public void user_clicks_on_add_resource_window_submit_button() {
        clickOnResourceSubBtn();
        log().info("'" + getConfirmText() +"' Message displayed");
        waitupto(500);
    }
    @When("user clicks on Next button in resource required tab")
    public void user_clicks_on_next_button_in_resource_required_tab() {
       clickOnResouceNextBth();
    }

    /**
     * Comments steps
     */

    @When("user clicks on comments tab")
    public void user_clicks_on_comments_tab() {
        clickOnCommentsTab();
    }
    @When("user add comments in comments text filed")
    public void user_add_comments_in_comments_text_filed() {
       enterCommentsInText();
    }
    @When("user clicks on comments save button")
    public void user_clicks_on_comments_save_button() {
        clickOnCommentsSaveBtn();
        log().info("'" + getConfirmText() +"' Message displayed");
        waitupto(500);
    }

    /**
     * History tab
     */

    @When("user clicks on History tab")
    public void user_clicks_on_history_tab() {
        clickOnHistoryTab();
    }
    @Then("user should find Capture name under title search")
    public void user_should_find_capture_name_under_title_search() {
        Assertions.assertThat(getCaptureNameText()).isEqualTo("Apple Solutions");
        log().info("Found capture name text in history tab as "+ getCaptureNameText());
    }
    @When("user clicks on view icon")
    public void user_clicks_on_view_icon() {
        clickOnViewLink();
        waitupto(500);
    }

}
