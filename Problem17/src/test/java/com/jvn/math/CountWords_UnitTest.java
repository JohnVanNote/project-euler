package com.jvn.math;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CountWords_UnitTest {

  @DataProvider
  public Object[][] intToSize() {
    return new Object[][]{
        {1, 3},
        {2, 3},
        {3, 5},
        {4, 4},
        {5, 4},
        {342, 23},
        {115, 20}
    };
  }

  @Test(dataProvider = "intToSize")
  public void numSize_ints_sizes(int n, int size) {
    Assert.assertEquals(CountWords.numSize(n), size);
  }

}
