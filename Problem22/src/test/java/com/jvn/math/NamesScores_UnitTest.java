package com.jvn.math;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NamesScores_UnitTest {

  @DataProvider
  public Object[][] names() {
    return new Object[][]{
        {"COLIN", 53}
    };
  }

  @Test(dataProvider = "names")
  public void score_names_expectedValue(String name, int expectedValue) {
    Assert.assertEquals(NamesScores.score(name), expectedValue);
  }

}
