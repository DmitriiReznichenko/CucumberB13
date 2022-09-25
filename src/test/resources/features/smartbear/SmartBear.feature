@regression
Feature: SmartBear  functionality
#@regularScenario
#  Scenario: User login to smart bear website
#    When User login with valid password and username
#    Then User validates title 'Web Orders' and clicks order button
#    When User provides product information 'MyMoney','3'
#    And User provides address information 'Kseniia','4415 N Drake Ave','Chicago','60625'
#    And User provides payment information 'American Express','1234567','04/25'
#    Then User clicks the Process Button and Validates the message 'New order has been successfully added.'
#  @OutlineScenario
#  Scenario Outline: User login to smart bear website
#    When User login with valid password and username
#    Then User validates title 'Web Orders' and clicks order button
#    When User provides product information '<ProductName>','<Quantity>'
#    And User provides address information '<Name>','<Street>','<City>','<ZipCode>'
#    And User provides payment information '<CardType>','<CardNumber>','<ExpirationDate>'
#    Then User clicks the Process Button and Validates the message 'New order has been successfully added.'
#    Examples:
#      | ProductName | Quantity | Name    | Street       | ZipCode | CardType         | City          | CardNumber    | ExpirationDate |
#      | FamilyAlbum | 1        | John    | West 15      | 11204   | American Express | Brooklyn      | 12345654321   | 01/23          |
#      | ScreenSaver | 2        | Barbara | Lexington    | 11214   | Visa             | Bronx         | 098767890     | 04/18          |
#      | MyMoney     | 3        | Paul    | Court street | 1235    | MasterCard       | Staten Island | 123454345678  | 09/99          |
#      | MyMoney     | 4        | Monica  | West steet   | 1385    | American Express | Queens        | 9864535656777 | 05/08          |


  Scenario: User login to smart bear website
    When User login with valid password and username
    Then User validates title  and clicks order button
      | Title | Web Orders |
    When User provides product information
      | ProductName | MyMoney |
      | Quantity    | 4       |
    And User provides address information
      | CustomerName | Ahmet          |
      | Street       | Midway         |
      | City         | Mount Prospect |
      | Zipcode      | 324232         |
    And User provides payment information
      | CardType       | Visa           |
      | CardNumber     | 82364823428974 |
      | ExpirationDate | 09/99          |

    Then User clicks the Process Button and Validates the message
    |New order has been successfully added.|





