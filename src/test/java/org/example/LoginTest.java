package org.example;

import io.qameta.allure.Owner;
import org.example.allureannotations.Suite;
import org.example.pages.LoginPage;
import org.example.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;

public class LoginTest extends BaseTest {

  private ProfilePage profilePage;
  private LoginPage loginPage;

  @Test(description = "Login check for 'tools-qa'")
  @Suite("Test")
  @Owner("Marina Fedotova")
  public void loginTest() {
    step("Open Profile page", () -> profilePage = bookStorePage.getMenu().openProfilePage());
    step("Click on the login link", () -> loginPage = profilePage.openLoginPage());
    step(
        "Enter login and password. Click the login button",
        () -> {
          String actualLogin = loginPage.login().getUserNameLabel();
          String expectedLogin = loginPage.getLogin();
          step(
              "The page displays the user's login",
              () -> Assert.assertEquals(actualLogin, expectedLogin));
        });
  }
}
