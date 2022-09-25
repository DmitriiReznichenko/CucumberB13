package com.test.openCart.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#input-username")
    WebElement userNameField;
    @FindBy(css = "#input-password")
    WebElement passwordField;
    public void login(){
        userNameField.sendKeys(ConfigReader.readProperty("openCartUsername"));
        passwordField.sendKeys(ConfigReader.readProperty("openCartPassword"), Keys.ENTER);
    }
}
