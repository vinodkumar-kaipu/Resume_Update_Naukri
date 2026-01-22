package tests;

import base.BaseTest;

import java.awt.AWTException;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;

public class ResumeUploadTest extends BaseTest {

    @Test
    public void uploadResumeTest() throws AWTException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.uploadResume();
    }
}


