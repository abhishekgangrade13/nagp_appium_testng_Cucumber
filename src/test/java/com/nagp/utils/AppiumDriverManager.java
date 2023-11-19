// '##################################################################################################################################
// 'Script Name      : AppiumDriverManager
// 'Description      : Appium driver manager file to initialize and tear down driver
// 'Application      : in.workindia.nileshdungarwal.workindiaandroid
// 'Created On       : 15-11-2023
// 'Updated On       : NA
// 'Created By       : Abhishek Gangrade
// '###################################################################################################################################

package com.nagp.utils;

import com.nagp.tests.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverManager {
    final static Logger log = LogManager.getLogger(AppiumDriverManager.class);
    public static AppiumDriver<MobileElement> driver;
    URL appiumURL = null;

    //Initialize driver
    public void initializeDriver(){
        if (driver == null) {
            try {
                appiumURL = new URL("http://" + ConfigFileReader.getConfigPropertyVal("AppiumServer") + ":" + ConfigFileReader.getConfigPropertyVal("AppiumPort") + "/wd/hub");
                driver = new AppiumDriver<MobileElement>(appiumURL, new BaseTest().setAppCapabilities());
                log.info("Driver initialized.");
                driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigFileReader.getConfigPropertyVal("globalWait")), TimeUnit.MILLISECONDS);
            } catch (MalformedURLException e) {
                log.info("Error message in driver initialization :" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    //tear down driver
    public void tearDownDriver(){
        //Tearing Driver
        driver.removeApp(ConfigFileReader.getConfigPropertyVal("appPackage"));
        driver.quit();
        log.info("Remove app and Tear Down Appium driver.");
    }

}
