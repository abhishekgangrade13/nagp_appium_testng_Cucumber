package com.nagp.pages;

import com.nagp.step_definitions.CreateAccountTest;
import com.nagp.utils.AndroidUtils;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.nagp.utils.Constants.*;

public class AccountInfoFillPage {
    final static Logger log = Logger.getLogger(AccountInfoFillPage.class);

    AndroidUtils androidUtils = null;
    public AppiumDriver driver = null;

    public AccountInfoFillPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Page Objects -----------------------------------------------------------
    String txt_appInfoScreen = "//android.widget.TextView[contains(@text,'{strTextName}')]";
    String btn_appInfoScreen = "//android.widget.Button[@text='{strButtonName}']";
    String chkbx_appInfoScreen = "//android.widget.CheckBox[contains(@text,'{strCheckboxName}')]";
    //-------------------------------------------------------------------------

    public void VerifyGenderSection(String strGender){
        boolean flag = true;
        AndroidUtils androidUtils =new AndroidUtils(driver);

        //Field - Title heading
        String strTxtName = txt_appInfoScreen.replace("{strTextName}",Title_Gender);
        By loc_txtFieldName = By.xpath(strTxtName);

        //Values under heading
        String[] arrGender = strGender.split(",");

        for(String g : arrGender){
            String Gender = btn_appInfoScreen.replace("{strButtonName}",g.trim());
            By loc_gender = By.xpath(Gender);
            if(!androidUtils.objectExists(loc_gender)){
                flag = false;
                break;
            }
        }
        Assert.assertTrue(flag && androidUtils.objectExists(loc_txtFieldName), "User is not able to see gender under My gender sections.");
        log.info("User able to see all the Gender on screen.");
    }

    public void VerifyQualificationSection(String strQualification){
        boolean flag = true;
        AndroidUtils androidUtils =new AndroidUtils(driver);

        //Field - Title heading
        String strTxtName = txt_appInfoScreen.replace("{strTextName}",Title_Qualification);
        By loc_txtFieldName = By.xpath(strTxtName);

        //Values under heading
        String[] arrQualification = strQualification.split(",");

        for(String g : arrQualification){
            String Qualification = btn_appInfoScreen.replace("{strButtonName}",g.trim());
            By loc_Qualification = By.xpath(Qualification);
            if(!androidUtils.objectExists(loc_Qualification)){
                flag = false;
                break;
            }
        }
        Assert.assertTrue(flag && androidUtils.objectExists(loc_txtFieldName), "User is not able to see Qualification under My Qualification sections.");
        log.info("User able to see all the Qualification on screen.");
    }

    public void VerifylanguageSection(String strLanguage){
        boolean flag = true;
        AndroidUtils androidUtils =new AndroidUtils(driver);

        //Field - Title heading
        String strTxtName = txt_appInfoScreen.replace("{strTextName}",Title_Medium);
        By loc_txtFieldName = By.xpath(strTxtName);

        //Values under heading
        String[] arrlanguage = strLanguage.split(",");

        for(String g : arrlanguage){
            String language = btn_appInfoScreen.replace("{strButtonName}",g.trim());
            By loc_language = By.xpath(language);
            if(!androidUtils.objectExists(loc_language)){
                flag = false;
                break;
            }
        }
        Assert.assertTrue(flag && androidUtils.objectExists(loc_txtFieldName), "User is not able to see language under My school medium sections.");
        log.info("User able to see all the language on screen.");
    }

    public void VerifyFluencySection(String strfluency){
        boolean flag = true;
        AndroidUtils androidUtils =new AndroidUtils(driver);

        //Field - Title heading
        String strTxtName = txt_appInfoScreen.replace("{strTextName}",Title_Fluency);
        By loc_txtFieldName = By.xpath(strTxtName);

        //Values under heading
        String[] arrFluency = strfluency.split(",");

        for(String g : arrFluency){
            String fluency = btn_appInfoScreen.replace("{strButtonName}",g.trim());
            By loc_fluency = By.xpath(fluency);
            if(!androidUtils.objectExists(loc_fluency)){
                flag = false;
                break;
            }
        }
        Assert.assertTrue(flag && androidUtils.objectExists(loc_txtFieldName), "User is not able to see fluency under How I Speak sections.");
        log.info("User able to see all the fluency on screen.");
    }

    public void VerifyExperienceSection(String strExperience){
        boolean flag = true;
        AndroidUtils androidUtils =new AndroidUtils(driver);

        //Field - Title heading
        String strTxtName = txt_appInfoScreen.replace("{strTextName}",Title_Exp);
        By loc_txtFieldName = By.xpath(strTxtName);

        //Values under heading
        String[] arrExperience = strExperience.split(",");

        for(String g : arrExperience){
            String Experience = btn_appInfoScreen.replace("{strButtonName}",g.trim());
            By loc_Experience = By.xpath(Experience);
            if(!androidUtils.objectExists(loc_Experience)){
                flag = false;
                break;
            }
        }
        Assert.assertTrue(flag && androidUtils.objectExists(loc_txtFieldName), "User is not able to see Experience under Fresher/Experience sections.");
        log.info("User able to see all the Experience on screen.");
    }

    public void ScrollUptoDown(){
        AndroidUtils androidUtils =new AndroidUtils(driver);
        androidUtils.scrollUptoDown(0.70,0.10,0.50);
        androidUtils.waitFor(1000);
    }

    public void VerifyAgeSection(){
        boolean flag = true;
        AndroidUtils androidUtils =new AndroidUtils(driver);

        //Field - Title heading
        String strTxtName = txt_appInfoScreen.replace("{strTextName}",Title_Age);
        By loc_txtTitleldName = By.xpath(strTxtName);

        //Values under heading
        String strAgeValue = txt_appInfoScreen.replace("{strTextName}",Value_Age);
        By loc_txtFieldName = By.xpath(strAgeValue);

        Assert.assertTrue(androidUtils.objectExists(loc_txtTitleldName) && androidUtils.objectExists(loc_txtFieldName), "User is not able to see Age under My Age sections.");
        log.info("User able to see Age section on screen.");
    }

    public void VerifyInterestedSection(String strInterested){
        boolean flag = true;
        AndroidUtils androidUtils =new AndroidUtils(driver);

        //Field - Title heading
        String strTxtName = txt_appInfoScreen.replace("{strTextName}",Title_InterestedIn);
        By loc_txtFieldName = By.xpath(strTxtName);

        //Values under heading
        String[] arrInterested = strInterested.split(",");

        for(String g : arrInterested){
            String Interested = chkbx_appInfoScreen.replace("{strCheckboxName}",g.trim());
            By loc_Interested = By.xpath(Interested);
            if(!androidUtils.objectExists(loc_Interested)){
                flag = false;
                break;
            }
        }
        Assert.assertTrue(flag && androidUtils.objectExists(loc_txtFieldName), "User is not able to see Interested under Interested_Exerienced section.");
        log.info("User able to see all the Interested fields on screen.");
    }

    public void TabField(String fieldName, String fieldValue){
        String objString;
        if (!(fieldName.trim().equalsIgnoreCase("InterestedIn"))){
            objString = btn_appInfoScreen;
        }
        else{
            objString = chkbx_appInfoScreen;
        }
        System.out.println("objString-"+objString);
        AndroidUtils androidUtils =new AndroidUtils(driver);
        By loc_field = By.xpath(objString.replace("{strButtonName}",fieldValue.trim()));
        System.out.println(loc_field);
        androidUtils.objectTap(loc_field);
        log.info("User selected "+fieldName+" as "+fieldValue);
    }

    public void SelectAgeField(String AgeValue){
        AndroidUtils androidUtils =new AndroidUtils(driver);
        By loc_Agefield = By.xpath(txt_appInfoScreen.replace("{strTextName}",Value_Age));
        androidUtils.objectClick(loc_Agefield);
        androidUtils.waitFor(2000);

        By loc_AgeValue = By.xpath(txt_appInfoScreen.replace("{strTextName}",AgeValue));
        androidUtils.objectClick(loc_AgeValue);
        androidUtils.waitFor(2000);
        log.info("User selected age as "+AgeValue);
    }

    public void VerifySalaryDetailsScreen(){
        AndroidUtils androidUtils =new AndroidUtils(driver);
        By ele_SalaryDetailScreen = By.xpath(chkbx_appInfoScreen.replace("{strCheckboxName}","Aapki Last Salary Kya thi"));
        androidUtils.waitUntilElementVisible(ele_SalaryDetailScreen, 15000);
        Assert.assertTrue(androidUtils.objectExists(ele_SalaryDetailScreen), "User is not able to navigate to last salary details screen.");
        log.info("User is able to navigate to last salary details screen.");
    }

}
