package com.jvn.math;

import java.math.BigInteger;

public class Sum {


  public static void main(String[] args) {
    BigInteger sum = BigInteger.valueOf(2L).pow(1000);
    String sumStr = sum.toString();

    long total = 0L;

    for (int i = 0; i < sumStr.length(); i++) {
      Character c = sumStr.charAt(i);
      int val = Integer.parseInt(c.toString());
      total += val;
    }

    System.out.println(total);
  }

}
