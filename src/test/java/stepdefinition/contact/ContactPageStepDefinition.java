package stepdefinition.contact;

import stepdefinition.setup.BaseTestPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import co.com.sofka.pages.contactpage.ContactPage;
import co.com.sofka.pages.homepage.HomePage;
import runners.ContactPageTestCucumber;

public class ContactPageStepDefinition extends BaseTestPage {


    private static final Logger LOGGER = Logger.getLogger(ContactPageTestCucumber.class);

    @Given("que el cliente entro a pagina del Costumer Care")
    public void queElClienteEntroAPaginaDelCostumerCare() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();
            HomePage homePage = new HomePage(driver,3);
            homePage.clickOnContact();
        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }

    @When("llene el formulario correctamente")
    public void lleneElFormularioCorrectamente() {
        try {
            ContactPage contactPage = new ContactPage(driver,3);
            contactPage.fillContactFields();

        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }

    @Then("recibira un mensaje de pronto contacto")
    public void recibiraUnMensajeDeProntoContacto() {
        try {
            ContactPage contactPage = new ContactPage(driver,3);
            Assertions.assertTrue(contactPage.getSuccessMessageText().contains("A Customer Care Representative will be contacting you."));
            quiteDriver();
        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }

    @When("llene el formulario incorrectamente")
    public void lleneElFormularioIncorrectamente() {
        try {
            ContactPage contactPage = new ContactPage(driver,3);
            contactPage.justPressSendButton();

        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }

    @Then("recibira mensajes con los campos a corregir")
    public void recibiraMensajesConLosCamposACorregir() {
        try {
            ContactPage contactPage = new ContactPage(driver,3);
            Assertions.assertEquals(4, contactPage.getSizeErrorsMessage());
            quiteDriver();
        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }
}
