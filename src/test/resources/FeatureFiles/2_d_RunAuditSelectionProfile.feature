Feature: [SUC:21-04] Run Audit Selection Profile

  Background:
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    Then User should be logged in
    Then Navigate to audit > Run Audit Selection Profile

  @SUC:21-04  @UAT_M8-21-04-01 @UAT_M8-21-04-02 @backoffice @boom
  Scenario: UAT_M8-21-04-02-Verify the process of Run audit profile
    Then Enter audit selection profile id as "AP000000141" and click search
#    Then Search for audit selection profile
    Then Enter results to display as "200" and click run
    Then Click accept button
    Then Verify success message "Audit visit selection report saved successfully."
    Then Click export as pdf
    Then Verify file "AuditProfileSelectionReport.pdf" has been downloaded in downloads directory "C:\\Users\\Maxipain\\Downloads"
    Then Click export as excel
    Then Verify file "AuditProfileSelectionReport.xls" has been downloaded in downloads directory "C:\\Users\\Maxipain\\Downloads"

  @SUC:21-04  @UAT_M8-21-04-03 @backoffice
  Scenario: UAT_M8-21-04-03-Verify the process of Report not accepted
    Then Enter audit selection profile id as "AP000000141" and click search
#    Then Search for audit selection profile
    Then Enter results to display as "200" and click run
    Then Click cancel so as not to save profile
    Then User is navigated back to homepage "https://backoffice.mra.mw:8443/trips-ui/faces/login/Welcome.xhtml"

  @SUC:21-04  @UAT_M8-21-04-04 @backoffice
  Scenario: UAT_M8-21-04-04-Verify the process of Run not executed
    Then Enter audit selection profile id as "AP000000101" and click search
    Then Enter results to display as "200" and click run
    Then Verify error message "Current date not in between audit profile period start date and audit profile period end date."




