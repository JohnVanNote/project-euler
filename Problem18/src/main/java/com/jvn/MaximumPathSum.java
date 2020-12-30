package com.jvn;

import java.util.ArrayList;
import java.util.List;

public class MaximumPathSum {

  public static List<List<Integer>> convertPlainTextToTreeMatrix(String plainText) {
    List<List<Integer>> treeMatrix = new ArrayList<>();
    String[] lines = plainText.split(System.lineSeparator());
    for (String line : lines) {
      List<Integer> convertLine = new ArrayList<>();
      String[] splitLine = line.split(" ");
      for (String item : splitLine) {
        convertLine.add(Integer.parseInt(item));
      }
      treeMatrix.add(convertLine);
    }
    return treeMatrix;
  }

  // Assumes some level of correct format for matrix and may end in an NPE if not followed
  public static int findMaximumPath(List<List<Integer>> treeMatrix) {
    int max = 0;

    List<List<Integer>> treeCopy = new ArrayList<>(treeMatrix);

    int treeDepth = treeCopy.size();
    if (treeDepth > 0) {

      // roll up
      for (int i = treeDepth - 1; i > 0; i--) {
        int oneLineUp = i - 1;

        List<Integer> bottomLine = treeCopy.get(i);
        List<Integer> upperLine = treeCopy.get(oneLineUp);
        List<Integer> maxUpperLine = new ArrayList<>(); // The new upper, max values only

        for (int j = 0; j < upperLine.size(); j++) {
          if (maxUpperLine.size() <= j) {
            maxUpperLine.add(0);
          }

          int maxValue = maxUpperLine.get(j);
          int upperLineValue = upperLine.get(j);
          int bottomLineLeftValue = bottomLine.get(j);
          int bottomLineRightValue = bottomLine.get(j + 1);

          int tempLeftValue = bottomLineLeftValue + upperLineValue;
          int tempRightValue = bottomLineRightValue + upperLineValue;

          maxUpperLine.set(j, Math.max(Math.max(tempLeftValue, tempRightValue), maxValue));
        }
        treeCopy.set(oneLineUp, maxUpperLine);
      }
      max = treeCopy.get(0).get(0);
    }

    return max;
  }

  public static void main(String[] args) {
    String s = "75\n"
        + "95 64\n"
        + "17 47 82\n"
        + "18 35 87 10\n"
        + "20 04 82 47 65\n"
        + "19 01 23 75 03 34\n"
        + "88 02 77 73 07 63 67\n"
        + "99 65 04 28 06 16 70 92\n"
        + "41 41 26 56 83 40 80 70 33\n"
        + "41 48 72 33 47 32 37 16 94 29\n"
        + "53 71 44 65 25 43 91 52 97 51 14\n"
        + "70 11 33 28 77 73 17 78 39 68 17 57\n"
        + "91 71 52 38 17 14 91 43 58 50 27 29 48\n"
        + "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n"
        + "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

    System.out.println(findMaximumPath(convertPlainTextToTreeMatrix(s)));
  }

}
