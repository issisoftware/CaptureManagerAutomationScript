Feature: Agency Or Frim feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "Agency or Firm" option under master menu
    When user clicks on Agency or Frim option
    Then page heading should be as "Agency or Firm"


    # Agency Or Firm
  @AgencyOrFirm
  Scenario Outline: Agency or Firm functionality
    When user clicks on Add Agency or Frim link
    Then user should navigate to "Create Agency or Firm" window
    When user enters Agency or firm detilas from "Master" sheet and <RowNumber>
    And clicks on submit button
    Examples:
      | RowNumber |
      | 0         |

  @AgencyOrFirmSearchFunctionality
  Scenario: Agency or Firm search functionality
    When user enters search agency information in search field
    Then user should find agency record in search grid
    When user enters State in state search filed
    Then user should find state in search grid
    When user enter agency or firm description in search field
    Then user should find the agency or firm description in search field

  @AgencyOrFrimActionitems
  Scenario: Agency or Frim Action functionality
    When user clicks on Edit icon
    Then user should navigate to "Update Agency or Firm" window
    When user clicks on delete icon
    Then user get a confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close

