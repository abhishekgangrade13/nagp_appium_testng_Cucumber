@CreateAccount
  Feature: CreateAccountTest

    Background:
      Given User launch the application
      Then user should be able to successfully launch the application


#    Scenario Outline: User enter invalid details in login
#      Given User enter the "<Name>" in FullName field
#      And User enter the "<MobileNo>" in Mobile field
#      And User click on submit button
#      Then user should not login into application successfully
#
#      Examples:
#        | Name | MobileNo   |
#        |      | 1234567869 |
#        | Abhi | 12345      |
#
#    Scenario Outline: User able to login with correct details
#      Given User enter the "<Name>" in FullName field
#      And User enter the "<MobileNo>" in Mobile field
#      And User click on submit button
#      Then user should be able to login into application successfully
#      And screen should display all cities "<City>"
#
#      Examples:
#        | Name     | MobileNo   | City |
#        | Abhishek | 1234567869 |MUMBAI, PUNE, DELHI, BENGALURU |


#    Scenario Outline: Validate the elements on Profile information screen.
#      Given User enter the "<Name>" in FullName field
#      And User enter the "<MobileNo>" in Mobile field
#      And User click on submit button
#      Then user should be able to login into application successfully
#      When user select "<City>" city and "<Area>" area
#      And User click on submit button
#      Then User should be able to see fill profile details screen
#      And user see "<Gender>" under My Gender section
#      And user see "<Qualification>" under My Qualification section
#      And user see "<Language>" under My school medium section
#      And user see "<Fluency>" under How I Speak section
#      And user see "<Experience>" under Fresher_Experience section
#      When User scroll from up to down
#      Then user see "<Age>" under My Age section
#
#      Examples:
#        | Name     | MobileNo   | City   | Area  | Gender      | Qualification                                        | Language                    | Fluency                                              | Experience         |  |  |
#        | Abhishek | 1234567869 | MUMBAI | Thane | Male,Female | below 10th Pass,10th Pass,12th Pass & Above,Graduate | English,Hindi,Marathi,Other | No English,Thoda English,Good English,Fluent English | Fresher,Experience |  |  |

