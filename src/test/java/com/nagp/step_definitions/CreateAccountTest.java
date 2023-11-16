package com.nagp.step_definitions;

import com.nagp.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import com.nagp.tests.BaseClass;
import org.testng.annotations.AfterClass;

public class CreateAccountTest extends BaseClass {
    final static Logger log = Logger.getLogger(CreateAccountTest.class);

    public CreateAccountTest(){
        super();
        this.driver = initializeDriver();
    }

    @Given("User launch the application")
    public void fnLaunchApplication() throws InterruptedException {
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

    @Given("User click on submit button")
    public void fnClickOnSubmitButton() {
        createAccountPage.ClickOnSubmitButton();
    }

    @Then("user should not login into application successfully")
    public void fnLoginFailed() {
        createAccountPage.loginFailed();
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
    public void fnSelectCountryAndCity(String city, String area) throws InterruptedException {
        createAccountPage.SelectCountyAndCity(city, area);
    }

    @Then("User should be able to see fill profile details screen")
    public void fnFillDetailsScreen() {
        createAccountPage.FillDetailsScreen();
    }

    @After
    public void tearDown(){
        basePage.tearDown();
    }

}
