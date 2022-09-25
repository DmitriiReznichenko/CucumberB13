package com.test.smartbear.stepdefinitions;

import com.test.smartbear.pages.LoginPage;
import com.test.smartbear.pages.MainPage;
import com.test.smartbear.pages.OrderPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class SmartBearStepDef {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);
    OrderPage orderPage = new OrderPage(driver);

    @When("User login with valid password and username")
    public void user_login_with_valid_password_and_username() {
        loginPage.login(ConfigReader.readProperty("smartbearUsername"), ConfigReader.readProperty("smartbearPassword"));
    }

    @Then("User validates title {string} and clicks order button")
    public void user_validates_title_and_clicks_order_button(String title) {
        Assert.assertEquals(title, driver.getTitle().trim());
        mainPage.clickOrderButton();
    }

    @When("User provides product information {string},{string}")
    public void user_provides_product_information(String product, String quantity) {
        orderPage.provideProductInformation(product, quantity);
    }

    @When("User provides address information {string},{string},{string},{string}")
    public void user_provides_address_information(String customerName, String street, String city, String zip) {
        orderPage.provideAddressInformation(customerName, street, city, zip);
    }

    @When("User provides payment information {string},{string},{string}")
    public void user_provides_payment_information(String cardType, String cardNr, String expireDate) {
        orderPage.providePaymentInformation(cardType, cardNr, expireDate);
    }

    @Then("User clicks the Process Button and Validates the message {string}")
    public void user_clicks_the_process_button_and_validates_the_message(String message) {
        Assert.assertEquals(message, orderPage.validationMessage());
    }

    @Then("User validates title  and clicks order button")
    public void user_validates_title_and_clicks_order_button(DataTable dataTable) {
        Map<String, String> title = dataTable.asMap();
        Assert.assertEquals(title.get("Title"), driver.getTitle().trim());
        mainPage.clickOrderButton();
    }

    @When("User provides product information")
    public void user_provides_product_information(DataTable dataTable) {
        Map<String, String> productInformation = dataTable.asMap();
        orderPage.provideProductInformation(productInformation.get("ProductName"),
                                            productInformation.get("Quantity"));

    }

    @When("User provides address information")
    public void user_provides_address_information(DataTable dataTable) {
        Map<String, String> addressInformation = dataTable.asMap();
        orderPage.provideAddressInformation(addressInformation.get("CustomerName"),
                                            addressInformation.get("Street"),
                                            addressInformation.get("City"),
                                            addressInformation.get("Zipcode"));
    }
    @When("User provides payment information")
    public void user_provides_payment_information(DataTable dataTable) {
        Map<String ,String> paymentInformation=dataTable.asMap();
        orderPage.providePaymentInformation(paymentInformation.get("CardType"),
                                            paymentInformation.get("CardNumber"),
                                            paymentInformation.get("ExpirationDate"));
    }

    @Then("User clicks the Process Button and Validates the message")
    public void user_clicks_the_process_button_and_validates_the_message(DataTable dataTable) {
        List<String> message=dataTable.asList();
        Assert.assertEquals(message.get(0), orderPage.validationMessage());

    }

}
