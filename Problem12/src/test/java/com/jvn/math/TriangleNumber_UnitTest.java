package com.jvn.math;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleNumber_UnitTest {

  @DataProvider
  public Object[][] sequences() {
    return new Object[][]{
        {1, 1},
        {2, 3},
        {3, 6},
        {4, 10},
        {5, 15},
        {6, 21},
        {7, 28}
    };
  }

  @Test(dataProvider = "sequences")
  public void next_sequences_expectedVal(int n, long expectedValue) {
    Assert.assertEquals(TriangleNumber.next(n), expectedValue);
  }

  @DataProvider
  public Object[][] divisors() {
    return new Object[][]{
        {1, ImmutableSet.of(1L)},
        {3, ImmutableSet.of(1L, 3L)},
        {6, ImmutableSet.of(1L, 2L, 3L, 6L)},
        {10, ImmutableSet.of(1L, 2L, 5L, 10L)},
        {15, ImmutableSet.of(1L, 3L, 5L, 15L)},
        {21, ImmutableSet.of(1L, 3L, 7L, 21L)},
        {28, ImmutableSet.of(1L, 2L, 4L, 7L, 14L, 28L)}
    };
  }

  @Test(dataProvider = "divisors")
  public void getDivisors_divisors_expectedVal(int n, Set<Long> expectedDivisors) {
    Assert.assertEquals(TriangleNumber.getDivisors(n), expectedDivisors);
  }

}
