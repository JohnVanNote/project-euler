package com.jvn.fibonacci;

import java.util.ArrayList;
import java.util.List;

public class MemoizationFibonacci implements Fibonacci {

  private List<Integer> memoized = initMemoized();

  public int sequenceValue(int position) {
    if (memoized.size() <= position) {
      memoized.add(sequenceValue(position - 1) + sequenceValue(position - 2));
    }
    return memoized.get(position);
  }

  private List<Integer> initMemoized() {
    List<Integer> memoized = new ArrayList<Integer>();
    memoized.add(0);
    memoized.add(1);
    return memoized;
  }

}
