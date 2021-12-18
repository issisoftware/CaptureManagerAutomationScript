Feature: RFP and Proposals feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on Bids and Proposals module
    Then user should find "RFP and Proposals" option
    When user clicks on RFP and Proposals option
    Then user sholuld navigate to "RFP and Proposals" page
    When user enters Solicitation Id in search box
    And clicks on search button
    Then user should find solicitation id in search table
    When user clicks on Edit icon in search table
   # When user clicks on Add New Bid link
    Then user should navigate the page heading as "Add New / Edit RFP and Proposals"

  @CapturePlanTab
  Scenario Outline: Adding details in Capture Plan tab
    Given user clicks on Capture Plan tab
    Then user should navigate to "Capture Plan" tab
    When user fills Capture Plan details from "Capture Plan" sheet and <RowNumber>
    And user clicks on Capture Plan submit button
    When user clicks on next button in capture plan tab
   # Then user should navigate to the "Add New Requirement" tab
    Examples:
      | RowNumber |
      | 0         |

  @RequirementsTab
  Scenario Outline: Adding Requirements details
    When user clicks on Requirements tab
    Then user should navigate to the "Add New Requirement" tab
    When user clicks on Add New Requirement link
    Then user should get "Add Requirement" window open
    When user fills Requirements details from "Requirements Tab" sheet and <RowNumber>
    And user clicks on add requirement window submit button
    When user clicks on Next button in Requirements tab
    # Then user should navigate to "ISSI Capability" tab
    Examples:
      | RowNumber |
      | 0         |

    @ISSIcapability
    Scenario Outline: ISSI capability search functionality
      When user clicks on ISSI Capability tab
      Then user should navigate to "ISSI Capability" tab
      When user enter Task type details from "Requirements Tab" sheet and <RowNumber>
      Then user should find added requirement task type in issi capability search table
      When user select ISSI option in search table
      And user clicks on issi capability next button
    # Then user should navigate to the "Add Incumbent and Contact" tab
      Examples:
        | RowNumber |
        | 0         |

  @IncumbentAndContactTab
  Scenario Outline: Add IncumbentAndContact details
    When user clicks on IncumbentAndContact tab
    Then user should navigate to the "Add Incumbent and Contact" tab
    When user clicks on Add Incumbent and Contact link
    Then user should get "Add Incumbent and contact" window open
    When user fills incumbent details from "IncumbentAndContacts Tab" sheet and <RowNumber>
    And user clicks on add incumbentAndContact window submit button
    When user clicks on Next button in incumbentAndContact tab
    # Then user should navigate to "ISSI Capability" tab
    Examples:
      | RowNumber |
      | 0         |

  @TeamingAndSubContractingTab
  Scenario Outline: Add Teaming and sub contacting details
    When user clicks on Teaming and sub contacting tab
    Then user should navigate to the "Add Teaming and Subcontracting" tab
    When user clicks on Add Teaming and sub contracting link
    Then user should get "Add Team and Subcontracting" window open
    When user fills teaming and subcontracting details from "TeamingAndSubContacting" sheet and <RowNumber>
    And user clicks on add teamingandsubcontracting window submit button
    When user clicks on Next button in teaming and subcontacting tab
    # Then user should navigate to "ISSI Capability" tab
    Examples:
      | RowNumber |
      | 0         |

  @TeamingMatrix
  Scenario Outline: Add Teaming Matrix functionality
    When user clicks on Teaming Matrix tab
    Then user should navigate to "Teaming Matrix" tab
    Then user should find added requirement in teaming matrix page
    When user select teaming ISSI option in search table
    And user clicks on Teamnig Matrix next button
    # Then user should navigate to the "Add Incumbent and Contact" tab
    Examples:
      | RowNumber |
      | 0         |

  @SWOTanalysis
  Scenario Outline: Add SWOT analysis functionality
    When user clicks on SWOT analysis tab
    #Then user should navigate to the "Add SWOT Analysis" tab
    When user fills SWOT details from "SWOTdetails" sheet and <RowNumber>
    And user clicks on SWOT analysis save button
    And user clicks on SWOT analysis Next button
    # Then user should navigate to the "Add Incumbent and Contact" tab
    Examples:
      | RowNumber |
      | 0         |

  @FileUploads
  Scenario: Add File upload functionality
    When user clicks on File Upload tab
    Then user should navigate to "File Uploads" tab
    When user upload a file and click on Attach button
    Then user should find attached file in search grid
    And user clicks on file upload next button
    # Then user should navigate to the "Bid Statistics" tab

  @ResourcesRequired
  Scenario Outline: Adding Resources Required details
    When user clicks on Resource Required tab
    Then user should navigate to the "Add New Resource" tab
    When user clicks on Add New Resource link
    Then user should get "Add Resource" window open
    When user fills resource details from "Resources Required" sheet and <RowNumber>
    And user clicks on add resource window submit button
    When user clicks on Next button in resource required tab
    # Then user should navigate to "ISSI Capability" tab
    Examples:
      | RowNumber |
      | 0         |

  @Comments
  Scenario: Add comments functionality
    When user clicks on comments tab
    Then user should navigate to the "Add Comments" tab
    When user add comments in comments text filed
    And user clicks on comments save button
    # Then user should navigate to the "Add Incumbent and Contact" tab

  @History
  Scenario: History functionality
    When user clicks on History tab
    Then user should navigate to "History" tab
    And user should find Capture name under title search
    When user clicks on view icon
    Then user should navigate to "Capture Plan" tab