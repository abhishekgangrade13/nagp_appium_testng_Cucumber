// '##################################################################################################################################
// 'Script Name      : CreateAccountPage
// 'Description      : Page file contains locator and method for login page screen
// 'Application      : in.workindia.nileshdungarwal.workindiaandroid
// 'Created On       : 13-11-2023
// 'Updated On       : NA
// 'Created By       : Abhishek Gangrade
// '###################################################################################################################################

package com.nagp.pages;

import com.nagp.utils.AndroidUtils;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class CreateAccountPage {

    final static Logger log = Logger.getLogger(CreateAccountPage.class);

    AndroidUtils androidUtils;
    public AppiumDriver driver;

    //Constructor
    public CreateAccountPage(AppiumDriver driver) {
        this.driver = driver;
        this.androidUtils = new AndroidUtils(driver);
        PageFactory.initElements(driver, this);
    }

    // Page Objects -----------------------------------------------------------
    private static final By txt_fullName = By.id("et_name");
    private static final By txt_mobileNo = By.id("et_number");
    private static final By btn_Submit = By.xpath("//*[@text = 'SUBMIT']");
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

    //'===========================================================================================================
    //'Function Name       : enterUserName
    //'Description         : Function to enter username on login screen
    //'============================================================================================================
    public void enterUserName(String fieldValue) {
        androidUtils.enterValueInTextBox(fieldValue, txt_fullName);
        log.info("Full name is entered as "+fieldValue);
    }

    //'===========================================================================================================
    //'Function Name       : enterMobileNo
    //'Description         : Function to enter mobile number on login screen
    //'============================================================================================================
    public void enterMobileNo(String fieldValue){
        androidUtils.enterValueInTextBox(fieldValue, txt_mobileNo);
        log.info("Mobile No is entered as "+fieldValue);
    }

    //'===========================================================================================================
    //'Function Name       : ClickOnSubmitButton
    //'Description         : Function to click on submit on login screen
    //'============================================================================================================
    public void ClickOnSubmitButton(){
        androidUtils.objectClick(btn_Submit);
        androidUtils.waitFor(3000);
    }

    //'===========================================================================================================
    //'Function Name       : loginFailed
    //'Description         : Function to verify login failed on login screen
    //'============================================================================================================
    public void loginFailed(){
        Assert.assertFalse(androidUtils.objectExists(ele_titleLogin), "User able to login with incorrect details.");
        log.info("User not able to login.");
    }

    //'===========================================================================================================
    //'Function Name       : loginSuccess
    //'Description         : Function to verify login success on login screen
    //'============================================================================================================
    public void loginSuccess(){
        androidUtils.waitUntilElementVisible(ele_titleLogin, 15000);
        Assert.assertTrue(androidUtils.objectExists(ele_titleLogin), "User is not able to login with correct details.");
        log.info("User able to login.");
    }

    //'===========================================================================================================
    //'Function Name       : LoginScreenCityValidation
    //'Description         : Function to verify city after login
    //'============================================================================================================
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

    //'===========================================================================================================
    //'Function Name       : SelectCountyAndCity
    //'Description         : Function to country and city after login
    //'============================================================================================================
    public void SelectCountyAndCity(String strCity, String strArea) {
        String strCityObject = select_city.replace("{strCity}",strCity);
        By loc_City = By.xpath(strCityObject);
        androidUtils.objectTap(loc_City);
        androidUtils.waitFor(2000);
        androidUtils.objectTabByCordinates(txt_area, -10,100,strArea);
        log.info("User selected cite as "+strCity +" and area as "+strArea);
    }

    //'===========================================================================================================
    //'Function Name       : FillDetailsScreen
    //'Description         : Function to verify account details screen dispalyed
    //'============================================================================================================
    public void FillDetailsScreen(){
        androidUtils.waitUntilElementVisible(ele_FillDetails, 15000);
        Assert.assertTrue(androidUtils.objectExists(ele_FillDetails), "User is not able to navigate to fill profile details screen.");
        log.info("User is able to navigate to fill profile details screen.");
    }

    //'===========================================================================================================
    //'Function Name       : EnterReferalCode
    //'Description         : Function to enter referral code on login screen
    //'============================================================================================================
    public void EnterReferalCode(String fieldValue){
        androidUtils.waitFor(3000);
        driver.hideKeyboard();
        androidUtils.waitFor(3000);
        androidUtils.objectClick(btn_referalCode);
        androidUtils.waitUntilElementVisible(txt_referalCode,5000);
        androidUtils.enterValueInTextBox(fieldValue, txt_referalCode);
        androidUtils.waitFor(2000);
        androidUtils.objectClick(btn_ApplyReferalCode);
        log.info("Referral code is entered "+fieldValue);
    }

    //'===========================================================================================================
    //'Function Name       : ErrorMessageReferalCode
    //'Description         : Function to verify error message on login
    //'============================================================================================================
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
