package stepdefinition.homepage;

import stepdefinition.setup.BaseTestPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import co.com.sofka.pages.homepage.HomePage;
import co.com.sofka.pages.overviewaccount.OverviewAccount;
import runners.HomePageTestCucumber;

public class HomePageStepDefinition extends BaseTestPage {

    private static final Logger LOGGER = Logger.getLogger(HomePageTestCucumber.class);

    @Given("que el cliente entro a pagina Home del banco")
    public void que_el_cliente_entro_a_pagina_home_del_banco() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }


    }

    @When("llene el username y password correctamente.")
    public void llene_el_username_y_password_correctamente() {
        try {
            HomePage homePage = new HomePage(driver, 3);
            homePage.isHomePageDisplayed();
            homePage.sigInUsernameandPassword();

        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }

    @Then("entrara a la cuenta overview.")
    public void entrara_a_la_cuenta_overview() {
        try {
            OverviewAccount overviewAccount = new OverviewAccount(driver, 3);
            Assertions.assertTrue(overviewAccount.isLogoutDisplayed());
            quiteDriver();

        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }

    @When("no escriba usuario y contrasena.")
    public void no_escriba_usuario_y_contrasena() {
        try {
            HomePage homePage = new HomePage(driver, 3);
            homePage.isHomePageDisplayed();
            homePage.clickOnLogginButton();
        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }

    @Then("recibira un mensaje de error")
    public void recibira_un_mensaje_de_error() {
        try {
            HomePage homePage = new HomePage(driver, 3);
            Assertions.assertEquals("Please enter a username and password.", homePage.isErrorLoggin());
            quiteDriver();
        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }
}
