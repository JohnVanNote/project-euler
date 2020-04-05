package com.jvn.util;

import java.util.Set;

public class SetUtil {

  public static int sum(Set<Integer> set) {
    int total = 0;
    for (int item : set) {
      total += item;
    }
    return total;
  }

}
