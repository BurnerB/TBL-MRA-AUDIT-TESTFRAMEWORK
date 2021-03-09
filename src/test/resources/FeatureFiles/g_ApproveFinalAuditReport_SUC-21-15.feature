Feature: [SUC:21-15] Approve Final Audit Report

  @UAT_M8-21-15-01 @CREATE
  Scenario: UAT_M8-21-15-01-UAT_M8-21-15-02-Verify the Process of  Approve Final Audit Report
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
    Then Audit status should be "Pending Final Audit Approval"
    And wait for plan to load "Business Sector"
    Then switch to frame1
    And clicks Approve from the dropdown
    Then switch to frame1
    And enters manager comments "Manager test comment"
    And Click on Save button
    Then Audit status should be "Final Audit Approved"

  @UAT_M8-21-15-03 @CREATE--
  Scenario: UAT_M8-21-15-03-Verify the Process of  Return Final Audit Report for Revision
    Given Open CRM URL Module as "AuditManager1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Audit reference number in search results
#    And picks the audit case
#    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Audit status should be "Pending Final Audit Approval"
    And wait for plan to load "Business Sector"
    Then switch to frame1
    And clicks reject from the dropdown
    Then switch to frame1
    And enters manager comments "Manager test comment"
    Then Enter Outcome Notes "Invalid documentation"
    Then Enter Outcome Reason
    And Click on Save button
    Then Audit status should be "Execution"

  @UAT_M8-21-15-04 @CREATE--
  Scenario: UAT_M8-21-15-04-Verify the Process of  Validation Failed
    Given Open CRM URL Module as "AuditManager1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Audit reference number in search results
#    And picks the audit case
#    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Audit status should be "Pending Final Audit Approval"
    And wait for plan to load "Business Sector"
    Then switch to frame1
    And clicks reject from the dropdown
    Then switch to frame1
    And enters manager comments "Manager test comment"
    And Click on Save button
    Then switch to frame1
    Then validation audit error displayed " You must provide a value for Outcome Reason."


#----------------------------------Facing issues---need TestCase clarification---------------------------#
#  @UAT_M8-21-16-01 @CREATE==
#  Scenario Outline: UAT_M8-21-16-03-Verify the Process of  Update Officer's Assessment
#    Given Open CRM URL Module as "AuditorUser1"
#    And Close Popup Window
#    And Click on Case management dropdown
#    And click on Queues
#    Then switch to frame0
#    And enters Audit reference number in search results
##    And picks the audit case
##    And click pick button
#    Then switch to frame0
#    Then Click on reference number
#    Then switch to frame1
#    And verifies " FINAL AUDIT REPORT " entry fields are displayed
#    When selects ASSESSMENT DETAILS
#    And clicks update assesment details button
#    When enters OFFICERS ASSESMENT details<Addressee> and <Address>
#    And clicks officers assesment submit
#    Then switch to frame1
#    And verifies " FINAL AUDIT REPORT " entry fields are displayed
#    And Click on Save button
#    Then Audit status should be "Reporting"
#
#    Examples:
#      | Addressee | Address  |
#      | testDataUpdated  | testInfoUpdated |
#
#  @UAT_M8-21-16-04 @CREATE++
#  Scenario Outline: UAT_M8-21-16-04-Verify the Process of  Remove Officer's Assessment
#    Given Open CRM URL Module as "AuditorUser1"
#    And Close Popup Window
#    And Click on Case management dropdown
#    And click on Queues
#    Then switch to frame0
#    And enters Audit reference number in search results
##    And picks the audit case
##    And click pick button
#    Then switch to frame0
#    Then Click on reference number
#    Then switch to frame1
#    And verifies " FINAL AUDIT REPORT " entry fields are displayed
#    When selects ASSESSMENT DETAILS
#    And clicks update assesment details button
#    When enters OFFICERS ASSESMENT details<Addressee> and <Address>
#    And clicks officers assesment submit
#    Then switch to frame1
#    And verifies " FINAL AUDIT REPORT " entry fields are displayed
#    And Click on Save button
#    Then Audit status should be "Reporting"
#
#    Examples:
#      | Addressee | Address  |
#      | testDataUpdated  | testInfoUpdated |








