package com.computers;

import com.computers.data.Computers;
import com.computers.model.Computer;
import com.computers.pages.AddComputer;
import com.computers.pages.ComputerDatabase;
import com.computers.support.annotations.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteComputerTest extends ComputerHelper {


    @TestCase(ID = "SAMPLE00", priority = "HIGH", desciption = "NEW TESTCASE")
    @Test
    public void verifyThatUserIsAbleDeleteComputer() {

        ComputerDatabase computerDatabase = this.openBrowser()
                .loadComputerDataBaseHome();

        Computer computer = Computers.validComputer_1();
        AddComputer addComputer = computerDatabase.openAddComputerPage();
        this.enterComputerDetails(computer, addComputer);
        addComputer.submit();


        String computerName = computer.getComputerName();
        computerDatabase.editFilterByName(computerName).clickOnFilterByName();

        String message = computerDatabase.getDataGrid().openEditComputerByName(computerName)
                .deleteThisComputer().getMessage();

        Assert.assertEquals(message, "Done! Computer has been deleted");

    }
}
