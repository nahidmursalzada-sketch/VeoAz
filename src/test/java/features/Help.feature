@Help
  Feature: Help function
    Scenario Outline: Support information must operate according to the user's request.
      Given The main page is entered
      When  The help button is clicked
      Then  The how do i create my first video button is clicked
      And   The how many videos can i create button is clicked
      And   The can i use videos commercially button is clicked
      And   The what if my video won't generate button is clicked
      And   Database "<search>" is being conducted
      And   The search button is clicked
      And   The user click on the contact button

      Examples:
        | search                        |
        | Can I use videos commercially |