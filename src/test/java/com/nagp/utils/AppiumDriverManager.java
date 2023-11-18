package com.nagp.utils;

import com.nagp.tests.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class AppiumDriverManager {
    final static Logger log = LogManager.getLogger(AppiumDriverManager.class);
    public static AppiumDriver<MobileElement> driver;
    URL appiumURL = null;

    //Initialize driver
    public void initializeDriver() {
        if (driver == null) {
            try {
                appiumURL = new URL("http://" + ConfigFileReader.getConfigPropertyVal("AppiumServer") + ":" + ConfigFileReader.getConfigPropertyVal("AppiumPort") + "/wd/hub");
                driver = new AppiumDriver<MobileElement>(appiumURL, new BaseTest().setAppCapabilities());
                log.info("Driver initialized.");
                driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigFileReader.getConfigPropertyVal("globalWait")), TimeUnit.MILLISECONDS);
            } catch (MalformedURLException e) {
                log.info("Error message:" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void tearDownDriver() {
        //Tearing Driver
        driver.removeApp(ConfigFileReader.getConfigPropertyVal("appPackage"));
        driver.quit();
        log.info("Remove app and Tear Down Appium driver.");
    }

    @AfterMethod
    public void teardown(Scenario sc) {
        System.out.println("Tear Down method executed..");
        if (sc.isFailed() == true) {
//Convert web driver object to TakeScreenshot
            String fileWithPath = "C:\\Users\\prach\\Desktop\\CodeStudio";
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
//Call getScreenshotAs method to create image file
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
            File DestFile = new File(fileWithPath);
//Copy file at destination
            try {
                FileUtils.copyFile(SrcFile, DestFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }

    @AfterStep
    public void addScreenshot (Scenario scenario) {
        if(scenario.isFailed())
        {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//attach image file report(data, media type, name of the attachment)
            scenario.attach(screenshot, "image/png", scenario.getName());
        } I
/*@After
public void teardown2()
{
System.out.println("Tear Down method executed..");
driver.quit();
}*/


}
