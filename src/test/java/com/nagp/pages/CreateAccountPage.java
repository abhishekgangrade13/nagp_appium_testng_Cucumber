package com.nagp.pages;

import com.nagp.step_definitions.CreateAccountTest;
import com.nagp.utils.AndroidUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.bs.A;
import net.bytebuddy.asm.Advice;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CreateAccountPage {

    final static Logger log = Logger.getLogger(CreateAccountTest.class);

    AndroidUtils androidUtils = null;
    public AppiumDriver driver = null;

    public CreateAccountPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Page Objects -----------------------------------------------------------
    private static final By txt_fullName = By.id("et_name");
    private static final By txt_mobileNo = By.id("et_number");
    private static final By btn_Submit = By.xpath("//*[@text = 'SUBMIT']");
    private static final By btn_SubmitCity = By.id("btn_submit");
    private static final By ele_titleLogin = By.id("tv_city");

    String select_city = "//android.widget.Button[@text = '{strCity}']";
    private static final By txt_area = By.id("act_auto_complete");

    private static final By ele_FillDetails = By.id("tv_profile_heading");

    //-------------------------------------------------------------------------

//    public void enterUserName(String fieldName, String fieldValue){
//        By locator = null;
//        switch (fieldName.toLowerCase()){
//            case "fullname":
//                locator = txt_fullName;
//                break;
//            case "mobile":
//                locator = txt_mobileNo;
//                break;
//            default:
//                log.error("No field object exists.");
//                break;
//        }
//        System.out.println(locator);
//        androidUtils.enterValueInTextBox(fieldValue, locator);
//    }

    public void enterUserName(String fieldValue) {
        AndroidUtils androidUtils =new AndroidUtils(driver);
        androidUtils.enterValueInTextBox(fieldValue, txt_fullName);
        log.info("Full name is entered as "+fieldValue);
    }

    public void enterMobileNo(String fieldValue){
        AndroidUtils androidUtils =new AndroidUtils(driver);
        androidUtils.enterValueInTextBox(fieldValue, txt_mobileNo);
        log.info("Mobile No is entered as "+fieldValue);
    }

    public void ClickOnSubmitButton(){
        AndroidUtils androidUtils =new AndroidUtils(driver);
        androidUtils.objectClick(btn_Submit);
        androidUtils.waitFor(3000);
    }

    public void loginFailed(){
        AndroidUtils androidUtils =new AndroidUtils(driver);
        Assert.assertFalse(androidUtils.objectExists(ele_titleLogin), "User able to login with incorrect details.");
        log.info("User not able to login.");
    }

    public void loginSuccess(){
        AndroidUtils androidUtils =new AndroidUtils(driver);
//        androidUtils.waitFor(5000);
        androidUtils.waitUntilElementVisible(ele_titleLogin, 15000);
        Assert.assertTrue(androidUtils.objectExists(ele_titleLogin), "User is not able to login with correct details.");
        log.info("User able to login.");
    }

    public void LoginScreenCityValidation(String strCities){
        boolean flag = true;
        AndroidUtils androidUtils =new AndroidUtils(driver);
        String[] cities = strCities.split(",");
        for(String city : cities){
            String strCityName = select_city.replace("{strCity}",city.trim());
            By loc_City = By.xpath(strCityName);
            if(!androidUtils.objectExists(loc_City)){
                flag = false;
                break;
            }
        }
        Assert.assertTrue(flag, "User is not able to see all the cities after login.");
        log.info("User able to see all the cities-"+strCities);
    }

    public void SelectCountyAndCity(String strCity, String strArea) {
        AndroidUtils androidUtils =new AndroidUtils(driver);
        String strCityObject = select_city.replace("{strCity}",strCity);
        By loc_City = By.xpath(strCityObject);
        androidUtils.objectTap(loc_City);
        androidUtils.waitFor(2000);
        androidUtils.objectTabByCordinates(txt_area, -10,100,strArea);
        log.info("User selected cite as "+strCity +" and area as "+strArea);
    }

    public void FillDetailsScreen(){
        AndroidUtils androidUtils =new AndroidUtils(driver);
        androidUtils.waitUntilElementVisible(ele_FillDetails, 15000);
        Assert.assertTrue(androidUtils.objectExists(ele_FillDetails), "User is not able to navigate to fill profile details screen.");
        log.info("User is able to navigate to fill profile details screen.");
    }

}
