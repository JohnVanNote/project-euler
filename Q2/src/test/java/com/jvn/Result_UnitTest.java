package com.jvn;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Result_UnitTest {

  @DataProvider
  public Object[][] arrs() {
    return new Object[][]{
        {Arrays.asList(13, 10, 21, 20), 1},
        {Arrays.asList(6, 3, 4, 5), 1},
        {Arrays.asList(6, 4, 3, 5), 0},
        {Arrays.asList(8, 5, 11, 4, 6), 2},
        {Arrays.asList(
            34365521,
            60190187,
            61613781,
            65998977,
            71794485,
            74709393,
            120878689,
            150840769,
            160598719,
            191005749,
            207975019,
            211248935,
            222355941,
            228779583,
            229688451,
            256001183,
            286285759,
            287856433,
            302059779,
            303017105,
            310682203,
            319548659,
            335713343,
            377480943,
            399682329,
            428958635,
            484605977,
            486827555,
            505714737,
            512324191,
            517642251,
            543344363,
            551578781,
            558464899,
            578955231,
            603693909,
            631285679,
            659532133,
            674648511,
            716573247,
            730171655,
            741509813,
            751861695,
            758068299,
            774248005,
            808681091,
            816249435,
            841552741,
            865879405,
            890807675,
            920875663,
            924651079,
            927348987,
            935376155,
            935527775,
            982577773,
            993851707,
            45235290,
            78625454,
            85108616,
            90515178,
            134284652,
            137130124,
            152759726,
            153051690,
            187115794,
            190110576,
            192721258,
            211613370,
            223814396,
            246512606,
            272440164,
            282382896,
            284164476,
            294567472,
            324327260,
            329220886,
            365913010,
            369465388,
            370711560,
            389128810,
            406576110,
            475273032,
            478872316,
            486642638,
            491924752,
            512464294,
            520019050,
            539080148,
            539519082,
            540894208,
            550933146,
            561351226,
            563402042,
            565168404,
            571160080,
            630007170,
            649933836,
            653598552,
            669179718,
            684111614,
            704868458,
            728393512,
            736266878,
            736427650,
            748349068,
            776272880,
            805085132,
            821817756,
            889465450,
            892710560,
            923626984,
            937380790,
            959718098
        ), 57}
    };
  }

  @Test(dataProvider = "arrs")
  public void moves_arr_exepected(List<Integer> arr, int expectedMoves) {
    Assert.assertEquals(Result.moves(arr), expectedMoves);

  }

}