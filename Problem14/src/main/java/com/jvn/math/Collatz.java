package com.jvn.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Collatz {

  private static final int MAX = 1000000;
  private static Map<Long, List<Long>> COLLATZ_MAP = new HashMap<>();

  static {
    COLLATZ_MAP.put(1L, Collections.singletonList(1L));
  }

  public static List<Long> getSequence(long number) {
    if (!COLLATZ_MAP.containsKey(number)) {
      long nextNumber;
      if (number % 2 == 0) {
        nextNumber = number / 2;
      } else {
        nextNumber = 3 * number + 1;
      }

      COLLATZ_MAP.put(number, concat(number, getSequence(nextNumber)));
    }
    return COLLATZ_MAP.get(number);
  }

  private static List<Long> concat(Long front, List<Long> back) {
    List<Long> full = new ArrayList<>();
    full.add(front);
    full.addAll(back);
    return full;
  }

  public static void main(String[] args) {
    int maxChain = 0;
    int maxNumber = 1;

    for (int i = 1; i < MAX; i++) {
      List<Long> sequence = getSequence(i);
      int tempChain = sequence.size();
      if (tempChain > maxChain) {
        maxChain = tempChain;
        maxNumber = i;
      }
    }

    System.out.println("Number " + maxNumber + " has a chain size of " + maxChain);
  }

}
