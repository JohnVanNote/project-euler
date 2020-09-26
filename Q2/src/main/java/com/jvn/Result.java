package com.jvn;


import java.util.Collections;
import java.util.List;

class Result {

  /**
   * Minimum number of moves to have an integer array organized by all even then all odd numbers
   *
   * @param arr the integer array
   * @return the number of moves
   */
  public static int moves(List<Integer> arr) {
    int moves = 0;

    if (arr != null) {

      int size = arr.size();

      int i = 0;
      int j = size - 1;
      for (; i < j; i++) {
        boolean isOdd = arr.get(i) % 2 != 0;
        if (isOdd) {
          for (; j > i; j--) {
            boolean isEven = arr.get(j) % 2 == 0;
            if (isEven) {
              Collections.swap(arr, i, j);
              moves++;
              break;
            }
          }
        }
      }
    }
    return moves;
  }

}