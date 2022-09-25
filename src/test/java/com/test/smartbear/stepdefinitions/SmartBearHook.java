package com.test.smartbear.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class SmartBearHook {
        WebDriver driver= DriverHelper.getDriver();

    @Before
    public void navigation(){
        driver.get(ConfigReader.readProperty("smartbearurl"));
    }
    @After
    public void tearDown(Scenario scenario){
        BrowserUtils.getScreenShotCucumber(scenario,driver);
       driver.quit();
    }
}
