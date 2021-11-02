Feature: [SUC:21-07] Create Audit Case

  Background:
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    Then User should be logged in

  @UAT_M8-21-07-01 @CREATE
  Scenario Outline: UAT_M8-21-07-01-UAT_M8-21-07-02-Verify the Process of Create Audit Case Manually
    Given User navigates to Audit>>Create case manually
    And enters taxpayer details "C0103070" and "Notes"
    And clicks on the create audit case button
    And  Verify the ARN number "<ARN>"

    Examples:
      | ARN                                     |
      | Processing Completed - Reference Number |



