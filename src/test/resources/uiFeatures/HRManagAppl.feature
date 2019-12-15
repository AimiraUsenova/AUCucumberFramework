@ProjectOrange
Feature: HR Management Application
  Scenario: Login as an Admin and change password for Fiona Grace and verify it is changed by signing in again
    Given User navigates to login page
    Then User provides login "Admin" and password "admin123"
    And Change password for Fiona Grace
    Then Verify it is changed by signing in again


