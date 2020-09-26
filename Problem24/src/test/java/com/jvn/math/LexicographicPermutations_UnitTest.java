package com.jvn.math;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.List;
import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LexicographicPermutations_UnitTest {

  @DataProvider
  public Object[][] objects() {
    return new Object[][]{
        {ImmutableList.of(), ImmutableSet.of()},
        {ImmutableList.of("0"), ImmutableSet.of("0")},
        {ImmutableList.of("0", "1"), ImmutableSet.of("01", "10")},
        {ImmutableList.of("0", "1", "2"), ImmutableSet.of("012", "021", "102", "120", "201", "210")}
    };
  }

  //@Test(dataProvider = "objects")
  public void getPermutations_objects_expectedSet(List<String> objects, Set<String> expectedSet) {
    Assert.assertEquals(LexicographicPermutations.getPermutations(objects), expectedSet);
  }

}
