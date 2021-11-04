Feature: [SUC:21-02] Maintain Audit Risk Indicators

  Background:
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    Then User should be logged in
    Then Navigate to audit > Mantain risk indicators

  @SUC:21-02 @UAT_M8-21-02-01 @backoffice
  Scenario: UAT_M8-21-02-01-Verify the fields in Create Risk Indicator screen
    Then Verify fields in audit risk indicator screen
    Then Click add to open risk indicator details screen
    Then Switch to frame
    Then Verify fields in risk indicator details screen

  @SUC:21-02 @UAT_M8-21-02-03 @backoffice
  Scenario: UAT_M8-21-02-03-Verify the process of update audit risk indicator
    Then Select first table row in existing risk indicators
    Then Switch to frame
    Then fill in Turnover risk indicator details
    Then Switch to default
    Then Verify success message "Record Updated"
    Then Click save to process risk indicator update
    Then Verify success message "Record Successfully Saved."

  @SUC:21-02 @UAT_M8-21-02-04 @backoffice
  Scenario: UAT_M8-21-02-04-Verify the process of view risk indicator details
    Then Select first table row to view existing risk indicators
    Then Switch to frame
    Then Verify fields in risk indicator details screen are read only

  @SUC:21-02 @UAT_M8-21-02-05 @backoffice
  Scenario: UAT_M8-21-02-05-Verify the process of validation failed
    Then Click add to open risk indicator details screen
    Then Switch to frame
    Then Click ok to trigger validation check in risk band details
    Then Verify error message "Turnover From:: Validation Error: Value is required."


