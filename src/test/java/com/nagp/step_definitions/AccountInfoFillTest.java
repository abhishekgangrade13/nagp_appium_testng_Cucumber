package com.nagp.step_definitions;

import com.nagp.pages.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import com.nagp.tests.BaseClass;
import org.testng.annotations.AfterClass;

public class AccountInfoFillTest extends BaseClass {

    final static Logger log = Logger.getLogger(AccountInfoFillTest.class);

    public AccountInfoFillTest(){
        super();
        this.driver = initializeDriver();
    }


    @After
    public void tearDown(){
        basePage.tearDown();
    }

}
