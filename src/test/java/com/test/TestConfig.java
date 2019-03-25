package com.test;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestConfig {

    private SpringApp springApp = new SpringApp();
    private DriverManager driverManager = new DriverManager();

    @org.junit.Before
    public void beforeClass() {

    }

    @Before
    public void before() {
        driverManager.getDriver();
        SpringApp.initSpring();
    }

    @After
    public void after() {
        driverManager.closeDriver();
    }
}
