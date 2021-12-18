Feature: NAICS code feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "NAICS Code" option under master menu
    When user clicks on NAICS Code option
    Then page heading should be as "NAICS Code"

  @NAICScode
  Scenario Outline: NAICS code functionality
    When user clicks on Add NAICS Code link
    Then user should navigate to "Create NAICS Code" window
    When user enters NAICS code detilas from "Master" sheet and <RowNumber>
    And clicks on NAICS code submit button
    Examples:
      | RowNumber |
      | 0         |

  @NAICScodeSearchFunctionality
  Scenario: NAICS code search functionality
    When user enters search NAICS code information in search field
    Then user should find NAICS code record in search grid
    When user enters search NAICS code description information in search field
    Then user should find NAICS code description record in search grid

  @NAICScodeActionitems
  Scenario: NAICS code Action functionality
    When user clicks on Edit icon
    Then user should navigate to "Update NAICS Code" window
    When user clicks on delete icon
    Then user get delete confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close

