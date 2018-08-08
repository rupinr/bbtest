package com.computers;

import com.computers.model.Computer;
import com.computers.pages.AddOrEditComputer;
import com.computers.test.BaseTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComputerHelper extends BaseTest {

    public void enterComputerDetails(Computer computer, AddOrEditComputer computerPage) {
        computerPage.editComputerName(computer.getComputerName())
                .editDiscontinuedDate(computer.getDiscontinued())
                .editIntroducedDate(computer.getIntroduced())
                .selectCompany(computer.getCompany());
    }

    public String convertDateToGridForm(String date){
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date _date=null;
        try {
             _date = formatter.parse(date);
        } catch ( ParseException e ) {
            e.printStackTrace();

        }
        SimpleDateFormat newFormat = new SimpleDateFormat("dd MMM yyyy");
        return newFormat.format(_date);
    }

}


