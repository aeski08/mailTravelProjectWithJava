@US_001

Feature: User book flight tickets and accommodation online from mailtravel website.

  Scenario: User should book flight tickets and accommodation online from mailtravel website.
    Given user goes to homepage of mailtravel website
    Then user verifies page title is "Home Page | Mail Travel"
    And user clicks on accept all cookies button
    And user types "India" in search box
    And user selects the first option from dropdown menu
    Then user verifies first book online button is clickable and clicks on the button
    When user scrolls to the bottom of the page
    And user selects the first available date
    Then user verifies the text Please select your departure date is not visible after clicking on the first available date
    And user checks the price for "1" adult
    And user selects "2" adults
    Then user verifies the price for two adults
    And user clicks on book online button at the bottom
    When user expands the Date, Departure & Passengers section on the next page
    Then user verifies the details populated are valid
    Then user selects "1" twin room for two people under the accommodation section and clicks on the SELECT YOUR ROOMS AND CONTINUE
    When user fills the Passenger details
    And user selects email under where did you hear about us? text and clicks CONTINUE button
    Then user verifies the "Confirm Details + Book" page is visible
    And user verifies the Book Now button is clickable




