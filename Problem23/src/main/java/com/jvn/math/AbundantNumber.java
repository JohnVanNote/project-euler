package com.jvn.math;

import com.jvn.util.SetUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AbundantNumber {

  private static final int UNDER = 28123;

  public static boolean isAbundant(int number) {
    Set<Integer> properDivisors = Divisors.findProperDivisors(number);
    return number < SetUtil.sum(properDivisors);
  }

  public static Set<Integer> getAbundantUnder(int under) {
    Set<Integer> abundants = new HashSet<>();
    for (int i = 1; i < under; i++) {
      if (isAbundant(i)) {
        abundants.add(i);
      }
    }
    return abundants;
  }

  public static boolean isSumOfTwoNumbers(Set<Integer> numbers, int sum) {
    boolean isSum = false;
    for (int number : numbers) {
      int check = sum - number;
      isSum = isSum || numbers.contains(check);
      if (isSum) {
        break;
      }
    }
    return isSum;
  }

  public static void main(String[] args) {
    Set<Integer> abundants = getAbundantUnder(UNDER);
    List<Integer> sortedAbundants = new ArrayList<>(abundants);
    Collections.sort(sortedAbundants);

    int sum = 0;
    for (int i = 1; i < UNDER; i++) {
      if (!isSumOfTwoNumbers(abundants, i)) {
        sum += i;
      }
    }

    System.out.println(String.format("The sum of all the positive integers which cannot be written as the sum of two abundant numbers is %d.", sum));
  }

}
