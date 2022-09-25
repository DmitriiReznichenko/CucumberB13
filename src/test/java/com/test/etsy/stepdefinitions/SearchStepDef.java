package com.test.etsy.stepdefinitions;

import com.test.etsy.pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchStepDef {
    WebDriver driver= DriverHelper.getDriver();
    MainPage mainPage=new MainPage(driver);
    @When("User searches for {string}")
    public void user_searches_for(String search) {
    mainPage.search(search);

    }
    @Then("User validates the title is {string}")
    public void user_validates_the_title_is(String title) {
        Assert.assertEquals(title,driver.getTitle().trim());

    }
}
