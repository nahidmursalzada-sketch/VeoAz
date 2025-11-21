@About
  Feature: About function
    Scenario Outline: When a user clicks on the About Us section, relevant information about the company should appear.
      Given The main page of the site is accessed.
      When  About us button is clicked.
      Then  Click on the plans button.
      And   The "<amount>" is entered.
      And   The user clicks on the desired package

      Examples:
        | amount |
        | 30     |
