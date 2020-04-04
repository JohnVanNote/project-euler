package com.jvn.math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class AmicableNumbers {

  private static final int UNDER = 10000;

  public static int sumSet(Set<Integer> set) {
    int total = 0;
    for (int item : set) {
      total += item;
    }
    return total;
  }

  public static Map<Integer, Integer> sumDivisorMap(int under) {

    Map<Integer, Integer> sumDivisorMap = new HashMap<>(under - 1);

    IntStream.range(1, under).forEachOrdered(n -> {
      sumDivisorMap.put(n, sumSet(Divisors.findProperDivisors(n)));
    });

    return sumDivisorMap;
  }

  public static void main(String[] args) {
    Set<Integer> amicableNumbers = new HashSet<>();
    Map<Integer, Integer> map = sumDivisorMap(UNDER);

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int key = entry.getKey();
      int value = entry.getValue();

      int otherKey = value;
      int otherValue = map.getOrDefault(otherKey, -1);

      if (key == otherValue && key != otherKey) {
        amicableNumbers.add(key);
        amicableNumbers.add(value);
        //System.out.println(String.format("The numbers %d(%d) and %d(%d) are amicable.", key, value, otherKey, otherValue));
      }

    }

    System.out.println(String.format("The sum of all amicable numbers under %d is %d.", UNDER, sumSet(amicableNumbers)));
  }

}
