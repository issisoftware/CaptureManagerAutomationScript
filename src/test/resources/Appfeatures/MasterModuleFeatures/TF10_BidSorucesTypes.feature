Feature: Bid Source Types feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "Bid Source Types" option under master menu
    When user clicks on Bid Source Types option
    Then page heading should be as "Bid Source Types"

  @BidSourceTypes
  Scenario Outline: Bid Source Types functionality
    When user clicks on Add Bid Source Type link
    Then user should navigate to "Create Bid Source Type" window
    When user enters Bid Source type detilas from "Master" sheet and <RowNumber>
    And clicks on Bid Source type submit button
    Examples:
      | RowNumber |
      | 0         |

  @BidSourceTypeSearchFunctionality
  Scenario: Bid Source Type search functionality
    When user enters search Bid Source type information in search field
    Then user should find Bid Source type record in search grid
    When user enters search Bid Source type descripton information in search field
    Then user should find Bid Source type descripton record in search grid

  @BidSourceTypeActionitems
  Scenario: Bid Source Type Action functionality
    When user clicks on Edit icon
    Then user should navigate to "Update Bid Source Type" window
    When user clicks on delete icon
    Then user get delete confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close

