package com.computers;

import com.computers.pages.ComputerDatabase;
import com.computers.pages.DataGrid;
import com.computers.support.annotations.TestCase;
import com.computers.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ComputerDatabaseTest extends BaseTest {


    @Test
    //TC Annotion..

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
    //TC Annotion..

    @TestCase(testID = "SAMPLE00", testPriority = "HIGH", testDesciption = "NEW TESTCASE")
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

    @TestCase(testID = "SAMPLE00", testPriority = "HIGH", testDesciption = "NEW TESTCASE")
    @Test
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

    @TestCase(testID = "SAMPLE00", testPriority = "HIGH", testDesciption = "NEW TESTCASE")
    @Test
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

    @TestCase(testID = "SAMPLE00", testPriority = "HIGH", testDesciption = "NEW TESTCASE")
    @Test
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

    @TestCase(testID = "SAMPLE00", testPriority = "HIGH", testDesciption = "NEW TESTCASE")
    @Test
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
