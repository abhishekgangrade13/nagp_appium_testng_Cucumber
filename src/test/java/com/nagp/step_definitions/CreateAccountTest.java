package com.nagp.step_definitions;

import com.nagp.pages.BasePage;
import com.nagp.pages.CreateAccountPage;
import com.nagp.utils.AppiumDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;


public class CreateAccountTest extends AppiumDriverManager {
    final static Logger log = Logger.getLogger(CreateAccountTest.class);
    BasePage basePage = new BasePage(driver);
    CreateAccountPage createAccountPage = new CreateAccountPage(driver);

    @Given("User launch the application")
    public void fnLaunchApplication() {
        basePage.fnAcceptPermission();
    }

    @Then("user should be able to successfully launch the application")
    public void fnLaunchSuccessfully() {
        basePage.fnLaunchSuccess();

    }

    @Given("User enter the {string} in FullName field")
    public void fnEnterUserName(String value) {
        createAccountPage.enterUserName(value);
    }

    @Given("User enter the {string} in Mobile field")
    public void fnEnterMobileNo(String value) {
        createAccountPage.enterMobileNo(value);
    }

    @Given("User enter the {string} in referal code field")
    public void fnEnterReferalCode(String value) {
        createAccountPage.EnterReferalCode(value);
    }

    @Given("Change the orientation of screen")
    public void fnSwitchOrientation() {
        basePage.SwitchOrientation();
    }

    @Given("User click on submit button")
    public void fnClickOnSubmitButton() {
        createAccountPage.ClickOnSubmitButton();
    }

    @Then("user should not login into application successfully")
    public void fnLoginFailed() {
        createAccountPage.loginFailed();
    }

    @Then("User should receive error message {string} on screen")
    public void fnErrorMessageReferalCode(String errMsg) {
        createAccountPage.ErrorMessageReferalCode(errMsg);
    }

    @Then("user should be able to login into application successfully")
    public void fnLoginSuccess() {
        createAccountPage.loginSuccess();
    }

    @Then("screen should display all cities {string}")
    public void fnLoginScreenCityValidation(String strCities) {
        createAccountPage.LoginScreenCityValidation(strCities);
    }

    @When("user select {string} city and {string} area")
    public void fnSelectCountryAndCity(String city, String area){
        createAccountPage.SelectCountyAndCity(city, area);
    }

    @Then("User should be able to see fill profile details screen")
    public void fnFillDetailsScreen() {
        createAccountPage.FillDetailsScreen();
    }


//    @After
//    public void tearDown(){
//        basePage.tearDown();
//    }

//    @AfterMethod(alwaysRun = true)
//    public void tearDown(){
//        this.driver.quit();
//    }
}
