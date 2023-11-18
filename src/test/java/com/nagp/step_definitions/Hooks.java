package com.nagp.step_definitions;

import com.nagp.utils.AppiumDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends AppiumDriverManager {
    final static Logger log = Logger.getLogger(Hooks.class);

    @Before
    public void beforeMethod(Scenario scenario){
        log.info("Test Case execution started : " +scenario.getName());
    }

    @After
    public void afterMethod(Scenario scenario){
        log.info("Test Case execution completed : " +scenario.getName());

        //Capture screenshot in case of failure
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            //attach image file report
            scenario.attach(screenshot,"image/png", scenario.getName());
        }
    }

}
