package com.jvn.fibonacci;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public abstract class Fibonacci_TestCase {

  private Fibonacci fibonacci;

  public abstract Fibonacci initialize();

  @DataProvider
  public Object[][] inputs() {
    return new Object[][] {
        {0, 0},
        {1, 1},
        {2, 1},
        {3, 2},
        {4, 3},
        {5, 5},
        {6, 8},
        {7, 13},
        {8, 21},
        {9, 34},
        {10, 55},
        {11, 89}
    };
  }

  @Test(dataProvider = "inputs")
  public void sequenceValue_inputs_expectedValues(int position, int expectedValue) {
    fibonacci = initialize();
    Assert.assertEquals(fibonacci.sequenceValue(position), expectedValue);
  }

}
