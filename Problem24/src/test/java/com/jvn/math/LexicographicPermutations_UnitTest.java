package com.jvn.math;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LexicographicPermutations_UnitTest {

  @DataProvider
  public Object[][] objects() {
    return new Object[][]{
        //{"", ImmutableList.of()},
        //{"0", ImmutableList.of("0")},
        {ImmutableList.of(0, 1), ImmutableList.of(1, 0)},
        {ImmutableList.of(0, 1, 2), ImmutableList.of(0, 2, 1)}
    };
  }

  @Test(dataProvider = "objects")
  public void nextPermutation_currentPerm_nextPerm(List<Integer> currentPerm, List<Integer> nextPerm) {
    Assert.assertEquals(LexicographicPermutations.nextPermutation(currentPerm), nextPerm);
  }

}
