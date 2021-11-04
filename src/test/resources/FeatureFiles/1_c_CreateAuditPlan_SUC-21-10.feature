Feature: [SUC:21-10] Create Audit Plan

  @UAT_M8-21-10-06
  Scenario: UAT_M8-21-10-06-Verify the Process of  Validation Failed
    Given Open CRM URL Module as "AuditorUser1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Audit reference number in search results
    And picks the audit case
    Then Audit status should be "Open"
    When clicks create audit plan
    Then switch to frame1
    And verifies " 1. AUDIT PLAN PARTICULARS " entry fields are displayed
    When enters audit case plan details
      | Auditors               | [blank]  |
      | Estimated Start Date   | 19112019 |
      | Estimated End Date     | 20112019 |
      | Case Officer           | [blank]  |
      | Team Leader            | [blank]  |
      | Objectives             | [blank]  |
      | Background Information | [blank]  |
      | Trend Analysis         | [blank]  |
      | Compliance History     | [blank]  |
      | Relevant Documents     | [blank]  |
    And Clicks submit audit plan button
    Then switch to frame1
    Then validation error displayed " This field can not be empty. "

  @UAT_M8-21-10-02 @CREATE
  Scenario: UAT_M8-21-10-01-UAT_M8-21-10-02-UAT_M8-21-10-04-UAT_M8-21-10-05-Verify the Process of  Create Audit Plan and submit
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
    Then create Create Audit Plan page is displayed
    When clicks create audit plan
    Then switch to frame1
    And verifies " 1. AUDIT PLAN PARTICULARS " entry fields are displayed
    When enters audit case plan details
      | Auditors               | TestAuditor    |
      | Estimated Start Date   | 19/11/2019     |
      | Estimated End Date     | 20/11/2019     |
      | Case Officer           | testOfficer    |
      | Team Leader            | testLeader     |
      | Objectives             | testObjectives |
      | Background Information | testInfo       |
      | Trend Analysis         | testAnalysis   |
      | Compliance History     | testHistory    |
      | Relevant Documents     | testDocuments  |
    And enters AUDIT SCOPE METHODOLOGY
      | taxtype                             | Domestic VAT    |
      | Tax Period                          | 1/2020          |
      | Risk Area(s)                        | Airport Tax     |
      | Materiality                         | materialityTest |
      | Tests to be Conducted (Methodology) | methodologyTest |
      | Responsible Auditors                | testAuditors    |
      | Time Allocated (in days)            | 2               |
    And Clicks submit audit plan button
    Then Audit status should be "Pending Audit Plan Approval"








