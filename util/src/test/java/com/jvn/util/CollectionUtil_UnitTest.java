package com.jvn.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.List;
import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CollectionUtil_UnitTest {

  @DataProvider
  public Object[][] sumSets() {
    return new Object[][]{
        {ImmutableSet.of(), 0},
        {ImmutableSet.of(1), 1},
        {ImmutableSet.of(1, 2, 5), 8},
        {ImmutableSet.of(1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110), 284},
        {ImmutableSet.of(1, 2, 4, 71, 142), 220},
    };
  }

  @Test(dataProvider = "sumSets")
  public void sum_sumSets_expectedSum(Set<Integer> set, int expectedSum) {
    Assert.assertEquals(CollectionUtil.sum(set), expectedSum);
  }

  @DataProvider
  public Object[][] concatLists() {
    return new Object[][]{
        {ImmutableList.of(), ""},
        {ImmutableList.of("1"), "1"},
        {ImmutableList.of("1", "2", "5"), "125"},
        {ImmutableList.of("1", "2", "4", "5", "10", "11", "20", "22", "44", "55", "110"), "1245101120224455110"},
        {ImmutableList.of("1", "2", "4", "71", "142"), "12471142"},
    };
  }

  @Test(dataProvider = "concatLists")
  public void concatenate_concatSets_expectedSum(List<String> list, String expectedString) {
    Assert.assertEquals(CollectionUtil.concatenate(list), expectedString);
  }

  @DataProvider
  public Object[][] setItems() {
    return new Object[][]{
        {ImmutableSet.of(), ImmutableSet.of()},
        {ImmutableSet.of(10), ImmutableSet.of(20)},
        {ImmutableSet.of(10, 8), ImmutableSet.of(20, 18, 16)},
        {ImmutableSet.of(10, 8, 7), ImmutableSet.of(20, 18, 17, 16, 15, 14)}
    };
  }

  @Test(dataProvider = "setItems")
  public void sumAllSetItems_setItems_expectedSet(Set<Integer> set, Set<Integer> expectedSet) {
    Assert.assertEquals(CollectionUtil.sumAllItems(set), expectedSet);
  }

}
