package com.jvn.fibonacci;

import com.google.common.base.Stopwatch;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

  private static final int MAX = 4000000;

  private static int fibonacciSum(final Fibonacci implementation, final int maxValue) {
    int sum = 0;
    int sequenceValue = 0;
    int count = 0;

    while (sequenceValue < maxValue) {
      sequenceValue = implementation.sequenceValue(count);

      if (count % 2 == 0) {
        sum += sequenceValue;
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
      Stopwatch stopwatch = Stopwatch.createStarted();
      try {
        System.out.println("Starting test " + fibonacci.name());
        System.out.println(fibonacciSum(fibonacci, MAX));
        System.out.println("Ending test " + fibonacci.name());
        // Catch the StackOverflow Error
      } catch (Throwable t) {
        System.out.println("Unable to generate fibonnacci sum for  " + fibonacci.name() + ", error:" + t.getMessage());
      }
      stopwatch.stop();
      System.out.println(fibonacci.name() + " completed in " + stopwatch.elapsed(TimeUnit.MICROSECONDS) + " microseconds");
    }
  }

}
