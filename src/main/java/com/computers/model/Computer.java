package com.computers.model;

public class Computer {

    private String computerName;
    private String introduced;
    private String discontinued;
    private String company;

    public String getComputerName() {
        return computerName;
    }

    public String getIntroduced() {
        return introduced;
    }

    public String getDiscontinued() {
        return discontinued;
    }

    public String getCompany() {
        return company;
    }


    private Computer(ComputerBuilder builder) {
        this.computerName = builder.computerName;
        this.introduced = builder.introduced;
        this.discontinued = builder.discontinued;
        this.company = builder.company;
    }

    public static class ComputerBuilder {
        private String computerName;
        private String introduced;
        private String discontinued;
        private String company;


        public ComputerBuilder withComputerName(String computerName) {
            this.computerName = computerName;
            return this;
        }

        public ComputerBuilder withIntroduced(String introduced) {
            this.introduced = introduced;
            return this;
        }

        public ComputerBuilder withDiscontinued(String discontinued) {
            this.discontinued = discontinued;
            return this;
        }

        public ComputerBuilder withCompany(String company) {
            this.company = company;
            return this;
        }


        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return String.format("Computer Name %s, Introduced %s, Discontinued %s , Company %s",
                this.computerName,
                this.introduced,
                this.discontinued,
                this.company);
    }
}
