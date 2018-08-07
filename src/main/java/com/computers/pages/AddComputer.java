package com.computers.pages;

import org.openqa.selenium.WebDriver;

public class AddComputer extends AddOrEditComputer {


    public AddComputer(WebDriver driver) {
        super(driver);
    }

    public ComputerDatabase createThisComputer() {
        return this.submit();
    }


}
