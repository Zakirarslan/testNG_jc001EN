package myapp.tests.medunna_practice;

import myapp.pages.Medunna_HomePage;
import myapp.pages.Medunna_RegistrationPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day24_US001 {

    /*
    US001: Registration should be available using SSN, Firstname and Lastname
            AC001: There should be a valid SSN respecting the "-" after 3rd and 5th digits, it should be 9 digits long
                AC001TC01: User enters the ssn 22255-5432, there should be "Your SSN is invalid" message
                AC001TC02: User enters the ssn 222-555432, there should be "Your SSN is invalid" message
                AC001TC03: User enters the ssn 222-55-543, there should be "Your SSN is invalid" message
                AC001TC04: User enters the ssn 222-55-543a, there should be "Your SSN is invalid" message
                AC001TC05: User enters the ssn 222-55-5432, there should not be any error message
            AC002: SSN cannot be left blank
                AC002TC01: User leaves the ssn blank, there should be "Your SSN is required." message
                AC002TC02: User enters the ssn only space, there should be "Your SSN is required." message
                AC002TC03: User enters the ssn 222-55-5432, there should not be any error message
            AC003: There should be a valid name that contains any chars and cannot be blank
                AC003TC01: User leaves the FirstName blank, there should be "Your FirstName is required." message
                AC003TC02: User enters the FirstName only space, there should be "Your FirstName is required." message
                AC003TC03: User enters the name that contains any chars, there should not be any error message
            AC004: There should be a valid lastname that contains any chars and it is a required field
                AC004TC01: User leaves the lastname blank, there should be "Your LastName is required." message
                AC004TC02: User enters the lastname only space, there should be "Your LastName is required." message
                AC004TC03: User enters the lastname that contains any chars, there should not be any error message
    ⇒ https://medunna.com/
 */

    Medunna_HomePage medunnaHomePage = new Medunna_HomePage();
    Medunna_RegistrationPage medunnaRegistrationPage = new Medunna_RegistrationPage();

    @BeforeTest
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));
        BrowserUtils.clickWithTimeOut(medunnaHomePage.userIcon, 2);
        BrowserUtils.clickWithTimeOut(medunnaHomePage.registerOption, 2);
    }

    //AC001: There should be a valid SSN respecting the "-" after 3rd and 5th digits, it should be 9 digits long
    @Test
    public void medunnaTest1() {
        //AC001TC01: User enters the ssn 22255-5432, there should be "Your SSN is invalid" message
        medunnaRegistrationPage.ssn.sendKeys("22255-5432", Keys.TAB);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.invalidSsnMessage);

        //AC001TC02: User enters the ssn 222-555432, there should be "Your SSN is invalid" message
        medunnaRegistrationPage.ssn.clear();
        medunnaRegistrationPage.ssn.sendKeys("222-555432", Keys.TAB);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.invalidSsnMessage);

        //AC001TC03: User enters the ssn 222-55-543, there should be "Your SSN is invalid" message
        medunnaRegistrationPage.ssn.clear();
        medunnaRegistrationPage.ssn.sendKeys("222-55-543", Keys.TAB);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.invalidSsnMessage);

        //AC001TC04: User enters the ssn 222-55-543a, there should be "Your SSN is invalid" message
        medunnaRegistrationPage.ssn.clear();
        medunnaRegistrationPage.ssn.sendKeys("222-55-543a", Keys.TAB);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.invalidSsnMessage);

        //AC001TC05: User enters the ssn 222-55-5432, there should not be any error message
        medunnaRegistrationPage.ssn.clear();
        medunnaRegistrationPage.ssn.sendKeys("222-55-5432", Keys.TAB);
        BrowserUtils.verifyElementNotDisplayed(medunnaRegistrationPage.invalidSsnMessage);
    }

    //AC002: SSN cannot be left blank
    @Test
    public void medunnaTest2() {
        //AC002TC01: User leaves the ssn blank, there should be "Your SSN is required." message
        //medunnaRegistrationPage.ssn.sendKeys("", Keys.TAB);
        medunnaRegistrationPage.ssn.sendKeys(Keys.TAB);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.ssnRequiredMessage);
        WaitUtils.waitFor(1);
        //AC002TC02: User enters the ssn only space, there should be "Your SSN is required." message
        //medunnaRegistrationPage.ssn.sendKeys(" ", Keys.TAB);
        medunnaRegistrationPage.ssn.sendKeys(Keys.SPACE);
        BrowserUtils.verifyExpectedAndActualTextMatch("Your SSN is required.", medunnaRegistrationPage.ssnRequiredMessage);
        WaitUtils.waitFor(1);
        //AC002TC03: User enters the ssn 222-55-5432, there should not be any error message
        medunnaRegistrationPage.ssn.clear();
        medunnaRegistrationPage.ssn.sendKeys("222-55-5432", Keys.TAB);
        BrowserUtils.verifyElementNotDisplayed(medunnaRegistrationPage.invalidSsnMessage);
        BrowserUtils.verifyElementNotDisplayed(medunnaRegistrationPage.ssnRequiredMessage);
        WaitUtils.waitFor(1);
    }

    //AC003: There should be a valid name that contains any chars and cannot be blank
    @Test
    public void medunnaTest3() {
        //AC003TC01: User leaves the FirstName blank, there should be "Your FirstName is required." message
        medunnaRegistrationPage.firstName.sendKeys("", Keys.TAB);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.firstNameRequiredMessage);
        WaitUtils.waitFor(1);
        //AC003TC02: User enters the FirstName only space, there should be "Your FirstName is required." message
        medunnaRegistrationPage.firstName.sendKeys(" ", Keys.TAB);
        //BrowserUtils.verifyExpectedAndActualTextMatch("Your FirstName is required.", medunnaRegistrationPage.firstNameRequiredMessage);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.firstNameRequiredMessage);
        WaitUtils.waitFor(1);
        //AC003TC03: User enters the name that contains any chars, there should not be any error message
        medunnaRegistrationPage.firstName.clear();
        medunnaRegistrationPage.firstName.sendKeys("Isa");
        BrowserUtils.verifyElementNotDisplayed(medunnaRegistrationPage.firstNameRequiredMessage);
    }

    //AC004: There should be a valid lastname that contains any chars and it is a required field
    @Test
    public void medunnaTest4(){
        //AC004TC01: User leaves the lastname blank, there should be "Your LastName is required." message
        medunnaRegistrationPage.lastName.sendKeys(Keys.TAB);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.lastNameRequiredMessage);
        WaitUtils.waitFor(1);
        //AC004TC02: User enters the lastname only space, there should be "Your LastName is required." message
        medunnaRegistrationPage.lastName.sendKeys(" ", Keys.TAB);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.lastNameRequiredMessage);
        WaitUtils.waitFor(1);
        //AC004TC03: User enters the lastname that contains any chars, there should not be any error message
        medunnaRegistrationPage.lastName.clear();
        medunnaRegistrationPage.lastName.sendKeys("Zakir");
        BrowserUtils.verifyElementNotDisplayed(medunnaRegistrationPage.lastNameRequiredMessage);
    }

    @AfterTest
    public void closeDriver(){
        Driver.closeDriver();
    }
}














