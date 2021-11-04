Feature: [SUC:21-03] Maintain Audit Selection Profile

  Background:
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    Then User should be logged in


  @SUC:21-03 @UAT_M8-21-03-01 @UAT_M8-21-03-02 @backoffice @boom
  Scenario: UAT_M8-21-03-02-Verify the process of mantain Audit profile
    Then Navigate to audit > Create Audit Selection Profile
    Then Enter profile name
    And Select selection profile office
    And Select Audit period start
    And Select Audit period end
    And Select Profile status
    And Select all industry sectors
    Then Click save to submit audit profile
    Then Verify success message "Audit profile details successfully saved."

  @SUC:21-03  @UAT_M8-21-03-03 @backoffice @boom
  Scenario: UAT_M8-21-03-03-Verify the process of Update audit profile
    Then Navigate to audit > Update Audit Selection Profile
    Then Enter audit selection profile id as "AP000000121" and click search
#    Then Search for audit selection profile
    Then Update the audit selection profile status
    Then Click save to submit audit profile
    Then Verify success message "Audit profile details successfully saved."

  @SUC:21-03  @UAT_M8-21-03-04 @backoffice
  Scenario: UAT_M8-21-03-04-Verify the process of validation failed
    Then Navigate to audit > Create Audit Selection Profile
    Then Click save to submit audit profile
    Then Verify error message "Selection Profile Name: Validation Error: Value is required."

  @SUC:21-03  @UAT_M8-21-03-05 @backoffice
  Scenario: UAT_M8-21-03-05-Verify the process of profile not found
    Then Navigate to audit > Update Audit Selection Profile
    Then Enter audit selection profile id as "AP000000121bh76lkpain" and click search
    Then Verify no data found in table




