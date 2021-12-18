package org.issi.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import static org.issi.pages.DashboardPage.*;

public class DashboardSteps {

    private static String dashboardpageheading;

    @When("user clicks on Dashboard menu")
    public void user_clicks_on_dashboard_menu() {
            clickOnDashboar();
           }

    @When("user get the Dashboard page heading")
    public void user_get_the_dashboard_page_heading() {
           dashboardpageheading = dashboardHeading();
    }


    @Then("Dashboard page heading should be as {string}")
    public void dashboard_page_heading_should_be_as(String actualHeading) {
        Assertions.assertThat(dashboardpageheading).isEqualTo(actualHeading);
        log().info("Found Dashboard page heading as : " + dashboardpageheading);
    }

    @When("user select year and month from drop down")
    public void user_select_year_and_month_from_drop_down() {
        selectYear();
        selectMonth();
    }

    /**
     * Dashboard Bid Status functionality
     */

    @When("user scroll to Bid status value")
    public void user_scroll_to_bid_status_value() {
        scrollToBidStatusValue("On-Hold");
        waitupto(500);
    }
    @When("clicks on Bid Staus count")
    public void clicks_on_bid_staus_count() {
        clickOnSpecificBidStatus("On-Hold","2");
        waitupto(500);
    }

    @Then("user gets window with {string} heading")
    public void user_gets_window_with_heading(String ActualHeading) {
        String biddatawindowheading = biddataHeading();
        Assertions.assertThat(biddatawindowheading).isEqualTo(ActualHeading);
        log().info("Found Bid Data window heading as : " + biddatawindowheading);
         }

    @When("user clicks on OMEGA SYSTEMS Proposal link")
    public void user_clicks_on_omega_systems_proposal_link() {
       clickOnTitle();
       waitupto(300);
    }
    @Then("user should navigate to {string} page")
    public void user_should_navigate_to_page(String Actualrfpheading) {
        String rfppageheading = rfpPageHeading();
        Assertions.assertThat(rfppageheading).isEqualTo(Actualrfpheading);
        log().info("Found RFP and Proposal page heading is : " + rfppageheading);
    }
    /**
     * Bid Source Steps
     */

    @When("user scroll to Bid source value")
    public void user_scroll_to_bid_source_value() {
        scrollToBidSourceValue("FBO");
        waitupto(500);
            }
    @When("clicks on Bid source count")
    public void clicks_on_bid_source_count() {
        clickOnSpecificBidSource("FBO","3");
        waitupto(500);
    }
    @When("user clicks on Apple Dev Supp link")
    public void user_clicks_on_apple_dev_supp_link() {
        clickOnSourceTitle();
        waitupto(500);
    }

    /**
     * identified by steps
     */
    @When("user scroll to identified by value")
    public void user_scroll_to_idnetified_by_value() {
        scrollToIdentifiedbyValue("satish");
        waitupto(500);
    }
    @When("clicks on identified by count")
    public void clicks_on_identified_by_count() {
       clickOnSpecificBidIdentified("satish","2");
       waitupto(500);
    }
    @When("user clicks on ebs link")
    public void user_clicks_on_ebs_link() {
        clickOnIdentifiedByTitle();
        waitupto(500);
    }
    /**
     * Contract Type
     */

    @When("user scroll to contract type value")
    public void user_scroll_to_contract_type_value() {
        scrollToContractTypeValue("Task Orders");
        waitupto(500);
    }
    @When("clicks on contract type count")
    public void clicks_on_contract_type_count() {
        clickOnSpecificBidcontracttype("Task Orders","1");
        waitupto(500);
    }
    @When("user clicks on ibts - ARMS project link")
    public void user_clicks_on_ibts_arms_project_link() {
        clickOnContractTypeTitle();
        waitupto(500);
    }

    /**
     * set Aside
     */

    @When("user scroll to set aside value")
    public void user_scroll_to_set_aside_value() {
        scrollToSetAsideValue("Hubzone");
        waitupto(500);
    }
    @When("clicks on set aside count")
    public void clicks_on_set_aside_count() {
        clickOnSpecificBidsetaside("Hubzone","1");
        waitupto(500);
    }
    @When("user clicks on Telenor systems capture proposal link")
    public void user_clicks_on_telenor_systems_capture_proposal_link() {
        clickOnSetAsideTitle();
        waitupto(500);
            }
}
