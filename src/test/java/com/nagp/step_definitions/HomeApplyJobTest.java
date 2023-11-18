package com.nagp.step_definitions;

import com.nagp.pages.HomeApplyJobPage;
import com.nagp.utils.AppiumDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;


public class HomeApplyJobTest extends AppiumDriverManager {

    final static Logger log = Logger.getLogger(CreateAccountTest.class);
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
