// '##################################################################################################################################
// 'Script Name      : AccountInfoFillPage
// 'Description      : Page file contains locator and method for Account details screen
// 'Application      : in.workindia.nileshdungarwal.workindiaandroid
// 'Created On       : 15-11-2023
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
import static com.nagp.utils.Constants.*;

public class AccountInfoFillPage {
    final static Logger log = Logger.getLogger(AccountInfoFillPage.class);

    AndroidUtils androidUtils;
    public AppiumDriver driver;

    //Constructor
    public AccountInfoFillPage(AppiumDriver driver) {
        this.driver = driver;
        androidUtils =new AndroidUtils(driver);
        PageFactory.initElements(driver, this);
    }

    //Page Objects -----------------------------------------------------------
    String txt_appInfoScreen = "//android.widget.TextView[contains(@text,'{strTextName}')]";
    String btn_appInfoScreen = "//android.widget.Button[@text='{strButtonName}']";
    String chkbx_appInfoScreen = "//android.widget.CheckBox[contains(@text,'{strCheckboxName}')]";
    //-------------------------------------------------------------------------

    //'===========================================================================================================
    //'Function Name       : VerifyGenderSection
    //'Description         : Function to verify Gender title and values present under it on account details screen
    //'============================================================================================================
    public void VerifyGenderSection(String strGender){
        boolean flag = true;

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

    //'===========================================================================================================
    //'Function Name       : VerifyQualificationSection
    //'Description         : Function to verify Qualification title and values present under it on account details screen
    //'============================================================================================================
    public void VerifyQualificationSection(String strQualification){
        boolean flag = true;

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

    //'===========================================================================================================
    //'Function Name       : VerifylanguageSection
    //'Description         : Function to verify Language title and values present under it on account details screen
    //'============================================================================================================
    public void VerifylanguageSection(String strLanguage){
        boolean flag = true;

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

    //'===========================================================================================================
    //'Function Name       : VerifyFluencySection
    //'Description         : Function to verify fluency title and values present under it on account details screen
    //'============================================================================================================
    public void VerifyFluencySection(String strfluency){
        boolean flag = true;

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

    //'===========================================================================================================
    //'Function Name       : VerifyExperienceSection
    //'Description         : Function to verify Experience title and values present under it on account details screen
    //'============================================================================================================
    public void VerifyExperienceSection(String strExperience){
        boolean flag = true;

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

    //'===========================================================================================================
    //'Function Name       : ScrollUptoDown
    //'Description         : Function to scroll screen from Up to Down by certain percentage
    //'============================================================================================================
    public void ScrollUptoDown(){
        androidUtils.scrollUptoDown(0.70,0.10,0.50, 2000);
    }

    //'===========================================================================================================
    //'Function Name       : VerifyAgeSection
    //'Description         : Function to verify Age title and values present under it on account details screen
    //'============================================================================================================
    public void VerifyAgeSection(){
        //Field - Title heading
        String strTxtName = txt_appInfoScreen.replace("{strTextName}",Title_Age);
        By loc_txtTitleldName = By.xpath(strTxtName);

        //Values under heading
        String strAgeValue = txt_appInfoScreen.replace("{strTextName}",Value_Age);
        By loc_txtFieldName = By.xpath(strAgeValue);

        Assert.assertTrue(androidUtils.objectExists(loc_txtTitleldName) && androidUtils.objectExists(loc_txtFieldName), "User is not able to see Age under My Age sections.");
        log.info("User able to see Age section on screen.");
    }

    //'===========================================================================================================
    //'Function Name       : VerifyInterestedSection
    //'Description         : Function to verify Interested title and values present under it on account details screen
    //'============================================================================================================
    public void VerifyInterestedSection(String strInterested){
        boolean flag = true;

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

    //'===========================================================================================================
    //'Function Name       : TabField
    //'Description         : Function to tab on values for each Menu on account information screen
    //'============================================================================================================
    public void TabField(String fieldName, String fieldValue){
        String objString, strReplaceName;
        if (!(fieldName.trim().equalsIgnoreCase("InterestedIn"))){
            objString = btn_appInfoScreen;
            strReplaceName = "{strButtonName}";
        }else{
            objString = chkbx_appInfoScreen;
            strReplaceName = "{strCheckboxName}";
        }
        By loc_field = By.xpath(objString.replace(strReplaceName,fieldValue.trim()));
        androidUtils.waitUntilElementVisible(loc_field,3000);
        androidUtils.objectTap(loc_field);
        log.info("User selected "+fieldName+" as "+fieldValue);
    }

    //'===========================================================================================================
    //'Function Name       : SelectAgeField
    //'Description         : Function to select age field value on account details screen
    //'============================================================================================================
    public void SelectAgeField(String AgeValue){
        By loc_Agefield = By.xpath(txt_appInfoScreen.replace("{strTextName}",Value_Age));
        androidUtils.objectClick(loc_Agefield);
        androidUtils.waitFor(2000);

        By loc_AgeValue = By.xpath(txt_appInfoScreen.replace("{strTextName}",AgeValue));
        androidUtils.objectClick(loc_AgeValue);
        androidUtils.waitFor(2000);
        log.info("User selected age as "+AgeValue);
    }

    //'===========================================================================================================
    //'Function Name       : VerifySalaryDetailsScreen
    //'Description         : Function to verify salary detail screen should be displayed
    //'============================================================================================================
    public void VerifySalaryDetailsScreen(){
        By ele_SalaryDetailScreen = By.xpath(txt_appInfoScreen.replace("{strTextName}",Title_Salary));
        androidUtils.waitUntilElementVisible(ele_SalaryDetailScreen, 15000);
        Assert.assertTrue(androidUtils.objectExists(ele_SalaryDetailScreen), "User is not able to navigate to last salary details screen.");
        log.info("User is able to navigate to last salary details screen.");
    }

    //'===========================================================================================================
    //'Function Name       : SelectLastDrawnSalary
    //'Description         : Function to select last drawn salary field value on account details screen
    //'============================================================================================================
    public void SelectLastDrawnSalary(String lastSalaryValue){
        By loc_lastSalaryfield = By.xpath(txt_appInfoScreen.replace("{strTextName}",Value_Salary));
        androidUtils.waitUntilElementVisible(loc_lastSalaryfield,3000);
        androidUtils.objectClick(loc_lastSalaryfield);
        androidUtils.waitFor(2000);

        By loc_LastSalaryValue = By.xpath(txt_appInfoScreen.replace("{strTextName}",lastSalaryValue));
        androidUtils.waitUntilElementVisible(loc_LastSalaryValue,3000);
        androidUtils.objectClick(loc_LastSalaryValue);
        androidUtils.waitFor(2000);
        log.info("User selected last drawn salary as "+lastSalaryValue);
    }

    //'===========================================================================================================
    //'Function Name       : VerifyJobApplyHomeLocation
    //'Description         : Function to verify job home screen should be displayed
    //'============================================================================================================
    public void VerifyJobApplyHomeLocation(){
        By ele_JobApplyHomeScreen = By.xpath(txt_appInfoScreen.replace("{strTextName}",Title_WorkIndia));
        androidUtils.waitUntilElementVisible(ele_JobApplyHomeScreen, 15000);
        Assert.assertTrue(androidUtils.objectExists(ele_JobApplyHomeScreen), "User is not able to create profile and work india job search screen should be displayed.");
        log.info("User is able to create profile and work india job search screen should be displayed.");
    }

}
