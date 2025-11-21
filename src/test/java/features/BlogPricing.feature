@BlogPricing
  Feature: Blog pricing function
    Scenario: Blog pricing functions should be operated in an appropriate manner
      Given The user is redirected to the homepage.
      When  The blog button view is active.
      Then  Click the pricing button
      And   The user selects the Read More option.
      And   The user initiates the Share action.
      And   The user navigates back using the Back to Blog button.