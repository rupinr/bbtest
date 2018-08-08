package com.computers.pages;

import com.computers.component.BaseActionEditor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.computers.locators.Replacements.I;

public class AddOrEditComputer extends BasePage {
    private static final String ID_NAME = "name";
    private static final String ID_INTRODUCED = "introduced";
    private static final String ID_DISCONTINUED = "discontinued";
    private static final String ID_COMPANY = "company";
    private static final String XPATH_COMMON_LABEL_BY_ID = "//fieldset//label[@for='{I}']";
    private static final String XPATH_COMMON_HELP_TEXT_BY_ID = "//fieldset//input[@id='{I}']//following-sibling::*[@class='help-inline']";

    private static final String XPATH_SUBMIT = "//*[@type='submit']";
    private static final String XPATH_CANCEL = "//*[@class='actions']/a[@class='btn']";
    private static final String XPATH_COMMON_FILED = "//fieldset//input[@id='name']/../..";
    private static final String CLASS_ERROR = "error";

    private BaseActionEditor editor;

    public AddOrEditComputer(WebDriver driver) {
        super(driver);
        this.editor = new BaseActionEditor(driver);
    }


    public AddOrEditComputer editComputerName(String computerName) {
        this.editor.editTextFieldById(ID_NAME, computerName);
        return this;
    }

    public AddOrEditComputer editIntroducedDate(String computerName) {
        this.editor.editTextFieldById(ID_INTRODUCED, computerName);
        return this;
    }


    public AddOrEditComputer editDiscontinuedDate(String computerName) {
        this.editor.editTextFieldById(ID_DISCONTINUED, computerName);
        return this;
    }

    public AddOrEditComputer selectCompany(String computerName) {
        this.editor.selectComboBoxByIdWithText(ID_COMPANY, computerName);
        return this;
    }

    public ComputerDatabase submit() {
        this.editor.clickOnElementByXpath(XPATH_SUBMIT);
        return new ComputerDatabase(driver);
    }

    public ComputerDatabase cancel() {
        this.editor.clickOnElementByXpath(XPATH_CANCEL);
        return new ComputerDatabase(driver);
    }

    private String getLabel(String id) {
        return driver.findElement(By.xpath(XPATH_COMMON_LABEL_BY_ID.replace(I, id))).getText();
    }

    private String getHelpText(String id) {
        return driver.findElement(By.xpath(XPATH_COMMON_HELP_TEXT_BY_ID.replace(I, id))).getText();
    }

    public String getComputerNameLabel() {
        return getLabel(ID_NAME);
    }

    public String getIntroducedLabel() {
        return getLabel(ID_INTRODUCED);
    }

    public String getDiscontinuedLabel() {
        return getLabel(ID_DISCONTINUED);
    }

    public String getCompanyLabel() {
        return getLabel(ID_COMPANY);
    }

    public String getIntroducedHelpText() {
        return getHelpText(ID_INTRODUCED);
    }

    public String getDiscontinuedHelpText() {
        return getHelpText(ID_DISCONTINUED);
    }

    public String getComputerNameHelpText() {
        return getHelpText(ID_NAME);
    }

    protected boolean isSubmitDisplayed() {
        return driver.findElement(By.xpath(XPATH_SUBMIT)).isDisplayed();
    }

    public boolean isCancelDisplayed() {
        return driver.findElement(By.xpath(XPATH_SUBMIT)).isDisplayed();
    }

    public boolean isErrorHighlightPresentForName() {
        return this.isErrorHighlightedByID(ID_NAME);
    }

    public boolean isErrorHighlightPresentForIntroduced() {
        return this.isErrorHighlightedByID(ID_INTRODUCED);
    }

    public boolean isErrorHighlightPresentForDiscontinued() {
        return this.isErrorHighlightedByID(ID_INTRODUCED);
    }

    private boolean isErrorHighlightedByID(String id) {
        return this.driver.findElement(By.xpath(XPATH_COMMON_FILED.replace(I, id))).getAttribute("class")
                .contains(CLASS_ERROR);
    }

}
