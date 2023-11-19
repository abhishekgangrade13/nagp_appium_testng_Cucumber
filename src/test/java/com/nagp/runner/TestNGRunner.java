// '##################################################################################################################################
// 'Script Name      : TestNGRunner
// 'Description      : Runner file to start the suite
// 'Application      : in.workindia.nileshdungarwal.workindiaandroid
// 'Created On       : 14-11-2023
// 'Updated On       : NA
// 'Created By       : Abhishek Gangrade
// '###################################################################################################################################


package com.nagp.runner;

import com.nagp.utils.AppiumDriverManager;
import com.nagp.utils.AppiumServer;
import com.nagp.utils.Listener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

//Cucumber Options
@CucumberOptions(
        tags = "", //@Sanity @Regression, @CreateAccountScreen, @HomeApplyJobFeature, @AccountInfoFillScreen, @FailedScreenshot
        features = {"src/test/java/com/nagp/features"},
        glue = {"com/nagp/step_definitions"},
        monochrome = true,
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

@Listeners(Listener.class)
public class TestNGRunner extends AbstractTestNGCucumberTests {
    //object for appium server
    AppiumServer appiumServer = new AppiumServer();


    //Before suite created to run the appium services at start
    @BeforeSuite
    public void startAppiumServer(){
//        AppiumServer.start();
//        if (appiumServer.checkIfServerIsRunning(Integer.parseInt(ConfigFileReader.getConfigPropertyVal("AppiumPort")))){
//            appiumServer.stopServer();
//        }
//        appiumServer.startServer();
    }

    //Before class to initialize driver
    @BeforeClass(alwaysRun = true)
    public void DriverInitialize(){
        new AppiumDriverManager().initializeDriver();
    }

    //Before method to launch app before each scenario
    @BeforeMethod
    public void reLaunchApp(){
        AppiumDriverManager.driver.launchApp();
    }

    //After method to close app after each scenario
    @AfterMethod
    public void closeApp(){
        AppiumDriverManager.driver.closeApp();
    }

    //After Class to close the driver and remove app after executing all scenario
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        new AppiumDriverManager().tearDownDriver();
    }

    //After suite to stop appium services after executing all scenario
    @AfterSuite
    public void stopAppiumServer(){
//        AppiumServer.stop();
//        appiumServer.stopServer();
    }
}
