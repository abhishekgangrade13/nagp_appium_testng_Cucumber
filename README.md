**Appium Cucumber Java Maven Project with Page Factory Design Pattern**
This is a _Maven project_ that demonstrates how to use the _Page Factory design pattern_ with Appium Driver in Java. The project uses _TestNG_ as the test framework.

**Setup**

**Prerequisites**
* Java 8 or later
* Maven 3 or later
* Nodejs 
* Android SDK()
* Appium Server

**Emulator**
* Pixel 4a API 30 (Android 11)

**Installation**
Clone the project or download it from repository or drive.

************************************************************
_To fetch the dependencies from Command line:_
Add maven path to the environment variables. 
Open a terminal or command prompt and navigate to the project directory
Run the following command to download the project dependencies:
Copy code
mvn clean install

**To run the tests using command line**
open a terminal or command prompt and navigate to the project directory. Then, run the following command:

Command - mvn clean test
************************************************************

*App* - App is stored at project path - src/test/resources/apps

_To fetch the dependencies from IDE:_
Open project in the IDE and update/reload project

**To test the grouping functionality, use tags**
//@Sanity @Regression, @CreateAccountScreen, @HomeApplyJobFeature, @AccountInfoFillScreen

**Extent Report**: The reports are stored in the Reports at the project path - /Result.

**Logs**: Logs are stored in the "logs" folder at the project path. We have stored logs in two separate log file, "App.logs" for application logs and
"ServerLogs.log" contains all the logs.

**Screenshots**: Screenshots are being captured for failures in "Screenshots" folder at the project path. /Result/ExtentReports/Screenshots 



