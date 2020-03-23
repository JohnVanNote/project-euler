package com.jvn.math;

import java.util.HashSet;
import java.util.Set;

public class TriangleNumber {

  public static final int NUM_DIVISORS = 500;

  public static long next(int num) {
    return ((num + 1) * num) / 2;
  }

  public static Set<Long> getDivisors(long num) {
    Set<Long> divisors = new HashSet<>();
    divisors.add(1L);

    for (long i = 1; i * i < num; i++) {
      if (num % i == 0) {
        divisors.add(i);
        divisors.add(num / i);
      }
    }

    return divisors;
  }

  public static void main(String[] args) {
    int i = 1;
    long next;
    Set<Long> divisors;

    do {
      next = next(i);
      divisors = getDivisors(next);
      i++;
    } while (divisors.size() < NUM_DIVISORS);

    System.out.println(next);
  }

}
