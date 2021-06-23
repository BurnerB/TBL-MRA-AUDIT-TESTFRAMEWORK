Feature: [SUC:21-01] Maintain Audit Selection Risk Bands

  Background:
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    Then User should be logged in
    Then Navigate to audit > Mantain risk bands

    @SUC:21-01 @UAT_M8-21-01-01 @backoffice
    Scenario: UAT_M8-21-01-01-Verify the fields in Create Risk Band screen
      Then Verify fields in Mantain risk bands screen
      Then Click add to open add risk bands frame
      Then Switch to frame
      Then Verify fields in add risk band frame

    @SUC:21-01 @UAT_M8-21-01-03 @backoffice
    Scenario: UAT_M8-21-01-03-Verify the process of update risk band details
      Then Select first table row in existing risk bands
      Then Click update button to update selected risk band
      Then Switch to frame
      Then Fill in number of days of the audit field
      Then Switch to default
      Then Verify success message "Record Updated"
      Then Click save to process risk band update
      Then Verify success message "Record Successfully Saved."

    @SUC:21-01 @UAT_M8-21-01-04 @backoffice
    Scenario: UAT_M8-21-01-04-Verify the process of view risk band details
      Then Select first table row in existing risk bands
      Then Click view button to view selected risk band
      Then Switch to frame
      Then Verify view risk band field is readonly

    @SUC:21-01 @UAT_M8-21-01-05 @backoffice
    Scenario: UAT_M8-21-01-05-Verify the process validation failed
      Then Click add button to add risk band
      Then Switch to frame
      Then Click ok to trigger validation
      Then Verify error message "Risk Band: Validation Error: Value is required."




