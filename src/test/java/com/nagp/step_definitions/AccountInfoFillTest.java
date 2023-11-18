package com.nagp.step_definitions;

import com.nagp.pages.AccountInfoFillPage;
import com.nagp.utils.AppiumDriverManager;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;


public class AccountInfoFillTest extends AppiumDriverManager {

    final static Logger log = Logger.getLogger(AccountInfoFillTest.class);
    AccountInfoFillPage accountInfoFillPage = new AccountInfoFillPage(driver);

    @Then("user see {string} under My Gender section")
    public void  fnVerifyGenderSection(String gender) {
        accountInfoFillPage.VerifyGenderSection(gender);
    }

    @Then("user see {string} under My Qualification section")
    public void  fnVerifyQualificationSection(String qualification) {
        accountInfoFillPage.VerifyQualificationSection(qualification);
    }

    @Then("user see {string} under My school medium section")
    public void  fnVerifylanguageSection(String language) {
        accountInfoFillPage.VerifylanguageSection(language);
    }

    @Then("user see {string} under How I Speak section")
    public void  fnVerifyFluencySection(String fluency) {
        accountInfoFillPage.VerifyFluencySection(fluency);
    }

    @Then("user see {string} under Fresher_Experience section")
    public void  fnVerifyExperienceSection(String experience) {
        accountInfoFillPage.VerifyExperienceSection(experience);
    }

    @When("User scroll from up to down")
    public void  fnScrollUptoDown() {
        accountInfoFillPage.ScrollUptoDown();
    }

    @Then("user see Age field under My Age section")
    public void  fnVerifyAgeSection() {
        accountInfoFillPage.VerifyAgeSection();
    }

    @Then("user see {string} under Interested_Exerienced section")
    public void  fnVerifyInterestedSection(String interested) {
        accountInfoFillPage.VerifyInterestedSection(interested);
    }

    @When("User selected {string} as {string}")
    public void  fnTabField(String fieldName, String fieldValue) {
        accountInfoFillPage.TabField(fieldName, fieldValue);
    }

    @When("user selected age as {string}")
    public void  fnSelectAgeField(String ageValue) {
        accountInfoFillPage.SelectAgeField(ageValue);
    }

    @Then("User should be navigated to last salary details screen")
    public void fnVerifySalaryDetailsScreen() {
        accountInfoFillPage.VerifySalaryDetailsScreen();
    }

    @When("User selected last drawn salary as {string}")
    public void  fnSelectLastDrawnSalary(String LastSalary) {
        accountInfoFillPage.SelectLastDrawnSalary(LastSalary);
    }

    @Then("User should be able to create profile and work india job search screen should be displayed")
    public void fnVerifyJobApplyHomeLocation() {
        accountInfoFillPage.VerifyJobApplyHomeLocation();
    }



@AfterStep

//    public AppiumDriver<MobileElement> driver;
//    @BeforeMethod(alwaysRun = true)
//    public void Initialize(){
//        driver = initializeDriver();
//    }
//
//    @Then("user see {string} under My Gender section")
//    public void  fnVerifyGenderSection(String gender) {
//        accountInfoFillPage.VerifyGenderSection(gender);
//    }
//
//    @AfterMethod(alwaysRun = true)
//    public void tearDown(){
//        this.driver.quit();
//    }

}
