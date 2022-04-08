package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

  private static final String USER_NAME = "MarinaTest";

  @Test
  public void loginTest() {
    String actualLabel =
        bookStorePage.getMenu().openProfilePage().openLoginPage().login().getUserNameLabel();
    Assert.assertEquals(actualLabel, USER_NAME);
  }
}
