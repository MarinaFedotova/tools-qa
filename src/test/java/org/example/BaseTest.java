package org.example;

import org.example.pages.BookStorePage;
import org.example.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static io.qameta.allure.Allure.step;

public class BaseTest {

  protected WebDriver driver;
  protected BookStorePage bookStorePage;

  @BeforeTest
  public void beforeSuite() {
    driver = WebDriverUtils.setupWebDriver();
    step("Open BookStore page", () -> bookStorePage = new BookStorePage(driver).openPage());
  }

  @AfterTest
  public void afterSuite() {
    driver.quit();
  }
}
