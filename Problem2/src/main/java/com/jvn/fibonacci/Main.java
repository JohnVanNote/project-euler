package com.jvn.fibonacci;

import java.util.Arrays;
import java.util.List;

public class Main {

  private static final int INIT_SENTINEL = -1;
  private static final int MAX = 4000000;
  private static final int[] MEMOIZED = init(MAX+1);

  private static int[] init(int size) {
    int[] init = new int[size];
    for (int i=0; i<size; i++) {
      init[i] = INIT_SENTINEL;
    }

    return init;
  }

  private static int fibonacciSumSlow(final int maxCount) {

    int sum = 0;
    int count = maxCount;

    while (count > 0) {
      if (count % 2 == 0) {
        //sum = fibonacciSlow(count);
      }
      count--;
    }

    return sum;
  }

  public static int fibonacciMemoized(int n) {
    System.out.println("Memoized ");
    if (n < 0) throw new IllegalArgumentException();

    if (MEMOIZED[n] == INIT_SENTINEL) {
      if (n < 2) MEMOIZED[n] = 1;
      else MEMOIZED[n] = fibonacciSumMemoized(n-1) + fibonacciSumMemoized(n-2);
    }

    return MEMOIZED[n];
  }

  private static int fibonacciSumMemoized(final int maxCount) {

    int sum = 0;
    int count = maxCount;

    while (count > 0) {
      if (count % 2 == 0) {
        sum = fibonacciMemoized(count);
      }
      count--;
    }

    return sum;
  }

  public static void main(String[] args) {
    Fibonacci bruteForceFibonacci = new BruteForceFibonacci();
    List<Fibonacci> fibonaccis = Arrays.asList(bruteForceFibonacci);

    //System.out.println(fibonacciSlow(1));
    System.out.println(fibonacciSumMemoized(MAX));
  }

}
