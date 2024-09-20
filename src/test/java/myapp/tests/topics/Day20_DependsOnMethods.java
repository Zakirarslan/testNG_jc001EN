package myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day20_DependsOnMethods {

    // DependsOnMethods parameter is used to make tests dependent on each other
    // If the test (on which other tests are dependant) fails, the other tests will be skipped

    @Test
    public void homePageTest() {
        System.out.println("Home Page Test ..");
        Assert.assertTrue(false); //test fails at this step

    }

    @Test(dependsOnMethods = "homePageTest")
    public void searchTest() {
        System.out.println("Searching something ..");
        Assert.assertTrue(false); //test fails at this step
    }

    @Test(dependsOnMethods = "searchTest")
    public void checkOutTest() {
        System.out.println("User is checking out");
    }

}
