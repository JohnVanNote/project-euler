package com.jvn.math;

public class Multiple {

  private static final int MAX = 20;

  public static int smallest(int max) {
    int num = max;
    boolean cleanDivide = false;

    while (!cleanDivide) {
      num++;
      boolean tempCleanDivide = true;
      for (int i = max; i > max / 2; i--) {
        tempCleanDivide = tempCleanDivide && (num % i == 0);
      }
      cleanDivide = tempCleanDivide;
    }

    return num;
  }

  public static void main(String[] args) {
    System.out.println(smallest(MAX));
  }

}
