Feature: Laptop and Notebook test
  As a user I want to test Laptop and Notebook Test

  @smoke @regression
  Scenario: User should be able to sort product price in High to Low
    Given I am on home page
    When I mouse hover on Laptop and Notebook
    And I click on "Show AllLaptops & Notebooks"
    And I change currency to "£Pound Sterling"
    And I select sort by option "Price (High > Low)"
    Then Verify that products sorted in Descending order

  @sanity @regression
  Scenario: User can place order successfully
    When I am on home page
    When I mouse hover on Laptop and Notebook
    And I click on "Show AllLaptops & Notebooks"
    And I change currency to "£Pound Sterling"
    And I select sort by option "Price (High > Low)"
    And I Select product "MacBook"
    Then Verify the Head Text "MacBook"
    And I Click on “Add to Cart” button
    Then Verify the Message "Success: You have added MacBook to your shopping cart!"
    When I Click on link “shopping cart” display into success message
    Then Verify the text "Shopping Cart"
    And Verify the Product name "MacBook"
    When I Change Quantity "2"
    And I Click on “Update” Tab
    Then Verify the message "Success: You have modified your shopping cart!"
    And Verify the Total "£737.45"