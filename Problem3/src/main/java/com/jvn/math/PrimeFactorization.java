package com.jvn.math;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {

  private static final BigInteger NUMBER = new BigInteger("600851475143");

  public static long largestPrimeFactor(BigInteger number) {
    BigInteger numCopy = number;

    List<Long> factors = new ArrayList<>();

    for (long i = 2; numCopy.compareTo(BigInteger.valueOf(i)) >= 0; i++) {
      if (numCopy.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
        factors.add(i);
        numCopy = numCopy.divide(BigInteger.valueOf(i));
      }
    }
    return factors.get(factors.size() - 1);
  }

  public static void main(String[] args) {
    System.out.println(largestPrimeFactor(NUMBER));
  }

}
