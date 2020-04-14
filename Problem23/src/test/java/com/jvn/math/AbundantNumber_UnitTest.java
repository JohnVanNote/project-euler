package com.jvn.math;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AbundantNumber_UnitTest {

  @DataProvider
  public Object[][] numbers() {
    return new Object[][]{
        {1, false},
        {5, false},
        {10, false},
        {12, true},
        {28, false},
    };
  }

  @Test(dataProvider = "numbers")
  public void isAbundant_numbers_expected(int number, boolean expected) {
    Assert.assertEquals(AbundantNumber.isAbundant(number), expected);
  }

}
