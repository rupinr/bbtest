package com.computers;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void editTextFieldById(String id, String text) {
        driver.findElement(By.id(id)).sendKeys(text);
    }

    public void clickOnElementById(String id) {
        driver.findElement(By.id(id)).click();
    }

    public void clickOnElementByXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void selectComboBoxByIdWithValue(String id, String value) {
        Select select = new Select(this.driver.findElement(By.id(id)));
        select.selectByValue(value);
    }

    public void selectComboBoxByIdWithText(String id, String text) {
        Select select = new Select(this.driver.findElement(By.id(id)));
        select.selectByVisibleText(text);
    }


}