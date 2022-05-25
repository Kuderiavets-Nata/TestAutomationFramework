package tests.web.login.negative;

import constants.Constant;
import org.testng.annotations.Test;
import tests.web.base.BaseTest;

public class LoginWithInvalidCredentials extends BaseTest {

    @Test
    public void LoginWithInvalidLoginAndPassword() {
        basePage.open(Constant.Urls.MAIN_PAGE);

        loginPage
                .enterlogin(Constant.LoginCredentials.INVALID_LOGIN)
                .enterPassword(Constant.LoginCredentials.INVALID_PASSWORD)
                .clickToSubmit()
                .CheckLoginErrorMassageIsDisplayed();

    }
}
