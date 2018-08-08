package com.computers;

import com.computers.data.Computers;
import com.computers.model.Computer;
import com.computers.pages.AddComputer;
import com.computers.pages.ComputerDatabase;
import com.computers.pages.DataGrid;
import com.computers.pages.EditComputer;
import com.computers.support.annotations.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.computers.support.Priority.HIGH;

public class EditComputerTest extends ComputerHelper {

    @TestCase(id = "TC012", priority = HIGH, desciption = "Verify that user is able to edit a computer")
    @Test
    public void verifyThatUserIsAbleEditComputer() {

        ComputerDatabase computerDatabase = this.openBrowser()
                .loadComputerDataBaseHome();

        Computer computer = Computers.validComputer_1();
        AddComputer addComputer = computerDatabase.openAddComputerPage();
        this.enterComputerDetails(computer, addComputer);
        addComputer.submit();


        String computerName = computer.getComputerName();
        computerDatabase.editFilterByName(computerName).clickOnFilterByName();

        EditComputer editComputer = computerDatabase.getDataGrid().openEditComputerByName(computerName);

        Computer computer2 = Computers.validComputer_2();
        this.enterComputerDetails(computer2, editComputer);
        String message = editComputer.saveThisComputer().getMessage();

        Assert.assertEquals(message, "Done! Computer " + computer2.getComputerName() + " has been updated");

        DataGrid dataGrid = computerDatabase
                .editFilterByName(computer2.getComputerName())
                .clickOnFilterByName()
                .getDataGrid();

        Assert.assertEquals(dataGrid.getIntroducedByComputerName(computer2.getComputerName()), convertDateToGridForm(computer2.getIntroduced()));
        Assert.assertEquals(dataGrid.getDiscontinuedByComputerName(computer2.getComputerName()), convertDateToGridForm(computer2.getDiscontinued()));
        Assert.assertEquals(dataGrid.getByCompanyByComputerName(computer2.getComputerName()), computer2.getCompany());

    }
}
