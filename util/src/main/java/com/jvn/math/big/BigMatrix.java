package com.jvn.math.big;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class BigMatrix {

  private List<List<BigInteger>> matrix;

  public BigMatrix(List<List<BigInteger>> matrix) {
    setMatrix(matrix);
  }

  public List<List<BigInteger>> getMatrix() {
    return matrix;
  }

  public void setMatrix(final List<List<BigInteger>> matrix) {
    if (!verify(matrix)) {
      throw new IllegalArgumentException(String.format("Matrix %s is not valid.", matrix));
    }
    this.matrix = matrix;
  }

  public BigMatrix power(int exponent) {
    BigMatrix result = new BigMatrix(matrix);

    if (exponent != 1) {
      for (int i = 1; i < exponent; i++) {
        result = result.multiply(new BigMatrix(matrix));
      }
    }

    return result;
  }

  public BigMatrix multiply(BigMatrix otherMatrix) {

    List<List<BigInteger>> otherMatrixComponents = otherMatrix.getMatrix();
    int m1Rows = matrix.size();
    int m1Cols = matrix.get(0).size();

    int m2Rows = otherMatrixComponents.size();
    int m2Cols = otherMatrixComponents.get(0).size();

    List<List<BigInteger>> outerResult = new ArrayList<>();

    for (int i = 0; i < m1Rows; i++) {
      List<BigInteger> innerResult = new ArrayList<>();
      for (int j = 0; j < m2Cols; j++) {
        BigInteger cell = BigInteger.ZERO;
        for (int k = 0; k < m1Cols; k++) {
          BigInteger x = matrix.get(i).get(k);
          BigInteger y = otherMatrixComponents.get(k).get(j);
          cell = cell.add(x.multiply(y));
        }
        innerResult.add(cell);
      }

      outerResult.add(innerResult);
    }

    return new BigMatrix(outerResult);
  }

  private boolean verify(List<List<BigInteger>> matrix) {
    boolean valid = true;
    if (matrix.size() < 1) {
      valid = false;
    } else {
      int rowSize = matrix.get(0).size();
      for (List<BigInteger> row : matrix) {
        valid = valid && (row.size() == rowSize);
      }
    }
    return valid;
  }

  @Override
  public String toString() {
    return "Matrix{" + "matrix=" + matrix + '}';
  }

}
