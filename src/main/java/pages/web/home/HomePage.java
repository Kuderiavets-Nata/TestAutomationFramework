package pages.web.home;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.web.base.BasePage;

import static pages.web.home.HomePageLocators.*;

@Slf4j
public class HomePage extends BasePage {

    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
    Actions actions = new Actions(driver);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfUserIconIsDisplayed() {
        waitUntilElementIsPresent(USER_ICON);
        return driver.findElement(USER_ICON).isDisplayed();
    }

    public boolean checkIfSavePersonalInfoIsDisplayed() {
        return driver.findElement(NOT_SAVE_PERSONAL_INFO).isDisplayed();
    }

    public boolean checkIfLikePresed() {
        return driver.findElement(LIKE_BUTTON).isEnabled();
    }

    public HomePage scrollDown() {
        javascriptExecutor.executeScript("window.scrollBy(0,250)", "");
        return this;
    }

    @Step("Refuse save personal info")
    public HomePage notSavePersonalInfo() {
        if (checkIfSavePersonalInfoIsDisplayed()) {
            log.info("Refusing to save personal info");
            clickElementBy(NOT_SAVE_PERSONAL_INFO);
        } else {
            log.info("Don't need to refuse");
        }
        return this;
    }

    @Step("Press like on photo")
    public HomePage likePhoto() {
        log.info("Pressing like on photo");
        clickElementBy(LIKE_BUTTON);
        return this;
    }

    @Step("Leave a comment")
    public HomePage LeaveComment() {
        log.info("Click comment button");
        clickElementBy(COMMENT_BUTTON);
        log.info("Click comment field");
        driver.findElement(COMMENT_FIELD).click();
        log.info("Leaving a comment");
        clearAndfillInFieldWith(COMMENT_FIELD, "Nice Picture!!");
        log.info("Click send a comment");
        clickElementBy(SEND_COMMENT_BUTTON);
        waitUntilElementClickable(COMMENT_FIELD);
        log.info("Closing comment window");
        clickElementBy(CLOSE_COMMENT_WINDOW);
        return this;
    }

    @Step("Click to save image")
    public HomePage saveImage() {
        log.info("Click to save image");
        clickElementBy(SAVE_IMAGE_BUTTON);
        return this;
    }

    @Step("Go to saved images page")
    public HomePage GoToSavedImages() {
        log.info("Click to user icon");
        clickElementBy(USER_ICON);
        log.info("Click to save image");
        clickElementBy(SAVED_FROM_MENU);
        return this;
    }


}
