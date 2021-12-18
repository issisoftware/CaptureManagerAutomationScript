Feature: Teaming Partner feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "Teaming Partner" option under master menu
    When user clicks on Teaming Partner option
    Then page heading should be as "Teaming Partners"

  @TeamingPartners
  Scenario Outline: Teaming Partners functionality
    When user clicks on Add Teaming Partners link
    Then user should navigate to the "Add/Edit Teaming Partners" window
    When user enters Teaming partners detilas from "TeamingPartner" sheet and <RowNumber>
    And clicks on teaming parner save button
    Examples:
      | RowNumber |
      | 0         |

  @TeamingPartnerSearchFunctionality
  Scenario: Teaming Partners search functionality
    When user enters search Company Name information in search field
    Then user should find Company Name record in search grid
    When user enters search Address information in search field
    Then user should find Address record in search grid
    When user enters search Email information in search field
    Then user should find Email record in search grid

  @TeamingPartnersActionitems
  Scenario: Teaming Partners Action functionality
    When user clicks on Teaming partner Edit icon
    Then user should navigate to teaming partner "Add/Edit Teaming Partners" page
    When user clicks on Teaming partner Exit button
    Then user should navigate to the "Teaming Partners" page
    When user clicks on delete icon
    Then user get delete confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close

