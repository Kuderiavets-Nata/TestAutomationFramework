package pages.mobile.myProfile;

import org.openqa.selenium.By;

public class MyProfilePageLocators {

    protected static final By BURGER_MENU = By.xpath("//android.widget.Button[@content-desc='Параметри']");
    protected static final By GO_TO_SAVED_IMAGES = By.xpath("//android.widget.Button[@content-desc='Збережено']/android.view.ViewGroup");
    protected static final By SAVED_IMAGES_FOLDER = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.Button[1]/android.widget.FrameLayout");
    protected static final By HOME_BUTTON = By.xpath("//android.widget.FrameLayout[@content-desc='Головна']/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ImageView");

}
