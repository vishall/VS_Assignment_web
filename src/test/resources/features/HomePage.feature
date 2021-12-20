@HomePage
Feature: To verify basic flows on coinmarketcap site

  Scenario: Verify the number of results
    Given user on the home page
    And user can see 100 results for various cryptos

  # Not fully implemented
  Scenario: Verify the watchlist on cryptocurrency result list
    Given user on the home page
    And user clicks on login link
    And user enters username and password
    And user clicks on login button
    And user should complete slide in captcha
    Then user should be able to login successfully
    And user should add some cryptocurrencies to the watchlist
    And user open the watchlist in different browser window
    When user clicks on the watchlist tab
    Then user verify all the selected options are added to the watchlist

  Scenario: Verify the historical data with different date range
    Given user on the home page
    And user select the historical data for one of the cryptocurrency
    When user record the current data for selected date range
    And user change the date range from the date filter
    Then user verify result against preselected historical data


