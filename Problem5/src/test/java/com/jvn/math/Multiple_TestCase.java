package com.jvn.math;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Multiple_TestCase {

  @Test
  public void smallest_10_2520() {
    Assert.assertEquals(Multiple.smallest(10), 2520);
  }

}
