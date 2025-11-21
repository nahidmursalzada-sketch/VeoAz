@Contact
  Feature: Contact function
    Scenario Outline: Contact functions should be operated in an appropriate manner
      Given The user goes to the website’s homepage.
      When  The contact button is clicked
      Then  The user enters their "<name>"
      And   The user enters "<email>" address
      And   The user adds a "<subject>".
      And   The user enters a "<message>".
      And   The category button is clicked
      And   The user select category
      And   The send message button is clicked
      And   The send message another button is clicked

      Examples:
        | name  | email                   | subject                    | message                                                           |  |
        | Nahid | nahidmurslzad@gmail.com | Unable to purchase credits | Hello, I'm encountering an issue when trying to purchase credits. |  |
