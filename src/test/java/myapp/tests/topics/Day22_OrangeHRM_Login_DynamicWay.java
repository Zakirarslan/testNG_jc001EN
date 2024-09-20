package myapp.tests.topics;

import myapp.pages.OrangeHRM_DashboardPage;
import myapp.pages.OrangeHRM_LoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day22_OrangeHRM_Login_DynamicWay {

    // Automate login functionality, using page object model
    // https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
    // Given user is the application login page
    // Then enter the credentials
    // Then verify the login is successful
    // And logout the application
    // Then verify the logout is successful

    @Test
    public void loginTestDynamic() {
        // Given user is the application login page
        //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
        Driver.getDriver().get(ConfigReader.getProperty("orangeHRM_url"));

        // Then enter the credentials
        // Inorder to access the Webelements, we need to create Page Object.
        OrangeHRM_LoginPage orangeHRMLoginPage = new OrangeHRM_LoginPage();

//        orangeHRMLoginPage.username.sendKeys("Admin");
//        WaitUtils.waitFor(2); //HARD WAIT
//        orangeHRMLoginPage.password.sendKeys("admin123");
//        WaitUtils.waitFor(2); //HARD WAIT
//        orangeHRMLoginPage.loginButton.click();
//        WaitUtils.waitFor(2); //HARD WAIT

        //OR use REUSABLE METHOD:
        orangeHRMLoginPage.login(ConfigReader.getProperty("orangeHRM_username"), ConfigReader.getProperty("orangeHRM_password"));

        // Then verify the login is successful
        OrangeHRM_DashboardPage orangeHRMDashboardPage = new OrangeHRM_DashboardPage(); // create an object from page class
        Assert.assertTrue(orangeHRMDashboardPage.dropdown.isDisplayed());

        // And logout the application
        orangeHRMDashboardPage.dropdown.click();
        WaitUtils.waitFor(1);
        orangeHRMDashboardPage.logout.click();
        WaitUtils.waitFor(1);

        // Then verify the logout is successful
        Assert.assertTrue(orangeHRMLoginPage.username.isDisplayed());

        //Close the driver
        Driver.closeDriver();
    }

    @Test (groups = "minor_regression_group")
    public void loginTestDynamic_ReusableMethods() {
        // Given user is the application login page
        Driver.getDriver().get(ConfigReader.getProperty("orangeHRM_url"));

        // Then enter the credentials
        // Inorder to access the Webelements, we need to create Page Object.
        OrangeHRM_LoginPage orangeHRMLoginPage = new OrangeHRM_LoginPage();

        // Recommended way => USE Reusable method from Utils Class
        BrowserUtils.sendKeysWithTimeout(orangeHRMLoginPage.username, ConfigReader.getProperty("orangeHRM_username"), 1);
        BrowserUtils.sendKeysWithTimeout(orangeHRMLoginPage.password, ConfigReader.getProperty("orangeHRM_password"), 1);
        BrowserUtils.clickWithTimeOut(orangeHRMLoginPage.loginButton, 1);

        // Then verify the login is successful
        OrangeHRM_DashboardPage orangeHRMDashboardPage = new OrangeHRM_DashboardPage(); // create an object from page class
        BrowserUtils.verifyElementDisplayed(orangeHRMDashboardPage.dropdown); //use reusable method from Utils class

        // And logout the application
        BrowserUtils.clickWithTimeOut(orangeHRMDashboardPage.dropdown, 1);
        BrowserUtils.clickWithTimeOut(orangeHRMDashboardPage.logout, 1);

        // Then verify the logout is successful
        BrowserUtils.verifyElementDisplayed(orangeHRMLoginPage.username);

        //Close the driver
        Driver.closeDriver();
    }
}
