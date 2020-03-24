package com.jvn.math;

import java.math.BigInteger;

public class FactorialDigitSum {

  public static Long digitSum(int number) {
    long sum = 0;

    BigInteger factorial = BigInteger.ONE;
    for (int i = number; i > 0; i--) {
      factorial = factorial.multiply(BigInteger.valueOf(i));
    }

    String factorialString = factorial.toString();
    for (int i = 0; i < factorialString.length(); i++) {
      Character character = factorialString.charAt(i);
      sum += Integer.parseInt(character.toString());
    }

    return sum;
  }

  public static void main(String[] args) {
    System.out.println(digitSum(100));
  }

}
