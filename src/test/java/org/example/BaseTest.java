package org.example;

import org.example.pages.BookStorePage;
import org.example.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {

  protected WebDriver driver;
  protected BookStorePage bookStorePage;

  @BeforeTest
  public void beforeSuite() {
    driver = WebDriverUtils.setupWebDriver();
    bookStorePage = new BookStorePage(driver).openPage();
  }

  @AfterTest
  public void afterSuite() {
    driver.quit();
  }
}
