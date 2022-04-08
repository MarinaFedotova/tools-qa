package org.example.pages;

import org.example.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

  protected PropertiesReader reader = new PropertiesReader("conf.properties");
  protected WebDriver driver;

  public BasePage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }
}
