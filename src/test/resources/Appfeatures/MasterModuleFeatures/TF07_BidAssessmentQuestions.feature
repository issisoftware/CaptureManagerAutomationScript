Feature: Bid Assessment Questions feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "Bid Assessment Questions" option under master menu
    When user clicks on Bid Assessment Questions option
    Then page heading should be as "Bid Assessment Questions"

  @BidAssessmentQuestions
  Scenario Outline: Bid Assessment Questions functionality
    When user clicks on Add Bid Assessment Questions link
    Then user should navigate to "Create Bid Assessment Questions" window
    When user enters Bid Assesment Questions detilas from "Master" sheet and <RowNumber>
    And clicks on Bid Assesment Questions submit button
    Examples:
      | RowNumber |
      | 0         |

  @BidAssessmentQuestionsSearchFunctionality
  Scenario: Bid Assessment Questions search functionality
    When user enters search Bid Assessment Questions information in search field
    Then user should find Bid Assessment Questions record in search grid
    When user enters search Assessment Category information in search field
    Then user should find Assessment Category record in search grid

  @BidAssessmentQuestionsforyActionitems
  Scenario: Bid Assessment Questions Action functionality
    When user clicks on Edit icon
    Then user should navigate to "Update Bid Assessment Questions" window
    When user clicks on delete icon
    Then user get delete confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close

