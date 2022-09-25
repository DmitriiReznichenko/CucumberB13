#it is  user story
Feature: Sign up Functionality
  #test description. it means what are we going to test here
  Scenario: Creating and deleting user
    Given User navigates to the automationexercise web page
    And User validates the url of the page
    When User clicks sighUpLogin button
    Then User verifies New User signUp is visible
    And User  Enters name, email address and click signUp Button


