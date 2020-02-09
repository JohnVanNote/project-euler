package com.jvn.math;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Palindrome_TestCase {

  @Test
  public void largestPalindrome_twoDigit_9009() {
    Assert.assertEquals(Palindrome.largestPalindrome(10, 99), 9009);
  }

  @DataProvider
  public Object[][] palindromes() {
    return new Object[][] {
        {9009},
        {5},
        {11},
        {676},
        {999949999}
    };
  }

  @Test(dataProvider = "palindromes")
  public void isPalidrome_palidromes_true(int number) {
    Assert.assertTrue(Palindrome.isPalindrome(number));
  }

  @DataProvider
  public Object[][] notPalindromes() {
    return new Object[][] {
        {9019},
        {52},
        {110},
        {1676},
        {99994999}
    };
  }

  @Test(dataProvider = "notPalindromes")
  public void isPalidrome_notPalidromes_false(int number) {
    Assert.assertFalse(Palindrome.isPalindrome(number));
  }

}
