Feature: Document Types feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "Document Types" option under master menu
    When user clicks on Document Type option
    Then page heading should be as "Document Types"

  @DocumentType
  Scenario Outline: Document Types functionality
    When user clicks on Add Document Type link
    Then user should navigate to "Create Document Type" window
    When user enters Document Type detilas from "Master" sheet and <RowNumber>
    And clicks on Document Type submit button
    Examples:
      | RowNumber |
      | 0         |

  @DocumentTypeSearchFunctionality
  Scenario: Document Type search functionality
    When user enters search Document type information in search field
    Then user should find Document type record in search grid
    When user enters Document type description search information in search field
    Then user should find Document type description record in search grid


  @DepartmentActionitems
  Scenario: Document Type Action functionality
    When user clicks on Edit icon
    Then user should navigate to "Update Document Type" window
    When user clicks on delete icon
    Then user get delete confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close

