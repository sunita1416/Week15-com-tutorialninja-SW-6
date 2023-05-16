package com.tutorialninja.pages;

import com.tutorialninja.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountRegisterPage extends Utility {
    private static final Logger log = LogManager.getLogger(AccountRegisterPage.class.getName());

    public AccountRegisterPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstNameField;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastNameField;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephoneField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement passwordConfirmField;
    @CacheLookup
    @FindBy(xpath = "//fieldset[3]//input")
    List<WebElement> subscribeRadios;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicyCheckBox;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueBtn;

    public String getRegisterAccountText() {
        log.info("Get register text" + registerAccountText.toString());
        return getTextFromElement(registerAccountText);
    }

    public void enterFirstName(String fName) {
        sendTextToElement(firstNameField, fName);
        log.info("Enter First name " + fName + " to first name field " + firstNameField.toString());
    }

    public void enterLastName(String lName) {
        sendTextToElement(lastNameField, lName);
        log.info("Enter Last name " + lName + " to last name field " + lastNameField.toString());
    }

    public void enterEmail(String email) {
        sendTextToElement(emailField, email);
        log.info("Enter email " + email + " to email field " + emailField.toString());
    }

    public void enterTelephone(String telephone) {
        sendTextToElement(telephoneField, telephone);
        log.info("Enter telephone " + telephone + " to telephone field " + telephoneField.toString());
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        log.info("Enter Password " + password + " to Password field " + passwordField.toString());
    }

    public void enterConfirmPassword(String cPassword) {
        sendTextToElement(passwordConfirmField, cPassword);
        log.info("Enter confirm Password " + cPassword + " to Confirm Password field " + passwordConfirmField.toString());
    }

    public void selectSubscription(String option) {
        log.info("Select option from " + subscribeRadios.toString());
        List<WebElement> radioButtons = getListOfElements(subscribeRadios);
        for (WebElement e : radioButtons) {
            if (e.getText().equals(option)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnPrivacyPolicyCheckBox() {
        clickOnElement(privacyPolicyCheckBox);
        log.info("Click on Privacy policy " + privacyPolicyCheckBox.toString());
    }

    public void clickOnContinueButton() {
        clickOnElement(continueBtn);
        log.info("Click on continue " + continueBtn.toString());
    }

}
