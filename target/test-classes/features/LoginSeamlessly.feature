Feature: Login functionality tests
  @wip
  Scenario: Login with valid credential
    Given the user is on the login page
    When the user enters valid username
    And the user enters valid password
    And the user clicks the login in button
    Then the user should be able to login
