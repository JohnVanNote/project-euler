package com.jvn.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LatticePaths {

  private static final Map<List<Integer>, Long> memoization = new HashMap<List<Integer>, Long>();

  public static long numRoutes(int x, int y) {

    long routes = 0;
    List<Integer> key = new ArrayList<>(2);
    key.add(x);
    key.add(y);

    if (!memoization.containsKey(key)) {
      if (x == 0 && y ==0) {
        routes++;
      }
      if (x > 0) {
        routes += numRoutes(x - 1, y);
      }
      if (y > 0) {
        routes += numRoutes(x, y - 1);
      }

      memoization.put(key, routes);
    }

    return memoization.get(key);
  }

  public static void main(String[] args) {
    System.out.println(numRoutes(20, 20));
  }

}
