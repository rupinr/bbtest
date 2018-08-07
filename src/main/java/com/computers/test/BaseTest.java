package com.computers.test;

import com.computers.pages.ComputerDatabase;
import com.computers.reporting.CustomTestReporter;
import com.computers.support.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;

@Listeners(CustomTestReporter.class)
public class BaseTest {

    protected TestProperties testProperties;
    private WebDriver driver;

    public BaseTest() {
        testProperties = TestProperties.getInstance();
        driver = createWebDriver();
    }

    public ComputerDatabase getComputerDataBaseHome() {
        this.driver.get(testProperties.getHomePageURL());
        return new ComputerDatabase(driver);
    }

    private WebDriver createWebDriver() {
        String browserName = testProperties.getBrowser();
        WebDriver driver = null;
        switch (browserName) {
            case "chrome":
                driver = createChromeDriver();
                break;
            case "firefox":
                driver = createFireFoxDriver();
                break;

        }
        return driver;
    }


    private WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", testProperties.getChromeDriverPath());
        return new ChromeDriver();
    }

    private WebDriver createFireFoxDriver() {
        System.setProperty("webdriver.gecko.driver", testProperties.getGekhoDriverPath());
        return new FirefoxDriver();
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
