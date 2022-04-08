package org.example.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage extends BasePage {

  private final String login = reader.getProperty("user.login");
  private final String password = reader.getProperty("user.password");

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
    loginInput.sendKeys(login);
    passwordInput.sendKeys(password);
    loginButton.click();
    return new ProfilePage(driver);
  }
}
