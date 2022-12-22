package co.com.sofka.pages.overviewaccount;

import co.com.sofka.common.BasePageActions;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import co.com.sofka.pages.homepage.HomePage;

public class OverviewAccount extends BasePageActions {

    private static final Logger LOGGER = Logger.getLogger(HomePage.class);

    @FindBy(linkText = "Log Out")
    @CacheLookup
    private WebElement logout;

    public OverviewAccount(WebDriver driver, int waitTime) {
        super(driver, waitTime);
        pageFactoryInitElement(driver, this);

    }
    public boolean isLogoutDisplayed() {
        return isDisplayed(logout);
    }
}
