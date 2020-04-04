package com.jvn.file;

import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CsvReader_UnitTest {

  private CsvReader reader;

  @DataProvider
  public Object[][] contents() {
    return new Object[][]{
        {Arrays.asList("Test"), ImmutableList.of(ImmutableList.of("Test"))},
        {Arrays.asList("\"Test1\", \"Test 2\", \"Test, 3\", Test4"), ImmutableList.of(ImmutableList.of("Test1", "Test 2", "Test, 3", "Test4"))},
        {Arrays.asList("Line 1,X,Y", "Line 2, A, B"), ImmutableList.of(ImmutableList.of("Line 1", "X", "Y"), ImmutableList.of("Line 2", "A", "B"))},
    };
  }

  @Test(dataProvider = "contents")
  public void getLines_contents_lines(List<String> contents, List<List<String>> lines) {
    reader = new CsvReader(contents);
    Assert.assertEquals(reader.getParsedLines(), lines);
  }

}
