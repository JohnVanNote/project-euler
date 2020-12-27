package com.jvn.math.big;

import com.jvn.math.Matrix;
import java.math.BigInteger;
import java.util.Arrays;

public class BigMatrixFibonacci implements BigFibonacci {

  public BigInteger sequenceValue(int position) {
    BigInteger value = BigInteger.ZERO;
    if (position > 0) {

      BigMatrix matrix = new BigMatrix(Arrays.asList(
          Arrays.asList(BigInteger.ONE, BigInteger.ONE),
          Arrays.asList(BigInteger.ONE, BigInteger.ZERO)
      ));

      value = matrix.power(position - 1).getMatrix().get(0).get(0);
    }
    return value;
  }

  public String name() {
    return "Big Matrix Fibonacci";
  }

}
