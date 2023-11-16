package com.nagp.tests;

import com.nagp.pages.AccountInfoFillPage;
import com.nagp.pages.BasePage;
import com.nagp.pages.CreateAccountPage;
import com.nagp.utils.AndroidUtils;
import com.nagp.utils.ConfigFileReader;
import com.nagp.utils.Listener;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Listeners(Listener.class)
public class BaseTest {

    final static Logger log = LogManager.getLogger(BaseTest.class);

    protected BasePage basePage;
    protected AndroidUtils androidUtils;
    protected CreateAccountPage createAccountPage;

    protected AccountInfoFillPage accountInfoFillPage;

    public AppiumDriver<MobileElement> driver;

    URL appiumURL = null;

    @BeforeSuite(alwaysRun = true)
    public AppiumDriver initializeDriver(){
        if(driver == null) {
            try {
                appiumURL = new URL("http://" + ConfigFileReader.getConfigPropertyVal("AppiumServer") + ":" + ConfigFileReader.getConfigPropertyVal("AppiumPort") + "/wd/hub");
                this.driver = new AppiumDriver<MobileElement>(appiumURL, setAppCapabilities());
                log.info("Driver initialized.");
                initActions(driver);
            } catch (Exception e) {
                log.info("Error message:" + e.getMessage());
                e.printStackTrace();
            }
        }
        return driver;
    }

    public void initActions(AppiumDriver driver) {
        basePage = new BasePage(driver);
        androidUtils = new AndroidUtils(driver);
        createAccountPage = new CreateAccountPage(driver);
        accountInfoFillPage = new AccountInfoFillPage(driver);
    }

    public DesiredCapabilities setAppCapabilities(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("autoGrantPermissions", ConfigFileReader.getConfigPropertyVal("autoGrantPermissions"));
        caps.setCapability("deviceName", ConfigFileReader.getConfigPropertyVal("deviceName"));
        caps.setCapability("platformName", ConfigFileReader.getConfigPropertyVal("platformName"));
        caps.setCapability("platformVersion", ConfigFileReader.getConfigPropertyVal("platformVersion"));
        caps.setCapability("appPackage", ConfigFileReader.getConfigPropertyVal("appPackage"));
        caps.setCapability("appActivity", ConfigFileReader.getConfigPropertyVal("appActivity"));
        caps.setCapability("app", System.getProperty("user.dir")+"/"+ConfigFileReader.getConfigPropertyVal("app"));
        return caps;
    }

    public String takeScreenShotPath(String testCaseName,AppiumDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }

//    @AfterTest(alwaysRun = true)
//    public void tearDown() {
//        driver.quit();
//    }

//    @AfterClass(alwaysRun = true)
//    public void tearDownAfterClass() {
//        driver.quit();
//    }


//    @After
//    public void tearDown(){
//        driver.quit();
//        log.info("driver quit.");
//    }

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

//    @AfterSuite
//    public void tearDown(){
//        driver.close();
//        driver.quit();
//    }

}
