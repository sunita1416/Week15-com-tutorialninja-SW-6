package com.tutorialninja.pages;

import com.tutorialninja.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNoteBooksPage extends Utility {
    private static final Logger log = LogManager.getLogger(LaptopsAndNoteBooksPage.class.getName());
    public LaptopsAndNoteBooksPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopsAndNotebooksText;

    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productsPrices;

    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList;

    @FindBy(id = "input-sort")
    WebElement sortBy;

    public String getLaptopsAndNotebooksText() {
        log.info("Get text " + laptopsAndNotebooksText.toString());
        return getTextFromElement(laptopsAndNotebooksText);
    }

    public ArrayList<Double> getProductsPriceList() {
        log.info("Get product prices " + productsPrices.toString());
        List<WebElement> products = getListOfElements(productsPrices);
        ArrayList<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return originalProductsPrice;
    }
    public boolean isSorted() throws InterruptedException {
        List<Double> sortedList= getProductsPriceList();
        Collections.sort(getProductsPriceList(), Collections.reverseOrder());
        return getProductsPriceList().equals(sortedList);
    }

    public void selectSortByOption(String option) {
        selectByVisibleTextFromDropDown(sortBy, option);
        log.info("Select option from " + sortBy.toString());
    }

    public void selectProductByName(String product) {
        log.info("Select "+product+" from " + productsList.toString());
        List<WebElement> products = getListOfElements(productsList);
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }

}
