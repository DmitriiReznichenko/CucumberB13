package com.test.openCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h5//following-sibling::button")
    WebElement closeButton;

    @FindBy(xpath = "//a[@href=\"#collapse-5\"]")
    WebElement customerMenuButton;

    @FindBy(xpath = "//a[@href=\"#collapse-5\"]/following-sibling::ul//a")
    WebElement customerButton;


    public void closeBaner(){
        closeButton.click();
    }
    public void clicksCustomerButtons(){
        customerMenuButton.click();
        customerButton.click();
    }
}
