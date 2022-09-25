package com.test.openCart.stepDefiniitions;

import com.test.openCart.pages.CustomerPage;
import com.test.openCart.pages.HomePage;
import com.test.openCart.pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class AddCustomerAndAddressStepDef {
    WebDriver driver= DriverHelper.getDriver();

    LoginPage loginPage=new LoginPage(driver);

    HomePage homePage=new HomePage(driver);

    CustomerPage customerPage=new CustomerPage(driver);
    @Given("User logins with valid userName and password closes banner")
public void user_logins_with_valid_user_name_and_password_closes_banner() {
        loginPage.login();
        homePage.closeBaner();
}
    @Given("User clicks Customer Button in dropDown menu Customer")
    public void user_clicks_customer_button_in_drop_down_menu_customer() {
        homePage.clicksCustomerButtons();
    }

    @Given("User clicks button create new customer")
    public void user_clicks_button_create_new_customer() {
        customerPage.clickAddNewButton();

    }
    @When("User provides all customer information {string},{string},{string},{string}")
    public void user_provides_all_customer_information(String firstName, String lastName, String email, String password) {
        customerPage.provideCustomerInformation(driver,firstName,lastName,email,password);


    }
    @When("User clicks  Button Save  and validates the  message {string}")
    public void user_clicks_button_save_and_validates_the_message(String message) {
        customerPage.validatingMessage(message);

    }
    @Then("User clicks Buttons Addresses and Add Address")
    public void user_clicks_buttons_addresses_and_add_address() {
        customerPage.addAddress();

    }
    @Then("User provide new Address information{string},{string},{string},{string},{string},{string}")
    public void user_provide_new_address_information(String firstName, String lastName,String address,String city,String country,String regionState) throws InterruptedException {
        customerPage.provideNewAddressInformation(firstName,lastName,address,city,country,regionState);

    }
    @Then("User clicks  Button Save address and validates the  message {string}")
    public void user_clicks_button_save_address_and_validates_the_message(String message) {
        customerPage.validatingMessage(message);

    }

}
