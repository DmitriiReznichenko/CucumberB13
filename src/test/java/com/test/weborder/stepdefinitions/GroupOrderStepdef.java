package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.GroupOrderPage;
import com.test.weborder.pages.OrderPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class GroupOrderStepdef {
    WebDriver driver= DriverHelper.getDriver();
    OrderPage orderPage=new OrderPage(driver);
    GroupOrderPage groupOrderPage=new GroupOrderPage(driver);
    @When("User clicks Group Order Box and Next Button")
    public void user_clicks_group_order_box_and_next_button() {
    orderPage.clickNextButton();
    }
    @When("User sends the word {string} for Note to Invitees section")
    public void user_sends_the_word_for_note_to_invitees_section(String word) {
    groupOrderPage.sendNote(word);
    }
    @When("User sends e-mail adresses which are {string} and {string} to Invite List")
    public void user_sends_e_mail_adresses_which_are_and_to_invite_list(String guest1, String guest2) {
        groupOrderPage.sendInviteList(guest1, guest2);

    }
    @When("User chooses the delivery addresses {string} and validate the adress {string}")
    public void user_chooses_the_delivery_addresses_and_validate_the_adress(String locationOfDelivery, String adress) {
        Assert.assertTrue(groupOrderPage.chooseLocationForDelivery(locationOfDelivery,adress));

    }
    @When("User clicks create Group Order button")
    public void user_clicks_create_group_order_button() {
    groupOrderPage.clickCreateGroupOrderButton();
    }
    @Then("User validates the header of page which is {string}")
    public void user_validates_the_header_of_page_which_is(String exceptedHeader) throws InterruptedException {
        Assert.assertEquals(exceptedHeader,groupOrderPage.validateheader());

    }
    @Then("User validates total participant is {int}")
    public void user_validates_total_participant_is(Integer totalParticipants) {
        Assert.assertEquals(totalParticipants,groupOrderPage.validateTotalParticipants());

    }
}
