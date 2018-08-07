package com.computers;

import org.openqa.selenium.WebDriver;

public class EditComputer extends AddOrEditComputer {

    private static final String XPATH_DELETE = "";

    public EditComputer(WebDriver driver) {
        super(driver);
    }

    public ComputerDatabase succefullySaveComputer() {
        return this.submit();
    }


    public ComputerDatabase succefullyCreateComputer() {
        this.clickOnElementByXpath(XPATH_DELETE);
        return new ComputerDatabase(this.getDriver());
    }

}
