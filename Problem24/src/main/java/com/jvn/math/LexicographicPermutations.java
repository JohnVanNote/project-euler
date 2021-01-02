package com.jvn.math;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;

public class LexicographicPermutations {

  private static final Logger LOG = Logger.getLogger(LexicographicPermutations.class);

  static {
    //LOG.setLevel(Level.ALL);
  }

  public static List<Integer> swap(List<Integer> elements, int i, int j) {
    if (LOG.isTraceEnabled()) {
      LOG.trace(String.format("enter swap(elements=%s, i=%d, j=%d)", elements, i, j));
    }
    List<Integer> copyElements = new ArrayList<>(elements);
    Collections.swap(copyElements, i, j);

    if (LOG.isTraceEnabled()) {
      LOG.trace(String.format("exit swap(elements=%s, i=%d, j=%d) return=%s", elements, i, j, copyElements));
    }
    return copyElements;
  }

  public static List<Integer> reverse(List<Integer> elements, int i, int j) {
    if (LOG.isTraceEnabled()) {
      LOG.trace(String.format("enter reverse(elements=%s, i=%d, j=%d)", elements, i, j));
    }
    List<Integer> copyElements = new ArrayList<>(elements);
    List<Integer> subElements = copyElements.subList(i, j + 1);
    Collections.reverse(subElements);

    List<Integer> newElements = new ArrayList<>();
    newElements.addAll(copyElements.subList(0, i));
    newElements.addAll(subElements);
    newElements.addAll(copyElements.subList(j + 1, copyElements.size()));
    if (LOG.isTraceEnabled()) {
      LOG.trace(String.format("exit reverse(elements=%s, i=%d, j=%d) return=%s", elements, i, j, newElements));
    }
    return newElements;
  }

  public static List<Integer> nextPermutation(List<Integer> elements) {
    if (LOG.isTraceEnabled()) {
      LOG.trace(String.format("enter nextPermutation(elements=%s)", elements));
    }
    List<Integer> copyElements = new ArrayList<>(elements);
    List<Integer> next = new ArrayList<>();
    int lastIndex = copyElements.size() - 1;
    if (lastIndex > 0) {

      int i = lastIndex - 1;
      while (i >= 0 && !(copyElements.get(i) < copyElements.get(i + 1))) {
        i--;
      }

      if (i < 0) {
        next = reverse(copyElements, 0, lastIndex);
      } else {
        int j = lastIndex;
        while (j > i + 1 && !(copyElements.get(j) > copyElements.get(i))) {
          j--;
        }

        next = swap(copyElements, i, j);
        next = reverse(next, i + 1, lastIndex);
      }
    }
    if (LOG.isTraceEnabled()) {
      LOG.trace(String.format("enter nextPermutation(elements=%s) return=%s", elements, next));
    }
    return next;
  }

  public static void main(String[] args) {
    int number = 1000000;
    List<Integer> initialPermutation = ImmutableList.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    for (int i = 1; i < number; i++) {
      initialPermutation = nextPermutation(initialPermutation);
      System.out.println(String.format("Permutation %d is %s", i, initialPermutation));
    }
  }

}
