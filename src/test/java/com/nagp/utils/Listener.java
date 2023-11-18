package com.nagp.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.nagp.tests.BaseTest;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listener extends  AppiumDriverManager implements ITestListener {
    BaseTest baseTest = new BaseTest();
    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("Testcase Case Execution Started :"+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("Testcase Passed :"+result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("Testcase Failed :"+result.getName());
        String testMethodName = result.getMethod().getMethodName();
        AppiumDriver mobileDriver = null;
        try {
            mobileDriver =(AppiumDriver) result.getTestClass().getRealClass().getDeclaredField("mobileDriver").get(result.getInstance());
        } catch(Exception e)
        {
            e.printStackTrace();
        }

        try {
            baseTest.takeScreenShotPath(testMethodName, mobileDriver);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
//        captureScreenShot(result, "fail");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("Testcase Case Execution Skipped :"+result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub

    }

    // Function to capture screenshot.
    public void captureScreenShot(ITestResult result, String status) {
        // AndroidDriver driver=ScreenshotOnPassFail.getDriver();
        String destDir = "";
        String passfailMethod = result.getMethod().getRealClass().getSimpleName() + "." + result.getMethod().getMethodName();
        // To capture screenshot.
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        // If status = fail then set folder name "screenshots/Failures"
        if (status.equalsIgnoreCase("fail")) {
            destDir = "screenshots/Failures";
        }
        // If status = pass then set folder name "screenshots/Success"
        else if (status.equalsIgnoreCase("pass")) {
            destDir = "screenshots/Success";
        }
    }

}