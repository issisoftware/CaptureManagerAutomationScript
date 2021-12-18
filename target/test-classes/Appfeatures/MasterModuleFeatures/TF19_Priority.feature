Feature: Priority feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "Priority" option under master menu
    When user clicks on Priority option
    Then page heading should be as "Priority"

  @Priority
  Scenario Outline: Priority functionality
    When user clicks on Add Priority link
    Then user should navigate to "Create Priority" window
    When user enters Priority detilas from "Master" sheet and <RowNumber>
    And clicks on Priority submit button
    Examples:
      | RowNumber |
      | 0         |

  @PrioritySearchFunctionality
  Scenario: Priority search functionality
    When user enters search Priority information in search field
    Then user should find Priority record in search grid

  @PriorityActionitems
  Scenario: Priority Action functionality
    When user clicks on Edit icon
    Then user should navigate to "Update Priority" window
    When user clicks on delete icon
    Then user get delete confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close

