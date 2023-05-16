Feature: TopMenu Test
  As a user I want to test my top menu

  @smoke @regression
  Scenario: User should be navigated to Desktop page
    Given I am on home page
    When I mouse hover on Desktop
    And I click on "Show AllDesktops"
    Then Verify that User is navigated to Desktop page using "Desktops"

  @smoke @regression
  Scenario: User should be navigated to Laptop and Notebook page
    Given I am on home page
    When I mouse hover on Laptop and Notebook
    And I click on "Show AllLaptops & Notebooks"
    Then Verify that User is navigated to Laptop page using "Laptops & Notebooks"

  @smoke @regression
  Scenario: User should be navigated to Component page
    Given I am on home page
    When I mouse hover on Component
    And I click on "Show AllComponents"
    Then Verify that User is navigated to Component page using "Components"