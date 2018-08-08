package com.computers;

import com.computers.pages.ComputerDatabase;
import com.computers.pages.DataGrid;
import com.computers.support.annotations.TestCase;
import com.computers.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.computers.support.Priority.*;

public class ComputerDatabaseTest extends BaseTest {


    @Test
    @TestCase(id = "TC001",
            desciption = "Ensure that on searching for a valid computer user is presented with the matching result"
            , priority = HIGH)
    public void verifyThatUserIsPresentedWithSearchResultsForAValidQuery() {
        String computerName = "Atari ST";
        DataGrid dataGrid = this.openBrowser()
                .loadComputerDataBaseHome().editFilterByName(computerName)
                .clickOnFilterByName()
                .getDataGrid();
        Assert.assertEquals(dataGrid.getByCompanyByComputerName(computerName), "Atari");
        Assert.assertEquals(dataGrid.getDiscontinuedByComputerName(computerName), "01 Jan 1993");
        Assert.assertEquals(dataGrid.getIntroducedByComputerName(computerName), "01 Jan 1985");
    }

    @Test
    @TestCase(id = "TC002",
            desciption = "Ensure that on searching for a valid name that matches more than one computer , user is presented with the matching results",
            priority = HIGH)
    public void verifyThatUserIsPresentedWithMultipleSearchResultsIfThereAreMoreThanOneMatchingEntry() {
        String toSearchComputerName = "Atari";
        ComputerDatabase computerDatabase = this.openBrowser()
                .loadComputerDataBaseHome()
                .editFilterByName(toSearchComputerName)
                .clickOnFilterByName();

        DataGrid dataGrid = computerDatabase.getDataGrid();

        dataGrid.getByComputerNames()
                .forEach(computerName -> Assert.assertTrue(computerName.contains(computerName)));

        computerDatabase
                .clickOnNext()
                .getDataGrid()
                .getByComputerNames()
                .forEach(computerName -> Assert.assertTrue(computerName.contains(computerName)));
    }

    @Test
    @TestCase(id = "TC003", desciption = "Ensure that that search functionality is not considering the Case  of the search text",
            priority = MEDIUM)
    public void verifyThatFilterComputersAreNotCaseSensitive() {
        String upperCase = "ASC";
        String lowerCase = "asc";
        ComputerDatabase computerDatabase = this.openBrowser()
                .loadComputerDataBaseHome();

        List<String> upperCaseComputerNames =
                computerDatabase
                        .editFilterByName(upperCase)
                        .clickOnFilterByName()
                        .getDataGrid()
                        .getByComputerNames();

        List<String> lowerCaseComputerNames =
                computerDatabase
                        .editFilterByName(lowerCase)
                        .clickOnFilterByName()
                        .getDataGrid()
                        .getByComputerNames();

        Assert.assertEquals(upperCaseComputerNames, lowerCaseComputerNames);
    }

    @Test
    @TestCase(id = "TC004",
            desciption = "Ensure that that if search is not able to match any text, a proper error message is shown.",
            priority = MEDIUM)
    public void verifyThatAMessageIsShownOnInvalidSearch() {
        String searchText = "THIS#$@#$COMPUTER";
        String message = this.openBrowser()
                .loadComputerDataBaseHome()
                .editFilterByName(searchText)
                .clickOnFilterByName()
                .getDataGrid()
                .getEmptyMessage();

        Assert.assertEquals(message, "Nothing to display");

    }

    @Test
    @TestCase(id = "TC005",
            desciption = "Ensure that empty fields are shown as a '-' in the grid.",
            priority = LOW)
    public void verifyThatEmptyPropertiesAreDisplayedCorrectlyInGrid() {
        String computerName = "ASCI Thors Hammer";
        DataGrid dataGrid = this.openBrowser()
                .loadComputerDataBaseHome()
                .editFilterByName(computerName)
                .clickOnFilterByName()
                .getDataGrid();

        Assert.assertEquals(dataGrid.getByCompanyByComputerName(computerName), "-");
        Assert.assertEquals(dataGrid.getIntroducedByComputerName(computerName), "-");
        Assert.assertEquals(dataGrid.getDiscontinuedByComputerName(computerName), "-");
    }

    @Test
    @TestCase(id = "SAMPLE00",
            priority = HIGH,
            desciption = "Verify that the grid has columns for all computer properties")
    public void verifyHeaderTextForColumns() {
        DataGrid dataGrid = this.openBrowser()
                .loadComputerDataBaseHome()
                .getDataGrid();

        Assert.assertEquals(dataGrid.getComputerNameHeader(), "Computer name");
        Assert.assertEquals(dataGrid.getIntroducedHeader(), "Introduced");
        Assert.assertEquals(dataGrid.getDiscontinuedHeader(), "Discontinued");
        Assert.assertEquals(dataGrid.getCompanyHeader(), "Company");

    }


}
