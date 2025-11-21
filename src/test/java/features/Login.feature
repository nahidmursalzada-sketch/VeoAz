@Login
  Feature: Login feature
    Scenario Outline: A previously registered user should be able to log in easily.
      Given The user navigates to the homepage.
      When  The login button is clicked.
      Then  "<email>" and "<password>" are entered.
      And   Click the submit button


      Examples:
        | email                   | password    |
        | nahidmurslzad@gmail.com | 06nahid2006 |