Feature: User Login

 Scenario: Login with invalid mobile number
    Given the user is on the login page
    When the user enters a invalid phone number 
    Then an invalid number message should be shown

  Scenario: Login with invalid OTP
    Given the user is on the login page
	When the user enters a valid phone number
	And the user enters the invalid OTP
    Then an invalid otp message should be shown
    
  Scenario: OTP Expiry and Resend
    Given the user is on the login page
    When the user enters a valid phone number
    And waits until the OTP expires and clicks on resend button
    And the user enters the valid OTP
    Then the user should be logged in successfully

  Scenario: Page loaded successfully
    Given the user is on the login page
    Then the login page should be loaded successfully
    
  Scenario: Login with valid credentials
    Given the user is on the login page
    When the user enters a valid phone number
	And the user enters the valid OTP
    Then the user should be logged in successfully