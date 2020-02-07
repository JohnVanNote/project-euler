package com.jvn.fibonacci;

public class BruteForceNonRecursiveFibonacci_TestCase extends Fibonacci_TestCase {

  @Override
  public Fibonacci initialize() {
    return new BruteForceNonRecursiveFibonacci();
  }
}
