package com.computers;

import com.computers.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample extends BaseTest {


    @Test
    public void verifyHomePage() {
        Assert.assertEquals(this.getComputerDataBaseHome().getDataGrid()
                .isCompanyMatching("AN/FSQ-32", "IBM"), true);


    }
}
