package com.jvn;

import com.google.common.base.Stopwatch;
import com.jvn.math.big.BigBruteForceFibonacci;
import com.jvn.math.big.BigBruteForceNonRecursiveFibonacci;
import com.jvn.math.big.BigFibonacci;
import com.jvn.math.big.BigMatrixFibonacci;
import com.jvn.math.big.BigMemoizationFibonacci;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FibonacciNumber {

  private static final int DIGIT_NUM = 1000;

  private static int fibonacciDigit(final BigFibonacci implementation, final int digitNum) {
    BigInteger sequenceValue = BigInteger.ZERO;
    int count = 1;

    while (sequenceValue.toString().length() < digitNum) {
      sequenceValue = implementation.sequenceValue(count);
      count++;
    }

    return count - 1; //since the index starts at 1 and not 0
  }

  public static void main(String[] args) {
    BigFibonacci matrixFibonacci = new BigMatrixFibonacci();
    BigFibonacci memoizationFibonacci = new BigMemoizationFibonacci();
    BigFibonacci bruteForceNonRecursiveFibonacci = new BigBruteForceNonRecursiveFibonacci();
    BigFibonacci bruteForceFibonacci = new BigBruteForceFibonacci();
    List<BigFibonacci> fibonaccis = Arrays.asList(
        matrixFibonacci,
        memoizationFibonacci,
        bruteForceNonRecursiveFibonacci,
        bruteForceFibonacci
    );

    String result;

    for (BigFibonacci fibonacci : fibonaccis) {
      Stopwatch stopwatch = Stopwatch.createStarted();
      try {
        System.out.println("Starting test " + fibonacci.name());
        System.out.println(fibonacciDigit(fibonacci, DIGIT_NUM));
        System.out.println("Ending test " + fibonacci.name());

        result = "completed in";

        // Catch the StackOverflow/Heapspace Error
      } catch (Throwable t) {
        System.out.println("Unable to generate fibonnacci sum for  " + fibonacci.name() + ", error:" + t.getMessage());
        result = "failed after";
      }
      stopwatch.stop();
      System.out.println(fibonacci.name() + " " + result + " " + stopwatch.elapsed(TimeUnit.MICROSECONDS) + " microseconds");

    }
  }

}
