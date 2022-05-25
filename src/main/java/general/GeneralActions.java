package general;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import java.time.Duration;

import static constants.Constant.Timeouts.FOUR_SEC_WAIT;
import static general.config.BROWSER_TYPE;

public class GeneralActions {
    public static WebDriver createDriver() {
        WebDriver driver = null;
        switch (BROWSER_TYPE) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            default:
                Assert.fail("No such browser" + BROWSER_TYPE);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FOUR_SEC_WAIT));
        return driver;
    }
}
