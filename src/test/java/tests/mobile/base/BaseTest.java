package tests.mobile.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    static AppiumDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        try {


            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            capabilities.setCapability(MobileCapabilityType.VERSION, "10 QKQ1.191215.002");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "M2003J6B2G");
            capabilities.setCapability(MobileCapabilityType.UDID, "34885ec");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
            capabilities.setCapability("appPackage", "com.instagram.android");
            capabilities.setCapability("appActivity", "com.instagram.mainactivity.LauncherActivity");

            URL appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AppiumDriver(appiumServerURL, capabilities);
        } catch (Exception exception) {
            System.out.println("Caused by" + exception.getCause());
            System.out.println("Message is" + exception.getMessage());
            exception.printStackTrace();
        }
    }

    @Test
    public void Test() {
        System.out.println("1234");
    }

    @AfterTest
    public void teardown() {
        driver.close();
        driver.quit();
    }
}
