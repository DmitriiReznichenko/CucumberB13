package com.test.amazon.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.security.Key;
import java.util.List;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
@FindBy(id = "twotabsearchtextbox")
    WebElement searchField;

    @FindBy (xpath = "//span[contains(text(),'1-16')]")
    WebElement amountOfResults;
    @FindBy (tagName = "//h2")
    List<WebElement> allHeaders;

    public void searchItem(String item){
        searchField.sendKeys(item, Keys.ENTER);
    }
    public boolean validateAmountOfResults(){
        if (amountOfResults.getText().replace(",","").contains("50000")){
            return true;
        }
        return false;
    }
    public void validateAllHeaders(String validateWord){
        for (WebElement header:allHeaders) {
            if (!BrowserUtils.getText(header).equals("")){
                Assert.assertTrue(BrowserUtils.getText(header).toLowerCase().contains(validateWord));
            }
        }

    }
}
