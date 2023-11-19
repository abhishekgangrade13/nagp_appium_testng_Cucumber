// '##################################################################################################################################
// 'Script Name      : HomeApplyJobTest
// 'Description      : Test file containing step definitions for inWorkIndia home details screen
// 'Application      : in.workindia.nileshdungarwal.workindiaandroid
// 'Created On       : 18-11-2023
// 'Updated On       : NA
// 'Created By       : Abhishek Gangrade
// '###################################################################################################################################

package com.nagp.step_definitions;

import com.nagp.pages.HomeApplyJobPage;
import com.nagp.utils.AppiumDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HomeApplyJobTest extends AppiumDriverManager {
    HomeApplyJobPage homeApplyJobPage = new HomeApplyJobPage(driver);
    @When("User search for job {string} and click on {string} result")
    public void  fnSearchForJobAndCLickonResult(String JobFilter, String resultNo) {
        homeApplyJobPage.SearchForJobAndCLickonResult(JobFilter, resultNo);
    }

    @Then("User should be navigated to Job profile {string} details screen and able to see contact to HR button")
    public void fnVerifyJobProfileDetail(String jobTitle) {
        homeApplyJobPage.VerifyJobProfileDetail(jobTitle);
    }

}
