package com.jvn.fibonacci;

public class BruteForceNonRecursiveFibonacci implements Fibonacci {

  public int sequenceValue(int position) {
    int total = 0;
    if (position == 1) total = 1;
    if (position == 2) total = 1;
    else {

      int previous1 = 1;
      int previous2 = 1;

      for (int i = 2; i < position; i++) {
        total = previous1 + previous2;
        previous2 = previous1;
        previous1 = total;
      }
    }
    return total;
  }

  public String name() {
    return "Brute Force Non-Recursive Fibonacci";
  }

}
