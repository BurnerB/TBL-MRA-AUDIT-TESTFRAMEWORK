Feature: [SUC:21-14] Create Final Audit Report & [SUC:21-16] Officer's Assessment

  @UAT_M8-21-14-05 @CREATE
  Scenario: UAT_M8-21-14-05-Verify the Process of  Invalid Final Audit Report
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
    Then Audit status should be "Preliminary Audit Approved"
    When clicks Create Final Audit Report
    Then switch to frame1
    And verifies " FINAL AUDIT REPORT " entry fields are displayed
    And Clicks submit Submit Final Audit Report button
    Then switch to frame1
    Then final audit validation error is displayed "This field can not be empty. "

  @UAT_M8-21-14-01 @CREATE
  Scenario: UAT_M8-21-14-01-UAT_M8-21-14-02-Verify the Process of  Create Final Audit Report
    Given Open CRM URL Module as "AuditorUser1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Audit reference number in search results
#    And picks the audit case
#    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Audit status should be "Preliminary Audit Approved"
    When clicks Create Final Audit Report
    Then switch to frame1
    And verifies " FINAL AUDIT REPORT " entry fields are displayed
    When enters FINAL AUDIT REPORT details
      | Address Visited  | TestAddress    |
      | Address Visited  | TestAddress    |
      | Date(s) of Visit | 20/11/2019     |
      | Number of Visits | 1              |
      | Contact Person   | testLeader     |
      | SUBJECT          | testObjectives |
      | BACKGROUND       | testInfo       |
      | CONCLUSION       | testAnalysis   |
    And Click on Save button
    Then Audit status should be "Reporting"

  @UAT_M8-21-12-03 @CREATE
  Scenario Outline: UAT_M8-21-14-03-Verify the Process of  Update Final Audit Report-
    Given Open CRM URL Module as "AuditorUser1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Audit reference number in search results
#    And picks the audit case
#    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then switch to frame1
    And verifies " FINAL AUDIT REPORT " entry fields are displayed
    When selects FINAL AUDIT FINDINGS
    And clicks update final audit findings button
    When enters updated FINAL AUDIT REPORT details<updatedinfo> and <particulars>
    And clicks ok on update Info
    And Click on Save button
    Then Audit status should be "Reporting"

    Examples:
      | updatedinfo | particulars |
      | testData    | testInfo    |

  @UAT_M8-21-14-06 @CREATE
  Scenario Outline: UAT_M8-21-16-05-Verify the Process of Validation Failed([SUC:21-16] Officer's Assessment)
    Given Open CRM URL Module as "AuditorUser1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Audit reference number in search results
#    And picks the audit case
#    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then switch to frame1
    And verifies " FINAL AUDIT REPORT " entry fields are displayed
    When selects ASSESSMENT DETAILS
    And clicks add assesment details button
    And clicks officers assesment submit
    Then switch to frame1
    Then final officers assesment validation error is displayed "  This field can not be empty. "

    Examples:
      | Addressee | Address |
      |           |         |

  @UAT_M8-21-14-06 @CREATE
#  ([SUC:21-16] Officer's Assessment)
  Scenario Outline: UAT_M8-21-14-06-UAT_M8-21-16-01-UAT_M8-21-16-02-Verify the Process of  Officer's Assessment-Verify the Process of  Update Final Audit Report-Verify the Process of  Officer's Assessment-Verify the Process of  Maintain Officer's Assessment([SUC:21-16] Officer's Assessment)
    Given Open CRM URL Module as "AuditorUser1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Audit reference number in search results
#    And picks the audit case
#    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then switch to frame1
    And verifies " FINAL AUDIT REPORT " entry fields are displayed
    When selects ASSESSMENT DETAILS
    And clicks add assesment details button
    When enters OFFICERS ASSESMENT details<Addressee> and <Address>
    And clicks officers assesment submit
    Then switch to frame1
    And verifies " FINAL AUDIT REPORT " entry fields are displayed
    And Click on Save button
    Then Audit status should be "Reporting"
    Examples:
      | Addressee | Address  |
      | testData  | testInfo |


  @UAT_M8-21-12-05 @CREATE
  Scenario: UAT_M8-21-14-04-Verify the Process of Submit Final Audit Report
    Given Open CRM URL Module as "AuditorUser1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Audit reference number in search results
#    And picks the audit case
#    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then switch to frame1
    And verifies " FINAL AUDIT REPORT " entry fields are displayed
    And Clicks submit Submit Final Audit Report button
    Then Audit status should be "Pending Final Audit Approval"












