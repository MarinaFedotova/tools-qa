package org.example;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchFieldTest extends BaseTest {

  @DataProvider(name = "searchData")
  public Object[][] searchData() {
    return new Object[][] {
      {"Speaking JavaScript"}, {"Glenn Block et al."}, {"No Starch Press"},
    };
  }

  @Test(dataProvider = "searchData")
  public void searchFieldTest(String data) {
    boolean isContainsBook =
        bookStorePage.searching(data).getSearchRows().stream()
            .allMatch(row -> row.getText().contains(data));
    Assert.assertTrue(isContainsBook);
  }

  @AfterTest
  public void closeDriver() {
    driver.close();
  }
}
