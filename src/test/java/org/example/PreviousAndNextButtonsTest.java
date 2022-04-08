package org.example;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PreviousAndNextButtonsTest extends BaseTest {

  private Integer expectedNumber;

  @BeforeClass
  public void beforeTest() {
    bookStorePage.selectRows(5);
  }

  @Test
  private void nextButtonTest() {
    expectedNumber = bookStorePage.getPageNumberInput();
    bookStorePage.getNextButton().click();
    Integer actualPageNumber = bookStorePage.getPageNumberInput();
    Assert.assertEquals(actualPageNumber, ++expectedNumber);
  }

  @Test(dependsOnMethods = "nextButtonTest")
  private void previousButtonTest() {
    expectedNumber = bookStorePage.getPageNumberInput();
    bookStorePage.getPreviousButton().click();
    Integer actualPageNumber = bookStorePage.getPageNumberInput();
    Assert.assertEquals(actualPageNumber, --expectedNumber);
  }
}
