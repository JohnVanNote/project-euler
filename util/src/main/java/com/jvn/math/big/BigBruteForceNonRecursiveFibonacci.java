package com.jvn.math.big;

import java.math.BigInteger;

public class BigBruteForceNonRecursiveFibonacci implements BigFibonacci {

  public BigInteger sequenceValue(int position) {
    BigInteger total = BigInteger.ZERO;
    if (position == 1) {
      total = BigInteger.ONE;
    }
    if (position == 2) {
      total = BigInteger.ONE;
    } else {

      BigInteger previous1 = BigInteger.ONE;
      BigInteger previous2 = BigInteger.ONE;

      for (int i = 2; i < position; i++) {
        total = previous1.add(previous2);
        previous2 = previous1;
        previous1 = total;
      }
    }
    return total;
  }

  public String name() {
    return "Big Brute Force Non-Recursive Fibonacci";
  }

}
