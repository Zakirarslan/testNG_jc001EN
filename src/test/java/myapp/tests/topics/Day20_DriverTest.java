package myapp.tests.topics;

import myapp.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day20_DriverTest {

// Go to amazon page
// Verify the title includes amazon
// Check if Driver class is working

    @Test
    public void driverTest() throws InterruptedException {
        // driver.get("https://www.amazon.com/"); //we were calling driver from TestBase class in Junit framework

        Driver.getDriver().get("https://www.amazon.com/");
        Thread.sleep(2000);
        Driver.getDriver().navigate().refresh(); // to get rid of captcha

        Thread.sleep(3000);
        String title = Driver.getDriver().getTitle();
        System.out.println("title = " + title);
        Assert.assertTrue(title.contains("Amazon"));

        Driver.closeDriver();
    }
}
