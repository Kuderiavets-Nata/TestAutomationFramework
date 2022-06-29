package tests.mobile.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import listeners.TestAllureListeners;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import pages.mobile.base.BasePage;
import pages.mobile.home.HomePage;
import pages.mobile.myProfile.MyProfilePage;

@Slf4j
@Listeners({TestAllureListeners.class})
public class BaseTest extends BasePage {

    public static AppiumDriver<MobileElement> driver;
    protected BasePage basePage = new BasePage();
    protected HomePage homePage = new HomePage();
    protected MyProfilePage myProfilePage = new MyProfilePage();

    @BeforeTest(alwaysRun = true)
    public static void setUpBrowser() {
        log.info("Open Browser");
        startAppiumServer();
        setup();
    }

    @AfterTest(alwaysRun = true)
    public static void tearDown() {
        log.info("Closing Browser");
        driver.quit();
        stopAppiumServer();
    }
}
