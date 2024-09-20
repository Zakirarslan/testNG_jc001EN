package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlueRental_Homepage {

    // 1. Create constructor and initiate PageFactory
    // 2 . Locate and store webElements

    public BlueRental_Homepage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (partialLinkText = "Login")
    public WebElement userIcon;

    @FindBy (id = "dropdown-basic-button")
    public WebElement dropdown;

    @FindBy (linkText = "Logout")
    public WebElement logoutOption;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement okOption;



}
