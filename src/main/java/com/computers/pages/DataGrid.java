package com.computers.pages;

import com.computers.component.BaseActionEditor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.computers.locators.Replacements.I;
import static com.computers.locators.Replacements.II;

public class DataGrid extends BasePage {

    private static final String XPATH_COMPUTER_BY_NAME = "//*[contains(@class,'computers')]//a[contains(text(),'{I}')]";
    private static final String XPATH_GENERIC_CELL_BY_COMPUTER_NAME = "//*[contains(@class,'computers')]//a[contains(text(),'{I}')]/../../td[{II}]";
    private static final String XPATH_COMPUTER_NAME_CELL = "//*[contains(@class,'computers')]//td[1]/a";
    private static final String XPATH_EMPTY_MESSAGE = "//*[@class='well']/em";
    private static final String XPATH_COMMON_HEADER = "(//th[contains(@class,'header')]/a)[{}]";

    private BaseActionEditor editor;

    public DataGrid(WebDriver driver) {
        super(driver);
        this.editor = new BaseActionEditor(driver);
    }

    public EditComputer openEditComputerByName(String computerName) {
        this.editor.clickOnElementByXpath(XPATH_COMPUTER_BY_NAME.replace(I, computerName));
        return new EditComputer(driver);
    }

    public String getIntroducedByComputerName(String computerName) {
        String xpath = XPATH_GENERIC_CELL_BY_COMPUTER_NAME.replace(I, computerName).replace(II, "2");
        return this.driver.findElement(By.xpath(xpath)).getText();
    }

    public String getDiscontinuedByComputerName(String computerName) {
        String xpath = XPATH_GENERIC_CELL_BY_COMPUTER_NAME.replace(I, computerName).replace(II, "3");
        return this.driver.findElement(By.xpath(xpath)).getText();
    }

    public String getByCompanyByComputerName(String computerName) {
        String xpath = XPATH_GENERIC_CELL_BY_COMPUTER_NAME.replace(I, computerName).replace(II, "4");
        return this.driver.findElement(By.xpath(xpath)).getText();
    }

    public List<String> getByComputerNames() {
        return this.driver.findElements(By.xpath(XPATH_COMPUTER_NAME_CELL))
                .stream().map(WebElement::getText).collect(Collectors.toList());

    }

    public String getEmptyMessage() {
        return this.driver.findElement(By.xpath(XPATH_EMPTY_MESSAGE)).getText();
    }

    private String getHeaderText(String index) {
        return this.driver.findElement(By.xpath(XPATH_COMMON_HEADER.replace(I, index))).getText();
    }

    public String getComputerNameHeader() {
        return getHeaderText("1");
    }

    public String getDiscontinuedHeader() {
        return getHeaderText("3");
    }

    public String getIntroducedHeader() {
        return getHeaderText("2");
    }

    public String getCompanyHeader() {
        return getHeaderText("4");
    }

}
