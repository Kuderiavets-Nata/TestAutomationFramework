package pages.mobile.home;

import io.qameta.allure.Step;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import pages.mobile.base.BasePage;

import static pages.mobile.home.HomePageLocators.*;


@Slf4j
public class HomePage extends BasePage {

    public boolean checkIFSaveImageButtonDisplayed() {
        return driver.findElement(SAVE_IMAGE_BUTTON).isDisplayed();
    }

    public boolean checkIfLikePressed() {
        return driver.findElement(LIKE_IMAGE_BUTTON).isEnabled();
    }

    public boolean checkIfHomePageSelected() {
        return driver.findElement(LIKE_IMAGE_BUTTON).isSelected();
    }

    @Step("Press like on photo")
    public HomePage LikePhoto() {
        log.info("Pressing like on photo");
        clickElementBy(LIKE_IMAGE_BUTTON);
        return this;
    }

    @SneakyThrows
    @Step("Leave a comment")
    public HomePage LeaveComment() {
        log.info("Click comment button");
        clickElementBy(COMMENT_IMAGE_BUTTON);
        log.info("Leaving a comment");
        clearAndfillInFieldWith(COMMENT_FIELD, "Nice Picture!!");
        log.info("Click send a comment");
        clickElementBy(SEND_COMMENT_BUTTON);
        Thread.sleep(15);
        log.info("Closing comment window");
        clickElementBy(BACK_FROM_COMMENT_BUTTON);
        return this;
    }

    @Step("Click to save image")
    public HomePage SaveImage() {
        log.info("Click to save image");
        clickElementBy(SAVE_IMAGE_BUTTON);
        return this;
    }

    @Step("Go to my profile page")
    public HomePage GoToMyProfile() {
        log.info("Click to user icon");
        clickElementBy(MYPROFILE_BUTTON);
        return this;
    }

    @Step("Open flowing users stories")
    public HomePage OpenStories() {
        log.info("Opening stories");
        clickElementBy(OPEN_STORIES_BUTTON);
        return this;
    }

    @Step("Press like on users stories")
    public HomePage LikeStories() {
        log.info("Like stories");
        clickElementBy(LIKE_STORIES_BUTTON);
        return this;
    }
}
