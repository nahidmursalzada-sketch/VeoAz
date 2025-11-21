@BlogAll
  Feature: BlogAll function
    Scenario Outline: User should be able to view blogs.
      Given The user is redirected to the homepage of the site.
      When  The blog button is clicked.
      Then  The read more button is clicked
      And   The share button is clicked
      And   The back to blog button is clicked
      And   The read more two button clicked
      And   The read more three button clicked
      And   The read more four button is clicked
      And   The read more five button is clicked
      And   Looking for "<article>"

      Examples:
        | article                                     |
        | Video Marketing Strategies: Success with AI |
