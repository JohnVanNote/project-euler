package com.jvn.math;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AmicableNumbers_UnitTest {

  @DataProvider
  public Object[][] properDivisors() {
    return new Object[][]{
        {1, ImmutableSet.of()},
        {2, ImmutableSet.of(1)},
        {3, ImmutableSet.of(1)},
        {4, ImmutableSet.of(1, 2)},
        {5, ImmutableSet.of(1)},
        {6, ImmutableSet.of(1, 2, 3)},
        {7, ImmutableSet.of(1)},
        {8, ImmutableSet.of(1, 2, 4)},
        {9, ImmutableSet.of(1, 3)},
        {10, ImmutableSet.of(1, 2, 5)},
        {220, ImmutableSet.of(1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110)},
        {284, ImmutableSet.of(1, 2, 4, 71, 142)},
    };
  }

  @Test(dataProvider = "properDivisors")
  public void findProperDivisors_number_expectedProperDivisor(int number, Set<Integer> expectedProperDivisors) {
    Assert.assertEquals(AmicableNumbers.findProperDivisors(number), expectedProperDivisors);
  }

  @DataProvider
  public Object[][] sets() {
    return new Object[][]{
        {ImmutableSet.of(), 0},
        {ImmutableSet.of(1), 1},
        {ImmutableSet.of(1, 2, 5), 8},
        {ImmutableSet.of(1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110), 284},
        {ImmutableSet.of(1, 2, 4, 71, 142), 220},
    };
  }

  @Test(dataProvider = "sets")
  public void sumSet_sets_expectedSum(Set<Integer> set, int expectedSum) {
    Assert.assertEquals(AmicableNumbers.sumSet(set), expectedSum);
  }

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
