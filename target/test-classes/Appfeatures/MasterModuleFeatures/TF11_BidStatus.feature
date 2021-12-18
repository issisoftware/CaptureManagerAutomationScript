Feature: Bid Status feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "Bid Status" option under master menu
    When user clicks on Bid Status option
    Then page heading should be as "Bid Status"

  @BidStatus
  Scenario Outline: Bid Status functionality
    When user clicks on Add Bid Status Type link
    Then user should navigate to "Create Bid Status" window
    When user enters Bid Status detilas from "Master" sheet and <RowNumber>
    And clicks on Bid Create Bid Status submit button
    Examples:
      | RowNumber |
      | 0         |

  @BidStatusSearchFunctionality
  Scenario: Bid Status search functionality
    When user enters search Bid Status information in search field
    Then user should find Bid Status record in search grid
    When user enters search Bid Status descripton information in search field
    Then user should find Bid Status descripton record in search grid

  @BidStatusActionitems
  Scenario: Bid Status Action functionality
    When user clicks on Edit icon
    Then user should navigate to "Update Bid Status" window
    When user clicks on delete icon
    Then user get delete confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close

