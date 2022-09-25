package com.test.weborder.pages;

import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;

public class GroupOrderPage {
    public GroupOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
@FindBy(id = "InviteNote")
    WebElement noteField;

    @FindBy(id = "InviteList")
    WebElement inviteListField;
    @FindBy(id = "ConfirmAddressID")
    WebElement locationDropDown;
    @FindBy(id = "addressPreview")
    WebElement adressOfDelivery;

    @FindBy(id = "createGroupOrder")
    WebElement createGroupeOrderButton;
    @FindBy(tagName = "h1")
    WebElement header;

    @FindBy(xpath = "//label[.='Total Participants:']//following-sibling::div")
    WebElement totalParticipants;

    public void sendNote(String text){
        noteField.sendKeys(text);
    }
    public void sendInviteList(String guest1, String guest2){
        inviteListField.sendKeys(guest1+", "+guest2);
    }
    public boolean chooseLocationForDelivery(String locationOfDelivery,String adress){
        BrowserUtils.selectBy(locationDropDown,locationOfDelivery,"text");
        return BrowserUtils.getText(adressOfDelivery).contains(adress);
    }
    public void clickCreateGroupOrderButton(){
        createGroupeOrderButton.click();

    }
    public String validateheader() throws InterruptedException {
       Thread.sleep(2000);
//        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//        header=wait.until(ExpectedConditions.visibilityOf(header));
        return  BrowserUtils.getText(header);
    }
    public Integer validateTotalParticipants(){
        return Integer.parseInt(BrowserUtils.getText(totalParticipants));
    }
}
