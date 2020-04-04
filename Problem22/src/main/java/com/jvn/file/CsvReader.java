package com.jvn.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

  private static final String DEFAULT_SEPARATOR = ",";
  private static final String DEFAULT_QUOTE = "\"";
  private List<String> rawLines;
  private List<List<String>> parsedLines;

  public CsvReader(String csvPath) throws IOException {
    this(Files.readAllLines(Paths.get(csvPath), StandardCharsets.UTF_8));
  }

  public CsvReader(List<String> rawLines) {
    this.setRawLines(rawLines);
  }

  public List<String> getRawLines() {
    return rawLines;
  }

  public void setRawLines(List<String> rawLines) {
    this.rawLines = rawLines;
    this.setParsedLines(rawLines);
  }

  public List<List<String>> getParsedLines() {
    return parsedLines;
  }

  public void setParsedLines(List<String> rawLines) {
    this.parsedLines = parseContent(rawLines);
  }

  private List<List<String>> parseContent(List<String> rawLines) {
    List<List<String>> parsedLines = new ArrayList<>();
    if (rawLines != null) {
      for (String rawLine : rawLines) {

        List<String> parsedLine = new ArrayList<>();
        StringBuilder value = new StringBuilder();
        boolean balanceParenthesis = true;

        for (int i = 0; i < rawLine.length(); i++) {
          String character = ((Character) rawLine.charAt(i)).toString();

          if (balanceParenthesis && DEFAULT_SEPARATOR.equals(character)) {
            parsedLine.add(value.toString().trim());
            value = new StringBuilder();
          } else if (DEFAULT_QUOTE.equals(character)) {
            balanceParenthesis = !balanceParenthesis;
          } else {
            value.append(character);
          }
        }

        parsedLine.add(value.toString().trim());
        parsedLines.add(parsedLine);

      }

    }

    return parsedLines;
  }

}
