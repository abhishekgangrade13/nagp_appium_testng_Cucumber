
@HomeApplyJob
Feature: WorkIndia Job home screen

  Background: launch application
    Given User launch the application
    Then user should be able to successfully launch the application

  Scenario Outline: Verify user able to see all the tabs of workIndia home screen
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
    And User scroll from up to down
    And User selected "experience" as "<Experience>"
    And user selected age as "<Age>"
    And User scroll from up to down
    And User selected "InterestedIn" as "<Interested>"
    And User click on submit button
    Then User should be navigated to last salary details screen
    When User selected last drawn salary as "<LastSalary>"
    And User click on submit button
    And User selected "Language for job profile home" as "<Language job prfoile>"
    Then User should be able to create profile and work india job search screen should be displayed
    When User search for job "<JobProfile>" and click on "1" result
    Then User should be navigated to Job profile "<JobProfile>" details screen and able to see contact to HR button

    Examples:
      | Name     | MobileNo   | City   | Area  | Gender | Qualification | Language | Fluency      | Experience | Interested           | Age      | LastSalary | Language job prfoile | JobProfile          |
      | Abhishek | 1234567869 | MUMBAI | Thane | Male   | 10th Pass     | English  | Good English | Experience | Business Development | 22 Years | 9000 Rs.   | ENGLISH              | Marketing Executive |


