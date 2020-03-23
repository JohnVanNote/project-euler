package com.jvn.math;

import com.google.common.math.DoubleMath;
import java.util.ArrayList;
import java.util.List;

public class PythagoreanTriple {

  public static List<Integer> findTripleBruteForce(int max) {

    List<Integer> triple = new ArrayList<>(3);

    for (int a = 1; a < max; a++) {
      for (int b = a + 1; b < max; b++) {
        double cSquared = (int) Math.pow(a, 2) + (int) Math.pow(b, 2);
        double cDouble = Math.sqrt(cSquared);
        if (DoubleMath.isMathematicalInteger(cDouble)) {
          int c = (int) cDouble;
          if ((a + b + c) == max) {
            triple.add(a);
            triple.add(b);
            triple.add(c);
            return triple;
          }
        }
      }
    }

    return null;
  }

  public static void main(String[] args) {
    List<Integer> triple = findTripleBruteForce(1000);
    if (triple != null) {
      System.out.println(triple.get(0) * triple.get(1) * triple.get(2));
    }
  }

}
