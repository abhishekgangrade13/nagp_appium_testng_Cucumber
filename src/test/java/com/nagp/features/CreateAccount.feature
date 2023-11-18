@CreateAccount
  Feature: CreateAccountTest

    Background: Launch Application
      Given User launch the application
      Then user should be able to successfully launch the application


    Scenario Outline: User enter invalid details in login
      Given User enter the "<Name>" in FullName field
      And User enter the "<MobileNo>" in Mobile field
      And User click on submit button
      Then user should not login into application successfully

      Examples:
        | Name | MobileNo   |
        |      | 1234567869 |
        | Abhi | 12345      |

    Scenario Outline: User able to login with correct details
      Given User enter the "<Name>" in FullName field
      And User enter the "<MobileNo>" in Mobile field
      And User click on submit button
      Then user should be able to login into application successfully
      And screen should display all cities "<City>"

      Examples:
        | Name     | MobileNo   | City                           |
        | Abhishek | 1234567869 | MUMBAI, PUNE, DELHI, BENGALURU |


    Scenario Outline: User try to apply for invalid referal code
      Given User enter the "<Name>" in FullName field
      And User enter the "<MobileNo>" in Mobile field
      And User enter the "<ReferalCode>" in referal code field
      Then User should receive error message "Not a Valid Code" on screen
#      Given Change the orientation of screen

      Examples:
        | Name     | MobileNo   | ReferalCode |
        | Abhishek | 9876543210 | ABCDEF      |