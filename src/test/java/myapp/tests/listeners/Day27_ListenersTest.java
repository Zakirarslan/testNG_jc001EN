package myapp.tests.listeners;

import myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class Day27_ListenersTest {

    /*
    We can add Listeners capability forTest Methods in two way:
    1. By using @Listeners in the Test class
    2. Through xml file =>> RECOMMENDED WAY
     */

    @Test
    public void listenerTest1() {
        Driver.getDriver().get("https://www.techproeducation.com/");
        String title = Driver.getDriver().getTitle();
        System.out.println("Test 1 title = " + title);
        Assert.assertTrue(title.contains("TechPro Education IT Programs")); //pass
    }

    @Test
    public void listenerTest2() {
        Driver.getDriver().get("https://www.amazon.com/");
        Driver.getDriver().navigate().refresh();
        String title = Driver.getDriver().getTitle();
        System.out.println("Test 2 title = " + title);
        Assert.assertTrue(title.contains("amazon")); //fail
    }

    @Test
    public void listenerTest3() {
        System.out.println("Test 3 SKIPPED");
        throw new SkipException("Skipping Test"); //skipped
    }

    @Test
    public void listenerTest4() {
        Driver.getDriver().get("https://www.google.com/");
        String title = Driver.getDriver().getTitle();
        System.out.println("Test 4 title = " + title);
        System.out.println("This is test4 and it is meant to fail");
        Driver.getDriver().findElement(By.id("wrong_id")).sendKeys("Iphone 16"); // test will fail here and throw NoSuchElement Exception
    }
}






















