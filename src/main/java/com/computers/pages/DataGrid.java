package com.computers.pages;

import com.computers.component.BaseActionEditor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.computers.locators.Replacements.I;
import static com.computers.locators.Replacements.II;

public class DataGrid extends BasePage {

    private static final String XPATH_COMPUTER_BY_NAME = "//*[contains(@class,'computers')]//a[contains(text(),'{I}')]";
    private static final String XPATH_GENERIC_CELL_BY_COMPUTER_NAME = "//*[contains(@class,'computers')]//a[contains(text(),'{I}')]/../../td[{II}]";

    private BaseActionEditor editor;

    public DataGrid(WebDriver driver) {
        super(driver);
        this.editor = new BaseActionEditor(driver);
    }

    public EditComputer clickOnEditByComputerName(String computerName) {
        this.editor.clickOnElementByXpath(XPATH_COMPUTER_BY_NAME.replace(I, computerName));
        return new EditComputer(driver);
    }

    public boolean isIntroducedMatching(String computerName, String expected) {
        String xpath = XPATH_GENERIC_CELL_BY_COMPUTER_NAME.replace(I, computerName).replace(II, "2");
        return this.driver.findElement(By.xpath(xpath)).getText().equals(expected);
    }

    public boolean isDiscontinuedMatching(String computerName, String expected) {
        String xpath = XPATH_GENERIC_CELL_BY_COMPUTER_NAME.replace(I, computerName).replace(II, "3");
        return this.driver.findElement(By.xpath(xpath)).getText().equals(expected);
    }

    public boolean isCompanyMatching(String computerName, String expected) {
        String xpath = XPATH_GENERIC_CELL_BY_COMPUTER_NAME.replace(I, computerName).replace(II, "4");
        return this.driver.findElement(By.xpath(xpath)).getText().equals(expected);
    }
}
