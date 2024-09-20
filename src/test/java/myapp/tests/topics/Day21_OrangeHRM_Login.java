package myapp.tests.topics;

import myapp.pages.OrangeHRM_DashboardPage;
import myapp.pages.OrangeHRM_LoginPage;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day21_OrangeHRM_Login {

    // Automate login functionality, using page object model
    // https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
    // Given user is the application login page
    // Then enter the credentials
    // Then verify the login is successful
    // And logout the application
    // Then verify the logout is successful

    @Test
    public void loginTest(){
        // Given user is the application login page
        //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

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
        orangeHRMLoginPage.login("Admin", "admin123");

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
}
