package com.jvn.primes;

import com.jvn.math.Sieve;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Sieve_UnitTest {

  @DataProvider
  public Object[][] combinations() {
    return new Object[][]{
        {1, 0L},
        {2, 0L},
        {3, 2L},
        {5, 5L},
        {10, 17L},
        {2000000, 142913828922L}
    };
  }

  @Test(dataProvider = "combinations")
  public void sumOfPrimes_max_expectedSum(int max, long expectedSum) {
    Assert.assertEquals(Sieve.sumOfPrimes(max), expectedSum);
  }

}
