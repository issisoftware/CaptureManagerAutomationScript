Feature: Bid Sources feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "Bid Sources" option under master menu
    When user clicks on Bid Sources option
    Then page heading should be as "Bid Sources"

  @BidSource
  Scenario Outline: Bid Sources functionality
    When user clicks on Add Bid Sources link
    Then user should navigate to "Create Bid Source" window
    When user enters Bid Sources detilas from "Master" sheet and <RowNumber>
    And clicks on Bid Sources submit button
    Examples:
      | RowNumber |
      | 0         |

  @BidSourceSearchFunctionality
  Scenario: Bid Source search functionality
    When user enters search Bid Source information in search field
    Then user should find Bid Source record in search grid
    When user enters search Bid Source descripton information in search field
    Then user should find Bid Source descripton record in search grid

  @BidSourceActionitems
  Scenario: Bid Source Action functionality
    When user clicks on Edit icon
    Then user should navigate to "Update Bid Source" window
    When user clicks on delete icon
    Then user get delete confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close

