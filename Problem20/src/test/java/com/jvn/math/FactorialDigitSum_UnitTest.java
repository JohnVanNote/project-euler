package com.jvn.math;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactorialDigitSum_UnitTest {

  @DataProvider
  public Object[][] pairs() {
    return new Object[][]{
        {10, 27L}
    };
  }

  @Test(dataProvider = "pairs")
  public void digitSum_pairs_expectedValue(int input, Long expectedValue) {
    Assert.assertEquals(FactorialDigitSum.digitSum(input), expectedValue);
  }

}
