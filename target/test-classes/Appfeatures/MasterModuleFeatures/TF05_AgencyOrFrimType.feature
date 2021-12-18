Feature: Agency Or Frim Type feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "Agency or Firm Type" option under master menu
    When user clicks on Agency or Frim Type option
    Then page heading should be as "Agency or Firm Type"

  @AgencyOrFirmType
  Scenario Outline: Agency or Firm type functionality
    When user clicks on Add Agency or Firm Type link
    Then user should navigate to "Create Agency or Firm Type" window
    When user enters Agency or firm type detilas from "Master" sheet and <RowNumber>
    And clicks on Create Agency or Firm Type submit button
    Examples:
      | RowNumber |
      | 0         |

  @AgencyOrFirmTypeSearchFunctionality
  Scenario: Agency or Firm type search functionality
    When user enters search agency or firm type information in search field
    Then user should find agency or firm type record in search grid
    When user enters agency or firm type description in descripton search filed
    Then user should find the agency or firm type description in search field

  @AgencyOrFrimTypeActionitems
  Scenario: Agency or Frim type Action functionality
    When user clicks on Edit icon
    Then user should navigate to "Update Agency or Firm Type" window
    When user clicks on delete icon
    Then user get delete confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close