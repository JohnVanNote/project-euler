package com.jvn.fibonacci;

public class MatrixFibonnaci_TestCase extends Fibonacci_TestCase {

  @Override
  public Fibonacci initialize() {
    return new MatrixFibonacci();
  }
}
