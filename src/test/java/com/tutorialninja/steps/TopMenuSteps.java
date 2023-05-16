package com.tutorialninja.steps;

import com.tutorialninja.pages.ComponentsPage;
import com.tutorialninja.pages.DesktopsPage;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.LaptopsAndNoteBooksPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class TopMenuSteps {
    @Given("^I am on home page$")
    public void iAmOnHomePage() {
    }

    @When("^I mouse hover on Desktop$")
    public void iMouseHoverOnDesktop() {
        new HomePage().mouseHoverOnDesktopsLinkAndClick();
    }

    @And("^I click on \"([^\"]*)\"$")
    public void iClickOn(String menu) {
        new HomePage().selectMenu(menu);
    }

    @Then("^Verify that User is navigated to Desktop page using \"([^\"]*)\"$")
    public void verifyThatUserIsNavigatedToDesktopPageUsing(String expected) {
        Assert.assertEquals(new DesktopsPage().getDesktopsText(),expected,"User in not navigated");
    }

    @When("^I mouse hover on Laptop and Notebook$")
    public void iMouseHoverOnLaptopAndNotebook() {
        new HomePage().mouseHoverOnLaptopsAndNotebooksLinkAndClick();
    }

    @Then("^Verify that User is navigated to Laptop page using \"([^\"]*)\"$")
    public void verifyThatUserIsNavigatedToLaptopPageUsing(String expected) {
        Assert.assertEquals(new LaptopsAndNoteBooksPage().getLaptopsAndNotebooksText(),expected,"User is not navigated");
    }

    @When("^I mouse hover on Component$")
    public void iMouseHoverOnComponent() {
        new HomePage().mouseHoverOnComponentLinkAndClick();
    }

    @Then("^Verify that User is navigated to Component page using \"([^\"]*)\"$")
    public void verifyThatUserIsNavigatedToComponentPageUsing(String expected) {
        Assert.assertEquals(new ComponentsPage().getComponentsText(),expected,"User is not navigated");
    }
}
