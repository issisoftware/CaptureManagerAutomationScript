Feature: P4 Actions feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "P4 Actions" option under master menu
    When user clicks on P4 Actions option
    Then page heading should be as "P4 Actions"

  @P4Actions
  Scenario Outline: P4 Actions functionality
    When user clicks on Add P4 Actions link
    Then user should navigate to "Create P4 Action" window
    When user enters P4 Actions detilas from "Master" sheet and <RowNumber>
    And clicks on P4 Action submit button
    Examples:
      | RowNumber |
      | 0         |

  @P4ActionsSearchFunctionality
  Scenario: P4 Actions search functionality
    When user enters search P4 Actions information in search field
    Then user should find P4 Actions record in search grid
    When user enters search P4 Actions description information in search field
    Then user should find P4 Actions description record in search grid

  @P4ActionsActionitems
  Scenario: P4 Actions Action functionality
    When user clicks on Edit icon
    Then user should navigate to "Update P4 Action" window
    When user clicks on delete icon
    Then user get delete confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close

