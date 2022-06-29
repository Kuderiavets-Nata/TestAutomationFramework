package pages.web.login;

import org.openqa.selenium.By;

public class LoginPageLocators {

    protected static final By USERNAME_TEXT_BOX = By.name("username");
    protected static final By PASSWORD_TEXT_BOX = By.name("password");
    protected static final By SUBMIT_BUTTON = By.xpath("//button[@type='submit']");
    protected static final By LOGIN_ERROR_MASSAGE = By.id("slfErrorAlert");
}
