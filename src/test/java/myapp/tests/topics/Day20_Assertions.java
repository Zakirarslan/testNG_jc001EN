package myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day20_Assertions {

    /*
    In Junit we had only HARD ASSERTION
    In TestNG, we have two types of Assertions ==> HARD and SOFT
    HARD ASSERTION works with the same in TestNg as it works in JUnit

    SOFT ASSERTION is different in a sense that it doesn't stop executing the test if fails at any point
    It continues executing the test, and inform in the end which step the test failed at... ONLY IF WE USE assertAll() as a last step
    assertAll() is mandatory last step.
     */

    @Test
    public void hardAssert() {
        System.out.println("Checking how hard assertion works");
        Assert.assertTrue(true); //passes
        System.out.println("Line 12");
        Assert.assertTrue(false); // fails at this point.. so the rest of the test is not executed
        System.out.println("Line 14");
    }

    @Test (groups = "minor_regression_group")
    public void javaAssert() {
        /*
        Ths comes from Java library. It works the same way as HARD ASSERTION
        But we (testers) prefer TestNgG assertions, specially HARD ASSERTION
         */
        System.out.println("Line 34");
        assert 3 < 5; //pass
        System.out.println("Line 36");
        assert "Apple".toLowerCase().contains("a");
        System.out.println("Line 38");
        assert "apple".equals("apple"); //pass
        System.out.println("Line 40");
        assert "java".equals("selenium"); //fails
        System.out.println("Line 42"); //doesn't print
    }

    @Test
    public void softAssert() {
        /*
        If Soft Assertion fails at any step, it continues to execute the test steps
        1. Create Soft Assertion Object
        2. Use the Soft Assertion method such as assertEquals(), assertTrue() etc.
        3. Use assertAll() as a last step, otherwise you can't find out the test step failed or not
         */
        System.out.println("Line 29");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(5, 5); //passes
        System.out.println("Line 33");
        softAssert.assertTrue("Apple".toLowerCase().contains("a")); //pass
        System.out.println("Line 35");
        softAssert.assertEquals("apple", "orange"); //fail
        System.out.println("Line 37");
        softAssert.assertEquals("pineapple", "grapes"); //fail
        System.out.println("Line 39");
        softAssert.assertAll();
    }
}
