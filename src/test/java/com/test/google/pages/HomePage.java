package com.test.google.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//input[@name='q']")
            WebElement searchBar;
    @FindBy(xpath = "//a//h3")
    List<WebElement> links;
    public void searchWord(String word){
        searchBar.sendKeys(word, Keys.ENTER);
    }
    public boolean validateNumberOfLinks(){
        if (links.size()<10){
            return true;
        }
        return false;
    }
}
