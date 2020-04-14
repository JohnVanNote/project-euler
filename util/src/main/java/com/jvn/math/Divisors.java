package com.jvn.math;

import java.util.HashSet;
import java.util.Set;

public class Divisors {

  public static Set<Integer> findProperDivisors(int number) {
    Set<Integer> divisors = new HashSet<>();
    divisors.add(1);

    for (int i = 2; i < Math.sqrt(number) + 1; i++) {
      if (number % i == 0) {
        divisors.add(i);
        divisors.add(number / i);
      }
    }

    divisors.remove(number);
    return divisors;
  }

}
