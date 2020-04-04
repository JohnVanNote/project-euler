package com.jvn.math;

import com.jvn.file.CsvReader;

public class NamesScores {

  private static final String FILE_NAME = "./Problem22/src/main/resources/p022_names.txt";

  public static void main(String[] args) throws Exception {
    CsvReader reader = new CsvReader(FILE_NAME);
    System.out.println(reader.getParsedLines());
  }

}
