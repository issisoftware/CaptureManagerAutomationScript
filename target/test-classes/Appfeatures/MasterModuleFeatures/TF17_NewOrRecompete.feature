Feature: New Or Recompete feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "New or Recompete" option under master menu
    When user clicks on New Or Recompete option
    Then page heading should be as "New or Recompete"

  @NewOrRecompete
  Scenario Outline: New or Recompete functionality
    When user clicks on Add New or Recompete link
    Then user should navigate to "Create New or Recompete" window
    When user enters New or Recompete detilas from "Master" sheet and <RowNumber>
    And clicks on New or Recompete submit button
    Examples:
      | RowNumber |
      | 0         |

  @NewOrRecompeteSearchFunctionality
  Scenario: New or Recompete search functionality
    When user enters search Type information in search field
    Then user should find Type record in search grid
    When user enters search description information in search field
    Then user should find description record in search grid

  @NewOrRecompeteActionitems
  Scenario: New or Recompete Action functionality
    When user clicks on Edit icon
    Then user should navigate to "Update New or Recompete" window
    When user clicks on delete icon
    Then user get delete confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close

