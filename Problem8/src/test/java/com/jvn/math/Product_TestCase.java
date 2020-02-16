package com.jvn.math;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Product_TestCase {

  @DataProvider
  public Object[][] numbers() {
    return new Object[][] {
        {0, 0},
        {1, 9},
        {2, 81},
        {4, 5832}
    };
  }

  @Test(dataProvider = "numbers")
  public void greatestProduct_numbers_result(int length, long result) {
    Assert.assertEquals(Product.greatestProduct(Product.NUMBER, length), result);
  }

}
