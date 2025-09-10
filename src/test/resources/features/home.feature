Feature: Home Page Search and Navigation


  @home
  Scenario Outline: Missing landmark
    Given the user selects location "<location>"
    And leaves the landmark field blank
    And clicks on search button
    Then an error message should be displayed

    Examples:
      | location |
      | Mumbai   |

  @home
  Scenario Outline: Valid landmark
    Given the user selects location "<location>"
    And enters landmark "<landmark>"
    And clicks on search button
    Then the user should be redirected to the Rent Page

    Examples:
      | location | landmark  |
      | Chennai  | Velachery |
      
  @home
  Scenario: View previous searches after new search
   Given the user selects location "<location>"
    And enters landmark "<landmark>"
    And clicks on search button
    Then the user should be redirected to the Rent Page
    And the user returns to the home page
    Then the previous search should appear in search history

    
   Examples:
      | location | landmark  |
      | Chennai  | Velachery |
      
      