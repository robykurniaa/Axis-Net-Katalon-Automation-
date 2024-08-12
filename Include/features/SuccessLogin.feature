Feature: Login to Axis Net

  Scenario: Successful login with valid credentials
    Given the application is started
    And the Axis Net app is opened
    When I tap on the "Start" button on the login page
    And I enter the MSISDN in the login input field
    And I hide the keyboard
    And I tap on the "Number" button on the login page
    And I enter the OTP in the OTP input field
    And I hide the keyboard
    And I tap on the Next button
    Then I wait for the success login element to be present
