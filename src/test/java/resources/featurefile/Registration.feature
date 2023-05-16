Feature: Registration Test
  As a User I want to register on website

  @smoke @regression
  Scenario: User should navigated on registration page successfully
    Given I am on home page
    When I click on myAccountTab
    And I select "Register"
    Then Verify User is navigated to register page using "Register Account"

  @sanity @regression
  Scenario: User can login and logout successfully
    Given I am on home page
    When I click on myAccountTab
    And I select "Register"
    And I Enter First Name "<firstname>"
    And I Enter Last Name "<lastname>"
    And I Enter Email "<email>"
    And I Enter Telephone "<phone>"
    And I Enter Password "<password>"
    And I Enter Password Confirm "<cpassword>"
    And I Select Subscribe "Yes" radio button
    And I Click on Privacy Policy check box
    And I Click on Continue button
    Then Verify the success message "Your Account Has Been Created!"
    When I Click on Continue
    And I click on myAccountTab
    And I select "Logout"
    Then Verify the text "Account Logout"
    And I Click on Continue