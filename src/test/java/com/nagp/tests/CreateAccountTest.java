package com.nagp.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest{

    @Test
    public void loginTest() throws InterruptedException {
        driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
        Thread.sleep(2000);
//        driver.findElement(By.xpath("//android.widget.Button[@text = 'OK']"));
        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(2000);
        System.out.println("TestCompleted");


        Assert.assertTrue(driver.findElement(By.id("et_name")).isDisplayed(),"Successfully launched application");

    }

}
