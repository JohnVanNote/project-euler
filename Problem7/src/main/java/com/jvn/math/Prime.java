package com.jvn.math;

import java.util.ArrayList;
import java.util.List;

public class Prime {

  private static final int NUMBER = 10001;

  public static long nthPrime(int n) {
    List<Long> nPrimes = new ArrayList<Long>();
    for (long i = 2; nPrimes.size()<n ; i++) {
      boolean oneGcd = true;
      for (Long nPrime : nPrimes) {
        long gcd = gcd(nPrime, i);
        oneGcd = oneGcd && (gcd == 1);
        if (!oneGcd) break;
      }
      if (oneGcd) nPrimes.add(i);
    }

    return nPrimes.get(n-1);
  }

  private static long gcd(long a, long b) {
    if (a == 0) return b;
    return gcd(b % a, a);
  }

  public static void main(String[] args) {
    System.out.println(nthPrime(NUMBER));
  }

}
