package com.computers.pages;

import com.computers.component.BaseActionEditor;
import org.openqa.selenium.WebDriver;

public class AddOrEditComputer  extends BasePage{
    private static final String ID_NAME = "name";
    private static final String ID_INTRODUCED = "introduced";
    private static final String ID_DISCONTINUED = "discontinued";
    private static final String ID_COMPANY = "company";
    private static final String XPATH_SUBMIT = "//*[@type='submit']";
    private static final String XPATH_CANEL = "//*[@class='actions']/a[@class='btn']";
    private BaseActionEditor editor;

    public AddOrEditComputer(WebDriver driver) {
        super(driver);
        this.editor=new BaseActionEditor(driver);
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
        this.editor.clickOnElementByXpath(XPATH_CANEL);
        return new ComputerDatabase(driver);
    }
}
