package com.jvn.math;

public class Palindrome {

  public static long largestPalindrome(int lowerLimit, int upperLimit) {
    int largest = 0;

    for (int i=upperLimit; lowerLimit<i; i--) {
      for (int j=upperLimit; lowerLimit<j; j--) {
        int localProduct = i * j;
        if (isPalindrome(localProduct)) {
          if (localProduct > largest) {
            largest = localProduct;
          }
        }
      }
    }

    return largest;
  }

  public static boolean isPalindrome(int number) {
    boolean palindrome = true;
    String numString = Integer.toString(number);
    int frontIndex = 0;
    int lastIndex = numString.length()-1;

    while (frontIndex < lastIndex) {
      palindrome = palindrome && (numString.charAt(frontIndex) == numString.charAt(lastIndex));
      frontIndex++;
      lastIndex--;
    }
    return palindrome;
  }

  public static void main(String[] args) {
    System.out.println(largestPalindrome(100, 999));
  }

}
