package myapp.tests.topics;

import org.testng.annotations.*;

public class Day20_Annotations {

    /*
    @Test: is the most used annotation to create test cases - just like Junit

    Hierarchy: suite > test > group > class > method ... this provides better control on the test flow

    @Ignore: used to ignore / skip a test
    @Test (enabled=false): disables the test; another way of ignoring the test method (this one is stronger)

    By default, tests run from top to bottom ... following ascending / alphabetical order
    So if we want to run any particular test first, we have the option to mention priority for test case

    @Test (priority = 3) will run this test case at number 3.

    We can also use negative numbers; but that's not common and recommended

    We can also group tests together by passing group = "name of the group" in @Test parameter to run all tests under one group
     */

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before suite ..");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class ..");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("Before groups ..");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before test ..");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method ..");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After suite .. ");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class .. ");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("After groups .. ");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After test .. ");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method .. ");
    }

    @Test(priority = 2)
    public void test1() {
        System.out.println("Test 1");
    }

    @Test
    @Ignore
    public void test2() {
        System.out.println("Test 2");
    }

    @Test(enabled = false)
    public void test3() {
        System.out.println("Test 3");
    }

    @Test(priority = 3)
    public void test4() {
        System.out.println("Test 4");
    }

    @Test(priority = 1)
    public void test5() {
        System.out.println("Test 5");
    }
}
