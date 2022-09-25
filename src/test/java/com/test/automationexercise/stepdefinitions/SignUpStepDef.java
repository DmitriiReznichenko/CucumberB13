package com.test.automationexercise.stepdefinitions;

import com.test.automationexercise.pages.HomePage;
import com.test.automationexercise.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class SignUpStepDef {
    WebDriver driver= DriverHelper.getDriver();
    HomePage homePage=new HomePage(driver);
    LoginPage loginPage=new LoginPage(driver);

    @Given("User navigates to the automationexercise web page")
    public void user_navigates_to_the_automationexercise_web_page() {
        driver.get(ConfigReader.readProperty("automationexerciseUrl"));

    }
    @Given("User validates the url of the page")
    public void user_validates_the_url_of_the_page() {
        Assert.assertEquals("https://www.automationexercise.com/",driver.getCurrentUrl());

    }
    @When("User clicks sighUpLogin button")
    public void user_clicks_sigh_up_login_button() {
        homePage.clickSignUpButton();

    }
    @Then("User verifies New User signUp is visible")
    public void user_verifies_new_user_sign_up_is_visible() {
        loginPage.validateHeader();
    }
    @Then("User  Enters name, email address and click signUp Button")
    public void user_enters_name_and_email_address_signup() {
    loginPage.enterNameAndEmail("Alisa","Alisa@gmail.com");
    }
}
