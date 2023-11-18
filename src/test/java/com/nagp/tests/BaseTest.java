package com.nagp.tests;

import com.nagp.utils.ConfigFileReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class BaseTest {

    final static Logger log = LogManager.getLogger(BaseTest.class);

    public AppiumDriver<MobileElement> driver;

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
