package com.computers.support;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {


    private Properties properties;
    private static TestProperties testProperties;

    public static TestProperties getInstance() {
        if (testProperties == null) {
            testProperties = new TestProperties();
        }
        return testProperties;
    }

    private TestProperties() {
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(new FileInputStream("testconfiguration.properties"));
            } catch ( IOException e ) {
                e.printStackTrace();
            }
        }
    }

    public String getHomePageURL() {
        return this.properties.getProperty("homePageURL");
    }

    public String getApiBaseURL() {
        return this.properties.getProperty("apiBaseURL");
    }

    public String getBrowser() {
        return this.properties.getProperty("browser");
    }

    public String getChromeDriverPath() {
        return this.properties.getProperty("chromeDriverPath");
    }

    public String getGekhoDriverPath() {
        return this.properties.getProperty("gekhoDriverPath");
    }

    public boolean getTakeScreenShot() {
        return Boolean.parseBoolean(this.properties.getProperty("takeScreenShot"));
    }

    public String getScreenshotDirectory() {
        return this.properties.getProperty("screenshotDirectory");
    }


}
