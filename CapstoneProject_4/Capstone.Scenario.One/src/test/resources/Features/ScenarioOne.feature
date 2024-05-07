Feature: Verify functionality of the-internet.herokuapp.com website

Scenario: Verify title of the homepage
    Given User navigates to the homepage
    Then Page title should be "The Internet"

Scenario: Verify A/B Testing link
    Given User clicks on A/B Testing link
    Then Page should display text "A/B Test Variation 1"

Scenario: Verify dropdown functionality
    Given User navigates to the homepage
    And User clicks on dropdown link
    When User selects Option1 from dropdown
    Then Option1 should be selected

Scenario: Verify Frames page
    Given User navigates to the homepage
    And User clicks on Frames link
    Then Nested Frames link should be present
    And iFrame link should be present
