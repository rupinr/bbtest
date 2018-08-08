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

    @TestCase(ID = "SAMPLE00", priority = "HIGH", desciption = "NEW TESTCASE")
    @Test
    public void verifyAddAComputerPage() {

        ComputerDatabase computerDatabase = this.openBrowser()
                .loadComputerDataBaseHome();

        AddComputer addComputer = computerDatabase
                .openAddComputerPage();


        Assert.assertEquals(addComputer.getComputerNameLabel(), "Computer name");
        Assert.assertEquals(addComputer.getCompanyLabel(), "Company");
        Assert.assertEquals(addComputer.getIntroducedLabel(), "Introduced date");
        Assert.assertEquals(addComputer.getDiscontinuedLabel(), "Discontinued date");


        Assert.assertEquals(addComputer.getComputerNameHelpText(), "Required");
        Assert.assertEquals(addComputer.getIntroducedHelpText(), "Date ('yyyy-MM-dd')");
        Assert.assertEquals(addComputer.getDiscontinuedHelpText(), "Date ('yyyy-MM-dd')");

        Assert.assertTrue(addComputer.isCreateThisComputerDislpayed());
        Assert.assertTrue(addComputer.isCancelDisplayed());

        addComputer.cancel();

        Assert.assertTrue(computerDatabase.isInComputerDataPage());
    }

    @TestCase(ID = "SAMPLE00", priority = "HIGH", desciption = "NEW TESTCASE")
    @Test
    public void verifyThatUserIsAbleToAddAComputer() {
        ComputerDatabase computerDatabase = this.openBrowser()
                .loadComputerDataBaseHome();

        Computer computer = Computers.validComputer_1();

        AddComputer addComputer = computerDatabase.openAddComputerPage();
        this.enterComputerDetails(computer, addComputer);
        addComputer.submit();


        Assert.assertEquals(computerDatabase.getMessage(), "Done! Computer "+computer.getComputerName()+" has been created");


        Assert.assertTrue(computerDatabase.isInComputerDataPage());

    }

    @TestCase(ID = "SAMPLE00", priority = "HIGH", desciption = "NEW TESTCASE")
    @Test
    public void verifyThatUserIsAbleSearchAnAddedComputer() {
        ComputerDatabase computerDatabase = this.openBrowser()
                .loadComputerDataBaseHome();

        Computer computer = Computers.validComputer_1();
        AddComputer addComputer = computerDatabase.openAddComputerPage();
        this.enterComputerDetails(computer, addComputer);
        addComputer.submit();


        String computerName = computer.getComputerName();
        computerDatabase.editFilterByName(computerName).clickOnFilterByName();
        String actualComputerName = computerDatabase.getDataGrid().getByComputerNames().stream().findFirst().orElse("NO_MATCHING_COMPUTER");

        Assert.assertEquals(actualComputerName, computerName);

    }

    @TestCase(ID = "SAMPLE00", priority = "HIGH", desciption = "NEW TESTCASE")
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
                new ComputerData(Computers.invalidDiscontinuedDate(), VALID_COMPUTERNAME, VALID_INTRODUCED, INVALID_DISCONTINUED)},
                {new ComputerData(Computers.invalidIntroducedDate(), VALID_COMPUTERNAME, INVALID_INTRODUCED, VALID_DISCONTINUED)},
                {new ComputerData(Computers.allInvalid(), INVALID_COMPUTERNAME, INVALID_INTRODUCED, INVALID_DISCONTINUED)}
                , {new ComputerData(Computers.invalidComputerName(), INVALID_COMPUTERNAME, VALID_INTRODUCED, VALID_DISCONTINUED)}};

    }

    private static class ComputerData {

        Computer computer;
        boolean isValidComputerName;
        boolean isValidIntroduced;
        boolean isValidDiscontinued;

        private ComputerData(Computer computer, boolean isValidComputerName, boolean isValidIntroduced, boolean isValidDiscontinued) {
            this.computer = computer;
            this.isValidComputerName = isValidComputerName;
            this.isValidIntroduced = isValidIntroduced;
            this.isValidDiscontinued = isValidDiscontinued;
        }
    }

}
