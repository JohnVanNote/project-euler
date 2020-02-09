package com.jvn.math;

import java.math.BigInteger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PrimeFactorization_TestCase {

  @DataProvider
  public Object[][] data() {
    return new Object[][] {
        {BigInteger.valueOf(26), 13},
        {BigInteger.valueOf(13195), 29}
    };
  }

  @Test(dataProvider = "data")
  public void largestPrimeFactor_data_expectedValue(BigInteger input, long largestPrime) {
    Assert.assertEquals(PrimeFactorization.largestPrimeFactor(input), largestPrime);
  }

}
