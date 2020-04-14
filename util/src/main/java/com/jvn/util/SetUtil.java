package com.jvn.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class SetUtil {

  public static int sum(Set<Integer> set) {
    int total = 0;
    for (int item : set) {
      total += item;
    }
    return total;
  }

  public static Set<Integer> sumAllSetItems(Set<Integer> set) {
    Set<Integer> newSet = new HashSet<>();

    if (set.size() > 0) {
      List<Integer> list = new ArrayList<>(set);
      int firstItem = list.get(0);
      for (int i = 0; i < list.size(); i++) {
        newSet.add(firstItem + list.get(i));
      }
      List<Integer> newList = list.subList(1, list.size());
      newSet.addAll(sumAllSetItems(new HashSet<>(newList)));
    }

    return newSet;
  }

}
