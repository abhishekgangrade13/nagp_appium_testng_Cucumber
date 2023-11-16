package com.nagp.pages;

import com.nagp.step_definitions.CreateAccountTest;
import com.nagp.tests.BaseClass;
import com.nagp.utils.AndroidUtils;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BasePage{
    final static Logger log = Logger.getLogger(CreateAccountTest.class);

    AndroidUtils androidUtils = null;
    public AppiumDriver driver = null;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Create object of utils class

        //Page Objects-----------------------------------------------------
        private static final By btn_Permmission_Continue = By.id("com.android.permissioncontroller:id/continue_button");
        private static final By btn_OK = By.id("android:id/button1");
        private static final By txt_edtName = By.id("et_name");

    //------------------------------------------------------------------

    public void fnAcceptPermission(){
        AndroidUtils androidUtils =new AndroidUtils(driver);
        androidUtils.objectClick(btn_Permmission_Continue);
        androidUtils.waitUntilElementVisible(btn_OK,5000);
        androidUtils.objectClick(btn_OK);
        androidUtils.waitFor(4000);
        log.info("Permission and message popup accepted successfully.");
    }

    public void fnLaunchSuccess(){
        AndroidUtils androidUtils =new AndroidUtils(driver);
        Assert.assertTrue(androidUtils.objectExists(txt_edtName),"Not able to launch the application");
        log.info("Application home screen displayed successfully.");
    }

    public void tearDown(){
        driver.quit();
        log.info("driver quit.");
    }

}
