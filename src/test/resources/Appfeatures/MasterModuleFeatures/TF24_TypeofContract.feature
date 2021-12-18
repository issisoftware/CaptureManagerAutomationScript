Feature: Type of Contract feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "Type of Contract" option under master menu
    When user clicks on Type of Contract option
    Then page heading should be as "Type of Contract"

  @TypeofContract
  Scenario Outline: Type of Contract functionality
    When user clicks on Add Type of Contract link
    Then user should navigate to "Create Type of Contract" window
    When user enters Type of Contract detilas from "Master" sheet and <RowNumber>
    And clicks on Type of Contract submit button
    Examples:
      | RowNumber |
      | 0         |

  @TypeofContractSearchFunctionality
  Scenario: Type of Contract search functionality
    When user enters search Type of Contract information in search field
    Then user should find Type of Contract record in search grid
    When user enters search Type of Contract Description information in search field
    Then user should find Type of Contract Description record in search grid

  @TypeofContractActionitems
  Scenario: Type of Contract Action functionality
    When user clicks on Edit icon
    Then user should navigate to "Update Type of Contract" window
    When user clicks on delete icon
    Then user get delete confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close

