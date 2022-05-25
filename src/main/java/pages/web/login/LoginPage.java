package pages.web.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.web.base.BasePage;

public class LoginPage extends BasePage {

    private final By usernameTextBox = By.name("username");
    private final By passwordTextBox = By.name("password");
    private final By submitButton = By.xpath("//button[@type='submit']");
    private final By loginErrorMassage = By.id("slfErrorAlert");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterlogin(String username) {

        driver.findElement(usernameTextBox).click();
        driver.findElement(usernameTextBox).sendKeys(username);

        return this;
    }

    public LoginPage enterPassword(String password) {

        driver.findElement(passwordTextBox).click();
        driver.findElement(passwordTextBox).sendKeys(password);

        return this;
    }

    public LoginPage clickToSubmit() {

        WebElement submitBnt = driver.findElement(submitButton);
        waitElementVisible(submitBnt).click();

        return this;
    }

    public void CheckLoginErrorMassageIsDisplayed() {

        Assert.assertTrue(driver.findElement(loginErrorMassage).isDisplayed());

    }
}



