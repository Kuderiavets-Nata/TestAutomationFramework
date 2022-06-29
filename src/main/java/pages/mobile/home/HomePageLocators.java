package pages.mobile.home;

import org.openqa.selenium.By;

public class HomePageLocators {

    protected static final By LIKE_IMAGE_BUTTON = By.xpath("//android.widget.ImageView[@content-desc='Подобається']");
    protected static final By COMMENT_IMAGE_BUTTON = By.xpath("//android.widget.ImageView[@content-desc='Коментар']");
    protected static final By SAVE_IMAGE_BUTTON = By.xpath("//android.widget.ImageView[@content-desc='Додати до збереженого']");
    protected static final By COMMENT_FIELD = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText");
    protected static final By SEND_COMMENT_BUTTON = By.xpath("//android.widget.Button[@content-desc='Опублікувати']/android.widget.TextView");
    protected static final By BACK_FROM_COMMENT_BUTTON = By.xpath("//android.widget.ImageView[@content-desc='Назад']");
    protected static final By MYPROFILE_BUTTON = By.xpath("//android.widget.FrameLayout[@content-desc='Профіль']/android.view.ViewGroup");
    protected static final By OPEN_STORIES_BUTTON = By.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc='reels_tray_container']/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View");
    protected static final By LIKE_STORIES_BUTTON = By.xpath("//android.widget.ImageView[@content-desc='Подобається']");

}
