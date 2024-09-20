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

public class Day24_US002 {

    /*
    US002: Registration should be successful using email and username
        US002AC01: Choose a username that can contain any chars, but it cannot be blank
            US002AC01TC01: User leaves the username blank, there should be "Your username is required." error message
            US002AC01TC02: User enters username special chars(£#$€), there should be "Your username is invalid." error message
            US002AC01TC03: User enters username  that can contain any chars, there should not be any error message
        US002AC02: email id cannot be created without "@" sign and "." extension
            US002AC02TC01: User enters the email as "johndoe.com", there should be "This field is invalid" error message
            US002AC02TC02: User enters the email as "john@doecom", there should be "This field is invalid" error message
            US002AC02TC03: User enters the email as "john@doe.", there should be "This field is invalid" error message
            US002AC02TC04: User enters the email as "@doe.com", there should be "This field is invalid" error message
            US002AC03TC05: User enters the email as "john@doe.com", there should not be any error message
        US002AC03: email cannot be left blank
            US002AC03TC01: User leaves the email blank, there should be "Your email is required." error message
            US002AC03TC02: User enters the email as "john@doe.com", there should not be any error message
     */
    Medunna_HomePage medunnaHomePage = new Medunna_HomePage();
    Medunna_RegistrationPage medunnaRegistrationPage =  new Medunna_RegistrationPage();

    @BeforeTest
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));
        BrowserUtils.clickWithTimeOut(medunnaHomePage.userIcon, 2);
        BrowserUtils.clickWithTimeOut(medunnaHomePage.registerOption, 2);
    }

    @AfterTest
    public void closeDriver(){
        Driver.closeDriver();
    }

    //US002AC01: Choose a username that can contain any chars, but it cannot be blank
    @Test
    public void medunna1(){
        //US002AC01TC01: User leaves the username blank, there should be "Your username is required." error message
        medunnaRegistrationPage.username.sendKeys(Keys.TAB);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.userNameRequiredMessage);
        WaitUtils.waitFor(1);
        //US002AC01TC02: User enters username special chars(£#$€), there should be "Your username is invalid." error message
        medunnaRegistrationPage.username.sendKeys("£#$€", Keys.TAB);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.userNameInvalidMessage);
        WaitUtils.waitFor(1);
        //US002AC01TC03: User enters username  that can contain any chars, there should not be any error message
        medunnaRegistrationPage.username.clear();
        medunnaRegistrationPage.username.sendKeys("Techpro",Keys.TAB);
        BrowserUtils.verifyElementNotDisplayed(medunnaRegistrationPage.userNameRequiredMessage);
        BrowserUtils.verifyElementNotDisplayed(medunnaRegistrationPage.userNameInvalidMessage);
        WaitUtils.waitFor(1);
    }

    // US002AC02: email id cannot be created without "@" sign and "." extension
    @Test
    public void medunna2(){
        //US002AC02TC01: User enters the email as "johndoe.com", there should be "This field is invalid" error message
        medunnaRegistrationPage.email.sendKeys("johndoe.com",Keys.TAB);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.emailInvalidMessage);
        WaitUtils.waitFor(1);
        //US002AC02TC02: User enters the email as "john@doecom", there should be "This field is invalid" error message
        medunnaRegistrationPage.email.clear();
        medunnaRegistrationPage.email.sendKeys("john@doecom", Keys.TAB);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.emailInvalidMessage);
        WaitUtils.waitFor(1);
        //US002AC02TC03: User enters the email as "john@doe.", there should be "This field is invalid" error message
        medunnaRegistrationPage.email.clear();
        medunnaRegistrationPage.email.sendKeys("john@doe.", Keys.TAB);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.emailInvalidMessage);
        WaitUtils.waitFor(1);
        //US002AC02TC04: User enters the email as "@doe.com", there should be "This field is invalid" error message
        medunnaRegistrationPage.email.clear();
        medunnaRegistrationPage.email.sendKeys("@doe.com", Keys.TAB);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.emailInvalidMessage);
        WaitUtils.waitFor(1);
        //US002AC03TC05: User enters the email as "john@doe.com", there should not be any error message
        medunnaRegistrationPage.email.clear();
        medunnaRegistrationPage.email.sendKeys("john@doe.com", Keys.TAB);
        BrowserUtils.verifyElementNotDisplayed(medunnaRegistrationPage.emailInvalidMessage);
        WaitUtils.waitFor(1);
    }

    //US002AC03: email cannot be left blank
    @Test
    public void medunna3(){
        //US002AC03TC01: User leaves the email blank, there should be "Your email is required." error message
        WaitUtils.waitFor(3);
        medunnaRegistrationPage.email.clear();
        medunnaRegistrationPage.email.sendKeys("", Keys.ENTER);
        WaitUtils.waitFor(1);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.emailRequiredMessage);
        WaitUtils.waitFor(1);
        //US002AC03TC02: User enters the email as "john@doe.com", there should not be any error message
        medunnaRegistrationPage.email.sendKeys("john@doe.com", Keys.TAB);
        BrowserUtils.verifyElementNotDisplayed(medunnaRegistrationPage.emailInvalidMessage);
      //  BrowserUtils.verifyElementNotDisplayed(medunnaRegistrationPage.emailRequiredMessage);
        WaitUtils.waitFor(1);
    }



}
