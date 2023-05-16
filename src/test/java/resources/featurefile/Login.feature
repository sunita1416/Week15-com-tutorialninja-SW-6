Feature: Login Test
  As a User I want to login and logout successfully

  @smoke @regression
  Scenario: User should be navigated to login page successfully
    Given I am on home page
    When I click on myAccountTab
    And I select "Login"
    Then Verify User is navigated to login page using "Returning Customer"

  @sanity @regression
  Scenario: User should login and logout successfully
    Given I am on home page
    When I click on myAccountTab
    And I select "Login"
    And I enter EmailAddress "prime1233@gmail.com"
    And I Enter Login Password "test1234"
    And I click on login button
    And I click on myAccountTab
    And I select "Logout"
    Then Verify the text "Account Logout"