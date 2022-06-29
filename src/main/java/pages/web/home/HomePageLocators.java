package pages.web.home;

import org.openqa.selenium.By;

public class HomePageLocators {

    protected static final By USER_ICON = By.xpath("//span/img[@alt='Основна світлина we_bubnii']");
    protected static final By SAVED_FROM_MENU = By.xpath("//div[text()='Збережено']");
    protected static final By SAVE_IMAGE_BUTTON = By.cssSelector("span._aamz > div > div > button > div._abm0._abl_ > svg");
    protected static final By NOT_SAVE_PERSONAL_INFO = By.xpath("//button[text()='Не зараз']");
    protected static final By LIKE_BUTTON = By.cssSelector("button > div._abm0._abl_ > span > svg");
    protected static final By COMMENT_BUTTON = By.cssSelector("button > div._abm0._abl_ > svg");
    protected static final By COMMENT_FIELD = By.cssSelector("div._aata > div > div > div._aasx > section._aaoe._aaso > div > form > textarea");
    protected static final By SEND_COMMENT_BUTTON = By.cssSelector("div._aata > div > div > div._aasx > section._aaoe._aaso > div > form > button > div");
    protected static final By CLOSE_COMMENT_WINDOW = By.cssSelector("div.o9tjht9c.jar9mtx6.mbzxb4f5.njoytozt > div > div > svg");
}