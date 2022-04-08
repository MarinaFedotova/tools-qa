package org.example;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DropDownListTest extends BaseTest {

  private List<Integer> expectedCountRows;
  private final SoftAssert softAssert = new SoftAssert();

  @BeforeTest
  public void initialData() {
    expectedCountRows = List.of(5, 10, 20, 25, 50, 100);
  }

  @Test
  public void dropDownListTest() {
    expectedCountRows
        .forEach(
            number -> {
              Integer actualCountRows = bookStorePage.selectRows(number).getRows().size();
              softAssert.assertEquals(actualCountRows, number);
            });
    softAssert.assertAll();
  }
}
