package com.tutorialninja.steps;

import com.tutorialninja.pages.AccountRegisterPage;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.MyAccountPage;
import com.tutorialninja.utilities.Utility;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class RegistrationSteps {
    @When("^I click on myAccountTab$")
    public void iClickOnMyAccountTab() {
        new HomePage().clickOnMyAccountTab();
    }

    @And("^I select \"([^\"]*)\"$")
    public void iSelect(String option) {
        new HomePage().selectMyAccountOptions(option);
    }

    @Then("^Verify User is navigated to register page using \"([^\"]*)\"$")
    public void verifyUserIsNavigatedToRegisterPageUsing(String expected) {
        Assert.assertEquals(new AccountRegisterPage().getRegisterAccountText(),expected,"Navigation is not successful");
    }

    @And("^I Enter First Name \"([^\"]*)\"$")
    public void iEnterFirstName(String firstname) {
        new AccountRegisterPage().enterFirstName("Prime" + Utility.getRandomString(2));
    }

    @And("^I Enter Last Name \"([^\"]*)\"$")
    public void iEnterLastName(String lastname) {
        new AccountRegisterPage().enterLastName("test"+ Utility.getRandomString(2));
    }

    @And("^I Enter Email \"([^\"]*)\"$")
    public void iEnterEmail(String email) {
        new AccountRegisterPage().enterEmail("prime"+Utility.getRandomString(3)+"@gmail.com");
    }

    @And("^I Enter Telephone \"([^\"]*)\"$")
    public void iEnterTelephone(String phone) {
        new AccountRegisterPage().enterTelephone("07424108905");
    }

    @And("^I Enter Password \"([^\"]*)\"$")
    public void iEnterPassword(String password) {
        new AccountRegisterPage().enterPassword("test123");
    }

    @And("^I Enter Password Confirm \"([^\"]*)\"$")
    public void iEnterPasswordConfirm(String password) {
        new AccountRegisterPage().enterConfirmPassword("test123");
    }

    @And("^I Select Subscribe \"([^\"]*)\" radio button$")
    public void iSelectSubscribeRadioButton(String value) {
        new AccountRegisterPage().selectSubscription(value);
    }

    @And("^I Click on Privacy Policy check box$")
    public void iClickOnPrivacyPolicyCheckBox() {
        new AccountRegisterPage().clickOnPrivacyPolicyCheckBox();
    }

    @And("^I Click on Continue button$")
    public void iClickOnContinueButton() {
        new AccountRegisterPage().clickOnContinueButton();
    }

    @Then("^Verify the success message \"([^\"]*)\"$")
    public void verifyTheSuccessMessage(String expected) {
        Assert.assertEquals(new MyAccountPage().getYourAccountHasBeenCreatedText(),expected,"Account is not created");
    }

    @When("^I Click on Continue$")
    public void iClickOnContinue() {
        new MyAccountPage().clickOnContinueButton();
    }
}
