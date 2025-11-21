@Billing
  Feature: Billing function
    Scenario Outline: Payment methods should work in a way that suits the user's wishes.
      Given User enters the main vault.
      When  The user clicks on the control panel.
      Then  The user clicks the payment button.
      And   The user deposits the package they want.
      And   "<amount>" is entered
      And   Inserting a new "<cardNumber>"
      And   "<monthYear>" are entered
      And   Entering "<security>" code
      And   Click the Save card for future payments button.
      And   Click the saved card button

      Examples:
        | amount | cardNumber          | monthYear | security |
        | 4      | 4169 7388 1980 9157 | 10/27     | 616      |
