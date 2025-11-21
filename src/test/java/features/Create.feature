@Create
  Feature: Create function
    Scenario Outline: The create function should work as desired
      Given The main safe of the site is entered
      When  Click on the create button.
      Then  "<sceneDescription>" is included
      And   Clicking on the AI model button
      And   AI "<modelName>" is selected
      And   Clicking the AI Enhanced button
      And   Language selection for enhanced AI
      And   The create new button is clicked
      And   The orijinal button is clicked
      Examples:
        | sceneDescription | modelName |
        | People           | Veo 2     |
