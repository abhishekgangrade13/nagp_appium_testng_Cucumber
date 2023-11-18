package com.nagp.pages;


import com.nagp.utils.AndroidUtils;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BasePage{
    final static Logger log = Logger.getLogger(BasePage.class);

    AndroidUtils androidUtils;
    AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        androidUtils =new AndroidUtils(driver);
        PageFactory.initElements(driver, this);
    }

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
        if (currentOrientation.toString().trim().equalsIgnoreCase("LANDSCAPE")){
            driver.rotate(ScreenOrientation.PORTRAIT);
        }else if(currentOrientation.toString().trim().equalsIgnoreCase("PORTRAIT")){
            driver.rotate(ScreenOrientation.LANDSCAPE);
        }

        try{
            androidUtils.waitFor(3000);
        }catch (Exception e){
            log.error("Error message is "+ e.getMessage());
        }
    }

}
