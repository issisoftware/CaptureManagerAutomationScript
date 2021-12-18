Feature: Requirement Types feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "Requirement Types" option under master menu
    When user clicks on Requirement Types option
    Then page heading should be as "Requirement Types"

  @RequirementTypes
  Scenario Outline: Requirement Types functionality
    When user clicks on Add Requirement Type link
    Then user should navigate to "Create Requirement Type" window
    When user enters Requirement Type detilas from "Master" sheet and <RowNumber>
    And clicks on Requirement Type submit button
    Examples:
      | RowNumber |
      | 0         |

  @RequirementTypeSearchFunctionality
  Scenario: Requirement Type search functionality
    When user enters search Requirement Type information in search field
    Then user should find Requirement Type record in search grid
    When user enters search Requirement Type Description information in search field
    Then user should find Requirement Type Description record in search grid

  @RequirementTypeActionitems
  Scenario: Requirement Type Action functionality
    When user clicks on Edit icon
    Then user should navigate to "Update Requirement Type" window
    When user clicks on delete icon
    Then user get delete confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close

