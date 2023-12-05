@activity2
Feature: Second BDD Cucumber Test -Login Test

  Scenario: Testing Login
    Given User is on Training support Login page
    When User enters username and password
    Then User Read the page title and confirmation message
    And User Close the Browser
