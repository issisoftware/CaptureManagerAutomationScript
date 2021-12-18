Feature: Evaluation Criteria feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "Evaluation Criteria" option under master menu
    When user clicks on Evaluation Criteria option
    Then page heading should be as "Evaluation Criteria"

  @EvaluationCriteria
  Scenario Outline: Evaluation Criteria functionality
    When user clicks on Add Evaluation Criteria link
    Then user should navigate to "Create Evaluation Criteria" window
    When user enters Evaluation Criteria detilas from "Master" sheet and <RowNumber>
    And clicks on Evaluation Criteria submit button
    Examples:
      | RowNumber |
      | 0         |

  @EvaluationCriteriaSearchFunctionality
  Scenario: Evaluation Criteria search functionality
    When user enters search Evaluation Criteria information in search field
    Then user should find Evaluation Criteria record in search grid

  @EvaluationCriteriaActionitems
  Scenario: Evaluation Criteria Action functionality
    When user clicks on Edit icon
    Then user should navigate to "Update Evaluation Criteria" window
    When user clicks on delete icon
    Then user get delete confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close

