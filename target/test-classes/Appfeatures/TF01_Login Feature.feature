Feature: Login feature

  @ValidLoginScenario
  Scenario: Login functionality with valid credentials
    Given user should login to capture manager application
      | username | password |
      | admin    | issi123  |
    When user gets the title of the page
    Then page title should be "Capture Plan Management System"

  @InValidLoginScenario
  Scenario: Login functionality with invalid credentials
    Given user should login to capture manager application
      | username | password |
      | admin    | issi1234 |
    When user gets error message on invalid login
    Then error message  should be "Invalid Credentials"

