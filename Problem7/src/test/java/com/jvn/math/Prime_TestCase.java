package com.jvn.math;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Prime_TestCase {

  @DataProvider
  public Object[][] data() {
    return new Object[][]{
        {1, 2},
        {2, 3},
        {3, 5},
        {4, 7},
        {5, 11},
        {6, 13}
    };
  }

  @Test(dataProvider = "data")
  public void nthPrime_data_expectedValue(int n, long prime) {
    Assert.assertEquals(Prime.nthPrime(n), prime);
  }

}
