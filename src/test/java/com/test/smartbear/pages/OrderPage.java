package com.test.smartbear.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class OrderPage {
    public OrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "ctl00$MainContent$fmwOrder$ddlProduct")
    WebElement productField;

    @FindBy(name = "ctl00$MainContent$fmwOrder$txtQuantity")
    WebElement quantityField;

    @FindBy(name = "ctl00$MainContent$fmwOrder$txtName")
    WebElement customerNameField;

    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox2")
    WebElement streetField;

    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox3")
    WebElement cityField;

    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox5")
    WebElement zipField;

    @FindBy(xpath = "//input[@value=\"Visa\"]")
    WebElement cardVisa;

    @FindBy(xpath = "//input[@value=\"MasterCard\"]")
    WebElement cardMasterCard;

    @FindBy(xpath = "//input[@value=\"American Express\"]")
    WebElement cardAmericanExpress;

    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox6")
    WebElement cardNRField;

    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox1")
    WebElement expireDateField;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    WebElement processButton;

    @FindBy(tagName = "strong")
    WebElement message;

    public void provideProductInformation(String product, String quantity) {
        BrowserUtils.selectBy(productField, product, "text");
        quantityField.clear();
        quantityField.sendKeys(quantity);
    }

    public void provideAddressInformation(String customerName, String street, String city, String zip) {
        customerNameField.sendKeys(customerName);
        streetField.sendKeys(street);
        cityField.sendKeys(city);
        zipField.sendKeys(zip);
    }

    public void providePaymentInformation(String cardType, String cardNr, String expireDate) {
        cardNRField.sendKeys(cardNr);
        expireDateField.sendKeys(expireDate);
        cardType = cardType.toUpperCase();
        switch (cardType) {
            case "VISA":
                cardVisa.click();
                break;
            case "MASTERCARD":
                cardMasterCard.click();
                break;
            case "AMERICAN EXPRESS":
                cardAmericanExpress.click();
                break;
            default:
                System.out.println("Card name is not found.Please provide valid card type");
        }
    }

    public String validationMessage() {
        processButton.click();
        return message.getText().trim();
    }
}
