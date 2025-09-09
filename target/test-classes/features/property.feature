Feature: Post Property Functionality

  Background:
    Given the user is on the login page
    When the user enters a valid phone number
    And the user enters the valid OTP
    Then the user should be logged in successfully

  Scenario: User opens the Post Your Property page
    When the user clicks on Post Free Property Ad
    And the user clicks on Post a New Property Ad Free
    Then the Post Your Property page should be displayed
    
 Scenario: User fills the Post Property details from Excel
	  Given the Post Your Property page is open
	  When the user fills property details from excel row 1
	  And the user clicks on Start Posting Your Ad For Free button
	  Then the Property Details form should be displayed
