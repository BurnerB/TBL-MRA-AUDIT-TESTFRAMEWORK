Feature: [SUC:21-08] Assign an Audit Case

 @UAT_M8-21-08-01 @CREATE
  Scenario: UAT_M8-21-08-01-UAT_M8-21-08-02-Verify the Process of Assign Audit Case
    Given Open CRM URL Module as "AuditManager1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
   Then switch to frame0
#   And select queues im a member of
    And enters Audit reference number in search results
    And picks the audit case
    And click assign button
    Then Assign pop up is displayed
    And search team to assign
    And selects the team "Auditor Team"
    Then Switch to default
    Then Assign pop up is displayed
    And assigns to the team or user



