package tests.web.login.positive;

import org.testng.annotations.Test;
import tests.web.base.BaseTest;

public class LoginWithValidCredentials extends BaseTest {


    @Test(dataProvider = "loginValidCredentials")
    public void Login(String VALID_LOGIN, String VALID_PASSWORD) {
        loginPage
                .enterlogin(VALID_LOGIN)
                .enterPassword(VALID_PASSWORD)
                .clickToSubmit();
    }
}
