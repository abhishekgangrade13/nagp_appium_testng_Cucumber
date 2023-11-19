// '##################################################################################################################################
// 'Script Name      : AndroidUtils
// 'Description      : Utils file all utility function
// 'Application      : in.workindia.nileshdungarwal.workindiaandroid
// 'Created On       : 14-11-2023
// 'Updated On       : NA
// 'Created By       : Abhishek Gangrade
// '###################################################################################################################################

package com.nagp.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class AndroidUtils {

	public AppiumDriver driver;

	//Constructor
	public AndroidUtils(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	//'===========================================================================================================
	//'Function Name       : waitFor
	//'Description         : Function to wait for certain time
	//'============================================================================================================
	public void waitFor(long milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//'===========================================================================================================
	//'Function Name       : waitUntilElementLocated
	//'Description         : Function to wait until element located for mentioned time
	//'============================================================================================================
	public void waitUntilElementLocated(By by, long timeOutInSeconds){
		(new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.presenceOfElementLocated(by));
	}

	//'===========================================================================================================
	//'Function Name       : waitUntilElementVisible
	//'Description         : Function to wait until element visible for mentioned time
	//'============================================================================================================
	public void waitUntilElementVisible(By by, long timeOutInSeconds){
		(new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	//'===========================================================================================================
	//'Function Name       : waitUntilElementInVisible
	//'Description         : Function to wait until element invisible for mentioned time
	//'============================================================================================================
	public void waitUntilElementInVisible(By by, long timeOutInSeconds){
		(new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	//'===========================================================================================================
	//'Function Name       : waitUntilElementInVisible
	//'Description         : Function to wait until element enabled for mentioned time
	//'============================================================================================================
	public void waitUntilElementEnabled(By by, long timeOutInSeconds){
		(new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.elementToBeClickable(by));
	}

	//'===========================================================================================================
	//'Function Name       : waitUntilElementDisabled
	//'Description         : Function to wait until element disabled for mentioned time
	//'============================================================================================================
	public void waitUntilElementDisabled(By by, long timeOutInSeconds){
		(new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(by)));
	}

	//'===========================================================================================================
	//'Function Name       : objectExists
	//'Description         : Function to check if object exists
	//'============================================================================================================
	public Boolean objectExists(By by) {
		try {
			if (driver.findElements(by).size() == 0) {
				return false;
			} else {
				return true;
			}
		}catch (Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	//'===========================================================================================================
	//'Function Name       : objectClick
	//'Description         : Function to click object
	//'============================================================================================================
	public boolean objectClick(By by) {
		boolean flag = false;
		try {
			if (driver.findElement(by).isDisplayed()) {
				driver.findElement(by).click();
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	//'===========================================================================================================
	//'Function Name       : objectTap
	//'Description         : Function to tab object using touch actions
	//'============================================================================================================
	public void objectTap(By by) {
		TouchAction touch = new TouchAction(driver);
		WebElement ele = driver.findElement(by);
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(ele))).release().perform();
	}

	//'===========================================================================================================
	//'Function Name       : objectTabByCordinates
	//'Description         : Function to tab object by cordinates using touch actions
	//'============================================================================================================
	public void objectTabByCordinates(By by, int x, int y, String value) {
		TouchAction touch = new TouchAction(driver);
		WebElement ele = driver.findElement(by);
		ele.sendKeys(value);
		int x1 = ele.getLocation().getX() + x;
		int y1 = ele.getLocation().getY() + y;
		touch.tap(PointOption.point(x1,y1)).release().perform();
	}

	//'===========================================================================================================
	//'Function Name       : enterValueInTextBox
	//'Description         : Function to enter value in text box
	//'============================================================================================================
	public boolean enterValueInTextBox(String text, By by) {
		boolean flag = false;
		try {
			if (driver.findElement(by).isDisplayed()) {
				driver.findElement(by).click();
				driver.findElement(by).clear();
				driver.findElement(by).sendKeys(text);
//				driver.hideKeyboard();
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}


	//'===========================================================================================================
	//'Function Name       : getElementText
	//'Description         : Function to get element text
	//'============================================================================================================
	public String getElementText(By by) {
		if (driver.findElement(by).isDisplayed()) {
			return driver.findElement(by).getText();
		} else {
			throw new ElementNotVisibleException("Element Not Found");
		}
	}

	//'===========================================================================================================
	//'Function Name       : setWait
	//'Description         : Function to set wait
	//'============================================================================================================
	public static void setWait(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.getStackTrace();
		}
	}

	//'===========================================================================================================
	//'Function Name       : selectListItem
	//'Description         : Function to select list item
	//'============================================================================================================
	public void selectListItem(By by, String item){
		Select dropDownList = new Select(driver.findElement(by));
		dropDownList.selectByVisibleText(item);
	}

	//'===========================================================================================================
	//'Function Name       : screenshot
	//'Description         : Function to take screenshot
	//'============================================================================================================
	public void screenshot(String path_screenshot) throws IOException {
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		String filename = Math.random()+"";
		File targetFile = new File(path_screenshot+filename+".jpg");
		FileUtils.copyFile(srcFile,targetFile);
	}

	//'===========================================================================================================
	//'Function Name       : scrollUptoDown
	//'Description         : Function to scroll from up to down using touch actions
	//'============================================================================================================
	public void scrollUptoDown(double startPercentage, double endPercentage, double anchorPercentage, int timeOut){
		Dimension size = driver.manage().window().getSize();
		int anchor = (int)(size.width*anchorPercentage);
		int start = (int)(size.height*startPercentage);
		int end = (int)(size.height*endPercentage);

		new TouchAction(driver)
				.press(PointOption.point(anchor,start))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOut)))
				.moveTo(PointOption.point(anchor,end)).release().perform();
	}

}
