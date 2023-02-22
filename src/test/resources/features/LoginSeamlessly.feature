Feature: Login functionality tests

  Background:
    Given the user is on the login page

  Scenario: Login with valid credential
    When the user enters valid username
    And the user enters valid password
    And the user clicks the login in button
    Then the user should be able to login

  Scenario: Login with invalid credential
    When the user enters invalid username
    And the user enters invalid password
    And the user clicks the login in button
    Then the user should not be able to login and get the error message

  Scenario: Login without credentials
    When the user clicks the login in button
    Then the user should not be able to login

  Scenario Outline: Login with valid credential
    When the user enters username "<username>"
    And the user enters password "<password>"
    And the user clicks the login in button
    Then the user should not be able to login for all

    Examples:
      | username      | password      |
      | Employee61    | WrongPassword |
      | WrongUsername | Employee123   |
      | WrongUsername | WrongPassword |
      | empty         | empty         |
