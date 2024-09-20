package myapp.tests.extent_log4j_report;

import myapp.pages.BlueRental_Homepage;
import myapp.pages.BlueRental_LoginPage;

import myapp.utilities.*;

import org.testng.annotations.Test;

public class Day27_AdminLogin {

    /*
    ADD EXTENT REPORT CAPABILITY
    1. use createTestReport(String name,String description) first for creating extent report for this test
    2. Then use all methods to log the information on the extent report => pass,fail,info..
    3. Use flush() method in the end ... MANDATORY
     */

    /*
    ADD LOGGER CAPABILITY
    Use any methods from LoggerUtils
     */

    BlueRental_Homepage blueRentalHomepage = new BlueRental_Homepage();
    BlueRental_LoginPage blueRentalLoginPage = new BlueRental_LoginPage();

    @Test
    public void blueRentalLoginTest(){

        //
        LoggerUtils.info("Starting login test");

        //1.
        ExtentReportUtils.createTestReport("Smoke Test Report", "Login Function");

        //Given user is on the application home page https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("bluerental_url"));
        //2.
        ExtentReportUtils.info("User is logging on to https://www.bluerentalcars.com/");

        //Then clicks on login link
        //To click on the login, we need to create an object of the class where this element is stored
        BrowserUtils.clickWithTimeOut(blueRentalHomepage.userIcon,1);
        ExtentReportUtils.pass("clicks on login icon");

        //Then enters admin email, password
        //To type on the email, password we need to create an object of the class where these elements are stored
        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.email, ConfigReader.getProperty("bluerental_email"), 1);
        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.password, ConfigReader.getProperty("bluerental_password"), 1);
        //2.
        ExtentReportUtils.pass("user entered email and password successfully");

        //Then click on login button
        BrowserUtils.clickWithTimeOut(blueRentalLoginPage.loginButton,1);
        //2.
        ExtentReportUtils.passAndCaptureScreenshot("user clicked on log in button");

        //Then verify the login is successful
        BrowserUtils.verifyElementDisplayed(blueRentalHomepage.dropdown);
        //2.
        ExtentReportUtils.passAndCaptureScreenshot("user has logged in successfully");

        LoggerUtils.info("login is successful");

        //Then click logout
        BrowserUtils.clickWithTimeOut(blueRentalHomepage.dropdown, 1);
        BrowserUtils.clickWithTimeOut(blueRentalHomepage.logoutOption, 1);
        BrowserUtils.clickWithTimeOut(blueRentalHomepage.okOption, 1);

        //Verify logout is successful
        BrowserUtils.verifyElementDisplayed(blueRentalHomepage.userIcon);
        //2.
        ExtentReportUtils.passAndCaptureScreenshot("logout is successful");

        LoggerUtils.info("logout is successful");

        // Close the driver
        Driver.closeDriver();
        //2.
        ExtentReportUtils.pass("driver is closed");
        //3.
        ExtentReportUtils.flush();
    }
}
