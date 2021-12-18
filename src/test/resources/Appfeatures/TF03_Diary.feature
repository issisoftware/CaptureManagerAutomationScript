Feature: Diary feature
  Background:
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"
    When user clicks on Diary menu
    And user get the Diary page heading

  @SelectDate
  Scenario: Select specific date from date picker
    Then Diary page heading should be as "Diary"
    When user select date, month and year from drop down

  @PreviousbuttonValidation
  Scenario: Validating previous button functionality
    When user clicks on previous button
    And user gets the page heading
    Then page heading should be "September 2021"

  @NextbuttonValidation
  Scenario: Validating next button functionality
    When user clicks on Next button
    And user gets the page heading
    Then page heading should be "November 2021"

  @MonthbuttonValidation
  Scenario: Validating month button functionality
    When user clicks on Month button
    And user gets the page heading
    Then page heading should be "October 2021"

  @WeekbuttonValidation
  Scenario: Validating week button functionality
    When user clicks on week button
    And user gets the page heading
    Then page heading should be "Oct 24 – 30, 2021"

  @DaybuttonValidation
  Scenario: Validating day button functionality
    When user clicks on day button
    And user gets the page heading
    Then page heading should be "October 28, 2021"
