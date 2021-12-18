Feature: Departments feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "Departments" option under master menu
    When user clicks on Departments option
    Then page heading should be as "Departments"

  @Departments
  Scenario Outline: Departments functionality
    When user clicks on Add Departments link
    Then user should navigate to "Create Department" window
    When user enters Departments detilas from "Master" sheet and <RowNumber>
    And clicks on Department submit button
    Examples:
      | RowNumber |
      | 0         |

  @DepartmentSearchFunctionality
  Scenario: Department search functionality
    When user enters search Department information in search field
    Then user should find Department record in search grid
    When user enters Potential Agency or Firm search information in search field
    Then user should find Potential Agency or Firm record in search grid
    When user enters Department description search information in search field
    Then user should find Department description record in search grid


  @DepartmentActionitems
  Scenario: Department Action functionality
    When user clicks on Edit icon
    Then user should navigate to "Update Department" window
    When user clicks on delete icon
    Then user get delete confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close

