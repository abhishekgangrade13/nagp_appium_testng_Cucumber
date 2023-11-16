package com.nagp.runner;


import com.nagp.utils.AppiumServer;
import com.nagp.utils.ConfigFileReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.net.URL;

@CucumberOptions(
        features = {"src/test/java/com/nagp/features/AccountInfoFill.feature"},
        glue = {"com/nagp/step_definitions"},
//        plugin = {"pretty", "html:target/site/CucumberReport.html", "json:target/cucumber1/json"},
        tags = ""
)

public class TestNGRunner extends AbstractTestNGCucumberTests {
//    final static Logger log = Logger.getLogger(TestNGRunner.class);
//    @BeforeSuite
//    public void setUp(){
//        AppiumServer.start();
//    }
//
//    @AfterSuite
//    public void tearDown(){
//        AppiumServer.stop();
//    }

}
