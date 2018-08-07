package com.computers;

import org.openqa.selenium.WebDriver;

public class AddOrEditComputer extends BasePage {
    private static final String ID_NAME = "name";
    private static final String ID_INTRODUCED = "introduced";
    private static final String ID_DISCONTINUED = "discontinued";
    private static final String ID_COMPANY = "company";
    private static final String XPATH_SUBMIT = "//*[@type='submit']";
    private static final String XPATH_CANEL = "//*[@class='actions']/a[@class='btn']";

    public AddOrEditComputer(WebDriver driver) {
        super(driver);
    }


    public AddOrEditComputer editComputerName(String computerName) {
        this.editTextFieldById(ID_NAME, computerName);
        return this;
    }

    public AddOrEditComputer editIntroducedDate(String computerName) {
        this.editTextFieldById(ID_INTRODUCED, computerName);
        return this;
    }


    public AddOrEditComputer editDiscontinuedDate(String computerName) {
        this.editTextFieldById(ID_DISCONTINUED, computerName);
        return this;
    }

    public AddOrEditComputer selectCompany(String computerName) {
        this.selectComboBoxByIdWithText(ID_COMPANY, computerName);
        return this;
    }

    public ComputerDatabase submit() {
        this.clickOnElementByXpath(XPATH_SUBMIT);
        return new ComputerDatabase(this.getDriver());
    }

    public ComputerDatabase cancel() {
        this.clickOnElementByXpath(XPATH_CANEL);
        return new ComputerDatabase(this.getDriver());
    }
}
