package com.nagp.runner;

import com.nagp.utils.AppiumDriverManager;
import com.nagp.utils.AppiumServer;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

@CucumberOptions(
        tags = "", //@Sanity @Regression, @CreateAccountScreen, @HomeApplyJobFeature, @AccountInfoFillScreen
        features = {"src/test/java/com/nagp/features"},
        glue = {"com/nagp/step_definitions"},
        monochrome = true,
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class TestNGRunner extends AbstractTestNGCucumberTests {
    AppiumServer appiumServer = new AppiumServer();

    @BeforeSuite
    public void startAppiumServer(){
//        AppiumServer.start();
//        if (appiumServer.checkIfServerIsRunning(Integer.parseInt(ConfigFileReader.getConfigPropertyVal("AppiumPort")))){
//            appiumServer.stopServer();
//        }
//        appiumServer.startServer();
    }

    @BeforeClass(alwaysRun = true)
    public void DriverInitialize(){
        new AppiumDriverManager().initializeDriver();
    }

    @BeforeMethod
    public void reLaunchApp(){
        AppiumDriverManager.driver.launchApp();
    }

    @AfterMethod
    public void closeApp(){
        AppiumDriverManager.driver.closeApp();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        new AppiumDriverManager().tearDownDriver();
    }

    @AfterSuite
    public void stopAppiumServer(){
//        AppiumServer.stop();
//        appiumServer.stopServer();
    }
}
