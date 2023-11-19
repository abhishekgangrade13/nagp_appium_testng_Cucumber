// '##################################################################################################################################
// 'Script Name      : HomeApplyJobPage
// 'Description      : Page file contains locator and method for job india home screen
// 'Application      : in.workindia.nileshdungarwal.workindiaandroid
// 'Created On       : 18-11-2023
// 'Updated On       : NA
// 'Created By       : Abhishek Gangrade
// '###################################################################################################################################

package com.nagp.pages;

import com.nagp.utils.AndroidUtils;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomeApplyJobPage {

    final static Logger log = Logger.getLogger(AccountInfoFillPage.class);

    AndroidUtils androidUtils;
    public AppiumDriver driver;

    //Constructor
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
    //-------------------------------------------------------------------------


    //'===========================================================================================================
    //'Function Name       : SearchForJobAndCLickonResult
    //'Description         : Function to search for job and click on first result
    //'============================================================================================================
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

    //'===========================================================================================================
    //'Function Name       : VerifyJobProfileDetail
    //'Description         : Function to verify job profile detail screen displayed
    //'============================================================================================================
    public void VerifyJobProfileDetail(String jobTitle){
        boolean flag = false;
        androidUtils.waitUntilElementVisible(ele_JobTitle,10000);
        if (androidUtils.getElementText(ele_JobTitle).trim().equalsIgnoreCase(jobTitle)){
            flag = true;
        }
        androidUtils.scrollUptoDown(0.80,0.30,0.50,2000);
        Assert.assertTrue(androidUtils.objectExists(btn_CalltoHR) && flag, "User is not navigated to Job profile details screen and able to see contact to HR button.");
        log.info("User should be navigated to Job profile details screen and able to see contact to HR button.");
    }

}
