package stepdefinition.homepage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import stepdefinition.setup.BaseTestPage;
import pages.homepage.HomePage;
import pages.overviewaccount.OverviewAccount;
import runners.HomePageTestCucumber;

public class HomePageStepDefinition extends BaseTestPage {

    private static final Logger LOGGER = Logger.getLogger(HomePageTestCucumber.class);

    @Given("que el cliente entro a pagina Home del banco")
    public void que_el_cliente_entro_a_pagina_home_del_banco() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

        } catch (Exception exception){
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }


    }
    @When("llene el username y password correctamente.")
    public void llene_el_username_y_password_correctamente() {
        try{
            HomePage homePage = new HomePage(driver,10);
            homePage.isHomePageDisplayed();
            homePage.sigInUsernameandPassword();

        } catch (Exception exception){
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }
    @Then("entrara a la cuenta overview.")
    public void entrara_a_la_cuenta_overview() {
        try {
            OverviewAccount overviewAccount = new OverviewAccount(driver,10);
            Assertions.assertTrue(overviewAccount.isLogoutDisplayed());
            quiteDriver();

        } catch (Exception exception){
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }

    @When("no escriba usuario y contrasena.")
    public void no_escriba_usuario_y_contrasena() {
        HomePage homePage = new HomePage(driver,10);
        homePage.isHomePageDisplayed();
        homePage.clickOnLogginButton();
    }
    @Then("recibira un mensaje de error")
    public void recibira_un_mensaje_de_error() {
        HomePage homePage = new HomePage(driver,10);
        Assertions.assertEquals("Please enter a username and password.", homePage.isErrorLoggin());
        quiteDriver();
    }
}
