@VideoStatus
  Feature: New video status feature
    Scenario: Video status should work properly
      Given Entering the main part of the site
      When  Dashboard is then clicked on the video status button
      Then  Click on the refresh button.
      And   Click on the completed button
      And   Click on the video download button
      And   Click on the Failed button
      And   Click on the All button
