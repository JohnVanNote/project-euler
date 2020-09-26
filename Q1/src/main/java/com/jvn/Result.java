package com.jvn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Result {

  // Namespace globals
  private static final int INVALID_SIZE = -1;
  private static final int INVALID_DENOMINATION = -1;
  private static final Set<String> VALID_DENOMINATIONS = new HashSet<>(Arrays.asList(
      "10", "20", "50", "100", "200", "500", "1000"
  ));

  /**
   * The function is expected to return an INTEGER. The function accepts STRING_ARRAY serialNumber as parameter.
   *
   * @param serialNumber list of strings containing serial numbers
   * @return the value of the transaction
   */
  public static int countCounterfeit(List<String> serialNumber) {
    int value = 0;
    if (serialNumber != null) {
      for (String number : serialNumber) {
        int size = validateSize(number);
        if (size == INVALID_SIZE) {
          continue;
        }

        // Chunk into smaller part
        String firstChunk = number.substring(0, 3);
        String secondChunk = number.substring(3, 7);
        String thirdChunk = number.substring(7, size - 1);
        String finalChunk = number.substring(size - 1);

        if (validateDistinctUpperCase(firstChunk) && validateYear(secondChunk) && validateDistinctUpperCase(finalChunk)) {
          int denomination = validateDenomination(thirdChunk);
          if (denomination != INVALID_DENOMINATION) {
            value += denomination;
          }
        }
      }
    }
    return value;
  }

  /**
   * Validate number size
   *
   * @param number the number
   * @return the size of the number if it is value, if not it returns a sentinel
   */
  private static int validateSize(String number) {
    int size = INVALID_SIZE;
    if (number != null) {
      int length = number.length();
      if (length < 13 && length > 9) {
        size = length;
      }
    }
    return size;
  }

  /**
   * Validates a string contains English, upper case, distinct characters
   *
   * @param chunk the string
   * @return true if the string is English, upper cased, and distinct
   */
  private static boolean validateDistinctUpperCase(String chunk) {
    int length = chunk.length();
    boolean isDistinctUpper = length > 0; // Validates that an empty string won't come back true
    Set<Character> memory = new HashSet<>();

    for (int i = 0; i < length; i++) {
      if (!isDistinctUpper) {
        break;
      }

      char character = chunk.charAt(i);

      boolean distinct = !memory.contains(character);
      memory.add(character);

      boolean inRange = character >= 'A' && character <= 'Z';

      isDistinctUpper = distinct && inRange;
    }
    return isDistinctUpper;
  }

  /**
   * Validates the year is between 1900-2019
   *
   * @param year the year
   * @return true, if the year is in range
   */
  private static boolean validateYear(String year) {
    int length = year.length();
    boolean isValid = length == 4;
    if (isValid) {
      char firstDigit = year.charAt(0);
      char secondDigit = year.charAt(1);
      char thirdDigit = year.charAt(2);
      char fourthDigit = year.charAt(3);

      // This should cover between 1900 and 2019
      if (firstDigit == '1') {
        isValid = secondDigit == '9'
            && (thirdDigit >= '0' && thirdDigit <= '9')
            && (fourthDigit >= '0' && fourthDigit <= '9');
      } else if (firstDigit == '2') {
        isValid = secondDigit == '0'
            && (thirdDigit >= '0' && thirdDigit <= '1')
            && (fourthDigit >= '0' && fourthDigit <= '9');
      } else {
        isValid = false;
      }

    }
    return isValid;
  }

  /**
   * Validates a denomination is in within a set
   *
   * @param denomination the denomination
   * @return the denomination value if it is within the set, if not it returns a sentinel
   */
  public static int validateDenomination(String denomination) {
    int denominationValue = INVALID_DENOMINATION;
    if (VALID_DENOMINATIONS.contains(denomination)) {
      denominationValue = Integer.parseInt(denomination);
    }
    return denominationValue;
  }

}