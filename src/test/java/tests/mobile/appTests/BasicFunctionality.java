package tests.mobile.appTests;

import io.qameta.allure.Description;
import listeners.TestAllureListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import tests.mobile.base.BaseTest;

@Listeners({TestAllureListeners.class})
public class BasicFunctionality extends BaseTest {

    @Title("Like photo")
    @Description("Verify that photo can be liked")
    @Test(groups = {"Test"})
    public void CheckLikePhotoFunction() {
        homePage
                .LikePhoto();

        Assert.assertTrue(homePage.checkIfLikePressed(), "Photo not liked");

    }

    @Title("Leave Comment")
    @Description("Verify that photo can be liked")
    @Test(groups = {"Test"})
    public void CheckCommentFunction() {
        homePage
                .LeaveComment();

        Assert.assertTrue(homePage.checkIfLikePressed(), "Photo not liked");

    }

    @Title("Save photo")
    @Description("Verify that photo after saving appears at saved images page")
    @Test(groups = {"Test"})
    public void CheckSavePhotoFunction() {
        homePage.SaveImage()
                .GoToMyProfile();

        myProfilePage.GoToSavedImages()
                .ChickHome();

        Assert.assertTrue(homePage.checkIfHomePageSelected(), "You not on home page");


    }

    @Title("Open Stories and leve like")
    @Description("Verify that stories can be opened and user can press like")
    @Test(groups = {"Test"})
    public void OpenStoriesAndLike() {
        homePage.OpenStories()
                .LikeStories();


    }


}
