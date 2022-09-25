@regression
Feature: WebOrder page food Order Functionality


  Scenario: Testing the WebOrder functionality for House
  #  Given User navigates to the 'https://demo.weborder.net/'
    And User provides  username 'guest1@microworks.com' and password 'Guest1!'
    When  User validates the title 'ORDER DETAILS - Weborder' from homepage
    And User clicks Group Order Box and Next Button
    And User sends the word 'Test' for Note to Invitees section
    And User sends e-mail adresses which are 'ahmet@gmail.com' and 'mustafa@gmail.com' to Invite List
    And User chooses the delivery addresses 'My House' and validate the adress '3137 Laguna Street'
    And  User clicks create Group Order button
    Then User validates the header of page which is 'View Group Order'
    And User validates total participant is 1
    And User exits the website





