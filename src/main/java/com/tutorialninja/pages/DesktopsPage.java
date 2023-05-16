package com.tutorialninja.pages;

import com.tutorialninja.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsPage extends Utility {
    private static final Logger log = LogManager.getLogger(DesktopsPage.class.getName());
    public DesktopsPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopsText;

    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList;

    @FindBy(id = "input-sort")
    WebElement sortBy;


    public String getDesktopsText() {
        log.info("Get desktop text" + desktopsText.toString());
        return getTextFromElement(desktopsText);
    }

    public ArrayList<String> getProductsNameList() {
        log.info("Select option from " + productsList.toString());
        List<WebElement> products = getListOfElements(productsList);
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        return originalProductsName;
    }

    public void selectProductByName(String product) {
        log.info("Select option from " + productsList.toString());
        List<WebElement> products = getListOfElements(productsList);
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }

    public void selectSortByOption(String option) throws InterruptedException {
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(sortBy, option);
        log.info("Select " + option + " to sort by " + sortBy.toString());
    }
    public boolean isSorted() throws InterruptedException {
        List<String> sortedList= getProductsNameList();
        Collections.sort(sortedList,String.CASE_INSENSITIVE_ORDER);
        Collections.reverse(sortedList);
        return getProductsNameList().equals(sortedList);
    }

}
