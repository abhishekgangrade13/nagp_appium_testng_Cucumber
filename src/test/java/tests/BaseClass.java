package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import utils.ConfigFileReader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public AppiumDriver<MobileElement> driver;
    URL appiumURL = null;


    public AppiumDriver initializeDriver(){
        try{
            appiumURL = new URL("http://" +ConfigFileReader.getConfigPropertyVal("AppiumServer") +":" +ConfigFileReader.getConfigPropertyVal("AppiumPort") +"/wd/hub");
            this.driver = new AppiumDriver<MobileElement>(appiumURL, setAppCapabilities());
        }
        catch (Exception e){
            System.out.println("appiumURL: "+ appiumURL);
            System.out.println("setAppCapabilities :"+setAppCapabilities());
            System.out.println("messgae : "+e.getMessage());
            e.printStackTrace();
        }
        return driver;
    }

    public DesiredCapabilities setAppCapabilities(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("autoGrantPermissions", ConfigFileReader.getConfigPropertyVal("autoGrantPermissions"));
        caps.setCapability("deviceName", ConfigFileReader.getConfigPropertyVal("deviceName"));
        caps.setCapability("platformName", ConfigFileReader.getConfigPropertyVal("platformName"));
        caps.setCapability("platformVersion", ConfigFileReader.getConfigPropertyVal("platformVersion"));
        caps.setCapability("appPackage", ConfigFileReader.getConfigPropertyVal("appPackage"));
        caps.setCapability("appActivity", ConfigFileReader.getConfigPropertyVal("appActivity"));
        caps.setCapability("app", System.getProperty("user.dir")+"/"+ConfigFileReader.getConfigPropertyVal("app"));
        return caps;
    }

    public String takeScreenShotPath(String testCaseName,AppiumDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }

//    @BeforeTest
//    public void setUp() {
//        try{
//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setCapability("autoGrantPermissions", ConfigFileReader.getConfigPropertyVal("autoGrantPermissions"));
//            caps.setCapability("deviceName", ConfigFileReader.getConfigPropertyVal("deviceName"));
//            caps.setCapability("platformName", ConfigFileReader.getConfigPropertyVal("platformName"));
//            caps.setCapability("platformVersion", ConfigFileReader.getConfigPropertyVal("platformVersion"));
//            caps.setCapability("appPackage", ConfigFileReader.getConfigPropertyVal("appPackage"));
//            caps.setCapability("appActivity", ConfigFileReader.getConfigPropertyVal("appActivity"));
//            caps.setCapability("app", ConfigFileReader.getConfigPropertyVal("app"));
//
//            URL url = new URL("http://0.0.0.0:4723/wd/hub");
//
//            driver = new AppiumDriver<MobileElement>(url, caps);
//
//        }catch(Exception ex){
//            System.out.println("Message is : "+ex.getMessage());
//            ex.printStackTrace();
//        }
//    }
//
//    @AfterSuite
//    public void tearDown(){
//        driver.close();
//        driver.quit();
//    }

}
