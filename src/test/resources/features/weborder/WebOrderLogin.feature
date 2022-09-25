@smoke @regression
Feature: Login Functionality of Weborder page

#  Background: Navigation to the website
#    #Given User navigates to the 'https://demo.weborder.net/'
#
#  Scenario: Validation of Weborder Login Page(Correct Username Wrong password)
#   # Given User navigates to the 'https://demo.weborder.net/'
#    When User provides  username 'guest1@microworks.com' and password 'sdsdsx!'
#    Then User validates the message 'Sign in Failed' from login page
#
#  Scenario: Validation of Weborder Login Page(Wrong Username  correct password)
#    #Given User navigates to the 'https://demo.weborder.net/'
#    When User provides  username 'guest1@gmail.com' and password 'Guest1!'
#    Then User validates the message 'Sign in Failed' from login page
#  @smoke @ahmet
#  Scenario: Validation of Weborder Login Page(Emtpty Username  Emtpty password)
#    #Given User navigates to the 'https://demo.weborder.net/'
#    When User provides  username '' and password ''
#    Then User validates the message 'Sign in Failed' from login page
#  @smoke @ahmet @mehmet
#  Scenario: Validation of Weborder Login Page(Happy Path)
#   # Given User navigates to the 'https://demo.weborder.net/'
#    When User provides  username 'guest1@microworks.com' and password 'Guest1!'
#    Then User validates the title 'ORDER DETAILS - Weborder' from homepage
  Scenario Outline: Validation of Weborder Login Page with Scenario Outline
    When User provides  username '<username>' and password '<password>'
    Then User validates the message '<message>' from login page
    Examples:
      | username                    | password              | message        |
      | guest1@microworks.com       | sdsdsx                | Sign in Failed |
      | gsdfsdfst1@microworks.com   | Guest1!               | Sign in Failed |
      | guest1@microworks.com       |                       | Sign in Failed |
      | Guest1!@mail.ru                     | guest1@microworks.com | Sign in Failed |
      | GUEST1@MICROWORKS.COM       | GUEST1!               | Sign in Failed |
      | 12345678765433456@gmail.com | 123456654321          | Sign in Failed |
      | sdfghbvccfdg@gmail.com      | fghjhgfdfghfd         | Sign in Failed |


