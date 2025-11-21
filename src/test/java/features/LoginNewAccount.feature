@LoginNewAccount
  Feature: New account function
    Scenario Outline: The functions of the new account must work correctly.
      Given Access to the site is granted.
      When  Click on the Sign In button
      Then  "<email>" address and "<password>" are entered
      And   The submit button is clicked

      Examples:
        | email                     | password    |
        | nahidmursalzada@gmail.com | 06nahid2006 |