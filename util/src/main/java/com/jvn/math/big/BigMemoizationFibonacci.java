package com.jvn.math.big;

import com.jvn.math.fibonacci.Fibonacci;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class BigMemoizationFibonacci implements BigFibonacci {

  private List<BigInteger> memoized = initMemoized();

  public BigInteger sequenceValue(int position) {
    if (memoized.size() <= position) {
      memoized.add(sequenceValue(position - 1).add(sequenceValue(position - 2)));
    }
    return memoized.get(position);
  }

  public String name() {
    return "Big Memoization Fibonacci";
  }

  private List<BigInteger> initMemoized() {
    List<BigInteger> memoized = new ArrayList<>();
    memoized.add(BigInteger.ZERO);
    memoized.add(BigInteger.ONE);
    return memoized;
  }

}
