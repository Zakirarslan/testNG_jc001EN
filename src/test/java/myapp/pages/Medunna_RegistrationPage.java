package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Medunna_RegistrationPage {

    public Medunna_RegistrationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "ssn")
    public WebElement ssn;
    @FindBy (xpath = "//div[text()='Your SSN is invalid']")
    public WebElement invalidSsnMessage;
    @FindBy (xpath = "//div[text()='Your SSN is required.']")
    public WebElement ssnRequiredMessage;
    @FindBy(id = "firstName")
    public WebElement firstName;
    @FindBy (xpath = "//div[text()='Your FirstName is required.']")
    public WebElement firstNameRequiredMessage;
    @FindBy(id = "lastName")
    public WebElement lastName;
    @FindBy (xpath = "//div[text()='Your LastName is required.']")
    public WebElement lastNameRequiredMessage;
    @FindBy (id = "username")
    public WebElement username;
    @FindBy (xpath = "//div[text()='Your username is required.']")
    public WebElement userNameRequiredMessage;
    @FindBy (xpath = "//div[text()='Your username is invalid.']")
    public WebElement userNameInvalidMessage;
    @FindBy (id = "email")
    public WebElement email;
    @FindBy (xpath = "//div[text()='This field is invalid']")
    public WebElement emailInvalidMessage;
    @FindBy (xpath = "//div[text()='Your email is required.']")
    public WebElement emailRequiredMessage;



}
