package com.test.amazon.stepDefinitions;

import com.test.amazon.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class AmazonStepDef {
    WebDriver driver= DriverHelper.getDriver();
    HomePage homePage=new HomePage(driver);
    @Given("User navigates to the Amazon")
    public void user_navigates_to_the_amazon() {
        driver.get(ConfigReader.readProperty("amazonUrl"));

    }
    @When("User searches for iphone thirteen case")
    public void user_searches_for_iphone_thirteen_case() {
        homePage.searchItem("iphone 13  case");

    }
    @Then("User validates the number is fifty thousands results")
    public void user_validates_the_number_is_fifty_thousands_results() {
        Assert.assertTrue(homePage.validateAmountOfResults());
    }
    @Then("User validates all headers contains iPhone")
    public void user_validates_all_headers_contains_i_phone() {
       homePage.validateAllHeaders("iphone");
    }
}
