@LanguageSelect
  Feature: Language selection function
    Scenario: The language should be chosen according to the user's wishes.
      Given The site's home page opens.
      When  The language selection button is clicked
      Then  Click the US button
