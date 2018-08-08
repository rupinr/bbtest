package com.computers;

import com.computers.model.Computer;
import com.computers.pages.AddOrEditComputer;
import com.computers.test.BaseTest;

public class ComputerHelper extends BaseTest {

    public void enterComputerDetails(Computer computer, AddOrEditComputer computerPage) {
        computerPage.editComputerName(computer.getComputerName())
                .editDiscontinuedDate(computer.getDiscontinued())
                .editIntroducedDate(computer.getIntroduced())
                .selectCompany(computer.getCompany());
    }

}


