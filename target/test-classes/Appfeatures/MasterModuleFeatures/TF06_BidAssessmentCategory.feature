Feature: Bid Assessment Catefory feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "Bid Assessment Category" option under master menu
    When user clicks on Bid Assessment Category option
    Then page heading should be as "Bid Assessment Category"

  @BidAssessmentCategory
  Scenario Outline: Bid Assessment Category functionality
    When user clicks on Add Bid Assessment Category link
    Then user should navigate to "Create Bid Assessment Category" window
    When user enters Bid Assesment Category detilas from "Master" sheet and <RowNumber>
    And clicks on Bid Assesment Category submit button
    Examples:
      | RowNumber |
      | 0         |

  @BidAssessmentCategorySearchFunctionality
  Scenario: Bid Assessment Category search functionality
    When user enters search Bid Assessment Category information in search field
    Then user should find Bid Assessment Category record in search grid

  @BidAssesmentCateforyActionitems
  Scenario: Bid Assessment Category Action functionality
    When user clicks on Edit icon
    Then user should navigate to "Update Bid Assessment Category" window
    When user clicks on delete icon
    Then user get delete confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close

