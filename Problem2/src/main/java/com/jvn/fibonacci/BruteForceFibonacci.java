package com.jvn.fibonacci;

public class BruteForceFibonacci implements Fibonacci {

  public int sequenceValue(int position) {
    if (position == 0) return 0;
    if (position == 1) return 1;
    return sequenceValue(position - 1) + sequenceValue(position - 2);
  }

}
