package com.nagp.pages;

import com.beust.ah.A;
import com.nagp.utils.AndroidUtils;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.nagp.utils.Constants.Title_InterestedIn;
import static com.nagp.utils.Constants.Title_WorkIndia;

public class HomeApplyJobPage {

    final static Logger log = Logger.getLogger(AccountInfoFillPage.class);

    AndroidUtils androidUtils = null;
    public AppiumDriver driver = null;

    public HomeApplyJobPage(AppiumDriver driver) {
        this.driver = driver;
        this.androidUtils = new AndroidUtils(driver);
        PageFactory.initElements(driver, this);
    }

    //Page Objects -----------------------------------------------------------
    private static final By txt_edtInputSearch = By.id("et_inputSearch");
    String txt_FirstSearchedJob = "(//android.widget.TextView[@text='{strTextName}'])[{strResultNo}]";
    private static final By ele_JobTitle = By.id("tv_job_title");
    private static final By btn_CalltoHR = By.id("btn_schedule_2");
    private static final By ele_InterviewAddressTitle = By.id("tv_head_job_interview_address");
    //-------------------------------------------------------------------------

    public void SearchForJobAndCLickonResult(String jobTitle, String resultNo){
        androidUtils.enterValueInTextBox(jobTitle,txt_edtInputSearch);
        driver.hideKeyboard();
        androidUtils.waitFor(7000);

        //click on result
        String strSearchResult = txt_FirstSearchedJob.replace("{strTextName}",jobTitle);
        strSearchResult = strSearchResult.replace("{strResultNo}",resultNo);
        By loc_FirstSearchResult = By.xpath(strSearchResult);
        androidUtils.objectClick(loc_FirstSearchResult);
        log.info("User search for the job "+jobTitle+" and clicked on result number "+resultNo);
    }

    public void VerifyJobProfileDetail(String jobTitle){
        boolean flag = false;
        androidUtils.waitUntilElementVisible(ele_JobTitle,10000);
        if (androidUtils.getElementText(ele_JobTitle).trim().equalsIgnoreCase(jobTitle)){
            flag = true;
        }
        androidUtils.scrollUptoDown(0.80,0.30,0.50,2000);
//        androidUtils.objectTap(ele_InterviewAddressTitle);
        Assert.assertTrue(androidUtils.objectExists(btn_CalltoHR) && flag, "User is not navigated to Job profile details screen and able to see contact to HR button.");
        log.info("User should be navigated to Job profile details screen and able to see contact to HR button.");
    }

}
