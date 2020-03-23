package com.jvn.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid {

  private List<List<Integer>> grid;
  private int minColumn = -1;
  private int maxColumn = -1;
  private int minRow = -1;
  private int maxRow = -1;

  public Grid(List<List<Integer>> grid) {
    this.setGrid(grid);
  }

  public Grid(String gridString) {
    this.setGrid(convert(gridString));
  }

  public List<List<Integer>> getGrid() {
    return grid;
  }

  public void setGrid(List<List<Integer>> grid) {
    this.grid = grid;
    if (grid != null) {
      this.setMinRow(0);
      this.setMaxRow(grid.size());
      if (!grid.isEmpty()) {
        List<Integer> gridLine = grid.get(0);
        if (gridLine != null) {
          this.setMinColumn(0);
          this.setMaxColumn(gridLine.size());
        }
      }
    }
  }

  public int getMinColumn() {
    return minColumn;
  }

  public void setMinColumn(int minColumn) {
    this.minColumn = minColumn;
  }

  public int getMaxColumn() {
    return maxColumn;
  }

  public void setMaxColumn(int maxColumn) {
    this.maxColumn = maxColumn;
  }

  public int getMinRow() {
    return minRow;
  }

  public void setMinRow(int minRow) {
    this.minRow = minRow;
  }

  public int getMaxRow() {
    return maxRow;
  }

  public void setMaxRow(int maxRow) {
    this.maxRow = maxRow;
  }

  private List<List<Integer>> convert(String gridString) {
    List<List<Integer>> grid = new ArrayList<>();
    List<String> gridLines = Arrays.asList(gridString.split(System.lineSeparator()));

    for (String gridLine : gridLines) {
      List<String> numbers = Arrays.asList(gridLine.split(" "));
      List<Integer> gridL = new ArrayList<>();
      for (String num : numbers) {
        gridL.add(Integer.parseInt(num));
      }
      grid.add(gridL);
    }

    return grid;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    for (List<Integer> line : grid) {
      builder.append(line.toString()).append(System.lineSeparator());
    }

    return builder.toString();
  }
}
