package com.nagp.pages;

import com.nagp.step_definitions.CreateAccountTest;
import com.nagp.tests.BaseTest;
import com.nagp.utils.AndroidUtils;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BasePage{
    final static Logger log = Logger.getLogger(BasePage.class);

//    AndroidUtils androidUtils;
    public AppiumDriver driver;
    public AndroidUtils androidUtils;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        androidUtils =new AndroidUtils(driver);
        PageFactory.initElements(driver, this);
    }

    //Create object of utils class

        //Page Objects-----------------------------------------------------
        private static final By btn_Permmission_Continue = By.id("com.android.permissioncontroller:id/continue_button");
        private static final By btn_OK = By.id("android:id/button1");
        private static final By txt_edtName = By.id("et_name");

    //------------------------------------------------------------------

    public void fnAcceptPermission(){
        androidUtils.objectClick(btn_Permmission_Continue);
        androidUtils.waitUntilElementVisible(btn_OK,5000);
        androidUtils.objectClick(btn_OK);
        androidUtils.waitUntilElementVisible(txt_edtName,10000);
        log.info("Permission and message popup accepted successfully.");
    }

    public void fnLaunchSuccess(){
        Assert.assertTrue(androidUtils.objectExists(txt_edtName),"Not able to launch the application");
        log.info("Application home screen displayed successfully.");
    }


    public void SwitchOrientation(){
        ScreenOrientation currentOrientation = driver.getOrientation();
        System.out.println("currentOrientation-"+currentOrientation);
        if (currentOrientation.toString().trim().equalsIgnoreCase("LANDSCAPE")){
            System.out.println("1");
            driver.rotate(ScreenOrientation.PORTRAIT);
        }else if(currentOrientation.toString().trim().equalsIgnoreCase("PORTRAIT")){
            System.out.println("2");
            driver.rotate(ScreenOrientation.LANDSCAPE);
        }

        try{
            androidUtils.waitFor(3000);
        }catch (Exception e){
            log.error("Error message is "+ e.getMessage());
        }
    }

    public void tearDown(){
        driver.quit();
        log.info("driver quit.");
    }

}
