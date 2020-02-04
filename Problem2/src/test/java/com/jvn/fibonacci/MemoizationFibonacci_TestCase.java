package com.jvn.fibonacci;

public class MemoizationFibonacci_TestCase extends Fibonacci_TestCase {

  @Override
  public Fibonacci initialize() {
    return new MemoizationFibonacci();
  }

}
