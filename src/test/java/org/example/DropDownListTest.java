package org.example;

import io.qameta.allure.Owner;
import org.example.allureannotations.Suite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static io.qameta.allure.Allure.step;

public class DropDownListTest extends BaseTest {

  private final SoftAssert softAssert = new SoftAssert();
  private List<Integer> expectedCountRows;
  private Integer actualCountRows;

  @BeforeTest
  public void initialData() {
    expectedCountRows = List.of(5, 10, 20, 25, 50, 100);
  }

  @Test(description = "Testing a dropdown to set the number of books per page")
  @Suite("Test")
  @Owner("Marina Fedotova")
  public void dropDownListTest() {
    expectedCountRows.forEach(
        number -> {
          step(
              "Choose to display " + number + " entries in the drop down list",
              () -> {
                actualCountRows = bookStorePage.selectNumberOfRows(number).getAllRows().size();
                step(
                    "Table contains " + number + " rows",
                    () -> softAssert.assertEquals(actualCountRows, number));
              });
        });
    softAssert.assertAll();
  }
}
