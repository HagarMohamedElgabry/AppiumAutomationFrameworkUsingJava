# AppiumAutomationFrameworkUsingJava
 
## About AutomationFramework

Mobile Automation framework is a set of guidelines,or rules used to create and design automated test scripts.
They provide a generic automation framework that supports real devices (Ios and Android) devices**<BR/>

Automation Framework Implementations done the following:<BR/>
   1-  Parallel testing (Multiple devices - Android and iOS) (Real devices and Emulator/Simulator)<BR/>
   2-  Application used: https://github.com/saucelabs/sample-app-mobile/releases (V2.7.1)
   3-  ExtentReports V5.0.9<BR/>
   4-  User has options for customization<BR/>
   5-  Email to User(s) using Java mail API<BR/>
   6-  Retry failed test cases<BR/>
   7-  Custom Enums, Exceptions, Annotations<BR/>
   8-  Zip the ExtentReports directory into Project path (you can send this Zip file as well as an Attachment in Email)<BR/>
   9-  Automatically open the report after tests execution.<BR/>
   10- Start and Stop Appium Server programmatically<BR/>
   11- Videos for Failed test cases<BR/>
   12- Pass Test Data from JSON file<BR/>
   13- Pass Expected Data from XML file<BR/>
   14- Send EMail using Java mail API to User(s) with attachment(s).<BR/>

## Automation Framework Structure

## Table of Content:

+ [FrameWorkAnnotation class]
  - Metadata class for keeping basic information about the test such as: Category Level, Severity Level, etc.

+ [FrameWorkConstants class]
    - Constants are immutable values which are known at compile time and do not change for the life of the program.

+ [Base Page]
    - Wrapper class for UI Objects to simplify actions like click, scroll, type and wait for element to appear as we
      will share the different things to be used with the Page Object classes.

+ [Base Test]
    - Wrapper class for common function like setup , teardown, and we will extend all the test classes from this test
      base.

+ [enums Classes]
        - Will use interfaces classes that serve the purpose of representing a group of named constants of Test cases

+ [reports Classes]
        - Creating HTML reports Format using ExtentReports V5.0.9

+ [java_Mail_API Classes]
        - Will Send EMail using Java mail API to User(s) with attachment(s).

+ [listeners Classes]
        - Will use TestNG Listeners classes  that we have created in order to used them in testcases .


+ [utils Classes]
    - PropertyUtils : Class for reading any property file.
    - AppiumServerUtils : Class for Starting and Stopping Appium Server programmatically.
    - CapabilityUtils : Class is  responsible for setting all mobile capability
    - EmailSendUtils : Class  is  responsible for Sending  EMail using Java mail API to User(s) with attachment(s).
    - LogFormatter : Class provides color by using the ANSI escape codes.
    - JsonDataReader : Class is responsible for reading JSON file.
    - ScreenshotUtils: Class  responsible for Taking Screenshot.
    - TestUtils :  provides parseStringXML () the basic implementation of the Map interface of Java.
    - VideoRecordUtils : provides Videos for test cases
    - VerificationUtils : Class is responsible for validate results
    - ZipUtils : Class is  responsible for making Zip file  of automation reports.

+ [Pages  Classes]
  - build page objects and map activities of the mobile app.

+ [Test Cases Classes]
        - Will use Page Objects that we have created in order to write some basic UI tests.
        - We will navigate through a number of screens and verify that specific elements exist.
        - We will also do one functional test and verify all the elements.


+ [manager Classes]
        - Will use managers pages like dateTime,device,Platform and strings.

+ [config.properties]
        - User has options for customization.

+ [log4j2.properties]
        - integration with log4j2 to trigger logs.

+ [strings xml files]
        - Will use xml files for reading expected data.

+ [runners xml files]
        - How to run framework in order to run tests in parallel on different devices.

+ [app folder]
        - Will Put apps (apk and ipa files)

How to run the Project from Local machine:
 1- Pull the code into your machine and import in IDE (Eclipse/intelliJ).<BR/>
 2- Go to src/test/resources/runners testng_realDevice.xml -> Run this file as TestNG suite (you should have done the setup for Appium) It should start the execution -> Parallel Testing.


**Author:** _Hagar Abdelsamad Elgabry_ <BR/>
**LinkedIn Profile:** https://www.linkedin.com/in/hagar-el-gabry<BR/>
