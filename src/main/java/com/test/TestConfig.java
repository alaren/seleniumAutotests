package com.test;

import com.test.DriverManager;
import com.test.SpringApp;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

public class TestConfig {

    @Before
    public void before() {
        DriverManager.initDriver();
        SpringApp.initSpring();
    }

    @After
    public void after() {
        SpringApp.killSpring();
        DriverManager.quitDriver();
        System.out.println(DriverManager.getDriver());
    }
}
