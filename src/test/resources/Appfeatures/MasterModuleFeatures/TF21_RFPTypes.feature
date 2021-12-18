Feature: RFP Types feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "RFP Types" option under master menu
    When user clicks on RFP Types option
    Then page heading should be as "RFP Types"

  @RFPTypes
  Scenario Outline: RFP Types functionality
    When user clicks on Add RFP Type link
    Then user should navigate to "Create RFP Type" window
    When user enters RFP Type detilas from "Master" sheet and <RowNumber>
    And clicks on RFP Type submit button
    Examples:
      | RowNumber |
      | 0         |

  @RFPTypeSearchFunctionality
  Scenario: RFP Type search functionality
    When user enters search RFP Type information in search field
    Then user should find RFP Type record in search grid
    When user enters search RFP Type Description information in search field
    Then user should find RFP Type Description record in search grid

  @RFPTypeActionitems
  Scenario: RFP Type Action functionality
    When user clicks on Edit icon
    Then user should navigate to "Update RFP Type" window
    When user clicks on delete icon
    Then user get delete confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close

