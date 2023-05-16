package com.tutorialninja.pages;

import com.tutorialninja.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends Utility {
    private static final Logger log = LogManager.getLogger(ShoppingCartPage.class.getName());

    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement model;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement total;
    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement qtyField;
    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement qtyUpdateBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement successModifiedMessage;

    public String getShoppingCartText() throws InterruptedException {
        Thread.sleep(500);
        log.info("Get text " + shoppingCartText.toString());
        return getTextFromElement(shoppingCartText);
    }

    public String getProductName() {
        log.info("Get product name" + productName.toString());
        return getTextFromElement(productName);
    }

    public String getDeliveryDate() {
        log.info("Get delivery date" + deliveryDate.toString());
        return getTextFromElement(deliveryDate);
    }

    public String getModel() {
        log.info("Get Model name" + model.toString());
        return getTextFromElement(model);
    }

    public String getTotal() {
        log.info("Get total" + total.toString());
        return getTextFromElement(total);
    }

    public void changeQuantity(String qty) {
        qtyField.sendKeys(Keys.BACK_SPACE);
        sendTextToElement(qtyField, qty);
        log.info("Change quantity" + qty.toString());
    }

    public void clickOnQtyUpdateButton() {
        clickOnElement(qtyUpdateBtn);
        log.info("Click on update" + qtyUpdateBtn.toString());
    }

    public String getSuccessModifiedMessage() {
        log.info("Get success message" + successModifiedMessage.toString());
        return getTextFromElement(successModifiedMessage);
    }
}
