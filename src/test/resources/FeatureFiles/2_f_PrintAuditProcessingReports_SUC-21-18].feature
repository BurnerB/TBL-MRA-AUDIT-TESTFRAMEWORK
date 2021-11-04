Feature: [SUC:21-18] Print Audit Processing Reports

  Background:
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    Then User should be logged in

  @UAT_M8-21-18-01 @Reports
  Scenario Outline: UAT_M8-21-18-01-Verify the Process of  Print Report-Audit Case Details by Tax Office Report
    And Goto reporting link
    And click on  Reports link
    And Clicks on Audit Report "Audit Case Details by Tax Office"
    And Enter Report Paramenters <StartDate> , <EndDate> and <TaxOffice>
    And Click on Run Report button
    Then Verify file "<Filename>" has been downloaded in downloads directory "C:\\Users\\Maxipain\\Downloads"
    Examples:
      | StartDate  | EndDate    | TaxOffice | Filename                             |
      | 01/07/2018 | 01/07/2019 | Balaka    | Audit Case Details by Tax Office.pdf |

  @UAT_M8-21-18-01 @Reports
  Scenario Outline: UAT_M8-21-18-02-Verify the Process of  Print Report-Audit Performance Summary Report
    And Goto reporting link
    And click on  Reports link
    And Clicks on Audit Report "Audit Performance Statistics"
    And Enter Report Paramenters <StartDate> , <EndDate> and <TaxOffice>
    And Click on Run Report button
    Then Verify file "<Filename>" has been downloaded in downloads directory "C:\\Users\\Maxipain\\Downloads"
    Examples:
      | StartDate  | EndDate    | TaxOffice | Filename                             |
      | 01/07/2018 | 01/07/2019 | Balaka    | Audit Performance Statistics.pdf |

  @UAT_M8-21-18-01 @Reports
  Scenario Outline: UAT_M8-21-18-03-Verify the Process of  Print Report-Audit Performance Statistics
    And Goto reporting link
    And click on  Reports link
    And Clicks on Audit Report "Audit Performance Summary Report"
    And Enter Report Paramenters <StartDate> , <EndDate> and <TaxOffice>
    And Click on Run Report button
    Then Verify file "<Filename>" has been downloaded in downloads directory "C:\\Users\\Maxipain\\Downloads"
    Examples:
      | StartDate  | EndDate    | TaxOffice | Filename                             |
      | 01/07/2018 | 01/07/2019 | Balaka    | Audit Performance Summary Report.pdf |

  @UAT_M8-21-18-04 @Reports
  Scenario Outline: UAT_M8-21-18-04-Verify the Process of  Print Report-Audit Case Status Report
    And Goto reporting link
    And click on  Reports link
    And Clicks on Audit Report "Audit Case Status Report"
    And Enter Report Paramenters <StartDate> , <EndDate> and <TaxOffice>
    And Click on Run Report button
    Then Verify file "<Filename>" has been downloaded in downloads directory "C:\\Users\\Maxipain\\Downloads"
    Examples:
      | StartDate  | EndDate    | TaxOffice | Filename                             |
      | 01/07/2018 | 01/07/2019 | Balaka    | Audit Case Status Report.pdf |

  @UAT_M8-21-18-05 @Reports
  Scenario: UAT_M8-21-18-05-Verify the Process of  Validation Error
    And Goto reporting link
    And click on  Reports link
    And Clicks on Audit Report "Audit Case Details by Tax Office"
    And Click on Run Report button
    Then message is displayed "Validation Error: Value is required."

  @UAT_M8-21-18-06 @Reports
  Scenario Outline: UAT_M8-21-18-06-Verify the Process of Abandon Report
    And Goto reporting link
    And click on  Reports link
    And Clicks on Audit Report "Audit Performance Statistics"
    And Enter Report Paramenters <StartDate> , <EndDate> and <TaxOffice>
    And Click on Cancel Report button
    Then should return to reports page

    Examples:
      | StartDate  | EndDate    | TaxOffice |
      | 01/07/2018 | 01/07/2019 | Balaka    |




