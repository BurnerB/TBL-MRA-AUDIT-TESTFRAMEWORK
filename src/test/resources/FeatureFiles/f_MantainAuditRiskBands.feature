Feature: [SUC:21-01] Maintain Audit Selection Risk Bands

  Background:
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    Then User should be logged in
    Then Navigate to audit > Mantain risk bands

    @SUC:21-01 @UAT_M8-21-01-01
    Scenario: UAT_M8-21-01-01-Verify the fields in Create Risk Band screen
      Then Verify fields in Mantain risk bands screen
      Then Click add to open add risk bands frame
      Then Verify fields in add risk band frame

    @SUC:21-01 @UAT_M8-21-01-01
    Scenario: UAT_M8-21-01-02-Verify the Process of Create Risk Band
      Then Click add to open add risk bands frame
      Then Fill in audit risk band details



