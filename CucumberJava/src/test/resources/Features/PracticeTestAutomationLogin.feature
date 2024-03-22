@PracticeTestAutomation
Feature: Test login functionality

  @PositiveLogIntest
  Scenario Outline: Check login is successful with valid credentials
    Given Browser is open
    And User is on login page
    When User enter <username> and <password>
    And User clicks on login button
    Then User is navigated to the home page

    Examples: 
      | username | password    |
      | student  | Password123 |

  @NegativeUsernameTest
  Scenario Outline: Check login is unsuccessful with Invalid credentials
    Given Browser is open
    And User is on login page
    When User enter <username> and <password>
    And User clicks on login button
    Then User receive error message your password is invalid

    Examples: 
      | username      | password    |
      | incorrectUser | Password123 |

  @NegativePasswordTest
  Scenario Outline: Check login is unsuccessful with Invalid credentials
    Given Browser is open
    And User is on login page
    When User enter <username> and <password>
    And User clicks on login button
    Then User receive error message your password is invalid

    Examples: 
      | username | password          |
      | student  | incorrectPassword |
