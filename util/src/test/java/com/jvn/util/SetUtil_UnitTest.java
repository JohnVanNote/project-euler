package com.jvn.util;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SetUtil_UnitTest {

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
  public void sum_sets_expectedSum(Set<Integer> set, int expectedSum) {
    Assert.assertEquals(SetUtil.sum(set), expectedSum);
  }


}
