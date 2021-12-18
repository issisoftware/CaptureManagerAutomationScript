Feature: Set Aside feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "Set Aside" option under master menu
    When user clicks on Set Aside option
    Then page heading should be as "Set Aside"

  @SetAside
  Scenario Outline: Set Aside functionality
    When user clicks on Add Set Aside link
    Then user should navigate to "Create Set Aside" window
    When user enters Set Aside detilas from "Master" sheet and <RowNumber>
    And clicks on Set Aside submit button
    Examples:
      | RowNumber |
      | 0         |

  @SetAsideSearchFunctionality
  Scenario: Set Aside search functionality
    When user enters search Set Aside information in search field
    Then user should find Set Aside record in search grid
    When user enters search Set Aside Description information in search field
    Then user should find Set Aside Description record in search grid

  @SetAsideActionitems
  Scenario: Set Aside Action functionality
    When user clicks on Edit icon
    Then user should navigate to "Update Set Aside" window
    When user clicks on delete icon
    Then user get delete confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close

