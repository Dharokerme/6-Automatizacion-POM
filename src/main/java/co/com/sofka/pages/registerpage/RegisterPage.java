package co.com.sofka.pages.registerpage;

import co.com.sofka.common.BasePageActions;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import co.com.sofka.util.NameListGenerator;

import java.util.List;


public class RegisterPage extends BasePageActions {

    private static final Logger logger = Logger.getLogger(RegisterPage.class);

    @FindBy(id = "customer.firstName")
    @CacheLookup
    private WebElement firstName;

    @FindBy(id = "customer.lastName")
    @CacheLookup
    private WebElement lastName;

    @FindBy(id = "customer.address.street")
    @CacheLookup
    private WebElement street;

    @FindBy(id = "customer.address.city")
    @CacheLookup
    private WebElement city;

    @FindBy(id = "customer.address.state")
    @CacheLookup
    private WebElement state;

    @FindBy(id = "customer.address.zipCode")
    @CacheLookup
    private WebElement zipCode;

    @FindBy(id = "customer.ssn")
    @CacheLookup
    private WebElement ssn;

    @FindBy(id = "customer.username")
    @CacheLookup
    private WebElement username;

    @FindBy(id = "customer.password")
    @CacheLookup
    private WebElement password;

    @FindBy(id = "repeatedPassword")
    @CacheLookup
    private WebElement repeatedPassword;

    @FindBy(xpath = "//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")
    @CacheLookup
    private WebElement registerButton;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"rightPanel\"]/p")
    private WebElement welcomeMessage;

    @CacheLookup
    @FindBy(xpath = ".//*[@class=\"error\"]")
    List<WebElement> allErrorElements;

    public RegisterPage(WebDriver driver, int waitTime) {
        super(driver, waitTime);
        pageFactoryInitElement(driver, this);
    }

    public void fillRegisterForm() throws InterruptedException {
        scrollOn(firstName);
        typeOnTextField(firstName, "Juan");
        scrollOn(lastName);
        typeOnTextField(lastName, "Cardona");
        scrollOn(street);
        typeOnTextField(street, "Calle 69# 7P Bis - 16");
        scrollOn(city);
        typeOnTextField(city, "Cali");
        scrollOn(state);
        typeOnTextField(state, "Valle del Cauca");
        scrollOn(zipCode);
        typeOnTextField(zipCode, "760001");
        scrollOn(ssn);
        typeOnTextField(ssn, "1152208813");
        scrollOn(username);
        typeOnTextField(username, NameListGenerator.generateName());
        scrollOn(password);
        typeOnTextField(password, "12345");
        scrollOn(repeatedPassword);
        typeOnTextField(repeatedPassword, "12345");
        scrollOn(registerButton);
        clickOnElement(registerButton);
    }

    public String getTextFromWelcomeMessage() {
        return getTextFromElement(welcomeMessage);
    }

    public void passToRegisterButton(){
        clickOnElement(registerButton);
    }

    public int getSizeErrorsMessage(){
        return allErrorElements.size();
    }
}

