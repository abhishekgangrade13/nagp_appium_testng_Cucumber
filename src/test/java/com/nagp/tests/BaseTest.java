// '##################################################################################################################################
// 'Script Name      : BaseTest
// 'Description      : BaseTest containing base information related to application
// 'Application      : in.workindia.nileshdungarwal.workindiaandroid
// 'Created On       : 12-11-2023
// 'Updated On       : NA
// 'Created By       : Abhishek Gangrade
// '###################################################################################################################################

package com.nagp.tests;

import com.nagp.utils.ConfigFileReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {

    public AppiumDriver<MobileElement> driver;

    //'===========================================================================================================
    //'Function Name       : setAppCapabilities
    //'Description         : Function to set App capabilities to initialize appium driver
    //'============================================================================================================
    public DesiredCapabilities setAppCapabilities(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("autoGrantPermissions", ConfigFileReader.getConfigPropertyVal("autoGrantPermissions"));
        caps.setCapability("deviceName", ConfigFileReader.getConfigPropertyVal("deviceName"));
        caps.setCapability("platformName", ConfigFileReader.getConfigPropertyVal("platformName"));
        caps.setCapability("platformVersion", ConfigFileReader.getConfigPropertyVal("platformVersion"));
        caps.setCapability("appPackage", ConfigFileReader.getConfigPropertyVal("appPackage"));
        caps.setCapability("appActivity", ConfigFileReader.getConfigPropertyVal("appActivity"));
        caps.setCapability("app", System.getProperty("user.dir")+"/"+ConfigFileReader.getConfigPropertyVal("app"));
//        caps.setCapability("orientation","LANDSCAPE");
        return caps;
    }

}
