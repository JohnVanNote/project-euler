package com.jvn.fibonacci;

import java.util.Arrays;
import java.util.List;

public class Main {

  private static final int MAX = 4000000;

  private static int fibonacciSum(final Fibonacci implementation, final int maxCount) {
    int sum = 0;
    int count = maxCount;

    while (count > 0) {
      if (count % 2 == 0) {
        sum = implementation.sequenceValue(count);
      }
      count--;
    }

    return sum;
  }

  public static void main(String[] args) {
    Fibonacci bruteForceFibonacci = new BruteForceFibonacci();
    Fibonacci memoizationFibonacci = new MemoizationFibonacci();
    List<Fibonacci> fibonaccis = Arrays.asList(bruteForceFibonacci, memoizationFibonacci);

    for (Fibonacci fibonacci : fibonaccis) {
      try {
        System.out.println(fibonacciSum(fibonacci, MAX));

        // Catch the StackOverflow Error
      } catch (Throwable t) {
        System.out.println("Unable to generate " + t.getMessage());
      }
    }
  }

}
