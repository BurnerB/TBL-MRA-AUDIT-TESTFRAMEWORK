Feature: [SUC:21-13] Approve Preliminary Audit Finding

  @UAT_M8-21-10-06 @CREATE
  Scenario: UAT_M8-21-13-01-Verify the fields in Approve Preliminary Audit Finding screen
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
    Then Audit status should be "Pending Preliminary Audit Approval"
    And wait for plan to load "Business Sector"
    Then switch to frame1
    And clicks Approve from the dropdown
    Then switch to frame1
    And enters manager comments "Manager test comment"
    And Click on Save button
    Then Audit status should be "Preliminary Audit Approved"

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
    Then Audit status should be "Pending Preliminary Audit Approval"
    And wait for plan to load "Business Sector"
    Then switch to frame1
    And clicks reject from the dropdown
    Then switch to frame1
    And enters manager comments "Manager test comment"
    Then Enter Outcome Notes "Invalid documentation"
    Then Enter Outcome Reason
    And Click on Save button
    Then Audit status should be "Execution"

  @UAT_M8-21-13-03
  Scenario: UAT_M8-21-13-03-Verify the Process of  Validation Failed
    Given Open CRM URL Module as "AuditManager1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Audit reference number in search results
    And picks the audit case
    And click pick button dropdown
    Then switch to frame0
    Then Click on reference number
    Then Audit status should be "Pending Preliminary Audit Approval"
    And wait for plan to load "Business Sector"
    Then switch to frame1
    And clicks reject from the dropdown
    Then switch to frame1
    And enters manager comments "Manager test comment"
    And Click on Save button
    Then switch to frame1
    Then validation audit error displayed " You must provide a value for Outcome Reason."








