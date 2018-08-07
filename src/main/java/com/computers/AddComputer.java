package com.computers;

import org.openqa.selenium.WebDriver;

public class AddComputer extends AddOrEditComputer {


    public AddComputer(WebDriver driver) {
        super(driver);
    }

    public ComputerDatabase succefullyCreateComputer() {
        return this.submit();
    }


}
