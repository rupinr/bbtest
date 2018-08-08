package com.computers.pages;

import com.computers.component.BaseActionEditor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComputerDatabase extends BasePage {

    private static final String ID_SEARCH_BOX = "searchbox";
    private static final String ID_SEARCH_SUBMIT = "searchsubmit";
    private static final String ID_ADD = "add";
    private static final String XPATH_NEXT = "//*[@class='next']/a";
    private static final String XPATH_PREVIOUS = "//*[@class='prev']/a";
    private static final String XPATH_CURRENT = "//*[@class='current']/a";
    private static final String XPATH_ALERT = "//*[contains(@class,'alert-message')]";

    private BaseActionEditor editor;
    private DataGrid dataGrid;

    public ComputerDatabase(WebDriver driver) {
        super(driver);
        this.editor = new BaseActionEditor(driver);
        this.dataGrid = new DataGrid(driver);
    }


    public ComputerDatabase editFilterByName(String filter) {
        this.editor.editTextFieldById(ID_SEARCH_BOX, filter);
        return this;
    }

    public ComputerDatabase clickOnFilterByName() {
        this.editor.clickOnElementById(ID_SEARCH_SUBMIT);
        return this;
    }

    public AddComputer openAddComputerPage() {
        this.editor.clickOnElementById(ID_ADD);
        return new AddComputer(driver);
    }

    public ComputerDatabase clickOnNext() {
        this.editor.clickOnElementByXpath(XPATH_NEXT);
        return this;
    }

    public ComputerDatabase clickOnPrevious() {
        this.editor.clickOnElementByXpath(XPATH_PREVIOUS);
        return this;
    }

    public DataGrid getDataGrid() {
        return this.dataGrid;
    }

    public String getMessage() {
        return this.driver
                .findElement(By.xpath(XPATH_ALERT))
                .getText();
    }


}
