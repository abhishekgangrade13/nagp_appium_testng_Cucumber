
@AccountInfoFill
Feature: FillAccountRelatedInfo

  Background: Fill the account profile information
    Given User launch the application
    Then user should be able to successfully launch the application

#  Scenario Outline: Validate the elements on Profile information screen.
#    Given User enter the "<Name>" in FullName field
#    And User enter the "<MobileNo>" in Mobile field
#    And User click on submit button
#    Then user should be able to login into application successfully
#    When user select "<City>" city and "<Area>" area
#    And User click on submit button
#    Then User should be able to see fill profile details screen
#    And user see "<Gender>" under My Gender section
#    And user see "<Qualification>" under My Qualification section
#    And user see "<Language>" under My school medium section
#    And user see "<Fluency>" under How I Speak section
#    And user see "<Experience>" under Fresher_Experience section
#    When User scroll from up to down
#    Then user see Age field under My Age section
#    When User scroll from up to down
#    Then user see "<Interested>" under Interested_Exerienced section
#
#    Examples:
#      | Name     | MobileNo   | City   | Area  | Gender      | Qualification                                        | Language                    | Fluency                                              | Experience         | Interested                                                                                                                                                                                                              |  |
#      | Abhishek | 1234567869 | MUMBAI | Thane | Male,Female | below 10th Pass,10th Pass,12th Pass & Above,Graduate | English,Hindi,Marathi,Other | No English,Thoda English,Good English,Fluent English | Fresher,Experience | Back Office,Office Boy/ Peon,Counter Sales,Accounts,Receptionist,Delivery,Telecalling,Field Sales,Business Development,Driver,Technician,Housekeeping,Beautician,DTP/Graphic Designer,Ward Boy/Nurse,Cook,Teacher,Other |  |


  Scenario Outline: Verify user able to fill the account information screen
    Given User enter the "<Name>" in FullName field
    And User enter the "<MobileNo>" in Mobile field
    And User click on submit button
    Then user should be able to login into application successfully
    When user select "<City>" city and "<Area>" area
    And User click on submit button
    Then User should be able to see fill profile details screen
    When User selected "gender" as "<Gender>"
    And User selected "qualification" as "<Qualification>"
    And User selected "language" as "<Language>"
    And User selected "fluency" as "<Fluency>"
    And User selected "experience" as "<Experience>"
    And User scroll from up to down
    And user selected age as "<Age>"
    And User scroll from up to down
    And User selected "InterestedIn" as "<Interested>"
    And User click on submit button
    Then User should be navigated to last salary details screen

    Examples:
      | Name     | MobileNo   | City   | Area  | Gender | Qualification | Language | Fluency      | Experience | Interested           | Age      |
      | Abhishek | 1234567869 | MUMBAI | Thane | Male   | 10th Pass     | English  | Good English | Experience | Business Development | 22 Years |
