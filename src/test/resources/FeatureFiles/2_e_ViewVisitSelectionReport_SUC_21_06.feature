Feature: [SUC:21-06] View Visit Selection Report

  Background:
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    Then User should be logged in
    Then Navigate to audit > View visit selection report

  @SUC:21-06 @UAT_M8-21-06-01 @backoffice
  Scenario: UAT_M8-21-06-01-Verify the fields in View visit selection reports screen
    Then verify fields in view visit selection reports screen

  @SUC:21-06 @UAT_M8-21-06-02 @backoffice
  Scenario: UAT_M8-21-06-02-Verify the process of view visit selection report
    Then Enter report ID as "VR000000021" and click search
    Then Verify same report ID "VR000000021" is displayed

  @SUC:21-06 @UAT_M8-21-06-03 @backoffice
  Scenario: UAT_M8-21-06-03-Verify the process of invalid criteria
    Then Enter report ID as "" and click search
    Then Verify error message "At least one field is required"

  @SUC:21-06 @UAT_M8-21-06-04 @backoffice
  Scenario: UAT_M8-21-06-04-Verify the process of no reports found
    Then Enter report ID as "VR000000021gg677uu" and click search
    Then Verify no data found in table

  @SUC:21-06 @UAT_M8-21-06-05 @backoffice
  Scenario: UAT_M8-21-06-05-Verify the process of export report
    Then Enter report ID as "VR000000021" and click search
    Then Export view selection report as pdf
    Then Verify file "AuditProfileSelectionReport.pdf" has been downloaded in downloads directory "C:\\Users\\Maxipain\\Downloads"
    Then Export view selection report as excel
    Then Verify file "AuditProfileSelectionReport.xls" has been downloaded in downloads directory "C:\\Users\\Maxipain\\Downloads"
