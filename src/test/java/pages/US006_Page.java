package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US006_Page {
    public US006_Page() {
        PageFactory.initElements(Driver.getDriver(),this );
    }
    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement signinSymbol;

    @FindBy(xpath = "//*[.='Sign in']")
    public WebElement signinButtonMainPage;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement userNameBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(css = "li[id='account-menu'] a[class='d-flex align-items-center dropdown-toggle nav-link'] span")
    public WebElement userNameField;

    @FindBy(xpath = "//span[normalize-space()='MY PAGES']")
    public WebElement myPagesLink;

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement accountMenu;

    @FindBy(xpath = "//li[@id='account-menu']//div[@role='menu']//a[1]")
    public WebElement settingsLink;

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement settingsFirstNameBox;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement settingsLastNameBox;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement settingsEmailBox;

    @FindBy(xpath = "//a[@class='dropdown-item']//span[text()='Sign out']")
    public WebElement signOutLink;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement settingsSubmitButton;

    @FindBy(xpath = "//button[text()='SIGN IN AGAIN']")
    public WebElement signInAgainButton;

}
