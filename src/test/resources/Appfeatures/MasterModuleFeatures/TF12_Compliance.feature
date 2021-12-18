Feature: Compliance feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "Compliance" option under master menu
    When user clicks on Compliance option
    Then page heading should be as "Compliance"

  @Compliance
  Scenario Outline: Compliance functionality
    When user clicks on Add Compliance Type link
    Then user should navigate to "Create Compliance" window
    When user enters Compliance detilas from "Master" sheet and <RowNumber>
    And clicks on Compliance submit button
    Examples:
      | RowNumber |
      | 0         |

  @ComplianceSearchFunctionality
  Scenario: Compliance search functionality
    When user enters search compliance information in search field
    Then user should find compliance record in search grid


  @ComplianceActionitems
  Scenario: Compliance Action functionality
    When user clicks on Edit icon
    Then user should navigate to "Edit Compliance" window
    When user clicks on delete icon
    Then user get delete confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close

