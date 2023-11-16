
@AccountInfoFill
Feature: FillAccountRelatedInfo

  Background: Fill the account profile information
    Given User launch the application
    Then user should be able to successfully launch the application

  Scenario Outline: Validate the elements on Profile information screen.
    Given User enter the "<Name>" in FullName field
    And User enter the "<MobileNo>" in Mobile field
    And User click on submit button
    Then user should be able to login into application successfully
    When user select "<City>" city and "<Area>" area
    And User click on submit button
    Then User should be able to see fill profile details screen
    And user see "<Gender>" under My Gender section

    Examples:
      | Name     | MobileNo   | City   | Area  | Gender      |  |
      | Abhishek | 1234567869 | MUMBAI | Thane | Male,Female |  |
