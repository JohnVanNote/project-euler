package com.jvn.math;

public class CountWords {

  public static final int MAX = 1000;

  public static int numSize(int num) {
    String word = IntegerToWordsFunctional.toWords(num);
    String clean = word.replaceAll("\\s", "");
    return clean.length();
  }

  public static void main(String[] args) {
    int total = 0;
    for (int i = 1; i <= MAX; i++) {
      total += numSize(i);
    }
    System.out.println(total);
  }

}
