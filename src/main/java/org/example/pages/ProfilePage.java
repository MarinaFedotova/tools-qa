package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends BasePage {

  @FindBy(xpath = "//a[text()='login']")
  private WebElement loginLink;

  @FindBy(css = "#userName-value")
  private WebElement userNameLabel;

  public ProfilePage(WebDriver driver) {
    super(driver);
  }

  public LoginPage openLoginPage() {
    loginLink.click();
    return new LoginPage(driver);
  }

  public String getUserNameLabel() {
    new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOf((userNameLabel)));
    return userNameLabel.getText();
  }
}
