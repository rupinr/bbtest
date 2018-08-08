package com.computers.data;

import com.computers.model.Computer;

import java.util.UUID;

public class Computers {

    public static Computer validDetails() {
        return new Computer.ComputerBuilder()
                .withComputerName("TEST_COMPUTER" + UUID.randomUUID().toString().substring(0, 5))
                .withIntroduced("1998-10-10")
                .withDiscontinued("2010-10-10")
                .withCompany("IBM")
                .build();
    }

    public static Computer invalidIntroducedDate() {
        return new Computer.ComputerBuilder()
                .withComputerName("TEST_COMPUTER" + UUID.randomUUID().toString().substring(0, 5))
                .withIntroduced("1998-99-10")
                .withDiscontinued("2010-10-10")
                .withCompany("IBM")
                .build();
    }

    public static Computer invalidDiscontinuedDate() {
        return new Computer.ComputerBuilder()
                .withComputerName("TEST_COMPUTER" + UUID.randomUUID().toString().substring(0, 5))
                .withIntroduced("1998-10-10")
                .withDiscontinued("2010-99-99")
                .withCompany("IBM")
                .build();
    }

    public static Computer invalidComputerName() {
        return new Computer.ComputerBuilder()
                .withComputerName("")
                .withIntroduced("1998-10-10")
                .withDiscontinued("2010-10-05")
                .withCompany("IBM")
                .build();
    }

    public static Computer allInvalid() {
        return new Computer.ComputerBuilder()
                .withComputerName("")
                .withIntroduced("1999-99-99")
                .withDiscontinued("2010-99-99")
                .withCompany("IBM")
                .build();
    }

}
