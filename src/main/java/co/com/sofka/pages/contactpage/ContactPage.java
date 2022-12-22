package co.com.sofka.pages.contactpage;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import co.com.sofka.common.BasePageActions;

import java.util.List;

public class ContactPage extends BasePageActions {

    private static Logger LOGGER = Logger.getLogger(ContactPage.class);


    @CacheLookup
    @FindBy(xpath = "//*[@id='rightPanel']/h1")
    private WebElement contactPageHeader;

    @CacheLookup
    @FindBy(id = "name")
    private WebElement nameField;

    //id="email"
    @CacheLookup
    @FindBy(id = "email")
    private WebElement emailField;
    //id="phone"
    @CacheLookup
    @FindBy(id = "phone")
    private WebElement phoneField;

    @CacheLookup
    @FindBy(id = "message")
    private WebElement messageField;

    @CacheLookup
    @FindBy(xpath = "//*[@id='contactForm']/table/tbody/tr[5]/td[2]/input")
    private WebElement sendButton;

    @CacheLookup
    @FindBy(xpath = "//*[@id='rightPanel']/p[2]")
    private WebElement successMessage;

    @CacheLookup
    @FindBy(xpath = ".//*[@class=\"error\"]")
    List<WebElement> allErrorElements;


    public ContactPage(WebDriver driver, int waitTime) {
        super(driver, waitTime);
        pageFactoryInitElement(driver, this);
    }

    public boolean isContactPageDisplayed() {
        return isDisplayed(contactPageHeader);
    }

    public void fillContactFields() {
        try {
            scrollOn(nameField);
            typeOnTextField(nameField, "Juancho");
            scrollOn(emailField);
            typeOnTextField(emailField, "juanes.cardona@hotmail.com");
            scrollOn(phoneField);
            typeOnTextField(phoneField, "123456789");
            scrollOn(messageField);
            typeOnTextField(messageField, "Hola, estoy interesado en una cotización");
            clickOnElement(sendButton);
        } catch (Exception e) {
            LOGGER.error("Error al llenar los campos de contacto");
        }
    }

    public boolean isSuccessMessageDisplayed() {
        return isDisplayed(successMessage);
    }

    public String getSuccessMessageText() {
        return getTextFromElement(successMessage);
    }

    public int getSizeErrorsMessage() {
        return allErrorElements.size();
    }

    public void justPressSendButton() {
        scrollOn(sendButton);
        clickOnElement(sendButton);
    }

}
