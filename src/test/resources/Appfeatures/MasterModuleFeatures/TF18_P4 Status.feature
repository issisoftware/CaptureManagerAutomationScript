Feature: P4 Status feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "P4 Status" option under master menu
    When user clicks on P4 Status option
    Then page heading should be as "P4 Status"

  @P4Status
  Scenario Outline: P4 Status functionality
    When user clicks on Add P4 Status link
    Then user should navigate to "Create P4 Status" window
    When user enters P4 Status detilas from "Master" sheet and <RowNumber>
    And clicks on P4 Status submit button
    Examples:
      | RowNumber |
      | 0         |

  @P4StatusSearchFunctionality
  Scenario: P4 Status search functionality
    When user enters search P4 Status information in search field
    Then user should find P4 Status record in search grid
    When user enters search P4 Status description information in search field
    Then user should find P4 Status description record in search grid

  @P4StatusActionitems
  Scenario: P4 Status Action functionality
    When user clicks on Edit icon
    Then user should navigate to "Update P4 Status" window
    When user clicks on delete icon
    Then user get delete confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close

