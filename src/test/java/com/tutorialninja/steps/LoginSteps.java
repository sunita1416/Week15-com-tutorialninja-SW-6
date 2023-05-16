package com.tutorialninja.steps;

import com.tutorialninja.pages.AccountLoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;

public class LoginSteps {
    @Then("^Verify User is navigated to login page using \"([^\"]*)\"$")
    public void verifyUserIsNavigatedToLoginPageUsing(String expected) {
        Assert.assertEquals(new AccountLoginPage().getReturningCustomerText(),expected,"Navigation is not successful");
    }

    @And("^I enter EmailAddress \"([^\"]*)\"$")
    public void iEnterEmailAddress(String email) {
        new AccountLoginPage().enterEmailAddress(email);
    }

    @And("^I Enter Login Password \"([^\"]*)\"$")
    public void iEnterLoginPassword(String password) {
        new AccountLoginPage().enterPassword(password);
    }

    @And("^I click on login button$")
    public void iClickOnLoginButton() {
        new AccountLoginPage().clickOnLoginButton();
    }
}
