Feature: [SUC:21-11] Approve Audit Plan

  @UAT_M8-21-10-06 @CREATE
  Scenario: UAT_M8-21-11-01-UAT_M8-21-11-02-Verify the Process of Approve Audit Plan
    Given Open CRM URL Module as "AuditManager1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Audit reference number in search results
    And picks the audit case
    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Audit status should be "Pending Audit Plan Approval"
    And wait for plan to load "Auditors"
    Then switch to frame1
    And clicks Approve from the dropdown
    Then switch to frame1
    And enters manager comments "Manager test comment"
    And Click on Save button
    Then Audit status should be "Audit Plan Approved"

  @UAT_M8-21-11-03
  Scenario: UAT_M8-21-11-03-Verify the Process of  Return Audit Plan for Revision
    Given Open CRM URL Module as "AuditManager1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Audit reference number in search results
    And picks the audit case
    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Audit status should be "Pending Audit Plan Approval"
    And wait for plan to load "Auditors"
    Then switch to frame1
    And clicks reject from the dropdown
    Then switch to frame1
    And enters manager comments "Manager test comment"
    Then Enter Outcome Notes "Invalid documentation"
    Then Enter Outcome Reason
    And Click on Save button
    Then Audit status should be "Planning"

  @UAT_M8-21-11-04
  Scenario: UAT_M8-21-11-04-Verify the Process of  Validation Failed
    Given Open CRM URL Module as "AuditManager1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Audit reference number in search results
    And picks the audit case
    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Audit status should be "Pending Audit Plan Approval"
    And wait for plan to load "Auditors"
    Then switch to frame1
    And clicks reject from the dropdown
    Then switch to frame1
    And enters manager comments "Manager test comment"
    And Click on Save button
    Then switch to frame1
    Then validation audit error displayed " You must provide a value for Outcome Reason."








