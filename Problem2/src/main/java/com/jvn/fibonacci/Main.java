package com.jvn.fibonacci;

import java.util.Arrays;
import java.util.List;

public class Main {

  private static final int MAX = 4000000;

  private static int fibonacciSum(final Fibonacci implementation, final int maxCount) {
    int sum = 0;
    int count = 0;


    while (count < maxCount) {
      if (count % 10000 == 0) {
        System.out.println((count+0.0)/MAX + " complete");
      }

      if (count % 2 == 0) {
        sum += implementation.sequenceValue(count);
      }
      count++;
    }

    return sum;
  }

  public static void main(String[] args) {
    Fibonacci matrixFibonacci = new MatrixFibonacci();
    Fibonacci memoizationFibonacci = new MemoizationFibonacci();
    Fibonacci bruteForceNonRecursiveFibonacci = new BruteForceNonRecursiveFibonacci();
    Fibonacci bruteForceFibonacci = new BruteForceFibonacci();
    List<Fibonacci> fibonaccis = Arrays.asList(
        matrixFibonacci,
        memoizationFibonacci,
        bruteForceNonRecursiveFibonacci,
        bruteForceFibonacci
    );

    for (Fibonacci fibonacci : fibonaccis) {
      try {
        System.out.println("Starting test " + fibonacci.name());
        System.out.println(fibonacciSum(fibonacci, MAX));
        System.out.println("Ending test " + fibonacci.name());
        // Catch the StackOverflow Error
      } catch (Throwable t) {
        System.out.println("Unable to generate fibonnacci sum for  " + fibonacci.name() + ", error:" + t.getMessage());
      }
    }
  }

}
