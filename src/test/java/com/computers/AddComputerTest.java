package com.computers;

import com.computers.data.Computers;
import com.computers.model.Computer;
import com.computers.pages.AddComputer;
import com.computers.pages.ComputerDatabase;
import com.computers.support.annotations.TestCase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.computers.data.ComputerDataValidity.*;

public class AddComputerTest extends ComputerHelper {

    @TestCase(testID = "SAMPLE00", testPriority = "HIGH", testDesciption = "NEW TESTCASE")
    @Test
    public void verifyAddAComputerPage() {

        ComputerDatabase computerDatabase = this.openBrowser()
                .loadComputerDataBaseHome();

        AddComputer addComputer = computerDatabase
                .openAddComputerPage();


        Assert.assertEquals(addComputer.getComputerNameLabel(), "Computer name");
        Assert.assertEquals(addComputer.getCompanyLabel(), "Introduced date");
        Assert.assertEquals(addComputer.getIntroducedLabel(), "Discontinued date");
        Assert.assertEquals(addComputer.getDiscontinuedLabel(), "Company");


        Assert.assertEquals(addComputer.getComputerNameHelpText(), "Required");
        Assert.assertEquals(addComputer.getIntroducedHelpText(), "Date ('yyyy-MM-dd')");
        Assert.assertEquals(addComputer.getDiscontinuedHelpText(), "Date ('yyyy-MM-dd')");

        Assert.assertTrue(addComputer.isCreateThisComputerDislpayed());
        Assert.assertTrue(addComputer.isCancelDisplayed());

        addComputer.cancel();

        Assert.assertTrue(computerDatabase.isInComputerDataPage());
    }

    @TestCase(testID = "SAMPLE00", testPriority = "HIGH", testDesciption = "NEW TESTCASE")
    @Test
    public void verifyThatUserIsAbleToAddAComputer() {
        ComputerDatabase computerDatabase = this.openBrowser()
                .loadComputerDataBaseHome();

        Computer computer = Computers.validDetails();

        AddComputer addComputer = computerDatabase.openAddComputerPage();
        this.enterComputerDetails(computer, addComputer);
        addComputer.submit();


        Assert.assertEquals(computerDatabase.getMessage(), "Check MEssage");


        Assert.assertTrue(computerDatabase.isInComputerDataPage());

    }

    @TestCase(testID = "SAMPLE00", testPriority = "HIGH", testDesciption = "NEW TESTCASE")
    @Test
    public void verifyThatUserIsAbleSearchAnAddedComputer() {
        ComputerDatabase computerDatabase = this.openBrowser()
                .loadComputerDataBaseHome();

        Computer computer = Computers.validDetails();
        AddComputer addComputer = computerDatabase.openAddComputerPage();
        this.enterComputerDetails(computer, addComputer);
        addComputer.submit();


        String computerName = computer.getComputerName();
        computerDatabase.editFilterByName(computerName).clickOnFilterByName();
        String actualComputerName = computerDatabase.getDataGrid().getByComputerNames().stream().findFirst().orElse("NO_MATCHING_COMPUTER");

        Assert.assertEquals(actualComputerName, computerName);

    }

    @TestCase(testID = "SAMPLE00", testPriority = "HIGH", testDesciption = "NEW TESTCASE")
    @Test(dataProvider = "invalidComputerArray")
    public void verifyThatErrorMessageIsShownWhenUserTriesToAddComputerWIthInvalidData(ComputerData computerData) {
        ComputerDatabase computerDatabase = this.openBrowser()
                .loadComputerDataBaseHome();

        AddComputer addComputer = computerDatabase.openAddComputerPage();
        this.enterComputerDetails(computerData.computer, addComputer);
        addComputer.submit();

        if (!computerData.isValidComputerName) {
            Assert.assertTrue(addComputer.isErrorHighlightPresentForName());
        }
        if (!computerData.isValidDiscontinued) {
            Assert.assertTrue(addComputer.isErrorHighlightPresentForDiscontinued());
        }
        if (!computerData.isValidIntroduced) {
            Assert.assertTrue(addComputer.isErrorHighlightPresentForIntroduced());
        }


    }


    @DataProvider
    public Object[][] invalidComputerArray() {

        return new Object[][]{{
                Computers.invalidDiscontinuedDate(), VALID_COMPUTERNAME, VALID_INTRODUCED, INVALID_DISCONTINUED},
                {Computers.invalidIntroducedDate(), VALID_COMPUTERNAME, INVALID_INTRODUCED, VALID_DISCONTINUED},
                {Computers.allInvalid(), INVALID_COMPUTERNAME, INVALID_INTRODUCED, INVALID_DISCONTINUED}};

    }

    private static class ComputerData {

        Computer computer;
        boolean isValidComputerName;
        boolean isValidIntroduced;
        boolean isValidDiscontinued;
    }

}
