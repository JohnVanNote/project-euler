package com.jvn.math.fibonacci;

import com.jvn.math.Matrix;
import java.util.Arrays;

public class MatrixFibonacci implements Fibonacci {

  public int sequenceValue(int position) {
    int value = 0;
    if (position > 0) {
      Matrix matrix = new Matrix(Arrays.asList(
          Arrays.asList(1, 1),
          Arrays.asList(1, 0)
      ));

      value = matrix.power(position - 1).getMatrix().get(0).get(0);
    }
    return value;
  }

  public String name() {
    return "Matrix Fibonacci";
  }

}
