package com.computers;

import com.computers.model.Computer;
import com.computers.pages.AddOrEditComputer;
import com.computers.test.BaseTest;

public class ComputerHelper extends BaseTest {

    public void enterComputerDetails(Computer computer, AddOrEditComputer computerPage) {
        computerPage.editComputerName(computer.getComputerName())
                .editIntroducedDate(computer.getDiscontinued())
                .editIntroducedDate(computer.getDiscontinued())
                .editComputerName(computer.getCompany());
    }

}


