package tests.web.home;

import constants.Constant;
import dataProvider.FileReaderConfigs;
import io.qameta.allure.Description;
import listeners.TestAllureListeners;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import tests.web.base.BaseTest;

@Listeners({TestAllureListeners.class})
public class CheckBaseHomeFunctionality extends BaseTest {

    @BeforeTest
    public void login() {
        basePage.open(Constant.Urls.MAIN_PAGE);
        loginPage.enterlogin(new FileReaderConfigs().getValidUserName())
                .enterPassword(new FileReaderConfigs().getValidPassword())
                .clickSubmitButton();
        homePage
                .notSavePersonalInfo()
                .notSavePersonalInfo();
    }

    @Title("Like photo")
    @Description("Verify that photo can be liked")
    @Test(groups = {"Test"})
    public void CheckLikePhotoFunction() {
        homePage
                .likePhoto();

        Assert.assertTrue(homePage.checkIfLikePresed(), "Photo not liked");

    }


    @Title("Save photo")
    @Description("Verify that photo after saving appears at saved images page")
    @Test(groups = {"Test"})
    public void CheckSavePhotoFunction() {
        homePage.saveImage()
                .GoToSavedImages();

    }

    @Title("Leave Comment")
    @Description("Verify that photo can be liked")
    @Test(groups = {"Test"})
    public void CheckCommentFunction() {
        homePage
                .LeaveComment();

        Assert.assertTrue(homePage.checkIfLikePresed(), "Photo not liked");

    }
}
