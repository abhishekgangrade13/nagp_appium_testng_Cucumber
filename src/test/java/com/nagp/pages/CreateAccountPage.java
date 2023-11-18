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

    final static Logger log = Logger.getLogger(CreateAccountPage.class);

    AndroidUtils androidUtils;
    public AppiumDriver driver;

    public CreateAccountPage(AppiumDriver driver) {
        this.driver = driver;
        this.androidUtils = new AndroidUtils(driver);
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
    private static final By btn_referalCode = By.id("tv_referral_code");
    private static final By txt_referalCode = By.id("et_referral_code");
    private static final By btn_ApplyReferalCode = By.id("android:id/button1");
    private static final By btn_CancelReferalCode = By.id("android:id/button2");
    private static final By msg_referalCode = By.id("tv_message");
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
        androidUtils.enterValueInTextBox(fieldValue, txt_fullName);
        log.info("Full name is entered as "+fieldValue);
    }

    public void enterMobileNo(String fieldValue){
        androidUtils.enterValueInTextBox(fieldValue, txt_mobileNo);
        log.info("Mobile No is entered as "+fieldValue);
    }

    public void ClickOnSubmitButton(){
        androidUtils.objectClick(btn_Submit);
        androidUtils.waitFor(3000);
    }

    public void loginFailed(){
        Assert.assertFalse(androidUtils.objectExists(ele_titleLogin), "User able to login with incorrect details.");
        log.info("User not able to login.");
    }

    public void loginSuccess(){
        androidUtils.waitUntilElementVisible(ele_titleLogin, 15000);
        Assert.assertTrue(androidUtils.objectExists(ele_titleLogin), "User is not able to login with correct details.");
        log.info("User able to login.");
    }

    public void LoginScreenCityValidation(String strCities){
        boolean flag = true;
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
        String strCityObject = select_city.replace("{strCity}",strCity);
        By loc_City = By.xpath(strCityObject);
        androidUtils.objectTap(loc_City);
        androidUtils.waitFor(2000);
        androidUtils.objectTabByCordinates(txt_area, -10,100,strArea);
        log.info("User selected cite as "+strCity +" and area as "+strArea);
    }

    public void FillDetailsScreen(){
        androidUtils.waitUntilElementVisible(ele_FillDetails, 15000);
        Assert.assertTrue(androidUtils.objectExists(ele_FillDetails), "User is not able to navigate to fill profile details screen.");
        log.info("User is able to navigate to fill profile details screen.");
    }

    public void EnterReferalCode(String fieldValue){
        androidUtils.waitFor(3000);
        driver.hideKeyboard();
        androidUtils.waitFor(3000);
        androidUtils.objectClick(btn_referalCode);
        androidUtils.waitUntilElementVisible(txt_referalCode,5000);
        androidUtils.enterValueInTextBox(fieldValue, txt_referalCode);
        androidUtils.waitFor(2000);
        androidUtils.objectClick(btn_ApplyReferalCode);
        log.info("Referal code is entered "+fieldValue);
    }

    public void ErrorMessageReferalCode(String errmsg){
        boolean flag = false;
        androidUtils.waitUntilElementVisible(msg_referalCode,7000);
        if(androidUtils.getElementText(msg_referalCode).equalsIgnoreCase(errmsg)){
            flag = true;
        }
        androidUtils.objectTap(btn_CancelReferalCode);
        Assert.assertTrue(flag, "User not receive error message 'Not a Valid Code' on screen.");
        log.info("User received error message 'Not a Valid Code' on screen.");
    }
}
