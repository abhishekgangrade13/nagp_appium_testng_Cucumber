package com.nagp.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.an.Y;
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
	public AndroidUtils(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Function to pause the execution for the specified time period
	 * 
	 * @param milliSeconds The wait time in milliseconds
	 */
	public void waitFor(long milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitUntilElementLocated(By by, long timeOutInSeconds){
		(new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitUntilElementVisible(By by, long timeOutInSeconds){
		(new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitUntilElementInVisible(By by, long timeOutInSeconds){
		(new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public void waitUntilElementEnabled(By by, long timeOutInSeconds){
		(new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.elementToBeClickable(by));
	}

	public void waitUntilElementDisabled(By by, long timeOutInSeconds){
		(new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(by)));
	}

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

	public void objectTap(By by) {
		TouchAction touch = new TouchAction(driver);
		WebElement ele = driver.findElement(by);
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(ele))).release().perform();
	}

	public void objectTabByCordinates(By by, int x, int y, String value) {
		TouchAction touch = new TouchAction(driver);
		WebElement ele = driver.findElement(by);
		ele.sendKeys(value);
		int x1 = ele.getLocation().getX() + x;
		int y1 = ele.getLocation().getY() + y;
		touch.tap(PointOption.point(x1,y1)).release().perform();
	}

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

	
	/**
	 * Function to get the text of an element. Ex : get title or header
	 * 
	 * param by  The {@link WebDriver} locator used to identify the
	 *                         element
	 * throwing Exception if element is not visible
	 */
	public String getElementText(By by) {
		if (driver.findElement(by).isDisplayed()) {
			return driver.findElement(by).getText();
		} else {
			throw new ElementNotVisibleException("Element Not Found");
		}
	}

	public static void setWait(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.getStackTrace();
		}
	}

	public void selectListItem(By by, String item){

		Select dropDownList = new Select(driver.findElement(by));
		dropDownList.selectByVisibleText(item);
	}

	public void screenshot(String path_screenshot) throws IOException {
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		String filename = Math.random()+"";
		File targetFile = new File(path_screenshot+filename+".jpg");
		FileUtils.copyFile(srcFile,targetFile);
	}

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
