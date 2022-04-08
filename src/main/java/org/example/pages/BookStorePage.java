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

  private final String url = "https://demoqa.com/books";

  @FindBy(id = "searchBox")
  private WebElement searchField;

  @FindBy(xpath = "//div[contains(@class, 'rt-tr -even') or contains(@class, 'rt-tr -odd')]")
  private List<WebElement> searchRows;

  @FindBy(css = ".rt-tbody [role='row']")
  private List<WebElement> rows;

  @FindBy(xpath = "//select")
  private WebElement countRowsSelect;

  @FindBy(css = ".-next")
  private WebElement nextButton;

  @FindBy(css = ".-previous")
  private WebElement previousButton;

  @FindBy(css = ".-pageJump input")
  private WebElement pageNumberInput;

  private final Menu menu;

  public BookStorePage(WebDriver driver) {
    super(driver);
    menu = new Menu(driver);
  }

  public BookStorePage openPage() {
    driver.get(url);
    return this;
  }

  public BookStorePage searching(String value) {
    searchField.clear();
    searchField.sendKeys(value);
    return this;
  }

  public BookStorePage selectRows(int number) {
    Select select = new Select(countRowsSelect);
    select.selectByValue(String.valueOf(number));
    return this;
  }

  public Integer getPageNumberInput() {
    return Integer.valueOf(pageNumberInput.getAttribute("value"));
  }
}
