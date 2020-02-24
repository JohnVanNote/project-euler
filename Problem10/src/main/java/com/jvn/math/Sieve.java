package com.jvn.math;

import java.util.ArrayList;
import java.util.List;

public class Sieve {

  private static final int MAX = 2000000;
  private static final boolean IS_PRIME = true;
  private static final boolean IS_NOT_PRIME = false;

  public static List<Boolean> initialize(int max) {
    List<Boolean> init = new ArrayList<Boolean>(max);
    if (max >= 0) {
      init.add(IS_NOT_PRIME);
      if (max >= 1) {
        init.add(IS_NOT_PRIME);
      }

      for (int i=2; i<max; i++) {
        init.add(IS_PRIME);
      }
    }

    return init;
  }

  public static long sumOfPrimes(int under) {
    long sum = 0;
    List<Boolean> init = initialize(under);

    for (int num=2; num<under; num++) {
      if (init.get(num)) {

        sum += num;
        int bump = 2;

        int next;
        while ((next = num * bump) < under) {
          init.set(next, IS_NOT_PRIME);
          bump++;
        }

      }

    }

    return sum;
  }

  public static void main(String[] args) {
    System.out.println(sumOfPrimes(MAX));
  }

}
