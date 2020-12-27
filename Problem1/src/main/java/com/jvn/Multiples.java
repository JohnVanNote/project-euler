package com.jvn;

public class Multiples {

  private static final int UNDER = 1000;

  public static int solution(int under) {

    int total3 = 0;
    for (int i=3; i<under; i=i+3) {
      total3 +=i;
    }

    int total5 = 0;
    for (int i=5; i<under; i=i+5) {
      // Prevent double counting
      if (i % 15 != 0) {
        total5 += i;
      }
    }

    return total3 + total5;
  }

  public static void main(String[] args) {
    System.out.println(solution(UNDER));
  }

}
