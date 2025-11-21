@Legal
    Feature: Legal function
        Scenario: Blog pricing functions should be operated in an appropriate manner
            Given Access is granted to the main entry page of the site.
            When  Click on the privacy button
            Then  Going back
            And   Click on the terms button
            And   The user returns back
            And   Click on the refunds button
            And   Going back.
            And   Click on the accessibility button