package com.nagp.runner;

//import com.nagp.utils.AppiumDriverManager;
//import com.nagp.utils.ConfigFileReader;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//import org.apache.log4j.Logger;
//import org.testng.annotations.*;
//import com.cucumber.listener.Reporter;
//import managers.FileReaderManager;
//import java.io.File;

;
import com.nagp.utils.AppiumDriverManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.testng.annotations.*;

import java.io.File;


@CucumberOptions(
        features = {"src/test/java/com/nagp/features"},///CreateAccount.feature
        glue = {"com/nagp/step_definitions"},
//        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
//        plugin = {"html:target/cucumber-html-report","json:target/cucumber-reports/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = ""

)

public class TestNGRunner extends AbstractTestNGCucumberTests {
    final static Logger log = Logger.getLogger(TestNGRunner.class);

//    @BeforeSuite
//    public void startAppiumServer(){
//        AppiumServer.start();
//    }

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
//        Reporter.loadXMLConfig(new File(new ConfigFileReader().getReportConfigPath()));
    }

//    @AfterSuite
//    public void stopAppiumServer(){
//        AppiumServer.stop();
//    }


}
