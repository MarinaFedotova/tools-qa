package org.example;

import io.qameta.allure.Owner;
import org.example.allureannotations.Suite;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;

public class SearchFieldTest extends BaseTest {

  private boolean isActualContainsBook;

  @DataProvider(name = "searchData")
  public Object[][] searchData() {
    return new Object[][] {
      {"Speaking JavaScript", "title"},
      {"Glenn Block et al.", "author"},
      {"No Starch Press", "publisher"},
    };
  }

  @Test(description = "Check search on BookStore page", dataProvider = "searchData")
  @Suite("Test")
  @Owner("Marina Fedotova")
  public void searchFieldTest(String data, String columnName) {
    step(
        String.format("In the search enter any %s of the book", columnName),
        () -> {
          isActualContainsBook =
              bookStorePage.search(data).getSearchResultRows().stream()
                  .allMatch(row -> row.getText().contains(data));
          step("Books are displayed in a table", () -> Assert.assertTrue(isActualContainsBook));
        });
  }

  @AfterTest
  public void closeDriver() {
    driver.close();
  }
}
