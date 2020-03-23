package com.jvn.math;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LatticePaths_UnitTest {

  @DataProvider
  public Object[][] sizes() {
    return new Object[][]{
        {0, 0, 1},
        {1, 0, 1},
        {1, 1, 2},
        {1, 2, 3},
        {2, 2, 6}
    };
  }

  @Test(dataProvider = "sizes")
  public void numRoutes_sizes_expectedValues(int x, int y, int expectedValue) {
    Assert.assertEquals(LatticePaths.numRoutes(x, y), expectedValue);
  }

}
