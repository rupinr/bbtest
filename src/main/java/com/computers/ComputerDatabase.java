package com.computers;

import org.openqa.selenium.WebDriver;

public class ComputerDatabase extends BasePage {

    private static final String ID_SEARCH_BOX = "searchbox";
    private static final String ID_SEARCH_SUBMIT = "searchsubmit";
    private static final String ID_ADD = "add";

    public ComputerDatabase(WebDriver driver) {
        super(driver);
    }


    public ComputerDatabase editFilterByName(String filter) {
        this.editTextFieldById(ID_SEARCH_BOX, filter);
        return this;
    }

    public ComputerDatabase clickOnFilterByName() {
        this.clickOnElementById(ID_SEARCH_SUBMIT);
        return this;
    }

    public AddComputer openAddComputerPage() {
        this.clickOnElementById(ID_ADD);
        return new AddComputer(this.getDriver());
    }


}
