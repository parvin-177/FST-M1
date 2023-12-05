@activity5
Feature: Data driven test with Example

  Scenario Outline: Testing with Data from Scenario
    Given User on Login page
    When User Enters Credentials "<Usernames>" and "<Passwords>"
    Then Read the page title and validate confirmation message
    And Close The Browser

    Examples:
      | Usernames | Passwords |
      | admin     | password  |
      | adminUser | Password  |
      | admin     | pssw0rd   |