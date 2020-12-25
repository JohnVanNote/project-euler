package com.jvn.math;

import com.jvn.util.CollectionUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LexicographicPermutations {

  public static List<String> getPermutations(List<String> integers) {
    List<String> integersCopy = new ArrayList<>(integers);
    System.out.println("Integers " + integersCopy);
    Collections.sort(integersCopy);
    List<String> permutations = new ArrayList<>();

    if (!integers.isEmpty()) {
      permutations.addAll(subPermutation(integersCopy));
    }

    return permutations;
  }

  private static List<String> subPermutation(List<String> integers) {
    List<String> permutations = new ArrayList<>();
    if (!integers.isEmpty()) {
      String firstItem = integers.get(0).toString();
      int length = integers.size();
      if (length > 1) {
        List<String> theRest = integers.subList(1, length);
        for (int i = 0; i < theRest.size(); i++) {
          List<String> newList = new ArrayList<>(theRest);
          newList.add(i, firstItem);
          permutations.add(CollectionUtil.concatenate(newList));
        }
      }
    }
    return permutations;
  }

}
