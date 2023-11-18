@CreateAccountScreen
  Feature: WorkIndia app home screen validation

    Background: Launch Application
      Given User launch the application
      Then user should be able to successfully launch the application


    @Sanity @Regression
    Scenario Outline: User is not able to login with invalid details
      Given User enter the "<Name>" in FullName field
      And User enter the "<MobileNo>" in Mobile field
      And User click on submit button
      Then user should not login into application successfully

      Examples:
        | Name | MobileNo   |
        |      | 1234567869 |
        | Abhi | 12345      |

    @Sanity @Regression
    Scenario: User is able to login with valid details
      Given User enter the "Abhishek" in FullName field
      And User enter the "1234567869" in Mobile field
      And User click on submit button
      Then user should be able to login into application successfully
      And screen should display all cities "MUMBAI, PUNE, DELHI, BENGALURU"

#      Examples:
#        |Name | MobileNo | City |
#        |Abhishek|1234567869|MUMBAI, PUNE, DELHI, BENGALURU|


    @Regression
    Scenario Outline: User is not able to apply the invalid referral code on login
      Given User enter the "<Name>" in FullName field
      And User enter the "<MobileNo>" in Mobile field
      And User enter the "<ReferralCode>" in referral code field
      Then User should receive error message "Not a Valid Code" on screen
#      Given Change the orientation of screen

      Examples:
        | Name     | MobileNo   | ReferralCode |
        | Abhishek | 9876543210 | ABCDEF       |