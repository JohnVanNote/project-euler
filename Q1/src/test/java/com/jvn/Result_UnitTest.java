package com.jvn;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Result_UnitTest {

  @Test
  public void countCounterfeit_invalidNumbers_value() {
    List<String> serialNumber = Arrays.asList(
        "A201550B",
        "ABB19991000Z",
        "ABB18991000Z",
        "ABB20201000Z",
        "ABB21001000Z",
        "ABB20991000Z",
        "ABB1r991000Z",
        "XYZ200019Z",
        "ERF200220",
        "SCD203010T",
        "SCD203010t",
        "SCd203010t"
    );

    Assert.assertEquals(Result.countCounterfeit(serialNumber), 0);
  }

}
