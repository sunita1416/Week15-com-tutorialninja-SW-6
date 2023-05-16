Feature: Desktop test
  As a User I want ro test Desktop Page

  @smoke @regression
  Scenario: User should be able to sort product in Alphabetical order
    Given I am on home page
    When I mouse hover on Desktop
    And I click on "Show AllDesktops"
    And I change currency to "£Pound Sterling"
    And I select sort by option "Name (Z - A)"
    Then Verify that products arranged in Descending order

  @sanity @regression
  Scenario: User can add product to shopping cart
    Given I am on home page
    When I mouse hover on Desktop
    And I click on "Show AllDesktops"
    And I change currency to "£Pound Sterling"
    And I select sort by option "Name (A - Z)"
    And I Select product "HP LP3065"
    Then Verify the Head Text "HP LP3065"
    And I Select Delivery Date "30" "November" "2023"
    And I Enter Qty "1"
    And I Click on “Add to Cart” button
    Then Verify the Message "Success: You have added HP LP3065 to your shopping cart!"
    When I Click on link “shopping cart” display into success message
    Then Verify the text "Shopping Cart"
    And Verify the Product name "HP LP3065"
    And Verify the Delivery Date "2023-11-30"
    And Verify the Model "Product 21"
    And Verify the Total "£74.73"