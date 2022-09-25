package com.test.weborder.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='custom-control custom-checkbox']")
    WebElement groupOrderButton;

    @FindBy(id = "getAddressNextButton")
    WebElement nextButton;

    public void clickNextButton(){
        groupOrderButton.click();
        nextButton.click();

    }

}
