package pages.mobile.myProfile;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import pages.mobile.base.BasePage;

import static pages.mobile.myProfile.MyProfilePageLocators.*;

@Slf4j
public class MyProfilePage extends BasePage {

    @Step("Go to saved images page")
    public MyProfilePage GoToSavedImages() {
        log.info("Click on burger menu");
        clickElementBy(BURGER_MENU);
        log.info("Click to saved images button");
        clickElementBy(GO_TO_SAVED_IMAGES);
        log.info("Click to saved images folder ");
        clickElementBy(SAVED_IMAGES_FOLDER);
        return this;
    }

    @Step("Back to the home page")
    public MyProfilePage ChickHome() {
        log.info("Click on home button");
        clickElementBy(HOME_BUTTON);
        return this;
    }
}
