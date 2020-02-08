package com.jvn.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix {

  private List<List<Integer>> matrix;

  public Matrix (List<List<Integer>> matrix) {
    setMatrix(matrix);
  }

  public List<List<Integer>> getMatrix() {
    return matrix;
  }

  public void setMatrix(final List<List<Integer>> matrix) {
    if (!verify(matrix)) throw new IllegalArgumentException(String.format("Matrix %s is not valid.", matrix));
    this.matrix = matrix;
  }

  public Matrix power(int exponent) {
    Matrix result = new Matrix(matrix);

    if (exponent != 1) {
      for (int i = 1; i<exponent; i++) {
        result = result.multiply(new Matrix(matrix));
      }
    }

    return result;
  }

  public Matrix multiply(Matrix otherMatrix) {

    List<List<Integer>> otherMatrixComponents = otherMatrix.getMatrix();
    int m1Rows = matrix.size();
    int m1Cols = matrix.get(0).size();

    int m2Rows = otherMatrixComponents.size();
    int m2Cols = otherMatrixComponents.get(0).size();

    List<List<Integer>> outerResult = new ArrayList<List<Integer>>();

    for (int i=0; i<m1Rows; i++) {
      List<Integer> innerResult = new ArrayList<Integer>();
      for (int j=0; j<m2Cols; j++) {
        int cell = 0;
        for (int k=0; k<m1Cols; k++) {
          int x = matrix.get(i).get(k);
          int y = otherMatrixComponents.get(k).get(j);
          cell += x * y;
        }
        innerResult.add(cell);
      }

      outerResult.add(innerResult);
    }

    return new Matrix(outerResult);
  }

  private boolean verify(List<List<Integer>> matrix) {
    boolean valid = true;
    if (matrix.size() < 1) {
      valid = false;
    } else {
      int rowSize = matrix.get(0).size();
      for (List<Integer> row: matrix) {
        valid = valid && (row.size() == rowSize);
      }
    }
    return valid;
  }

  @Override
  public String toString() {
    return "Matrix{" + "matrix=" + matrix + '}';
  }

  /*
  public static void main(String[] args) {
    Matrix m = new Matrix(Arrays.asList(
        Arrays.asList(0, 1),
        Arrays.asList(0, 1)
    ));

    Matrix m1 = new Matrix(Arrays.asList(
        Arrays.asList(4, 6, 2),
        Arrays.asList(1, 3, -3)
    ));

    Matrix m2 = new Matrix(Arrays.asList(
        Arrays.asList(-2, -4, 4, 2),
        Arrays.asList(-1, 5, 0, 3),
        Arrays.asList(6, -3, 1, 7)
    ));

    System.out.println("M1 " + m1);
    System.out.println("M2 " + m2);
    System.out.println("Result " + m1.multiply(m2));
    System.out.println("Power " + m.power(2));
  }
  */

}
