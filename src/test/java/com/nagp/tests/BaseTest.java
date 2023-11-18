package com.nagp.tests;

import com.nagp.pages.AccountInfoFillPage;
import com.nagp.pages.BasePage;
import com.nagp.pages.CreateAccountPage;
import com.nagp.pages.HomeApplyJobPage;
import com.nagp.utils.AndroidUtils;
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

    protected BasePage basePage;
    protected AndroidUtils androidUtils;
    protected CreateAccountPage createAccountPage;
    protected AccountInfoFillPage accountInfoFillPage;
    protected HomeApplyJobPage homeApplyJobPage;

    public AppiumDriver<MobileElement> driver;

    URL appiumURL = null;

//    @BeforeSuite(alwaysRun = true)
//    public AppiumDriver initializeDriver(){
//            try {
//                appiumURL = new URL("http://" + ConfigFileReader.getConfigPropertyVal("AppiumServer") + ":" + ConfigFileReader.getConfigPropertyVal("AppiumPort") + "/wd/hub");
//                this.driver = new AppiumDriver<MobileElement>(appiumURL, setAppCapabilities());
//                log.info("Driver initialized.");
//                initActions(driver);
//            } catch (Exception e) {
//                log.info("Error message:" + e.getMessage());
//                e.printStackTrace();
//            }
//        return driver;
//    }

//    public void initActions(AppiumDriver driver) {
//        basePage = new BasePage(driver);
//        androidUtils = new AndroidUtils(driver);
//        createAccountPage = new CreateAccountPage(driver);
//        accountInfoFillPage = new AccountInfoFillPage(driver);
//        homeApplyJobPage = new HomeApplyJobPage(driver);
//    }

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

    public String takeScreenShotPath(String testCaseName,AppiumDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }


//    @AfterClass(order = 1)  //end of class
//    public void deleteApp(){
////        if(scenario.isFailed())
////        {
////           scenario.attach(getByteScreenshot(), "image/png", scenario.getName());
////        }
//        log.info("Remove app from android");
//        driver.removeApp(ConfigFileReader.getConfigPropertyVal("appPackage"));
//        driver.quit();
//    }


}
