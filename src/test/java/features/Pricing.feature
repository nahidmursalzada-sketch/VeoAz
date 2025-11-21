@Pricing
  Feature: Pricing function
    Scenario Outline: Pricing functions should be operated in an appropriate manner
      Given The user enters the site’s main landing page.
      When  The user taps the pricing button.
      Then  The user enters the "<amount>".
      And   The user taps the add credits button
      And   The user selects a package
      Examples:
        | amount |
        | 5      |