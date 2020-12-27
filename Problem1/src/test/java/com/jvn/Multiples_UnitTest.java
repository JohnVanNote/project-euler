package com.jvn;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Multiples_UnitTest {

  @DataProvider
  public Object[][] inputAndExpectedOutput() {
    return new Object[][]{
        {10, 23},
        {1000, 233168}
    };
  }

  @Test(dataProvider = "inputAndExpectedOutput")
  public void solution_inputAndExpectedOutput_expectedOutput(int under, int result) {
    Assert.assertEquals(Multiples.solution(under), result);
  }

}
