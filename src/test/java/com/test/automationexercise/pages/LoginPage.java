package com.test.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    @FindBy (xpath = "//h2[.='New User Signup!']")
    WebElement header;

    @FindBy(name = "name")
    WebElement nameField;
    @FindBy (xpath = "//input[@data-qa='signup-email']")
    WebElement emailField;

    @FindBy (xpath = "//button[.='Signup']")
    WebElement signUpButton;

    public boolean validateHeader(){
        return  header.isDisplayed();
    }
    public void enterNameAndEmail(String name,String email){
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        signUpButton.click();
    }

}
