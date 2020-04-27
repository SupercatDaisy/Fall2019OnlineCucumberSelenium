Feature: View all calendar events
  As a user I want to be able to see all Calendar Events as a table

  @Rerun
  Scenario: User permissions
    Given user is on the login page
    When user logs in as a sales manager
    When user navigates to "Activities" and "Calendar Events"
    Then View Per Page menu should have following options
    |10 |
    |25 |
    |50 |
  # |100|