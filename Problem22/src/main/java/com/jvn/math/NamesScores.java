package com.jvn.math;

import com.jvn.file.CsvReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NamesScores {

  private static final String FILE_NAME = "./Problem22/src/main/resources/p022_names.txt";

  public static int score(String name) {
    int score = 0;
    if (name != null) {
      for (int i = 0; i < name.length(); i++) {
        score += (name.charAt(i) - 64);
      }
    }
    return score;
  }

  public static BigInteger score(List<String> names) {
    BigInteger score = BigInteger.ZERO;

    if (names != null) {
      List<String> sortedNames = new ArrayList<>(names);
      Collections.sort(sortedNames);

      for (int i = 0; i < sortedNames.size(); i++) {
        String name = sortedNames.get(i);
        score = score.add(BigInteger.valueOf((i + 1) * score(name)));
      }

    }

    return score;
  }

  public static void main(String[] args) throws Exception {
    CsvReader reader = new CsvReader(FILE_NAME);
    List<List<String>> lines = reader.getParsedLines();
    List<String> firstLine = lines.get(0);
    System.out.println(score(firstLine));
  }

}
