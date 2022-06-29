package pages.mobile.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;

import static constants.Constant.Timeouts.FLUENT_WAIT_INTERVAL;

public class BasePage {
    public static AppiumDriverLocalService service;
    public static AppiumDriver<MobileElement> driver;

    public static AppiumDriverLocalService startAppiumServer() {
        boolean flag = checkIfServerIsRunning(4723);
        if (!flag) {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;

    }


    public static boolean checkIfServerIsRunning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);

            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }


    public static AppiumDriver<MobileElement> setup() {
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
        return driver;
    }

    public static void stopAppiumServer() {
        service.stop();
        System.out.println("Server is stopped successfully");

    }

    public static void clickElementBy(By by) {
        tryFindElement(by).click();
    }

    public static void clearAndfillInFieldWith(By by, String text) {
        tryFindElement(by).clear();
        tryFindElement(by).sendKeys(text);
    }

    public static WebElement tryFindElement(By by) {

        return (WebElement) getFluentWait().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static String getTextFromElement(By by) {
        return tryFindElement(by).getText().trim();
    }

    public static int getNumberOfResultsForElement(By by) {
        return driver.findElements(by).size();
    }

    public static Wait getFluentWait() {

        return new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(FLUENT_WAIT_INTERVAL))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    public static boolean waitUntilElementIsPresent(By by) {
        try {
            getFluentWait().until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
}
