Feature: Buy Page Search and Navigation


  @rent
  Scenario Outline: Missing landmark
    Given the user click the buy
    When the user selects location "<location>"
    And leaves the landmark field blank
    And clicks on search button
    Then an error message should be displayed

    Examples:
      | location |
      | Mumbai   |
   @rent
   Scenario Outline: Valid landmark
    Given the user click the buy
    When the user selects location "<location>"
    And enters landmark "<landmark>"
    And clicks on search button
    Then the user should be redirected to the Buy Page
    And the user clicks on BHK type
    And the user clicks on Property Type
    And the clicks Apartment type
    And the user clicks the Price Range
    Then the Property should be displayed
    Examples:
      | location | landmark  |
      | Chennai  | Velachery |
    
    