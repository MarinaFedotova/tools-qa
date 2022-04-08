package org.example;

import io.qameta.allure.Owner;
import org.example.allureannotations.Suite;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;

public class PreviousAndNextButtonsTest extends BaseTest {

  private Integer expectedNumber;
  private Integer actualNumber;

  @BeforeClass
  public void precondition() {
    bookStorePage.selectNumberOfRows(5);
    expectedNumber = bookStorePage.getCurrentTableNumber();
  }

  @Test(description = "check Next button")
  @Suite("Test")
  @Owner("Marina Fedotova")
  public void nextButtonTest() {
    step(
        "Click on Next Button",
        () -> {
          bookStorePage.getNextButton().click();
          actualNumber = bookStorePage.getCurrentTableNumber();
          step(
              "The next page of the table is displayed",
              () -> Assert.assertEquals(actualNumber, ++expectedNumber));
        });
  }

  @Test(description = "check Previous button", dependsOnMethods = "nextButtonTest")
  @Suite("Test")
  @Owner("Marina Fedotova")
  public void previousButtonTest() {
    step(
        "Click on Previous Button",
        () -> {
          bookStorePage.getPreviousButton().click();
          actualNumber = bookStorePage.getCurrentTableNumber();
          step(
              "The previous page of the table is displayed",
              () -> Assert.assertEquals(actualNumber, --expectedNumber));
        });
  }
}
