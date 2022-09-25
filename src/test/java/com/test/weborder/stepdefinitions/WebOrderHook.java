package com.test.weborder.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class WebOrderHook {

//    WebDriver driver= DriverHelper.getDriver();
//    @Before
//    public void navigation(){
//        driver.get(ConfigReader.readProperty("weborderurl"));
//
//    }
//    @After
//    public void tearDown(Scenario scenario){
//        BrowserUtils.getScreenShotCucumber(scenario,driver);
//        driver.quit();
//    }
}
