@Library
  Feature: Library function
    Scenario Outline: Library functions should work correctly
      Given The user has entered the main safe of the platform.
      When  Clicks on the library button
      Then  User is searching for "<video>"
      And   Click the list button
      And   Click the all button
      And   The button is selected in statusFilter
      And   Click the newest button
      And   The "<sortingFilter>" is selected.
      And   The first video button is clicked

      Examples:
        | video |  | sortingFilter |
        | video |  | Oldest        |