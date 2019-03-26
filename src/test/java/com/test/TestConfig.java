package com.test;

import com.test.spring.SpringApp;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestConfig {

    @Before
    public void before() {
        DriverManager.initDriver();
        SpringApp.initSpring();
    }

    @After
    public void after() {
        DriverManager.quitDriver();
    }
}
