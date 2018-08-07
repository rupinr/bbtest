package com.computers;

import org.openqa.selenium.WebDriver;
import static com.computers.Replacements.*;

public class DataGrid extends BasePage {

    private static final String XPATH_COMPUTER_BY_NAME="//*[contains(@class,'computers')]//a[contains(text(),'{I}')]";
    private static final String XPATH_GENERIC_CELL_BY_COMPUTER_NAME="//*[contains(@class,'computers')]//tr[contains(@text(),'{I}')]";


    public DataGrid(WebDriver driver) {
        super(driver);
    }

    public EditComputer clickOnEditByComputerName(String computerName){
        clickOnElementByXpath(XPATH_COMPUTER_BY_NAME.replace(I,computerName));
        return new EditComputer(this.getDriver());
    }
}
