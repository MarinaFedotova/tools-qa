package org.example.pagecomponents;

import org.example.pages.ProfilePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Menu extends BasePageComponent {

  @FindBy(xpath = "//span[text()='Profile']/..")
  private WebElement profileItem;

  public Menu(WebDriver driver) {
    super(driver);
  }

  public ProfilePage openProfilePage() {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", profileItem);
    profileItem.click();
    return new ProfilePage(driver);
  }
}
