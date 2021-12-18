Feature: Dashboard Feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"

  @Year&MonthinDasboar
  Scenario: Select Month and Year functionality in Dashboar
    When user clicks on Dashboard menu
    And user get the Dashboard page heading
    Then Dashboard page heading should be as "Dashboard"
    When user select year and month from drop down

  @DashboardBidStatus
  Scenario: Bid status functionality in Dashboard
    When user scroll to Bid status value
    And clicks on Bid Staus count
    Then user gets window with "Bid Data" heading
    When user clicks on OMEGA SYSTEMS Proposal link
    Then user should navigate to "Add New / Edit RFP and Proposals" page

  @DashboardBidSource
  Scenario: Bid source functionality in Dashboard
    When user scroll to Bid source value
    And clicks on Bid source count
    Then user gets window with "Bid Data" heading
    When user clicks on Apple Dev Supp link
    Then user should navigate to "Add New / Edit RFP and Proposals" page

  @DashboardIdentifiedBy
  Scenario: Bid Identified by functionality in Dashboard
    When user scroll to identified by value
    And clicks on identified by count
    Then user gets window with "Bid Data" heading
    When user clicks on ebs link
    Then user should navigate to "Add New / Edit RFP and Proposals" page

  @DashboardContractType
  Scenario: Bid contract type functionality in Dashboard
    When user scroll to contract type value
    And clicks on contract type count
    Then user gets window with "Bid Data" heading
    When user clicks on ibts - ARMS project link
    Then user should navigate to "Add New / Edit RFP and Proposals" page

  @DashboardSetAside
  Scenario: Bid set aside functionality in Dashboard
    When user scroll to set aside value
    And clicks on set aside count
    Then user gets window with "Bid Data" heading
    When user clicks on Telenor systems capture proposal link
    Then user should navigate to "Add New / Edit RFP and Proposals" page



