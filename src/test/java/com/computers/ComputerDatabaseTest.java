package com.computers;

import com.computers.pages.ComputerDatabase;
import com.computers.pages.DataGrid;
import com.computers.support.annotations.TestCase;
import com.computers.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComputerDatabaseTest extends BaseTest {


    @Test
    //TC Annotion..

    public void verifyThatUserIsPresentedWithSearchResultsForAValidQuery() {
        String computerName = "Atari ST";
        DataGrid dataGrid = this.getComputerDataBaseHome().editFilterByName(computerName)
                .clickOnFilterByName()
                .getDataGrid();
        Assert.assertEquals(dataGrid.getByCompanyByComputerName(computerName), "Atari");
        Assert.assertEquals(dataGrid.getDiscontinuedByComputerName(computerName), "01 Jan 1993");
        Assert.assertEquals(dataGrid.getIntroducedByComputerName(computerName), "01 Jan 1985");
    }

    @Test
    //TC Annotion..

    @TestCase(testID = "SAMPLE00" ,testPriority = "HIGH", testDesciption = "NEW TESTCASE")
    public void verifyThatUserIsPresentedWithMultipleSearchResultsIfThereAreMoreThanOneMatchingEntry() {
        String toSearchComputerName = "Atari";
        ComputerDatabase computerDatabase = this.getComputerDataBaseHome()
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
}