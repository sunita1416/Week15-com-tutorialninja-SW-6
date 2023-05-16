package com.tutorialninja.steps;

import com.tutorialninja.pages.DesktopsPage;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.ProductPage;
import com.tutorialninja.pages.ShoppingCartPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class DesktopsSteps {
    @And("^I change currency to \"([^\"]*)\"$")
    public void iChangeCurrencyTo(String currency) throws InterruptedException {
        new HomePage().selectCurrency(currency);
    }

    @And("^I select sort by option \"([^\"]*)\"$")
    public void iSelectSortByOption(String option) throws InterruptedException {
        new DesktopsPage().selectSortByOption(option);
    }

    @Then("^Verify that products arranged in Descending order$")
    public void verifyThatProductsArrangedInDescendingOrder() throws InterruptedException {
        Assert.assertTrue(new DesktopsPage().isSorted(),"Products are not sorted in descending");
    }

    @And("^I Select product \"([^\"]*)\"$")
    public void iSelectProduct(String name) {
        new DesktopsPage().selectProductByName(name);
    }

    @Then("^Verify the Head Text \"([^\"]*)\"$")
    public void verifyTheHeadText(String expected) {
        Assert.assertEquals(new ProductPage().getProductText(),expected,"Product name is not matching");
    }

    @And("^I Select Delivery Date \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iSelectDeliveryDate(String day, String month, String year) {
        new ProductPage().selectDeliveryDate(day,month,year);
    }

    @And("^I Enter Qty \"([^\"]*)\"$")
    public void iEnterQty(String qty) {
        new ProductPage().enterQuantity(qty);
    }

    @And("^I Click on “Add to Cart” button$")
    public void iClickOnAddToCartButton() throws InterruptedException {
        new ProductPage().clickOnAddToCartButton();
    }

    @Then("^Verify the Message \"([^\"]*)\"$")
    public void verifyTheMessage(String expected) {
        Assert.assertTrue(new ProductPage().getProductAddedSuccessMessage().contains(expected),"Product is not added to cart");
    }

    @When("^I Click on link “shopping cart” display into success message$")
    public void iClickOnLinkShoppingCartDisplayIntoSuccessMessage() {
        new ProductPage().clickOnShoppingCartLinkIntoMessage();
    }

    @Then("^Verify the text \"([^\"]*)\"$")
    public void verifyTheText(String expected) throws InterruptedException {
        Assert.assertTrue(new ShoppingCartPage().getShoppingCartText().contains(expected),"Shopping cart page is not navigated");
    }

    @And("^Verify the Product name \"([^\"]*)\"$")
    public void verifyTheProductName(String expected) {
        Assert.assertEquals(new ShoppingCartPage().getProductName(),expected,"Product name is not matching");
    }

    @And("^Verify the Delivery Date \"([^\"]*)\"$")
    public void verifyTheDeliveryDate(String expected) {
        Assert.assertTrue(new ShoppingCartPage().getDeliveryDate().contains(expected),"Date is not matching");
    }

    @And("^Verify the Model \"([^\"]*)\"$")
    public void verifyTheModel(String expected) {
        Assert.assertEquals(new ShoppingCartPage().getModel(),expected,"Model name is not matching");
    }

    @And("^Verify the Total \"([^\"]*)\"$")
    public void verifyTheTotal(String expected) {
        Assert.assertEquals(new ShoppingCartPage().getTotal(),expected,"Total is not matching");
    }
}
