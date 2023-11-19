// '##################################################################################################################################
// 'Script Name      : Hooks
// 'Description      : Hook file containing before and after command after exexution
// 'Application      : in.workindia.nileshdungarwal.workindiaandroid
// 'Created On       : 15-11-2023
// 'Updated On       : NA
// 'Created By       : Abhishek Gangrade
// '###################################################################################################################################

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

    //Before to print scenario picked up for execution
    @Before
    public void beforeMethod(Scenario scenario){
        log.info("Test Case execution started : " +scenario.getName());
    }


    //After to print scenario completed after execution and also attach screenshot if in case of failure to extent reports
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
