package com.jvn.math;

import com.jvn.util.CollectionUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LexicographicPermutations {

  public static Set<String> getPermutations(List<String> objects) {
    System.out.println("Objects " + objects);
    Set<String> permutations = new TreeSet<>();

    if (!objects.isEmpty()) {
      permutations.addAll(subPermutation(objects));
    }

    return permutations;
  }

  private static Set<String> subPermutation(List<String> objects) {
    Set<String> permutations = new TreeSet<>();
    if (!objects.isEmpty()) {
      String firstItem = objects.get(0);
      int length = objects.size();
      if (length > 1) {
        List<String> theRest = objects.subList(1, length);
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
