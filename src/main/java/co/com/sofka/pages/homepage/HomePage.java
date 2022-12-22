package co.com.sofka.pages.homepage;

import co.com.sofka.common.BasePageActions;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePageActions {

    private static final Logger LOGGER = Logger.getLogger(HomePage.class);

    //Localizadores con PageFactory

    @CacheLookup
    @FindBy(name = "username")
    private WebElement name;

    @CacheLookup
    @FindBy(name = "password")
    private WebElement password;

    @CacheLookup
    @FindBy(xpath = "//*[@value='Log In']")
    private WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//a[contains(@href,'register.htm')]")
    private WebElement registerLink;

    @CacheLookup
    @FindBy(xpath = "//a[contains(@href,'contact.htm')]")
    private WebElement contactLink;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"topPanel\"]")
    private WebElement topPanel;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"rightPanel\"]/p")
    private WebElement assertErrorLoggin;

    public HomePage(WebDriver driver, int seconds) {
        super(driver, seconds);
        pageFactoryInitElement(driver, this);
    }

    public void sigInUsernameandPassword() {
        typeOnTextField(name, "carlos");
        typeOnTextField(password, "1234");
        clickOnElement(loginButton);
    }

    public void clickOnLogginButton() {
        clickOnElement(loginButton);
    }

    public String isErrorLoggin(){
        return getTextFromElement(assertErrorLoggin);
    }

    public void clickOnRegisterLink(){
        clickOnElement(registerLink);
    }

    public void clickOnContact(){
        clickOnElement(contactLink);
    }

    public void isHomePageDisplayed(){
        isDisplayed(topPanel);
    }
}


