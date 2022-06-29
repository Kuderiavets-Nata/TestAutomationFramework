package pages.web.login;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import pages.web.base.BasePage;

import static pages.web.login.LoginPageLocators.*;

@Slf4j
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfUsernameTextBoxIsDisplayed() {
        return driver.findElement(USERNAME_TEXT_BOX).isDisplayed();
    }

    public boolean checkIfPasswordTextBoxIsDisplayed() {
        return driver.findElement(PASSWORD_TEXT_BOX).isDisplayed();
    }

    public boolean checkIfSubmitButtonIsDisplayed() {
        return driver.findElement(SUBMIT_BUTTON).isDisplayed();
    }

    public boolean checkIfLoginErrorMessageIsDisplayed() {
        return driver.findElement(LOGIN_ERROR_MASSAGE).isDisplayed();
    }

    @Step("Entering email address")
    public LoginPage enterlogin(String username) {
        log.info("Entering email address", username);
        waitUntilElementIsPresent(USERNAME_TEXT_BOX);
        driver.findElement(USERNAME_TEXT_BOX).clear();
        clearAndfillInFieldWith(USERNAME_TEXT_BOX, username);
        return this;
    }

    @Step("Entering password")
    public LoginPage enterPassword(String password) {
        log.info("Entering password");
        waitUntilElementIsPresent(PASSWORD_TEXT_BOX);
        driver.findElement(USERNAME_TEXT_BOX).clear();
        clearAndfillInFieldWith(PASSWORD_TEXT_BOX, password);
        return this;
    }


    @Step("Clicking on submit button")
    public LoginPage clickSubmitButton() {
        log.info("Clicking on submit button");
        waitUntilElementClickable(SUBMIT_BUTTON);
        clickElementBy(SUBMIT_BUTTON);
        return this;
    }

    @Step("Checking error message is displayed")
    public boolean CheckLoginErrorMassageIsDisplayed(String message) {
        try {
            log.info("Checking error message is displayed");
            Thread.sleep(500);
            String xmlFormat = driver.getPageSource();
            if (xmlFormat.contains(message)) {
                return true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

}



