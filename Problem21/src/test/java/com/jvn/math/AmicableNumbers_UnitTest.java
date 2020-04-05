package com.jvn.math;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AmicableNumbers_UnitTest {

  @DataProvider
  public Object[][] maps() {
    return new Object[][]{
        {2, ImmutableMap.of(1, 0)},
        {4, ImmutableMap.of(1, 0, 2, 1, 3, 1)},
        {6, ImmutableMap.of(1, 0, 2, 1, 3, 1, 4, 3, 5, 1)},
    };
  }

  @Test(dataProvider = "maps")
  public void sumDivisorMap_maps_expectedMap(int number, Map<Integer, Integer> expectedMap) {
    Assert.assertEquals(AmicableNumbers.sumDivisorMap(number), expectedMap);
  }


}
