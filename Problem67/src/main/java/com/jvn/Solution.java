package com.jvn;

import java.io.BufferedReader;
import java.io.FileReader;

public class Solution {

  public static void main(String[] args) throws Exception {
    String triangleFile = "./Problem67/src/main/resources/triangle.txt";
    BufferedReader reader = new BufferedReader(new FileReader(triangleFile));
    StringBuilder content = new StringBuilder();

    String line;
    while ((line = reader.readLine()) != null) {
      content.append(line);
      content.append(System.getProperty("line.separator"));
    }
    reader.close();
    String triangle = content.toString();

    System.out.println(MaximumPathSum.findMaximumPath(MaximumPathSum.convertPlainTextToTreeMatrix(triangle)));
  }

}
