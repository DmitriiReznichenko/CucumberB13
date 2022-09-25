package com.test.smartbear.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ctl00_MainContent_username")
    WebElement userNameField;

    @FindBy(id = "ctl00_MainContent_password")
    WebElement passwordField;

    public void login(String userName, String password) {
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password, Keys.ENTER);


    }

}
