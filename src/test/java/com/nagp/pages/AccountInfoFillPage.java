package com.nagp.pages;

import com.nagp.step_definitions.CreateAccountTest;
import com.nagp.utils.AndroidUtils;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class AccountInfoFillPage {
    final static Logger log = Logger.getLogger(AccountInfoFillPage.class);

    AndroidUtils androidUtils = null;
    public AppiumDriver driver = null;

    public AccountInfoFillPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Page Objects -----------------------------------------------------------
    private static final By txt_appInfoScreen = By.id("//android.widget.TextView[@Co]");


    //-------------------------------------------------------------------------

    public  void VerifyGenderSection(String strGender){

    }
}
