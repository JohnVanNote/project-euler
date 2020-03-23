package com.jvn.euler;

public class SumSquares {

  private static final int NUMBER = 100;

  public static int sumOfSquares(int num) {
    int total = 0;
    for (int i = 1; i <= num; i++) {
      total += Math.pow(i, 2);
    }
    return total;
  }

  public static int squareOfSum(int num) {
    int total = 0;
    for (int i = 1; i <= num; i++) {
      total += i;
    }
    return new Double(Math.pow(total, 2)).intValue();
  }

  public static int difference(int num) {
    return squareOfSum(num) - sumOfSquares(num);
  }

  public static void main(String[] args) {
    System.out.println(difference(NUMBER));
  }

}
