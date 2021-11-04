Feature: [SUC:21-12] Create Preliminary Audit Finding

  @UAT_M8-21-10-06 @CREATE
  Scenario: UAT_M8-21-12-01-UAT_M8-21-12-02-Verify the Process of  Create Audit Preliminary Finding
    Given Open CRM URL Module as "AuditorUser1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Audit reference number in search results
    And picks the audit case
    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Audit status should be "Audit Plan Approved"
    When clicks create preliminary audit
    Then switch to frame1
    And verifies " PRELIMINARY AUDIT FINDING " entry fields are displayed
    When enters PRELIMINARY AUDIT FINDING details
      | Address Visited  | TestAddress    |
      | Address Visited  | TestAddress    |
      | Date(s) of Visit | 20/11/2019     |
      | Number of Visits | 1              |
      | Contact Person   | testLeader     |
      | SUBJECT          | testObjectives |
      | BACKGROUND       | testInfo       |
      | CONCLUSION       | testAnalysis   |
    And Click on Save button
    Then Audit status should be "Execution"

  @CREATE @UAT_M8-21-12-03 @CREATE
  Scenario: UAT_M8-21-12-03-UAT_M8-21-12-04-Verify the Process of  Submit Preliminary Audit Finding
    Given Open CRM URL Module as "AuditorUser1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Audit reference number in search results
#    And picks the audit case
#    And click pick button
#    Then switch to frame0
    Then Click on reference number
    Then switch to frame1
    And verifies " PRELIMINARY AUDIT FINDING " entry fields are displayed
    And Clicks submit Preliminary Audit Finding button
    Then Audit status should be "Pending Preliminary Audit Approval"

  @UAT_M8-21-12-05
  Scenario: UAT_M8-21-12-05-Verify the Process of  Validation Failed
    Given Open CRM URL Module as "AuditorUser1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Audit reference number in search results
    And picks the audit case
    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Audit status should be "Audit Plan Approved"
    When clicks create preliminary audit
    Then switch to frame1
    And verifies " PRELIMINARY AUDIT FINDING " entry fields are displayed
    And Clicks submit Preliminary Audit Finding button
    Then switch to frame1
    Then validation error is displayed "  This field can not be empty. "









