package com.jvn.math;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LexicographicPermutations_UnitTest {

  @DataProvider
  public Object[][] objects() {
    return new Object[][]{
        {ImmutableList.of(), ImmutableList.of(ImmutableList.of())},
        {ImmutableList.of('0'), ImmutableList.of(ImmutableList.of('0'))},
        {ImmutableList.of('0', '1'),
            ImmutableList.of(
                ImmutableList.of('0', '1'),
                ImmutableList.of('1', '0')
            )
        },
        {ImmutableList.of('0', '1', '2'),
            ImmutableList.of(
                ImmutableList.of('0', '1', '2'),
                ImmutableList.of('0', '2', '1'),
                ImmutableList.of('1', '0', '2'),
                ImmutableList.of('1', '2', '0'),
                ImmutableList.of('2', '0', '1'),
                ImmutableList.of('2', '1', '0')
            )
        }
    };
  }

  //@Test(dataProvider = "objects")
  public void getPermutations_objects_expectedSet(List<Character> objects, List<List<Character>> expectedList) {
    Assert.assertEquals(LexicographicPermutations.getPermutations(objects), expectedList);
  }

}
