package org.example.pages;

import lombok.Getter;
import org.example.pagecomponents.Menu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@Getter
public class BookStorePage extends BasePage {

  private final String url = reader.getProperty("url");
  private final Menu menu;
  @FindBy(id = "searchBox")
  private WebElement searchInput;
  @FindBy(xpath = "//div[contains(@class, 'rt-tr -even') or contains(@class, 'rt-tr -odd')]")
  private List<WebElement> searchResultRows;
  @FindBy(css = ".rt-tbody [role='row']")
  private List<WebElement> allRows;
  @FindBy(xpath = "//select")
  private WebElement numberOfRowsSelect;
  @FindBy(css = ".-next")
  private WebElement nextButton;
  @FindBy(css = ".-previous")
  private WebElement previousButton;
  @FindBy(css = ".-pageJump input")
  private WebElement currentTableNumberInput;

  public BookStorePage(WebDriver driver) {
    super(driver);
    menu = new Menu(driver);
  }

  public BookStorePage openPage() {
    driver.get(url);
    return this;
  }

  public BookStorePage search(String value) {
    searchInput.clear();
    searchInput.sendKeys(value);
    return this;
  }

  public BookStorePage selectNumberOfRows(int number) {
    Select select = new Select(numberOfRowsSelect);
    select.selectByValue(String.valueOf(number));
    return this;
  }

  public Integer getCurrentTableNumber() {
    return Integer.valueOf(currentTableNumberInput.getAttribute("value"));
  }
}
