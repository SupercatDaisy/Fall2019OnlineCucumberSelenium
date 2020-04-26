Feature: Create Calendar Event Feature
  As a user I want to be able to create Calendar Events


  Scenario: Create Calendar Event as sales manager
    Given user is on the login page
    When user logs in as a sales manager
    And user navigates to "Activities" and "Calendar Events"
    Then user click on create calendar event button
    And user enters "Sprint Retrospective" as a title
    And user enters "On this meeting we discuss what went well" as description
    Then user click on save and close button
    And user verify that description is "On this meeting we discuss what went well"
    And user verify that title is "Sprint Retrospective"


  @dataTable
  Scenario: Create Calendar Event as sales manager with data table
    Given user is on the login page
    When user logs in as a sales manager
    And user navigates to "Activities" and "Calendar Events"
    Then user click on create calendar event button
    And user enters new calendar event information
      | title       |Sprint Retrospective|
      | description |On this meeting we discuss what went well|
    Then user click on save and close button
    And user verifies that new calendar event was created
      | title       |Sprint Retrospective|
      | description |On this meeting we discuss what went well|
