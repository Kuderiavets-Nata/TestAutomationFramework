package tests.web.base;

import general.GeneralActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.web.base.BasePage;
import pages.web.home.HomePage;
import pages.web.login.LoginPage;
import pages.web.myProfile.MyProfilePage;

import static general.config.CLEAR_COOKIES_AND_STORAGE;
import static general.config.HOLD_BROWSER_OPEN;


public class BaseTest {
    protected WebDriver driver = GeneralActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected HomePage homePage = new HomePage(driver);
    protected MyProfilePage myProfilePage = new MyProfilePage(driver);

    @AfterTest
    public void clearCookiesAndLocalStorage() {

        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void close() {
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }

}
