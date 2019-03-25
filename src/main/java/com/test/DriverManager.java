package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private WebDriver driver;

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            Util.driver = driver;
        }
        return driver;
    }

    public void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}
