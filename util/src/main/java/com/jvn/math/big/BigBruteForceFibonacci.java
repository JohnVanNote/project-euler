package com.jvn.math.big;

import java.math.BigInteger;

public class BigBruteForceFibonacci implements BigFibonacci {

  public BigInteger sequenceValue(int position) {
    if (position == 0) {
      return BigInteger.ZERO;
    }
    if (position == 1) {
      return BigInteger.ONE;
    }
    return sequenceValue(position - 1).add(sequenceValue(position - 2));
  }

  public String name() {
    return "Big Brute Force Fibonacci";
  }

}
