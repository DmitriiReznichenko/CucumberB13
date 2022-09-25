package com.test.weborder.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {
    public LoginPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "Email")
    WebElement username;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(xpath = "//button[.='Sign In']")
    WebElement signInButton;
    @FindBy (xpath = "//div[contains(text(),'Sign in Failed')]")
    WebElement failedMessage;

    public void login(String username,String password){
        this.username.clear();
        this.username.sendKeys(username);
       this.password.clear();
        this.password.sendKeys(password);
        signInButton.click();

    }
    public String  failedMessage(){
        return BrowserUtils.getText(failedMessage);
    }
}
