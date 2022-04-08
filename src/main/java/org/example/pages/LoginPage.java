package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

  private static final String MENU_ITEM = "Profile";

  private final String name = "MarinaTest";
  private final String password = "test123T#";

  @FindBy(id = "userName")
  private WebElement loginInput;

  @FindBy(id = "password")
  private WebElement passwordInput;

  @FindBy(id = "login")
  private WebElement loginButton;

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public ProfilePage login() {
    loginInput.sendKeys(name);
    passwordInput.sendKeys(password);
    loginButton.click();
    return new ProfilePage(driver);
  }
}
