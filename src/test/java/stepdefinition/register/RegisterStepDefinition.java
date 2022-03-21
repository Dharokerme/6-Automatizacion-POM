package stepdefinition.register;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import stepdefinition.setup.BaseTestPage;
import pages.homepage.HomePage;
import pages.registerpage.RegisterPage;

public class RegisterStepDefinition extends BaseTestPage {

    private static final Logger LOGGER = Logger.getLogger(RegisterStepDefinition.class);

    @Given("que el cliente entro a la pagina de registro")
    public void queElClienteEntroALaPaginaDeRegistro() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();
            HomePage homePage = new HomePage(driver,10);
            homePage.clickOnRegisterLink();
        } catch (Exception e) {
            LOGGER.error("Error en la ejecucion del test: " + e.getMessage());
            Assertions.fail("Error en la ejecucion del test: " + e.getMessage());
            quiteDriver();
        }
    }

    @When("llene el formulario correctamente.")
    public void lleneElFormularioCorrectamente() {
        try {
            RegisterPage registerPage = new RegisterPage(driver,10);
            registerPage.fillRegisterForm();


        } catch (Exception e) {
            LOGGER.error("Error en la ejecucion del test: " + e.getMessage());
            Assertions.fail("Error en la ejecucion del test: " + e.getMessage());
            quiteDriver();
        }
    }

    @Then("recibira un mensaje de cuenta creada correctamente.")
    public void recibiraUnMensajeDeCuentaCreadaCorrectamente() {
        try {
            RegisterPage registerPage = new RegisterPage(driver,10);
            Assertions.assertEquals("Your account was created successfully. You are now logged in.", registerPage.getTextFromWelcomeMessage());
            quiteDriver();

        } catch (Exception e) {
            LOGGER.error("Error en la ejecucion del test: " + e.getMessage());
            Assertions.fail("Error en la ejecucion del test: " + e.getMessage());
            quiteDriver();
        }

    }

    @When("llene el formulario incorrectamente.")
    public void lleneElFormularioIncorrectamente() {
        try {
            RegisterPage registerPage = new RegisterPage(driver,10);
            registerPage.passToRegisterButton();
        } catch (Exception e) {
            LOGGER.error("Error en la ejecucion del test: " + e.getMessage());
            Assertions.fail("Error en la ejecucion del test: " + e.getMessage());
            quiteDriver();
        }
    }

    @Then("recibira un mensaje con los datos a corregir.")
    public void recibiraUnMensajeConLosDatosACorregir() {
        try {
            RegisterPage registerPage = new RegisterPage(driver,10);
            Assertions.assertEquals(10, registerPage.getSizeErrorsMessage());
            quiteDriver();
        } catch (
                Exception e) {
            LOGGER.error("Error en la ejecucion del test: " + e.getMessage());
            Assertions.fail("Error en la ejecucion del test: " + e.getMessage());
            quiteDriver();
        }
    }
}
