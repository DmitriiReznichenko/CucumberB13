package com.test.openCart.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class CustomerPage {
    public CustomerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@aria-label='Add New']")
    WebElement addNewrButton;

    @FindBy(css = "#input-firstname")
    WebElement firstNameField;

    @FindBy(css = "#input-lastname")
    WebElement lastNameField;

    @FindBy(css = "#input-email")
    WebElement emailField;

    @FindBy(css = "#input-password")
    WebElement passwordField;

    @FindBy(css = "#input-confirm")
    WebElement confirmPasswordField;
    @FindBy(css = "#input-newsletter")
    WebElement newsLetterCheckBox;
    @FindBy(css = "#input-safe")
    WebElement safeCheckBox;
    @FindBy(css = "#input-status")
    WebElement statusCheckBox;
    @FindBy(xpath = "//button[@aria-label='Save']")
    WebElement saveButton;
    @FindBy(xpath = "//div[@id='alert']//div")
    WebElement alertMessage;

    @FindBy(linkText = "Addresses")
    WebElement addressesButton;

    @FindBy(css = "#button-address")
    WebElement addAddressButton;

    @FindBy(css = "#input-address-0-firstname")
    WebElement firstNameAddressField;

    @FindBy(css = "#input-address-0-lastname")
    WebElement lastNameAddressField ;

    @FindBy(css = "#input-address-0-address-1")
    WebElement addressField;

    @FindBy(css = "#input-address-0-city")
    WebElement cityField;

    @FindBy(css = "#input-address-0-country")
    WebElement countryField;

    @FindBy(css = "#input-address-0-zone")
    WebElement regionStateField;

    @FindBy(xpath = "//button[@data-bs-dismiss='alert']")
    WebElement closeAlertBanner;


    public void clickAddNewButton() {
        addNewrButton.click();
    }

    public void provideCustomerInformation(WebDriver driver, String firstName, String lastName, String email, String password) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
        if (!newsLetterCheckBox.isSelected()) {
            BrowserUtils.clickWithJS(driver, newsLetterCheckBox);
        }
        if (!statusCheckBox.isSelected()) {
            BrowserUtils.clickWithJS(driver, statusCheckBox);
        }
        if (!safeCheckBox.isSelected()) {
            BrowserUtils.clickWithJS(driver, safeCheckBox);
        }
    }
    public void validatingMessage(String message){
        saveButton.click();
        Assert.assertEquals(message,alertMessage.getText().trim());
    }
    public void addAddress(){
        addressesButton.click();
        addAddressButton.click();
    }
    public void provideNewAddressInformation(String firstName,String lastName,String address,String city,String country,String regionState) throws InterruptedException {
        firstNameAddressField.sendKeys(firstName);
        lastNameAddressField.sendKeys(lastName);
        addressField.sendKeys(address);
        cityField.sendKeys(city);
        Thread.sleep(300);
        BrowserUtils.selectBy(countryField,country,"text");
       // Thread.sleep(500);
        BrowserUtils.selectBy(regionStateField,regionState,"text");
      //  Thread.sleep(500);
        closeAlertBanner.click();
    }


}
