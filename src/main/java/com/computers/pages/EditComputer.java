package com.computers.pages;

import com.computers.component.BaseActionEditor;
import org.openqa.selenium.WebDriver;

public class EditComputer extends AddOrEditComputer {

    private static final String XPATH_DELETE = "//*[@type='submit' and contains(@class,'danger')]";
    private BaseActionEditor editor;

    public EditComputer(WebDriver driver) {
        super(driver);
        this.editor = new BaseActionEditor(driver);
    }

    public ComputerDatabase saveThisComputer() {
        return this.submit();
    }


    public ComputerDatabase deleteThisComputer() {
        this.editor.clickOnElementByXpath(XPATH_DELETE);
        return new ComputerDatabase(driver);
    }

}
