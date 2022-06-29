package tests.web.login;

import constants.Constant;
import dataProvider.FileReaderConfigs;
import io.qameta.allure.Description;
import listeners.TestAllureListeners;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import tests.web.base.BaseTest;

@Listeners({TestAllureListeners.class})
public class LoginTest extends BaseTest {

    @BeforeMethod
    public void openBrowser() {
        basePage.open(Constant.Urls.MAIN_PAGE);
    }

    @Title("Basic validation login page")
    @Description("Verify basic validation login page")
    @Test(groups = {"Test"})
    public void loginPageBasicValidation() {
        Assert.assertTrue(loginPage.checkIfUsernameTextBoxIsDisplayed(), "Email field is not present");
        Assert.assertTrue(loginPage.checkIfPasswordTextBoxIsDisplayed(), "Password field is not present");
        Assert.assertTrue(loginPage.checkIfSubmitButtonIsDisplayed(), "Submit button is not present");
    }


    @Title("Login with invalid credentials")
    @Description("Verify login is unsuccessful credentials")
    @Test(groups = {"Test"})
    public void loginIsSuccessfulWithInvalidCredentials() {
        loginPage.enterlogin(new FileReaderConfigs().getInvalidUserName())
                .enterPassword(new FileReaderConfigs().getInvalidPassword())
                .clickSubmitButton();
        Assert.assertTrue(loginPage.checkIfLoginErrorMessageIsDisplayed(), "Credentials invalid");
    }


    @Title("Login with correct credentials")
    @Description("Verify login is successful with valid credentials")
    @Test(groups = {"Test"})
    public void loginIsSuccessfulWithCorrectCredentials() {
        loginPage.enterlogin(new FileReaderConfigs().getValidUserName())
                .enterPassword(new FileReaderConfigs().getValidPassword())
                .clickSubmitButton();

        Assert.assertTrue(homePage.checkIfSavePersonalInfoIsDisplayed(), "User Icon button is missing");
    }
}
