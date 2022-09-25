@regression
Feature: OpenCart creating and validating new Customer Functionality

  Scenario Outline: Sign Up Customer and validating the message
    Given User logins with valid userName and password closes banner
    And User clicks Customer Button in dropDown menu Customer
    And User clicks button create new customer
    When User provides all customer information '<firstName>','<lastName>','<email>','<password>'
    And User clicks  Button Save  and validates the  message 'Warning: You do not have permission to modify customers!'
    Then User clicks Buttons Addresses and Add Address
    And User provide new Address information'<firstName>','<lastName>','<address>','<city>','<country>','<regionState>'
    And User clicks  Button Save address and validates the  message 'Warning: You do not have permission to modify customers!'

    Examples:
      | firstName | lastName    | email                  | password | address            | city      | country       | regionState |
      | Dmitrii   | Reznichenko | Aptimist1990@gmail.com | cup      | West 15th street   | Brooklyn  | United States | New York    |
      | Zinaida   | Gipius      | Zina@gmail.com         | plate    | ave N              | Manhettan | United States | Alaska      |
      | Sharik    | Smith       | Smith@gmail.com        | spoon    | 2117 Bay Ridge ave | Brooklyn  | United States | Nebraska    |
      | Bahrom    | Djavadov    | hophop@gmail.com       | fork     | 2552 nepomnyu      | Ridgewood | United States | Florida     |
