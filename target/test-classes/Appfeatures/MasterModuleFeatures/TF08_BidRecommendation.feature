Feature: Bid Recommendation feature

  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on master menu
    Then user found "Bid Recommendations" option under master menu
    When user clicks on Bid Recommendations option
    Then page heading should be as "Bid Recommendations"

  @BidRecommendations
  Scenario Outline: Bid Recommendation functionality
    When user clicks on Add Bid recommendations link
    Then user should navigate to "Create Bid Recommendation" window
    When user enters Bid Recommendation detilas from "Master" sheet and <RowNumber>
    And clicks on Bid Recommendation submit button
    Examples:
      | RowNumber |
      | 0         |

  @BidRecommendationSearchFunctionality
  Scenario: Bid Recommendation search functionality
    When user enters search Bid Recommendation information in search field
    Then user should find Bid Recommendation record in search grid
    When user enters search Bid Recommendation descripton information in search field
    Then user should find Bid Recommendation descripton record in search grid

  @BidRecommendationsActionitems
  Scenario: Bid Recommendation Action functionality
    When user clicks on Edit icon
    Then user should navigate to "Update Bid Recommendation" window
    When user clicks on delete icon
    Then user get delete confirmation window to choose the option
    When user clicks on print button
    Then user should found the record in new tab and close

